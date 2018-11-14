 
package br.com.octoevents.endpoint;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import br.com.octoevents.domain.Event;
import br.com.octoevents.service.EventService_Impl;
import br.com.octoevents.service.IEventService;

@Path("issues")
public class EventsWSRest {

	/**
     * Default constructor. 
     */
    public EventsWSRest() {
        // TODO Auto-generated constructor stub
    }

	@Path("{number}/events")
	@GET
	@Produces("application/json")
	public Response findEventByNumber(@PathParam("number") int number) throws JSONException {

		IEventService service = new EventService_Impl();
		List<Event> events = service.findByNumber(number);
		StringBuffer result = new StringBuffer();
		//result.append("200 OK");
		if(events != null && events.size() > 0) {
			JSONObject jsonObject = null;
			JSONArray array = new JSONArray();
			for(Event event : events) {
				jsonObject = new JSONObject();
				jsonObject.put("number", String.valueOf(event.getNumber()));
				jsonObject.put("created_at", event.getDateTimeCreation());
				jsonObject.put("action", event.getAction());
				array.put((JSONObject) new JSONTokener(jsonObject.toString()).nextValue());
			}
			result.append(System.lineSeparator());
			result.append(array.toString());
			return Response.ok(result.toString(), MediaType.APPLICATION_JSON).build();
		} else {
			return Response.ok(new JSONObject().put("NOT_FOUND", ("Nenhum registro encontrado para o parametro: ")+number).toString(), MediaType.APPLICATION_JSON).build();
		}
	}
}