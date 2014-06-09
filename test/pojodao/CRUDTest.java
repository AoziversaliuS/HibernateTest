package pojodao;

import many2one.People;
import many2one.Room;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CRUDTest {
	
	private static SessionFactory sf;
	private Session session;
	
	@Test
	public void testSave(){
		Room r = new Room();
		People p = new People();
		p.setRoom(r);
		p.setName("²âÊÔ¼¶Áª±£´æ");
//		session.save(p);
		session.persist(p);
	}
	@Test
	public void testDelete(){
//		Room r = (Room) session.get(Room.class, 1);
//		session.delete(r);
//		People p = (People)session.get(People.class, 1);
//		session.delete(p);
	}
	
	@BeforeClass
	public static void init(){
		Configuration cfg= new Configuration().configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		sf = cfg.buildSessionFactory(sr);
	}
	@AfterClass
	public static void release(){
		sf.close();
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
