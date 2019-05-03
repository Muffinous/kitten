/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalSnakeGame;

import java.awt.Point;

/**
 *
 * @author Rodrigo
 */
public class Snake {
        private final int TILE_WIDTH;
        private final int TILE_HEIGHT ;
        private Point snakeTiles[];
        private int numSnakeTiles=3;
        //constructor
        public Snake (){
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
        public void Appleeaten(){
            this.numSnakeTiles+=numSnakeTiles;
            snakeTiles[numSnakeTiles] = new Point();
        }
        
}
