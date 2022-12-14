package LeapYear;

import javax.swing.*;

public class LeapYearGUI extends JFrame {
    private JPanel panel1;
    private JTextField tfYear;
    private JButton btnCheckYear;



    public static void main(String[] args) {
        LeapYearGUI lp = new LeapYearGUI();
        lp.setContentPane(lp.panel1);
        lp.setSize(200, 200);
        lp.setDefaultCloseOperation(EXIT_ON_CLOSE);
        lp.setVisible(true);
    }
}

