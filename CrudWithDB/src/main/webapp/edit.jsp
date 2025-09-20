<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.crud.User" %>
<% User user = (User) request.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f6f9;
        margin: 0;
        padding: 20px;
    }

    h1 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    /* Table styling */
    table {
        width: 80%;
        margin: auto;
        border-collapse: collapse;
        background: #fff;
        box-shadow: 0px 4px 12px rgba(0,0,0,0.1);
    }

    th, td {
        border: 1px solid #ddd;
        padding: 12px;
        text-align: center;
        font-size: 14px;
    }

    th {
        background: #007bff;
        color: white;
    }

    tr:nth-child(even) {
        background: #f9f9f9;
    }

    tr:hover {
        background: #f1f7ff;
    }

    /* Buttons */
    input[type="submit"] {
        background: #007bff;
        color: white;
        border: none;
        padding: 8px 12px;
        font-size: 14px;
        border-radius: 5px;
        cursor: pointer;
        margin: 2px;
        transition: 0.3s;
    }

    input[type="submit"]:hover {
        background: #0056b3;
    }

    /* Form container */
    .form-container {
        width: 400px;
        margin: 50px auto;
        background: #fff;
        padding: 25px;
        border-radius: 8px;
        box-shadow: 0px 4px 12px rgba(0,0,0,0.1);
    }

    label {
        display: block;
        margin-bottom: 6px;
        font-weight: bold;
        color: #333;
    }

    input[type="text"],
    input[type="email"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 14px;
    }

    .form-container input[type="submit"] {
        width: 100%;
        background: #28a745;
    }

    .form-container input[type="submit"]:hover {
        background: #218838;
    }
</style>


</head>
<body>
    <div class="form-container">
        <h1>Edit User</h1>
        <form action="UpdateServlet" method="post">
            <input type="hidden" name="id" value="<%= user.getId() %>" />

            <label>Name:</label>
            <input type="text" name="name" value="<%= user.getName() %>" required>

            <label>Email:</label>
            <input type="email" name="email" value="<%= user.getEmail() %>" required>

            <label>Password:</label>
            <input type="password" name="password" value="<%= user.getPassword() %>" required>

            <input type="submit" value="Update User">
        </form>
    </div>
</body>

</html>