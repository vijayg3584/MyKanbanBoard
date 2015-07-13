<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Profile</title>
</head>
<body>
	<h1>Modify profile</h1>
	<form:form commandName="profile" action="login">
		<table>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" />
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update Profile" />
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>