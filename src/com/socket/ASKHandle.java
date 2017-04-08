package com.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.FriendListBean;
import com.NewFriend;
import com.Response;

import Server.DB.Bean.Record;
import Server.DB.DAO.RecordDAO;
import net.sf.json.JSONArray;

public class ASKHandle implements Runnable{
	private TCP clientSocket;
	
	public ASKHandle(TCP tcp) {
		this.clientSocket=tcp;
	}


	@Override
	public void run() {
		NewFriend addfriend=new NewFriend();
		FriendListBean friendListBean=new FriendListBean();
		friendListBean=addfriend.map.get(""+clientSocket.getUser_id());
		if(friendListBean!=null){
			System.out.println("正在处理添加好友列表。。。");
			JSONArray jsonarray=JSONArray.fromObject(friendListBean.getList());
			OutputStream output;
			try {
				output = clientSocket.getSocket().getOutputStream();
				String result="success|FRIENDLIST#";
				output.write((result+jsonarray.toString()).getBytes());
				addfriend.map.remove(""+clientSocket.getUser_id());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("处理添加好友时出错。。。");
				e.printStackTrace();
			}
			
			
		}
		else{
		List<Record>list=new ArrayList<Record>();
		RecordDAO recorddao=new RecordDAO();
		list=recorddao.getOfflineMessage(clientSocket.getUser_id());
		System.out.println("正在更新。。。。");
		Response re=recorddao.updateOfflineMessage(clientSocket.getUser_id());
		
		if(re.getStateCode()==200){
		JSONArray jsonarray=JSONArray.fromObject(list);
		System.out.println(jsonarray.toString());
		try {
			OutputStream output=clientSocket.getSocket().getOutputStream();
			String result="success|ASK#";
			output.write((result+jsonarray.toString()).getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else{
			String result="error|ASK#"+re.getErrorMessage();
			try {
				OutputStream output=clientSocket.getSocket().getOutputStream();
				output.write(result.getBytes());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		}
	}


	public TCP getClientSocket() {
		return clientSocket;
	}


	public void setClientSocket(TCP clientSocket) {
		this.clientSocket = clientSocket;
	}


}
