<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First Web Application</title>
</head>
<body>
	<font color="red">${errorMessage}</font>
	<form action="" method="post">
		Name: <input type="text" name="name" />
		Password: <input type="password" name="password"/>
		<input type="submit">
	</form>
</body>
</html>