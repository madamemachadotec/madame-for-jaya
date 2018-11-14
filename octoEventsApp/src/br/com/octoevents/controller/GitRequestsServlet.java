package br.com.octoevents.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.JSONTokener;

import br.com.octoevents.domain.Event;
import br.com.octoevents.service.EventService_Impl;
import br.com.octoevents.service.IEventService;

/**
 * Servlet that receives Webhook events from Github 
 * and saves them on the database
 * 
 */
@WebServlet("/GitRequestsServlet")
public class GitRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GitRequestsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

        try {
        	JSONObject jsonObject = (JSONObject) new JSONTokener(jb.toString()).nextValue();
           
            Event event = new Event();
            String action = jsonObject.getString("action");
            event.setAction(action);
            
            JSONObject issue = (JSONObject)jsonObject.get("issue");
            Integer number = (Integer)issue.get("number");
            event.setNumber(number);
            
            String state = issue.getString("state");
            event.setStatus(state);

            DateFormat dateFormatBR = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            dateFormatBR.setTimeZone(TimeZone.getTimeZone("GMT"));
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

            Date dtCreateTemp = dateFormat.parse(issue.getString("created_at"));
            Date dtCreate = dateFormatBR.parse((String)dateFormatBR.format(dtCreateTemp));
            event.setDateTimeCreation(dtCreate);
            
            Date dtUpdateTemp = dateFormat.parse(issue.getString("updated_at"));
            Date dtUpdate = dateFormatBR.parse((String)dateFormatBR.format(dtUpdateTemp));
            event.setDateTimeUpdated(dtUpdate);
            
            String title = issue.getString("title");
            event.setTitle(title);
            
            JSONObject user = (JSONObject)issue.get("user");
            String login = (String)user.getString("login");
            event.setUser(login);
            
            //Inserting in BD
            IEventService service = new EventService_Impl();
            service.insert(event);
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.service(request, response);
	}
	
	/**
	 * @see HttpServlet#doPut(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.service(request, response);
	}

}
