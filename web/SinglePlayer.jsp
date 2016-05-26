<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="css/mainMenu.css">
</head>
<body>
<canvas id="myCanvas" width="1000" height="1000"></canvas>
<script src="MazeActions.js"></script>
<!--This java code will get the players icon from the session and
use it has their players piece that will move within the maze-->
<li>
    <% String icon = "images/Icons/";
        String iconName = (String) session.getAttribute("icon");
        icon += iconName;
        {%><img id="myImg" src="<%=icon%>" width="40" height="40"
                style="float:left" align="center"/> <%
    }
%>
</li>
<ul div style="float: right">
    <li>
        <button type="button"><a href="MainMenu.jsp">Back</a></button>
    </li>
    <li>
        <button type="button"><a href="SinglePlayer.jsp">Reset</a></button>
    </li>
    <li>
        <button type="button"><a href="SinglePlayer.jsp">Suggestion</a></button>
    </li>
</ul>
</body>
</html>