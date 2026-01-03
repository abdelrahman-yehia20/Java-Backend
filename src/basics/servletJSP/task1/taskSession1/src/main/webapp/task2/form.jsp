<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Form</title>

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

.form-box {
    background-color: #ffffff;
    padding: 30px 35px;
    border-radius: 8px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    width: 360px;
}

.form-box h1 {
    text-align: center;
    margin-bottom: 20px;
    color: #333;
}

.form-box input[type="text"],
.form-box select {
    width: 100%;
    padding: 8px;
    margin-top: 5px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

.form-box input[type="radio"] {
    margin-right: 5px;
}

.form-box input[type="submit"] {
    width: 100%;
    margin-top: 20px;
    padding: 10px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    font-size: 15px;
    cursor: pointer;
}

.form-box input[type="submit"]:hover {
    background-color: #0056b3;
}
</style>

</head>
<body>

<div class="form-box">
<h1>User Information Form</h1>

<form action="display.jsp">
  Full Name:
  <input type="text" name="fullName"><br><br>

  Password:
  <input type="password" name="password"><br><br>

  Age:
  <input type="number" name="age" required><br><br>

  Address (Radio):<br>
  <input type="radio" name="addressRadio" value="Cairo"> Cairo<br>
  <input type="radio" name="addressRadio" value="Alex"> Alex<br>
  <input type="radio" name="addressRadio" value="Menofia"> Menofia<br><br>

  Address (Select):
  <select name="addressSelect">
    <option value="Cairo">Cairo</option>
    <option value="Alex">Alex</option>
    <option value="Menofia">Menofia</option>
  </select><br><br>

  <input type="submit" value="Submit">
</form>
</div>

</body>
</html>
