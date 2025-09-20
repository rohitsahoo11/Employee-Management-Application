<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.crud.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All users details</title>
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
    <h1>All Users</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Actions</th>
        </tr>
        <%
        	List<User> users = (List<User>) request.getAttribute("userList");
        	if(users!=null){
        		for(User u:users){
        %>
        <tr>
            <td><%= u.getId() %></td>
            <td><%= u.getName() %></td>
            <td><%= u.getEmail() %></td>
            <td><%= u.getPassword() %></td>
            <td>
                <form action="EditUserServlet" method="get" style="display:inline;">
                    <input type="hidden" name="id" value="<%= u.getId() %>">
                    <input type="submit" value="Edit">
                </form>
                <form action="DeleteUserServlet" method="get" style="display:inline;">
                    <input type="hidden" name="id" value="<%= u.getId() %>">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
        <% 
        		}
        	}
        %>
    </table>
</body>
</html>