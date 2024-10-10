<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<form action=<c:url value = "/admin/catagory/insert"/> method="post" enctype="">
	<label for="fname">Category name:</label><br>
	<input type="text" id="catagoryname" name="catagoryname"><br> 
	<label for="lname">Images:</label><br> 
	<input type="text" id="images" name="images">
	<label for="lname">Status:</label><br> 
	<label for="lname">Hoạt động</label><br>
	<input type="radio" id="statuson" name="status" value="1"> 
	<label for="lname">Không hoạt động</label><br>
	<input type="radio" id="statusoff" name="status" value="0"> 
	<input type="submit" value="Insert">
</form>