package snakey;
// VIEW
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {
    JPanel panel = new JPanel();

    public Menu() {
        setTitle("Menu");
        setSize(780,560);
        setResizable(true);
        panel.setBackground(Color.black);
       // panel.setLayout(new GridLayout(4,1));
       // panel.setBounds(40, 300, 250, 50);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(Menu.EXIT_ON_CLOSE);
        
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        AddButtons();
    }
    
    private void AddButtons() {
        
        JButton start = new JButton("Start");
        start.setForeground(Color.GREEN);
        start.setFont(new Font("cooper black", 0, 30));
        //start.setPreferredSize(new Dimension(100,100));
        panel.add(start);
        
        JButton instructions = new JButton("Instructions");
        instructions.setForeground(Color.GREEN);
        instructions.setFont(new Font("cooper black", 0, 30));
        panel.add(instructions);
        
        JButton difficulty = new JButton("Difficulty");
        difficulty.setForeground(Color.GREEN);
        difficulty.setFont(new Font("cooper black", 0, 30));
        panel.add(difficulty);
        
        JButton exit = new JButton("Exit");
        exit.setForeground(Color.GREEN);
        exit.setFont(new Font("cooper black", 0, 30));
        panel.add(exit);
        
        //create and add action listener to the buttons
        ActionListen AC = new ActionListen();
        start.addActionListener(AC);
        instructions.addActionListener(AC);
        difficulty.addActionListener(AC);
        exit.addActionListener(AC);
        
        this.getContentPane().add(panel);   

    }
    
    /*private void setBackground() {
        BufferedImage image = read(new File("snake.jpg"));
        JLabel label = new JLabel(new ImageIcon(image));
        panel.add(label);
        
    }*/ 

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
