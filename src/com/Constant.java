package com;

public class Constant {
	private int chatServerPort=9999;
	private String address="";//服务器地址
	
	public  final String DB="chat1";//在MySQL中定义的数据库名字
	public  final String USER_TABLE="user";//在MySQL中定义的表
	public  final String SHARE_TABLE="share";
	public  final String FRIEND_TABLE="friend";
	public  final String MSG_TABLE="msg";
	public  final String FRIENDGROUP_TABLE="friendgroup";
	public  final String RECORD="record";
	public  final String USER_GROUP_RELATION_TABLE="user_group_relation";
	public  final String GROUPS="groups";
	
	public  final String JDBC_DRIVER="com.mysql.jdbc.Driver";//驱动器
	public  final String url="jdbc:mysql://localhost:3306/"+DB+"?useUnicode=true&characterEncoding=utf-8&useSSL=false";//地址
	//120.77.46.44
	public  final String SQL_USER_NAME="root";//MYSQL中配置的用户名
	public  final String SQL_PASSWORD="linpanxue";//MYSQL中配置的用户登录密码
	
	
	public int getChatServerPort() {
		return chatServerPort;
	}

	public void setChatServerPort(int chatServerPort) {
		this.chatServerPort = chatServerPort;
	}
	
	

}
