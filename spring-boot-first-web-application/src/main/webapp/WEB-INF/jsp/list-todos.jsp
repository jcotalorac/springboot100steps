<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo's for ${name}</title>
</head>
<body>
	<h1>Your Todos</h1>
	<table>
		<caption>Your todos are</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is it Done?</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.desc}</td>
					<td>${todo.date}</td>
					<td>${todo.done}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="/add-todo">Add a Todo</a>
</body>
</html>