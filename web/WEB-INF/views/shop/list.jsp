<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<spring:message code="label_name" var="labelName"/>
<spring:message code="label_edit" var="labelEdit"/>
<spring:message code="label_delete" var="labelDelete"/>
<spring:message code="label_add" var="labelAdd"/>
<spring:message code="label_title_page_shop" var="labelTitlePageShop"/>
<head>
    <title>${labelTitlePageShop}</title>
</head>
<body>

<table>
    <tr><th>id</th><th>${labelName}</th><th>employer_id</th></tr>
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
    <tr><td><a href="/shop/add">${labelAdd}</a></td></tr>
</table>

</body>
</html>
