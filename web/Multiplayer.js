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