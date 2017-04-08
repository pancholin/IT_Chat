package Server.DB.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.Constant;
import com.Response;
import com.security.SQLFilter;

import Server.DB.Bean.User;

public class UserDAO {

	
	/*
	 * get user by id
	 */
	public List<User> getUser(int id) {
	ConnDB conndb=new ConnDB();
	Constant constant=new Constant();
	String sql="select * from "+constant.USER_TABLE+"where id="+id;
	List<User>list=new ArrayList<User>();
	list=conndb.executeUser(sql);
	return list;
	}

	/*
	 * change the login state when using the socket
	 */
	public Response changeLoginState(int id,int state){
		GenericDAO gen=new GenericDAO();
		Constant constant=new Constant();
		String sql="UPDATE `"+constant.DB+"`.`"+constant.USER_TABLE+"` SET `state`="+state+" WHERE `id`="+id;
		return gen.update(sql);
	}
	
	/*
	 * insert into the user and get the id
	 */
	public Response insert(User user ){
		Constant c=new Constant();
		GenericDAO gen=new GenericDAO();	
		SQLFilter sql_filter=new SQLFilter();
		user.setName(sql_filter.nameFilter(user.getName()));
	String sql="insert into "+c.USER_TABLE+" (name,pwd,ip,state,email,gender,headImg,remark,birthday,signature)"
		+ "values('"+user.getName()+"','"+user.getPwd()+"','"+user.getIp()+"',"+user.getState()+",'"+user.getEmail()+"','"
		+user.getGender()+"','"+user.getHeadImg()+"','"+user.getRemark()+"','"+user.getBirthday()+"','"+user.getSignature()+"')";

	return gen.insert(sql);
	}

	

	
	/*
	 * delete the user and get the response
	 */
	public Response delete(int user_id){
		Constant c=new Constant();
		GenericDAO gen=new GenericDAO();
		String sql="delete from "+c.USER_TABLE+" where user_id="+user_id;
		return gen.delete(sql);
	}

	
	/*
	 * update the information of user and get the response
	 */
	public Response update(User user){
		Constant c=new Constant();
		GenericDAO gen=new GenericDAO();
		String sql="update "+c.USER_TABLE+" set name='"+user.getName()+"', pwd='"+user.getPwd()+"',ip='"+user.getIp()
					+"',state="+user.getState()+",gender ='"+user.getGender() +"',email='"+user.getEmail()+"',remark ='"+user.getRemark()
					+"',signature ='"+user.getSignature()+"',headImg = '"+user.getHeadImg()+"',birthday = '"+user.getBirthday()+"' where id="+user.getId();
		return gen.update(sql);
	}
	
}
