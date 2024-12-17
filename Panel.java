import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel {
    JTextField textField;
    JTextField clicksTextField;
    private int balx=50;
    private int baly=50;
    private int x=800;
    private int y=600;
    private int deltax=5;
    private int deltay=5;
    private boolean mouseControl=false;
    private int clicks;
    public Panel() {
        clicks=0;
        textField = new JTextField(10);
        clicksTextField = new JTextField(10);
        this.setBackground(Color.BLACK);
        Timer timer = new Timer(10,e-> {
                checkColisions();
                moveMouseToBall();
                 repaint();
        });
        timer.start();
        this.add(textField);
        this.add(clicksTextField);
    }
    public void checkColisions()
    {
        if(balx+50>=x || balx<=0)
        {
            deltax*=-1;
        }
        if(baly+50>=y || baly<=0)
        {
            deltay*=-1;
        }
        balx+=deltax;
        baly+=deltay;
        textField.setText("X= "+balx+ "Y= "+baly);

    }
    public void moveMouseToBall()
    {
        try {
            Robot robot = new Robot();
            Point locationOnScreen=this.getLocationOnScreen();
            int mousex=locationOnScreen.x+balx+25;
            int mousey=locationOnScreen.y+baly+25;
            robot.mouseMove(mousex, mousey);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            clicks++;
            clicksTextField.setText("Numar de clickuri: "+clicks);
            if(clicks==300)
            {
                System.exit(0);
            }

        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(balx,baly,50,50);
    }
}
