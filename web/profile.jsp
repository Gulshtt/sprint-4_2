<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: David
  Date: 24.02.2024
  Time: 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<%
    User user = (User) request.getAttribute("user");
    if (user == null) {
%>
    ERORR
<%
    } else {
%>
    <h1 class="text-center">Hello <%=user.getFullName()%></h1>
    <p class="text-center">This is partner page</p>
<%
    }
%>
</body>
</html>
