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
        <input type="text" id="inputMazeName"  style="visibility: hidden" placeholder="Enter Maze Name">
    </form>
</div>

<canvas id="myCanvas" width="1200" height="550"></canvas>
<!--img id="oppImg" src="images/Icons/oppImg.png" width="40" height="40"
     style="float:left" style="visibility: hidden" align="center"/-->
<%
    {%><img id="oppImg" src="images/Icons/oppImg.png" width="40" height="40"
            style="float:left" style="visibility: hidden" align="center"/> <%
    }
%>
<!--The following code will get the icon from the current users session-->
<%
    {%><img id="myImg" src="<%=icon%>" width="40" height="40"
            style="float:left" style="visibility: hidden" align="center"/> <%
    }
%>

<script src="./jquery-2.2.4.js"></script>
<script src = "MultiAction.js"></script>
<script src="Multiplayer.js"></script>
</body>
</html>