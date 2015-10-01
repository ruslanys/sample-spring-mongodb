<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить контакт</title>
</head>
<body>
<form:form method="POST" action="/add" modelAttribute="contact">
    <form:hidden path="id" />
    <table>
        <tr>
            <td>Name:</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>Number:</td>
            <td><form:input path="number" /></td>
        </tr>
        <tr>
            <td>E-mail:</td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
