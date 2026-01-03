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
	String favPlace = "no place";
	
	Cookie [] cookies = request.getCookies();
	
	for(Cookie cookie: cookies){
		if (cookie.getName().equals("favPlace")){
			favPlace = cookie.getValue();
			break;
		}
	}
%>

<%= favPlace%>

</body>
</html>