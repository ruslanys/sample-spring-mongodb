<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Все контакты</title>
</head>
<body>
<img src="/resources/logo.png"><br/>
<table width="600px">
    <tr>
        <td><b>ID</b></td>
        <td><b>Name</b></td>
        <td><b>Number</b></td>
        <td><b>E-mail</b></td>
        <td><b>Action</b></td>
    </tr>
    <c:forEach var="contact" items="${contacts}">
        <tr>
            <td>${contact.id}</td>
            <td>${contact.name}</td>
            <td>${contact.number}</td>
            <td>${contact.email}</td>
            <td><a href="/edit?id=${contact.id}">Edit</a> | <a href="/delete?id=${contact.id}">Delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <a href="/add">Добавить запись</a>
        </td>
    </tr>
</table>
</body>
</html>
