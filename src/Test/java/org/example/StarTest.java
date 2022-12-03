package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processing.core.PVector;

import static org.junit.jupiter.api.Assertions.*;

class StarTest {

  Star star;
  Window window;
  public static final int max_weight = 7;
  PVector pos;
  public boolean isMoving = true;
  public boolean isNotMoving = true;
  float size;
  float colour;
  int margin = 50;
  float speed;
  int TOP_SPEED = 1;

    @BeforeEach
    void setUp() {
      window = new Window();
      star = new Star(window);
      pos = new PVector(window.width / 2f, window.height / 2f);
    }

    @Test
    void display() {
    }

    @Test
    void move() {
    }

    @Test
    void checkStarsPosXMoving(){
      if (pos.x > window.width + margin){
        assertTrue(isMoving);
      }
    }

  @Test
  void checkStarsPosXNotMoving(){
    if (pos.x < window.width + margin){
      assertTrue(isNotMoving);
    }
  }

    @Test
    void checkStarsPosYMoving(){
      if (pos.y > window.height + margin){
        assertTrue(isMoving);
      }
    }

    @Test
    void checkStarsPosYNotMoving(){
      if (pos.y < window.height + margin){
        assertTrue(isNotMoving);
      }
    }

    @Test
    void checkStarSpeed(){
      if (speed == window.map(size, 0, max_weight, 1, TOP_SPEED)){
        assertTrue(isMoving);
      }
    }

    @Test
    void checkStarNoSpeed(){
      if (speed != window.map(size, 0, max_weight, 1, TOP_SPEED)){
        assertTrue(isNotMoving);
      }
    }


}