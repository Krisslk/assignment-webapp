<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Report View</title>
  <!-- Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: rgb(43, 43, 47);
      background-size: cover;
      background-position: center;
    }
    .report-container {
      max-width: 800px;
      margin: 0 auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      margin-top: 10%;
    }
    .report-description {
      font-size: 18px;
      text-align: center;
      margin-bottom: 5%;
    }
  </style>
</head>
<body>

  <div class="report-container" id="reportContent" >
    <h2 class="text-center mb-4">${appointment.getTestName()} Report</h2>
    <div class="row">
      <div class="col-md-6">
        <p><strong>Customer Name:</strong>${appointment.getCustomerName()}</p>
        <p><strong>Test Name:</strong>${appointment.getTestName()}</p>
        <p><strong>Doctor Name:</strong>${appointment.getDoctorName()}</p>
        <p><strong>Appointment Date:</strong>${appointment.getAppointment_datetime()}</p>
        <p><strong>Appointment Description:</strong>${appointment.getDescription()}</p>
        <p><strong>Technician Name:</strong> ${appointment.getTestResultCreatedUserName()}</p>
      </div>
    </div>
    <div class="row mt-2">
      <div class="col-md-12">
        <h4 class="text-center">Test Result Description</h4>
        <p class="report-description">${appointment.getTestResultDesc()}</p>
      </div>
    </div>
  </div>

  <div class=row style="margin-left: 10%;margin-top: 2%;" >
    <a class="btn btn-warning" id="printBtn" >Print Report</a>
    <a class="btn btn-primary" href="/webapp/appointments?action=view-dashboard-technician" >Go Back</a>
  </div>

  <script src=
  "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
     </script>
     <script src=
 "https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js">
     </script>
      <script src=
      "https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.4.1/html2canvas.min.js">
         </script>

  <script type="text/javascript">

    $(document).ready(()=>{

      $('#printBtn').click(e=>{
    
        const { jsPDF } = window.jspdf;
 
        let doc = new jsPDF('l', 'mm', [700, 800]);
            let pdfjs = document.querySelector('#reportContent');
 
            doc.html(pdfjs, {
                callback: function(doc) {
                    doc.save("newpdf.pdf");
                },
                x: 12,
                y: 12
            });   


      });

    });


  </script>

</body>
</html>