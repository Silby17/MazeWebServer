var currX = 430;
var currY = 100;
var canvas = document.getElementById('myCanvas');
var context = canvas.getContext('2d');
var mazeWidth = 400;
var mazeHeight = 400;
var imageObj = document.getElementById("myImg");

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
 imageObj.onload = function() {
  context.drawImage(imageObj, currX, currY);
 };
 imageObj.src = "images/Icons/redFace.png";
}

function canMoveTo(destX, destY) {
// var imgData = context.getImageData(destX, destY, 40, 40);
 //var data = imgData.data;
 var canMove = 1; // 1 means: player can move
 // check whether the rectangle would move inside the bounds of the canvas
 if (destX >= 0 && destX <= mazeWidth - 40 && destY >= 0 && destY <= mazeHeight - 40) {
  //for (var i = 0; i < 4 * 40 * 40; i += 4) { // look at all pixels
   //if (data[i] === 0 && data[i + 1] === 0 && data[i + 2] === 0) { // black
   // canMove = 0; // 0 means: the rectangle can't move
   // break;
   //}
   //else if (data[i] === 0 && data[i + 1] === 255 && data[i + 2] === 0) { // lime: #00FF00
    //canMove = 2; // 2 means: the end point is reached
    //break;
   //}
 // }
 }
 else {
  canMove = 0;
 }
 return canMove;
}

//show the move if ok
function nextMove(newX, newY) {
 var movingAllowed = canMoveTo(newX, newY);
 // 1 means can move
 if (movingAllowed === 1) {
  currX = newX;
  currY = newY;
  PlacePlayerIcon(currX, currY);
 }
 // 2 means the palyer reached the end point
 else if (movingAllowed === 2) {
  context.font = "40px Arial";
  context.fillStyle = "blue";
  context.textAlign = "center";
  context.textBaseline = "middle";
  context.fillText("Congratulations!", canvas.width / 2, canvas.height / 2);
  window.removeEventListener("keydown", move, true);
 }
}



function move(e) {
 var newX;
 var newY;
 e = e || window.event;
 switch (e.keyCode) {
     // arrow up key
  case 38:
   newX = currX;
   newY = currY - 40;
   break;
     // arrow left key
  case 37:
   newX = currX - 40;
   newY = currY;
   break;
     // arrow down key
  case 40:
   newX = currX;
   newY = currY + 40;
   break;
     // arrow right key
  case 39:
   newX = currX + 40;
   newY = currY;
   break;
   nextMove(newX, newY);
 }
}


function move1(e){
 document.getElementById("myImg").style.visibility = "hidden";
 PlacePlayerIcon(currX + 40, currY + 40);
}
DrawMaze("1010101110100010101010111010001000101011101010101010101110101001110011110011110011110011110011110011");
//PlacePlayerIcon(currX,currY);
window.addEventListener("keydown", move1);

