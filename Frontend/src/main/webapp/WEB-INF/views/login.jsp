<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login Page</h1>
<form action="<c:url> value='loginSuccess'</c:url>" method="post">
<pre>
UserName: <input type="text" name="user">
Password: <input type="password" name="password">
 <input type="submit" name="Login">

</pre></form>
</body>
</html>