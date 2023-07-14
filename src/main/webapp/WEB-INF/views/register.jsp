<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>JotConnect - Register</title>
    <link rel="stylesheet" href="/static/css/style.css">
    <link rel="stylesheet" href="/static/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="/static/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="shortcut icon" href="/static/images/JConn-Logo.png"/>
</head>
<body>
<div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="row w-100 m-0">
            <div class="content-wrapper full-page-wrapper d-flex align-items-center auth login-bg">
                <div class="card col-lg-4 mx-auto">
                    <div class="card-body px-5 py-5">
                        <h3 class="card-title text-left mb-3">Register</h3>
                        <form action="saveUser" method="post">
                            <div class="form-group">
                                <label>Username</label>
                                <input type="text" class="form-control p_input" name="username"
                                       value="${user.username}">
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" class="form-control p_input" name="email" value="${user.email}">
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" class="form-control p_input" name="password"
                                       value="${user.password}">
                            </div>
                            <div class="form-group d-flex align-items-center justify-content-between">
                                <div class="form-group">
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="agreeCheckbox" required>
                                        <label class="form-check-label" for="agreeCheckbox">I agree to the <a href="/termsAndConditions">terms and conditions</a></label>
                                    </div>
                                </div>
                                <p class="log-in">Already a member? <a href="/login">Log in</a></p>
                            </div>
                            <div class="text-center">
                                <div class="error-message">
                                    <c:if test="${not empty usernameError}">
                                        <p>${usernameError}</p>
                                    </c:if>
                                    <c:if test="${not empty emailError}">
                                        <p>${emailError}</p>
                                    </c:if>
                                </div>
                                <button type="submit" class="btn btn-primary btn-block enter-btn">Register</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../../assets/vendors/js/vendor.bundle.base.js"></script>
<script src="../../assets/js/off-canvas.js"></script>
<script src="../../assets/js/hoverable-collapse.js"></script>
<script src="../../assets/js/misc.js"></script>
<script src="../../assets/js/settings.js"></script>
<script src="../../assets/js/todolist.js"></script>
<script>
    // Function to clear password field on error message
    function clearPasswordField() {
        document.querySelector('input[name="password"]').value = '';
    }

    // Check if error message exists and clear password field if necessary
    document.addEventListener('DOMContentLoaded', function () {
        var errorMessage = document.querySelector('.error-message');
        if (errorMessage && errorMessage.innerHTML.trim() !== '') {
            clearPasswordField();
        }
    });
</script>
</body>
</html>
