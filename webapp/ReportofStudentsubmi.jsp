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
  <button class="dropbtn">DETAILS</button>
  <div class="dropdown-content">
    <a href="ReportofStudentsubmi.jsp">REPORT</a>
    <a href="Staff-redg.html">CLASS</a>
    <a href="Normal_user-redg.html">ASSIGNMENT</a>
  </div>
</div></li>
                </ul>
            </div>
            <i class="fa-solid fa-bars" onclick="showMenu()"></i>
        </nav>
        </div>
    </header>
    <section class="re-body_u">
    
    <div class="container-r_u ">
  		<i class="fa-solid fa-user fa-5x"></i>
  		
        <table > 
       	 <form action="Report_In_by_staff" method="post"> 
            <tr> 
                <td> 
                    <label  for="branch"> 
                        Branch Name :
                    </label> 
                </td> 
                <td><input type="text" placeholder="Enter student branch" name="bname" /> 
                </td> 
            </tr> 
            <tr> 
                <td><label for="email"> 
                        Email :
                    </label> 
                </td> 
                <td><input type="email"placeholder="Enter student email" name="email" /> 
                </td> 
            </tr> 
            
            <tr> 
                <td><label for="Roll No."> 
                        Roll No.: 
                    </label> 
                </td> 
                <td><input type="number" placeholder="Enter student roll" name="rollno" /> 
                </td> 
            </tr> 
            <tr> 
                <td><label for=" TOTMarks"> 
                        TOTAL Marks:
                    </label> 
                </td> 
                <td><input type="number"placeholder="Enter student total mark"  name="totmarks" /> 
                </td> 
            </tr> 
            <tr> 
                <td><label for=" TOTCgpa"> 
                        TOTAL CGPA:
                    </label> 
                </td> 
                <td><input type="text" name="cgpa" /> 
                </td> 
            </tr> 
            <tr> 
                <td><label for=" grade"> 
                        Grade:
                    </label> 
                </td> 
                <td><input type="text" name="grades" /> 
                </td> 
            </tr> 
         		<tr><td><input type="submit" value="SUBMIT"></td></tr>
        </form> 
    </table> 
       
    </div>
</section>

</body>
</html>