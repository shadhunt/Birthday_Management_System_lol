import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.transdyn.dynac.member.Member;


public class TestUpdateName
{
	public static void main(String[] args)
	{
		Configuration cfg = new Configuration();		
		SessionFactory sessions = cfg.configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
//		Configuration configuration = new Configuration();
//		configuration.configure();
//		SessionFactory sessionFactory =configuration.buildSessionFactory(); 
//		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		Member member = (Member)session.get(Member.class, 14);
		
		member.setName("Danny Shumrock");		
		
		session.update(member);
//		session.save(member);
		session.getTransaction().commit();
		System.out.println("testing main");		
	}
}
