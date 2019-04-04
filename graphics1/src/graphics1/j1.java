package graphics1;

import java.awt.*;

import java.awt.event.*;
import java.util.Locale;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.plaf.ColorUIResource;

public class j1 extends JFrame implements ActionListener {

    private JPanel heading, name3, login, name2;
    private JLabel background;
    private JFrame j;
    private JButton b, b1, b2, b3;
    private SnakeGame b11;
    private Timer t;
    private static final String NORMAL = "Normal";
    private static final String MEDIUM = "Medium";
    private static final String DIFFICULT = "Difficult";

    private int DELAY;

    public j1() {

        setSize(1200, 970);
        setBackground(Color.CYAN);
        setUndecorated(true); //
        getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);//for changing titlebar
        this.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;

        // Move the window
        this.setLocation(x, y);
        setTitle("SNAKE GAME");
        iniciarComponentes();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void iniciarComponentes() {

        botones();
        paneles2();

        boton4();
        botones2();
        boton3();

        paneles();
        colocarbackground();

    }

    private void paneles() {
        heading = new JPanel();
        this.getContentPane().add(heading);
        heading.setBackground(new Color(0, 0, 0, 20));
        heading.setBounds(0, 0, 1200, 100);
        JLabel name = new JLabel("Welcome to Snake Game");
        name.setBounds(200, 90, 400, 70);
        name.setForeground(Color.BLACK);
        name.setFont(new Font("cooper black", 0, 55));
        heading.add(name);
    }

    private void paneles2() {
        login = new JPanel();
        this.getContentPane().add(login);

        login.setBounds(850, 100, 350, 900);
        login.setBackground(new Color(0, 0, 0, 40));
        login.add(b);

    }

    private void botones() {
        //when we will click on start this panel will appear
        b11 = new SnakeGame();
        //boton 1 start
        b = new JButton("START");
        b.setFocusable(false);
        b.setFont(new Font("cooper black", 0, 40));
        b.setForeground(Color.GREEN);
        ;
        b.setBackground(Color.BLACK);
        b.setBounds(10, 90, 250, 50);

        ActionListener ac = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Timer t = new Timer(DELAY, b11);
                t.start();

            }

        };
        b.addActionListener(ac);
    }

    private void botones2() {
        //when we will click on start this panel will appear
        b11 = new SnakeGame();
        //boton 1 start
        b3 = new JButton("DIFFICULTY");
        b3.setFocusable(false);
        b3.setFont(new Font("cooper black", 0, 40));
        b3.setForeground(Color.GREEN);
        ;
        b3.setBackground(Color.BLACK);
        b3.setBounds(10, 90, 250, 50);

        ActionListener ac11 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                UIManager.put("OptionPane.background", Color.TRANSLUCENT);
                UIManager.put("Panel.background", Color.TRANSLUCENT);
                UIManager.put("Button.background", Color.white);

                String[] cab = new String[3];
                cab[0] = NORMAL;
                cab[1] = MEDIUM;
                cab[2] = DIFFICULT;

                Object selectedCab = JOptionPane.showInputDialog(null, "ELIGE NIVEL", "DIFFICULTY", JOptionPane.QUESTION_MESSAGE, null, cab, NORMAL);
                if (selectedCab.equals(NORMAL)) {
                    DELAY = 300;

                }
                if (selectedCab.equals(MEDIUM)) {
                    DELAY = 100;

                }
                if (selectedCab.equals(DIFFICULT)) {
                    DELAY = 70;
                }

            }

        };
        b3.addActionListener(ac11);
        login.add(b3);
    }

    private void boton3() {
        name2 = new JPanel();
        b2 = new JButton("EXIT");
        b2.setFocusable(false);
        b2.setFont(new Font("cooper black", 0, 40));
        b2.setForeground(Color.GREEN);
        b2.setBackground(Color.BLACK);

        b2.setBounds(40, 300, 250, 50);
        ActionListener ac1 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UIManager.put("OptionPane.background", Color.TRANSLUCENT);
                UIManager.put("Panel.background", Color.TRANSLUCENT);
                UIManager.put("Button.background", Color.white);

                int dialogResult = JOptionPane.showConfirmDialog(null, "Seguro que quieres salir", "EXIT", JOptionPane.YES_NO_OPTION);

                if (dialogResult == 0) {
                    System.exit(0);
                    System.out.println("");
                } else {
                    System.out.println("");
                }

            }

        };
        b2.addActionListener(ac1);

        login.add(b2);

    }

    private void boton4() {

        name3 = new JPanel();
        
        b2 = new JButton("INSTRUCTION");
        b2.setFocusable(false);
        b2.setFont(new Font("cooper black", 0, 40));
        b2.setForeground(Color.GREEN);
        b2.setBackground(Color.BLACK);

        b2.setBounds(40, 300, 250, 50);

        b2.addActionListener(this);

        login.add(b2);

    }

    private void colocarbackground() {// method for background for all panels 
        ImageIcon backimage = new ImageIcon("C:/Users/alldocube/Pictures/snake.jpg");
        Image img = backimage.getImage();
        Image temp_img = img.getScaledInstance(1200, 950, Image.SCALE_SMOOTH);
        backimage = new ImageIcon(temp_img);
        JLabel background = new JLabel("", backimage, JLabel.CENTER);

        background.add(heading);
        background.add(login);
        background.add(b11);
        background.add(name3);
        background.add(name2);
        add(background);

    }

    @Override
    public void actionPerformed(ActionEvent e) {//when you click on button instruction this action will perform and it will be a new JFrame
        JPanel h1 = new JPanel();
        this.getContentPane().add(h1);
        h1.setBackground(new Color(0, 0, 0, 0));
        h1.setBounds(0, 138, 600, 100);
        JLabel name = new JLabel();
        name.setText("-Para reiniciar el juego pulsa 'ENTER'");
        
        name.setForeground(Color.GREEN);
        name.setFont(new Font("cooper black", 0, 23));
       
        h1.add(name);
        j = new JFrame();
        j.setUndecorated(true);
        j.getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);
        j.setResizable(false);
        ImageIcon backimage = new ImageIcon("C:/Users/alldocube/Pictures/green2.jpg");
        Image img = backimage.getImage();
        Image temp_img = img.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
        backimage = new ImageIcon(temp_img);
        JLabel background1 = new JLabel(" ", backimage, JLabel.CENTER);

        j.setBounds(this.getLocationOnScreen().x + 120, this.getLocationOnScreen().y + 250, 600, 600);
        background1.add(h1);
        j.add(background1);

        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

}
