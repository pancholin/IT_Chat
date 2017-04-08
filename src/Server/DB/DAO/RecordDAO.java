package Server.DB.DAO;

import java.util.List;

import com.Constant;
import com.Response;
import com.security.SQLFilter;

import Server.DB.Bean.Record;


public class RecordDAO {
	public Response insert(Record record){
		Constant constant=new Constant();
		GenericDAO gen=new GenericDAO();
		
		SQLFilter sql_filter=new SQLFilter();
		record.setMsg_content(sql_filter.chatFilter(record.getMsg_content()));
		String sql="INSERT INTO `"+constant.DB+"`.`"+constant.RECORD+"` (`sender_id`, `receivor_id`, `msg_content`, `send_time`) VALUES ("+
		record.getSender_id()+","+record.getReceiver_id()+",'"+record.getMsg_content()+"','"+record.getSend_time()+"')";
		System.out.println(sql);
		return (gen.insert(sql));
	}
	
	public List<Record>getOfflineMessage(int receivor_id){
		ConnDB con=new ConnDB();
		Constant constant=new Constant();
		String sql="select * from "+constant.RECORD+" where  receivor_id="+receivor_id+" and state= 0";
		System.out.println(sql);
		List<Record>list=con.executeRecord(sql);
		return list;
	}
	
	public Response updateOfflineMessage(int receivor_id){
		GenericDAO gen=new GenericDAO();
		String sql="UPDATE `chat1`.`record` SET `state`='1' WHERE `receivor_id`="+receivor_id+" and state=0";
		return gen.update(sql);
	}
	
	public List<Record> getAllRecord(int sender_id,int receivor_id)
	{
		ConnDB con=new ConnDB();
		Constant constant=new Constant();
		String sql="select * from "+constant.RECORD+" where  receivor_id="+receivor_id+" and sender_id="+sender_id;
		System.out.println(sql);
		List<Record>list=con.executeRecord(sql);
		return list;
	}

}
