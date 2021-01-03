<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   
<%@include file="menu.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">Update Product</h3>

<form:form action="Updateproducts" method="post" modelAttribute="product" enctype="multipart/form-data" >

<table align="center" class="table table-bordered">
   <%--  <tr>
     <td><form:hidden path="prodid" value="${product.prodid }"></form:hidden></td>
     </tr> 
 --%>
 	<tr>
		<td>Product Name</td>
		<td><form:input path="prodName" value="${product.prodName }"/></td>
	</tr>
	<tr>
		<td>Product Price</td>
		<td><form:input path="price" value="${product.price }"/></td>
	</tr>
	<tr>
		<td>Stock</td>
		<td><form:input path="stock" value="${product.stock }"/></td>
	</tr>
    <tr>
		<td>Category</td>
		<td><form:select path="catid">
			<%-- <form:option value="${product.catid }" /> --%> 
			<form:options items="${categoryList}"/>
		</form:select></td>
	</tr> 
	<tr>
		<td>Product Desc</td>
		<td><form:input path="prodDesc" value="${product.prodDesc }"/></td>
	</tr>
	<tr>
		<td>Product Image</td>
		<td><form:input type="file" path="pimage"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<center><input type="submit" value="Update Product"/></center>
		</td>
	</tr>
</table>
</form:form>

<table align="center" class="table table-bordered">
	<tr>
		<td>Product ID</td>
		<td>Product Name</td>
		<td>Category</td>
		<td>Price</td>
		<td>Stock</td>
	<!-- 	<td>Supplier</td> -->
		<td>Operation</td>
	</tr>
	<c:forEach items="${productList}" var="product">
	<tr>
		<td>${product.prodid}</td>
		<td>${product.prodName}</td>
		<td>${product.catid}</td>
		<td>${product.price}</td>
		<td>${product.stock}</td>
		<td>
			<a href="<c:url value="/editProduct/${product.prodid}"/>">Edit</a>
			<a href="<c:url value="/deleteProduct/${product.prodid}"/>">Delete</a>
		</td>
	</tr>
	</c:forEach>
</table>

</div>
</body>
</html>