package com.codingdojo.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
//import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codingdojo.web.models.Timer;

/**
 * Servlet implementation class Stopwatch
 */
@WebServlet("/Stopwatch")
public class Stopwatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stopwatch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String status = request.getParameter("status");
		
		if(session.getAttribute("time") == null) {
			session.setAttribute("time", new Timer());
		}
		
		if(session.getAttribute("allTimes") == null) {
//			List<Timer> allTimes = new ArrayList<Timer>();
			ArrayList<Timer> allTimes = new ArrayList<Timer>();
			session.setAttribute("allTimes", allTimes);
		}
		
		if(status != null) {
			Timer t = (Timer) session.getAttribute("time");
			
			if(status.equals("start")){
				t.setStart();
			} else if(status.equals("stop")  && t.getStart() != null) {
				// getting the List from session
//				List<?> currentTimes = (List<?>) session.getAttribute("allTimes");
				ArrayList<Timer> currentTimes = (ArrayList<Timer>) session.getAttribute("allTimes");
				// empty temp list
//				ArrayList<Timer> tempTimes = new ArrayList<Timer>();
//				
//				for(Object object : currentTimes) {
//					if(object instanceof Timer) {
//						// adding each one to the empty temp list
//						tempTimes.add((Timer) object);
//					}					
//				}
				t.setStop();
				currentTimes.add(t);
				//temp.Times.add(t);
//				session.setAttribute("allTimes", tempTimes);
				session.setAttribute("allTimes", currentTimes);
				session.setAttribute("time", new Timer());
			} else {
				session.setAttribute("time", new Timer());
//				List<Timer> allTimes = new ArrayList<Timer>();
				ArrayList<Timer> allTimes = new ArrayList<Timer>();
				session.setAttribute("allTimes", allTimes);
			}
		}
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		view.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
