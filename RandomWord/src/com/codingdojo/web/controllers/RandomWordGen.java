package com.codingdojo.web.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RandomWordGen
 */
@WebServlet("/Random")
public class RandomWordGen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomWordGen() {
        super();
        // TODO Auto-generated constructor stub
    }

    private String genRandomWord (int length) {
    		final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    		Random rnd = new Random();
	  	StringBuilder sb = new StringBuilder( length );
	    	   for( int i = 0; i < length; i++ ) 
	    	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	    	return sb.toString();
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Integer clicks = (Integer) session.getAttribute("clicks");
		if (clicks == null) {
			session.setAttribute("clicks", 0);
		} else {
			Integer clicks1 = (Integer) session.getAttribute("clicks");
			clicks1++;
			session.setAttribute("clicks", clicks1);
		}
		String randomWord = genRandomWord(10);
		Date dateofwordgen = new Date();
		SimpleDateFormat dateformated = new SimpleDateFormat("MMMM d, yyyy - H:m a");
        String datelastgen = dateformated.format(dateofwordgen);
	    request.setAttribute("randomWord", randomWord);
	    request.setAttribute("datelastgen", datelastgen);
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
