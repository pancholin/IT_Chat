package Server.DB.Bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Share")
public class Share {
private int share_id;
private int user_id;
private String time;
private String img;
private String message;

public int getShare_id() {
	return share_id;
}
public void setShare_id(int share_id) {
	this.share_id = share_id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
	
	
}
