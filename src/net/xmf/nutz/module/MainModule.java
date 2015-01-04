package net.xmf.nutz.module;

import net.xmf.nutz.init.ModuleSetUp;

import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

@Modules(scanPackage=true)
@Ok("json")
@Fail("json")
/*@IocBy(type=ComboIocProvider.class,args={
	"*org.nutz.ioc.loader.json.JsonLoader","ioc/",
	"*org.nutz.ioc.loader.annotation.AnnotationIocLoader","net.xmf.nutz"
})*/
@IocBy(type=ComboIocProvider.class,args={
	"*json","ioc/",
	"*annotation","net.xmf.nutz"
})
@SetupBy(ModuleSetUp.class)
public class MainModule {

}
