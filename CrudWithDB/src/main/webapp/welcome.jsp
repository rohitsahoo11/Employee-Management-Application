<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f6f9;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background: #fff;
        padding: 25px 30px;
        border-radius: 10px;
        box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.15);
        width: 350px;
        text-align: center;
    }

    h2 {
        margin-bottom: 20px;
        color: #333;
    }

    input[type="text"],
    input[type="email"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 8px 0;
        border: 1px solid #ccc;
        border-radius: 6px;
        outline: none;
        font-size: 14px;
    }

    input[type="submit"] {
        width: 100%;
        background: #007bff;
        color: white;
        border: none;
        padding: 12px;
        font-size: 16px;
        border-radius: 6px;
        cursor: pointer;
        transition: 0.3s;
    }

    input[type="submit"]:hover {
        background: #0056b3;
    }

    a {
        text-decoration: none;
        color: #007bff;
        font-size: 14px;
    }

    a:hover {
        text-decoration: underline;
    }

    p.error {
        color: red;
        margin-top: 10px;
    }
</style>

</head>
<body>
	<div class="container">
        <h2>Welcome, ${name}</h2>
        <p>You have successfully logged in!</p>
        <br>
        <a href="UsersListServlet">See All Users</a> | 
        <a href="login.jsp">Logout</a>
    </div>
	
</body>
</html>