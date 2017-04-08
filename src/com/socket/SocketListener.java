package com.socket;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SocketListener implements ServletContextListener {

	 private SocketDemo socketThread;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		 if (socketThread != null && socketThread.isInterrupted())
	        {
	            socketThread.getChatserver().closeServer();
	            socketThread.interrupt();
	        }
	}

	@Override
	public void contextInitialized(ServletContextEvent e) {
		 ServletContext servletContext = e.getServletContext();
	        System.out.println("Server contextInitialized over");
	        if (socketThread == null)
	        {
	            socketThread = new SocketDemo();
	            socketThread.start(); 
	        }
	}

}
