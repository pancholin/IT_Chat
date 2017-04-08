package Server.DB.DAO;

import java.util.List;

import com.Constant;
import com.Response;

import Server.DB.Bean.Friend;

public class FriendDAO {
	//还没处理插入失败的情况！！
	public Response insert(Friend friend){
		Constant c=new Constant();
		GenericDAO gen=new GenericDAO();
	String sql="insert into "+c.FRIEND_TABLE+" values ("+friend.getUser_id()+","+friend.getFriend_group_id()+","+friend.getFriend_id()+",'"+friend.getFriend_remark()+"')";
	System.out.println(sql);
	return gen.insert(sql);
	//考虑修改数据库，添加触发器实现两表同步！！
//	String sql2="insert into "+c.FRIENDGROUP_TABLE+" values ("+friend.getUser_id()+","+friend.getFriend_group_id()+","+friend_group_name+")";
//	gen.insert(sql2);
	}

	
	public Response delete(int user_id,int friend_id){
		Constant c=new Constant();
		GenericDAO gen=new GenericDAO();
		String sql="delete from "+c.FRIEND_TABLE+" where user_id="+user_id+" and friend_id= "+friend_id;
		return gen.delete(sql);
	}

	
	public Response update(Friend friend){
		Constant c=new Constant();
		GenericDAO gen=new GenericDAO();
		String sql="update "+c.FRIEND_TABLE+" set friend_group_id="+friend.getFriend_group_id()
		            +",friend_remark= '"+friend.getFriend_remark()+"' where user_id="+friend.getUser_id()+
					" and friend_id="+friend.getFriend_id();
		System.out.print(sql);
		return gen.update(sql);
	}
	
	
	public List<Friend> getFriend(int user_id,int friend_group_id){
		Constant constant=new Constant();
		String sql="select * from "+constant.FRIEND_TABLE+" where user_id="+user_id+" and friend_group_id="+friend_group_id;
		ConnDB con= new ConnDB();
		return con.executeFriend(sql);
	}
	
	public boolean isFriendExist(int user_id,int friend_id){
		Constant constant=new Constant();
		String sql="select * from "+constant.FRIEND_TABLE+" where user_id="+user_id+" and friend_id="+friend_id;
		ConnDB con= new ConnDB();
		List<Friend>list=con.executeFriend(sql);
		if(list.size()==0){return false;}
		else{return true;}
	}

	
}
