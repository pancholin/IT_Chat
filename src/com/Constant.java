package com;

public class Constant {
	private int chatServerPort=9999;
	private String address="";//��������ַ
	
	public  final String DB="chat1";//��MySQL�ж�������ݿ�����
	public  final String USER_TABLE="user";//��MySQL�ж���ı�
	public  final String SHARE_TABLE="share";
	public  final String FRIEND_TABLE="friend";
	public  final String MSG_TABLE="msg";
	public  final String FRIENDGROUP_TABLE="friendgroup";
	public  final String RECORD="record";
	public  final String USER_GROUP_RELATION_TABLE="user_group_relation";
	public  final String GROUPS="groups";
	
	public  final String JDBC_DRIVER="com.mysql.jdbc.Driver";//������
	public  final String url="jdbc:mysql://localhost:3306/"+DB+"?useUnicode=true&characterEncoding=utf-8&useSSL=false";//��ַ
	//120.77.46.44
	public  final String SQL_USER_NAME="root";//MYSQL�����õ��û���
	public  final String SQL_PASSWORD="linpanxue";//MYSQL�����õ��û���¼����
	
	
	public int getChatServerPort() {
		return chatServerPort;
	}

	public void setChatServerPort(int chatServerPort) {
		this.chatServerPort = chatServerPort;
	}
	
	

}
