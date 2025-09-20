<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            padding-top: 100px;
        }

        h1 {
            color: #333;
        }

        .btn {
            display: inline-block;
            margin: 20px 10px;
            padding: 12px 24px;
            font-size: 16px;
            color: white;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <h1>Welcome to Employee Management System</h1>

    <a href="login.jsp" class="btn">Login</a>
    <a href="register.jsp" class="btn">Register</a>

</body>
</html>