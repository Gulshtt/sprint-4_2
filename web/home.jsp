<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Item" %><%--
  Created by IntelliJ IDEA.
  User: Kuat
  Date: 01.02.2024
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="col-8 mx-auto">
<%--    <form action="/add-item" method="post">--%>
<%--        <div class="mb-3">--%>
<%--            <label for="exampleInputName" class="form-label">NAME:</label>--%>
<%--            <input name="item_name" type="text" class="form-control" id="exampleInputName">--%>
<%--        </div>--%>
<%--        <div class="mb-3">--%>
<%--            <label for="exampleInputDescription" class="form-label">DESCRIPTION:</label>--%>
<%--            <input name="item_description" type="text" class="form-control" id="exampleInputDescription">--%>
<%--        </div>--%>
<%--        <div class="mb-3">--%>
<%--            <label for="exampleInputPrice" class="form-label">PRICE:</label>--%>
<%--            <input name="item_price" type="number" class="form-control" id="exampleInputPrice">--%>
<%--        </div>--%>
<%--        <button type="submit" class="btn btn-primary">ADD ITEM</button>--%>
<%--    </form>--%>
<%--    <table class="table table-striped">--%>
<%--        <thead>--%>
<%--        <th>ID</th>--%>
<%--        <th>NAME</th>--%>
<%--        <th>DESCRIPTION</th>--%>
<%--        <th>DETAILS</th>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <%--%>
<%--            List<Item> items = (List<Item>) request.getAttribute("tovary");--%>
<%--            for (Item item : items) {--%>
<%--        %>--%>
<%--        <tr>--%>
<%--            <td><%=item.getId()%></td>--%>
<%--            <td><%=item.getName()%></td>--%>
<%--            <td><%=item.getDescription()%></td>--%>
<%--            <td><%=item.getPrice()%></td>--%>
<%--        </tr>--%>
<%--        <%--%>
<%--            }--%>
<%--        %>--%>
<%--        </tbody>--%>
<%--    </table>--%>
    <div class="container mt-5">
        <h1 class="text-center">Welcome to shop</h1>
        <br>
        <div class="row">
        <%
            List<Item> items = (List<Item>) request.getAttribute("tovary");
            for (Item item : items) {
        %>
        <div class="col-md-4">
            <div class="card">
                <div class="card-body text-center">
                    <h4 class="card-title"><%=item.getName()%></h4>
                    <h5><b class="card-text text-success">$<%=item.getPrice()%></b></h5>
                    <p class="card-text"><%=item.getDescription()%></p>
                    <a href="#" class="btn btn-primary btn-block">Add to Cart</a>
                </div>
            </div>
        </div>
        <% } %>
        </div>
    </div>
</div>
</body>
</html>
