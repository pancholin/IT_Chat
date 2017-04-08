package test;
import java.util.List;

import com.Response;

import Server.DB.Bean.Friend;
import Server.DB.Bean.Groups;
import Server.DB.Bean.User;
import Server.DB.DAO.ConnDB;
import Server.DB.DAO.GroupDAO;
import Server.DB.DAO.UserDAO;
import Server.Project.UserHandle;

public class testDB {
	/**
	 * @param a
	 */
	
	/**
	 * @param a
	 */
	
	/**
	 * @param a
	 */
	
	/**
	 * @param a
	 */
	public static void main(String[] a) {
	

		/*Friend friend = new Friend();
		friend.setFriend_id(52222);
		friend.setFriend_remark("sb");
		friend.setUser_id(11);
		friend.setFriend_group_id(66666);
		FriendDAO friend_dao = new FriendDAO();
		Response res = friend_dao.insert(friend);
		System.out.println(res.getStateCode());*/

		
		/*  User user=new User(); 
		  user.setName("heee");
		  user.setPwd("1234"); 
		  user.setEmail("291@qq.com"); 
		  user.setIp("192.53.34.123");
		  user.setBirthday("1996-04-19");
		  UserHandle user_handle=new UserHandle();*/
		  
		  /*User res=user_handle.getUserInformation(123);
		  System.out.print(res.getName());*/
		  
		  /*System.out.print("nihao"+res.getStateCode()+"&&&&&&");
		  System.out.print(res.getSuccessMessage());*/
		  /*Response res=user_dao.update(111123,user);
		  System.out.print("update"+res.getStateCode());*/
		
		Groups group=new Groups();
		group.setCreator_id(1111);
		//group.setGroup_id(22);
		group.setGroup_remark("Èí¼þ1°à");
		group.setHead_img("1111111");
		GroupDAO group_dao=new GroupDAO();
		/*Response res1=group_dao.deleteGroup(1111);
		System.out.print(res1);*/
		Response res2=group_dao.insertGroup(group);
		System.out.print("group"+res2.getStateCode());
		
		 
	}
}
