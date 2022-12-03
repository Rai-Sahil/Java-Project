package org.example;

import org.junit.jupiter.api.Test;
import processing.core.PApplet;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void speedTest(){
        long windowStart = System.currentTimeMillis();

        String[] appletArgs = new String[]{"Spacesaver"};
        Window window = new Window();
        PApplet.runSketch(appletArgs, window);

        long windowEnd = System.currentTimeMillis();

        assertTrue((windowEnd - windowStart) < 2000);
    }

}