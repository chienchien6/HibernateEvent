package service;

import java.util.List;

import org.hibernate.Session;

import model.Event;
import model.EventDao;

public class EventService implements EventServiceInterface {

	private EventDao eventDao;
	
	public EventService(Session session) {
		this.eventDao = new EventDao();
	}
	
	@Override
	public void insert(Event evBean) {
		eventDao.insert(evBean);

	}

	@Override
	public Event select(Integer id) {
		
		return eventDao.select(id);
	}

	@Override
	public List<Event> selectStartTime(String startTime) {
		
		return eventDao.selectStartTime(startTime);
	}

	@Override
	public List<Event> findAll() {
		
		return eventDao.findAll();
	}

	@Override
	public Event UpdateOne(Event evBean) {
		
		return eventDao.UpdateOne(evBean);
	}

	@Override
	public void deleteOne(Integer id) {
		eventDao.deleteOne(id);

	}

}
