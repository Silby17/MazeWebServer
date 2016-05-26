<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="css/mainMenu.css">
</head>
<body>

<ul div style="float: right" class="ul userInfo">
    <li >
        </div>
        <button>Back</button>
        </div>
    </li>
    <li>
            <% String icon = "images/Icons/";
         String iconName = (String)session.getAttribute("icon");
         icon += iconName;
         {%> <div style="float: right" id="userImage">
        <img src="<%=icon%>"/>
    </div><%}%>
    <li>
        <% String username = (String) session.getAttribute("username");
            {%>
        <label><%=username%></label>
        <%}%>
    </li>
</ul>


<div class="btn-group" style="float: left" >
    <form action="SinglePlayerServlet" method="post">
        <button id="getMazeBtn" type="button" name="action" value="StartNewGame">Start New Game</button>
        <button type="submit" name="action" value="Suggestion">Get Suggestion</button>
        <button type="submit" name="action" value="Return">Return to Main Menu</button>
    </form>
</div>
<canvas id="myCanvas" width="1000" height="550"></canvas>

<!--The following code will get the icon from the current users session-->
<%
    {%><img id="myImg" src="<%=icon%>" width="40" height="40"
            style="float:left" align="center"/> <%
    }
%>

<!--The definitions of the script sources-->
<script src = "MazeActions.js"></script>
<script src="./jquery-2.2.4.js"></script>

<!--The following code will check for button click to get new maze
it will then start checking the server every 3seconds if there is
a new maze, it will then convert it to JSON object and Draw the maze-->
<script>
    var current = 0;
    var checkInterval;
    var mazeFromServer;

    $(function(){
        $('#getMazeBtn').click(function(){
            if(confirm('Are you sure you want to start a new Game?')){
                checkInterval = setInterval(function() {getMaze()}, 3000);
            }
            else{

            }

        });
    });

    function getMaze(){
        $.getJSON("SingleMazeServlet", function(data){
            if (data.singleMaze != current)
                mazeFromServer = data.singleMaze;
            console.log(mazeFromServer.Name);
            console.log(mazeFromServer);

            stopJSONCheck();
        })
    }
    function stopJSONCheck() {
        clearInterval(checkInterval);
            var ob = JSON.parse(mazeFromServer);
        DrawMaze(ob.Maze);
    }
</script>
</body>
</html>
