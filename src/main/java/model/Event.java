package model;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name="EVENT")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EVENTID")
	private Integer eventId;
	
	@Column(name="EVENT_NAME")
	private String eventName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="SIGNUP_STARTIME")
	private Date signupStartime;
	
	@Temporal(TemporalType.DATE)
	@Column(name="SIGNUP_ENDTIME")
	private Date signupEndtime;
	
	@Temporal(TemporalType.DATE)
	@Column(name="EVENT_STARTIME")
	private Date startTime;
	
	@Temporal(TemporalType.DATE)
	@Column(name="EVENT_ENDTIME")
	private Date endTime;
	
	@Column(name="EVENT_DETAIL")
	private String eventDetail;
	
	@Column(name="EVENT_CATEGORY")
	private String eventCategory;
	
	@Column(name="EVENT_PRICE")
	private Integer eventPrice;
	
	@Column(name="EVENT_ADDRES")
	private String eventLocation;
	
	@Column(name="ORGANIZER")
	private String Organizer;
	
	@Column(name="PICTURE")
	private String Picture;
	
	

	public Event() {
		super();
	}

	

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", signupStartime=" + signupStartime
				+ ", signupEndtime=" + signupEndtime + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", eventDetail=" + eventDetail + ", eventCategory=" + eventCategory + ", eventPrice=" + eventPrice
				+ ", eventLocation=" + eventLocation + ", Organizer=" + Organizer + ", Picture=" + Picture + "]";
	}



	public Event(Integer eventId, String eventName, Date signupStartime, Date signupEndtime, Date startTime,
			Date endTime, String eventDetail, String eventCategory, Integer eventPrice, String eventLocation,
			String organizer, String picture) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.signupStartime = signupStartime;
		this.signupEndtime = signupEndtime;
		this.startTime = startTime;
		this.endTime = endTime;
		this.eventDetail = eventDetail;
		this.eventCategory = eventCategory;
		this.eventPrice = eventPrice;
		this.eventLocation = eventLocation;
		Organizer = organizer;
		Picture = picture;
	}



	public Date getSignupStartime() {
		return signupStartime;
	}



	public void setSignupStartime(Date signupStartime) {
		this.signupStartime = signupStartime;
	}



	public Date getSignupEndtime() {
		return signupEndtime;
	}



	public void setSignupEndtime(Date signupEndtime) {
		this.signupEndtime = signupEndtime;
	}



	public Date getStartTime() {
		return startTime;
	}



	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}



	public Date getEndTime() {
		return endTime;
	}



	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}



	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}



	public String getEventDetail() {
		return eventDetail;
	}

	public void setEventDetail(String eventDetail) {
		this.eventDetail = eventDetail;
	}

	public String getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	public Integer getEventPrice() {
		return eventPrice;
	}

	public void setEventPrice(Integer eventPrice) {
		this.eventPrice = eventPrice;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getOrganizer() {
		return Organizer;
	}

	public void setOrganizer(String organizer) {
		Organizer = organizer;
	}

	public String getPicture() {
		return Picture;
	}

	public void setPicture(String picture) {
		Picture = picture;
	}
	
	
	

}