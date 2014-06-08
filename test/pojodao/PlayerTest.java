package pojodao;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pojo.Pet;
import pojo.Player;
import type.Sex;

public class PlayerTest {

	private static SessionFactory sf;
	
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
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		
		
		session.save(new Player("�´�С����", "xiao", Sex.Girl));
		
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testPet(){
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Player player = new Player("������İ´�", "juan", Sex.Boy);
		Pet pet = new Pet("С��","����");
		session.save(pet);
		player.setPet(pet);
		session.save(player);
		session.getTransaction().commit();
	}

}
