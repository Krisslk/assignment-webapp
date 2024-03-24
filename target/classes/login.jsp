<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
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
       flex-direction: column; 
      height: 30vh;
    }


  </style>
</head>
<body>

 
  <div class="title-container">
    <h1 style="color: white;margin-top: 30%;" >Technician Login</h1>
    <h4 style="color: yellow;">${message}</h4>
  </div>

 <div class="col-md-12">
    <div class="text-center">    
  
        <form method="post" action="login">

         
            <div style="margin-top: 7%;">

              <input placeholder="Username" required="required" value=""  style="margin-top: 1%; width: 30%;" type="text" minlength="2" maxlength="25" name="TechUsername"><br/>
              <input placeholder="Password" required="required" value=""  style="margin-top: 1%; width: 30%;" type="password"  minlength="1" maxlength="50" name="TechPass"><br/>
 
            </div>
             
            <button type="submit" style="margin-top: 2%;" class="btn btn-warning">Login</button>	
            <a  style="margin-top: 2%;"  href="/webapp" class="btn btn-danger">Go Back</a>	
          </form>	
 

    </div>
  </div>



   
</body>
</html>