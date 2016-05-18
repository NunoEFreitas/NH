<%-- 
    Document   : index
    Created on : 4/jan/2016, 11:48:18
    Author     : Nuno
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Demo</title>
    </head>
    <body>
        <p>Demo</p>
        <a href="newproduct">New Product</a><br>
        <a href="newproducttype">New Product Type</a><br>
        <a href="listproducts">List Products</a><br>
        <a href="listproducttypes">List Product Types</a><br>
        <a href="newordertype">New Order Type</a><br>
        <a href="listordertypes">List Order Types</a><br>
        <a href="neworderstatus">New Order Status</a><br>
        <a href="listorderstatus">List Order Status</a><br>
        ${message}
    </body>
</html>
