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

<section class="contact">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 section-t8">
          <div class="row">
            <div class="col-md-8">
              <form action="addproperty" method="post" role="form" class="php-email-form">
                <div class="row">
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="text" name="name" class="form-control form-control-lg form-control-a" placeholder="Name" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="text" rows="3" name="city" class="form-control form-control-lg form-control-a" placeholder="city" required>
                    </div>
                  </div>
                  <div class="col-md-4 mb-3">
                    <label class="pb-2" for="Type">Enter Address</label>
                  </div>
                  <div class="col-md-8 mb-3">
                    <div class="form-group">
                      <textarea rows="2" name="address" class="form-control form-control-lg form-control-a" placeholder="address" required>
                      </textarea>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="number" name="area" class="form-control form-control-lg form-control-a" placeholder="area" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="number" name="floor" class="form-control form-control-lg form-control-a" placeholder="floor" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="number" name="bedrooms" class="form-control form-control-lg form-control-a" placeholder="bedrooms" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="number" name="bathrooms" class="form-control form-control-lg form-control-a" placeholder="bathrooms" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input name="locality" type="text" class="form-control form-control-lg form-control-a" placeholder="locality" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <select name="sell_type" class="form-control form-select form-control-a" id="Type">
                        <option value="rent">For Rent</option>
                        <option value="sale">For Sale</option>
                      </select>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="number" name="price" class="form-control form-control-lg form-control-a" placeholder="price" required>
                    </div>
                  </div>
                  <div class="col-md-6 mb-3">
                    <div class="form-group">
                      <input type="number" name="available_days" class="form-control form-control-lg form-control-a" placeholder="available days" required>
                    </div>
                  </div>
                  <div class="col-md-12 my-3">
                    <div class="mb-3"></div>
                      <div class="error-message"></div>
                      <div class="sent-message">Your property details have been stored. Thank you!</div>
                    </div>
                  </div>

                  <div class="col-md-12 text-center">
                    <button type="submit" class="btn btn-a">Add Property</button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section><!-- End Contact Single-->
