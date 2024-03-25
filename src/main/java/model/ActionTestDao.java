package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;



import util.HibernateUtil;

public class ActionTestDao {

	private SessionFactory factory;
	
	public ActionTestDao() {
		this.factory = HibernateUtil.getSessionFactory();	
	}

	//查詢
	public Event findByEventDate(Date startTime) {
		Session session = factory.getCurrentSession();
		
		String hql = "FROM EVENT a WHERE a.activityDate = :date";
		Calendar calendar = Calendar.getInstance();
		calendar.set(2024, Calendar.MARCH, 22);
		Date start = calendar.getTime();

		try {
			
			Query<Event> query = session.createQuery(hql, Event.class)
					.setParameter("date", start);
			
			Event result = query.getSingleResult();
			
			return result;
		}catch(NoResultException e) {
//			System.out.println(e);  // debug 再打開
			return null;
		}
	}
	
	
}	
