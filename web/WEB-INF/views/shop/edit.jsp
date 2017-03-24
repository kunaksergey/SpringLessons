<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<spring:message code="label_title_page_shopEdit" var="labelTitlePageShopEdit"/>
<spring:message code="label_add" var="labelAdd"/>
<head>
    <title>${labelTitlePageShopEdit}</title>
    <spring:theme code="styleSheet" var="app_css"/>
    <spring:url value="/${app_css}" var="app_css_url"/>
    <link rel="stylesheet" type="text/css" media="screen" href="${app_css_url}"/>
</head>
<body>
<spring:message code="label_name" var="labelName"/>

<h2>Shop</h2>
<form:form method = "POST" modelAttribute="shopOne" action = "/shop/save">
    <table>
        <tr>
            <td><form:label path = "id">${shopOne.id}</form:label>  </td>
        </tr>
        <tr>
            <td><form:input path = "name" value="${shopOne.name}" /></td>
        </tr>

        <tr>
            <td><form:input path = "emplNumber" value="${shopOne.emplNumber}"/></td>
        </tr>

        <tr>
            <td colspan = "2">
                <input type = "submit" value = "${labelAdd}"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
