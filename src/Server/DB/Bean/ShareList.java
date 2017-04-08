package Server.DB.Bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ShareList")
public class ShareList {


	private List<Share>list;

	public List<Share> getList() {
		return list;
	}

	public void setList(List<Share> list) {
		this.list = list;
	}
}

