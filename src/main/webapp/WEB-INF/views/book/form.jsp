<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 30.10.2022
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    Tytuł: <form:input path="title"/><br>
    Ocena: <form:input path="rating" type="number"/><br>
    Wydawca <form:select path="publisher">
        <form:option value="0">Wybierz wydawcę</form:option>
        <form:options items="${publisherList}" itemValue="id" itemLabel="name"/>
    </form:select>
    <input type="submit" value="Wyślij"/>
</form:form>
</body>
</html>
