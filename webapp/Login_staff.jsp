<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="Style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
        integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.2.1/css/fontawesome.min.css">
</head>
<body>
<div class="container">
        <div class="login-box">
            <form action="Login_staff" method="post">
                <h2>LOGIN to your Account!!!</h2>
                <div class="input-box">
                    <span class="icon"><i class="fa-solid fa-envelope"></i></i></span>
                    <input type="email" name="email" id="email" placeholder="Enter Email" required>
                </div>
                <div class="input-box">
                    <span class="icon"><i class="fa solid fa-lock "></i></span>
                    <input type="password" name="password" id="password" placeholder="Enter password" required>
                </div>
                <div class="remember-forgot">
                    <label for="remember">
                        <input type="checkbox">
                        Remember <Menu><a href="#">Forgot Password?</a></Menu>
                    </label>
                </div>
                <button type="submit">Login</button>
                <div class="resister-link">
                    <a href="Staff-redg.html">Don't have an account?Create New!</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>