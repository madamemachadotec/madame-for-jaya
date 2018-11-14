package test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.octoevents.domain.Event;
import br.com.octoevents.service.EventService_Impl;
import br.com.octoevents.service.IEventService;

public class EventsFindByNumberTests {

	private static IEventService service;
		 
    @BeforeClass
    public static void initEventsTests() {
        service = new EventService_Impl();
    }
    
    @Before
    public void beforeEachTest() {
        System.out.println("Inicio do teste de consulta");
	}
    
    @After
    public void afterEachTest() {
        System.out.println("Fim do teste de consulta");
    }
    
    @Test
    public void testSucessoFindByNumber() {
        List<Event> result = service.findByNumber(2);
        assertTrue(result.size() > 0);
    }

    @Test
    public void testNaoEncontradoFindByNumber() {
    	List<Event> result = service.findByNumber(0);
    	assertTrue(result.size() == 0);
    }
}
