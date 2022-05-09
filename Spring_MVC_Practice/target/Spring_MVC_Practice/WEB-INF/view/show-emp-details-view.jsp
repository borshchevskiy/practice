<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Dear employee, you are welcome</h2>
<br>
<br>
<br>

Your name: ${employee.firstName}
<br>
Your surname: ${employee.surname}
<br>
Your salary: ${employee.salary}
<br>
Your department: ${employee.department.displayName}
<br>
Your car: ${employee.carBrand.name}
<br>
Your language(s):
<ul>
    <c:forEach var="lang" items="${employee.languages}">
        <li>
            ${lang}
        </li>
    </c:forEach>
</ul>
<br>
Phone number: ${employee.phoneNumber}

</body>
</html>
