<h2>Note Table</h2>
<table>
  <thead>
  <tr>
    <th>Title</th>
    <th>Author</th>
  </tr>
  </thead>
  <tbody id="noteTableBody">
  <!-- The notes will be populated here -->
  </tbody>
</table>
<script>
  console.log("notes table log!");
</script>
<script>
  function fetchNotes() {
    fetch("/notes")
            .then(response => response.json())
            .then(notes => {
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
            })
            .catch(error => {
              console.error("Error fetching notes:", error);
            });
  }

  window.addEventListener("load", function () {
    fetchNotes();
  });
</script>
