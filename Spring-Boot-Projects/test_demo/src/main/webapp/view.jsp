<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.example.test_demo.entity.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Employees</title>
</head>
<body>
	<center><h1>Employee Data</h1>
	<%
	List<Employee> emp_list = (ArrayList<Employee>)request.getAttribute("emp_data");
	%>
	<table border=1 align=center style="border-collapse:collapse;">
		<tr>
			<th>Employee Id</th>
			<th>Name</th>
			<th>Gender</th>
			<th>City</th>
			<th>Department</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
		for(Employee emp:emp_list)
		{
		%>
		<tr>
			<td><%=emp.getId()%></td>
			<td><%=emp.getName()%></td>
			<td><%=emp.getGender()%></td>
			<td><%=emp.getCity()%></td>
			<td><%=emp.getDepartment()%></td>
			<td><a href="Edit?id=<%=emp.getId()%>">Edit</a></td>
			<td><a href="Delete?id=<%=emp.getId()%>">Delete</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<a href="/home">Add Employee</a>
	</center>
</body>
</html>