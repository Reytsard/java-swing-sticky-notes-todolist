import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1600,900);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        Todo todo1 = new Todo();
        Card card1 = new Card(todo1);

        Todo todo2 = new Todo();
        Card card2 = new Card(todo2);

        Todo todo3 = new Todo();
        Card card3 = new Card(todo3);

        panel.add(card1);
        panel.add(card2);
        panel.add(card3);

        frame.add(panel);
        frame.setVisible(true);
    }
}
