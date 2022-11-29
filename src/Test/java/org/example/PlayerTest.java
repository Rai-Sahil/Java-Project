package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

  Window window;

  Player player;

  Asteroid asteroid;

  float posX;
  float posY;
  int size;
  float rotation;
  float MAXSPEED;
  int isRotating;
  boolean shotFired;

  boolean collision = true;

  @BeforeEach
  void setup(){
    window = new Window();
    player = new Player(window);
    asteroid = new Asteroid(window);
  }

  @Test
  void checkPosXLaser1(){
    if (posX > window.width){
      assertEquals(0, posX);
    }
  }

  @Test
  void checkNotPosXLaser(){
    if (posX > window.height){
      assertNotEquals(4, posX, 0);
    }
  }

  @Test
  void checkPosXLaser2(){
    if (posX < 0){
      assertEquals(window.width, posX);
    }
  }

  @Test
  void checkNotPosXLaser2(){
    if (posX < 0){
      assertNotEquals(-5, window.width, posX);
    }
  }

  @Test
  void checkPosYLaser1(){
    if (posY > window.height){
      assertEquals(0, posY);
    }
  }

  @Test
  void checkPosYLaser2(){
    if (posY < 0){
      assertEquals(window.height, posY);
    }
  }

//  @Test
//  void checkCollision(){
//    float value = window.dist(posX, posY, asteroid.posX, asteroid.posY);
//    if (value < (asteroid.size+size) * 4/5){
//      assertTrue(collision);
//    }
//  }




}