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
                	<h2>List of Order Status</h2>	
	<table>
		<tr>
                    <td>ID</td><td>Designation</td>
                    <td>Edit</td><td>Delete</td>
		</tr>
		<c:forEach items="${los}" var="los">
			<tr>
			<td>${los.id}</td>
                        <td>${los.designation}</td>
                        
                        <td><a href="<c:url value='/edit-${los.id}-orderstatus' />">Edit</a></td>
			<td><a href="<c:url value='/delete-${los.id}-orderstatus' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/neworderstatus' />">Add new Order Status</a>
        <br>
        <a href="/NH/">Home</a>
        ${message}
    </body>
</html>