package snakegame;

import java.awt.Color;
import java.awt.Point;

public class apple {
    Point appleTile = new Point();
    Color apple_color = Color.red;
    
    public void createApple(board b){
        int pos = (b.getBheight()/b.getPixel()); 
         // Generate a random x coordinate for next apple
        int Coordinate = (int) (Math.random()* pos);
        appleTile.x = (Coordinate * b.getPixel());
        Coordinate = (int) (Math.random()* pos);
        // Generate a random y coordinate for next apple
        appleTile.y = (Coordinate * b.getPixel());
    }

    public int getAppleTilex() {
        return appleTile.x;
    }
    
    public int getAppleTiley() {
        return appleTile.y;
    }

    public Color getApple_color() {
        return apple_color;
    }
    
}