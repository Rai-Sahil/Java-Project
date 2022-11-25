package org.example;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;
import processing.data.IntList;

import java.util.ArrayList;

public class Window extends PApplet {

    PShape bot;
    Player player;
    ArrayList<Asteroid> asteroids;
    ArrayList<Pixel> pixels;
    ArrayList<Laser> lasers;
    IntList astRemove;
    IntList laserRemove;
    IntList pixelRemove;
    int gameState; // 0 is start menu, 1 is the game, 2 is game over
    int score;
    int round; //Levels
    int roundTitleCounter;
    boolean notRoundOne;

    public static void main(String[] args) {
        String[] appletArgs = new String[]{"Spacesaver"};
        Window window = new Window();
        PApplet.runSketch(appletArgs, window);
    }

    public void setup() {
        background(0);
        frameRate(60);
        InstantiateVariables();//This gets call whenever we restart the game...
        gameState = 0;
    }

    //Used for setup of our game when we are running it.
    void InstantiateVariables(){
        player = new Player(this);
        asteroids = new ArrayList<Asteroid>();

        for (int i = 0; i < floor(random(6, 10)); i++) {
            asteroids.add(new Asteroid(this));
        }

        lasers = new ArrayList<Laser>();
        pixels = new ArrayList<>();
        astRemove = new IntList();
        laserRemove = new IntList();
        pixelRemove = new IntList();

        score = 0;
        round = 1;
        notRoundOne = false;
        roundTitleCounter = 180;

        bot = loadShape("C:\\Users\\raisa\\IdeaProjects\\Java-Project\\src\\main\\java\\org\\example\\rocket-3432.svg");
    }

    public void settings() {
        size(700, 700);
    }

    public void draw() {
        switch (gameState) {
            case 0 -> {
                push();
                background(0);
                textSize(32);
                fill(255);
                shape(bot, 200, 150);
                text("Press Enter", width * .38f, height * .7f);
                pop();
                break;
            }
            case 1 -> {
                RoundUpdate();
                Update();
                Render();
                break;
            }
            case 2 -> {
                push();
                background(0);
                textSize(32);
                text("Game Over", width*.39f, height*.26f);
                text("You Scored: " + score, width * .35f, height * .5f);
                text("Press Enter to Play Again", width * .24f, height * .8f);
                pop();
                break;
            }
        }
    }

    void RoundUpdate(){
        if(roundTitleCounter > 0)roundTitleCounter--;//If there is any timer subtract the timer
        else {
            roundTitleCounter = 0;
            notRoundOne = true;
        }

        //ABout to finish a round but not in first round...
        if (roundTitleCounter == 1 && notRoundOne){
            for(int i = 0; i < floor(random(5, 8)); i++){
                asteroids.add(new Asteroid(this));
            }
        }

        if(roundTitleCounter == 0 && asteroids.size() == 0){
            roundTitleCounter = 180;
            round++;
        }
    }

    public void Render() {
        background(0);

        if(roundTitleCounter > 0){
            push();
            textSize(32);
            text("Round " + round, width*.4f, height*.4f);
            pop();
        }

        push();
        textSize(32);
        text("Score: " + score, width*.05f, height*.05f);
        pop();
        player.Render(this);
        for (Asteroid asteroid : asteroids) {
            asteroid.Render(this);
        }

        for (Laser laser : lasers) {
            laser.Render(this);
        }

        for (Pixel pixel : pixels) {
            pixel.Render(this);
        }
    }

    public void Update() {
        player.Update();
        for (Asteroid asteroid : asteroids) {
            asteroid.Update(this);
            if (player.CheckCollision(asteroid, this)) gameState = 2;
        }

        for (Laser laser : lasers) {
            laser.Update(this);
        }

        for (int l = 0; l < lasers.size(); l++) {
            for (int a = 0; a < asteroids.size(); a++) {
                if (lasers.get(l).CheckCollision(asteroids.get(a), this)) {
                    laserRemove.append(l);
                    astRemove.append(a);
                    score += 100;
                    for (int n = 0; n < 15; n++) {
                        pixels.add(new Pixel(asteroids.get(a).posX, asteroids.get(a).posY, this));
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < pixels.size(); i++) {
            if (pixels.get(i).Update(this)) {
                pixelRemove.append(i);
            }
        }

        //REMOVE
        for (int i = 0; i < laserRemove.size(); i++) {
            if (laserRemove.get(i) < lasers.size()) lasers.remove(laserRemove.get(i));
        }
        laserRemove.clear();
        for (int i = 0; i < astRemove.size(); i++) {
            if (astRemove.get(i) < asteroids.size()) asteroids.remove(astRemove.get(i));
        }
        astRemove.clear();
        for (int i = 0; i < pixelRemove.size(); i++) {
            if (pixelRemove.get(i) < pixels.size()) pixels.remove(pixelRemove.get(i));
        }
        pixelRemove.clear();
    }

    public void keyPressed() {
        switch (gameState) {
            case 0 -> {
                if (keyCode == 10) gameState = 1;
                break;
            }
            case 1 -> {
                if (keyCode == 39) {//RIGHT
                    player.isRotating = -1;
                } else if (keyCode == 37) {//LEFT
                    player.isRotating = 1;
                }
                if (keyCode == 32) {
                    if (!player.shotFired) {
                        lasers.add(player.Fire(this));
                        player.shotFired = true;
                    }
                }
                break;
            }
            case 2 -> {
                if (keyCode == 10) gameState = 1;
                InstantiateVariables();
                break;
            }
        }
    }

    public void keyReleased() {
        switch (gameState) {
            case 0 -> {

                break;
            }
            case 1 -> {
                if (keyCode == 39) {
                    player.isRotating = 0;
                } else if (keyCode == 37) {
                    player.isRotating = 0;
                }
                if (keyCode == 32) {
                    if (player.shotFired) player.shotFired = false;
                }
                break;
            }
            case 2 -> {

                break;
            }
        }
    }
}
