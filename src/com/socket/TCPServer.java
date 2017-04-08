package com.socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import com.Constant;
import com.Response;

import Server.DB.DAO.UserDAO;



public class TCPServer {
	public ServerSocket serverSocket;
	public HashMap<String,TCP>clientList=new HashMap<String,TCP>();
	private int serverPort=9999;	
	private boolean isStart=false;
	private RollingThreadPool rollingThreadPool;

	//private ExecutorService loginServerPool;
	//private int poolSize;
	
	
	public TCPServer(int serverPort) throws IOException{
		this.isStart=true;
		this.serverPort=serverPort;
		while(true){
			System.out.println("try ~~");
		while(startTCPServer(serverPort)){
			this.rollingThreadPool=new RollingThreadPool();
			service();
			}	
		}
	}
	
	
	/**
	 * ����������
	 * @param  int serverPort �������˿ں�*/
	public boolean startTCPServer(int serverPort){
		Constant com=new Constant();
		if(serverPort==com.getChatServerPort()){
		try {
			serverSocket=new ServerSocket(serverPort);
			System.out.println(serverSocket.getInetAddress());
			System.out.println("�ܷ�����������������");
		} catch (IOException e) {
			System.out.println("�������˿��Ѿ���ռ��....");
			System.out.println("�ðɣ���������Щ�˿ںŶ�̫æ��~������~");
			e.printStackTrace();
			return false;	
		}
		return true;
		}
		else{
		 while(true){		
			try{
				serverSocket=new ServerSocket(serverPort);
				System.out.println("�ַ�����������������");
				break;
			} catch (IOException e) {
				serverPort++;
			}
		 }
		return true;	
		}
	};

	
	
	/**
	 * �ر��ܷ�����*/
	public void closeServer(){
		isStart=false;
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	
	
	
	/**
	 * ִ���ܷ���*/
	public void service(){
			Socket clientSocket=null;
			while(!serverSocket.isClosed()){
				try {
					clientSocket=serverSocket.accept();//���ܿͻ�������
					String IP3=clientSocket.getInetAddress().toString();
					System.out.println(IP3);
					String order=getOrder(clientSocket);//��ÿͻ���ָ��
					handleOrder(order,clientSocket);//����ͻ���ָ��
				} catch (IOException e) {
					System.out.println("��service��������ͻ�����������У�����IO�쳣");
					e.printStackTrace();
				}
			
		}
	}

	
	
	/**
	 * ��������
	 * @param order ֧�ֵ�order����ΪLOGIN,CHAT,EXIT���֣�
	 * ʹ�ø�ʽΪLOGIN|user_id#user_pwd
	 * CHAT|receiver_id#chat_content(���������в����Գ���|��#�������ַ�����ע��!������ת���������ַ�������ǰ�˽����û���������) */
	public void handleOrder(String order, Socket clientSocket) {
		System.out.println("���ڴ���ָ�ָ��Ϊ��"+order);
		String IP3=clientSocket.getInetAddress().toString();
		System.out.println(IP3);
		
	String []param=order.split("\\|");
	
	if(param[0].equals("error")){System.out.println("���������ִ�����Ϣ��ȡʧ�ܣ�����������ָ��");}
	else if(param[0].equals("ASK")){doAsk(clientSocket);}
	else if(param[0].equals("CHAT")){doChat(param[1],clientSocket);}
	else if(param[0].equals("LOGIN")){doLogin(param[1],clientSocket);}
	else if(param[0].equals("EXIT")){doExit(clientSocket);}
	else if(param[0].equals("CLOSE")){sendMSG("success|CLOSE#closing...", clientSocket); closeServer();}
	else{System.out.println("error�� invalid order!");
	sendMSG("error|ORDER# invalid order!", clientSocket);}
		
	}
	
	
	
	
	public void doAsk(Socket socket) {
		String IP=socket.getInetAddress().toString();
		if(!isLogin(IP)){//��δ��½
			String result="error|ASK#you are not login";
			sendMSG(result,socket);
		}
		else{
			clientList.get(IP).setSocket(socket);
			rollingThreadPool.getThreadPool().execute(new ASKHandle(clientList.get(IP)));
		}
			
	}


	/**��ȡָ��*/
	public String getOrder(Socket socket) {
		System.out.println("���ڻ�ȡָ�������");
		String order=null;
			InputStream socketin;
			try {
				socketin = socket.getInputStream();
				byte[]b=new byte[1024];
				int len=socketin.read(b);
				order=new String(b,0,len);		
				System.out.println("��ÿͻ��˵�ָ��Ϊ��"+order);
				return order;
			} catch (IOException e) {
				
				e.printStackTrace();
				return("error|ORDER#get order IO exception");
			}
			
		
	}
	
	
	/**�ж��Ƿ��Ѿ���¼
	 * @param IP ͨ��ip��ַ��ȷ���Ƿ��¼*/
	public boolean isLogin(String IP){
		if(clientList.get(IP)!=null)return true;
		else return false;	
	};

	

private void doExit(Socket socket) {
	String IP=socket.getInetAddress().toString();
	System.out.println("IP is:"+IP);
	if(!isLogin(IP)){//��δ��½
		String result="error|EXIT#you are not login";
		sendMSG(result,socket);
	}
	else{//�Ѿ���¼
		clientList.get(IP).setSocket(socket);
		UserDAO userdao=new UserDAO();
		System.out.println(clientList.get(IP).getUser_id());
		Response re=userdao.changeLoginState(clientList.get(IP).getUser_id(), -1);
		if(re.getStateCode()==200){
			String result="success|EXIT#exit successfully";
			sendMSG(result,socket);
			clientList.remove(IP);
		}
		else{
			String result="error|EXIT#exit failed ,server error please try exit again";
			sendMSG(result,socket);
		}
		
	}
		
	}



	/**��¼����ʵ��*/
	public void doLogin(String param, Socket socket){
		String IP=socket.getInetAddress().toString();
//		String IP=socket.getLocalAddress().toString();
		System.out.println("�ͻ��˵�IP�ǣ�~~~~~~~~~~"+IP);
		//����Ѿ���¼
		if(isLogin(IP)){
			String msg="error|LOGIN#���˺��Ѿ���¼�������ظ���¼";
			sendMSG(msg,socket);	
		}
		else{ //��û��½
			rollingThreadPool.getThreadPool().execute(new CheckLoginHandle(socket,param,clientList));
//			Thread thread=new Thread(new CheckLoginHandle(socket,param,clientList));
//			thread.start();
		}
		}
		
		
	/**����ѷ�����Ϣ��ʽΪ CHAT|receiver#msg*/
	private void doChat(String param, Socket socket) {
		String IP=socket.getInetAddress().toString();
		if(!isLogin(IP)){//��δ��½
			String result="error|you are not login";
			sendMSG(result,socket);
		}
		//gainai 
		else{//�Ѿ���¼
			clientList.get(IP).setSocket(socket);
			rollingThreadPool.getThreadPool().execute(new MSGSaveHandle(clientList.get(IP),param));
//			Thread thread=new Thread(
//					new MSGSaveHandle(clientList.get(IP),param));
//			thread.start();
			
		}
		

		
	}
	
	
	/**��ͻ��˷�����Ϣ
	 * @param msg
	 * @param socket ��Ϊ���յ��Ŀͻ���*/	
	public void sendMSG(String msg, Socket socket) {
		try {
			System.out.println(msg);
			OutputStream out=socket.getOutputStream();
			out.write(msg.getBytes());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}


	
	//setter,getter
	public int getServerPort() {
		return serverPort;
	}
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}
	public boolean isStart() {
		return isStart;
	}
	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}
}
