<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "elServlet" method = "get">
	<table border = "1">
		<tr><td>아이디 </td><td><input type = "text" name = "id"></td></tr>
		<tr><td>이름 </td><td><input type = "text" name = "name"></td></tr>
		<tr><td colspan = "2" align = "center"><input type = "submit" value = "입력">	</td></tr>
	</table>
</form>
</body>
</html>