package org.example;

public class Player implements ICollidable, IBullets{

    private static Player player = null;
    float posX;
    float posY;
    int size;
    float rotation;
    float MAXSPEED;
    int isRotating;
    boolean shotFired;

  /**
   * Constructor for the Player class.
   * @param window window for the user
   */
  private Player(Window window){
        posX = window.width / 2;
        posY = window.height / 2;
        size = 15;
        rotation = 0;
        MAXSPEED = window.PI/50;
        isRotating = 0;
        shotFired = false;
    }

    public static Player getInstance(Window window){
        if(player == null){
            player = new Player(window);
        }
        return player;
    }

  /** Regular lasers fired at rounds < 5.
   *
   * @param window window for the user
   * @return laser beam when fired from player.
   */
  @Override
  public Laser Fire(Window window){
        Laser beam = new Laser(posX, posY, rotation, window);
        return beam;
    }

  /** Double lasers fired at rounds > 5.
   *
   * @param window window for the user
   * @return laser beam when fired from the player
   */
  @Override
  public Laser Fire2(Window window){
        Laser beam = new Laser(posX+30, posY+30, rotation, window);
        return beam;
    }
    /**
   * Updates the rotation of the player left and right.
   */

  public void Update(){
        if(isRotating == -1){// LEFT
            rotation = rotation + MAXSPEED;
        } else if(isRotating == 1){// RIGHT
            rotation = rotation - MAXSPEED;
        }
    }

  /**
   * Renders the player into the game. Player takes 6 values, 3 (x, y) coordinates, to render the triangle. The
   * size is elongated a bit to make a more ship like look.
   * @param window window for the user
   */
  public void Render(Window window){
        window.push();
        window.translate(posX, posY);
        window.rotate(rotation);
        window.noFill();
        window.stroke(255);
        window.strokeWeight(2);
        window.triangle( 0, -size*2, -size, size, size, size);
        window.pop();
    }

  /** Checks collision between an asteroid object and the window,
   *  Hit box is made larger to make it easier for laser impact.
   */
  @Override
    public boolean CheckCollision(Asteroid a, Window window){
        float d = window.dist(posX, posY, a.posX, a.posY);

        if(d < (a.size+size)*4/5){
            return true;
        }
        else {
            return false;
        }
    }
}