package org.example;

import processing.core.PApplet;
import processing.core.PConstants;

public class Asteroid {
    float posX;
    float posY;
    float size;
    float randomDir;
    float speed;

    Asteroid(Window window){
        randPos(window);
        size = 50;
        randomDir = window.random(0, PConstants.TWO_PI);
        speed = 2;
    }

    public void Update(Window window){
        posX += window.cos(randomDir)*speed;
        posY += window.sin(randomDir)*speed;
        Edge(window);
    }

    public void Render(Window window){
        window.push();
        window.translate(posX, posY);
        window.noFill();
        window.stroke(255);
        window.strokeWeight(2);
        window.circle(0, 0 , size);
        window.pop();
    }

    private void Edge(Window window){
        if(posX > window.width) posX = 0;
        if(posX < 0) posX = window.width;
        if(posY > window.height) posY = 0;
        if(posY < 0) posY = window.height;
    }

    private void randPos(Window window){
        boolean top = false;
        boolean left = false;
        if(window.floor(window.random(0, 2)) == 0) top = true;
        if(window.floor(window.random(0, 2)) == 0) left = true;

        if(top && left){
            posX = window.random(0, (window.width/2 - 100));
            posY = window.random(0, (window.height/2 - 100));
        }
        else if(top && !left){
            posX = window.random((window.width/2 + 100), window.width);
            posY = window.random(0, (window.height/2 - 100));
        }
        else if(!top && left){
            posX = window.random(0, (window.width/2 - 100));
            posY = window.random((window.height/2 + 100), window.height);
        } else{
            posX = window.random((window.width/2 + 100), window.width);
            posY = window.random((window.height/2 + 100), window.height);
        }
    }
}
