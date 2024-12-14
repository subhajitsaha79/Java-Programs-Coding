<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.test_demo.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee Details</title>
</head>
<body>
	<% Employee obj = (Employee)request.getAttribute("emp_obj"); %>
	<center>
	<h1>Employee Details</h1>
	<form action="editsaveemp" method="post">
		<table>
			<tr>
				<td>Employee Id : </td>
				<td><input type="text" value=<%=obj.getId() %> disabled></td>
			</tr>
			<tr>
				<td><input type="hidden" name="id" value=<%=obj.getId() %>></td>
			</tr>
			<tr>
				<td>Name : </td>
				<td><input type="text" name="name" value='<%=obj.getName() %>'></td>
			</tr>
			<tr>
				<td>Gender : </td>
				<td>
				<input id="male" type="radio" name="gender" value="Male" <%=obj.getGender().equals("Male")?"checked":"" %>>
				<label for="male">Male</label>
				<input type="radio" id="female" name="gender" value="Female" <%=obj.getGender().equals("Female")?"checked":"" %>>
				<label for="female">Female</label>
				<input type="radio" id="others" name="gender" value="Others" <%=obj.getGender().equals("Others")?"checked":"" %>>
				<label for="others">Others</label>
				</td>
			</tr>
			<tr>
				<td>City : </td>
				<td><input type="text" name="city" value='<%=obj.getCity() %>'></td>
			</tr>
			<tr>
				<td>Department : </td>
				<td>
				<select name="department" style="width:180px;">
					<option <%=obj.getDepartment().equals("Development")?"selected":"" %>>Development</option>
					<option <%=obj.getDepartment().equals("Testing")?"selected":"" %>>Testing</option>
					<option <%=obj.getDepartment().equals("Sales")?"selected":"" %>>Sales</option>
					<option <%=obj.getDepartment().equals("Devops")?"selected":"" %>>Devops</option>
				</select>
				</td>
		</table>
		
		<input type="submit"><br/>
	</form>
	<a href="ViewAllEmployees">View All Employees</a>
	</center>
</body>
</html>