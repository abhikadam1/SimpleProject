<%-- home.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${pageTitle}</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        h1 { color: #333; }
        .message { border: 1px solid #ccc; padding: 15px; background-color: #f9f9f9; }
    </style>
</head>
<body>

    <h1>Welcome to the JSP Home Page!</h1>

    <%-- 1. Displaying a simple variable passed from the Controller --%>
    <div class="message">
        <p>Your Greeting Message:</p>
        <%-- The value of the 'greeting' attribute from the Model is accessed directly --%>
        <strong>${greeting}</strong>
    </div>

    <%-- 2. Conditional Logic using JSTL (Jakarta Tag Library) --%>
    <p>Current Time: ${currentTime}</p>

    <c:choose>
        <c:when test="${isLoggedIn == true}">
            <p style="color: green;">You are currently logged in.</p>
        </c:when>
        <c:otherwise>
            <p style="color: red;">Please log in to continue.</p>
        </c:otherwise>
    </c:choose>

    <p><a href="/data">Go to Data Page</a></p>

</body>
</html>