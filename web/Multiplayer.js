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
    //TODO function to draw both mazes
    DrawMaze(object.You.Maze, object.You.Start.Row, object.You.Start.Col, object.You.End.Row,object.You.End.Col,
        object.Other.Start.Row, object.Other.Start.Col, object.Other.End.Row, object.Other.End.Col);
};