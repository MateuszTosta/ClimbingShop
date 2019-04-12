<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 06.04.2019
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ViewUser</title>
</head>
<body>
<style>
    body {
        background-image: url("https://images.pexels.com/photos/540518/pexels-photo-540518.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        background-size: cover;
    }
</style>
<jsp:include page="header.jsp"/>
<ul class="list-group">
    <c:choose>
        <c:when test="${user.isPresent()}">
            <c:set var="user" value="${user.get()}"/>
            <div align="center">
                <h1>
                    <li class="list-group-item active"><b>New User</b></li>
                </h1>
                <li class="list-group-item"><p>Login: ${user.getLogin()}</li>
                </p>
                <li class="list-group-item"><p>Email: ${user.getEmail()}</li>
                </p>
            </div>
        </c:when>
        <c:otherwise>
            A
        </c:otherwise>
    </c:choose>
</ul>
<jsp:include page="footer.jsp"/>
</body>
</html>
