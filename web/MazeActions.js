//gets a string and makes a grid out of it.
function DrawMaze(stringMaze) {
 var canvas = document.getElementById('myCanvas');
 var context = canvas.getContext('2d');
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

DrawMaze("1010101110100010101010111010001000101011101010101010101110101001110011110011110011110011110011110011");