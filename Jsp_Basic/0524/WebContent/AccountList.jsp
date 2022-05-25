<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = "1">
	<tr><th>계좌번호</th><th>이름</th><th>잔액</th></tr>
	<c:forEach items = "${requestScope.accs}" var = "acc">
		<tr><td>${acc.id }</td><td>${acc.name }</td><td>${acc.balance }</td></tr>
	</c:forEach>
</table>
</body>
</html>