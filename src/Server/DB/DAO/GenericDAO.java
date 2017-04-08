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
			System.out.println("error!����ʧ��");
			re.setStateCode(400);
			re.setErrorMessage(e.toString());
			return re;
			
		}
		cdb.close();
		System.out.print("����ɹ�");
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println("error!����ʧ��");
			re.setStateCode(400);
			re.setErrorMessage(e.toString());
			return re;
		}
		cdb.close();
		System.out.print("���³ɹ�");
		return re;
	};


	/**�ڲ�������ִ��ɾ�����
	 * @param sql ɾ�����  ����˵����delete from rank where user_name="nihao";
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println("error!ɾ��ʧ��");
			re.setStateCode(400);
			re.setErrorMessage(e.toString());
			return re;
		}
		cdb.close();
		System.out.println("ɾ���ɹ�");
		return re;
	};



}
