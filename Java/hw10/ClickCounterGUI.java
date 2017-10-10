// Christopher Larson
// CSCI 239 Homework 10 problem 3
// ClickCounterGUI.java
// 4/1/14
//
// This program creates a GUI that tracks how many times the mouse has been
// clicked.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClickCounterGUI extends JFrame
{
    public static final int WIDTH = 630;
    public static final int HEIGHT = 100;

    private JLabel counter;
    private int count = 0;

    public static void main(String[] args)
    {
        ClickCounterGUI win = new ClickCounterGUI();
        win.setVisible(true);
    }

    public ClickCounterGUI()
    {
        super("Click Counter");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addMouseListener(new MyMouseListener());
        
        counter = new JLabel("To get started counting the"
        + " number of times the mouse is clicked,"
        + " click the mouse inside the box.");
        
        setLayout(new FlowLayout());
        add(counter);
    }

    private class MyMouseListener extends MouseAdapter
    {
        public void mouseClicked(MouseEvent event)
        {
            count++;
            if (count == 1)
                counter.setText("The mouse was clicked " + count + " time.");
            else
                counter.setText("The mouse was clicked " + count + " times.");
        }
    }
}
