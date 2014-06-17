package pojodao;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

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

import pojo.Player;

public class CRUDTest {
	
	private static SessionFactory sf;
	private Session session;
	
	@Test
	public void testSave(){
		Room r = new Room();
		People p = new People();
		r.setRoomName("实验室");
		p.setRoom(r);
		p.setName("测试级联保存");
//		session.save(p);
		session.persist(p);
	}
	@Test
	public void testGet(){
		Room r = (Room) session.get(Room.class, 1);
		System.out.println(r.getPeoples().get(0).getName());
	}
	@Test
	public void testLoad(){
		Player p = (Player) session.get(Player.class, 3);
		 p.getPet().getName();
//		 p.getClass();
		session.getTransaction().commit();
//		p.getPet();
		System.out.println(p.getPet());
//		System.out.println(r.getPeoples().get(0).getName());
	}
	@Test
	public void testDelete(){
//		Room r = (Room) session.get(Room.class, 1);
//		session.delete(r);
//		People p = (People)session.get(People.class, 1);
//		session.delete(p);
	}
	@Test
	public void testHql(){
//		session.createQuery("delete from Room r where r.id = 2").executeUpdate();
	}
	
	@Test
	public void testSession(){
		Session s1 = sf.getCurrentSession();
		System.out.println("s1 = "+s1.hashCode());
		s1.beginTransaction();
		s1.getTransaction().commit();
		Session s2 = sf.getCurrentSession();
		
		System.out.println("s2 = "+s2.hashCode());
	}
	@Test
	public void testSession2(){
		Session session = sf.getCurrentSession();
		
		//事务开启
		session.beginTransaction();
		//进行数据库的操作
		//session.save(),delete等
		//事务提交
		session.getTransaction().commit();
	}
	@Test
	public void testUpdate(){
		People p = (People) session.get(People.class, 1);
//		System.out.println(p.getRoom().getRoomName());
//		session.getTransaction().commit();
		p.setName("Update测试");
		session.save(p);
//		session = sf.getCurrentSession();
//		p.getRoom().setRoomName("房间");
//		session.beginTransaction();
//		session.update(p);
//		session.getTransaction().commit();
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
//		session.getTransaction().commit();
	}

}
