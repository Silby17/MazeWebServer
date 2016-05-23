window.onload = function() {
 var mazeImg = new Image();
 mazeImg.setAttribute("src", "images/maze.png");
//mazeImg.src = "images/maze.png";
 var c = document.getElementById("mazecanvas");
 var ctx = c.getContext("2d");
 //var img = document.getElementById("maze");
 ctx.drawImage(mazeImg, 10, 10);
}


