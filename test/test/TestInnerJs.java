package test;

import net.xmf.nutz.demo.ioc.Pet;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;

public class TestInnerJs {
	public static void main(String[] args) {
		Ioc ioc = new NutIoc(new JsonLoader("net/xmf/nutz/demo/ioc/inner.js"));
		Pet pet = ioc.get(Pet.class, "xb");
		System.out.println(pet.getFriend().getName());
	}

}
