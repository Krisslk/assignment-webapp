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
  </style>
</head>
<body>

  <div class="title-container">
    <h1 style="color: white;margin-top: 30%;" >Check your Appointments</h1>
  </div>

  <div class="text-center">
    <form method="post" action="appointments?action=get-appointment-status">
      <input placeholder="NIC number"  value=""  style="margin-top: 15%; width: 20%;" type="text" name="NICNo">
       <input placeholder="PIN code" value=""  style="margin-top: 15%; width: 8%;" type="text" minlength="4" maxlength="4" name="PINCode">
      <button type="submit" class="btn btn-primary">Check</button>			
    </form>	
  </div>

 

</body>
</html>