<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>ADD PROPERTY</title>
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

      <button type="button" href="property.jsp" class="btn btn-b-n navbar-toggle-box navbar-toggle-box-collapse" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01">
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
              <form action="addproperty" method="post" role="form" class="php-email-form">
                <div class="row">
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="text" name="name" class="form-control form-control-lg form-control-a" placeholder="Name" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="text" name="address" class="form-control form-control-lg form-control-a" placeholder="address" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="text" name="floor" class="form-control form-control-lg form-control-a" placeholder="floor" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input name="locality" type="text" class="form-control form-control-lg form-control-a" placeholder="locality" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="text" name="city" class="form-control form-control-lg form-control-a" placeholder="City" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="text" name="bedrooms" class="form-control form-control-lg form-control-a" placeholder="bedrooms" required>
                    </div>
                  </div>
                  
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="text" name="bathrooms" class="form-control form-control-lg form-control-a" placeholder="bathrooms" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="text" name="price" class="form-control form-control-lg form-control-a" placeholder="price" required>
                    </div>
                  </div>
                  <div class="col-md-12 my-3">
                    <div class="mb-3"></div>
                      <div class="error-message"></div>
                      <div class="sent-message">Your property details have been stored. Thank you!</div>
                    </div>
                  </div>

                  <div class="col-md-12 text-center">
                    <button type="submit" class="btn btn-a">SUBMIT</button>
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