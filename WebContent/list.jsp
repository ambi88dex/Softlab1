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
a.button {
    -webkit-appearance: button;
    -moz-appearance: button;
    appearance: button;

    text-decoration: none;
    color: initial;
    padding: 5px;
        margin-bottom: 5px;
}
</style>
</head>
<body>

	<a href="http://localhost:8080/SoftLab/add" class="button">ADD</a>

<table>
  <tr>
    <th>Roll No</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Option</th>
  </tr>
  
  <%
	ResultSet data = (ResultSet) request.getAttribute("data");
  	while(data.next()) {
  %>
	  <tr>
	    <td><% out.println( data.getInt("roll_no")); %></td>
	    <td><% out.println( data.getString("fname")); %></td>
	    <td><% out.println( data.getString("lname")); %></td>
	    <td>
	    	<a href="http://localhost:8080/SoftLab/edit?roll_no=<% out.println( data.getInt("roll_no")); %>" class="button">Edit</a>
	    	<a href="http://localhost:8080/SoftLab/Delete?roll_no=<% out.println( data.getInt("roll_no")); %>" class="button">Delete</a>
	    </td>
	  </tr>
	  
	<% } %>
</table>

<% data.close(); %>

</body>
</html>
