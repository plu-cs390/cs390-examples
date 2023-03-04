import javax.swing.*;

public class FrameExample {
  public static void main( String[] args ) {
    JFrame frame = new JFrame("Hello GUI");
    frame.setSize(400,400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
