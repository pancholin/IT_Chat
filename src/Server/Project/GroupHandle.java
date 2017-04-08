package Server.Project;

import java.util.ArrayList;
import java.util.List;

import com.Constant;
import com.Response;

import Server.DB.Bean.Groups;
import Server.DB.Bean.GroupsList;
import Server.DB.Bean.User;
import Server.DB.DAO.ConnDB;
import Server.DB.DAO.GroupDAO;
import Server.DB.DAO.UserDAO;
import Server.Port.GroupPort;

public class GroupHandle implements GroupPort{

	@Override
	public Response CreateGroup(Groups group) {
		// TODO Auto-generated method stub
		GroupDAO group_dao=new GroupDAO();
		Response re=group_dao.insertGroup(group);
		return re;
	}

	@Override
	public Response deleteGroup(int group_id) {
		// TODO Auto-generated method stub
		GroupDAO group_dao=new GroupDAO();
		Response re=group_dao.deleteGroup(group_id);
		return re;
	}

	@Override
	public Groups getGroup(int group_id) {
		// TODO Auto-generated method stub
		ConnDB conndb=new ConnDB();
		Constant constant=new Constant();
		List<Groups>list=new ArrayList<Groups>();
		String sql="select * from "+constant.GROUPS+" where group_id ="+group_id;
		System.out.println(sql);
		list=conndb.executeGroups(sql);
		if(list.size()!=0)
		return list.get(0);
		else{
			Groups group=new Groups();
					return group;
		}
	}

	@Override
	public GroupsList getGroupList(int user_id) {
		// TODO Auto-generated method stub
		GroupDAO group_dao=new GroupDAO();
		GroupsList group_list=new GroupsList();
		List<Groups>list1=group_dao.getGroupsList(user_id);
		if(list1.size()!=0)
		group_list.setList(list1);;
		
		return group_list;
	}

	@Override
	public Response ModifyGroup(Groups group) {
		GroupDAO group_dao=new GroupDAO();
		Response re=group_dao.update(group);
		return re;
	}
	

}
