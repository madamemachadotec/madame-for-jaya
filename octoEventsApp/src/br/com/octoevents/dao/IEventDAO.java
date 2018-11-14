package br.com.octoevents.dao;

import java.util.List;

import br.com.octoevents.domain.Event;

/**
 * Interface that큦 model the dao큦 tier
 * 
 * @author Leonardo Lopes
 *
 */
public interface IEventDAO {
	
	/**
	 * Models the dao큦 call of insert event
	 * 
	 * @param Event
	 * @return int
	 */
	int insert(Event event);
	
	/**
	 * Models the dao큦 call of find by number
	 *  
	 * @param int number
	 * @return List<Event>
	 */
	List<Event> findByNumber(int number);
}
