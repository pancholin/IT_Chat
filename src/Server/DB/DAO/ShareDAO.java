package Server.DB.DAO;

import java.util.List;

import com.Constant;
import com.Response;

import Server.DB.Bean.Friend;
import Server.DB.Bean.Share;

public class ShareDAO {
	public Response insert(Share share){
	Constant c=new Constant();
    GenericDAO gen=new GenericDAO();
	String sql="insert into "+c.SHARE_TABLE+" (user_id,time,img,message) "+" values ("
			+share.getUser_id()+",'"+share.getTime()+"','"+share.getImg()+"','"+share.getMessage()+"')";
	System.out.println(sql);
	return gen.insert(sql);
	}

	public List<Share> getShare(int user_id){
		Constant constant=new Constant();
		String sql="select * from "+constant.SHARE_TABLE+" where user_id="+user_id+" limit 20";	
		ConnDB con= new ConnDB();
		return con.executeShare(sql);
	}
	

	
	
	
}
