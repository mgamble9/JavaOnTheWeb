package com.codingdojo.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GreatNumberGame
 */
@WebServlet("/GreatNumberGame")
public class GreatNumberGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GreatNumberGame() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result_box_str = null;
		HttpSession session = request.getSession();
		if(session.getAttribute("result_box_str") == null) {
			session.setAttribute("result_box_str", "<div id=\"no_div\"></div>");
			session.setAttribute("answer", (Double) Math.floor(Math.random()*101));
			System.out.println("Answer is:" + session.getAttribute("answer"));			
		}
		else {
			result_box_str = (String) session.getAttribute("result_box_str");			
		}
    
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/index.jsp");
        view.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String restart = (String) request.getParameter("restart");
		String result_box_str = "";
		if(restart != null) {
			session.setAttribute("answer", null);
			session.setAttribute("result_box_str", null);
		}
		else if (session.getAttribute("answer") != null) {
			Integer guess = Integer.parseInt(request.getParameter("guess"));
			session.setAttribute("guess", guess);
			Double answer_double = (Double) session.getAttribute("answer");
			Integer answer = answer_double.intValue();
	        if (guess == null || guess < 1 || guess > 100) {
	     	   result_box_str = "<div id=\"wrong_answer_div\"><h1>Your guess must be between 1 and 100!</h1></div>";
	     	 }
	     	 else if (guess == answer) {
	     		 session.setAttribute("answer", null);
	     		 result_box_str ="<div id=\"right_answer_div\"><h2>" + guess + " was the number!</h2><form action=\"/GreatNumberGame/GreatNumberGame\" method = \"post\"><input type=\"hidden\" name=\"restart\" value=\"restart\"><input type=\"submit\" value=\"New Game?\"></form></div>";

	     	 }
	     	 else if (guess < answer) {
	     	   result_box_str = "<div id=\"wrong_answer_div\"><h1>" + guess + "? Too Low!</h1></div>";

	     	 }
	     	 else if (guess > answer) {
	     	   result_box_str = "<div id=\"wrong_answer_div\"><h1>" + guess + "? Too High!</h1></div>";
	     	 }
	     	session.setAttribute("result_box_str", result_box_str);
	     	System.out.println(result_box_str);

		}
//		doGet(request, response);
		response.sendRedirect("/GreatNumberGame/GreatNumberGame");

	}

}

