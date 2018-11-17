<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>Login:</h2>
<form:form action="login" modelAttribute="modlatr" method="post"   >
    <pre>
    User Name:<input type="text" name="Email"/>
    Password:<input type="password" name="Password">
    <input type="submit" value="login">
        ${msg}
</pre>
</form:form>

</body>
</html>