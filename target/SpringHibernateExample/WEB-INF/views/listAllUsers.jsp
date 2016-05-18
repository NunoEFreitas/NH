<%-- 
    Document   : listAllUsers
    Created on : May 17, 2016, 3:05:03 PM
    Author     : hvsousa
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>List All Users</title>
    </head>
    <body>
        	<h2>List All Users</h2>	
	
        <table>
		<tr>
                     <td>Id</td><td>Name</td><td>Password</td><td>Email</td><td>Telephone</td>
                     <td>NIF</td><td>Address</td><td>Profile</td>
                     <td>
                        <form name="TrainerMenu" action="TrainerMenu" method="get">
                        <input type="button" value="New User" name="AuthorizationManager"
                         onclick="openPage('newUser')" />
                        </form>
                     </td>
		</tr>
		<c:forEach items="${allUsers}" var="user"> <!--that user came from controller called users and assume a foreach in this tag-->
			<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
                        <td>${user.password}</td>
                        <td>${user.email}</td>
                        <td>${user.telephone}</td>
                        <td>${user.nif}</td>
                        <td>${user.address}</td>
                        <td>${user.userProfile.getDesignation()}</td>
                        <td>
                           <form name="TrainerMenu" action="TrainerMenu" method="get">
                            <input type="button" value="Edit User" name="AuthorizationManager"
                             onclick="openPage('edit-${user.id}-user')" />
                            </form> 
                        </td>
                        <td>
                           <form name="TrainerMenu" action="TrainerMenu" method="get">
                            <input type="button" value="Delete User" name="AuthorizationManager"
                             onclick="openPage('delete-${user.id}-user')" />
                            </form> 
                        </td>
			</tr>
		</c:forEach>
	</table>
        
        
        <script type="text/javascript">
         function openPage(pageURL)
         {
         window.location.href = pageURL;
         }
        </script>
        
        
        
    </body>
</html>
