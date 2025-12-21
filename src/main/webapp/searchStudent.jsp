<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Search Student</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
<h2>Search Student</h2>
<form action="student" method="get" class="card">
<input type="hidden" name="action" value="search">
<label>Student ID</label>
<input type="number" name="id" required>
<button class="btn">Search</button>
</form>
<a href="index.jsp" class="link">⬅ Back</a>
</div>
</body>
</html>