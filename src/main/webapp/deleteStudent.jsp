<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Delete Student</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
<h2>Delete Student</h2>
<form action="student" method="post" class="card">
<input type="hidden" name="action" value="delete">
<label>ID</label>
<input type="number" name="id" required>
<button class="btn danger">Delete</button>
</form>
<a href="index.jsp" class="link">⬅ Back</a>
</div>
</body>
</html>