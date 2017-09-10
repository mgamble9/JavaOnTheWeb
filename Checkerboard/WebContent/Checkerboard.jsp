<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Drawing a checkerboard pattern</title>
<link rel='stylesheet' type='text/css' href='style.css'>
</head>
<body>
<h1>hello!</h1>
	<% int w = Integer.parseInt(request.getParameter("width")); %>
	<% int h = Integer.parseInt(request.getParameter("height")); %>
	<h1>Checkerboard: <%= w %>w X <%= h %>h</h1>
	
	<% String html = ""; %>
	<% for(int i = 0; i <h; i++) { %>
		<% for(int j = 0; j < w; j++) { %>
			<% if((i + j) % 2 == 0) { %>
				<% html += "<div class='redbox'></div>"; %>
			<% } else { %>	
				<% html += "<div class='bluebox'></div>"; %>
			<% } %>
		<% } %>
		<% html += "<br>"; %>
	<% } %>
	
	<%= html %>
</body>
</html>