package net.xmf.nutz.demo.ioc;

import java.util.Calendar;

import org.nutz.log.Log;
import org.nutz.log.Logs;

public class Pet {
	
	private static Log log = Logs.get();
	
	private String name;
	
	private Calendar birthday;
	
	private Pet friend;
	
	public void init(){
		log.debug("init=================================");
	}
	
	public void fetch(){
		log.debug("fetch=================================");
	}
	
	public Pet() {
		log.debug("无参构造函数被调用.......");
	}

	public Pet(String name) {
		log.debug("有参构造函数被调用.......");
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public Pet getFriend() {
		return friend;
	}

	public void setFriend(Pet friend) {
		this.friend = friend;
	}
	
	

}
