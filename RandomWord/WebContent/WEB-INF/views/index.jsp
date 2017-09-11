<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>You have generated a word <%= session.getAttribute("clicks") %> times</h3>
<%-- 	<h1><%= session.getAttribute("randomWord") %></h1> --%>
 	<h1><c:out value="${randomWord}"></c:out></h1>
 	<form action="/RandomWord/Random">
	    <button type="submit" name="generate">Generate</button>
	</form>
	<h3>The last time you generated a word was:</h3>
	    <h1><c:out value="${datelastgen}"></c:out></h1>
	

</body>
</html>