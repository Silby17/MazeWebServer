<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="css/mainMenu.css">
</head>
<body>
<div class="btn-group" style="float: left" >
    <form action="SinglePlayerServlet" method="post">
        <button id="getMazebtn" type="button" name="action" value="StartNewGame">Start New Game</button>
        <button type="submit" name="action" value="Suggestion">Get Suggestion</button>
        <button type="submit" name="action" value="Return">Return to Main Menu</button>
    </form>
</div>
<canvas id="myCanvas" width="1000" height="550"></canvas>

<% String icon = "images/Icons/";
    String iconName = (String) session.getAttribute("icon");
    icon += iconName;
    {%><img id="myImg" src="<%=icon%>" width="40" height="40"
            style="float:left" align="center"/> <%
    }
%>
<script src = "MazeActions.js"></script>

<script src="./jquery-2.2.4.js"></script>
<script>
    var current = 0;
    var checkInterval;
    var mazeFromServer;

    $(function(){
        $('#getMazebtn').click(function(){
            checkInterval = setInterval(function() {getMaze()}, 3000);
        });
    });

    function getMaze(){
        $.getJSON("SingleMazeServlet", function(data){
            if (data.singleMaze != current)
                mazeFromServer = data.singleMaze;
            console.log(mazeFromServer);
            stopJSONCheck();
        })
    }

    function stopJSONCheck() {
        clearInterval(checkInterval);
        var ob = JSON.parse(mazeFromServer);
    }
</script>

</body>
</html>
