import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MathQuestion extends JFrame {

    private JLabel questionLabel;
    private JTextField answerField;
    private JLabel messageLabel;
    private int term1, term2;
    private Random rand;

    public MathQuestion() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Math Question");

        JPanel panel = new JPanel();
        questionLabel = new JLabel("0 + 0 = ");
        answerField = new JTextField(5);
        messageLabel = new JLabel("Type the answer and press enter");
        rand = new Random();

        panel.add(questionLabel);
        panel.add(answerField);

        JPanel southPanel = new JPanel();
        southPanel.add(messageLabel);
        southPanel.setPreferredSize(new Dimension(300, 45));

        this.generateQuestion();

        answerField.addActionListener( (e) -> checkAnswer() );

        this.add(panel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }

    public void generateQuestion() {
        term1 = rand.nextInt(12) + 1;
        term2 = rand.nextInt(12) + 1;
        questionLabel.setText( term1 + " + " + term2 + " = ");
    }

    private void checkAnswer() {
        String text = answerField.getText();
        int answer = Integer.parseInt(text);
        if( answer == term1 + term2 ) {
            messageLabel.setText("Correct!!  Here's another question.");
            generateQuestion();
        }
        else {
            messageLabel.setText("Incorrect, please try again.");
        }
    }

    public static void main( String[] args ) {
        new MathQuestion();
    }
}
