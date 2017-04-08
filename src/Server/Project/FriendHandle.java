


package Server.Project;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.Constant;
import com.FriendListBean;
import com.NewFriend;
import com.Response;
import com.userID;

import Server.DB.Bean.Friend;
import Server.DB.Bean.FriendGroup;
import Server.DB.Bean.FriendGroupList;
import Server.DB.Bean.FriendList;
import Server.DB.Bean.User;
import Server.DB.DAO.ConnDB;
import Server.DB.DAO.FriendDAO;
import Server.Port.FriendPort;

public class FriendHandle implements FriendPort{
	
	User user=new User();
	

	/**add friend into server
	 * */
	@Override
	public Response addFriend(Friend friend){
		//check the id is exist
		FriendDAO friendDao=new FriendDAO();
		Response re=friendDao.insert(friend);
		NewFriend newfriend=new NewFriend();
		String key=""+friend.getFriend_id();
		if(!friendDao.isFriendExist(friend.getFriend_id(),friend.getUser_id())){
		if(newfriend.map.get(key)!=null)
		{
			FriendListBean friendlist=newfriend.map.get(key);
			List<userID>useridList=friendlist.getList();
			userID userid=new userID();
			userid.setId(friend.getUser_id());
			useridList.add(userid);
			friendlist.setList(useridList);
			newfriend.map.put(key, friendlist);
		}
		else{
			
			FriendListBean friendlist=new FriendListBean();
			List<userID>useridList=friendlist.getList();
			userID userid=new userID();
			userid.setId(friend.getUser_id());
			useridList.add(userid);
			friendlist.setList(useridList);
			newfriend.map.put(""+friend.getFriend_id(), friendlist);
			
		}
		}
		
		return re;
		
	}
	
	
	
	@Override
	public FriendList getFriendByUserId(int user_id) {
		ConnDB conndb=new ConnDB();
		Constant constant=new Constant();
		List<Friend>list=new ArrayList<Friend>();
		String sql="select * from "+constant.FRIEND_TABLE+" where user_id="+user_id;
		System.out.println(sql);
		FriendList friend_list=new FriendList();
		list=conndb.executeFriend(sql);
		if(list.size()!=0)
		friend_list.setList(list);
		
		return friend_list;
}


	
	
	
	@Override
	public Response modifiedFriend(Friend friend) {
		FriendDAO friendDao=new FriendDAO();
		Response re=friendDao.update(friend);
		return re;
	}



	@Override
	public Response deleteFriend(int user_id,int friend_id) {
		FriendDAO friendDao=new FriendDAO();
		Response re=friendDao.delete(user_id,friend_id);
		return re;
	}
	
	
	

	
}
