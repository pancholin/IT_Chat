package Server.DB.Bean;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Friend") 
public class Friend {
	
private int user_id;//用户id
private int friend_group_id;//好友所在分组id
private int friend_id;//好友id
private String friend_remark;//好友备注
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public int getFriend_group_id() {
	return friend_group_id;
}
public void setFriend_group_id(int friend_group_id) {
	this.friend_group_id = friend_group_id;
}
public int getFriend_id() {
	return friend_id;
}
public void setFriend_id(int friend_id) {
	this.friend_id = friend_id;
}
public String getFriend_remark() {
	return friend_remark;
}
public void setFriend_remark(String friend_remark) {
	this.friend_remark = friend_remark;
}


}
