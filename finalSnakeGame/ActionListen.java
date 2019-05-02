
package finalSnakeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ActionListen implements ActionListener {

    private Timer t;
    private int delay = 100;
    private JFrame InstructionsF,DifficultyF;
    private JPanel Instructions,Difficulty;
    private Menu i;
    
    public ActionListen(){//create an action listen that calling the difficultybutton and including all radio button
        difficultybutton();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // getActionCommand returns the string of the button
        String clickedButton = e.getActionCommand();

        // Check which button is clicked
        if (clickedButton.equals("Start")) {
            startbutton();
        } else if (clickedButton.equals("Instructions")) {
            instructionsbutton();
        } else if (clickedButton.equals("Difficulty")) {
            DifficultyF.setVisible(true);
        } else if (clickedButton.equals("Exit")) {
            exitbutton();
        }

    }
    

    private void startbutton() {//method that call  start button

        Menu j = this.i;
        j.changeToGame();

    }

    public void getprincipal(Menu i) {
        this.i = i;
    }

    private void instructionsbutton() {//method that calling instructtion button
      

        Instructions = new JPanel();
        Instructions.setBackground(new Color(0, 0, 0, 0));
        Instructions.setBounds(15, 80, 600, 400);
        String content = "-Primero eliges el nivel del juego pulsando boton' DIFFICULTY'.\n"
                + "-Luego para empezar y reiniciar el juego pulsa'START'.\n"
                + "-Para Salir de Juego pulsa boton 'EXIT'.\n"
                + "-Para ir a derecha pulsa boton derecha de tu teclado.\n"
                + "-Para ir a izquierda pulsa boton izquierda de tu teclado.\n"
                + "-Para ir Arriba pulsa boton de arriba en de teclado.\n"
                + "-Para ir abajo pulsa boton de abajo en de teclado.";
        JTextArea area = new JTextArea(content);// you will see instructions included this jtextarea after clicking on
        // instruction button
        area.setEditable(false);
        area.setFont(new Font("cooper black", 2, 19));
        Instructions.setBounds(15, 80, 600, 400);

        area.setBackground(Color.BLACK);
        area.setForeground(Color.GREEN);
        Instructions.add(area);

        InstructionsF = new JFrame();
        InstructionsF.setUndecorated(true);
        InstructionsF.getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);
        InstructionsF.setResizable(false);
        InstructionsF.setLocationRelativeTo(null);
        
        ImageIcon backimage = new ImageIcon("src/finalSnakeGame/dark.jpg");
        Image img = backimage.getImage();
        Image temp_img = img.getScaledInstance(650, 400, Image.SCALE_SMOOTH);
        backimage = new ImageIcon(temp_img);
        JLabel background1 = new JLabel(" ", backimage, JLabel.CENTER);

        InstructionsF.setBounds(120, 300, 650, 400);
        background1.add(Instructions);
        InstructionsF.add(background1);
        InstructionsF.setVisible(true);
        InstructionsF.setLocationRelativeTo(null);
        InstructionsF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
 
    private void difficultybutton() {//method that calling ddifficulty button
        DifficultyF = new JFrame();
        
        Difficulty = new JPanel();
        Difficulty.setBounds(0, 138, 590, 50);
        Difficulty.setBackground(Color.BLACK);

        ButtonGroup b = new ButtonGroup();

        JRadioButton easy = new JRadioButton("Easy");
        easy.setFont(new Font("cooper black", 0, 30));
        easy.setForeground(Color.GREEN);
        easy.setBackground(null);

        JRadioButton medium = new JRadioButton("Medium");
        medium.setFont(new Font("cooper black", 0, 30));
        medium.setForeground(Color.GREEN);
        medium.setBackground(null);

        JRadioButton god = new JRadioButton("Hard");
        god.setFont(new Font("cooper black", 0, 30));
        god.setForeground(Color.GREEN);
        god.setBackground(null);

        easy.setFocusable(false);
        medium.setFocusable(false);
        god.setFocusable(false);

        b.add(easy);
        b.add(medium);
        b.add(god);
        easy.setSelected(true);
        Difficulty.add(easy);
        Difficulty.add(medium);
        Difficulty.add(god);

        ActionListener ACD = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (easy.isSelected()) {
                    Menu.DELAY = 150;
                } else if (medium.isSelected()) {
                    Menu.DELAY = 100;
                } else if (god.isSelected()) {
                    Menu.DELAY = 50;
                }
            }
        };

        easy.addActionListener(ACD);
        medium.addActionListener(ACD);
        god.addActionListener(ACD);
        ImageIcon backimage = new ImageIcon("src/finalSnakeGame/dark.jpg");
        Image img = backimage.getImage();
        Image temp_img = img.getScaledInstance(650, 400, Image.SCALE_SMOOTH);
        backimage = new ImageIcon(temp_img);
        JLabel background1 = new JLabel(" ", backimage, JLabel.CENTER);
        background1.add(Difficulty);
        DifficultyF.add(background1);
        DifficultyF.setBounds(120, 350, 600, 400);
        DifficultyF.setLocationRelativeTo(null);
        DifficultyF.setVisible(false);
        DifficultyF.setAlwaysOnTop(true);

    }

    private void exitbutton() {  //create an action listen that calling the difficultybutton and including all radio button
        
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "EXIT",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

}
