<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
<meta charset="ISO-8859-1">

<title>Ticket Booking</title>
<link rel="stylesheet" href="../css/style.css" type="text/css"></link
</head>
<body>
<div class="bgimg">
  <div class="topleft">
    <p>WELCOME</p>
  </div>
  <div class="middle">
    <h1>TICKET MANAGEMENT SYSTEM</h1>
    <hr>
   <marquee behavior="scroll" direction="left">HOME PAGE</marquee>
  </div>
<h2>Hi ${user}</h2>
<div class="sidenav">
         <div class="login-main-text">
            <h2>Ticket Management System</h2>
            <p>Choose your Movie</p>
         </div>
      </div>
      <div class="user">
         <div class="row">
            <div class="user selection">
            <table>
               <form action="BookingServlet" method="post">
                  <div class="details">
                    <tr>
                    <td> <label>Movie</label></td>
                   <!--   <td><select name="movies" >
                     	<option selected disabled>Choose one</option>
                         <option value="1">Avengers:EndGame</option>
                         <option value="2">Shazam</option>
                         <option value="3">Frozen 2</option>
                         <option value="4">Twilight</option>
                         <option value="5">Aladdin</option>
                         <option value="6">Men in Black </option>
                     </select> -->
                   <td>  <select name="movie">
        <c:forEach items="${movieDetails}" var="movieDetails">
            <option value="${movieDetails.movieId}">${movieDetails.movieName}</option>
        </c:forEach>
    </select>
    </td>
                     </td></tr>
                  <tr>
                   <td>  <label>Time</label></td>
                    <td> <select name="Time">
                    	<option selected disabled>Choose one</option>
                     	<option value="11:00 AM">11:00 AM</option>
                         <option value="2:10 PM">2:10 PM</option>
                         <option value="4:30 PM">4:30 PM</option>
                         <option value="8:10 PM">8:10 PM</option>
                     </select>
                     </td></tr>
                     <tr>
                     <td><label>Pick a Date</label></td>
                    <td><input type="text" id="datepicker" name="date" placeholder="Date" ></td>
                    </tr>
                    <tr>
                    <td><label>Select Number of Tickets</label></td>
                    <td><input type="text" id="SeatNumber" name="seat"></td>
                    </tr>
                	<td><input type="hidden" name="fname" value="${user}" /></td>
                 
                    
                   </div>
                  <tr><td><input type="submit" value="BUY NOW"  class="btn btn-black"></td></tr>
                  <script>
                      function getSelectedValue(){
                          var moviename = document.getElementById("movies").value;
                          var time = document.getElementById("Time").value;
                          var date = document.getElementById("date").value;
                          
                      }
                   </script>
                  
               </form>
                  </table>
            </div>
         </div>
      </div>
</body>
</html>