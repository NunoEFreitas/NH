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
	
        
        
        <form name="TrainerMenu" action="TrainerMenu" method="get">

       
        <input type="button" value="New User" name="AuthorizationManager"
         onclick="openPage('newuser')" />

        </form>
                
                
        <script type="text/javascript">
         function openPage(pageURL)
         {
         window.location.href = pageURL;
         }
        </script>
        
        
        
    </body>
</html>
