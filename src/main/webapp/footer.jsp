<%@ page import="java.time.LocalDate" %>
<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 30.03.2019
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>Footer</title>
</head>
<body>
<p><%! private int visitCounter = 1; %></p>
<p class="whiteColour">Visitors: <%=visitCounter++%>
</p>

<p class="whiteColour">Created by Mateusz Tosta, <%=LocalDate.now()%>
</p>
</body>
</html>
