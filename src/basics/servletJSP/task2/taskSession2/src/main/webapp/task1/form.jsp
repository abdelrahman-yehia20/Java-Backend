<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>

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

.result {
    background-color: #ffffff;
    padding: 30px 40px;
    border-radius: 8px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    text-align: center;
}

.result h1 {
    margin: 10px 0;
    color: #333;
}

.result span {
    color: #007bff;
    font-weight: bold;
}
</style>

</head>
<body>

<div class="result">
    <h1>Full Name: <span>${param.fullName}</span></h1>
    <h1>Age: <span>${param.age}</span></h1>
</div>

</body>
</html>
