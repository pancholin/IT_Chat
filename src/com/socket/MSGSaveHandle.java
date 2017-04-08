package com.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.Response;

import Server.DB.Bean.Record;
import Server.DB.Bean.User;
import Server.DB.DAO.ConnDB;
import Server.DB.DAO.RecordDAO;

public class MSGSaveHandle  implements Runnable {
	private TCP socket;
	private String param;
	private InputStream input;
	private OutputStream output;

	public MSGSaveHandle(TCP clientSocket, String param) {
		this.socket=clientSocket;
		this.param=param;
		
	}
	

	public void close(){
			try {
				if(input!=null)
				input.close();
				else output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
	}


	@Override
	public void run() {
		
			String[]record=param.split("#");//登录时，传过来的格式应该是：接受者id#msg
			/*与数据库比对*/
			ConnDB con=new ConnDB();
			RecordDAO recorddao=new RecordDAO();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String send_time=df.format(new Date());
			Record record1=new Record();
			record1.setSender_id(socket.getUser_id());
			record1.setReceiver_id(Integer.valueOf(record[0]));
			record1.setMsg_content(record[1]);
			record1.setSend_time(send_time);
			Response re=recorddao.insert(record1);
			if(re.getStateCode()==200){
				String result="success|CHAT#record insert success";
				System.out.println(result);
				try {
					output=socket.getSocket().getOutputStream();
					output.write(result.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				String result="error|CHAT#"+re.getErrorMessage();
				System.out.println(result);
				try {
					output=socket.getSocket().getOutputStream();
					output.write(result.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			

		
	}

}
