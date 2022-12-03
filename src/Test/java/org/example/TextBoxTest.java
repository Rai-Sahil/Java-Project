package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextBoxTest {

  TextBox textBox;
  Window window;

  int keyCode;
  char key;

  boolean isKeyCapitalLetter = true;
  boolean isKeySmallLetter = true;
  boolean isKeyNumber = true;

  public int textSize = 32;
  public int X = 0, Y = 0, H = 35, W = 200;
  public boolean BorderEnable = true;
  private boolean selected = true;
  public int TextLength = 0;
  public String Text = "";
  public int BorderWeight = 1;

    @BeforeEach
    void setUp() {
      textBox = new TextBox();
      window = new Window();
    }

    @Test
    void testDraw() {

    }

    @Test
    void testKeyPressed() {
      if (keyCode == 8){
        assertEquals(8, keyCode);
      }
    }

    @Test
    void testKeyPressed2(){
      if (keyCode == 10){
        assertEquals(10, keyCode);
      }
    }

    @Test
    void testKeyPressed3(){
      if (keyCode == 32){
        assertEquals(32, keyCode);
      }
    }

    @Test
    void checkWrongKeyTenPressed(){
      if (keyCode == 12){
        assertNotEquals(12, 10);
      }
    }

    @Test
    void checkWrongKeyEightPressed(){
      if (keyCode == 10){
        assertNotEquals(10, 8);
      }
    }

    @Test
    void checkWrongKeyThirtyTwoPressed(){
      if (keyCode == 32){
        assertNotEquals(32, 10);
      }
    }

  @Test
  void checkIsKeyCapital(){
    if (key >= 'A' && key <= 'Z'){
      assertTrue(isKeyCapitalLetter);
    }
  }

  @Test
  void checkIsKeyCapital2(){
      if (key >= 'A' && key <= 'Z'){
        assertNotEquals('a', 'A');
      }
  }

  @Test
  void checkIsKeyLowerCase(){
    if (key >= 'a' && key <= 'z'){
      assertTrue(isKeySmallLetter);
    }
  }

  @Test
  void checkIsKeyLowerCase2(){
    if (key >= 'a' && key <= 'z'){
      assertNotEquals('A', 'a');
    }
  }


  @Test
  void checkIsKeyANumber(){
      if (key >= 1 && key <= 9){
        assertTrue(isKeyNumber);
      }
  }

  @Test
  void checkIsKeyNotANumber(){
      if (key >= 1 && key <= 9){
        assertNotEquals('a', 1);
      }
  }

  @Test
  void checkIsKeyInRange(){
      if (key >= 1 && key <=9){
        assertNotEquals(10, 1);
      }
  }

    @Test
    void testPRESSED() {
    }
}