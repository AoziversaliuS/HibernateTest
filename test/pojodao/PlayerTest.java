package pojodao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import many2many.Boy;
import many2many.Girl;
import many2one.People;
import many2one.Room;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pojo.Pet;
import pojo.Player;
import pojo.Weapon;
import type.Sex;

public class PlayerTest {

	private static SessionFactory sf;
	private Session session;
	
	@BeforeClass
	public static void init(){
		Configuration cfg= new AnnotationConfiguration().configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		sf = cfg.buildSessionFactory(sr);
	}
	@AfterClass
	public static void release(){
		sf.close();
	}
	
	@Test
	public void testSave() {

		
		
		session.save(new Player("奥茨小朋友", "xiao", Sex.Girl));
		
		
	}
	
	@Test
	public void testPet(){
		Player player = new Player("带宠物的奥茨", "juan", Sex.Boy);
		Pet pet = new Pet("小王","治疗");
		session.save(pet);
		player.setPet(pet);
		session.save(player);
	}
	
	@Test
	public void testLoad(){
//		Player p =  (Player)session.get(Player.class, 1);
		Pet pet = (Pet)session.load(Pet.class, 1);
		
//		System.out.println("pet="+pet.getMaster());
	}
	@Test
	public void testGroupMapping(){
		
		Player player = new Player("带武器的奥茨", "juan", Sex.Boy);
		Pet pet = new Pet("小王","治疗");
		session.save(pet);
		player.setPet(pet);
		player.setWeapon(new Weapon("神剑", 100));
		session.save(player);
		
	}
	@Test
	public void testManyToOne(){
		People p = new People();
		People p2 = new People();
		Room r = new Room();
		session.save(r);
		p.setName("奥茨人");
		p.setRoom(r);
		p2.setName("女仆");
		p2.setRoom(r);
		session.save(p);
		session.save(p2);
		
	}
	@Test 
	public void testOne2Many(){
//		this.before();
		Room room = (Room) session.get(Room.class, 1);
//		this.after();
     	System.out.println(room.getPeoples().get(1).getName());
//     	People p = (People)session.get(People.class, 1);
//     	System.out.println(p);
		
	}
	
	@Test
	public void testManyToMany(){
		List<Boy> boys = new ArrayList<Boy>();
		boys.add((Boy)session.get(Boy.class, 4));
		boys.add((Boy)session.get(Boy.class, 5));
		boys.add((Boy)session.get(Boy.class, 6));
		System.out.println(boys);
		session.save(new Girl("girlB",boys ));
	}
	@Test
	public void testManyToManyA(){
		Girl girl = (Girl)session.get(Girl.class, 1);
		System.out.println(girl.getBoyFriends());
	}
	@Test
	public void testManyToManyB(){
//		Girl girl = (Girl)session.get(Girl.class, 1);
//		System.out.println(girl.getBoyFriends());
		Boy boy = (Boy) session.get(Boy.class, 4);
		System.out.println(boy.getGirlFriends().get(1).getName());
	}
	
	@Before
	public void before(){
		session  = sf.getCurrentSession();
		session.beginTransaction();
	}
	@After
	public void after(){
		session.getTransaction().commit();
	}

}
