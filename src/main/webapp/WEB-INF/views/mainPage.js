// mainPage.js
document.addEventListener("DOMContentLoaded", function () {
    // Get the user data from the session
    const loggedInUser = JSON.parse(sessionStorage.getItem("loggedInUser"));
    console.log(loggedInUser.username);
    // Check if the user is logged in (loggedInUser will be null if not logged in)
    if (loggedInUser) {
        // Display the user information on the page
        const usernameElement = document.getElementById("username");
        usernameElement.textContent = loggedInUser.username;

        const userTypeElement = document.getElementById("userType");
        userTypeElement.textContent = loggedInUser.userType;
    } else {
        // Redirect to the login page if the user is not logged in
        window.location.href = "/login";
    }
});
