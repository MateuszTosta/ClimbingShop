<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.sda.tosta.servlet.DAO.User" %>
<%@ page import="com.sda.tosta.servlet.User.Roles" %>
<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 30.03.2019
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<html>
<head>
    <title>Header</title>
</head>
<body>
<link rel="stylesheet" href="style.css">
<div>

    <div align="center" style="float:bottom;">
        <h3 class="display-1">Climbing Shop</h3>
        <br>
        <hr width="800px">
        <%
            User loggedUser = (User) session.getAttribute("loggedUser");
            if (loggedUser == null) {
        %>
        <a href="${pageContext.request.contextPath}/home">
            <button type="button" class="btn btn-primary">Home</button>
        </a>
        <%
            User logUser = (User) session.getAttribute("loggedUser");
            if (logUser != null && logUser.getRoles().contains(Roles.ADMIN)) {
        %>
        <a href="${pageContext.request.contextPath}/addProduct">
            <button type="button" class="btn btn-success">Add Product</button>
        </a>
        <a href="${pageContext.request.contextPath}/deleteProduct">
            <button type="button" class="btn btn-success">Delete product</button>
        </a>
        <%
            } %>
        <a href="${pageContext.request.contextPath}/login">
            <button type="button" class="btn btn-info">Sign in</button>
        </a>
        <a href="${pageContext.request.contextPath}/register">
            <button type="button" class="btn btn-info">Registry</button>
        </a>
        <a href="${pageContext.request.contextPath}/allProducts">
            <button type="button" class="btn btn-info">Show all products</button>
        </a>
        <div>
            <p>
                <%
                } else {
                    out.println(String.format("Witaj %s", loggedUser.getLogin() + "!"));
                %>
            </p>
        </div>
        <div align="center">
            <a href="${pageContext.request.contextPath}/logout">
                <button type="button" class="btn btn-info">Logout</button>
            </a>
        </div>
        <%
            }
        %>

    </div>
</div>
</div>
<div align="center">
    <p>


    </p>
</div>
</body>
</html>
