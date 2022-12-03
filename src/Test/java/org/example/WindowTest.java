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
  int keyCode;
  int score;
  int result = 0;
  int round; //Levels
  int roundTitleCounter = 5;
  boolean notRoundOne = false;
  boolean isEmpty = false;
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

  @Test
  void checkGameState(){
    if (keyCode == 10){
      gameState = 1;
      assertEquals(1, gameState);
    }
  }

  @Test
  void checkGameStateTest2(){
    if (keyCode == 10){
      gameState = 2;
      assertNotEquals(1, gameState);
    }
  }

  @Test
  void checkKeyCodeRight(){
    if (keyCode == 39){
      player.isRotating = -1;
      assertEquals(-1, player.isRotating);
    }
  }

  @Test
  void checkKeyCodeRight2(){
    if (keyCode == 39){
      player.isRotating = -1;
      assertNotEquals(1, player.isRotating);
    }
  }

  @Test
  void checkKeyCodeLeft(){
    if (keyCode == 37){
      player.isRotating = 1;
      assertEquals(1, player.isRotating);
    }
  }

  @Test
  void checkKeyCodeLeft2(){
    if (keyCode == 37){
      player.isRotating = 1;
      assertNotEquals(-1, player.isRotating);
    }
  }

  @Test
  void checkKeyCode32(){
    if (keyCode == 32){
      player.shotFired = true;
      assertTrue(player.shotFired);
    }
  }

  @Test
  void checkPlayerNotRotatingRight(){
    if (keyCode == 39){
      player.isRotating = 0;
      assertEquals(0, player.isRotating);
    }
  }

  @Test
  void checkPlayerNotRotatingRight2(){
    if (keyCode == 39){
      player.isRotating = 0;
      assertNotEquals(-1,player.isRotating);
    }
  }

  @Test
  void checkPlayerNotRotatingLeft(){
    if (keyCode == 37){
      player.isRotating = 0;
      assertEquals(0, player.isRotating);
    }
  }

  @Test
  void checkPlayerNotRotatingLeft2(){
    if (keyCode == 37){
      player.isRotating = 0;
      assertNotEquals(1, player.isRotating);
    }
  }

  @Test
  void checkRoundUpdate(){
    if (roundTitleCounter > 0){
      roundTitleCounter--;
      assertTrue(roundTitleCounter < 5);
    }
  }

  @Test
  void checkRoundUpdate2(){
    if (roundTitleCounter > 0){
      roundTitleCounter--;
      assertNotEquals(6, roundTitleCounter);
    }
  }

  @Test
  void checkRoundOne(){
    if (roundTitleCounter == 1);
    assertFalse(notRoundOne);
  }

  @Test
  void checkNotRoundOne(){
    if (roundTitleCounter == 2);
    assertNotEquals(1, roundTitleCounter);
  }

}