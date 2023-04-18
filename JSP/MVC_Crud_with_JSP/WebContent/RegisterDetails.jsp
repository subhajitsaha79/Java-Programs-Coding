<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="menu.html">Menu</a>
	<h3 align="center">Employee Registration</h3>
	<%=request.getAttribute("status")!=null?request.getAttribute("status"):"" %>
	<form action="<%=request.getContextPath()%>/MainController?actionVal=insert" method="post">
		<table align="center">
			<tr>
				<td>Employee Id</td>
				<td><input name="empid" type="text"></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><input name="empName" type="text"></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>Male<input name="gender" type="radio" value="male"></td>
				<td>Female<input name="gender" type="radio" value="female"></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input name="dob" type="date"></td>
			</tr>
			<tr>
				<td>Citizenship Status</td>
				<td>
					<select name="status">
						<option value="citizen">Citizen</option>
						<option value="PR">PR</option>
					</select>
				</td>
			</tr>
			<tr></tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>
</body>
</html>