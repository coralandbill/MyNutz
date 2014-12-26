package net.xmf.nutz.init;


import org.nutz.dao.Dao;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.nutz.resource.Scans;


public class ModuleSetUp implements Setup{
	
	private static final Log log = Logs.get();

	@Override
	public void init(NutConfig config) {
		log.debug("config ioc = "+config.getIoc());
		log.debug("config urlmapping = "+config.getAtMap());
		
		/*Dao dao = config.getIoc().get(Dao.class);
		for (Class<?> clazz : Scans.me().scanPackage("net.xmf.nutz.bean")) {
			if(clazz.getAnnotation(Table.class) !=null){
				dao.create(clazz, false);
			}
		}
		
		if(dao.count(User.class)==0){
			User users = new User();
			users.setName("admin");
			users.setPasswd("123456");
			dao.insert(users);
		}*/
	}

	@Override
	public void destroy(NutConfig nc) {
		
	}

}
