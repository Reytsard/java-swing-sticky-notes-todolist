import javax.swing.*;
import java.awt.*;

public class TodoListFrame extends JFrame {
    public TodoListFrame(String title) throws HeadlessException {
        super(title);
        setLayout(null);
        setSize(600,500);
        setResizable(false);
    }
}
