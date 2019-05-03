package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ActionListen implements ActionListener {

    private Timer t;
    private JFrame InstructionsF,DifficultyF;
    private JPanel Instructions,Difficulty;
    private Menu i;
    
    public ActionListen(){//create an action listen that calling the difficultybutton and including all radio button
        difficultyButton();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // getActionCommand returns the string of the button
        String clickedButton = e.getActionCommand();

        // Check which button is clicked
        switch (clickedButton) {
            case "Start":
                startButton();
                break;
            case "Instructions":
                instructionsButton();
                break;
            case "Difficulty":
                DifficultyF.setVisible(true);
                break;
            case "Exit":
                exitButton();
                break;
        }

    }  
    
    private void startButton() {//method that call  start button

        Menu j = this.i;
        j.changeToGame();

    }

    public void getprincipal(Menu i) {
        this.i = i;
    }

    private void instructionsButton() {//method that calling instructtion button   
       
        Instructions = new JPanel();
        Instructions.setBackground(new Color(0, 0, 0, 0));
        Instructions.setBounds(15, 80, 600, 400);
        String content = "-First, select the level of difficulty by clicking on DIFFICULTY.\n"
                + "-Then, to start the game, just select START.\n"
                + "-To leave the game the game select 'EXIT'.\n"
                + "-To go to the right press D or the arrow.\n"
                + "-To go to the left press A or the arrow.\n"
                + "-To go up press W or the arrow.\n"
                + "-To go down press S or the arrow.";
        JTextArea area = new JTextArea(content);// you will see instructions in included this jtextarea after clicking on
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
 
    private void difficultyButton() {//method that calling ddifficulty button
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

        JRadioButton god = new JRadioButton("God");
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
                    Menu.delay = 200;
                } else if (medium.isSelected()) {
                    Menu.delay = 100;
                } else if (god.isSelected()) {
                    Menu.delay = 50;
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

    private void exitButton() {   
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "EXIT",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

}