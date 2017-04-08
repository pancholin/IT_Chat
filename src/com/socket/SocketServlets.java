package com.socket;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class SocketServlets extends HttpServlet{
	
	public void init(ServletConfig config)throws ServletException{
		Thread socketdemo=new SocketDemo();
		socketdemo.setDaemon(true);
		socketdemo.start();
	}

}
