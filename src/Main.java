import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    Connection conn;
    ToDoDAO toDoDAO;

    public static void main(String[] args) {
        Main program;
        try {
            program = new Main();
            program.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void run() throws Exception {

        toDoDAO = new ToDoDAO();
//        try{
//            conn = DriverManager.getConnection("jdbc:sqlite:todo.db");
//            initDatabase();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        TodoListFrame applicationFrame = new TodoListFrame("Todo List");

        JPanel applicationPanel = new JPanel();
        applicationPanel.setLayout(null);
        applicationPanel.setBounds(0, 0, applicationFrame.getWidth(), applicationFrame.getHeight());
        applicationFrame.add(applicationPanel);
        applicationPanel.setBackground(Color.BLACK);

        JButton addToDoButton = new JButton("Add Todo");
        addToDoButton.setBounds(450, 30, 100, 40);
        addToDoButton.setBackground(Color.white);
        addToDoButton.setFocusable(false);
        addToDoButton.addActionListener(new AddToDoButtonActionListener(applicationPanel));

        applicationPanel.add(addToDoButton);
        applicationFrame.setVisible(true);
    }

    private void initDatabase() throws SQLException {
        if (conn != null) {
            String statement = "CREATE TABLE IF NOT EXISTS Todo (\n" +
                    "    TodoId INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "    title VARCHAR(50) NOT NULL UNIQUE,\n" +
                    "    desc VARCHAR(254) NOT NULL ,\n" +
                    "    priority VARCHAR(100) NOT NULL\n" +
                    ");";

            PreparedStatement ps = conn.prepareStatement(statement);
            ps.execute();
        }
    }

    class AddToDoButtonActionListener implements ActionListener {

        JPanel applicationPanel;

        public AddToDoButtonActionListener(JPanel applicationPanel) {
            this.applicationPanel = applicationPanel;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame fieldsFrame = new JFrame("Add TodoList");
            fieldsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            fieldsFrame.setSize(300, 400);
            JPanel fieldsPanel = new JPanel();
            fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.Y_AXIS));

            JLabel titleLabel = new JLabel("Title:");
            JTextField titleField = new JTextField();

            JLabel descLabel = new JLabel("Description:");
            JTextField descField = new JTextField();

            JLabel prioLabel = new JLabel("Priority:");
            JComboBox<PRIORITY> prioBox = new JComboBox<>(PRIORITY.values());

            JButton addToListButton = new JButton("Add to list");
            addToListButton.setFocusable(false);
            addToListButton.addActionListener((addToListButtonEvent) -> {
                String title = titleField.getText();
                String desc = descField.getText();
                PRIORITY priority = (PRIORITY) prioBox.getSelectedItem();

                System.out.println(title);
                System.out.println(desc);
                System.out.println(String.valueOf(priority));

                Todo newTodo = new Todo(title,desc,priority);
                toDoDAO.addTodo(newTodo);


//                try {
//                    PreparedStatement ps = conn.prepareStatement("insert into todo values (?,?,?);");
//                    ps.setString(1, title);
//                    ps.setString(2, desc);
//                    ps.setString(3, String.valueOf(priority));
//                    ps.execute();
//
                fieldsFrame.dispose();
//                    try{
//                        String query = "Select 1=1;";
//                        PreparedStatement ps = conn.prepareStatement(query);
//                        ResultSet result =  ps.executeQuery();
//                    } catch (Exception ex) {
//                        throw new RuntimeException(ex);
//                    }
//
                    JPanel newTodoPanel = new JPanel();
                    newTodoPanel.setLayout(null);
                    newTodoPanel.setSize(100, 200);
                    newTodoPanel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            super.mousePressed(e);
                        }
                    });


//
//                    applicationPanel.add(newTodo);
//                    applicationPanel.revalidate();
//                    applicationPanel.repaint();
//                } catch (SQLException ex) {
//                    throw new RuntimeException(ex);
//                }
            });

            JButton cancelButton = new JButton("Cancel");
            cancelButton.setFocusable(false);

            fieldsPanel.add(titleLabel);
            fieldsPanel.add(titleField);
            fieldsPanel.add(descLabel);
            fieldsPanel.add(descField);
            fieldsPanel.add(prioLabel);
            fieldsPanel.add(prioBox);
            fieldsPanel.add(addToListButton);
            fieldsPanel.add(cancelButton);


            fieldsFrame.add(fieldsPanel);
            fieldsFrame.setVisible(true);
        }
    }


}
