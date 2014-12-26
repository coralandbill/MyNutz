package net.xmf.nutz.module.hello;

import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

public class HelloModule {
	
	@At("/hello")
	@Ok("jsp:jsp.hello")
	public String sayHello(){
		return "Hello Nutz";
	}

}
