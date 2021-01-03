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
<h1>Register Page</h1>
<form action="<c:url value='addUser'></c:url>" method="post">
<pre>
Enter your Name: <input type="text" name="user">
Enter Name to login: <input type="text" name="name">
Enter Password: <input type="password" name="password">
Address: <textarea rows="8" cols="20" name="address"></textarea>
Email-Id: <input type="email" name="email">
Mobile No: <input type="text" name="mobile">
<input type="submit" value="Register">
</pre>
</form>
</body>
</html>