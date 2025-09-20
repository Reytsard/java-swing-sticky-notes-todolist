import java.util.ArrayList;

public class ToDoDAO {
    ArrayList<Todo> todos;

    public ToDoDAO() {
        todos = new ArrayList<>();

//        initializeTodos
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
}
