<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online_voting_system</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<%@ include file="navbar.jsp"%>
<body>
<h1>Let's celebrate this festival of Democracy!</h1>
<h1>let's vote!</h1>
<div class = "form-container">

<form action="voterLogin" method="post">
<h2>Enter your Voter ID Number </h2>
<label for="voterNumber" class="form-elements form-label"><b>Voter ID :</b></label>
<br>
<input name="voterNumber" id = "voterNumber" class="form-elements form-input" type="text"/>
<br>
<button type="Submit" class="form-elements form-button">Login</button>
<br>
<a href="adminlogin.jsp" class="index-a">Admin</a>
<br><br>
<a href="register.jsp" class="index-a"><b>New Registration</b></a>
</form>
</div>
</body>
</html>