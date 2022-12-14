package FoodOrdering;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    ButtonGroup bg;

    public FoodOrderGUI() {
        bg = new ButtonGroup();
        bg.add(rbNone);
        bg.add(rb5);
        bg.add(rb10);
        bg.add(rb15);
        foods = new ArrayList<>();
        foods.add(cPizza);
        foods.add(cBurger);
        foods.add(cFries);
        foods.add(cSoftDrinks);
        foods.add(cTea);
        foods.add(cSundae);
        discounts = new ArrayList<>();
        discounts.add(rbNone);
        discounts.add(rb5);
        discounts.add(rb10);
        discounts.add(rb15);
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                order_price();
            }
        });
    }
    public void order_price() {
        double total = 0;
        int[] price = {100, 80, 65, 55, 50, 40};
        double[] less = {0, .05, .10, .15};
        int flag1 = 0, flag2 = 0;
        for(int i = 0; i < price.length; i++) {
            if(foods.get(i).isSelected()) {
                total += price[i];
                flag1++;
            }
        }
        for(int i = 0; i < less.length; i++) {
            if(discounts.get(i).isSelected()) {
                total -= total * less[i];
                flag2++;
                break;
            }
        }
        try {
            if(flag1 == 0 || flag2 == 0) {
                throw new Exception("No selected inputs");
            }
        }catch(Exception e) {
            if(flag1 == 0) {
                if(flag2 == 0) {
                    JOptionPane.showMessageDialog(panel1, "No selected inputs");
                } else {
                    JOptionPane.showMessageDialog(panel1, "No selected Foods");
                }
            } else {
                JOptionPane.showMessageDialog(panel1, "No selected discount");
            }
            return;
        }
        JOptionPane.showMessageDialog(panel1, "The total price is Php " + String.format("%.2f", total));
        clearFoodSelection();
        clearDiscountSelection();


    }
    public void clearFoodSelection() {
        for(JCheckBox cb : foods) {
            if(cb.isSelected()) {
                cb.setSelected(false);
            }
        }
    }
    public void clearDiscountSelection() {
        bg.clearSelection();
    }
    public static void main(String[] args) {
        FoodOrderGUI fo = new FoodOrderGUI();
        fo.setContentPane(fo.panel1);
        fo.setTitle("Food Ordering System");
        fo.setSize(600, 500);
        fo.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fo.setVisible(true);
    }

}
