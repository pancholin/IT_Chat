package Server.DB.Bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import Server.DB.DAO.ConnDB;

@XmlRootElement(name="FriendGroupList")
public class FriendGroupList {
	private List<FriendGroup>list;
	public FriendGroupList(User user){
		String sql="select * from friendgroup where user_id="+user.getId();
		ConnDB con=new ConnDB();
		this.list=con.executeFriendship(sql);
	}

	public List<FriendGroup> getList() {
		return list;
	}

	public void setList(List<FriendGroup> list) {
		this.list = list;
	}

}
