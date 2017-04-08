package Server.DB.Bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="FriendGroup")
public class FriendGroup {
	private int user_id;   ///用户id
	private int friend_group_id;//分组id
	private String name; //分组名
	
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}

