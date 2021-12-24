<%@ page import="java.io.*,java.util.*,java.sql.*" %>
  <%@ page import="javax.servlet.http.*,javax.servlet.*" %>
    <%@ page import="mypack.property" %>
      <%@ page import="mypack.User" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
          <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
            <% ResultSet user_data=(ResultSet)request.getAttribute("user_data"); %>
            <% ArrayList<property> property_data = (ArrayList<property>)request.getAttribute("property_data");
              %>

              <head>
                <meta charset="utf-8">
                <meta content="width=device-width, initial-scale=1.0" name="viewport">

                <title>USER PROFILE</title>
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
                  <button class="navbar-toggler collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarDefault" aria-controls="navbarDefault" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span></span>
                    <span></span>
                    <span></span>
                  </button>
                  <a class="navbar-brand text-brand">PROPERTY<span class="color-b">PORTAL</span></a>

                  <div class="navbar-collapse collapse justify-content-center" id="navbarDefault">
                    <ul class="navbar-nav">

                      <li class="nav-item">
                        <a class="nav-link " href="searchproperty.jsp">Home</a>
                      </li>

                      <li class="nav-item">
                        <a class="nav-link " href="user">Account</a>
                      </li>

                    </ul>
                  </div>

                  <button type="button" href="searchproperty.jsp"
                    class="btn btn-b-n navbar-toggle-box navbar-toggle-box-collapse" data-bs-toggle="collapse"
                    data-bs-target="#navbarTogglerDemo01">
                    <i class="bi bi-search"></i>
                  </button>

                </div>
              </nav><!-- End Header/Navbar -->

              <section class="intro-single">
                <div class="container">
                  <div class="row">

                  </div>
                </div>
              </section><!-- End Intro Single -->

              <!-- ======= Agent Single ======= -->
              <section class="agent-single">
                <div class="container">
                  <div class="row">
                    <div class="col-sm-12">
                      <div class="row">
                        <div class="col-md-5 section-md-t3">
                          <div class="agent-info-box">
                            <% user_data.absolute(1); %>
                              <div class="agent-content mb-3">
                                <div class="info-agents color-a">
                                  <p>
                                    <strong>Name: </strong>
                                    <span class="color-text-a">
                                      <% out.print(user_data.getString("Firstname")); %>
                                    </span>
                                  </p>
                                  <p>
                                    <strong>Lastname: </strong>
                                    <span class="color-text-a">
                                      <% out.print(user_data.getString("Lastname")); %>
                                    </span>
                                  </p>
                                  <p>
                                    <strong>Mobile: </strong>
                                    <span class="color-text-a">
                                      <% out.print(user_data.getString("Mobile")); %>
                                    </span>
                                  </p>
                                  <p>
                                    <strong>Email: </strong>
                                    <span class="color-text-a">
                                      <% out.print(user_data.getString("Email")); %>
                                    </span>
                                  </p>
                                  <p>
                                    <strong>City: </strong>
                                    <span class="color-text-a">
                                      <% out.print(user_data.getString("City")); %>
                                    </span>
                                  </p>
                                  <p>
                                    <strong>Location: </strong>
                                    <span class="color-text-a">
                                      <% out.print(user_data.getString("Location")); %>
                                    </span>
                                  </p>
                                  <p>
                                    <strong>State: </strong>
                                    <span class="color-text-a">
                                      <% out.print(user_data.getString("State")); %>
                                    </span>
                                  </p>
                                </div>
                              </div>
                          </div>
                        </div>
                        <div class="col-md-12 col-lg-4">
                          <nav aria-label="breadcrumb" class="breadcrumb-box d-flex justify-content-lg-end">
                            <ol class="breadcrumb">
                              <div class="col-md-12 text-center">
                                <button type="submit" class="btn btn-a">Logout</button>
                              </div>
                            </ol>
                          </nav>
                        </div>
                        <div class="col-md-12 section-t8">
                          <div class="title-box-d">
                            <h3 class="title-d">My Properties</h3>
                          </div>
                        </div>
                        <div class="row property-grid grid">
                          <div class="col-sm-12">
                            <div class="grid-option">
                              <form>
                                <select class="custom-select">
                                  <option selected>All</option>
                                  <option value="1">New to Old</option>
                                  <option value="2">For Rent</option>
                                  <option value="3">For Sale</option>
                                </select>
                              </form>
                            </div>
                          </div>
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
                                        <a href="#"><br />
                                          <% out.print(row.name); %>
                                        </a>
                                      </h2>
                                    </div>
                                    <div class="card-body-a">
                                      <div class="price-box d-flex">
                                        <span class="price-a">
                                          <% out.print(row.sell_type); %> | <% out.print(row.price); %>
                                        </span>
                                      </div>
                                      <div class="price-box d-flex">
                                        <span class="price-a">
                                          <a href="${pageContext.request.contextPath}/deleteproperty?id=<%=row.id%>"> delete </a>
                                        </span>
                                      </div>
                                      <div class="price-box d-flex">
                                        <span class="price-a">
                                          <a href="${pageContext.request.contextPath}/updateproperty?id=<%=row.id%>"> update </a>
                                        </span>
                                      </div>
                                      <a href="property-single.html" class="link-a">Click here to view
                                        <span class="bi bi-chevron-right"></span>
                                      </a>
                                    </div>
                                  
                                    <div class="card-footer-a">
                                      <ul class="card-info d-flex justify-content-around">
                                        <li>
                                          <h4 class="card-info-title">Area</h4>
                                          <span>
                                            <% out.print(row.area); %>m
                                              <sup>2</sup>
                                          </span>
                                        </li>
                                        <li>
                                          <h4 class="card-info-title">Bedrooms</h4>
                                          <span>
                                            <% out.print(row.bedrooms); %>
                                          </span>
                                        </li>
                                        <li>
                                          <h4 class="card-info-title">Bathrooms</h4>
                                          <span>
                                            <% out.print(row.bathrooms); %>
                                          </span>
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
                    </div>
              </section>



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