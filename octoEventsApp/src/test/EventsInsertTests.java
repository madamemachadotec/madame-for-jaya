package test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.octoevents.domain.Event;
import br.com.octoevents.service.EventService_Impl;
import br.com.octoevents.service.IEventService;

public class EventsInsertTests {

	private static IEventService service;
		 
    @BeforeClass
    public static void initEventsTests() {
        service = new EventService_Impl();
    }
    
    @Before
    public void beforeEachTest() {
        System.out.println("Inicio do teste de insert");
	}
    
    @After
    public void afterEachTest() {
        System.out.println("Fim do teste de insert");
    }
    
    @Test
    public void testInsert() {
    	
    	Event event = new Event();
        event.setAction("test");
        event.setNumber(2);
        event.setStatus("test");
        event.setDateTimeCreation(new Date());
        event.setDateTimeUpdated(new Date());
        event.setTitle("Test Junit");
        event.setUser("Junit");
    	
        int result = service.insert(event);
        assertEquals(1, result);
	}
    

    @Test(expected = Exception.class)
    public void testInsertException() throws Exception {
    	service.insert(null);
    }
}
