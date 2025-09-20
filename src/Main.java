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
        new TodoFrame("Todo List");
    }
}
