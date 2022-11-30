package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processing.core.PImage;
import processing.data.IntList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WindowTest {

  Window window;

  Player player;

  PImage bot;
  PImage gameOver;
  ArrayList<TextBox> textboxes;
  ArrayList<Asteroid> asteroids;
  ArrayList<Star> stars;
  ArrayList<Pixel> pixels;
  ArrayList<Laser> lasers;
  StarsStraght[] menuStars = new StarsStraght[800];
  IntList astRemove;
  IntList laserRemove;
  IntList pixelRemove;
  int gameState;
  int score;
  int result = 0;
  int round; //Levels
  int roundTitleCounter;
  boolean notRoundOne;
  boolean send = false;
  float speed;
  String msg = "";
  String name = "";

  @BeforeEach
  void setup(){
    window = new Window();
    player = new Player(window);
  }


  @Test
  void checkWindowSize(){
    window.setSize(569, 789);
    assertFalse(window.checkWindowSize(window));

    window.setSize(640, 360);
    assertTrue(window.checkWindowSize(window));
  }

}