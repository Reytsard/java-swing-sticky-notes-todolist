import controller.TodoController;
import view.TodoFrame;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

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
        new TodoController();
    }
}
