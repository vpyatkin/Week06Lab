<%-- 
    Document   : shoppingList
    Created on : Oct 15, 2022, 2:30:32 PM
    Author     : Vladik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        Hello, ${username} <a href="ShoppingList?action=logout">Logout</a>
        
        <h2>List</h2>
        <form method="get" action="ShoppingList"> 
            Add item: <input type="text" name="item" value=""> <button type="submit" name="action" value="add">Add</button>
        </form>
        
        <br>
        <form method="get" action="ShoppingList"> 
            <c:forEach items="${items}" var="item">
                <input type="radio" id="${item}" name="itemList" value="${item}">
                <label for="${item}">${item}</label><br>
            </c:forEach>
            <button name="action" value="delete" type="submit">Delete</button>
        </form>
    </body>
</html>
