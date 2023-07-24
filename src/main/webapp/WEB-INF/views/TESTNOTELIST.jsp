<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<%@ include file="main/mainHeader.jspf" %>
<body>
<div class="container-scroller">

    <%@ include file="main/mainNavbarLeft.jspf" %>
    <div class="container-fluid page-body-wrapper">
        <%@ include file="main/mainNavbarTop.jspf" %>
        <%@ include file="main/mainPanel.jspf" %>
        <!-- Add this section to display the user's notes -->
        <div class="container">
            <h2>User Notes tst</h2>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Titles</th>
                    <th>Contents</th>
                    <th>Created Datse</th>
                </tr>
                </thead>
                <tbody id="notesTableBody">
                <!-- The user's notes will be dynamically added here -->
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="main/mainBottomScripts.jspf" %>
<!-- JavaScript code to fetch and display user's notes -->
<script>
    // Function to fetch the user's notes and display them in the table
    function displayUserNotes() {
        console.log("Fetching user's notes...");
        fetch("/user/notes")
            .then(response => response.json())
            .then(data => {
                console.log("Received data:", data);
                const notesTableBody = document.getElementById("notesTableBody");

                // Clear the existing table rows
                notesTableBody.innerHTML = "";

                // Loop through the data (user notes) and create table rows for each note
                data.forEach(note => {
                    const row = document.createElement("tr");
                    row.innerHTML = `
            <td>${note.title}</td>
            <td>${note.content}</td>
            <td>${note.createdDate}</td>
          `;
                    notesTableBody.appendChild(row);
                });
            })
            .catch(error => {
                console.error("Error fetching user's notes:", error);
            });
    }

    // Call the function to display the user's notes when the page loads
    window.addEventListener("load", function() {
        console.log("Page loaded. Fetching user's notes...");
        displayUserNotes();
    });
</script>
</body>
</html>
