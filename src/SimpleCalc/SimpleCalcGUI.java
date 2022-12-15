package SimpleCalc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalcGUI extends JFrame {
    private JPanel panel1;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JButton btnCompute;
    private JTextField tfNumber2;
    private JTextField lblResult;

    public SimpleCalcGUI() {
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compute();
            }
        });
    }
    public void compute() {
        int num1 = Integer.parseInt(tfNumber1.getText());
        int num2 = Integer.parseInt((tfNumber2.getText()));
        int result;
        String op = (String) cbOperations.getSelectedItem();

        switch(op) {
            case "+":
                result = num1 + num2;
                lblResult.setText(String.valueOf(result));
                break;
            case "-":
                result = num1 - num2;
                lblResult.setText(String.valueOf(result));
                break;
            case "/":
                result = num1 / num2;
                lblResult.setText(String.valueOf(result));
                break;
            case "*":
                result = num1 * num2;
                lblResult.setText(String.valueOf(result));
                break;
        }

    }
    public static void main(String[] args) {
        SimpleCalcGUI sc = new SimpleCalcGUI();
        sc.setContentPane(sc.panel1);
        sc.setTitle("Simple Calculator");
        sc.setSize(600, 200);
        sc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        sc.setVisible(true);
    }
}
