package snakegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import Menu.Menu;

public class board extends JPanel implements ActionListener {
    int bwidth = 700;
    int bheight = 700;
    int pixel = 25;
    int score;
    
    final int BoardPixels = (bwidth * bheight) / (pixel* pixel);
    private Timer t;
    boolean isGameRunning;
    private int scoring = 120;

    private Menu i;
    snake snake = new snake();
    apple apple = new apple();

    public board() {
        setBackground(Color.BLACK);
        setBounds(30, 10, 700, 700);
        setFocusable(true);
        
        addKeyListener(new SnakeController());
        initBoard();
        
        setVisible(true);
    }
    
    public void initBoard(){
        isGameRunning = true;
        snake.direction = "right";
        snake.setIniSnakeTiles(3);
       
        Point currentSnakeTile;
        for (int i = 0; i<= snake.getIniSnakeTiles(); i++) {
            currentSnakeTile = snake.snakeTiles[i] = new Point();
            currentSnakeTile.x = ((bwidth / 2) - 100) - (i * pixel);
            currentSnakeTile.y = (bheight / 2);
        }      
        apple.createApple(this);
    }

    public void checkApple() {
        // When snake head is directly on the apple tile,
        // apple is then consumed
        if ((snake.snakeTiles[0].x == apple.getAppleTilex()) && (snake.snakeTiles[0].y == apple.getAppleTiley())) {
            snake.numSnakeTiles++; 
            snake.snakeTiles[snake.numSnakeTiles] = new Point(); //add longer tail
            setScore((snake.getNumSnakeTiles()-3) * getScoring()); //Mult * Scoring = 120
            apple.createApple(this);
            
        }
    }
    public void checkBoundsCollision() {
        // Check if the snake ran into itself
         for (int ind = snake.numSnakeTiles; ind > 0; ind--) {
            if ((snake.snakeTiles[0].x == snake.snakeTiles[ind].x)
                    && (snake.snakeTiles[0].y == snake.snakeTiles[ind].y)) {
                isGameRunning = false;
            }
        }
        // Check if the snake hits the edges
        if ((snake.snakeTiles[0].x > bwidth) || (snake.snakeTiles[0].x < 0) || (snake.snakeTiles[0].y < 0) || (snake.snakeTiles[0].y > bheight)) {
            isGameRunning = false;
        }
        
        if (!isGameRunning) {
            reset();
        }   
    }
  
    private void reset() {
       this.score = 0;
       snake.numSnakeTiles = 3;
    }
       
    public int getBwidth() {
        return bwidth;
    }

    public int getBheight() {
        return bheight;
    }

    public int getPixel() {
        return pixel;
    }

    public int getBoardPixels() {
        return BoardPixels;
    }

    public void setScore(int score) {
        this.score = score;
    }
  
    public int getScoring() {
        return scoring;
    }

    public int getScore() {
        return score;
    }
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics g2d = (Graphics2D) g;
        ImageIcon izquierda = new ImageIcon(getClass().getResource("CabezaAlRevés.jpg"));
        ImageIcon derecha = new ImageIcon(getClass().getResource("CabezaRecta.jpg"));
        ImageIcon arriba = new ImageIcon(getClass().getResource("CabezaArriba.jpg"));
        ImageIcon abajo = new ImageIcon(getClass().getResource("CabezaAbajo.jpg"));
        ImageIcon derechac = new ImageIcon(getClass().getResource("crecto.jpg"));
        ImageIcon abajoc = new ImageIcon(getClass().getResource("carriba.jpg"));
        ImageIcon topleft = new ImageIcon(getClass().getResource("izqtop.png"));
        ImageIcon leftbot = new ImageIcon(getClass().getResource("leftbot.png"));
        ImageIcon botright = new ImageIcon(getClass().getResource("botright.png"));
        ImageIcon righttop = new ImageIcon(getClass().getResource("righttop.png"));
        ImageIcon tileleft = new ImageIcon(getClass().getResource("colaiz.png"));
        ImageIcon tilebot = new ImageIcon(getClass().getResource("colaab.png"));
        ImageIcon tileright = new ImageIcon(getClass().getResource("colader.png"));
        ImageIcon tiletop = new ImageIcon(getClass().getResource("colaar.png"));
        ImageIcon pineapple = new ImageIcon(getClass().getResource("apple.png"));
       
        if(isGameRunning) {
            //paint apple
            //Color appleColor = apple.getApple_color();
            g2d.drawImage(pineapple.getImage(), apple.getAppleTilex(), apple.getAppleTiley(), pixel, pixel, null);

            // Paint snake as a series of squares based on tile coordinates
            Point currentSnakeTile;
            for (int ind = 0; ind < snake.numSnakeTiles; ind++) {
                currentSnakeTile = snake.snakeTiles[ind];
                int actualy = snake.snakeTiles[ind].y;
                int actualx = snake.snakeTiles[ind].x;
                 if ((ind == 0) && (snake.direction == "left")) {
                      g2d.drawImage(izquierda.getImage(), currentSnakeTile.x, currentSnakeTile.y, snake.getTILE_WIDTH(), snake.getTILE_HEIGHT(), null); 
                    } else if ((ind == 0) && (snake.direction == "right")) {
                       g2d.drawImage(derecha.getImage(), currentSnakeTile.x, currentSnakeTile.y, snake.getTILE_WIDTH(), snake.getTILE_HEIGHT(), null); 
                    } else if ((ind == 0) && (snake.direction == "up")) {
                      g2d.drawImage(arriba.getImage(), currentSnakeTile.x, currentSnakeTile.y, snake.getTILE_WIDTH(), snake.getTILE_HEIGHT(), null); 
                    } else if ((ind == 0) && (snake.direction == "down")) {
                       g2d.drawImage(abajo.getImage(), currentSnakeTile.x, currentSnakeTile.y, snake.getTILE_WIDTH(), snake.getTILE_HEIGHT(), null); 
                    }
                 else if (ind == snake.numSnakeTiles-1) {
                // Tail; Determine the correct image
                Point prev = snake.snakeTiles[ind-1]; // Prev segment
                if (prev.y < actualy) {
                    // Up
                    g2d.drawImage(tiletop.getImage(), currentSnakeTile.x, currentSnakeTile.y, snake.getTILE_WIDTH(), snake.getTILE_HEIGHT(), null);
                } else if (prev.x > actualx) {
                    // Right
                    g2d.drawImage(tileright.getImage(), currentSnakeTile.x, currentSnakeTile.y, snake.getTILE_WIDTH(), snake.getTILE_HEIGHT(), null);
                } else if (prev.y > actualy) {
                    // Down
                    g2d.drawImage(tilebot.getImage(), currentSnakeTile.x, currentSnakeTile.y, snake.getTILE_WIDTH(), snake.getTILE_HEIGHT(), null);
                } else if (prev.x < actualx) {
                    // Left
                    g2d.drawImage(tileleft.getImage(), currentSnakeTile.x, currentSnakeTile.y, snake.getTILE_WIDTH(), snake.getTILE_HEIGHT(), null);
                }                    
                 }else {
                // Body; Determine the correct image
                Point prev = snake.snakeTiles[ind-1]; // Previous segment
                Point next = snake.snakeTiles[ind+1]; // Next segment
                if (prev.x < actualx && next.x > actualx || next.x < actualx && prev.x > actualx) {
                    // Horizontal Left-Right
                    g2d.drawImage(derechac.getImage(), currentSnakeTile.x, currentSnakeTile.y, snake.getTILE_WIDTH(), snake.getTILE_HEIGHT(), null);
                } else if (prev.x < actualx && next.y > actualy || next.x < actualx && prev.y > actualy) {
                    // Angle Left-Down
                    g2d.drawImage(leftbot.getImage(), currentSnakeTile.x, currentSnakeTile.y, snake.getTILE_WIDTH(), snake.getTILE_HEIGHT(), null);
                } else if (prev.y < actualy && next.y > actualy || next.y < actualy && prev.y > actualy) {
                    // Vertical Up-Down
                    g2d.drawImage(abajoc.getImage(), currentSnakeTile.x, currentSnakeTile.y, snake.getTILE_WIDTH(), snake.getTILE_HEIGHT(), null);
                } else if (prev.y < actualy && next.x < actualx || next.y < actualy && prev.x < actualx) {
                    // Angle Top-Left
                    g2d.drawImage(topleft.getImage(), currentSnakeTile.x, currentSnakeTile.y, snake.getTILE_WIDTH(), snake.getTILE_HEIGHT(), null);;
                } else if (prev.x > actualx && next.y < actualy || next.x > actualx && prev.y < actualy) {
                    // Angle Right-Up
                    g2d.drawImage(righttop.getImage(), currentSnakeTile.x, currentSnakeTile.y, snake.getTILE_WIDTH(), snake.getTILE_HEIGHT(), null);
                } else if (prev.y > actualy && next.x > actualx || next.y > actualy && prev.x > actualx) {
                    // Angle Down-Right
                    g2d.drawImage(botright.getImage(), currentSnakeTile.x, currentSnakeTile.y, snake.getTILE_WIDTH(), snake.getTILE_HEIGHT(), null);
                }
            }}
           // Paint the score at the top left
          //  int score = (snake.numSnakeTiles * D1) - (INITIAL_SNAKE_TILES * D1));
            String msg = "Score: " + getScore();
           
            Font small = new Font("Helvetica Nueue", Font.BOLD, 20);
            g.setColor(Color.GREEN);
            g.setFont(small);
            g.drawString(msg, bwidth - 150, 30);

            // Tell the System to do the Drawing now,
            // otherwise it can take a few extra ms until
            // drawing is done which looks very jerky
            Toolkit.getDefaultToolkit().sync();

            // Cleanup the graphics instance after use
            g.dispose();
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(board.class.getName()).log(Level.SEVERE, null, ex);
            }
        i.changeMenu();  
    }
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isGameRunning) {
            checkApple();
            checkBoundsCollision();
            snake.moveSnake();
            repaint();
        }
    }

        private class SnakeController extends KeyAdapter {
        // Fires whenever a key on the keyboard is pressed
        // Handle arrow keys and the 'g' key for starting a new game.

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_A) && !("right".equals(snake.direction))) {
                snake.direction = "left";
            } else if ((key == KeyEvent.VK_RIGHT) || (key == KeyEvent.VK_D)&& !("left".equals(snake.direction))) {
                snake.direction = "right";
            } else if ((key == KeyEvent.VK_UP) || (key == KeyEvent.VK_W) && !("down".equals(snake.direction))) {
                snake.direction = "up";
            } else if ((key == KeyEvent.VK_DOWN)|| (key == KeyEvent.VK_S) && !("up".equals(snake.direction))) {
                snake.direction = "down";
            }
        }
    }
}
