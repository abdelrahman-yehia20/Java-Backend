<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Order</title>

<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f6f8;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

form {
    background-color: #ffffff;
    padding: 25px 30px;
    border-radius: 8px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    width: 320px;
}

form input[type="text"] {
    width: 100%;
    padding: 8px;
    margin-top: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

form input[type="submit"] {
    width: 100%;
    margin-top: 15px;
    padding: 10px;
    background-color: #28a745;
    color: white;
    border: none;
    border-radius: 4px;
    font-size: 15px;
    cursor: pointer;
}

form input[type="submit"]:hover {
    background-color: #218838;
}
</style>

</head>
<body>

<form action="allOrder.jsp">
    please write order:
    <input type="text" name="order">
    <br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
