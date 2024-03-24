<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Add Test Results</title>

  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-image: url('https://image.slidesdocs.com/responsive-images/slides/0-smart-technology-work-report-powerpoint-background_d91c025997__960_540.jpg'); 
      background-size: cover;
      background-position: center;
      height: 100vh;
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .form-container {
      background-color: rgba(255, 255, 255, 0.8);
      padding: 20px;
      border-radius: 10px;
      width: 70%;
    }
  </style>
</head>
<body>

  <div class="form-container">
    <form method="post" action="appointments?action=add-test-result">
      <div class="form-group">
        <h1>${testName} Results</h1>
        <h4 style="color: red;">${message}</h4>
        <label for="message">Enter Result:</label>
         <input hidden type="number" value=${userId} name="userId" >
        <input hidden type="number" value=${appointmentId} name="appointmentId" >
           <input hidden type="text" value=${testName} name="testName" >
        <textarea type="text" class="form-control" required="required" minlength="3" name="result" rows="10"></textarea>
      </div>
      <button type="submit" class="btn btn-primary">Submit Results</button>
    </form>
  </div>

</body>
</html>