<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Technician Dashboard</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .container {
      margin-top: 50px;
    }
  </style>
</head>
<body>
  <div class="container">
    <div class="text-right mb-2">Welcome to Technician Dashboard ${username} <span><a href="/webapp/login" class="btn btn-warning" >Logout</a></span> </div>
    <h3 class="text-center mb-4">Technician Dashboard</h3>
    <div class="table-responsive">
      <table class="table table-bordered table-striped text-center">
          <thead>
                <th>Appointment Id</th>
                <th>Appointment Date</th>
                 <th>Customer Name</th>
                 <th>Test Name</th>
                 <th>Doctor Name</th>
                <th>Status</th>
                <th>Description</th>
                <th>Add Test result</th>
                <th>View Test Result</th>
            </thead>
        <tbody>
         <tag:forEach var="appointment" items="${appointmentsList}">
          <tr>
            	<td>${appointment.getAppointmentId()}</td>
                <td>${appointment.getAppointment_datetime()}</td>
                <td>${appointment.getCustomerName()}</td>
                <td>${appointment.getTestName()}</td>
                 <td>${appointment.getDoctorName()}</td>
                 <td>${appointment.getStatus()}</td>
                 <td>${appointment.getDescription()}</td>
                  <td><a href="" class="btn btn-primary" >Add</a></td>
                  <td><a href="" class="btn btn-danger" >View</a></td>
          </tr>
        </tag:forEach>
        </tbody>
      </table>
    </div>
  </div>
</body>
</html>