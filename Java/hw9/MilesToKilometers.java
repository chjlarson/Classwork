// Christopher Larson
// CSCI 239 Homework 9 Problem 3
// MilesToKilometers.java
// 3/25/14
//
// This program creates a GIU that converts miles, entered by the user,
// into kilometers.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MilesToKilometers extends JFrame
{
        public static final int WIDTH = 300;
        public static final int HEIGHT = 200;

        private JLabel instructions;
        private JTextField mileEntry;
        private JLabel result;
        private JLabel error;
        private JButton convertButton;
        private JPanel instructionPanel= new JPanel();
        private JPanel buttonPanel= new JPanel();
        private JPanel computePanel= new JPanel();
        private JPanel errorPanel= new JPanel();

    public static void main(String[] args)
    {
        MilesToKilometers win = new MilesToKilometers();
        win.setVisible(true);
    }

    public MilesToKilometers()
    {
        super("Miles To Kilometer Calculator");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        instructions = new JLabel("Enter a number of miles:");
        mileEntry = new JTextField(15);
        mileEntry.addActionListener(new ConvertListener());

        convertButton = new JButton("Convert");
        convertButton.addActionListener(new ConvertListener());

        result = new JLabel();
        error = new JLabel();
        error.setForeground(Color.RED);

        setLayout(new GridLayout(6,1));

        instructionPanel.add(instructions, BorderLayout.CENTER);
        buttonPanel.add(convertButton, BorderLayout.CENTER);
        computePanel.add(result);
        errorPanel.add(error);

        add(instructionPanel);
        add(mileEntry);
        add(buttonPanel);
        add(computePanel);
        add(errorPanel);
    }


    private class ConvertListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String textData = mileEntry.getText();
            double miles;
            double kilometers;
            mileEntry.setText("");

            try
            {
                miles = Double.parseDouble(textData.trim());
                kilometers = miles * 1.6093;
                result.setText("Kilometers = " + kilometers);
                error.setText("");
            }
            catch (NumberFormatException e)
            {
                result.setText("");
                error.setText("*** Invald input ***");
            }
        }
    }
}
