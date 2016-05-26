var currX = 470;
var currY = 100;
var canvas = document.getElementById('myCanvas');
var context = canvas.getContext('2d');
var mazeWidth = 870;
var mazeHeight = 460;
var imageObj = document.getElementById("myImg");
imageObj.style.position= 'relative';
imageObj.style.left = '470px';
imageObj.style.top = '100px';

//imageObj.id = "myImg";

//gets a string and makes a grid out of it.
function DrawMaze(stringMaze) {
 context.rect(430,100,400,400);
 context.stroke();
 var x = 430, y = 100, index =0;
//row
 for (var i = 0; i < 10; i++) {
  //go over the col, if 0 draw white cube if 1 draw black cube
  for (var j = 0; j < 10; j++) {
    if(stringMaze[index] == '1') {
    context.fillStyle = "#B6E9FA";
    context.fillRect(x, y, 40, 40);
   }
   else {
     context.fillStyle = "white";
     context.fillRect(x, y, 40, 40);
    }
   x = x + 40;
   index++;
  }
  y = y + 40;
  x = 430;
 }
}

//place the icon of the player on the maze
function PlacePlayerIcon(currX ,currY) {
 document.getElementById("myImg").style.visibility = "hidden";
 imageObj.style.left = currX + 'px';
 imageObj.style.top =  currY + 'px';
 imageObj.style.visibility = 'visible';
}

function canMoveTo(destX, destY) {
 var canMove ; // 1 means: player can move
 // check whether the player would move inside the bounds of the canvas
 if (destX >= 470 && destX <= mazeWidth - 40 && destY >= 100 && destY <= mazeHeight - 40) {
  canMove = 1;
 }
 else {
  canMove = 0;
 }
 return canMove;
}

//show the move if ok
function Win(newX, newY) {
  context.font = "40px Arial";
  context.fillStyle = "blue";
  context.textAlign = "center";
  context.textBaseline = "middle";
  context.fillText("Congratulations!", canvas.width / 2, canvas.height / 2);
  window.removeEventListener("keydown", move, true);
}



function move(e) {
 var movingAllowed;
 e = e || window.event;
  switch (e.keyCode) {
      // arrow up key
   case 38:
    movingAllowed = canMoveTo(parseInt(imageObj.style.left), parseInt(imageObj.style.top) - 40);
       if(movingAllowed == 1) {
        document.getElementById("myImg").style.visibility = "hidden";
        imageObj.style.top = parseInt(imageObj.style.top) - 40 + 'px';
        imageObj.style.visibility = 'visible';
       }
    break;
      // arrow left key
   case 37:
    movingAllowed = canMoveTo(parseInt(imageObj.style.left) - 40, parseInt(imageObj.style.top));
    if(movingAllowed == 1) {
     document.getElementById("myImg").style.visibility = "hidden";
     imageObj.style.left = parseInt(imageObj.style.left) - 40 + 'px';
     imageObj.style.visibility = 'visible';
     break;
    }
      // arrow down key
   case 40:
    movingAllowed = canMoveTo(parseInt(imageObj.style.left), parseInt(imageObj.style.top + 40));
    if(movingAllowed == 1) {
     document.getElementById("myImg").style.visibility = "hidden";
     imageObj.style.top = parseInt(imageObj.style.top) + 40 + 'px';
     imageObj.style.visibility = 'visible';
     break;
    }
      // arrow right key
   case 39:
    movingAllowed = canMoveTo(parseInt(imageObj.style.left) + 40, parseInt(imageObj.style.top));
    if(movingAllowed == 1) {
     document.getElementById("myImg").style.visibility = "hidden";
     imageObj.style.left = parseInt(imageObj.style.left) + 40 + 'px';
     imageObj.style.visibility = 'visible';
     break;
    }
  }
}

function move1(e){
 document.getElementById("myImg").style.visibility = "hidden";
 imageObj.style.left = parseInt(imageObj.style.left) + 40 + 'px';
imageObj.style.visibility = 'visible';

}

//PlacePlayerIcon(currX,currY);
window.addEventListener("keydown", move);

