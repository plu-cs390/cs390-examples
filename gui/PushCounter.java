import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PushCounter extends JFrame {
  private JButton pushButton;
  private JLabel countLabel;
  private int pushCount;

  public PushCounter() {
    pushCount = 0;
    this.setTitle("Push Counter");
    this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
    this.setSize(300, 75);

    JPanel panel = new JPanel();
    pushButton = new JButton("Push Me!");
    countLabel = new JLabel("Pushes: 0");

    pushButton.addActionListener((e) -> updateCount());

    panel.add(countLabel);
    panel.add(pushButton);

    this.add(panel);
    this.setVisible(true);
  }

  private void updateCount() {
    pushCount ++;
    countLabel.setText( "Pushes: " + pushCount );
  }

  public static void main( String[] args ) {
    new PushCounter();
  }
}
