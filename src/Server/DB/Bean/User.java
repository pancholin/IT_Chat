package Server.DB.Bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;

@XmlRootElement(name="User") 
public class User {
	private int id=0;//用户id
	private String name; //用户真实名字
	private String pwd; //用户密码
	private String ip;  //用户IP
	private int state;//用户状态，-1或空表示不在线，0表示在线（此分类可能过于详细待删减）
	private String gender;//性别
	private String email;//邮箱
	private String remark;//用户备注
	private String signature;//个性签名
	private String headImg;//头像
	private int type;//用户类型 0-普通用户，1管理员
	private String birthday;//用户生日
	
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


