var current = 0;
var mazeFromServer;
var gameInPlay = false;


$(function start() {
    $('.loader').show();
    $.getJSON("MultiplayerMazeServlet", function (data) {
       if(data.multiMaze != current){
           mazeFromServer = data.multiMaze;
           alert("Done");
           $('.loader').hide();
           drawBothMazes();
           getMoveFromServer();
       }
        else{
           start();
       }
    });
});


function drawBothMazes(){
    var object = JSON.parse(mazeFromServer);
    console.log(object);
};


function getMoveFromServer(){
    $.ajax({
        url: 'GetPlayerMoveServlet',
        type: 'GET',
        dataType: 'json',
        cache: false,
        success: function(data){
            if(data.playerMove != 0){
                console.log(data.playerMove);
            }
            setTimeout(function() {getMoveFromServer()}, 3000);
        },
        error: function(data){
            setTimeout(function() {getMoveFromServer()}, 3000);
        }
    });
}