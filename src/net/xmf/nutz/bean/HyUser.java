package net.xmf.nutz.bean;


import java.util.List;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.Table;

@Table("hy_user")
public class HyUser {
	
	public static final String SESSION_NAME = "user";

	@Id
	private long id;
	
	private String loginName;
	
	private String realName;
	
	private String password;
	
	private String birtyday;
	
	@Many(target=UploadImage.class, field = "userId")
	private List<UploadImage> uploadImage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirtyday() {
		return birtyday;
	}

	public void setBirtyday(String birtyday) {
		this.birtyday = birtyday;
	}

	public List<UploadImage> getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(List<UploadImage> uploadImage) {
		this.uploadImage = uploadImage;
	}

	
}
