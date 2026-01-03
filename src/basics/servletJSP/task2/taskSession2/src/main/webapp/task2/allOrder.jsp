<%@page import="java.util.List"%>
<%@page import="java.util.Objects"%>
<%@page import="java.util.ArrayList"%>
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
	List<String> allOrdersSelected= (List<String>)session.getAttribute("allOrders");
	
	if(Objects.isNull(allOrdersSelected)){
		allOrdersSelected = new ArrayList();
		session.setAttribute("allOrders", allOrdersSelected);
	}
	String selectedOrder = request.getParameter("order");
	if(Objects.nonNull(selectedOrder)){
		allOrdersSelected.add(selectedOrder);
	}
	
%>

		<div class="result-box">
		    Selected order is: <span>${param.order}</span>
		    <%
		    if(!allOrdersSelected.isEmpty()){
		    	for(String order : allOrdersSelected){
		    		out.print("<h1>" + order + "</h1>");
		    	}
		    }else{
				out.print("<h1> no order selected </h1>");
		    }		
		    	%>
		</div>

</body>
</html>