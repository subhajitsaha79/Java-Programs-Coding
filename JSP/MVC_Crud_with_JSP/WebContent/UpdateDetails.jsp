<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Details</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/MainController?actionVal=updateConfirm" method="post">
		<table align="center">
			<tr>
				<td>Employee Id</td>
				<td><input name="empid" type="text" value="<%=(String)request.getAttribute("empId")%>" readonly></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><input name="empName" type="text" value="<%=(String)request.getAttribute("empName")%>"></td>
			</tr>
			<tr>
				<td>Gender <%String gender=(String)request.getAttribute("Gender");%></td>
				<td>Male<input name="gender" type="radio" value="male" <%=gender.equals("male")?"checked":""%>></td>
				<td>Female<input name="gender" type="radio" value="female" <%=gender.equals("female")?"checked":""%>></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input name="dob" type="date" value="<%=(String)request.getAttribute("dob")%>"></td>
			</tr>
			<tr>
				<td>Citizenship Status <%String citizenStatus = (String)request.getAttribute("citizenStatus"); %></td>
				<td>
					<select name="status">
						<option value="citizen" <%=citizenStatus.equals("citizen")?"selected":""%>>Citizen</option>
						<option value="PR" <%=citizenStatus.equals("PR")?"selected":""%>>PR</option>
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