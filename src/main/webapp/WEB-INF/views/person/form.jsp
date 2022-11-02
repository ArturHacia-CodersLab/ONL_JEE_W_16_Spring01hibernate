<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 30.10.2022
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<form method="POST">--%>
<%--    <label>--%>
<%--        Podaj login:--%>
<%--        <input type="text" name="login" placeholder="Login"/>--%>
<%--    </label>--%>
<%--    <label>--%>
<%--        Podaj email:--%>
<%--        <input type="email" name="email" placeholder="example@gmail.com"/>--%>
<%--    </label>--%>
<%--    <label>--%>
<%--        Podaj hasło:--%>
<%--        <input type="password" name="password" placeholder="Password"/>--%>
<%--    </label>--%>
<%--    <label><input type="submit" value="Zapisz"></label>--%>
<%--</form>--%>
<form:form method="post" modelAttribute="person">
    <label>
        Podaj login:
        <form:input path="login"/>
    </label>
    <label>
        Podaj email:
        <form:input path="email"/>
    </label>
    <label>
        Podaj hasło:
        <form:password path="password"/>
    </label>
    <label><input type="submit" value="Zapisz"></label>
</form:form>
</body>
</html>
