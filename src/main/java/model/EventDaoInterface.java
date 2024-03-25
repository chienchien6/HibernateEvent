package model;


import java.util.List;



public interface EventDaoInterface {
	void insert(Event evBean);
	Event select(Integer id);
	List<Event> selectStartTime(String startTime);//查詢活動開始時間	
	List<Event> findAll();
	Event UpdateOne(Event evBean);
	void deleteOne(Integer id);
}
