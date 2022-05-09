<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body>
<h2>Dear Employee, please, enter your details</h2>
<br>
<br>
<form:form action="showDetails" modelAttribute="employee">

    Name <form:input path="firstName"/><form:errors path="firstName"/>
    <br><br>
    Surname <form:input path="surname"/><form:errors path="surname"/>
    <br><br>
    Salary <form:input path="salary"/>
    <br><br>
    Department<form:select path="department">
    <form:options items="${departments}"/>
    </form:select>
    <br><br>

    Which car do you want?
    <br><br>
    <c:forEach items="${carBrands}" var="carBrand">
        <form:radiobutton path="carBrand" value="${carBrand}" label="${carBrand.displayName}"/>
    </c:forEach>
    <%--
    <form:radiobuttons path="carBrand" items="${carBrands}" itemLabel="displayName"/>
    --%>
    <br><br>
    Foreign languages?
    <form:checkboxes path="languages" items="${languages}"/>
    <br><br>
    Phone <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
    <br><br>
    <input type="submit" value="OK"/>

</form:form>

</body>
</html>
