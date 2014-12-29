package net.xmf.nutz.filter;

import javax.servlet.http.HttpSession;

import net.xmf.nutz.bean.HyUser;

import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.View;
import org.nutz.mvc.view.JspView;

public class UserLoginFilter implements ActionFilter{

	@Override
	public View match(ActionContext actionContext) {
		HttpSession session = actionContext.getRequest().getSession();
		System.out.println("=======session:"+session);
		
		HyUser hyUser = (HyUser) session.getAttribute(HyUser.SESSION_NAME);
		//没有登陆跳转至登陆页面
		if(hyUser==null){
			return new JspView("/index");
		}
		return null;
	}

}
