<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="background: #E0E0E0; height: 55px; padding: 5px;">  
	<div style="float: left"><h1>Soudip Webapp </h1> 
	</div>
	    
	<div style="float: right; padding: 10px; text-align: right;">       
		<!-- User stored in session with attribute: loginedUser -->
		Hello <b>${loginedUser.userName}</b>
		<br/>
			<form action = action>
			Search By Name: <input type="text" name="Name">
			<input type ="submit" value="Search">
			</form>    
	</div>
</div>