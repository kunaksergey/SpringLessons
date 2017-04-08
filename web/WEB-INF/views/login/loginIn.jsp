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
    <spring:message code="label_enter" var="label_enter"/>
    <spring:theme code="styleSheetBootstrap" var="bootstrapCss"/>
    <spring:url value="/${bootstrapCss}" var="bootstrapCssUrl"/>
    <link rel="stylesheet" type="text/css" media="screen" href="${bootstrapCssUrl}"/>

    <title>Spring Security Login</title>
</head>
<body>
<div class="content" style="width: 300px;">
    <c:url value="/j_spring_security_check" var="loginUrl"/> <!--Путь к фильтру аунтификации-->
    <form action="${loginUrl}" method="post">
        <h2 class="form-signin-heading">${label_enter}</h2>
        <input type="text" class="form-control" name="j_username" placeholder="Email address" required autofocus value="sa">
        <input type="text" class="form-control" name="j_password" placeholder="password" required  value="1234">
        <input type="checkbox" id="remember_me" name="_spring_security_remember_me"/>
        <label for="remember_me" class="inline">Remember me</label>
        <button class="btn btn-primary btn-block">${label_enter}</button>
    </form>
</div>
</body>
</html>
