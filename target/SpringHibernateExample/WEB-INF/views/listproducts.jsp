<%-- 
    Document   : listmaterials
    Created on : 14/jan/2016, 13:51:17
    Author     : Nuno
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
                	<h2>List of Products</h2>	
	<table>
		<tr>
                    <td>ID</td><td>Designation</td><td>Quantity</td><td>Price</td><td>Type of Product</td>
                    <td>Edit</td><td>Delete</td>
		</tr>
		<c:forEach items="${lp}" var="lp">
			<tr>
			<td>${lp.id}</td>
                        <td>${lp.designation}</td>
                        <td>${lp.quantity}</td>
                        <td>${lp.price}</td>
                        <td>${lp.productType.designation}</td>
                        <td><a href="<c:url value='/edit-${lp.id}-product' />">Edit</a></td>
			<td><a href="<c:url value='/delete-${lp.id}-product' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/newproduct' />">Add new Product</a>
        <br>
        <a href="/NH/">Home</a>
    </body>
</html>

