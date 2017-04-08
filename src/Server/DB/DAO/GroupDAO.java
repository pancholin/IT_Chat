package Server.DB.DAO;

import java.util.List;

import com.Constant;
import com.Response;

import Server.DB.Bean.Friend;
import Server.DB.Bean.Groups;
import Server.DB.Bean.GroupsList;

public class GroupDAO {

	//向群组关系表中插入新的一项
	public Response insertGroup(Groups group){
		Constant c=new Constant();
		GenericDAO gen=new GenericDAO();
	String sql="insert into "+c.GROUPS+"(creator_id,head_img,group_remark) "
			+ "values("+group.getCreator_id()+",'"+group.getHead_img()+"','"+group.getGroup_remark()+"')";
	System.out.println(sql);
	return gen.insert(sql);
	}

	
	//删除群组
	public Response deleteGroup(int group_id){
		Constant c=new Constant();
		GenericDAO gen=new GenericDAO();
		String sql="delete from "+c.GROUPS+" where group_id= "+group_id;
		return gen.delete(sql);
	}
	
	public List<Groups> getGroupsList(int creator_id){
		Constant constant=new Constant();
		String sql="select * from "+constant.GROUPS+" where creator_id="+creator_id;
		ConnDB con=new ConnDB();
		return con.executeGroups(sql);
		
	}


	public Response update(Groups group) {
		Constant c=new Constant();
		GenericDAO gen=new GenericDAO();
		String sql="update "+c.GROUPS+" set head_img='"+group.getHead_img()+"', group_remark='"+group.getGroup_remark()+"' where creator_id= "+group.getCreator_id()
		            +" and group_id="+group.getGroup_id();
		return gen.update(sql);
		}
	
}
	