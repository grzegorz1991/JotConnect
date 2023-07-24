<!DOCTYPE html>
<html>
<head>
    <title>Main Page</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Include any other necessary CSS stylesheets and JavaScript files here -->
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
<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }
</style>

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

    // Log the notes array to the console
    console.log("List of Notes:", notes);

    window.addEventListener("load", function () {
        populateTable();
    });
</script>

</body>
</html>
