package net.xmf.nutz.aop.ioc;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.annotation.AnnotationIocLoader;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean
//被AOP的类,必须是public的非abstract类!
public class UserAction {
	@Aop({"logInterceptor"}) //这里写拦截器bean的名字
	public boolean login(String username, String password) throws Throwable {
        if ("wendal".equals(username) && "qazwsxedc".equals(password)) {
            System.out.println("登陆成功");
            return true;
        }
        System.out.println("登陆失败");
        return false;
	}
	
	public static void main(String[] args) throws Throwable {
        Ioc ioc = new NutIoc(new AnnotationIocLoader("net.xmf.nutz.aop.ioc"));
        UserAction action = ioc.get(UserAction.class);
        action.login("wendal", "qazwsxedc");
	}
	    
}
