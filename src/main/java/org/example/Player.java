package org.example;

public class Player {

    float MAXSPEED;
    float asteroidsX;
    float asteroidsY;
    float asteroidsSize;
    float rotation;
    int isRotating;

    Player(Window window){
        window.frameRate(60);
        asteroidsX = window.width / 2;
        asteroidsY = window.height /2;
        asteroidsSize = 15;
        rotation = 0;
        MAXSPEED = (float) (Math.PI / 50);
        isRotating = 0;
    }

    public void Update(){
        if(isRotating == -1){ //Left
            rotation = rotation + MAXSPEED;
        } else if (isRotating == 1) {
            rotation = rotation - MAXSPEED;
        }
    }

    public void Render(Window window){
        window.translate(asteroidsX, asteroidsY);
        window.rotate(rotation);
        window.noFill();
        window.stroke(255);
        window.strokeWeight(2);
        window.triangle((float) 0, (float) (-asteroidsSize*1.5), -asteroidsSize, asteroidsSize, asteroidsSize, asteroidsSize);
    }
}
