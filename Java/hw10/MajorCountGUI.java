// Christopher Larson
// CSCI 239 Homework #10 Problem #1
// MajorCountGIU.java
// 3/29/14
//
// This program creats a GUI of possible choices of majors a student may pick
// and keeps a running tally for each major.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MajorCountGUI extends JFrame
{
    public static final int WIDTH = 650;
    public static final int HEIGHT = 150;

    public ButtonGroup majorGroup = new ButtonGroup();
    public JRadioButton compSci = new JRadioButton("Computer Science");
    public JRadioButton infoSys = new JRadioButton("Information Systems");
    public JRadioButton math = new JRadioButton("Mathematics");
    public JRadioButton other = new JRadioButton("None of these");

    private static int compSciCount = 0;
    private static int infoSysCount = 0;
    private static int mathCount = 0;
    private static int otherCount = 0;
    private static JLabel error;

    public static void main(String[] args)
    {
        MajorCountGUI majors = new MajorCountGUI();
        majors.setVisible(true);
    }

    public MajorCountGUI()
    {
        super("Academic Major Counter");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel question = new JLabel("What is your main Academic Major?");

        JButton submit = new JButton("Submit");
        submit.addActionListener(new submitButtonListener());

        JPanel majorPanel = new JPanel();
        majorGroup.add(compSci);
        majorGroup.add(infoSys);
        majorGroup.add(math);
        majorGroup.add(other);
        majorPanel.add(compSci);
        majorPanel.add(infoSys);
        majorPanel.add(math);
        majorPanel.add(other);

        error = new JLabel("");
        error.setForeground(Color.RED);

        setLayout(new FlowLayout());
        add(question);
        add (majorPanel);
        add(submit);
        add(error);
    }

    private class submitButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            error.setText("");

            if (compSci.isSelected())
                compSciCount++; 
            else if (infoSys.isSelected())
                infoSysCount++; 
            else if (math.isSelected())
                mathCount++; 
            else if (other.isSelected())
                otherCount++; 
            else
                error.setText("***Please choose one***");

            majorGroup.clearSelection();
            System.out.println("Computer Science: " + compSciCount 
                + ", Information Systems: " + infoSysCount 
                + ", Mathematics: " + mathCount + ", None of these: " 
                + otherCount);
        }
    }
}
