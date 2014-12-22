package net.xmf.nutz.module.User;

import java.util.Date;

import javax.servlet.http.HttpSession;

import net.xmf.nutz.bean.User;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Attr;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

@IocBean
@At("/user")
public class UserModule {
	
	private static final Log log = Logs.get();
	
	@Inject
	private Dao dao;
	
	@At
	public boolean login(@Param("name")String name,@Param("passwd")String passwd,
			HttpSession session){
		if(Strings.isBlank(name)|| Strings.isBlank(passwd)){
			return false;
		}else{
			name = name.trim().intern();
			passwd = passwd.trim().intern();
		}
		
		User user = dao.fetch(User.class,Cnd.where("name","=",name).and("passwd","=",passwd));
		if(user == null){
			return false;
		}else{
			session.setAttribute("me", user);
			return true;
		}
		
	}
	
	@At 
	@Ok(">>:/") //@Ok("->:/") 内部从定向
	public void logout(HttpSession session){
		session.invalidate();
	}
	
	@At
	public User me(@Attr("me")User user){
		return user;
	}
	
	@At("/ping")
	public Object ping(){
		log.debug("Dao ==="+dao);
		return new Date();
	}

}
