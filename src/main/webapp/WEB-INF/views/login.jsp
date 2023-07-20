<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>JotConnect - Login</title>
    <link rel="stylesheet" href="/static/css/style.css">
    <link rel="stylesheet" href="/static/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="/static/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="shortcut icon" href="/static/images/JConn-Logo.png"/>
    <style>
        .cloud-error-message {
            background-color: #f8d7da;
            border: 1px solid #f5c6cb;
            border-radius: 5px;
            padding: 10px;
            margin-bottom: 10px;
            display: inline-block;
        }

        .error-icon {
            font-size: 24px;
            margin-right: 5px;
        }

        .error-text {
            font-weight: bold;
        }
    </style>

</head>
<body>
<div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="row w-100 m-0">
            <div class="content-wrapper full-page-wrapper d-flex align-items-center auth login-bg">
                <div class="card col-lg-4 mx-auto">
                    <div class="card-body px-5 py-5">
                        <h3 class="card-title text-left mb-3">JotConnect Login</h3>
                        <form action="/login" method="post">
                            <div class="form-group">
                                <label>Username</label>
                                <input type="text" class="form-control p_input" name="username">
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" class="form-control p_input" name="password">
                            </div>
                            <div class="form-group d-flex align-items-center justify-content-between">
                                <div class="form-check">
                                    <input type="checkbox" class="form-check-input" id="rememberMe" name="rememberMe">
                                    <label class="form-check-label" for="rememberMe">Remember me</label>
                                </div>
                                <a href="/construction" class="forgot-pass">Forgot password</a>
                            </div>
                            <div class="text-center">
                                <% if (request.getParameter("error") != null) { %>
                                <div class="cloud-error-message">
                                    <span class="error-icon">&#9888;</span>
                                    <span class="error-text">Invalid username or password</span>
                                </div>
                                <% } %>
                                <button type="submit" class="btn btn-primary btn-block enter-btn">Login</button>
                            </div>
                            <p class="sign-up">Don't have an Account? <a href="/register">Sign Up</a> or <a href="/guest">Continue as Guest</a></p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



<script src="/static/vendors/js/vendor.bundle.base.js"></script>
<script src="/static/js/off-canvas.js"></script>
<script src="/static/assets/js/hoverable-collapse.js"></script>
<script src="/static/assets/js/misc.js"></script>
<script src="/static/assets/js/settings.js"></script>
<script src="/static/assets/js/todolist.js"></script>
</body>
</html>
