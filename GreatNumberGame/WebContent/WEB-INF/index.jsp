<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="static/css/style.css">
<title>Great Number Game</title>
</head>
<body>
	<%
		String result_box_str = (String) session.getAttribute("result_box_str");
	%>
    <div id="wrapper">
	      <div id="top_header">
		        <h1>Welcome to the Great Number Game!</h1>
		        <p>I am thinking of a number between 1 and 100</p>
		        <p>Take a guess!</p>
	      </div>
	      <div id="result_block">
		        <%= result_box_str %>
	      </div>
	      <div id="form_block">
	        <form action='/GreatNumberGame/GreatNumberGame' method = "POST">
	          input integer from 1 to 100:<input type="number" min="1" max="100" required name="guess">
	          <button>Submit</button>
	        </form>
	      </div>
    </div>

</body>
</html>