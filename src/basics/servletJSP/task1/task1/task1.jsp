<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Function Example</title>
</head>
<body>

<%
    int id = 101;
    String name = "Ahmed";

    String result = concatIdName(id, name);
%>

<h1>Result of function:</h1>
<p><%= result %></p>

</body>
</html>

<%! 
    public String concatIdName(int i, String n) {
        return i + " - " + n;
    }
%>
