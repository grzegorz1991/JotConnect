
<!-- Add this section to display the user's notes -->
<div class="container">
  <h2>User Notes</h2>
  <table class="table table-hover">
    <thead>
    <tr>
      <th>Title</th>
      <th>Content</th>
      <th>Created Date</th>
    </tr>
    </thead>
    <tbody id="notesTableBody">
    <!-- The user's notes will be dynamically added here -->
    </tbody>
  </table>
</div>
<script>
  // Function to fetch the user's notes and display them on the page
  function displayUserNotes() {
    fetch("/user/notes")
            .then(response => response.json())
            .then(notes => {
              // Get the table body element
              const tableBody = document.getElementById("notesTableBody");

              // Clear the existing table rows
              tableBody.innerHTML = "";

              // Loop through the notes and create table rows for each note
              notes.forEach(note => {
                const row = document.createElement("tr");
                row.innerHTML = `
            <td>${note.title}</td>
            <td>${note.content}</td>
            <td>${note.createdDate}</td>
          `;
                tableBody.appendChild(row);
              });
            })
            .catch(error => {
              console.error("Error fetching user's notes:", error);
            });
  }

  // Call the function to display the user's notes when the page loads
  window.addEventListener("load", function() {
    displayUserNotes();
  });
</script>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>User Notes</title>
</head>
<body>
<h1>User Notes</h1>
<div id="notesContainer"></div>

<script>
  // Function to fetch the user's notes and display them on the page
  function displayUserNotes() {
    fetch("/user/notes")
            .then(response => response.json())
            .then(notes => {
              const notesContainer = document.getElementById("notesContainer");
              if (notes.length === 0) {
                notesContainer.innerHTML = "<p>No notes found for this user.</p>";
              } else {
                notesContainer.innerHTML = "<ul>";
                notes.forEach(note => {
                  notesContainer.innerHTML += `<li>Title: ${note.title}, Content: ${note.content}</li>`;
                });
                notesContainer.innerHTML += "</ul>";
              }
            })
            .catch(error => {
              console.error("Error fetching user's notes:", error);
            });
  }

  // Call the function to display the user's notes when the page loads
  window.addEventListener("load", function () {
    displayUserNotes();
  });
</script>
</body>
</html>
