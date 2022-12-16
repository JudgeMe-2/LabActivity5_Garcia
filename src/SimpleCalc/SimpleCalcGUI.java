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
        String s1 = tfNumber1.getText();
        String s2 = tfNumber2.getText();
        System.out.println(s1);
        System.out.println(s2);
        try {
            if(s1.isBlank() || s2.isBlank()) {
                throw new NullPointerException("No inputs");
            }
            int num1 = Integer.parseInt(tfNumber1.getText());
            int num2 = Integer.parseInt((tfNumber2.getText()));

            //int result;
            long result;
            String op = (String) cbOperations.getSelectedItem();
            switch (op) {
                case "+":
                    result = (long)num1 + num2;
                    lblResult.setText(String.valueOf(result));
                    break;
                case "-":
                    result = (long)num1 - num2;
                    lblResult.setText(String.valueOf(result));
                    break;
                case "/":
                    result = (long)num1 / num2;
                    lblResult.setText(String.valueOf(result));
                    break;
                case "*":
                    result = (long) num1 * num2;
                    lblResult.setText(String.valueOf(result));
                    break;
            }
        } catch (NullPointerException e) {
            if(s1.isBlank()) {
                if(s2.isBlank()) {
                    JOptionPane.showMessageDialog(panel1, "All inputs must be filled");
                    lblResult.setText("");
                } else {
                    JOptionPane.showMessageDialog(panel1, "First input must be filled");
                    lblResult.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(panel1, "Second input must be filled");
                lblResult.setText("");
            }
        } catch(ArithmeticException e) {
            JOptionPane.showMessageDialog(panel1, "2nd Number or denominator must be nonzero");
            lblResult.setText("");
            tfNumber2.setText("");
        } catch(NumberFormatException e) {
            if(stringNumberChecker(tfNumber1.getText())) {
                if(stringNumberChecker(tfNumber2.getText())) {
                    JOptionPane.showMessageDialog(panel1, "All inputs must be a whole number");
                    lblResult.setText("");
                    tfNumber1.setText("");
                    tfNumber2.setText("");
                } else {
                    JOptionPane.showMessageDialog(panel1, "First input must be a whole number");
                    lblResult.setText("");
                    tfNumber1.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(panel1, "Second input must be a whole number");
                lblResult.setText("");
                tfNumber2.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panel1, "Error");
        }
    }
    public boolean stringNumberChecker(String str) {
        for(int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
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
