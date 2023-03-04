import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class DrawingExample extends JComponent {

    private List<Point2D.Double> circles;

    private int radius;

    private Color circleColor;

    public DrawingExample() {
        this.setPreferredSize(new Dimension(500, 500));
        circles = new ArrayList<>();
        radius = 20;
        circleColor = Color.orange;

        // Listen for mouse events
        this.addMouseListener(new DrawingExampleMouseListener());
        this.addMouseMotionListener(new DrawingExampleMouseMotionListener());
    }

    @Override
    public void paintComponent( Graphics g ) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(circleColor);
        for( Point2D.Double pt : circles ) {
            g2d.fillOval( (int)(pt.x - radius), (int)(pt.y - radius), 2*radius, 2*radius);
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Drawing Example");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add( new DrawingExample(), BorderLayout.CENTER );
        window.pack();
        window.setVisible(true);
    }

    private class DrawingExampleMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            Point2D.Double pt = new Point2D.Double(e.getX(), e.getY());
            circles.add(pt);

            // This generates another event, which eventually calls paintComponent
            DrawingExample.this.repaint();
        }
    }

    private class DrawingExampleMouseMotionListener extends MouseAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            Point2D.Double pt = new Point2D.Double(e.getX(), e.getY());
            circles.add(pt);

            // This generates another event, which eventually calls paintComponent
            DrawingExample.this.repaint();
        }
    }
}
