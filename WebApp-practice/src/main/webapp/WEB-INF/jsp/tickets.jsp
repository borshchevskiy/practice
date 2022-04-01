<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty requestScope.tickets}">
    <h1>Купленные билеты на рейс ${requestScope.flightId}</h1>
    <ul>
        <c:forEach var="ticket" items="${requestScope.tickets}">
            <li>${fn:toUpperCase(ticket.seatNo)}</li>
        </c:forEach>
    </ul>
</c:if>
</body>
</html>
