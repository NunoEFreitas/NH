<%-- 
    Document   : newUser
    Created on : May 17, 2016, 4:40:30 PM
    Author     : hvsousa
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>New User</title>
    </head>
    <body>
        <h1>Add New User</h1>
        
        <form:form method="POST" modelAttribute="user"><!-- create a var user or recived a var user, the path map the value -->
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="name">Name: </label> </td>
				<td><form:input path="name" id="name"/></td>
                                <td><form:errors path="name" cssClass="error"/></td>

		    </tr>
                    <tr>
				<td><label for="password">Password: </label> </td>
				<td><form:input path="password" id="password"/></td>
                                <td><form:errors path="password" cssClass="error"/></td>

		    </tr>
                    <tr>
				<td><label for="email">Email: </label> </td>
				<td><form:input path="email" id="email"/></td>
                                <td><form:errors path="email" cssClass="error"/></td>

		    </tr>
                    <tr>
				<td><label for="address">Address: </label> </td>
				<td><form:input path="address" id="address"/></td>
                                <td><form:errors path="address" cssClass="error"/></td>

		    </tr>
                    <tr>
				<td><label for="telephone">Phone: </label> </td>
				<td><form:input path="telephone" id="telephone"/></td>
                                <td><form:errors path="telephone" cssClass="error"/></td>

		    </tr>
                    <tr>
				<td><label for="nif">Nif: </label> </td>
				<td><form:input path="nif" id="nif"/></td>
                                <td><form:errors path="nif" cssClass="error"/></td>

		    </tr>
                    <tr>
                    <td><label for="userProfile">Profile: </label> </td>
                    <td>
             <%--          <select name="blabla" path="userProfile_id">  
                            <c:forEach var="elemento" items="${uplist}">  
                              <option value="${elemento.id}">${elemento.designation}</option>  
                            </c:forEach>  
                    </select>--%>
                                          
                                    
                       <form:select path="userProfile.id" id="userProfile.id">
                            <c:forEach items="${uplist}" var="up">
                                 <c:choose>
                                    <c:when test="${up.id eq userProfile.id}">
                                    <option value="${up.id}" selected="true">${up.designation}</option>
                                    </c:when>
                                    <c:otherwise>
                                    <option value="${up.id}">${up.designation}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                    </form:select> 
                    </td>
		    </tr>
                    
                    
                    <c:choose>
                        <c:when test="${up.id eq userProfile.id}">
                            <option value="${up.id}" selected="true">${up.designation}</option>
                        </c:when>
                    </c:choose>
		 
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
        
        
    </body>
</html>
