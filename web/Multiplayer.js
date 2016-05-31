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