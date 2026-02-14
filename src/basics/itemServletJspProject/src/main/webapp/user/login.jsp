<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<style>

/* Reset */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

/* Background like show-items */
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    min-height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

/* Glass card container */
.login-box {
    background: rgba(255, 255, 255, 0.95);
    padding: 40px;
    width: 400px;
    border-radius: 20px;
    box-shadow: 0 20px 60px rgba(0, 0, 0, 0.3);
    backdrop-filter: blur(10px);
    text-align: center;
}

/* Title */
.login-box h2 {
    margin-bottom: 30px;
    font-size: 2rem;
    font-weight: 700;
    background: linear-gradient(45deg, #667eea, #764ba2);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
}

/* Input fields */
.login-box input[type="email"],
.login-box input[type="password"] {
    width: 100%;
    padding: 12px 15px;
    margin-bottom: 20px;
    border-radius: 10px;
    border: 1px solid #ccc;
    font-size: 1rem;
    transition: 0.3s;
}

.login-box input:focus {
    border-color: #667eea;
    outline: none;
    box-shadow: 0 0 10px rgba(102,126,234,0.3);
}

/* Button */
.login-box button {
    width: 100%;
    padding: 12px;
    border: none;
    border-radius: 25px;
    background: linear-gradient(45deg, #667eea, #764ba2);
    color: white;
    font-size: 1rem;
    font-weight: 600;
    cursor: pointer;
    transition: 0.3s;
    box-shadow: 0 10px 25px rgba(102,126,234,0.4);
}

.login-box button:hover {
    transform: translateY(-3px);
    box-shadow: 0 15px 35px rgba(102,126,234,0.6);
}

.login-box button:active {
    transform: translateY(-1px);
}

/* Responsive */
@media (max-width: 480px) {
    .login-box {
        width: 90%;
        padding: 25px;
    }
}

</style>

</head>
<body>

<div class="login-box">
    <h2>Login</h2>

    <form action="/item-service-909/UserController" method="post">
        <input type="hidden" name="action" value="login">

        <input type="email" name="email" placeholder="Enter your email" required>

        <input type="password" name="password" placeholder="Enter your password" required>

        <button type="submit">Login</button>
    </form>
    <%
    	String error =request.getParameter("error");
    	if("invalid".equals(error)){
    %>
    <p style="color:red"> invalid email or password</p>
     <%
    }
    	 %>
</div>

</body>
</html>
