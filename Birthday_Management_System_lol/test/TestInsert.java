import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.transdyn.dynac.member.Member;


public class TestInsert
{
	public static void main(String[] args)
	{
		System.out.println("insert start");
		Configuration cfg = new Configuration();		
		SessionFactory sessions = cfg.configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
//		Configuration configuration = new Configuration();
//		configuration.configure();
//		SessionFactory sessionFactory =configuration.buildSessionFactory(); 
//		Session session = sessionFactory.getCurrentSession();
		System.out.println("beginning transaction");
		session.beginTransaction();
		System.out.println("setting values");
		Member member = new Member();
		member.setName("Robert Lupinek");
		member.setBirthday("OCT 21");		
		member.setId(1);
//		session.update(member);
		session.save(member);
		session.getTransaction().commit();
		System.out.println("testing main");		
	}
}
