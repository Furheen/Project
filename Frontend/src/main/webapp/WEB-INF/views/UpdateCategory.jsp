<%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value="/updateCategory"></c:url>" method="post">
<table align="center" class="table table-bordered">
	<tr>
		<td>Category Id</td>
		<td><input type="text" name="catId" 
		value="${category.categoryId}" readonly="readonly" /></td>
	</tr> 
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="catName"
		 value="${category.categoryName}"/></td>
	</tr>
	<tr>
		<td>Category Desc</td>
		<td><textarea cols="40" rows="5" name="catDesc" 
		value="">${category.categoryDesc}</textarea></td>
	</tr>
	<tr>
		<td colspan="2">
			<center>
			<input type="submit" value="Update Category"/>
			</center>
		</td>
	</tr>
</table>
</form>
</body>
</html>