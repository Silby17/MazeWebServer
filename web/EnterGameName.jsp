<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<!-- Stylesheets -->
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/skeleton.css">
<link rel="stylesheet" href="css/layout.css">
<head>
    <title>Please Enter Game Name</title>
</head>
<body>
<div class="container">
    <div class="form-small">
        <form action="MultiGameNameRequestServlet" method="post">
            <h2>Please enter in Game Name</h2>
            <p><input type="text" placeholder="Game Name" name="gameName"></p>
            <button type="submit">Login</button>
        </form>
    </div>
</div>
</body>
</html>