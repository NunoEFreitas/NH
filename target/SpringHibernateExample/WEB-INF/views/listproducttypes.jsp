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
                	<h2>List of Products Types</h2>	
	<table>
		<tr>
                    <td>ID</td><td>Designation</td>
                    <td>Edit</td><td>Delete</td>
		</tr>
		<c:forEach items="${lpt}" var="lpt">
			<tr>
			<td>${lpt.id}</td>
                        <td>${lpt.designation}</td>
                        
                        <td><a href="<c:url value='/edit-${lpt.id}-producttype' />">Edit</a></td>
			<td><a href="<c:url value='/delete-${lpt.id}-producttype' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/newproduct' />">Add new Product Type</a>
        <br>
        <a href="/NH/">Home</a>
        ${message}
    </body>
</html>

