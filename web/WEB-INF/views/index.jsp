<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
    <meta name="autor" content="">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">

    <title>Spring Security</title>
    <spring:theme code="styleSheetBootstrap" var="bootstrap_css"/>
    <spring:theme code="styleSheetJumbotron" var="jumbotron_css"/>
    <spring:url value="/${bootstrap_css}" var="bootstrap_css_url"/>
    <link rel="stylesheet" type="text/css" media="screen" href="${bootstrap_css_url}"/>
    <link rel="stylesheet" type="text/css" media="screen" href="${jumbotron_css}"/>
</head>
<body>
<div class="container">
    <p class="jumbotron" style="margin-top: 20px;">
    <h1>Devcolibri.com!</h1>
    <p class="lead"></p>
    <sec:authorize access="!isAuthenticated()">
        <p><a class="btn btn-lg btn-success" href="<c:url value="/login/loginIn"/>" role="button">Войти</a></p>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <p>Ваш логин:<sec:authentication property="principal.username"/></p>
        <sec:authentication property="principal.authorities" var="roles"/>
        Ваши привилегии:
        <c:forEach var="role" items="${roles}">
            ${role}:
        </c:forEach>

        <p><a class="btn btn-lg btn-danger" href="<c:url value="/login/loginOut"/>" role="button">Выйти</a></p>
    </sec:authorize>
</div>
<div class="footer">
    <p>@Sa</p>
</div>
</div>
</body>

</html>
