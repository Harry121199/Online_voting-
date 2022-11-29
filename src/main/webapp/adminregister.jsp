<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Registration</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<%@ include file="navbar.jsp"%>
<body>
<div class="form-container">
<form action="adminregister" method="post">
<h2>Admin Registration</h2>
<label for="employeeid" class="form-elements form-label"><b>Employee ID :</b></label>
<br>
<input id="employeeid" name="employeeid" class="form-elements form-input" type="text"/>
<br>
<label for="name" class="form-elements form-label"><b>Name :</b></label>
<br>
<input id="name" name="name"class="form-elements form-input" type="text"/>
<br>
<label for="voternumber" class="form-elements form-label"><b>Voter Id :</b></label>
<br>
<input id="voternumber" name="vc_num"class="form-elements form-input" type="text"/>
<br>
<label for="password" class="form-elements form-label"><b>Password :</b></label>
<br>
<input id="password" name="password" class="form-elements form-input" type="text"/>
<br>
<button type="Submit" class="form-elements form-button">Register</button>
</form>
</div>
</body>
</html>