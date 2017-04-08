package com.socket;

import java.io.IOException;

public class testServer {
	public static void main(String[]a){
		try {
			TCPServer chatserver=new TCPServer(9999);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
