<%-- 
    Document   : newmaterial
    Created on : 14/jan/2016, 13:50:56
    Author     : Nuno
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>New Product</title>
    </head>
    <body>
        <h2>Registration Form</h2>
 
	<form:form method="POST" modelAttribute="product">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="designation">Designation: </label> </td>
				<td><form:input path="designation" id="designation"/></td>
                                <td><form:errors path="designation" cssClass="error"/></td>

		    </tr>
                    <tr>
				<td><label for="quantity">Quantity: </label> </td>
				<td><form:input path="quantity" id="quantity"/></td>

		    </tr>
                    <tr>
				<td><label for="price">Price: </label> </td>
				<td><form:input path="price" id="price"/></td>

		    </tr>
                    <tr>
                    <td><label for="productType">Product Type: </label> </td>
                    <td>
                    <form:select path="productType.id" id="productType.id">
                            <c:forEach items="${pType}" var="pt">
                                 <c:choose>
                                    <c:when test="${pt.id eq pt.id}">
                                    <option value="${pt.id}" selected="true">${pt.designation}</option>
                                    </c:when>
                                    <c:otherwise>
                                    <option value="${pt.id}">${pt.designation}</option>
                                    </c:otherwise>
                                </c:choose>
                                    </c:forEach>
                            </form:select>
                    </td>
		    </tr>
		
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
                ${error}
	<br/>
	<br/>
    </body>
</html>
