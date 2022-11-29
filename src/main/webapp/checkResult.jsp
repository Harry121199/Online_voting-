<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Admin!</title>
<link rel="stylesheet" type="text/css" href="style.css">
<%
   
    String a[] = new String[100];
 
    Class.forName("com.mysql.cj.jdbc.Driver");
	java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineVotingDB","root","Hkay1234@");
	
	PreparedStatement preparedStatement = con.prepareStatement("select partie,count(partie) as c from vote group by partie");
	ResultSet rs=((java.sql.Statement) preparedStatement).executeQuery("select partie,count(partie) as c from vote group by partie");
	
    int i=0;
    while(rs.next()){
        a[i] = rs.getString("c");
        i++;
    }
    %>
</head>
<%@ include file="adminNavbar.jsp" %>
<body>
<div class="checktable">
<table>
<tr>
<th>
Parties
</th>
<th>
Names
</th>
<th>
Votes
</th>
</tr>
<tr>
<td>
<img src="images/Aap.jpg" alt="AAP">
</td>
<td>Aam Aadmi Party</td>
<td><%=a[3] %></td>
</tr>
<tr>
<td>
<img src="images/bjp.jpg" alt="BJP">
</td>
<td>Bhartiya Janta Party</td>
<td><%=a[0] %></td>
</tr>
<tr>
<td>
<img alt="BSP" src="images/bsp.jpg">
</td>
<td>Bahujan Samaj Party</td>
<td><%=a[2] %></td>
</tr>
<tr>
<td>
<img alt="CONG" src="images/congress.png">
</td>
<td>Congress Party</td>
<td><%=a[4] %></td>
</tr>
<tr>
<td>
<img alt="CPI(M)" src="images/cpi.jpeg">
</td>
<td>Communist Party of India(M)</td>
<td><%=a[1] %></td>
</tr>
</table>
</div>
</body>
</html>