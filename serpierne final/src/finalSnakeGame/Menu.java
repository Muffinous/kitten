
package finalSnakeGame;

// VIEW
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Menu extends JFrame {
    private static CardLayout c1;
    private static Timer t;
    public static int DELAY=120;
    private ActionListen a;
    private JPanel panel;
    private JButton start, instructions, difficulty, exit;
    private SnakeGame b11;
    private static JLabel background;

    public Menu() {
        setTitle("Menu");
        setSize(1000,800);
        setResizable(false);
        ImageIcon backimage = new ImageIcon("src/finalSnakeGame/snake.jpg");
        Image img = backimage.getImage();
        Image temp_img = img.getScaledInstance(1200, 900, Image.SCALE_SMOOTH);
        backimage = new ImageIcon(temp_img);
        this.setContentPane(new JLabel("",backimage,JLabel.CENTER));
        setLocationRelativeTo(null);
        b11= new SnakeGame();
        initComponents();
        setVisible(true);
        a.getprincipal(this);
        
        
    }

    private void initComponents() {//calling the addbuttons methods and colocarBackground
    	
    	AddButtons();
    	colocarbackground();
    	
        
    }

    private void AddButtons() {//In this method we have added all buttons and call the their actionlistener with actionlistenclass
        JLabel label = new JLabel(new ImageIcon("src/finalSnakeGame/frame2.jpg"));//image included in Jpanel that is using for Jbuttons
        ImageIcon iconA = new ImageIcon("src/finalSnakeGame/oth.gif");
        label.setBounds(0, 0, 900, 900);
        label.setFocusable(false);
        
        panel = new JPanel();//panel for Jbuttons
        panel.setFocusable(false);
        this.getContentPane().add(panel);
        panel.setBounds(225, 150, 900, 900);

        Border thickBorder = new LineBorder(Color.BLACK, 5);//border for all JButtons
        
        start = new JButton("Start");//start Button and designing
        start.setForeground(Color.BLACK);
        start.setBorder(thickBorder);
        start.setBackground(Color.GREEN.darker().darker());
        start.setFont(new Font("cooper black", 0, 27));
        start.setBounds(100, 100, 210, 50);
        start.setFocusable(false);
        label.add(start);//including start Button into image

        instructions = new JButton("Instructions");//instruction button and designing 
        instructions.setForeground(Color.BLACK);
        instructions.setBackground(Color.GREEN.darker().darker());
        instructions.setBorder(thickBorder);
        instructions.setFont(new Font("cooper black", 0, 27));
        instructions.setBounds(100, 150, 210, 50);
        instructions.setFocusable(false);
        label.add(instructions);//including instruction Button into image

        difficulty = new JButton("Difficulty");//difficulty button and designing 
        difficulty.setForeground(Color.BLACK);
        difficulty.setBackground(Color.GREEN.darker().darker());
        difficulty.setBorder(thickBorder);
        difficulty.setFont(new Font("cooper black", 0, 27));
        difficulty.setBounds(100, 200, 210, 50);
        difficulty.setFocusable(false);
        label.add(difficulty);//including difficulty Button into image

        exit = new JButton("Exit");//exit button and designing 
        exit.setForeground(Color.BLACK);
        exit.setBackground(Color.GREEN.darker().darker());
        exit.setBorder(thickBorder);
        exit.setFont(new Font("cooper black", 0, 27));
        exit.setBounds(100, 250, 210, 50);
        exit.setFocusable(false);
        label.add(exit);//including exit Button into image

        //create and add action listener to the buttons
        a = new ActionListen();
        start.addActionListener(a);
        instructions.addActionListener(a);
        difficulty.addActionListener(a);
        exit.addActionListener(a);
        panel.add(label);

    }

    private void colocarbackground() {//  background methods  for all panels 
        
        background = new JLabel();
        background.setLayout(new CardLayout());
        background.add(b11,"gamepanel");
        background.add(panel,"higame");
        background.setBounds(280,130,400, 400);
        add(background);
        c1=(CardLayout) background.getLayout();
        c1.show(background, "higame");
        

    }
    
    public void changeToGame() {
    	background.setBounds(10,15,730, 730);
        background.setBorder(new LineBorder(Color.green,8, true));
    	c1=(CardLayout)background.getLayout();
    	c1.show(background, "gamepanel");
    	b11.initGameBoard();
    	b11.requestFocus();
    	t = new Timer(DELAY, b11);
	t.start();
        
        
    }
    
    public static void changeMenu(){
        
        t.stop();
        background.setBounds(280,130,400, 400);
        c1.show(background, "higame");
        
    }
    
     
}
