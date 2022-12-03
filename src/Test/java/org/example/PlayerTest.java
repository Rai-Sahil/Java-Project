package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Asteroid asteroid;
    Window w;
    Player player;

    @BeforeEach
    public void setup(){
        w = new Window();
        player = new Player(w);
        asteroid = new Asteroid(w);

    }

    @Test
    public void testCollision(){

        assertTrue(player.CheckCollision(asteroid, w));
    }
}