<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info</title>

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

.info-box {
    background-color: #ffffff;
    padding: 30px 35px;
    border-radius: 8px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    width: 400px;
}

.info-box h1 {
    margin: 10px 0;
    font-size: 18px;
    color: #333;
}

.info-box span {
    color: #007bff;
    font-weight: bold;
}
</style>

</head>
<body>

<div class="info-box">
    <h1>Full name: <span>${param.fullName}</span></h1>
    <h1>Password: <span>${param.password}</span></h1>
    <h1>Age: <span>${param.age}</span></h1>
    <h1>Address (Radio): <span>${param.addressRadio}</span></h1>
    <h1>Address (Select): <span>${param.addressSelect}</span></h1>
</div>

</body>
</html>
