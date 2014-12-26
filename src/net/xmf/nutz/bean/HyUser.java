package net.xmf.nutz.bean;


import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("hy_user")
public class HyUser {

	@Id
	private long id;
	
	private String loginName;
	
	private String realName;
	
	private String password;
	
	private String birtyday;

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

	
}
