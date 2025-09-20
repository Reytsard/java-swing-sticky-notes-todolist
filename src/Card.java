import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Card extends JPanel {
    final Point[] offset = {new Point()};
    Todo todo;

    public Card(Todo todo) {
        this.todo = todo;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(200,200);
        setBackground(Color.black);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                offset[0].x = e.getX();
                offset[0].y = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int newX = getX() + e.getX() - offset[0].x;
                int newY = getY() + e.getY() - offset[0].y;
                setLocation(newX, newY);
            }
        });
    }

}