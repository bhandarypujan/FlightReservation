<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Complete Reservation</title>
</head>
<body>
<pre>
<h2>Complete Reservation</h2>
Airline:${flight.operatingAirlines}<br/>
Departure City:${flight.departureCity}<br/>
Arrival CIty:${flight.arrivalCity}<br/>

<form action="completeReservation" method="post">
<h2>Passenger Details:</h2>
First Name:<input type="text" name="passengerFirstName">
Last Name:<input type="text" name="passengerLastName">
    MIddle Name:<input type="text" name="passengerMiddleName">
Email:<input type="text" name="passengerEmail">
Phone:<input type="text" name="passengerPhone">

<h2>Card Details:</h2>
Name on the Card:<input type="text" name="nameOnTheCard">
Card No:<input type="text" name="cardNumber">
Expiry Date:<input type="text" name="expirationDate">
Three Digit Security Code:<input type="text" name="securityCode">
<input type="submit" value="Confirm">
    <input type="hidden" name="flightID" value="${flight.ID}">
</form>
</pre>

</body>
</html>