<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Enter Customer Details</h1>
</div>
<form action="add.html" method="post">
<table border=1 align="center">
			<tr>
				<td><label for="CustomerId">Customer Id</label></td>
				<td>
					<input id="CustomerId" required="true" placeholder="Customer ID" />
				</td>
			</tr>
			<tr>
				<td><label for="customerName">Customer Name</label></td>
				<td>
					<input  id="customerName" required="true" placeholder="Customer Name" />
				</td>
			</tr>
			<tr>
				<td><label for="customerAddress">Customer Address</label></td>
				<td>
					<input  id="customerAddress" required="true" placeholder="Customer Address" />
				</td>
			</tr>
			<tr>
				<td><label for="paymentMode">paymentMode</label></td>
				<td>
					<input type="radio" name="paymentMode" value="Cash"/>Cash
					<input type="radio" name="paymentMode" value="Card"/>Card
				</td>
			</tr>
			<tr>
					<td><button type="submit">Add Customer</button></td>
			</tr>
			</table>
</form>
<%-- <c:if test="${param.message ne null}">
			<div align="center">
				<h1>${param.message}</h1>
				<a href="index.html">Index</a>
			</div>
			
		</c:if> --%>
</body>
</html>