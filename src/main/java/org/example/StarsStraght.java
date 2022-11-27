package org.example;

public class StarsStraght {

    float x;
    float y;
    float z;

    StarsStraght(Window w){
        x = w.random(0, w.width);
        y = w.random(0, w.height);
        z = w.random(0, w.width);
    }
}
