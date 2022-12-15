package SimpleCalc;

import javax.swing.*;

public class SimpleCalcGUI extends JFrame {
    private JPanel panel1;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JButton btnCompute;
    private JTextField tfNumber2;
    private JTextField lblResult;

    public static void main(String[] args) {
        SimpleCalcGUI sc = new SimpleCalcGUI();
        sc.setContentPane(sc.panel1);
        sc.setTitle("Simple Calculator");
        sc.setSize(600, 200);
        sc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        sc.setVisible(true);
    }
}
