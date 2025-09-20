import java.sql.*;

public class DB {
    final String dbURL = "jdbc:sqlite:todo.db";
    Connection conn;

    public DB() throws SQLException {
        conn = DriverManager.getConnection(dbURL);
        initializeDB();
    }

    private void initializeDB() {
        if (conn != null) {
            String query = "Create table if not exists Todo (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "title TEXT NOT NULL," +
                    "description Text," +
                    "priority VARCHAR(6)," +
                    "status VARCHAR(10) NOT NULL" +
                    ");";

            try {
                Statement stmt = conn.createStatement();
                stmt.execute(query);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void insertTodo(Todo todo) throws SQLException {
        String query = "INSERT INTO TODO(title, description, priority, status) VALUES (?,?,?,?);";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, todo.getTodoTitle());
        ps.setString(2, todo.getTodoDesc());
        ps.setString(3, String.valueOf(todo.getPriority()));
        ps.setString(4, todo.getStatus());

        ps.execute();
    }

    public void updateTodo(Todo todo) throws SQLException {
        String query = "UPDATE TODO set status=? where id=?;";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, todo.getStatus());
        ps.setInt(2, todo.getId());

        ps.executeUpdate();
    }

    public void getAllTodo() throws SQLException {
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM Todo";
        ResultSet results = stmt.executeQuery(query);

        while (results.next()) {
            int id = results.getInt(1);
            String title = results.getString(2);
            String desc = results.getString(3);
            PRIORITY prio = PRIORITY.valueOf(results.getString(4));
            String status = results.getString(5);

            System.out.printf("%d, %s, %s, %s, %s\n", id, title, desc, prio, status);
        }
    }
}
