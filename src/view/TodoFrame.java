package view;

import javax.swing.*;
import java.awt.*;

public class TodoFrame extends JFrame {

    private final JPanel panel;

    public TodoFrame(String title) {
        super(title);
        setSize(1600, 900);
        setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(this.getWidth(), this.getHeight());

        JButton addTodoButton = new JButton("Add model.Todo");
        addTodoButton.setBounds(this.getWidth() - 200, 10, 100, 50);
        addTodoButton.setFocusable(false);

        float columnWidth = (float) this.getWidth() / 3;

        JLabel todoLabel = new JLabel("model.Todo");
        todoLabel.setFont(new Font("Verdana",Font.BOLD,24));
        todoLabel.setBounds((int) (columnWidth - 50) / 2, 100, 100, 50);
        JLabel doingLabel = new JLabel("Working");
        doingLabel.setFont(new Font("Verdana",Font.BOLD,20));
        doingLabel.setBounds((int) (columnWidth + (columnWidth/2) - 50),100, 100, 50);
        JLabel doneLabel = new JLabel("Finished");
        doneLabel.setFont(new Font("Verdana",Font.BOLD,20));
        doneLabel.setBounds((int) (columnWidth + columnWidth + (columnWidth/2) - 50), 100, 100, 50);


        panel.add(addTodoButton);
        panel.add(todoLabel);
        panel.add(doingLabel);
        panel.add(doneLabel);

        add(panel);

        setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }
}
