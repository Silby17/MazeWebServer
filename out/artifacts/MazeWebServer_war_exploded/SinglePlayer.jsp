<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="css/mainMenu.css">
    <title>Single Player Game</title>
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
    <form action="SinglePlayerServlet" method="post">
        <button id="getMazeBtn" type="button" name="action" value="StartNewGame">Start New Game</button>
        <button id="getSolution" type="button" name="action">Get Suggestion</button>
        <button type="submit" name="action" value="Return">Return to Main Menu</button>
        <input type="text" id="inputMazeName"  style="visibility: hidden" placeholder="Enter Maze Name">
    </form>
</div>
<canvas id="myCanvas" width="1000" height="550"></canvas>

<!--The following code will get the icon from the current users session-->
<%
    {%><img id="myImg" src="<%=icon%>" width="40" height="40"
            style="float:left" style="visibility: hidden" align="center"/> <%
    }
%>

<!--The definitions of the script sources-->
<script src = "MazeActions.js"></script>
<script src="./jquery-2.2.4.js"></script>
<script src="SinglePlayer.js"></script>
</body>
</html>