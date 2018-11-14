package br.com.octoevents.dao;

import java.util.List;

import br.com.octoevents.domain.Event;

/**
 * Interface that�s model the dao�s tier
 * 
 * @author Leonardo Lopes
 *
 */
public interface IEventDAO {
	
	/**
	 * Models the dao�s call of insert event
	 * 
	 * @param Event
	 * @return int
	 */
	int insert(Event event);
	
	/**
	 * Models the dao�s call of find by number
	 *  
	 * @param int number
	 * @return List<Event>
	 */
	List<Event> findByNumber(int number);
}
