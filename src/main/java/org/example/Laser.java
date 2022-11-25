package org.example;

public class Laser {
    float posX;
    float posY;
    float speed;
    float dir;
    float size;

    Laser(float px, float py, float pDir, Window window){
        posX = px;
        posY = py;
        speed = 5;
        dir = pDir - window.HALF_PI;
        posX += 25*window.cos(dir);
        posY += 25*window.sin(dir);
        size = 2;
    }

    void Update(Window window){
        posX += speed*window.cos(dir);
        posY += speed*window.sin(dir);
    }

    void Render(Window window){
        window.push();
        window.noFill();
        window.stroke(255);
        window.strokeWeight(1);
        window.rect(posX, posY, size, size + 10f);
        window.pop();
    }

    public boolean CheckCollision(Asteroid a, Window window){
        float d = window.dist(posX, posY, a.posX, a.posY);

        if(d < (a.size+size)*3/5){
            return true;
        }
        else {
            return false;
        }
    }
}
