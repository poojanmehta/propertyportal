<%@ page import = "java.io.*,java.util.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="mypack.property"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<% ResultSet property_data=(ResultSet)request.getAttribute("property_data"); %>

<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Edit PROPERTY</title>
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
<nav class="navbar navbar-default navbar-trans navbar-expand-lg fixed-top">
    <div class="container">
      <button class="navbar-toggler collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#navbarDefault" aria-controls="navbarDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span></span>
        <span></span>
        <span></span>
      </button>
      <a class="navbar-brand text-brand">PROPERTY<span class="color-b">PORTAL</span></a>

      <div class="navbar-collapse collapse justify-content-center" id="navbarDefault">
        <ul class="navbar-nav">

          <li class="nav-item">
            <a class="nav-link " href="index.html">Home</a>
          </li>

          <li class="nav-item">
            <a class="nav-link " href="">Account</a>
          </li>

        </li>
        </ul>
      </div>

      <button type="button" class="btn btn-b-n navbar-toggle-box navbar-toggle-box-collapse" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01">
        <i class="bi bi-search"></i>
      </button>

    </div>
  </nav><!-- End Header/Navbar -->

<section class="contact">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 section-t8">
          <div class="row">
            <div class="col-md-7">
              <form action="editproperty" method="post" role="form" class="php-email-form">
                <% property_data.absolute(1); %>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="text" name="name" value="<c:out value='${property_data.getString("name")}' />" class="form-control form-control-lg form-control-a" placeholder="Name" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="text" rows="3" name="city" value="<c:out value='${property_data.getString("city")}' />" class="form-control form-control-lg form-control-a" placeholder="city" required>
                    </div>
                  </div>
                  <div class="col-md-4 mb-3">
                    <label class="pb-2" for="Type">Enter Address</label>
                  </div>
                  <div class="col-md-8 mb-3">
                    <div class="form-group">
                      <input rows="2" name="address" value="<c:out value='${property_data.getString("address")}' />" class="form-control form-control-lg form-control-a" placeholder="address" required>
                    </input>
                    </div>
                  </div>
                  <div class="col-md-12 mb-3">
                    <div class="form-group">
                      <input type="file" name="image">
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="number" name="area" value="<c:out value='${property_data.getString("area")}' />" class="form-control form-control-lg form-control-a" placeholder="area" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="number" name="floor" value="<c:out value='${property_data.getString("floor")}' />" class="form-control form-control-lg form-control-a" placeholder="floor" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="number" name="bedrooms" value="<c:out value='${property_data.getString("bedrooms")}' />" class="form-control form-control-lg form-control-a" placeholder="bedrooms" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="number" name="bathrooms" value="<c:out value='${property_data.getString("bathrooms")}' />" class="form-control form-control-lg form-control-a" placeholder="bathrooms" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input name="locality" type="text" value="<c:out value='${property_data.getString("locality")}' />" class="form-control form-control-lg form-control-a" placeholder="locality" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <select name="sell_type" value="<c:out value='${property_data.getString("sell_type")}' />" class="form-control form-select form-control-a" id="Type">
                        <option value="rent">For Rent</option>
                        <option value="sale">For Sale</option>
                      </select>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="number" name="price" value="<c:out value='${property_data.getString("price")}' />" class="form-control form-control-lg form-control-a" placeholder="price" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="number" name="available_days" value="<c:out value='${property_data.getString("available_days")}' />" class="form-control form-control-lg form-control-a" placeholder="available days" required>
                    </div>
                  </div>
                  <div class="col-md-12 text-center">
                    <input type="hidden" name="id" value="<c:out value='${property_data.getString("id")}' />"
                  </div>

                  <div class="col-md-12 text-center">
                    <button type="submit" class="btn btn-a">Update</button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section><!-- End Contact Single-->

  <footer>
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <nav class="nav-footer">
            <ul class="list-inline">
              <li class="list-inline-item">
                <a href="#">Home</a>
              </li>
              <li class="list-inline-item">
                <a href="#">Account</a>
              </li>
            </ul>
          </nav>
          
          <div class="copyright-footer">
            <p class="copyright color-text-a">
              &copy; Copyright
              <span class="color-a">PROPERTY PORTAL</span> All Rights Reserved.
            </p>
          </div>
         
          
        </div>
      </div>
    </div>
  </footer><!-- End  Footer -->