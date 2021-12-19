<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="mypack.property"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<% ArrayList<property> property_data = (ArrayList<property>)request.getAttribute("property_data");
%>

<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>EstateAgency Bootstrap Template - Index</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: EstateAgency - v4.7.0
  * Template URL: https://bootstrapmade.com/real-estate-agency-bootstrap-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>
<body>
<section class="property-grid grid">
<div class="container">
<div class="row">
    <% for(property row : property_data) { %>

    <div class="col-md-4">
    <div class="card-box-a card-shadow">
      <div class="img-box-a">
        <img src="assets/img/property-8.jpg" alt="" class="img-a img-fluid">
      </div>
      <div class="card-overlay">
        <div class="card-overlay-a-content">
          <div class="card-header-a">
            <h2 class="card-title-a">
              <a href="#"><br/><% out.print(row.name); %></a>
            </h2>
          </div>
          <div class="card-body-a">
            <div class="price-box d-flex">
              <span class="price-a"><% out.print(row.sell_type); %> | <% out.print(row.price); %></span>
            </div>
            <a href="property-single.html" class="link-a">Click here to view
              <span class="bi bi-chevron-right"></span>
            </a>
          </div>
          <div class="card-footer-a">
            <ul class="card-info d-flex justify-content-around">
              <li>
                <h4 class="card-info-title">Area</h4>
                <span><% out.print(row.area); %>m
                  <sup>2</sup>
                </span>
              </li>
              <li>
                <h4 class="card-info-title">Bedrooms</h4>
                <span><% out.print(row.bedrooms); %></span>
              </li>
              <li>
                <h4 class="card-info-title">Bathrooms</h4>
                <span><% out.print(row.bathrooms); %></span>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>

<% } %>
</div>
</div>
</section>

</body>
</html>