<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

</head>
<body>
<h2>Flights:</h2>
<table>
    <tr><th>Airlines:</th>
        <th>Departure City</th>
        <th>Arrival City</th>
        <th>Time</th>
    </tr>
<j:forEach items="${flights}" var="flight">
    <tr>
        <td>${flight.operatingAirlines}</td>
        <td>${flight.departureCity}</td>
        <td>${flight.arrivalCity}</td>
       <td> <fmt:formatDate value="${flight.estimatedDepartureTime}" pattern="HH:mm"/></td>
        <td><a href="showCompleteReservation?flightID=${flight.ID}">Select</a></td>



</j:forEach>


</table>
</body>
</body>
</html>