package org.example;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Window extends PApplet{

    int MAX_WEIGHT = 7;
    static final int totalStars = 120;
    ArrayList<Star> stars = new ArrayList<Star>();
    Player player;
    ArrayList<Asteroid> asteroids;
    PVector direction;


    public void setup(){
        for (int i = 0; i < totalStars; i++){
            Star star = new Star(this);
            stars.add(star);
        }
        player = new Player(this);
        asteroids = new ArrayList<Asteroid>();
        for (int i = 0; i < floor(random(6, 10)); i++){
            asteroids.add(new Asteroid(this));
        }
    }

    public void settings(){
        size(1000, 800);
    }

    public void draw(){
        background(0);
        for (Star s : stars){
            s.display(this);

            // ! TO CHANGE THE SPEED OF THE OBJECT INCREASE THE VALUE OF X.
            // ! Could change the direction to move in space as well
            direction = new PVector(-2, 0);
            s.move(direction, this);
        }

        //*Asteroids
        update();
        Render();
    }

    void update(){
        player.Update();
        for (int i = 0; i <asteroids.size(); i++){
            asteroids.get(i).Update(this);
        }
    }

    void Render(){
        player.Render(this);
        for (int i = 0; i <asteroids.size(); i++){
            asteroids.get(i).Render(this);
        }
    }

    public void keyPressed(){
        if (keyCode == 39){//Right
            player.isRotating = -1;
        } else if (keyCode == 37) {//Left
            player.isRotating = 1;
        }
    }

    public void keyReleased(){
        if(keyCode == 39){
            player.isRotating = 0;
        } else if(keyCode == 37){
            player.isRotating = 0;
        }
    }

    public static void main(String[] args) {

        String[] appletArgs = new String[]{"Spacesaver"};
        Window window = new Window();
        PApplet.runSketch(appletArgs, window);
    }
}