<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JSP PAge</title>
</head>
<body>
<form action="registerUser" method="post">
    <pre>
        <h2>User registration</h2>
    First Name:<input type="text" name="First_Name"/>
    Last Name:<input type="text" name="Last_Name"/>
    User Name:<input type="text" name="Email"/>
    Password:<input type="password" name="Password"/>
   <input type="submit" value="register"/>
    </pre>
</form>

</body>
</html>