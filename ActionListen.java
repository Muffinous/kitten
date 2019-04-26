package snakey;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ActionListen implements ActionListener {
    int delay; 
    private Timer t;
    SnakeGame snakey = new SnakeGame();
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // getActionCommand returns the string of the button
        String clickedButton = e.getActionCommand();
       
        //Check which button is clicked
        if (clickedButton.equals("Start")) {
            startbutton();
        } 
        else if (clickedButton.equals("Instructions")) {
            instructionsbutton();
        } 
        else if (clickedButton.equals("Difficulty")) {
            difficultybutton();
        } 
        else if (clickedButton.equals("Exit")) {
            exitbutton();
        }
        
      /*  switch (button) {
            case (button.equals("Start")):
                break;
                
        } */
    }

    private void startbutton() {
        System.out.println("starting");
        
        JFrame play = new JFrame();
        
        snakey.initGameBoard();
        
        t = new Timer(delay, snakey);
        t.start();
        
        play.add(snakey);
    }
    
    private void instructionsbutton() {
         //JOptionPane.showMessageDialog(null, "Instructions");
         JFrame InstructionsF = new JFrame();
         JPanel Instructions = new  JPanel();
         
         InstructionsF.setTitle("Instructions");
         InstructionsF.setSize(350, 350);
         InstructionsF.setLocationRelativeTo(null);
         String content = "-Primero eliges el nivel del juego pulsando boton' DIFFICULTY'.\n"
                    + "-Luego para empezar y reiniciar el juego pulsa'START'.\n"
                    + "-Para Salir de Juego pulsa boton 'EXIT'.\n"
                    + "-Para ir a derecha pulsa boton derecha de tu teclado.\n"
                    + "-Para ir a izquierda pulsa boton izquierda de tu teclado.\n"
                    + "-Para ir Arriba pulsa boton de arriba en de teclado.\n"
                    + "-Para ir abajo pulsa boton de abajo en de teclado.";
         JTextArea area = new JTextArea(content);
         area.setEnabled(false); 
         area.setEditable(false); //can't write
         
        // Instructions.setBounds(15, 40, 100, 100);
         Instructions.add(area);
         
         InstructionsF.setResizable(false);
         InstructionsF.show();
         InstructionsF.getContentPane().add(Instructions);
         
         Instructions.setVisible(true);
    }

    private void difficultybutton() {
         JFrame DifficultyF = new JFrame();
         JPanel Difficulty = new  JPanel();
         ButtonGroup b = new ButtonGroup();
         
         DifficultyF.setTitle("Choose difficulty");
         DifficultyF.setSize(350, 350);
         DifficultyF.setLocationRelativeTo(null);
         
         JRadioButton easy = new JRadioButton("Easy");
         JRadioButton medium = new JRadioButton("Medium");
         JRadioButton god = new JRadioButton("God");
         
         easy.setFocusable(false);
         medium.setFocusable(false);
         god.setFocusable(false);
        
         b.add(easy); 
         b.add(medium);
         b.add(god);

         Difficulty.add(easy);
         Difficulty.add(medium);
         Difficulty.add(god);
         
         ActionListener ACD = new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                if (easy.isSelected()) {
                    delay = 150;
                    System.out.println("Easy");
                } else if (medium.isSelected()) {
                    delay = 100;
                } else if (god.isSelected()) {
                    delay = 50;
                }
            }
        };
                 
         easy.addActionListener(ACD);
         medium.addActionListener(ACD);
         god.addActionListener(ACD);

         DifficultyF.show();
         DifficultyF.getContentPane().add(Difficulty);
         Difficulty.setVisible(true);

    }

    private void exitbutton() { 
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "EXIT", JOptionPane.YES_NO_OPTION);
             if (option == JOptionPane.YES_OPTION) {
                 System.exit(0);
             }
    }
    
}
