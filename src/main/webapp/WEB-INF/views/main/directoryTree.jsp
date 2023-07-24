<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>User Directories</title>
  <!-- Add any necessary CSS or JavaScript files here -->
</head>
<body>

<h2>User Directories</h2>

<div id="directoryTree">
  <!-- The directories will be populated here as a tree -->
</div>

<script>
  // Assuming the "directories" array is available in the view
  const directories = ${directories};

  function buildDirectoryTree(directories, parentId, level) {
    const container = document.getElementById("directoryTree");
    const ul = document.createElement("ul");
    container.appendChild(ul);

    directories.filter(directory => directory.parentDirectory?.id === parentId)
            .forEach(directory => {
              const li = document.createElement("li");
              li.textContent = "-".repeat(level) + " " + directory.name;
              ul.appendChild(li);

              buildDirectoryTree(directories, directory.id, level + 1);
            });
  }

  window.addEventListener("load", function () {
    buildDirectoryTree(directories, null, 0);
  });
</script>

</body>
</html>
