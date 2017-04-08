package Server.DB.Bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


import Server.DB.DAO.FriendDAO;

@XmlRootElement(name="FriendList")
public class FriendList {
	private List<Friend>list;

	public List<Friend> getList() {
		return list;
	}

	public void setList(List<Friend> list) {
		this.list = list;
	}
	
		
	

}
