<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:message code="label_name" var="labelName"/>

<h2>Shop</h2>
<form:form method = "POST" modelAttribute="shopOne" action = "/shop/save">
    <table>
        <tr>
            <td><form:input path = "id" value="${shopOne.id}" /></td>
        </tr>
        <tr>
            <td><form:input path = "name" value="${shopOne.name}" /></td>
        </tr>

        <tr>
            <td><form:input path = "emplNumber" value="${shopOne.emplNumber}"/></td>
        </tr>

        <tr>
            <td colspan = "2">
                <input type = "submit" value = "Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
