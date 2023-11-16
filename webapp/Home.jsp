<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['areas', 'areas in campus'],
          ['clg classroom',     9],
          ['playground',      5],
          ['garden', 11],
          ['cafeteria', 2],
          ['agriculture',    7]
        ]);

        var options = {
          title: 'Our Campus Sections'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript">
    google.charts.load("current", {packages:['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ["Admission/year", "%percent", { role: "style" } ],
        ["2019", 56, "#b87333"],
        ["2020", 76, "silver"],
        ["2022", 79, "gold"],
        ["2023", 89, "color: #e5e4e2"]
      ]);

      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        title: "Admissions",
        width: 600,
        height: 400,
        bar: {groupWidth: "95%"},
        legend: { position: "none" },
      };
      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
      chart.draw(view, options);
  }
  </script>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawVisualization);

      function drawVisualization() {
        // Some raw data (not necessarily accurate)
        var data = google.visualization.arrayToDataTable([
          ['year', 'Government', 'donations', 'buiesness', 'own-production', 'fees', 'donation_late admisiion'],
          ['2019',  165,      938,         522,             998,           450,      614.6],
          ['2020',  135,      1120,        599,             1268,          288,      682],
          ['2021',  157,      1167,        587,             807,           397,      623],
          ['2022',  139,      1110,        615,             968,           215,      609.4],
          ['2023',  136,      691,         629,             1026,          366,      569.6]
        ]);

        var options = {
          title : 'Financial Supports    >>>>>',
          vAxis: {title: 'amount'},
          hAxis: {title: 'year'},
          seriesType: 'bars',
          series: {5: {type: 'line'}}
        };

        var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawSeriesChart);

    function drawSeriesChart() {

      var data = google.visualization.arrayToDataTable([
        ['ID', 'Result with high %', '--%', 'Campuses',     'Number'],
        ['zoo',    80.66,              1.67,      'North America',  33739900],
        ['chem',    79.84,              1.36,      'Europe',         81902307],
        ['CSE',    78.6,               1.84,      'Europe',         5523095],
        ['ME',    72.73,              2.78,      'Middle East',    79716203],
        ['MET',    80.05,              2,         'Europe',         61801570],
        ['BOT',    72.49,              1.7,       'Middle East',    73137148],
        ['AERO',    68.09,              4.77,      'Middle East',    31090763],
        ['PHY',    81.55,              2.96,      'Middle East',    7485600],
        ['MATH',    68.6,               1.54,      'Europe',         141850000],
        ['CE',    78.09,              2.05,      'North America',  307007000]
      ]);

      var options = {
        title: 'Result of College In Every region  or globally',
        hAxis: {title: 'Result per %'},
        vAxis: {title: 'Rate of %'},
        bubble: {textStyle: {fontSize: 11}}
      };

      var chart = new google.visualization.BubbleChart(document.getElementById('series_chart_div'));
      chart.draw(data, options);
    }
    </script>
</head>

<body>
<header>
        <div class="navbar">
            <nav>
            <a><img src="LOGOPHD-removebg-preview.png" alt="Logo"></a>
            <div class="nav-links" id="navLinks">
                
                <ul>
                    <li><a href="Index.html">HOME</a></li>
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
                    <li><div class="dropdown">
  <button class="dropbtn">LOGIN</button>
  <div class="dropdown-content">
    <a href="Login_student.jsp">STUDENT-LOGIN</a>
    <a href="Login_staff.jsp">STAFF-LOGIN</a>
    <a href="Login_normal_user.jsp">NORMAL USER-LOGIN</a>
  </div>
</div></li>
                    <li><div class="dropdown">
  <button class="dropbtn">REGISTER</button>
  <div class="dropdown-content">
    <a href="Student-redg.html">STUDENT</a>
    <a href="Staff-redg.html">STAFF</a>
    <a href="Normal_user-redg.html">NORMAL USER</a>
  </div>
</div></li>
                </ul>
            </div>
            <i class="fa-solid fa-bars" onclick="showMenu()"></i>
        </nav>
        </div>
    </header>
    <section class="header-h">
    
          <div class="text-box">
            <h1>we offer the Best For You</h1>
            <p>“No research without action, no action without research”</p>
            <a href="Visit.jsp" class="hero-btn"> Visit Us To Know More</a>

        </div>  
       
    </section>
	<section class="row">
	<div class="r-left ">
         <div id="piechart" style="width: 600px; height: 500px;"></div>
         </div>
         <div class="r-right">
         <div id="columnchart_values" style="width: 600px; height: 500px;"></div>
         </div>
         </section>
         <section class="row">
	
         <div id="chart_div" style="width: 1000px; height: 600px;"></div>
         
         </section>
         <div id="series_chart_div" style="width: 900px; height: 500px;"></div>
         
         <footer>
        <div class="foot-pannel1">
       Enroll for our various Courses in Online ,From anywhere and anytime
        </div>
        <div class="foot-pannel2">
            <ul>
                <p>Get to Connect Us</p>
                <a href="">Careers</a>
                <a href="">Blog</a>
                <a href="About.html">About us</a>
                <a href="">Authorities</a>
                
            </ul>
            <ul>
                <p>General</p>
                <a href="">Holidaylist </a>
                <a href="">Login</a>
                <a href="">Admission</a>
                <a href="">course fee</a>
                
            </ul>
            <ul>
                <p>Connect</p>
                <a href="">image galary</a>
                <a href="">vedio galery</a>
                <a href="">Media coverage</a>
                <a href="">News letter</a>
            </ul>
            <ul>
                <p>Let Us Help You</p>
                <a href=""> COVID-19</a>
                <a href="">Your Account</a>
                <a href="">Manage Your Account</a>
                <a href="">Our Assistant</a>
                <a href="">Help</a>
            </ul>
        </div>
        <div class="foot-pannel3">
            <div class="logo"></div>
        </div>
        <div class="foot-pannel4">
            <div class="pages">
                <a> first duty of a university is to teach wisdom, not trade; character, not technicalities</a>
            </div>
            <div class="copy">
                © 1996-2023,Ph.D Dashboard
                
            </div>
        </div>
    </footer>
</body>
</html>