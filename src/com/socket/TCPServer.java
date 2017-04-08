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
	 * 开启服务器
	 * @param  int serverPort 服务器端口号*/
	public boolean startTCPServer(int serverPort){
		Constant com=new Constant();
		if(serverPort==com.getChatServerPort()){
		try {
			serverSocket=new ServerSocket(serverPort);
			System.out.println(serverSocket.getInetAddress());
			System.out.println("总服务器启动。。。。");
		} catch (IOException e) {
			System.out.println("服务器端口已经被占用....");
			System.out.println("好吧，，，，那些端口号都太忙了~认命吧~");
			e.printStackTrace();
			return false;	
		}
		return true;
		}
		else{
		 while(true){		
			try{
				serverSocket=new ServerSocket(serverPort);
				System.out.println("分服务器启动。。。。");
				break;
			} catch (IOException e) {
				serverPort++;
			}
		 }
		return true;	
		}
	};

	
	
	/**
	 * 关闭总服务器*/
	public void closeServer(){
		isStart=false;
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	
	
	
	/**
	 * 执行总服务*/
	public void service(){
			Socket clientSocket=null;
			while(!serverSocket.isClosed()){
				try {
					clientSocket=serverSocket.accept();//接受客户端请求
					String IP3=clientSocket.getInetAddress().toString();
					System.out.println(IP3);
					String order=getOrder(clientSocket);//获得客户端指令
					handleOrder(order,clientSocket);//处理客户端指令
				} catch (IOException e) {
					System.out.println("在service函数处理客户端请求过程中，出现IO异常");
					e.printStackTrace();
				}
			
		}
	}

	
	
	/**
	 * 处理命令
	 * @param order 支持的order类型为LOGIN,CHAT,EXIT三种，
	 * 使用格式为LOGIN|user_id#user_pwd
	 * CHAT|receiver_id#chat_content(聊天内容中不可以出现|或#这两种字符，请注意!若有请转换成其他字符，或在前端进行用户输入限制) */
	public void handleOrder(String order, Socket clientSocket) {
		System.out.println("正在处理指令，指令为："+order);
		String IP3=clientSocket.getInetAddress().toString();
		System.out.println(IP3);
		
	String []param=order.split("\\|");
	
	if(param[0].equals("error")){System.out.println("服务器出现错误，信息读取失败，请重新输入指令");}
	else if(param[0].equals("ASK")){doAsk(clientSocket);}
	else if(param[0].equals("CHAT")){doChat(param[1],clientSocket);}
	else if(param[0].equals("LOGIN")){doLogin(param[1],clientSocket);}
	else if(param[0].equals("EXIT")){doExit(clientSocket);}
	else if(param[0].equals("CLOSE")){sendMSG("success|CLOSE#closing...", clientSocket); closeServer();}
	else{System.out.println("error！ invalid order!");
	sendMSG("error|ORDER# invalid order!", clientSocket);}
		
	}
	
	
	
	
	public void doAsk(Socket socket) {
		String IP=socket.getInetAddress().toString();
		if(!isLogin(IP)){//还未登陆
			String result="error|ASK#you are not login";
			sendMSG(result,socket);
		}
		else{
			clientList.get(IP).setSocket(socket);
			rollingThreadPool.getThreadPool().execute(new ASKHandle(clientList.get(IP)));
		}
			
	}


	/**获取指令*/
	public String getOrder(Socket socket) {
		System.out.println("正在获取指令。。。。");
		String order=null;
			InputStream socketin;
			try {
				socketin = socket.getInputStream();
				byte[]b=new byte[1024];
				int len=socketin.read(b);
				order=new String(b,0,len);		
				System.out.println("获得客户端的指令为："+order);
				return order;
			} catch (IOException e) {
				
				e.printStackTrace();
				return("error|ORDER#get order IO exception");
			}
			
		
	}
	
	
	/**判断是否已经登录
	 * @param IP 通过ip地址来确定是否登录*/
	public boolean isLogin(String IP){
		if(clientList.get(IP)!=null)return true;
		else return false;	
	};

	

private void doExit(Socket socket) {
	String IP=socket.getInetAddress().toString();
	System.out.println("IP is:"+IP);
	if(!isLogin(IP)){//还未登陆
		String result="error|EXIT#you are not login";
		sendMSG(result,socket);
	}
	else{//已经登录
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



	/**登录函数实现*/
	public void doLogin(String param, Socket socket){
		String IP=socket.getInetAddress().toString();
//		String IP=socket.getLocalAddress().toString();
		System.out.println("客户端的IP是：~~~~~~~~~~"+IP);
		//如果已经登录
		if(isLogin(IP)){
			String msg="error|LOGIN#此账号已经登录，不能重复登录";
			sendMSG(msg,socket);	
		}
		else{ //还没登陆
			rollingThreadPool.getThreadPool().execute(new CheckLoginHandle(socket,param,clientList));
//			Thread thread=new Thread(new CheckLoginHandle(socket,param,clientList));
//			thread.start();
		}
		}
		
		
	/**向好友发送消息格式为 CHAT|receiver#msg*/
	private void doChat(String param, Socket socket) {
		String IP=socket.getInetAddress().toString();
		if(!isLogin(IP)){//还未登陆
			String result="error|you are not login";
			sendMSG(result,socket);
		}
		//gainai 
		else{//已经登录
			clientList.get(IP).setSocket(socket);
			rollingThreadPool.getThreadPool().execute(new MSGSaveHandle(clientList.get(IP),param));
//			Thread thread=new Thread(
//					new MSGSaveHandle(clientList.get(IP),param));
//			thread.start();
			
		}
		

		
	}
	
	
	/**向客户端发送信息
	 * @param msg
	 * @param socket 此为接收到的客户端*/	
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
