package Server.Project;

import java.util.ArrayList;
import java.util.List;

import com.Constant;
import com.Response;

import Server.DB.Bean.Friend;
import Server.DB.Bean.FriendList;
import Server.DB.Bean.Share;
import Server.DB.Bean.ShareList;
import Server.DB.Bean.User;
import Server.DB.DAO.ConnDB;
import Server.DB.DAO.FriendDAO;
import Server.DB.DAO.ShareDAO;
import Server.Port.SharePort;

public class ShareHandle implements SharePort{

	@Override
	public Response insertShare(Share share) {
		ShareDAO share_dao=new ShareDAO();
		Response re=share_dao.insert(share);
		return re;
	}

	@Override
	public ShareList getShare(int user_id) {
		ConnDB conndb=new ConnDB();
		Constant constant=new Constant();
		List<Share>list=new ArrayList<Share>();
		String sql="select * from "+constant.SHARE_TABLE+" where user_id="+user_id;
		System.out.println(sql);
		ShareList share_list=new ShareList();
		list=conndb.executeShare(sql);
		if(list.size()!=0)
		share_list.setList(list);
		
		return share_list;
	}
	
	
}
