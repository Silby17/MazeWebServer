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
    <form action="MultiplayerMazeServlet" method="post">
        <button id="getMazeBtn" type="button" name="action" value="StartNewGame">Start New Game</button>
        <button type="submit" name="action" value="Suggestion">Get Suggestion</button>
        <button type="submit" name="action" value="Return">Return to Main Menu</button>
        <input type="text" id="inputMazeName"  placeholder="Enter Maze Name">
    </form>
</div>
<canvas id="myCanvas" width="1400" height="550"></canvas>
<!--The following code will get the icon from the current users session-->
<%
    {%><img id="myImg" src="<%=icon%>" width="40" height="40"
            style="float:left" style="visibility: hidden" align="center"/> <%
    }
%>
<script src="./jquery-2.2.4.js"></script>
<script src = "MultiAction.js"></script>
<script>
    var current = 0;
    var gameName;
    var checkInterval;
    var mazeFromServer;
    var gameInPlay = false;

    $(function(){
        $('#getMazeBtn').click(function(){
            if(gameInPlay == true){
                if(confirm('Game in Play, are you sure you want to start again?')){
                    //TODO send close command
                }
            }
            if(confirm('Are you sure you want to start a new Game?')){
                checkInterval = setInterval(function() {getMaze()}, 15000);
            }
        });
    });

    function getMaze(){
        gameName = $('#inputMazeName').val();
        var nameToPass = {mazeName : gameName};
        $.getJSON("MultiplayerMazeServlet", nameToPass , function(data){
            if (data.multiMaze != current)
                mazeFromServer = data.multiMaze;
            gameInPlay = true;
            console.log(mazeFromServer);
            stopJSONCheck();
        })
    }
    function stopJSONCheck() {
        clearInterval(checkInterval);
        var ob = JSON.parse(mazeFromServer);
        console.log(ob);
    }
</script>

</body>
</html>
