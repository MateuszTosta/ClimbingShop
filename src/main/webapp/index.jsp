<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<table class="table table-dark table-bordered" align="center" style="width: 80ex">
    <hr width="800px">
    <link rel="stylesheet" href="style.css">
    <style>
        body {
            background-image: url("https://images.pexels.com/photos/540518/pexels-photo-540518.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
            background-size: cover;
        }
    </style>
    <jsp:include page="header.jsp"/>

    <div align="center">
        <form action="${pageContext.request.contextPath}/home" method="get">
            <h5 class="display-5">wyszukaj produkt</h5>
            <div class="form-group">
                <input class="form-control" style="width:30ex" type="text" name="category"
                       placeholder="Enter category"/>
            </div>
            <div class="form-group">
                <input class="form-control" style="width:30ex" type="text" name="name"
                       placeholder="Enter product's name"/>
            </div>
            <p>
                <input class="btn btn-primary" type="submit" name="submit" value="Wyślij"/>
            </p>
        </form>
    </div>
    <ul class="list-group">
        <c:forEach items="${products}" var="product">
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
        </c:forEach>
    </ul>

    <table class="table table-dark rounded-lg" align="center" style="width: 40ex">
        <tbody>
        <tr>
            <td>
                <img src="/climbing-introduction-get-started-1000x500.jpg" class="rounded-lg">
            </td>
        </tr>
        </tbody>
    </table>


    <table class="table table-dark rounded-lg" align="center" style="width: 100ex">
        <tbody>
        <tr>

            <td class="whiteColour">
                <div align="right">
                    <h4 class="whiteColour" align="center">Ostatnio oglądane</h4>
                </div>
            </td>
            <td class="whiteColour">
                <div style="position: absolute; right: 225px">
                    <img width="300px" height="280px"
                         src="${advertisement}" class="rounded-lg">
                </div>
            </td>

        </tr>
        </tbody>
    </table>
    <br>
    <%--<div style="position: absolute; right: 225px">--%>
    <%--    <img style="box-shadow: 3px 3px 10px white, darkred -3px 3px 10px, 3px -3px 10px" width="300px" height="280px"--%>
    <%--         src="${advertisement}">--%>
    <%--</div>--%>
    <jsp:include page="footer.jsp"/>
</body>
</html>
