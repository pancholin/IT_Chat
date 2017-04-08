package test;

import java.io.IOException;
import java.io.*;
import java.net.Socket;

public class socketClient {
	public static void main(String []a){
	try {
		Socket socket=new Socket("120.77.46.44",9999);//新建一个客户端socket用于与服务端联系
		System.out.println("客户端启动。。。。");
		OutputStream out;//定义一个服务端传输信息的接口
		out=socket.getOutputStream();//获取与服务端连接的接口
//	out.write("EXIT|".getBytes());//向服务端传输指令
//		out.write("CHAT|123#123456".getBytes());//向服务端传输指令
		out.write("ASK|123#2345".getBytes());
//		out.write("LOGIN|123#2345".getBytes());//向服务端传输指令
		//得到服务端消息
		InputStream in;
		
		in=socket.getInputStream(); 
		byte[]b=new byte[1024];
		int len=in.read(b);
		if(len!=-1){
			String s=new String(b,0,len);
			System.out.println(s);
			}
		
		
		
//		in.close();
//		out.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
