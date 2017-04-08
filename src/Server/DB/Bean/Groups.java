package Server.DB.Bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Groups")
public class Groups {
	private int creator_id; //群主id
	private int group_id;   //群组id
    private String head_img;  //群组头像
    private String group_remark;
    
    
	public String getGroup_remark() {
		return group_remark;
	}
	public void setGroup_remark(String group_remark) {
		this.group_remark = group_remark;
	}
	public int getCreator_id() {
		return creator_id;
	}
	public void setCreator_id(int creator_id) {
		this.creator_id = creator_id;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public String getHead_img() {
		return head_img;
	}
	public void setHead_img(String head_img) {
		this.head_img = head_img;
	}
	
    
    
}
