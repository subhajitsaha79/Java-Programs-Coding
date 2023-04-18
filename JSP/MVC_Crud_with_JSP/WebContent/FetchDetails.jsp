<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.beans.*,java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trainee Details</title>
</head>
<body>
	<%SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY"); %>
	<%ArrayList<TraineeDetails> traineeList = (ArrayList<TraineeDetails>)request.getAttribute("traineeList"); %>
	<a href="menu.html">Menu</a>
	<h3 align=center>Modify Employee Details</h3>
	<h5 align=center><%=request.getAttribute("status")!=null?request.getAttribute("status"):"" %></h5>
	<table border=1 align=center style="border-collapse:collapse">
		<tr>
			<th>Emp Id</th>
			<th>Emp Name</th>
			<th>Gender</th>
			<th>DOB</th>
			<th>Citizenship Status</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
			for(TraineeDetails trainee:traineeList)
			{%>
		<tr>
			<td><%=trainee.getEmpId()%></td>
			<td><%=trainee.getName()%></td>
			<td><%=trainee.getGender()%></td>
			<td><%=formatter.format(trainee.getDob())%></td>
			<td><%=trainee.getCitizenshipStatus()%></td>
			<td><a href="MainController?actionVal=updateFetch&empId=<%=trainee.getEmpId() %>&empName=<%=trainee.getName()%>&gender=<%=trainee.getGender()%>&dob=<%=trainee.getDob()%>&citizenStatus=<%=trainee.getCitizenshipStatus()%>">Edit</a></td>
			<td><a href="MainController?actionVal=delete&empId=<%=trainee.getEmpId()%>">Delete</a></td>
		</tr>	
			<%}
		%>
	</table>
</body>
</html>