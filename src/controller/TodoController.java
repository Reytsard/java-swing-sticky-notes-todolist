package controller;

import model.DB;
import model.ToDoDAO;
import model.Todo;
import view.TodoFrame;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class TodoController {
    TodoFrame todoFrame;
    ToDoDAO toDoDAO;

    public TodoController() {
        todoFrame = new TodoFrame("Todo");
        toDoDAO = new ToDoDAO();
        todoFrame.addCards(toDoDAO.getTodos());
    }
}
