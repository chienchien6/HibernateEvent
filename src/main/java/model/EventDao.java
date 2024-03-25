package model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import util.HibernateUtil;

public class EventDao implements EventDaoInterface {

//	private Session session;// 空的 全域變數
//
//	public EventDao(Session session) {
//		this.session = session;
//	}
	
	private SessionFactory factory;
	
	public EventDao() {
		this.factory = HibernateUtil.getSessionFactory();
	}

	@Override
	public void insert(Event evBean) {
		// EventBean eventBean=session.get(EventBean.class, evBean.getEventId());
		Session session = factory.getCurrentSession();
		if (evBean != null) {
			session.save(evBean);

		}

	}

	@Override
	public Event select(Integer id) {
		Session session = factory.getCurrentSession();
		
		 Event event = session.get(Event.class, id);

		 return event;
	}
	
	

	@Override
	public List<Event> findAll() {
		Session session = factory.getCurrentSession();
		Query<Event> query = session.createQuery("from Event", Event.class);
		List<Event> result = query.getResultList();
		return result;
	}

	@Override
	public Event UpdateOne(Event evBean) {
		Session session = factory.getCurrentSession();
		Event eventBean = session.get(Event.class, evBean.getEventId());

		if (eventBean != null) {
			eventBean.setEventName(evBean.getEventName());
			eventBean.setSignupStartime(evBean.getSignupStartime());				
			eventBean.setSignupEndtime(evBean.getEndTime());
			eventBean.setStartTime(evBean.getStartTime());
			eventBean.setEndTime(evBean.getEndTime());
			eventBean.setEventDetail(evBean.getEventDetail());
			eventBean.setEventCategory(evBean.getEventCategory());
			eventBean.setEventPrice(evBean.getEventPrice());
			eventBean.setEventLocation(evBean.getEventLocation());
			eventBean.setOrganizer(evBean.getOrganizer());
			eventBean.setPicture(evBean.getPicture());

		}
		return eventBean;

	}

	
	@Override
	public List<Event> selectStartTime(String startTime) {
		Session session = factory.getCurrentSession();
		
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startDate = LocalDate.parse(startTime,date);
		
		
		String hql="from Event e where e.startTime =:st";
		
		Query<Event> query = session.createQuery(hql,Event.class);	
		query.setParameter("st",java.sql.Date.valueOf(startDate));
		
		List<Event> resultList = query.getResultList();
		
		if(!resultList.isEmpty()) {
			return resultList;
		}
		
		return null;
	}

	@Override
	public void deleteOne(Integer id) {
		Session session = factory.getCurrentSession();
		Event eventBean = session.get(Event.class, id);

		if (eventBean != null) {
			session.delete(eventBean);
			
		}
	
	}

}
