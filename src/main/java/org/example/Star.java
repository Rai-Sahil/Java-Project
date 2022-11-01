package org.example;

import processing.core.PApplet;
import processing.core.PVector;

public class Star extends PApplet {

    public static final int max_weight = 7;
    PVector pos;
    float size;
    float colour;
    int margin = 50;
    float speed;
    int TOP_SPEED = 3;

    Star(Window window){
        this.pos = new PVector(random(window.width), random(window.height));
        this.size = random(max_weight);
        this.speed = map(this.size, 0, max_weight, 1,TOP_SPEED);
        this.colour = (255 / max_weight) * this.size;
    }

    public void display(Window window){
       window.stroke(this.colour, this.colour, this.colour, this.colour);
       window.strokeWeight(this.size);
        window.point(this.pos.x, this.pos.y);
    }

    void move(PVector direction, Window window){
        direction.mult(this.speed);
        this.pos.add(direction);

        if (this.pos.x > window.width + this.margin){
            this.pos.x = -this.margin;
        } else if (this.pos.x < 0 - this.margin){
            this.pos.x = window.width + this.margin;
        }

        if (this.pos.y > window.height + this.margin){
            this.pos.y = -this.margin;
        } else if (this.pos.y < 0 - this.margin){
            this.pos.y = window.height + this.margin;
        }
    }
}
