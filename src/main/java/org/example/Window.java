package org.example;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Window extends PApplet{

    int MAX_WEIGHT = 7;
    static final int totalStars = 120;
    ArrayList<Star> stars = new ArrayList<Star>();

    public void setup(){
        for (int i = 0; i < totalStars; i++){
            Star star = new Star(this);
            stars.add(star);
        }
    }

    public void settings(){
        size(1000, 770);
    }

    public void draw(){
        background(0);
        for (Star s : stars){
            s.display(this);

            // ! TO CHANGE THE SPEED OF THE OBJECT INCREASE THE VALUE OF X.
            // ! Could change the direction to move in space as well
            PVector direction = new PVector(-2, 0);
            s.move(direction, this);
        }
    }

    public static void main(String[] args) {

        String[] appletArgs = new String[]{"Spacesaver"};
        Window window = new Window();
        PApplet.runSketch(appletArgs, window);
    }
}