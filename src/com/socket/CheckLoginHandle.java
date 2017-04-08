package com.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

import com.Response;

import Server.DB.Bean.User;
import Server.DB.DAO.ConnDB;
import Server.DB.DAO.UserDAO;

public class CheckLoginHandle implements Runnable {

	private Socket socket;
	private String param;
	private InputStream input;
	private OutputStream output;
	private HashMap<String,TCP>clientList;
	public CheckLoginHandle(Socket clientSocket, String param, HashMap<String, TCP> clientList) {
		this.socket=clientSocket;
		this.param=param;
		this.clientList=clientList;
		
	}
	
	public void close(){
			try {
				if(input!=null)
				input.close();
				else output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	
	
	@Override
	public void run() {
		
		try {
			String[]userValid=param.split("#");//登录时，传过来的格式应该是：用户id#密码
			/*与数据库比对*/
			ConnDB con=new ConnDB();
			if(userValid[0]==null|userValid[1]==null){
				output=socket.getOutputStream();
				String result="error|LOGIN#用户名密码不能为空，或指令有误，指令参考格式:userid#pwd";
				System.out.println(result);
				output.write(result.getBytes());	
				close();
				socket.close();
			}
			else{
			List<User>user=con.executeUser("select* from user where id="+userValid[0]);
			if(user.isEmpty()){//还没注册
				output=socket.getOutputStream();
				String result="error|LOGIN#该用户尚未注册";
				System.out.println(result);
				output.write(result.getBytes());	
				close();
				socket.close();
			}
			else if(!(user.get(0).getPwd()).equals(userValid[1])){//用户名或密码错误
				output=socket.getOutputStream();
				String result="error|LOGIN#用户名或密码错误";
				System.out.println(result);
				output.write(result.getBytes());	
				close();
				socket.close();
			}
			else{
				System.out.println("验证成功");
					TCP clientTCP=new TCP();
					String IP=socket.getInetAddress().toString();
					
					clientTCP.setSocket(socket);
					clientTCP.setUser_id(Integer.valueOf(userValid[0]));
					UserDAO userdao=new UserDAO();
					System.out.println("user_id==?"+userValid[0]);
					Response re=userdao.changeLoginState(Integer.valueOf(userValid[0]),0);
					if(re.getStateCode()==200){
						clientList.put(IP,clientTCP);
						String msg="success|LOGIN#login success";
						sendMSG(msg,socket);	
					}
					else{
						String msg="error|LOGIN#server error,please try again";
						sendMSG(msg,socket);
						
					}
				
			}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("checkLoginHandle 的IO异常。。。");
			String result="error|LOGIN#"+e.toString();
			try {
				output.write(result.getBytes());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		

	}

	
	public String getParam() {
		return param;
	}
	

	
	public void setParam(String param) {
		this.param = param;
	}
	
	
	
	/**向客户端传递数据
	 * @param String msg,传递消息
	 * @param Socket socket 对应客户端的socket接口*/
	public void sendMSG(String msg, Socket socket) {
		try {
			OutputStream out=socket.getOutputStream();
			out.write(msg.getBytes());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
