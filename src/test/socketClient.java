package test;

import java.io.IOException;
import java.io.*;
import java.net.Socket;

public class socketClient {
	public static void main(String []a){
	try {
		Socket socket=new Socket("120.77.46.44",9999);//�½�һ���ͻ���socket������������ϵ
		System.out.println("�ͻ���������������");
		OutputStream out;//����һ������˴�����Ϣ�Ľӿ�
		out=socket.getOutputStream();//��ȡ���������ӵĽӿ�
//	out.write("EXIT|".getBytes());//�����˴���ָ��
//		out.write("CHAT|123#123456".getBytes());//�����˴���ָ��
		out.write("ASK|123#2345".getBytes());
//		out.write("LOGIN|123#2345".getBytes());//�����˴���ָ��
		//�õ��������Ϣ
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
