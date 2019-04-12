<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 06.04.2019
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Products</title>
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
    <form action="${pageContext.request.contextPath}/addProduct" method="post">
        <h1 class="display-5">New product</h1>
        <div class="form-group">
            <input class="form-control" style="width:30ex" placeholder="Enter product's name" type="text" name="name"/>
        </div>
        <div class="form-group">
            <input class="form-control" style="width:30ex" placeholder="Enter description" type="text"
                   name="description"/>
        </div>
        <div class="form-group">
            <input class="form-control" style="width:30ex" placeholder="Enter category" type="text" name="categories"/>
        </div>
        <div class="form-group">
            <input class="form-control" style="width:30ex" placeholder="Enter price" type="text" name="price"/>
        </div>
        <form>
            <div class="form-group">
                <label for="exampleFormControlFile1">Example file input</label>
                <input type="file" class="form-control-file" id="exampleFormControlFile1">
            </div>
        </form>
        <div class="custom-file">
            <input type="file" class="custom-file-input" id="customFile">
            <label class="custom-file-label" for="customFile">Choose file</label>
        </div>
        <div style="position: absolute; right: 295px">
            <input class="btn btn-primary" type="submit" name="submit" value="Add product"/>
        </div>
    </form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
