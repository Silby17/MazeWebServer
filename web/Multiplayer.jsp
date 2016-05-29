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
        <input type="text" id="inputMazeName" placeholder="Enter Maze Name">
    </form>
</div>

<script src="./jquery-2.2.4.js"></script>
<script>
    var current = 0;
    var checkInterval;
    var mazeFromServer;

    $(function(){
        $('#getMazeBtn').click(function(){
            if(confirm('Are you sure you want to start a new Game?')){
                checkInterval = setInterval(function() {getMaze()}, 5000);
            }
        });
    });

    function getMaze(){
        var mazeName = $('#inputMazeName').val();
        var nameToPAss = {mazeName : mazeName};
        $.getJSON("MultiplayerMazeServlet", nameToPAss , function(data){
            if (data.multiMaze != current)
                mazeFromServer = data.multiMaze;
            console.log(mazeFromServer);
            stopJSONCheck();
        })
    }
    function stopJSONCheck() {
        clearInterval(checkInterval);
        var ob = JSON.parse(mazeFromServer);
        DrawMaze(ob.Maze, 790, 460);
    }
</script>

</body>
</html>
