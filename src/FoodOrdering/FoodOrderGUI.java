package FoodOrdering;

import javax.swing.*;
import java.util.List;

public class FoodOrderGUI extends JFrame {
    private JPanel panel1;
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JButton btnOrder;
    List<JCheckBox> foods;
    List<JRadioButton> discounts;

    public static void main(String[] args) {
        FoodOrderGUI fo = new FoodOrderGUI();
        fo.setContentPane(fo.panel1);
        fo.setTitle("Food Ordering System");
        fo.setSize(600, 500);
        fo.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fo.setVisible(true);
    }

}
