<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<%@ include file="navbar.jsp"%>
<body>
<h4>If your details are correct then click on "next"</h4>
<div>
<% 
String name = (String) session.getAttribute("name");
String phnnum = (String) session.getAttribute("number");
String email = (String) session.getAttribute("email");
String voterid = (String) session.getAttribute("voterid");
String address = (String) session.getAttribute("address");
String dob = (String) session.getAttribute("dob");
%>
<form class="topnav">
<h4 class="centre">NAME     : <%=name %></h4>
<br>
<h4 class="centre">Phone no : <%=phnnum %></h4>
<br>
<h4 class="centre">Email ID : <%=email %></h4>
<br>
<h4 class="centre">Voter ID : <%=voterid %></h4>
<br>
<h4 class="centre">Address  : <%=address %></h4>
<br>
<h4 class="centre">DOB      : <%=dob %></h4>
<br>
<a href="userWelcome.jsp" class="index-a"><b>Next</b></a>
</form>
</div>
</body>
</html>