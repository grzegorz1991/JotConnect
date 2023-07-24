<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<%@ include file="main/mainHeader.jspf" %>
<body>
<div class="container-scroller">
  <script src="/js/mainPage.js"></script>
  <script>
    console.log("JavaScript code loaded!");
  </script>
  <%@ include file="main/mainNavbarLeft.jspf" %>
  <div class="container-fluid page-body-wrapper">
    <%@ include file="main/mainNavbarTop.jspf" %>
    <%@ include file="main/mainPanel.jspf" %>

  </div>
</div>
</div>


<%@ include file="main/mainFooter.jspf" %>
</div>
<%@ include file="main/mainBottomScripts.jspf" %>
</body>
</html>