 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>
<head>
<title>
Knowledge Explorer : login
</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="<spring:url value='/css/index.css'/>"/>

</head>
<body>
<div class="card card0 border-0">
    <div class="row d-flex">
        <div class="col-lg-6">
            <div class="card1 pb-5">
                <div class="row"> <img src='<spring:url value="/img/logo.png"/>' class="logo"> </div>
                <div class="row px-3 justify-content-center mt-4 mb-5 border-line"> <img src='<spring:url value="/img/uNGdWHi.png"/>' class="image"> </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="card2 card border-0 px-4 py-5">
                <div class="row mb-4 px-3">
                     <h7 style="color: red; background-color: white; margin-right: 50px; margin-left: 50px;">${requestScope.error}</h7>
                </div>
                <div class="row px-3 mb-4">
                    <div class="line"></div> <small class="text-center"><h1> &nbspSIGN IN &nbsp</h1></small>
                    <div class="line"></div>
                </div>
                <form action='<spring:url value="/login"/>' method="post">
                <div class="row px-3"> <label class="mb-1">
                        <h6 class="mb-0 text-sm">Email Address</h6>
                    </label> <input class="mb-4" type="text" name="email" placeholder="Enter a valid email address"> </div>
                <div class="row px-3"> <label class="mb-1">
                        <h6 class="mb-0 text-sm">Password</h6>
                    </label> <input type="password" name="password" placeholder="Enter password"> </div>
                <div class="row px-3 mb-4">
                     <a href="#" class="ml-auto mb-0 text-sm">Forgot Password?</a>
                </div>
                <div class="row mb-3 px-3"> <button type="submit" class="btn btn-blue text-center">Login</button> </div>
                </form>
                <div class="row mb-4 px-3"> <small class="font-weight-bold">Don't have an account? <a href='<spring:url value="/registrationPage"/>'class="text-danger ">Register</a></small> </div>
            </div>
        </div>
    </div>
    <div class="bg-blue py-4">
        <div class="row px-3"> <small class="ml-4 ml-sm-5 mb-2">Knowledge Explorer &copy; 2023. All rights reserved.</small>
            <div class="social-contact ml-4 ml-sm-auto"> <span class="fa fa-facebook mr-4 text-sm"></span> <span class="fa fa-google-plus mr-4 text-sm"></span> <span class="fa fa-linkedin mr-4 text-sm"></span> <span class="fa fa-twitter mr-4 mr-sm-5 text-sm"></span> </div>
        </div>
    </div>
</div>
</body>
<html>