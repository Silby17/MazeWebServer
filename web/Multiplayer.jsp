<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="css/mainMenu.css">
    <title>Multiplayer</title>
</head>
<body background="/images/bg.jpg">
<div class="loader" style="display: none"></div>
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
    <form action="MultiplayerMazeServlet" method="post">
        <button id="getMazeBtn" type="button" name="action" >Start New Game</button>
        <button id="getSuggestionBtn" type="button" name="action">Get Suggestion</button>
        <button type="submit" name="action" value="Return">Return to Main Menu</button>
        <input type="text" id="inputMazeName"  placeholder="Enter Maze Name">
    </form>
</div>

<canvas id="myCanvas" width="1400" height="550"></canvas>

<script src="./jquery-2.2.4.js"></script>
<script src = "MultiActions.js"></script>
<script src="Multiplayer.js"></script>
</body>
</html>