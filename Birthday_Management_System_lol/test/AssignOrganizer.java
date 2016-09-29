import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.omg.Messaging.SyncScopeHelper;

import com.transdyn.dynac.member.Member;


public class AssignOrganizer {

	public static int[] randomAssign(int amount)
	{
		int memberOrganizer[]=new int[amount];
		for(int n=0;n<amount;n++)
		{
			System.out.println("n="+n);
			Random random=new Random();
			int organizerID=random.nextInt(amount);
			System.out.println("organizerID:"+organizerID);
			boolean hasSameValue=false;
			for(int m=0;m<n;m++)
			{
				if(memberOrganizer[m]==organizerID)
				{
					n--;
					hasSameValue=true;
					System.out.println("m:"+m+" value same:"+organizerID);
					break;
				}
			}
			if(!hasSameValue)
			{
				memberOrganizer[n]=organizerID;
				System.out.println("assigned:"+n+" "+organizerID);
			}
			
		}
		return memberOrganizer;
				
	}
	public static void main(String[] args) {
		Configuration cfg = new Configuration();		
		SessionFactory sessions = cfg.configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
//		Configuration configuration = new Configuration();
//		configuration.configure();
//		SessionFactory sessionFactory =configuration.buildSessionFactory(); 
//		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		Member member = (Member)session.get(Member.class, 4);						
		int organizer[]=new int[17];
		organizer=AssignOrganizer.randomAssign(17);
		
		
		//getting members example
		/*
		String hql = "select name from Member mem where mem.id=:id"; //Member is the classname
		Query query = session.createQuery(hql);
		query.setString("id", "1");		
		List<String> result=query.list();
		System.out.println("member:"+result.get(0));
		member.setOrganizer(result.get(0));*/
//		for(int n=0;n<17;n++)
//		{
//			member.setOrganizer(organizer);
//		}
		
		//get member counts
		Long count;		
		String hql = "select count(name) from Member";
		count = (Long)session.createQuery(hql).uniqueResult();
		System.out.println("count:"+count);
		
		for(int n=1;n<=count;n++)
		{			
			cfg = new Configuration();		
			sessions = cfg.configure().buildSessionFactory();
			session=sessions.getCurrentSession();
			session.beginTransaction();
			System.out.println("n="+n);
			//operate on member id=n
			member = (Member)session.get(Member.class, n);
			//getting the organizer name by id
			hql = "select name from Member mem where mem.id=:id"; //Member is the classname
			Query query = session.createQuery(hql);
			query.setString("id", organizer[n-1]+1+"");
			System.out.println("member id="+n);
			System.out.println("organizer:"+organizer[n-1]);
			String assignedOrganizerName=(String)query.uniqueResult();			
			member.setOrganizer(assignedOrganizerName);		
			session.update(member);
//			session.save(member);
			session.getTransaction().commit();
			System.out.println("testing main");
		}
	}

}
