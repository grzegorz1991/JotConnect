<!DOCTYPE html>
<html>
<head>
    <title>Main Page</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

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
    // Mock data of notes (replace this with your actual data)
    const notes = [
        { title: 'Test note 1', author: 'Tester Name' },
        { title: 'Test note 2', author: 'Tester Name' },
        { title: 'Welcome User', author: 'User' },
        { title: 'Welcome Admin', author: 'Admin' },
    ];

    function populateTable() {
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

    window.addEventListener("load", function () {
        populateTable();
    });
</script>

</body>
</html>
