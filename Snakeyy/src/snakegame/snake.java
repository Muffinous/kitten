package snakegame;

import java.awt.Color;
import java.awt.Point;

public class snake {
        private final int TILE_WIDTH;
        private final int TILE_HEIGHT ;
        Point snakeTiles[];
        int numSnakeTiles;
        int iniSnakeTiles;
        String direction; 

// Setup colors for drawing snake
    private final Color SNAKE_HEAD_COLOR = new Color(Integer.parseInt("215E21", 16));
    private final Color SNAKE_TAIL_COLOR = Color.green;
//constructor
        public snake (){
            this.TILE_HEIGHT = 25;
            this.TILE_WIDTH = 25;
            this.numSnakeTiles=3;
            this.snakeTiles = new Point[(700 * 700) / (TILE_WIDTH * TILE_HEIGHT)];
        
            for (int ind = 0; ind <= numSnakeTiles; ind++) {
            snakeTiles[ind]= new Point();
            this.snakeTiles[ind].x = ((700 / 2) - 100) - (ind * TILE_WIDTH);
            this.snakeTiles[ind].y = (700 / 2);
        }
            }
        //when the snake eat an apple
        public void AppleEaten(board b){
            this.numSnakeTiles+=numSnakeTiles;
            snakeTiles[numSnakeTiles] = new Point();
          //  b.setScore((getNumSnakeTiles()-3) * b.getScoring()); //Mult * Scoring = 120
        }

        public void moveSnake(){
        // First since a snake slides across the tiles,
        // move each tile so that every tile is now equal
        // to the previous tile (to move all tiles).
        for (int ind = numSnakeTiles; ind > 0; ind--) {
            snakeTiles[ind].x = snakeTiles[(ind - 1)].x;
            snakeTiles[ind].y = snakeTiles[(ind - 1)].y;
        }

        if (null != direction) // Based on the current direction, we need to
        // move the head tile towards the next tile in that direction...
        switch (direction) {
            case "left":
                snakeTiles[0].x -= TILE_WIDTH;
                break;
            case "right":
                snakeTiles[0].x += TILE_WIDTH;
                break;
            case "up":
                snakeTiles[0].y -= TILE_HEIGHT;
                break;
            case "down":
                snakeTiles[0].y += TILE_HEIGHT;
                break;
        }
    }

    public Color getSNAKE_HEAD_COLOR() {
        return SNAKE_HEAD_COLOR;
    }

    public Color getSNAKE_TAIL_COLOR() {
        return SNAKE_TAIL_COLOR;
    }

    public void setIniSnakeTiles(int iniSnakeTiles) {
        this.iniSnakeTiles = iniSnakeTiles;
    }

    public int getIniSnakeTiles() {
        return iniSnakeTiles;
    }
    
    public int getNumSnakeTiles() {
        return numSnakeTiles;
    }    

    public int getTILE_WIDTH() {
        return TILE_WIDTH;
    }

    public int getTILE_HEIGHT() {
        return TILE_HEIGHT;
    }
    
}
