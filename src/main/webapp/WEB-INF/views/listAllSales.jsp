<%-- 
    Document   : listAllSales
    Created on : May 18, 2016, 4:15:57 PM
    Author     : hvsousa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>List All Sales</title>
    </head>
    <body>
        <h1>List All Sales!</h1>
         <table>
		<tr>
                     <td>Id</td><td>Date</td><td>Price Total</td><td>Paided?</td><td>Order</td>
                     <td>Product</td><td>Payment Type</td>
                     <td>
                        <form name="TrainerMenu" action="TrainerMenu" method="get">
                        <input type="button" value="New Sale" name="AuthorizationManager"
                         onclick="openPage('newUser')" />
                        </form>
                     </td>
		</tr>
		<c:forEach items="${allSales}" var="sale"> <!--that user came from controller called users and assume a foreach in this tag-->
			<tr>
			<td>${sale.id}</td>
			<td>${sale.date}</td>
                        <td>${sale.priceTotal}</td>
                        <td>${sale.paid}</td>
                        <td>${sale.order.getId()}</td>
                        <td>${sale.orderProduct.getOrder_Product_id()}</td>
                        <td>${sale.paymentType.getId()}</td>
                        <td>
                           <form name="TrainerMenu" action="TrainerMenu" method="get">
                            <input type="button" value="Edit Sale" name="AuthorizationManager"
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
        
        
    </body>
</html>
