package LeapYear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class LeapYearGUI extends JFrame {
    private JPanel panel1;
    private JTextField tfYear;
    private JButton btnCheckYear;



    public LeapYearGUI() {
        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leapYearChecker();
            }
        });
    }

    public void leapYearChecker() {
        long year = 0;
        System.out.println(Math.addExact(year, 0));
        try {
            year = Long.parseLong(tfYear.getText());
            if(year <= 0) {
                throw new Exception("Not a Year");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(panel1, "Input must be a number");
            return;
        } catch(Exception e) {
            JOptionPane.showMessageDialog(panel1, "Input must be a year(nonnegative and nonzero)");
            return;
        }
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0)
                    JOptionPane.showMessageDialog(panel1, "Leap year");
                else
                    JOptionPane.showMessageDialog(panel1, "Not a leap year");
            } else
                JOptionPane.showMessageDialog(panel1, "Leap year");
        } else {
            JOptionPane.showMessageDialog(panel1, "Not a leap year");
        }
    }
    public static void main(String[] args) {
        LeapYearGUI lp = new LeapYearGUI();
        lp.setContentPane(lp.panel1);
        lp.setTitle("Leap Year Checker");
        lp.setSize(500, 300);
        lp.setDefaultCloseOperation(EXIT_ON_CLOSE);
        lp.setVisible(true);
    }
}

