<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
</head>
<body>
<table border="2">
<fo:form action="adddata" method="post" modelAttribute="my">

<tr>
<td>Customer Name</td>
<td><fo:input path="name"/>
</tr>

<tr>
<td>Mobile No.</td>
<td><fo:input path="mobileNo"/>
</tr>

<tr>
<td>Age</td>
<td><fo:input path="age"/>
</tr>

<tr>
<td>Initial Balance</td>
<td><fo:input path="initialBalance"/>
</tr>
<td><input type="submit" value="Add Customer Account" /></td>
</fo:form>

</table>
</body>
</html>