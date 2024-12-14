<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<center>
	<h1>Employee Details</h1>
	<form action="addemp" method="post">
		<table>
			<tr>
				<td>Employee Id : </td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>Name : </td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Gender : </td>
				<td>
				<input id="male" type="radio" name="gender" value="Male">
				<label for="male">Male</label>
				<input type="radio" id="female" name="gender" value="Female">
				<label for="female">Female</label>
				<input type="radio" id="others" name="gender" value="Others">
				<label for="others">Others</label>
				</td>
			</tr>
			<tr>
				<td>City : </td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td>Department : </td>
				<td>
				<select name="department" style="width:180px;">
					<option>Development</option>
					<option>Testing</option>
					<option>Sales</option>
					<option>Devops</option>
				</select>
				</td>
		</table>
		
		<input type="submit"><br/>
	</form>
	<a href="ViewAllEmployees">View All Employees</a>
	</center>
</body>
</html>