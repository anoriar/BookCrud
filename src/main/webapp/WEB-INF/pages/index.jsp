<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management Screen</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css"
    rel="stylesheet">
</head>
<body>
	<div align="center">
		<form:form action="searchBook" method="post" modelAttribute="search">
			<table>
				<tr>
					<td>Название:</td>
					<td><form:input path="searchStr" /><input type="submit" value="Поиск"></td>
				</tr>
			</table>
		</form:form>
		<h1>Список книг</h1>
		
		<table class="bordered" cellspacing="0">

			<th>Название</th>
			<th>Описание</th>
			<th>Автор</th>
			<th>isbn</th>
			<th>Год издания</th>
            <th>Прочитано</th>

			<c:forEach var="book" items="${bookList}">
				<tr>

					<td>${book.title}</td>
					<td>${book.description}</td>
					<td>${book.author}</td>
					<td>${book.isbn}</td>
					<td>${book.printYear}</td>
					<td>${book.readAlready}</td>

					<td>
                        <a href="readBook?id=${book.id}">Прочитать</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="editBook?id=${book.id}">Заменить на новое издание</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deleteBook?id=${book.id}">Удалить</a>
                    </td>

				</tr>
			</c:forEach>
		</table>
                <div class="pages">
                    <c:forEach var="page" items="${pageList}">
                        <a href="books?id=<c:out value="${page}"/>"> <c:out value="${page}"/></a>
                    </c:forEach>
                </div>
		<h4>
                    <a href="newBook">Добавить книгу</a>
		</h4>
	</div>
</body>
</html>