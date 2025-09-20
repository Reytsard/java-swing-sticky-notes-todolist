public class Todo {
    String todoTitle;
    String todoDesc;
    PRIORITY priority;
    int id;

    public Todo() {
        todoTitle = "";
        todoDesc = "";
        priority = PRIORITY.LOW;
        id = -1;
    }

    public Todo(String todoTitle, String todoDesc, PRIORITY priority) {

        this.todoTitle = todoTitle;
        this.todoDesc = todoDesc;
        this.priority = priority;
    }


    public String getTodoTitle() {
        return todoTitle;
    }

    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public String getTodoDesc() {
        return todoDesc;
    }

    public void setTodoDesc(String todoDesc) {
        this.todoDesc = todoDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
