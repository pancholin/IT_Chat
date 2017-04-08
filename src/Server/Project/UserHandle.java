
package Server.Project;

import java.util.ArrayList;
import java.util.List;

import com.Constant;
import com.Response;

import Server.DB.Bean.User;
import Server.DB.DAO.ConnDB;
import Server.DB.DAO.UserDAO;
import Server.Port.UserPort;
import net.sf.json.JSONArray;

public class UserHandle implements UserPort{

	
	@Override
	public Response modifiedUser(User user) {
		UserDAO UserDao=new UserDAO();
		Response re=UserDao.update(user);
		return re;
	}

	@Override
	public User getUserInformation(int user_id) {
		ConnDB conndb=new ConnDB();
		Constant constant=new Constant();
		List<User>list=new ArrayList<User>();
	
		String sql="select * from "+constant.USER_TABLE+" where id="+user_id;
		System.out.println(sql);
		list=conndb.executeUser(sql);
		JSONArray j=JSONArray.fromObject(list);
		System.out.println(j.toString());
		//!!!如果没有对应的friend——id??
		
		if(list.size()!=0){
			return list.get(0);
		}
		else{
			User user=new User();
			return user;
		}
	
	}


	
}

