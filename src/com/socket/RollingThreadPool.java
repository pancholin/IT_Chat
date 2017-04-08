package com.socket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RollingThreadPool {
	private ExecutorService threadPool;
	private int PoolSize;
	public RollingThreadPool(){
		this.PoolSize=Runtime.getRuntime().availableProcessors()*PoolSize;
		setThreadPool(Executors.newFixedThreadPool(5));
	}
	public ExecutorService getThreadPool() {
		return threadPool;
	}
	public void setThreadPool(ExecutorService threadPool) {
		this.threadPool = threadPool;
	} 
}
