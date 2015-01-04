package test;

import net.xmf.nutz.demo.ioc.Pet;
import net.xmf.nutz.module.user.UserModule;

import org.junit.Test;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.nutz.ioc.loader.json.JsonLoader;

import com.alibaba.druid.pool.DruidDataSource;

public class TestIoc {

	@Test
	public void test_conv_jav_ioc() throws ClassNotFoundException{
		ComboIocLoader loader = new ComboIocLoader("*org.nutz.ioc.loader.json.JsonLoader","ioc/daoDataSource.js",
	"*org.nutz.ioc.loader.annotation.AnnotationIocLoader","net.xmf.nutz");
		
		NutIoc ioc = new NutIoc(loader);
		Dao dao = ioc.get(Dao.class);
		System.out.println("dao====:"+dao);
		
		UserModule userModule = ioc.get(UserModule.class);
		System.out.println("userModule::"+userModule.ping());
	}
	
	
	@Test
	public void test_js_ioc(){
		JsonLoader loader = new JsonLoader("ioc/");
		NutIoc ioc = new NutIoc(loader);
		
		Dao dao = ioc.get(Dao.class);
		System.out.println("==11==dao:"+dao);
	}
	
	@Test 
	public void test_js_conv_ioc(){
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/nutzTest");
		dataSource.setUsername("postgres");
		dataSource.setPassword("123456");
		
		NutDao dao = new NutDao(dataSource);
		System.out.println("====22===dao:"+dao);
	}
	
	@Test 
	public void test_js_pet_ioc(){
		JsonLoader loader = new JsonLoader("net/xmf/nutz/demo/ioc/pets.js");
		Ioc ioc = new NutIoc(loader);
		Pet pet = ioc.get(Pet.class);
		Pet pet1 = ioc.get(Pet.class);
		System.out.println("=====pet:"+pet.getName());
		System.out.println("=====pet1:"+pet1.getName());
	}
	
}
