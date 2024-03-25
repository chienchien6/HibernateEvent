package service;

import java.util.List;

import model.Event;


public interface EventServiceInterface {
	void insert(Event evBean);
	Event select(Integer id);
	List<Event> selectStartTime(String startTime);//查詢活動開始時間	
	List<Event> findAll();
	Event UpdateOne(Event evBean);
	void deleteOne(Integer id);
}
