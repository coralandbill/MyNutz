package net.xmf.nutz.module.user;

import java.util.Date;

import javax.servlet.http.HttpSession;

import net.xmf.nutz.bean.HyUser;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Attr;
import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

@IocBean
@At("/user")
public class UserModule {
	
	private static final Log log = Logs.get();
	
	@Inject
	private Dao dao;
	
	@At("/login")
	@Ok("jsp:jsp.success")
	@Fail("jsp:jsp.index")
	@Encoding(input="UTF-8",output="UTF-8")
	public String login(@Param("loginName")String loginName,@Param("password")String password,
			HttpSession session){
		if(Strings.isBlank(loginName)|| Strings.isBlank(password)){
			return "登录失败，用户名或密码不能为空!";
		}else{
			loginName = loginName.trim().intern();
			password = password.trim().intern();
		}
		
		HyUser hyUser = dao.fetch(HyUser.class,Cnd.where("loginName","=",loginName).and("password","=",password));
		if(hyUser == null){
			return "登录失败，用户名或密码错误!";
		}else{
			session.setAttribute("user", hyUser);
			return "登录成功！";
		}
		
	}
	
	@At 
	@Ok(">>:/") //@Ok("->:/") 内部从定向
	public void logout(HttpSession session){
		session.invalidate();
	}
	
	@At
	public HyUser me(@Attr("me")HyUser hyUser){
		return hyUser;
	}
	
	@At("/ping")
	public Object ping(){
		log.debug("Dao ==="+dao);
		return new Date();
	}

}
