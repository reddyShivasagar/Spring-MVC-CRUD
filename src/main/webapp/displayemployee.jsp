<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

	th {
	background-color:red;
	
}

</style>


</head>

<body>


           <table border="3px" style="border-collapse:collapse;">
			
				<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Age</th>
				<th>Sal</th>
				<th>Email</th>
				<th>Password</th>
				<th>Edit</th>
				<th>Delete</th>
				
				</tr>
				
				<c:forEach var="emp" items="${list}">
				
				<tr>
				<td>${emp.getId()}</td>
				<td>${emp.getName()}</td>
				<td>${emp.getAge()}</td>
				<td>${emp.getSal()}</td>
				<td>${emp.getEmail()}</td>
				<td>${emp.getPassword()}</td>
				<td><a href="editemployee?id=${emp.getId()}">EDIT</a></td>
				<td><a href="deleteemployee?id=${emp.getId()}">DELETE</a></td>
				
				
				</tr>
				
				
				
				</c:forEach>
				
           </table>
           
</body>

</html>