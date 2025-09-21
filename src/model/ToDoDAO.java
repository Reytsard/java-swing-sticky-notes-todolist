package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class ToDoDAO {
    ArrayList<Todo> todos = new ArrayList<>();
    DB db;
    public ToDoDAO() {
        try {
            db = new DB();
            todos = db.getAllTodo();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public boolean removeTodo(int id) {
        Todo todo = todos.stream().filter(item -> item.id == id).findAny().orElse(null);

        if (todo != null) {
            todos = (ArrayList<Todo>) todos.stream().filter(list -> list.getId() != id).toList();
            return true;
        }

        return false;
    }

    public ArrayList<Todo> getTodos() {
        return todos;
    }
}
