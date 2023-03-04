import javax.swing.*;
import java.awt.*;

public class LayoutExample extends JFrame {
  public LayoutExample() {
    setTitle("Layout Example");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel cPanel = new JPanel();
    cPanel.add( new JButton("Button 1") );
    cPanel.add( new JButton("Button 2") );
    cPanel.add( new JLabel("Buttons!!") );
    cPanel.setBackground(Color.green);

    JPanel sPanel = new JPanel();
    sPanel.add( new JLabel("This is the south"));
    sPanel.setBackground(Color.yellow);

    add(cPanel, BorderLayout.CENTER);
    add(sPanel, BorderLayout.SOUTH);

    pack();
    setVisible(true);
  }
  public static void main( String[] args ) {
    new LayoutExample();
  }
}
