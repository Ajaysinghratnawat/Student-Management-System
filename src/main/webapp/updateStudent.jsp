<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Student</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
<h2>Update Student</h2>
<form action="student" method="post" class="card">
<input type="hidden" name="action" value="update">
<label>ID</label>
<input type="number" name="id" required>
<label>Name</label>
<input type="text" name="name">
<label>Age</label>
<input type="number" name="age">
<label>Address</label>
<input type="text" name="address">
<button class="btn">Update</button>
</form>
<a href="index.jsp" class="link">⬅ Back</a>
</div>
</body>
</html>