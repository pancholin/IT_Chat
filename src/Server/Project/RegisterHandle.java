package Server.Project;

import java.util.ArrayList;
import java.util.List;

import com.Constant;
import com.Response;

import Server.DB.Bean.User;
import Server.DB.DAO.ConnDB;
import Server.DB.DAO.UserDAO;
import Server.Port.RegisterPort;
import net.sf.json.JSONArray;

public class RegisterHandle implements RegisterPort{

	@Override
	public Response register(User user) {
		UserDAO UserDao=new UserDAO();
		Constant con=new Constant();
		Response re=UserDao.insert(user);
		ConnDB db=new ConnDB();
		/*List <User> user1=db.executeUser("select * from " +con.USER_TABLE+" where ip= '"+user.getIp()+"'");
		user.setId(user1.get(0).getId());
		System.out.print(user.getId());
		System.out.print("haha");
		re.setSuccessMessage(user.getId());*/
		return re;
	}
	

}
