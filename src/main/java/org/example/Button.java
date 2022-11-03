package org.example;

import processing.core.PConstants;

public class Button {

    float startX;
    float startY;
    float startLength;
    float startWidth;
    String t;

    Button(Window window){
        startX = window.width / 2;
        startY = window.height /2;
        startLength = 140;
        startWidth = 50;
        t = "hello";
    }

//    public void Update(){
//        if(isRotating == -1){ //Left
//            rotation = rotation + MAXSPEED;
//        } else if (isRotating == 1) {
//            rotation = rotation - MAXSPEED;
//        }
//    }

    public void Render(Window window){
        window.noFill();
        window.stroke(255);
        window.strokeWeight(2);
        window.rect(startX, startY, startLength, startWidth);

        window.fill(255);
        //window.textAlign(PConstants.CENTER, PConstants.CENTER);
        window.text(t, startX+(window.width/2), startY+(window.height/2));
    }

    boolean overStart(Window window)  {
        if (window.mouseX >= startX && window.mouseX <= startX+window.width &&
                window.mouseY >= startY && window.mouseY <= startY+window.height) {
            return true;
        } else {
            return false;
        }
    }
}
