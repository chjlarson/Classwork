// Christopher Larson
// CSCI 239 Homework 10 Problem 2
// BirthdayGUI.java
// 4/1/14
//
// This program creates a gui that uses a combo box to allow the user to input
// their birthday and displays their birthday.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BirthdayGUI extends JFrame
{
    public static final int WIDTH = 250;
    public static final int HEIGHT = 150;

    private JComboBox monthChooser;
    private JComboBox dayChooser;
    private String month = "January";
    private int day = 1;
    private JLabel birthday;

    private String[] months = {"January", "Febuary", "March", "April", "May",
        "June", "July", "August", "September", "October",
        "November", "December"};

    public static void main(String[] args)
    {
        BirthdayGUI win = new BirthdayGUI();
        win.setVisible(true);
    }

    public BirthdayGUI()
    {
        super("Birthday Box");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        monthChooser = new JComboBox(months);
        monthChooser.setBackground(Color.WHITE);
        monthChooser.addActionListener(new MonthListener());
        
        Object[] days = new Object[31];
        for (int j = 0; j < days.length; j++)
        {
            days[j] = j + 1;
        }
        dayChooser = new JComboBox(days);
        dayChooser.setBackground(Color.WHITE);
        dayChooser.setSelectedItem(days[0]);
        dayChooser.addActionListener(new DayListener());

        birthday = new JLabel("Your Birthday is " + month + " " + day);

        setLayout(new FlowLayout());
        add(monthChooser);
        add(dayChooser);
        add(birthday);
    }

    public class MonthListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            month = (String)monthChooser.getSelectedItem();
            birthday.setText("Your birthday is " 
            + month + " " + day);
        }
    }
    
    public class DayListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            day = dayChooser.getSelectedIndex() + 1;
            birthday.setText("Your birthday is " 
            + month + " " + day);
        }
    }
}
