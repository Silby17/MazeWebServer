var current = 0;
var mazeFromServer;
var nameOfGame;
var gameInPlay = false;
var otherMove;
var getMazeInterval;

$(function start(){
   $('.loader').show();
    getMazeInterval = setInterval(function () {getMaze()}, 3000);
});



function getMaze(){
    $.getJSON("GetMultiMazeServlet", function(data){
        if(data.multiMaze != 0){
            mazeFromServer = data.multiMaze;
            drawBothMazes();
            getMoveFromServer();
        }
    })
}


function drawBothMazes(){
    var object = JSON.parse(mazeFromServer);
    nameOfGame = object.Name;
    DrawMaze(object.You.Maze, object.You.Start.Row, object.You.Start.Col, object.You.End.Row,object.You.End.Col,
        object.Other.Start.Row, object.Other.Start.Col, object.Other.End.Row, object.Other.End.Col);
    $('.loader').hide();
    clearInterval(getMazeInterval);
};


function getMoveFromServer(){
    $.ajax({
        url: 'GetPlayerMoveServlet',
        type: 'GET',
        dataType: 'json',
        cache: false,
        success: function(data){
            if(data.playerMove != 0){
                otherMove = data.playerMove;
                var moveObject = JSON.parse(otherMove);
                console.log(moveObject.Move);
                opMove(moveObject.Move);
            }
            setTimeout(function() {getMoveFromServer()}, 3000);
        },
        error: function(data){
            setTimeout(function() {getMoveFromServer()}, 3000);
        }
    });
}


$('#returnBtn').click(function(){
   closeGame();
});


function closeGame(){
    var name = {"gameName" : nameOfGame};
    $.ajax({
        url: 'CloseGameServlet',
        type: 'POST',
        data: name
    })
}