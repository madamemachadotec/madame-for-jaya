package br.com.octoevents.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Servlet implementation class GitRequestsServlet
 */
@WebServlet("/GitRequestsServlet")
public class GitRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GitRequestsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Salvar no BD: ").append(request.getContextPath());
		System.out.println("Chegou a requisição: " + request.getContextPath());
		
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
            System.out.println(jsonObject.toString());
            
            String action = jsonObject.getString("action");
            System.out.println("action: " + action);

            
            JSONObject issue = (JSONObject)jsonObject.get("issue");
            System.out.println("number: " + (Integer)issue.get("number"));           
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("GET Served at: ").append(request.getContextPath());
		this.service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("POST Served at: ").append(request.getContextPath());
		this.service(request, response);
	}

}
