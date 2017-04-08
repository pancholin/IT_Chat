package Server.Project;

import java.util.List;

import com.Response;

import Server.DB.Bean.Record;
import Server.DB.Bean.RecordList;
import Server.DB.DAO.FriendDAO;
import Server.DB.DAO.RecordDAO;
import Server.Port.RecordPort;

public class RecordHandle implements RecordPort{

	@Override
	public RecordList getAllRecord(int sender_id, int receivor_id) {
		RecordDAO record_dao=new RecordDAO();
		List<Record> list=record_dao.getAllRecord(sender_id, receivor_id);
		RecordList record_list=new RecordList();
		if (list.size()!=0)		
		record_list.setList(list);;
		return record_list;
	}

	
}
