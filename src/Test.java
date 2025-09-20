import javax.swing.*;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        DB database = null;
        try {
            database = new DB();
        } catch (SQLException e) {
            System.out.println("DB not initialized");
//            throw new RuntimeException(e);
        }

        JFrame frame = new JFrame();
        frame.setSize(1600, 900);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        Todo todo1 = new Todo();
        todo1.setTodoTitle("Create Database");
        todo1.setPriority(PRIORITY.HIGH);
        Card card1 = new Card(todo1);
        if (database != null) {
            try {
                database.insertTodo(todo1);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        JButton button = new JButton("Select all");
        button.setBounds(800, 100, 100, 50);
        button.setFocusable(false);
        DB finalDatabase = database;
        button.addActionListener((e) -> {
            if (finalDatabase != null) {
                try {
                    finalDatabase.getAllTodo();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        panel.add(card1);
        panel.add(button);

        frame.add(panel);
        frame.setVisible(true);
    }
}
