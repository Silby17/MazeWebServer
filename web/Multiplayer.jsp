<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="css/mainMenu.css">
    <title>Multiplayer</title>
</head>
<body background="/images/bg.jpg">

<ul style="float:right">
    <li><button>Back</button></li>

    <li> <% String icon = "images/Icons/";
        String iconName = (String)session.getAttribute("icon");
        icon += iconName;
        {%> <div style="float: right" id="userImage">
        <img src="<%=icon%>"/>
    </div><%}%></li>

    <li><% String username = (String) session.getAttribute("username");
        {%>
        <label><%=username%></label>
        <%}%></li>
</ul>

<div class="btn-group" style="float: left" >
    <form action="SinglePlayerServlet" method="post">
        <button id="getMazeBtn" type="button" name="action" value="StartNewGame">Start New Game</button>
        <button type="submit" name="action" value="Suggestion">Get Suggestion</button>
        <button type="submit" name="action" value="Return">Return to Main Menu</button>
        <input type="text" id="mazeNameInput" placeholder="Enter Maze Name">
    </form>
</div>

</body>
</html>
