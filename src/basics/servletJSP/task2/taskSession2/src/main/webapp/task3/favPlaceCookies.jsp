<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String favPlace = request.getParameter("favPlace");
	Cookie cookie = new Cookie("favPlace", favPlace);
	cookie.setMaxAge(60*60*24*30);
	response.addCookie(cookie);
%>

<a href="main-page.jsp">main page</a>

</body>
</html>