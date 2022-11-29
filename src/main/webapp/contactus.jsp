<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Us</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<%@ include file="navbar.jsp"%>
<body>
<h4>Email: abc@gmail.com</h4>
<h4>Phone Number: 817XXXXXXX</h4>
<div class="form-container">
<form action="contact" method="post">
<h2>Contact Us</h2>
<label for="name" class="form-elements form-label"><b>Name :</b></label>
<br>
<input id="name" name="name" class="form-elements form-input" type="text"/>
<br>
<label for="number" class="from-elements form-label"><b>Phone Number :</b></label>
<br>
<input id="number" name="number" class="form-elements form-input" type="number"/>
<br>
<label for="email" class="from-elements form-label"><b>Email :</b></label>
<br>
<input id="email" name="email" class="form-elements form-input" type="email"/>
<br>
<label for="comment" class="form-elements form-label"><b>Comment :</b></label>
<br>
<textarea id="comment" name="comment" class="form-elements form-input"></textarea>
<br>
<button type="Submit" class="form-elements form-button">Submit</button>
</form>
</div>

</body>
</html>