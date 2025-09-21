package view;

import model.Todo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Card extends JPanel {
    final Point[] offset = {new Point()};
    Todo todo;
    JLabel title;
    JLabel description;

    public Card(Todo todo) {
        this.todo = todo;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(200, 200);
        setBackground(Color.PINK);
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

        title = new JLabel(todo.getTodoTitle());
        title.setSize(this.getWidth(), 50);
        description = new JLabel(todo.getTodoDesc());
        title.setSize(this.getWidth(), 150);

        add(title);
        add(description);

        switch (todo.getPriority()) {
            case LOW -> setBorder(BorderFactory.createLineBorder(Color.black, 2));
            case MID -> setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
            case HIGH -> setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        }
    }

}