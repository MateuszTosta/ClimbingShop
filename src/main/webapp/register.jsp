<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 06.04.2019
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>Register</title>
</head>
<body>
<style>
    body {
        background-image: url("https://images.pexels.com/photos/540518/pexels-photo-540518.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        background-size: cover;
    }
</style>
<jsp:include page="header.jsp"/>
<div align="center">
    <form action="${pageContext.request.contextPath}/register" method="post">
        <h4 class="display-5">Rejestracja</h4>
        <div class="form-group">
            <input class="form-control" style="width:30ex" placeholder="Enter login" type="text" name="login"/>
        </div>
        <div class="form-group">
            <input class="form-control" style="width:30ex" placeholder="Enter password" type="password"
                   name="password"/>
        </div>
        <div class="form-group">
            <input class="form-control" style="width:30ex" placeholder="Enter email" type="text" name="email"/>
        </div>
        <p>
            <input class="btn btn-primary" type="submit" name="submit" value="Zarejesrtuj"/>
        </p>
    </form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
