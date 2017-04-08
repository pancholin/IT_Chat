package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Response;

import Server.DB.Bean.Friend;
import Server.DB.DAO.FriendDAO;
import Server.DB.DAO.UserDAO;

public class test1 {
	public static void main(String[]a){
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(df.format(new Date()));
//		String s="1234";
//		System.out.println(Integer.valueOf(s));
		FriendDAO f=new FriendDAO();
		Response re=f.delete(12, 545);
		System.out.println(re.getStateCode());
//		List<Friend>list=new ArrayList<Friend>();
//		list=f.getFriend(12, 43);
//		System.out.println(list.get(0).getFriend_id());
	}

}
