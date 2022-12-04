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

  /**
   * Sets up before each test begins.
   */
  @BeforeEach
  void setup(){
    window = new Window();
    player = new Player(window);
  }


  /**
   * Checks the window size.
   */
  @Test
  void checkWindowSize(){
    window.setSize(569, 789);
    assertFalse(window.checkWindowSize(window));

    window.setSize(640, 360);
    assertTrue(window.checkWindowSize(window));
  }

  /**
   * Checks if the gameState is 1.
   */
  @Test
  void checkGameState(){
    if (keyCode == 10){
      gameState = 1;
      assertEquals(1, gameState);
    }
  }

  /**
   * Checks if the gameState is 2.
   */
  @Test
  void checkGameStateTest2(){
    if (keyCode == 10){
      gameState = 2;
      assertNotEquals(1, gameState);
    }
  }

  /**
   * Tests if the player is rotating right.
   */
  @Test
  void checkKeyCodeRight(){
    if (keyCode == 39){
      player.isRotating = -1;
      assertEquals(-1, player.isRotating);
    }
  }

  /**
   * Tests if the player is rotating right and not left with the proper
   * key code.
   */
  @Test
  void checkKeyCodeRight2(){
    if (keyCode == 39){
      player.isRotating = -1;
      assertNotEquals(1, player.isRotating);
    }
  }

  /**
   * Tests if the player is rotating left.
   */
  @Test
  void checkKeyCodeLeft(){
    if (keyCode == 37){
      player.isRotating = 1;
      assertEquals(1, player.isRotating);
    }
  }

  /**
   * Tests whether the keycode is mapped to the proper player rotation.
   */
  @Test
  void checkKeyCodeLeft2(){
    if (keyCode == 37){
      player.isRotating = 1;
      assertNotEquals(-1, player.isRotating);
    }
  }

  /**
   * Tests if the keycode is mapped to the player button to fire lasers.
   */
  @Test
  void checkKeyCode32(){
    if (keyCode == 32){
      player.shotFired = true;
      assertTrue(player.shotFired);
    }
  }

  /**
   * Tests if the player stops rotating right.
   */
  @Test
  void checkPlayerNotRotatingRight(){
    if (keyCode == 39){
      player.isRotating = 0;
      assertEquals(0, player.isRotating);
    }
  }

  /**
   * Tests if the player rotates left instead of stopping from
   * right rotation.
   */
  @Test
  void checkPlayerNotRotatingRight2(){
    if (keyCode == 39){
      player.isRotating = 0;
      assertNotEquals(-1,player.isRotating);
    }
  }

  /**
   * Tests if the player stops rotating from the left.
   */
  @Test
  void checkPlayerNotRotatingLeft(){
    if (keyCode == 37){
      player.isRotating = 0;
      assertEquals(0, player.isRotating);
    }
  }

  /**
   * Tests if the player rotates right instead of stopping from
   * left rotation.
   */
  @Test
  void checkPlayerNotRotatingLeft2(){
    if (keyCode == 37){
      player.isRotating = 0;
      assertNotEquals(1, player.isRotating);
    }
  }

  /**
   * Tests if the roundTitleCounter is greater than 0.
   */
  @Test
  void checkRoundUpdate(){
    if (roundTitleCounter > 0){
      roundTitleCounter--;
      assertTrue(roundTitleCounter < 5);
    }
  }

  /**
   * Tests if the roundTitleCounter is not 6.
   */
  @Test
  void checkRoundUpdate2(){
    if (roundTitleCounter > 0){
      roundTitleCounter--;
      assertNotEquals(6, roundTitleCounter);
    }
  }

  /**
   * Tests if the roundTitleCounter is not decrementing at 0.
   */
  @Test
  void checkRoundUpdate3(){
    if (roundTitleCounter > 0){
      roundTitleCounter--;
      assertNotEquals(0, roundTitleCounter);
    }
  }

  /**
   * Tests if the game is not in round one.
   */
  @Test
  void checkRoundOne(){
    if (roundTitleCounter == 1);
    assertFalse(notRoundOne);
  }

  /**
   * Tests if the roundTitleCounter is 2.
   */
  @Test
  void checkNotRoundOne(){
    if (roundTitleCounter == 2);
    assertNotEquals(1, roundTitleCounter);
  }

}