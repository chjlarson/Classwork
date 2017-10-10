// Christopher Larson
// CSCI 239 Homework 11 Problem 5
// CircleAnimation.java
// 4/6/14
//
// This program creates a gui that fills a window woth circles at the users
// control.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CircleAnimation extends JFrame
{
    public static final int WIDTH = 320;
    public static final int LENGTH = 300;
    public static final int PANEL_WIDTH = 300;
    public static final int PANEL_HEIGHT = 200;

    private JPanel drawingPanel;
    private DrawCircles drawingObject;
    private Graphics g;
    private Thread animationThread;

    public static void main(String[] args)
    {
        CircleAnimation myFrame = new CircleAnimation();
        myFrame.setVisible(true);
    }

    public CircleAnimation()
    {
        super("Circle Animation");
        setSize(WIDTH, LENGTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        g = null;  // cannot be set until visible
        animationThread = null;

        JButton start = new JButton("Start");
        start.addActionListener(new StartListener());
        JButton pause = new JButton("Pause");
        pause.addActionListener(new PauseListener());
        JButton resume = new JButton("Resume");
        resume.addActionListener(new ResumeListener());
        JButton stop = new JButton("Stop");
        stop.addActionListener(new StopListener());
        
        drawingPanel = new JPanel();
        drawingPanel.setPreferredSize(
            new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        JPanel buttonPanel = new JPanel(new FlowLayout());
        drawingObject = new DrawCircles();

        buttonPanel.add(start);
        buttonPanel.add(pause);
        buttonPanel.add(resume);
        buttonPanel.add(stop);

        add(drawingPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private class DrawCircles implements Runnable
    {
        public static final int CIRCLE_SIZE = 10;

        private boolean isPaused;

        public DrawCircles()
        {
            isPaused = false;
        }

        public synchronized void run()
        {
            int i;
            int j;

            isPaused = false;
            
            try
            {
                for (j = 0; j < PANEL_HEIGHT; j += CIRCLE_SIZE)
                    for (i = 0; i < PANEL_WIDTH; i += CIRCLE_SIZE)
                    {
                        while (isPaused)
                        {
                            wait();
                        }

                        g.fillOval(i, j, CIRCLE_SIZE, CIRCLE_SIZE);
                        Thread.sleep(200);
                    }
            }
            catch (InterruptedException e)
            {
                
            }
        }

        public void pause()
        {
            isPaused = true;
        }

        public synchronized void resume()
        {
            isPaused = false;
            notifyAll();
        }
    }
    
    private class StartListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (g == null)
                 g = drawingPanel.getGraphics();

            // Clear the previous work by drawing a large white
            // rectangle, then change the color to red so that the
            // circles will show up
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
            g.setColor(Color.RED);

            // Stop any previous thread before starting a new one
            if (animationThread != null)
                animationThread.interrupt();

            animationThread = new Thread(drawingObject);
            animationThread.start();
        }
    }

    private class PauseListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            drawingObject.pause();
        }
    }

    private class ResumeListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            drawingObject.resume();
        }
    }

    private class StopListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            animationThread.interrupt();    
        }
    }
}
