package net.xmf.nutz.aop.ioc;

import org.nutz.aop.InterceptorChain;
import org.nutz.aop.MethodInterceptor;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean //声明为一个Ioc的bean,名字为logInterceptor
public class LogInterceptor implements MethodInterceptor{

	@Override
	public void filter(InterceptorChain chain) throws Throwable {
		System.out.println("方法即将执行 -->" + chain.getCallingMethod());
        chain.doChain();// 继续执行其他拦截器
        System.out.println("方法执行完毕 -->" + chain.getCallingMethod());
	}

}
