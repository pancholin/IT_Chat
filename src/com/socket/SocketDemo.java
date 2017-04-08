package com.socket;

import java.io.IOException;
import java.net.Socket;



public class SocketDemo extends Thread {
private TCPServer chatserver;

	@Override
	public void run(){
		try {
			setChatserver(new TCPServer(9999));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public TCPServer getChatserver() {
		return chatserver;
	}

	public void setChatserver(TCPServer chatserver) {
		this.chatserver = chatserver;
	}
	
	
}
