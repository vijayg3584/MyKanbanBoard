<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Kanban Board</title>
<link href="styles/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Login below to access the application form</h1>
    <form method="post" action="dashboard.html">
        Username <input type="text" id="username" name="username" /> <br/>
        Password <input type="password" id="password" name="password" /> <br/>
        <input type="submit" value="submit" />
        <input type="reset" value="clear" />
    </form>
</body>
</html>