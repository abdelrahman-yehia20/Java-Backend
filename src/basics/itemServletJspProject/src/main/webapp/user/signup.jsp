<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>

<style>

/* Reset */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

/* Background same as show-items */
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    min-height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

/* Glass container */
.signup-box {
    background: rgba(255, 255, 255, 0.95);
    padding: 40px;
    width: 420px;
    border-radius: 20px;
    box-shadow: 0 20px 60px rgba(0, 0, 0, 0.3);
    backdrop-filter: blur(10px);
    text-align: center;
    animation: fadeIn 0.6s ease;
}

/* Title */
.signup-box h2 {
    margin-bottom: 30px;
    font-size: 2rem;
    font-weight: 700;
    background: linear-gradient(45deg, #667eea, #764ba2);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
}

/* Inputs */
.signup-box input[type="text"],
.signup-box input[type="email"],
.signup-box input[type="password"] {
    width: 100%;
    padding: 12px 15px;
    margin-bottom: 18px;
    border-radius: 10px;
    border: 1px solid #ccc;
    font-size: 1rem;
    transition: 0.3s;
}

.signup-box input:focus {
    border-color: #667eea;
    outline: none;
    box-shadow: 0 0 10px rgba(102,126,234,0.3);
}

/* Button */
.signup-box button {
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

.signup-box button:hover {
    transform: translateY(-3px);
    box-shadow: 0 15px 35px rgba(102,126,234,0.6);
}

.signup-box button:active {
    transform: translateY(-1px);
}

/* Link */
.signup-box .login-link {
    margin-top: 20px;
    display: block;
    font-size: 0.9rem;
}

.signup-box .login-link a {
    text-decoration: none;
    font-weight: 600;
    color: #667eea;
}

/* Animation */
@keyframes fadeIn {
    from {
        opacity: 0;
        transform: translateY(30px);
    }
    to {
        opacity: 1;
        transform: translateY(0);
    }
}

/* Responsive */
@media (max-width: 480px) {
    .signup-box {
        width: 90%;
        padding: 25px;
    }
}

</style>

</head>
<body>

<div class="signup-box">
    <h2>Create Account</h2>

    <form action="/item-service-909/UserController" method="post">
        <input type="hidden" name="action" value="signup">

        <input type="text" name="name" placeholder="Enter your name" required>

        <input type="email" name="email" placeholder="Enter your email" required>

        <input type="password" name="password" placeholder="Enter your password" required>

        <button type="submit">Signup</button>
    </form>
    
    <% 
    String error = request.getParameter("error");
    if("Email already exists".equals(error)){
    	%>
    	<p style="color:red">Email already exists</p> 
    <% }
    %>

    <div class="login-link">
        Already have an account?
        <a href="login.jsp">Login</a>
    </div>

</div>

</body>
</html>
