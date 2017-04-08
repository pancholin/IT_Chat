package Server.DB.Bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;

@XmlRootElement(name="User") 
public class User {
	private int id=0;//�û�id
	private String name; //�û���ʵ����
	private String pwd; //�û�����
	private String ip;  //�û�IP
	private int state;//�û�״̬��-1��ձ�ʾ�����ߣ�0��ʾ���ߣ��˷�����ܹ�����ϸ��ɾ����
	private String gender;//�Ա�
	private String email;//����
	private String remark;//�û���ע
	private String signature;//����ǩ��
	private String headImg;//ͷ��
	private int type;//�û����� 0-��ͨ�û���1����Ա
	private String birthday;//�û�����
	
	//return and get the id of user
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//return and get the name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//return and get the password
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	//return and get the IP
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	//return and get the state
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	//return and get gender
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	//return and get the email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//return and get the remark
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	//return and get the signature
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	//return and get the headImg
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	
	//return and get type
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	//return and get birthday
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String string) {
		this.birthday = string;
	}

}


