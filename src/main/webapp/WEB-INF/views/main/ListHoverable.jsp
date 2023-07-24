
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
  async function fetchUserNotes() {
    try {
      const response = await fetch("http://localhost:8080/user/notes", {
        credentials: "include",
        headers: {
          "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/115.0",
          "Accept": "*/*",
          "Accept-Language": "pl,en-US;q=0.7,en;q=0.3",
          "Sec-Fetch-Dest": "empty",
          "Sec-Fetch-Mode": "cors",
          "Sec-Fetch-Site": "same-origin"
        },
        referrer: "http://localhost:8080/login",
        method: "GET",
        mode: "cors"
      });

      if (!response.ok) {
        throw new Error("Network response was not ok");
      }

      const data = await response.json();
      console.log("Received user's notes:", data);

      // Now you can use the 'data' to populate your table or perform other actions
      // For example, you can call another function to populate the table with the received data
      populateTable(data);
    } catch (error) {
      console.error("Error fetching user's notes:", error);
    }
  }

  function populateTable(notes) {
    // Populate your table here
    // 'notes' is an array of note objects received from the backend
    // Example: If your table body has an id 'noteTableBody', you can populate it like this:
    const tableBody = document.getElementById("noteTableBody");
    tableBody.innerHTML = "";

    notes.forEach(note => {
      const row = document.createElement("tr");
      row.innerHTML = `
                <td>${note.title}</td>
                <td>${note.author}</td>
            `;
      tableBody.appendChild(row);
    });
  }

  // Call the function to fetch user's notes when the window loads
  window.addEventListener("load", fetchUserNotes);
</script>


<h2>User Directoriesss</h2>
<c:forEach var="directory" items="${directories}">
  <h1>"${directory.id}">${directory.name}</h1>
</c:forEach>
<ul>
  <!-- Loop through the directories and display their names -->
  <c:forEach var="directory" items="${directories}">
    <li>${directory.name}</li>
  </c:forEach>
</ul>
<script>
  // Assuming the "directories" array is available in the view
  const directories = ${directories}; // This will retrieve the data from the model

  // Log the directories array to the console
  console.log("Directories:", directories);
</script>
</body>
</html>
