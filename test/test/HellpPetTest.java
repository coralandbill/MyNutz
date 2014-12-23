package test;
import net.xmf.nutz.demo.ioc.Pet;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;


public class HellpPetTest {
	public static void main(String[] args) {
		Ioc ioc = new NutIoc(new JsonLoader("net/xmf/nutz/demo/ioc/pets.js"));
        Pet pet = ioc.get(Pet.class, "xiaobai");
        System.out.printf("%s - [%s]\n", pet.getName(), pet.getBirthday().getTimeZone().getID());
        
        Pet xh = ioc.get(null, "xiaohei");
        System.out.printf("%s's friend is %s\n", xh.getName(), xh.getFriend().getName());
        
        Pet p1 = ioc.get(null, "xiaohei");
        Pet p2 = ioc.get(null, "xiaohei");
        System.out.println(p1==p2);
	}

}
