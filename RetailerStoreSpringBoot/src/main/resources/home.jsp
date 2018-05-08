<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <center>
        <h1>Store Management</h1>
       
    </center>
    <div align="center">
    <h2 align="center">List All Customer</h2>
        <table border="1" cellpadding="5">
            
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>Payment Mode</th>
                
            </tr>
            <c:forEach var="cutomer" items="${listCustomer}">
                <tr>
                    <td><%-- <c:out value="${cutomer.customerId}" /> --%>${cutomer.customerId}</td>
                    <td><%-- <c:out value="${cutomer.customerId}" /> --%>${cutomer.customerId}</td>
                    <td><%-- <c:out value="${cutomer.customerAddress}" /> --%>${cutomer.customerAddress}</td>
                    <td><%-- <c:out value="${cutomer.paymentMode}" /> --%>${cutomer.paymentMode}</td>
                   <%--  <td>
                        <a href="/edit?customerId=<c:out value='${customer.customerId}' />">Update</a>
                        
                        <a href="/delete?customerId=<c:out value='${customer.customerId}' />">Delete</a>                     
                    </td> --%>
                </tr>
            </c:forEach>
        </table>
    </div>   

</body>
</html>