<%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver");%>

<!DOCTYPE html>
<html>
<head>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}	

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>
<body>

<%
	String msg = (String) request.getAttribute("msg");
	String fname = (String) request.getAttribute("fname");
	String lname = (String) request.getAttribute("lname");
	String roll_no = (String) request.getAttribute("roll");
	if(msg != null)
		out.println(msg);
%>
	<form method="post">
		Roll No : <input name="roll_no" value="<%out.println(roll_no);%>" readonly/><br>
		First Name : <input name="fname" value="<%out.println(fname);%>" /><br>
		Last Name : <input name="lname" value="<%out.println(lname);%>" /><br>
		<button type="submit" value="<%out.println(msg);%>">Submit</button>
	</form>

</body>
</html>
