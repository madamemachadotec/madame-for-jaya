package br.com.octoevents.service;

import java.util.List;

import br.com.octoevents.dao.EventDAO_Impl;
import br.com.octoevents.dao.IEventDAO;
import br.com.octoevents.domain.Event;

/**
 * Implementation of business service´s tier
 * 
 * @author Leonardo Lopes
 *
 */
public class EventService_Impl implements IEventService {

	IEventDAO dao = null;
	
	@Override
	public int insert(Event event) {
		dao = new EventDAO_Impl();
		return dao.insert(event);
	}

	@Override
	public List<Event> findByNumber(int number) {
		dao = new EventDAO_Impl();
		return dao.findByNumber(number);
	}
}
