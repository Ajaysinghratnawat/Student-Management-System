<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Student</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
<h2>Add Student</h2>
<form action="student" method="post" class="card">
<input type="hidden" name="action" value="add">
<label>Name</label>
<input type="text" name="name" required>
<label>Age</label>
<input type="number" name="age" required>
<label>Address</label>
<input type="text" name="address" required>
<button class="btn">Add</button>
</form>
<a href="index.jsp" class="link">⬅ Back</a>
</div>
</body>
</html>