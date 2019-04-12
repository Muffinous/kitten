package graphics1;

import java.awt.*;

import java.awt.event.*;
import java.util.Locale;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.plaf.ColorUIResource;

public class j1 extends JFrame implements ActionListener {

    private JPanel heading, name3, name4, login, name2;

    private JLabel background;
    private JFrame j, h;
    private JButton b, b1, b2, b3;
    private SnakeGame b11;
    private Timer t;
    private static final String NORMAL = "Normal";
    private static final String MEDIUM = "Medium";
    private static final String DIFFICULT = "Difficult";

    private int DELAY = 120;

    public j1() {

        setSize(1200, 970);

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

    private void iniciarComponentes() {//calling all panels  and botons 

        botones();
        paneles2();

        boton4();
        botones2();
        boton3();

        paneles();
        colocarbackground();

    }

    private void paneles() {//JFrame heading
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

    private void paneles2() {  //side panel in which we have all buttons (start, instructions, difficulty,, exit)
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
        //when we will click on Difficulty button this panel will appear
        name4 = new JPanel();

        //boton 2 difficulty
        b3 = new JButton("DIFFICULTY");
        b3.setFocusable(false);
        b3.setFont(new Font("cooper black", 0, 40));
        b3.setForeground(Color.GREEN);

        b3.setBackground(Color.BLACK);
        b3.setBounds(10, 90, 250, 50);

        b3.addActionListener(this);

        login.add(b3);
    }

    private void boton3() {//  exit button method after clicking on it there will be options of yes and no if you click on on yes button game window will be closed else it will continue
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

    private void boton4() {// instructionn button after clicking on it u will see a frame with instructions

        name3 = new JPanel();

        b1 = new JButton("INSTRUCTION");
        b1.setFocusable(false);
        b1.setFont(new Font("cooper black", 0, 40));
        b1.setForeground(Color.GREEN);
        b1.setBackground(Color.BLACK);

        b1.setBounds(40, 300, 250, 50);

        b1.addActionListener(this);

        login.add(b1);

    }

    private void colocarbackground() {//  background methods  for all panels 
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
        background.add(name4);
        add(background);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
          //if we will click on instruction button new frame will appear else difficulty button action will be perforrmed 
        if(e.getSource()==b1){   
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
 
        }else  {
            //its the panel in which radiobuttons will appear
            JPanel name4 = new JPanel();
            name4.setBounds(0, 138, 590, 90);
            name4.setBackground(Color.darkGray);            
            ButtonGroup b = new ButtonGroup();
            JRadioButton r1 = new JRadioButton();
            r1.setFocusable(false);//radio button normal  with all settings
            r1.setText("NORMAL");
            r1.setFont(new Font("cooper black", 0, 30));
            r1.setForeground(Color.GREEN);
            r1.setBackground(null);

            JRadioButton r2 = new JRadioButton();//radio button medium with all settings
            r2.setText("MEDIUM");
            r2.setFont(new Font("cooper black", 0, 30));
            r2.setForeground(Color.GREEN);
            r2.setBackground(null);
            r2.setFocusable(false);

            JRadioButton r3 = new JRadioButton(); //radio button difficulty  with all settings
            r3.setText("DIFFICULTY");
            r3.setFont(new Font("cooper black", 0, 30));
            r3.setForeground(Color.GREEN);
            r3.setBackground(null);
            r3.setFocusable(false);
            b.add(r1);
            b.add(r2);
            b.add(r3);
            name4.add(r1);
            name4.add(r2);
            name4.add(r3);
            

            if (r1.isSelected()) {
                DELAY = 100;
            } else if (r2.isSelected()) {
                DELAY = 200;

            } else if (r3.isSelected()) {

                DELAY = 70;
            }

            h = new JFrame();//frame for difficulty button
            h.setUndecorated(true);
            h.getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);
            h.setBounds(this.getLocationOnScreen().x + 120, this.getLocationOnScreen().y + 250, 600,400);
           
            ImageIcon back = new ImageIcon("C:/Users/alldocube/Pictures/green2.jpg");//backgroud image of frame 
            Image im = back.getImage();
            Image temp_im = im.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
            back = new ImageIcon(temp_im);
            JLabel background2 = new JLabel(" ", back, JLabel.CENTER);
            background2.add(name4);
            h.add(background2);
            h.setVisible(true);
            h.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        }
    }


