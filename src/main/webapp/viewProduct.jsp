<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 06.04.2019
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Product</title>
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
    <c:when test="${product.isPresent()}">
    <c:set var="product" value="${product.get()}"/>
    <table class="table table-dark table-bordered" align="center" style="width: 80ex">
        <table class="table table-dark rounded-lg" align="center" style="width: 100ex">
            <thead>
            <tr align="center">

                <th scope="col"></th>
                <th scope="col" class="whiteColour">Nazwa</th>
                <th scope="col" class="whiteColour">Opis</th>
                <th scope="col" class="whiteColour">Kategoria</th>
                <th scope="col" class="whiteColour">Cena</th>

            </tr>
            </thead>
            <tbody>
            <tr align="center">

                <td class="whiteColour"><img width="200px" height="200px" src="${product.getImage()}"
                                             class="rounded-lg"/></td>
                <td class="whiteColour"><p>
                    <a href="/viewProduct?id=${product.getId()}">${product.getName()}</a></p>
                </td>
                <td class="whiteColour"><p>${product.getDescription()}</p></td>
                <td class="whiteColour"><p>${product.getCategories()}</p></td>
                <td class="whiteColour"><p>${product.getPrice()}</p></td>

            </tr>
            </tbody>
        </table>
        </c:when>
        <c:otherwise>
        There's no product!
        </c:otherwise>
        </c:choose>
</ul>
<jsp:include page="footer.jsp"/>
</body>
</html>
