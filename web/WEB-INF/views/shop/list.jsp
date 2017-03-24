<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<spring:message code="label_name" var="labelName"/>
<spring:message code="label_edit" var="labelEdit"/>
<spring:message code="label_delete" var="labelDelete"/>
<spring:message code="label_add" var="labelAdd"/>
<spring:message code="label_title_page_shopList" var="labelTitlePageShopList"/>
<head>
    <title>${labelTitlePageShopList}</title>
     <spring:theme code="styleSheet" var="app_css"/>
     <spring:url value="/${app_css}" var="app_css_url"/>
     <link rel="stylesheet" type="text/css" media="screen" href="${app_css_url}"/>
</head>
<body>

<table>
    <tr>
        <th>ID</th>
        <th>${labelName}</th>
        <th>employer_id</th>
        <th colspan="2"></th>
    </tr>
    <tbody>

<c:forEach items="${shopList}" var="shop">
    <tr>
        <td>${shop.id}</td>
        <td>${shop.name}</td>
        <td>${shop.emplNumber}</td>
        <td><a href="/shop/edit?id=${shop.id}">${labelEdit}</a></td>
        <td><a href="/shop/delete?id=${shop.id}">${labelDelete}</a></td>
    </tr>
</c:forEach>
    </tbody>
    <tr><td colspan="2"><a href="/shop/add">${labelAdd}</a></td></tr>
</table>

</body>
</html>
