package Server.DB.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.Constant;

import Server.DB.Bean.*;



public class ConnDB {
	Connection Con=null;
	Statement st=null;
	ResultSet rs=null;
	
	/**获取连接
	 * @return COnnection*/
	public Connection getCon(){
		Constant constant=new Constant();
		try {
			try {
				Class.forName(constant.JDBC_DRIVER);
				Con=DriverManager.getConnection(constant.url,constant.SQL_USER_NAME,constant.SQL_PASSWORD);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				return null;
			}
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
		
		return Con;
	}
	
	/**执行sql语句
	 * @return List<User>*/
	public List<User>executeUser(String sql){
		List<User>list=new ArrayList<User>();
		Connection con=getCon();
		if(con!=null){
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				User user=new User();
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPwd(rs.getString(3));
				user.setIp(rs.getString(4));
				user.setState(rs.getInt(5));
				user.setGender(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setRemark(rs.getString(8));
				user.setSignature(rs.getString(9));
				user.setHeadImg(rs.getString(10));
				user.setType(rs.getInt(11));
				user.setBirthday(rs.getString(12));
				list.add(user);
			};
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
		
		}
		else{
			return null;
		}	
	};
	
	/**执行sql语句
	 * @return List<MSG>*/

//	public List<MSG>executeMSG(String sql){
//		List<MSG>list=new ArrayList<MSG>();
//		Connection con=getCon();
//		try {
//			st=con.createStatement();
//			rs=st.executeQuery(sql);
//			while(rs.next()){
//				MSG msg=new MSG();
//				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
//				msg.setMsg_id(rs.getInt(1));
//				msg.setSender(rs.getInt(2));
//				msg.setReceiver(rs.getInt(3));
//				msg.setSendtime(rs.getString(4));
//				msg.setRemark(rs.getString(5));
//				msg.setMsgType(rs.getInt(6));
//				list.add(msg);
//			};
//		} catch (SQLException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		return list;
//		
//	};
//	
	/**执行sql语句
	 * @return List<Friendgroup>*/
	public List<FriendGroup>executeFriendship(String sql){
		List<FriendGroup>list=new ArrayList<FriendGroup>();
		Connection con=getCon();
		if(con==null){return null;}
		else{
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				FriendGroup fs=new FriendGroup();
				//System.out.println(rs.getString(1)+" "+rs.getString(2));
				fs.setFriend_group_id(rs.getInt(2));
				fs.setUser_id(rs.getInt(1));
				fs.setName(rs.getString(3));
				list.add(fs);
			};
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
		}	
	};
	
	/**执行sql语句
	 * @return List<Friend>*/
	public List<Friend>executeFriend(String sql){
		List<Friend>list=new ArrayList<Friend>();
		
		Connection con=getCon();
		
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				Friend fs=new Friend();
				//System.out.println(rs.getString(1)+" "+rs.getString(2));
				fs.setFriend_group_id(rs.getInt(2));
				fs.setUser_id(rs.getInt(1));
				fs.setFriend_id(rs.getInt(3));
				fs.setFriend_remark(rs.getString(4));
				list.add(fs);
			};
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
		
	};
	
	
	/**执行sql语句
	 * @return List<Record>*/
	public List<Record>executeRecord(String sql){
		List<Record>list=new ArrayList<Record>();
		Connection con=getCon();
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				Record fs=new Record();
				//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
				fs.setRecord_id(rs.getInt(1));
				fs.setSender_id(rs.getInt(2));
				fs.setReceiver_id(rs.getInt(3));
				fs.setMsg_content(rs.getString(4));
				fs.setSend_time(rs.getString(5));
				fs.setState(rs.getInt(6));
				list.add(fs);
			};
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
		
	};
	
	
	/**执行sql语句
	 * @return List<Groups>*/
	public List<Groups>executeGroups(String sql){
		List<Groups>list=new ArrayList<Groups>();
		Connection con=getCon();
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				Groups fs=new Groups();
				//System.out.println(rs.getString(1)+" "+rs.getString(2));
				fs.setCreator_id(rs.getInt(1));
				fs.setGroup_id(rs.getInt(2));
				fs.setHead_img(rs.getString(3));
				list.add(fs);
			};
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
		
	};
	
	
	/**执行sql语句
	 * @return List<User_group_relation>*/
	public List<UserGroupRelation>executeUser_group_relation(String sql){
		List<UserGroupRelation>list=new ArrayList<UserGroupRelation>();
		Connection con=getCon();
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				UserGroupRelation fs=new UserGroupRelation();
				//System.out.println(rs.getString(1)+" "+rs.getString(2));
				fs.setGroup_id(rs.getInt(2));;
				fs.setUser_id(rs.getInt(1));
				list.add(fs);
			};
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
		
	};
	
	/**执行sql语句
	 * @return List<Share>*/
	public List<Share>executeShare(String sql){
		List<Share>list=new ArrayList<Share>();
		Connection con=getCon();
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				Share fs=new Share();
				fs.setShare_id(rs.getInt(1));;
				fs.setUser_id(rs.getInt(2));
				fs.setTime(rs.getString(3));
				fs.setImg(rs.getString(4));
				fs.setMessage(rs.getString(5));
				list.add(fs);
			};
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
		
	};
	
	
	/**关闭所有连接*/
	/**将连接全部关闭*/
	public void close(){
		
			try {
				if(rs!=null)rs.close();
				if(st!=null)st.close();
				if(Con!=null)Con.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}

	

}

