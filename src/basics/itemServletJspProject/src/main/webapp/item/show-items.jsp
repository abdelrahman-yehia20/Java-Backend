<%@page import="item.model.ItemDetails"%>
<%@page import="item.model.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Items</title>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <style type="text/css">
    
    /* Reset and base styles */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    min-height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 20px;
}

/* Layer container */
.layer {
    background: rgba(255, 255, 255, 0.95);
    border-radius: 20px;
    box-shadow: 0 20px 60px rgba(0, 0, 0, 0.3);
    padding: 40px;
    max-width: 1200px;
    width: 100%;
    backdrop-filter: blur(10px);
    border: 1px solid rgba(255, 255, 255, 0.2);
}

/* Table heading */
h1 {
    text-align: center;
    color: #333;
    margin-bottom: 30px;
    font-size: 2.8rem;
    font-weight: 700;
    background: linear-gradient(45deg, #667eea, #764ba2);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    text-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

/* Table styles */
table {
    width: 100%;
    border-collapse: separate;
    border-spacing: 0;
    margin-bottom: 40px;
    overflow: hidden;
    border-radius: 15px;
    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
}

/* Table header */
thead {
    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
}

thead tr th {
    color: white;
    font-weight: 600;
    text-transform: uppercase;
    letter-spacing: 1px;
    font-size: 0.95rem;
    padding: 20px 15px;
    text-align: left;
    border-bottom: none;
}

/* Table body */
tbody tr {
    transition: all 0.3s ease;
    border-bottom: 1px solid rgba(0, 0, 0, 0.05);
}

tbody tr:nth-child(even) {
    background-color: rgba(102, 126, 234, 0.05);
}

tbody tr:hover {
    background-color: rgba(102, 126, 234, 0.1);
    transform: translateY(-2px);
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
}

tbody td {
    padding: 18px 15px;
    color: #555;
    font-size: 0.95rem;
    border-bottom: 1px solid rgba(0, 0, 0, 0.05);
}

tbody td:first-child {
    border-left: 4px solid transparent;
    transition: border-left-color 0.3s ease;
}

tbody tr:hover td:first-child {
    border-left-color: #667eea;
}

/* Strong text in first column */
td strong {
    color: #333;
    font-weight: 600;
    font-size: 1rem;
}

/* Action buttons */
td a {
    display: inline-block;
    padding: 8px 18px;
    margin-right: 10px;
    border-radius: 25px;
    text-decoration: none;
    font-weight: 500;
    font-size: 0.9rem;
    transition: all 0.3s ease;
    cursor: pointer;
    text-transform: uppercase;
    letter-spacing: 0.5px;
}

/* Update button */
td a:first-child {
    background: linear-gradient(45deg, #4CAF50, #8BC34A);
    color: white;
    box-shadow: 0 4px 15px rgba(76, 175, 80, 0.3);
}

td a:first-child:hover {
    transform: translateY(-2px);
    box-shadow: 0 6px 20px rgba(76, 175, 80, 0.4);
}

/* Delete button */
td a:last-child {
    background: linear-gradient(45deg, #f44336, #FF9800);
    color: white;
    box-shadow: 0 4px 15px rgba(244, 67, 54, 0.3);
}


td a:last-child:hover {
    transform: translateY(-2px);
    box-shadow: 0 6px 20px rgba(244, 67, 54, 0.4);
}

/* Red Delete Details button */
td a.redColor {
    background: rgba(255, 0, 0, 0.75) !important; /* override gradient */
    color: white !important;
    box-shadow: 0 4px 15px rgba(255, 0, 0, 0.3) !important;
    border-radius: 25px;
    padding: 8px 18px;
    text-decoration: none;
    display: inline-block;
    font-weight: 500;
    font-size: 0.9rem;
    transition: all 0.3s ease;
}

td a.redColor:hover {
    transform: translateY(-2px);
    box-shadow: 0 6px 20px rgba(255, 0, 0, 0.4) !important;
}


/* Add button */
.f {
    display: block;
    margin: 0 auto;
    padding: 0;
    border: none;
    background: none;
    cursor: pointer;
}

.f a {
    display: inline-block;
    padding: 18px 40px;
    background: linear-gradient(45deg, #667eea, #764ba2);
    color: white;
    text-decoration: none;
    border-radius: 50px;
    font-weight: 600;
    font-size: 1.1rem;
    text-transform: uppercase;
    letter-spacing: 1px;
    box-shadow: 0 10px 30px rgba(102, 126, 234, 0.4);
    transition: all 0.3s ease;
}

.f a:hover {
    transform: translateY(-3px);
    box-shadow: 0 15px 40px rgba(102, 126, 234, 0.6);
}

.f a:active {
    transform: translateY(-1px);
}

.logout{
    padding: 18px 40px;
    background: linear-gradient(45deg, #FF0000, #8B0001);
    color: white;
    border-radius: 50px;
    font-weight: 600;
    font-size: 1.1rem;
    letter-spacing: 1px;

}

/* Responsive design */
@media (max-width: 768px) {
    .layer {
        padding: 20px;
        margin: 10px;
    }
    
    h1 {
        font-size: 2rem;
        margin-bottom: 20px;
    }
    
    table {
        display: block;
        overflow-x: auto;
    }
    
    thead tr th,
    tbody td {
        padding: 12px 8px;
        font-size: 0.9rem;
    }
    
    td a {
        padding: 6px 12px;
        font-size: 0.8rem;
        margin-bottom: 5px;
        display: block;
        width: fit-content;
    }
    
    
    .f a {
        padding: 15px 30px;
        font-size: 1rem;
    }
}

/* Animation for table rows */
@keyframes fadeIn {
    from {
        opacity: 0;
        transform: translateY(20px);
    }
    to {
        opacity: 1;
        transform: translateY(0);
    }
}

tbody tr {
    animation: fadeIn 0.5s ease forwards;
}

tbody tr:nth-child(1) { animation-delay: 0.1s; }
tbody tr:nth-child(2) { animation-delay: 0.2s; }
tbody tr:nth-child(3) { animation-delay: 0.3s; }
tbody tr:nth-child(n+4) { animation-delay: 0.4s; }

/* Scrollbar styling */
::-webkit-scrollbar {
    width: 8px;
    height: 8px;
}

::-webkit-scrollbar-track {
    background: rgba(0, 0, 0, 0.05);
    border-radius: 10px;
}

::-webkit-scrollbar-thumb {
    background: linear-gradient(45deg, #667eea, #764ba2);
    border-radius: 10px;
}
    </style>
</head>
<body>
<div class="layer">

	<%
	if(session.getAttribute("loggedUser") == null){
	    response.sendRedirect("login.jsp");
	    return;
	}
	%>

	<%
	if(session.getAttribute("loggedUser") != null){
	%>
	<form action="UserController" method="post">
	    <input type="hidden" name="action" value="logout"/>
	    <button class="logout" type="submit">Logout</button>
	</form>
	<%
	}
	%>

    <table>
        <h1>Items</h1>
        <thead>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>PRICE</th>
            <th>TOTAL_NUMBER</th>
            <th>DESCRIPTION</th>
			<th>ISSUE DATE</th>
			<th>EXPIRY DATE</th>
			<th>Test</th>
			<th>Action</th>
            
        </tr>
        </thead>
        <tbody>
        <%
        	List<Item> items = (List<Item>) request.getAttribute("allItems");
        
        	for(Item item : items){
        %>
	        <tr>
	            <td><%=item.getId() %></td>
	            <td><%=item.getName() %></td>
	            <td><%=item.getPrice() %></td>
	            <td><%=item.getTotalNumber() %></td>
	            <%
					ItemDetails details = item.getItemDetails();
					%>
					
					<td><%= details != null ? details.getDescription() : "" %></td>
					<td><%= details != null && details.getIssueDate() != null ? details.getIssueDate() : "" %></td>
					<td><%= details != null && details.getExpiryDate() != null ? details.getExpiryDate() : "" %></td>
	            <td>
	            <% if(item.getItemDetails() == null) {%>
	            <a href="/item-service-909/ItemDetailsController?action=add-form&id=<%=item.getId()%>">
	            	Add Details
	            </a>
	            <%}else{%>
	            <a class="redColor" href="/item-service-909/ItemDetailsController?action=delete&id=<%=item.getId()%>">
	            	Delete Details
	            </a>
	            
	            <%}  %></td>
	            <td>
	                <a href="/item-service-909/ItemController?action=show-item&id=<%=item.getId()%>">Update</a>
	                <a href="/item-service-909/ItemController?action=remove-item&id=<%=item.getId()%>">Delete</a>
	            </td>
	        </tr>
        <% } %>
        
        </tbody>
    </table>


    <button class="f"><a href="./item/add-item.html" >Add Item</a></button>

</div>

	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script>
const params = new URLSearchParams(window.location.search);

switch(params.get("success")) {
    case "added":
        Swal.fire({ icon: 'success', title: 'Item added successfully', showConfirmButton: false, timer: 1500 });
        break;
    case "nameExist":
        Swal.fire({ icon: 'error', title: 'name already exists successfully', showConfirmButton: false, timer: 1500 });
        break;
    case "updated":
        Swal.fire({ icon: 'success', title: 'Item updated successfully', showConfirmButton: false, timer: 1500 });
        break;
    case "removed":
        Swal.fire({ icon: 'success', title: 'Item removed successfully', showConfirmButton: false, timer: 1500 });
        break;
    case "failed":
        Swal.fire({ icon: 'error', title: 'Operation failed', showConfirmButton: true });
        break;
}
</script>


</body>
</html>