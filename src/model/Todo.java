package model;

public class Todo {
    String todoTitle;
    String todoDesc;
    PRIORITY priority;
    String status;
    int id;
    static int todoCount = 0;


    public Todo() {
        todoTitle = "";
        todoDesc = "";
        priority = PRIORITY.LOW;
        id = todoCount++;
        status = "todo";
    }

    public Todo(String todoTitle, String todoDesc, PRIORITY priority) {
        id = todoCount++;
        this.todoTitle = todoTitle;
        this.todoDesc = todoDesc;
        this.priority = priority;
        status = "todo";
    }


    public PRIORITY getPriority() {
        return priority;
    }

    public void setPriority(PRIORITY priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
