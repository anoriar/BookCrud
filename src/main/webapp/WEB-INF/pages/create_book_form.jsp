<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Добавить новую книгу</title>
</head>
<body>
    <div align="center">
        <h1>Добавить новую книгу</h1>
        <form:form action="saveBook?action=create" method="post" modelAttribute="book">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Название:</td>
                <td><form:input path="title" /></td>
                <td><form:errors path="title" cssclass="error"></form:errors></td>
            </tr>
            <tr>
                <td>Описание:</td>
                <td><form:input path="description" /></td>
                <td><form:errors path="description" cssclass="error"></form:errors></td>
            </tr>
            <tr>
                <td>Автор:</td>
                <td><form:input path="author" /></td>
                <td><form:errors path="author" cssclass="error"></form:errors></td>
            </tr>
            <tr>
                <td>ISBN:</td>
                <td><form:input path="isbn" /></td>
                <td><form:errors path="isbn" cssclass="error"></form:errors></td>
            </tr>
            <tr>
                <td>Год издания:</td>
                <td><form:input path="printYear" /></td>
                <td><form:errors path="printYear" cssclass="error"></form:errors></td>
            </tr>
            <tr>
                <td><form:hidden path="readAlready" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Сохранить"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>