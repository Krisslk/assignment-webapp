<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Welcome to ABC Laboratories</title>
  <!-- Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-image: url('https://img.freepik.com/free-photo/medicine-blue-background-flat-lay_23-2149341573.jpg'); /* Replace 'background.jpg' with the path to your image */
      background-size: cover;
      background-position: center;
      height: 100vh;
      margin: 0;
      padding: 0;
    }

    .title-container {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 15%;
    }

    .table-container {
      margin: 0 auto;
      margin-top: 2%;
      width: 50%;
    }

  </style>
</head>
<body>

  <div class="title-container">
    <h1 style="color: white;margin-top: 30%;" >Check your Appointments</h1>
  </div>

  <div class="text-center">
    <form method="post" action="appointments?action=get-appointment-status">
      <input placeholder="NIC number"  value="" required="required"  style="margin-top: 15%; width: 20%;" type="text"  minlength="10"  name="NICNo">
       <input placeholder="PIN code" value=""  required="required" style="margin-top: 15%; width: 8%;" type="text" minlength="4" maxlength="4" name="PINCode">
      <button type="submit" class="btn btn-primary">Check</button>			
    </form>	
    <a  style="margin-top: 1%;"  href="/webapp" class="btn btn-danger">Go Back</a>	
  </div>
  

  <div class="table-container">
    <table class="table table-dark">
        <tr>
            <thead>
                <th>Appointment Id</th>
                <th>Appointment Date</th>
                 <th>Test Name</th>
                 <th>Doctor Name</th>
                <th>Status</th>
                <th>Description</th>
            </thead>
        </tr>

        <tag:forEach var="appointment" items="${appointmentsList}">

            <tr>
               	<td>${appointment.getAppointmentId()}</td>
                <td>${appointment.getAppointment_datetime()}</td>
                    <td>${appointment.getTestName()}</td>
                   <td>${appointment.getDoctorName()}</td>
                 <td>${appointment.getStatus()}</td>
                 <td>${appointment.getDescription()}</td>
            </tr>

        </tag:forEach>

    </table>
  </div>
 
</body>
</html>