package br.com.octoevents.domain;

import java.util.Date;

public class Event {

	private int id;
	private String action;
	private int number;
	private String status;
	private Date dateTimeCreation;
	private Date dateTimeUpdated;
	private String title;
	private String user;

	/**
	 *  Constructor
	 */
	public Event() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Minimal Constructor
	 * @param id
	 * @param number
	 */
	public Event(int id, int number) {
		super();
		this.id = id;
		this.number = number;
	}
	

	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDateTimeCreation() {
		return dateTimeCreation;
	}
	public void setDateTimeCreation(Date dateTimeCreation) {
		this.dateTimeCreation = dateTimeCreation;
	}
	public Date getDateTimeUpdated() {
		return dateTimeUpdated;
	}
	public void setDateTimeUpdated(Date dateTimeUpdated) {
		this.dateTimeUpdated = dateTimeUpdated;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
