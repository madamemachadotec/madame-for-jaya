package br.com.octoevents.service;

import java.util.List;

import br.com.octoevents.domain.Event;

/**
 * Interface that call the DAO´s tier
 * 
 * @author Leonardo Lopes
 *
 */
public interface IEventService {
	
	/**
	 * Insert an event
	 * 
	 * @param Event
	 */
	int insert(Event event);
	
	/**
	 * Find an event by number
	 * 
	 * @param int number
	 * @return List<Event>
	 */
	List<Event> findByNumber(int number);
}
