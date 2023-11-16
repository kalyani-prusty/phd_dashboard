<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ph.D. Dashboard </title>
    <link rel="stylesheet" href="Style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
        integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<header>
        <div class="navbar">
            <nav>
            <a><img src="LOGOPHD-removebg-preview.png" alt="Logo"></a>
            <div class="nav-links" id="navLinks">
                
                <ul>
                    <li><a href="Index.html">HOME</a></li>
                    <li><a href="Home.jsp">DASHBOARD</a></li>
                    <li><li><div class="dropdown">
  <button class="dropbtn">ABOUT</button>
  <div class="dropdown-content">
    <a href="Precident-about.html">Precident's Message</a>
    <a href="Principal-msg.html">Vice Precident's Desk</a>
    <a href="college-admin.html">College Administration</a>
  </div>
</div></li></li>
                    <li><a href="Course.html">COURSE</a></li>
                    <li><a href="Research.html">RESEARCH</a></li>
                    <li><a href="Contact.html">CONTACT</a></li>
                    <li>
    <a href="Login_student.jsp">LOGOUT</a>
    </li>
                    <li><div class="dropdown">
  <button class="dropbtn">MY DETAILS</button>
  <div class="dropdown-content">
    <a href="ReportofStudentsubmi.jsp">REPORT</a>
    <a href="Staff-redg.html">CLASS</a>
    <a href="Normal_user-redg.html">ASSIGNMENT</a>
    <a href="Normal_user-redg.html">UPLOADED THESIS</a>
  </div>
</div></li>
                </ul>
            </div>
            <i class="fa-solid fa-bars" onclick="showMenu()"></i>
        </nav>
        </div>
    </header>
    <section class="re-body_u">
    
    <div class="container-r_u">
  		<i class="fa-solid fa-user fa-5x"></i>
  		<form action="Class_attendance_retrive" method="post">
  <div class="row">
    <div class="col">
      <input type="text" class="form-control" value="${roll}" name="roll">
    </div>
    <div class="col">
      <input type="text" class="form-control" value="${atten}" name="atten">
    </div>
    <div class="col">
      <input type="date" class="form-control" value="${date}" name="date">
    </div>
    
  </div>
</form>
        
       
    </div>
</section>

</body>
</html>