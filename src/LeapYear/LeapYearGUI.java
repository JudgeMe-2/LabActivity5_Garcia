package LeapYear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        int year = Integer.parseInt(tfYear.getText());
        if (year % 4 == 0) {
            // if the year is century
            if (year % 100 == 0) {
                // if year is divided by 400
                // then it is a leap year
                if (year % 400 == 0)
                    JOptionPane.showMessageDialog(panel1, "Leap year");
                else
                    JOptionPane.showMessageDialog(panel1, "Not a leap year");
            }

            // if the year is not century
            else
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

