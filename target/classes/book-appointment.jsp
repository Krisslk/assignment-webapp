<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Welcome to ABC Laboratories</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-image: url('https://img.freepik.com/free-photo/medicine-blue-background-flat-lay_23-2149341573.jpg'); 
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
       flex-direction: column; 
      height: 30vh;
    }


  </style>
</head>
<body>

  	<%
    	Object success = request.getAttribute("successStatus");
    	Boolean successStatus = false;
    	if(success!=null){
    		successStatus = Boolean.parseBoolean(success.toString());
    	}
    %>

  <div class="title-container">
    <h1 style="color: white;margin-top: 30%;" >Book Appointment</h1>
     <div>
      <h4 style="color: yellow;">${message}</h4>
      <%
      	if(successStatus){
      %>
      	<a  style="margin-top: 2%;"  href="/webapp" class="btn btn-danger">Go Back</a>	
      <%
      	}
      %>
    </div>
  </div>

 <div class="col-md-12">
    <div class="text-center">    
    <%
    	if (!successStatus) { 
	%>
        <form method="post" action="appointments?action=book-appointment">
            <input placeholder="NIC number" required="required"  value=""  style="margin-top: 10%; width: 20%;" type="text"  minlength="10" maxlength="10"  name="NICNo"><br/>
            <div style="margin-top: 1%;">
                <span >note down this pin code</span>
                <input placeholder="PIN code" readonly   style=" width: 5%;" type="text" minlength="4" maxlength="4" name="PINCode"  id="PINCode"><br/>
            </div>
             <input placeholder="Patient Name" required="required" value=""  style="margin-top: 1%; width: 30%;" type="text" minlength="2" maxlength="25" name="PatientName"><br/>
             <input placeholder="Phone Number" required="required" value=""  style="margin-top: 1%; width: 30%;" type="text" minlength="2" maxlength="10" name="PhoneNo"><br/>
             <textarea style="margin-top: 1%;  width: 30%;" name="desc" placeholder="explain your medicial condition"   >sugar test</textarea><br/>

             <label>Select a doctor</label>
            <select required="required" style="margin-top: 1%;" name="doctorId">
            	 <tag:forEach var="doctor" items="${doctorsList}">
                <option value="${doctor.getDoctorId()}" >${doctor.getDoctorName()}</option>
                </tag:forEach>
            </select>

            <br/>

            <label>Select a Test</label>
            <select required="required" style="margin-top: 1%;" name="testId" id="">
            	 <tag:forEach var="test" items="${testsList}">
                <option value="${test.getTestId()}" >${test.getTestName()}</option>
                </tag:forEach>
            </select>

            <br/>

            <span>Appointment Date </span>
            <input required="required" placeholder="Appointment Date" value=""  style="margin-top: 1%; width: 15%;" type="date"  name="appointmentDate"><br/>

            <button type="submit" style="margin-top: 2%;" class="btn btn-warning">Book Now</button>	
            <a  style="margin-top: 2%;"  href="/webapp" class="btn btn-danger">Go Back</a>	
          </form>	
          
   <%
    	}
   %>

    </div>
  </div>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

<script>
    $( document ).ready(function() {
        const randomNum = Math.random() * 9000
        const token = Math.floor(1000 + randomNum)
        $('#PINCode').val(token);
    });
</script>
   
</body>
</html>