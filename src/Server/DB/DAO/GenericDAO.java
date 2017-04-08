package Server.DB.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.Response;
import java.sql.ResultSet;

public class GenericDAO {
	
	
	public Response insert(String sql){
		Response re=new Response();
		ConnDB cdb=new ConnDB();
		Connection con=cdb.getCon();
		try {
			Statement st=con.createStatement();
			st.execute(sql);
			re.setStateCode(200);
			ResultSet rs=st.executeQuery("SELECT LAST_INSERT_ID()");
			while(rs.next()){
				re.setSuccessMessage(rs.getInt(1));
			};
			
			re.setErrorMessage(null);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error!插入失败");
			re.setStateCode(400);
			re.setErrorMessage(e.toString());
			return re;
			
		}
		cdb.close();
		System.out.print("插入成功");
		return re;
	};
	
	
	public Response update(String sql){
		Response re=new Response();
		ConnDB cdb=new ConnDB();
		Connection con=cdb.getCon();
		if(con==null){re.setStateCode(401);re.setErrorMessage("dateBase not connection");}
		try {
			Statement st=con.createStatement();
			st.execute(sql);
			re.setStateCode(200);
			re.setErrorMessage(null);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("error!更新失败");
			re.setStateCode(400);
			re.setErrorMessage(e.toString());
			return re;
		}
		cdb.close();
		System.out.print("更新成功");
		return re;
	};


	/**内部函数，执行删除语句
	 * @param sql 删除语句  举例说明：delete from rank where user_name="nihao";
	 * @return List<Score>
	 * */
	public Response delete(String sql){
		
		Response re=new Response();
		ConnDB cdb=new ConnDB();
		Connection con=cdb.getCon();
		
		
		try {
			Statement st=con.createStatement();
			st.execute(sql);
			re.setStateCode(200);
			re.setErrorMessage(null);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("error!删除失败");
			re.setStateCode(400);
			re.setErrorMessage(e.toString());
			return re;
		}
		cdb.close();
		System.out.println("删除成功");
		return re;
	};



}
