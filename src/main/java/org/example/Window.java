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
    Menu startMenu;
    Button button;
    PVector direction;
    int menu = 0;


    public void setup(){
        for (int i = 0; i < totalStars; i++){
            Star star = new Star(this);
            stars.add(star);
        }

        asteroids = new ArrayList<Asteroid>();
        for (int i = 0; i < floor(random(20, 30)); i++){
            asteroids.add(new Asteroid(this));
            break;
        }

        player = new Player(this);

        button = new Button(this);
    }

    public void setMenu(int menu) {
        this.menu = menu;
    }

    public void settings(){
        size(1000, 800);
    }

    public void draw(){

        background(0);
        for (Star s : stars) {
            s.display(this);
            // ! TO CHANGE THE SPEED OF THE OBJECT INCREASE THE VALUE OF X.
            // ! Could change the direction to move in space as well
            direction = new PVector(-2, 0);
            s.move(direction, this);
        }

        update();
        Render();

        switch (menu){
            case 0:
                button.draw(this);
                break;
            case 1:

        }
    }

    void update(){

        switch(menu){
            case 0:{
                button.update(this);
                break;
                }
            case 1:{
                for (int i = 0; i < asteroids.size(); i++){
                    asteroids.get(i).Update(this);
                }
                player.Update();
                break;
            }
        }
    }

    void Render(){

        switch(menu){
            case 0:{
                break;
            }
            case 1:{
                for (int i = 0; i <asteroids.size(); i++){
                    asteroids.get(i).Render(this);
                }
                player.Render(this);
                break;
            }
        }
    }

    //If mouse is pressed over specific button
    public void mousePressed() {
        if (button.rectOver == true) {
            menu = 1;
        } else {
            menu = 0;
        }
    }

    //If the specific key code is pressed, then rotate.
    public void keyPressed(){
        if (keyCode == 39){//Right
            player.isRotating = -1;
        } else if (keyCode == 37) {//Left
            player.isRotating = 1;
        }
    }

    //If the specific key code is released after being pressed, then stop rotating.
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
