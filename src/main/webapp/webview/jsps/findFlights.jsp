<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form:form action="findFlights" modelAttribute="fltatr" method="post" >
    From:<input type="text" name="from"/>
    To:<input type="text" name="to"/>
    Departure Date:<input type="date" name="departureDate" required/>
    <input type="submit" value="search"/>

</form:form>


</body>
</html>