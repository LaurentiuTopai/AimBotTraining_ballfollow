import javax.swing.*;

public class Frame extends JFrame {

    public Frame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Test");
        this.setSize(800,600);
        this.add(new Panel());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
