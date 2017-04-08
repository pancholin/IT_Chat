package Server.DB.Bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RecordList")
public class RecordList {

	
	private List<Record>list;

	public List<Record> getList() {
		return list;
	}

	public void setList(List<Record> list) {
		this.list = list;
	}

	
	
}
