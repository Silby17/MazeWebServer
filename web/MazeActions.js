var canvas = document.getElementById('myCanvas');
var context = canvas.getContext('2d');
var mazeWidth = 830;
var mazeHeight = 500;
var imageObj = document.getElementById("myImg");
imageObj.style.position= 'relative';
imageObj.style.left = '470px';
imageObj.style.top = '100px';



//gets a string and makes a grid out of it.
function DrawMaze(stringMaze, startX, startY, endX, endY) {
 window.addEventListener("keydown", move);
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
 //place start image
 var x = (470 + (startY * 40));
 var y = (100 + (startX * 40));
 imageObj.style.left = parseInt(x)  + 'px';
 imageObj.style.top = parseInt(y) + 'px';
 imageObj.style.visibility = 'visible';
 //color end point
 context.fillStyle = "#3045BF";
 var endx = (430 + (40 * endY));
 var endy = (100 + (40 * endX));
 context.fillRect(endx, endy, 40, 40);
}

function canMoveTo(destX, destY) {
 var canMove ; // 1 means: player can move
 // check whether the player would move inside the bounds of the canvas
 if (destX >= 430 && destX <= mazeWidth - 40 && destY >= 100 && destY <= mazeHeight - 40) {
  canMove = 1;
 }
 else {
  canMove = 0;
 }
 return canMove;
}

//show win alert
function win() {
 alert("Congratulations!");
 window.removeEventListener("keydown", move);
}


function move(e) {
 var movingAllowed;
 var color, blue;
 e = e || window.event;
 switch (e.keyCode) {
     // arrow up key
  case 38:
   movingAllowed = canMoveTo(parseInt(imageObj.style.left), parseInt(imageObj.style.top) - 40);
   color = context.getImageData((parseInt(imageObj.style.left) - 40), (parseInt(imageObj.style.top) - 40), 40, 40);
   blue = parseInt(color.data[2]);
   //if blue pixels are 255 mines it is white
   if(movingAllowed == 1 && blue == 255) {
    document.getElementById("myImg").style.visibility = "hidden";
    imageObj.style.top = parseInt(imageObj.style.top) - 40 + 'px';
    imageObj.style.visibility = 'visible';
   }
   //check win
   if(movingAllowed == 1 && blue == 191) {
    win();
   }
   break;
     // arrow left key
  case 37:
   movingAllowed = canMoveTo(parseInt(imageObj.style.left) - 40, parseInt(imageObj.style.top));
   color = context.getImageData(parseInt(imageObj.style.left) - 80, parseInt(imageObj.style.top), 40, 40);
   blue = parseInt(color.data[2]);
   if(movingAllowed == 1 && blue == 255) {
    document.getElementById("myImg").style.visibility = "hidden";
    imageObj.style.left = parseInt(imageObj.style.left) - 40 + 'px';
    imageObj.style.visibility = 'visible';
   }
   //check win
   if(movingAllowed == 1 && blue == 191) {
    win();
   }
   break;
     // arrow down key
  case 40:
   movingAllowed = canMoveTo(parseInt(imageObj.style.left), parseInt(imageObj.style.top + 40));
   color = context.getImageData((parseInt(imageObj.style.left)- 40), (parseInt(imageObj.style.top) +40)  , 40, 40);
   blue = parseInt(color.data[2]);
   if(movingAllowed == 1 && blue == 255) {
    document.getElementById("myImg").style.visibility = "hidden";
    imageObj.style.top = parseInt(imageObj.style.top) + 40 + 'px';
    imageObj.style.visibility = 'visible';
   }
   //check win
   if(movingAllowed == 1 && blue == 191) {
    win();
   }
   break;
     // arrow right key
  case 39:
   movingAllowed = canMoveTo(parseInt(imageObj.style.left) + 40, parseInt(imageObj.style.top));
   color = context.getImageData(parseInt(imageObj.style.left), parseInt(imageObj.style.top), 40, 40);
   blue = parseInt(color.data[2]);
   if(movingAllowed == 1 && blue == 255) {
    document.getElementById("myImg").style.visibility = "hidden";
    imageObj.style.left = parseInt(imageObj.style.left) + 40 + 'px';
    imageObj.style.visibility = 'visible';
   }
   //check win
   if(movingAllowed == 1 && blue == 191) {
    win();
   }
   break;
 }
}
document.getElementById("myImg").style.visibility = "hidden";
window.addEventListener("keydown", move);