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
                	<h2>List of Order Types</h2>	
	<table>
		<tr>
                    <td>ID</td><td>Designation</td>
                    <td>Edit</td><td>Delete</td>
		</tr>
		<c:forEach items="${lot}" var="lot">
			<tr>
			<td>${lot.id}</td>
                        <td>${lot.designation}</td>
                        
                        <td><a href="<c:url value='/edit-${lot.id}-ordertype' />">Edit</a></td>
			<td><a href="<c:url value='/delete-${lot.id}-ordertype' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/newordertype' />">Add new Order Type</a>
        <br>
        <a href="/NH/">Home</a>
        ${message}
    </body>
</html>