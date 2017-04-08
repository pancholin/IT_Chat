package Server.DB.Bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="GroupsList")
public class GroupsList {

	private List<Groups> list;
	
	public List<Groups> getList() {
		return list;
	}

	public void setList(List<Groups> list) {
		this.list = list;
	}
}
