package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processing.core.PImage;

import static org.junit.jupiter.api.Assertions.*;

class LaserTest {

  Laser laser;
  Window window;
  boolean isFiring = true;
  PImage bot;
  float posX;
  float posY;
  int speed;
  float dir;
  float size;

  /**
   * Sets up before each test begins.
   */
    @BeforeEach
    void setUp() {
      window = new Window();
      laser = new Laser(posX, posY, dir, window);
      speed = 5;
    }

    @Test
    void update() {
    }

    @Test
    void render() {
    }

    @Test
    void checkCollision() {
    }

}