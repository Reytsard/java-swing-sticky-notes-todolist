package view;

import javax.swing.*;

public class FieldsPanel extends JPanel {

    private JLabel titleLabel;
    private JTextField title;
    private JLabel descLabel;
    private JTextArea desc;
    private JLabel priorityLabel;
    private JComboBox<String> prioField;
    private final String[] choices = {"Low", "Medium", "High"};
    private JButton addButton;
    private JButton cancelButton;

    public FieldsPanel(){
        titleLabel = new JLabel("Title:");
        title = new JTextField();
        descLabel = new JLabel("Description:");
        desc = new JTextArea(10,20);
        priorityLabel = new JLabel("Priority:");
        prioField = new JComboBox<>(choices);
        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(400,500);

        add(titleLabel);
        add(title);
        add(descLabel);
        add(desc);
        add(priorityLabel);
        add(prioField);
    }

    public static void main(String[] args) {
        JFrame test = new JFrame();
        test.setSize(400,500);

        FieldsPanel fp = new FieldsPanel();
        test.add(fp);

        test.setVisible(true);
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JTextField getTitle() {
        return title;
    }

    public void setTitle(JTextField title) {
        this.title = title;
    }

    public JLabel getDescLabel() {
        return descLabel;
    }

    public void setDescLabel(JLabel descLabel) {
        this.descLabel = descLabel;
    }

    public JTextArea getDesc() {
        return desc;
    }

    public void setDesc(JTextArea desc) {
        this.desc = desc;
    }

    public JLabel getPriorityLabel() {
        return priorityLabel;
    }

    public void setPriorityLabel(JLabel priorityLabel) {
        this.priorityLabel = priorityLabel;
    }

    public JComboBox<String> getPrioField() {
        return prioField;
    }

    public void setPrioField(JComboBox<String> prioField) {
        this.prioField = prioField;
    }

    public String[] getChoices() {
        return choices;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }
}
