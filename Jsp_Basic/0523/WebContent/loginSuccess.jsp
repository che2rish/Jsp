<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("passwd");
	String addr = (String)request.getAttribute("addr");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디 : <%=id %></br>
비밀번호 : <%=password %></br>
주소 : <%=addr %>
</body>
</html>