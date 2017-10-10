// Christopher Larson
// CSCI 239 Homework 12 Problem 1
// CardGameGUI.java
// 4/12/14
// 
// This program creates a GUI that allows the user to play a graphical card
// game.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardGameGUI extends JFrame
{
    public static final int WIDTH = 450;
    public static final int HEIGHT = 400;
    public static final int MAX_TURNS = 3;
    public static final int ACE_POINTS = 3;
    public static final int FACE_POINTS = 2;
    public static final int OTHER_POINTS = 1;


    private GraphicalDeck deck;
    private GraphicalCard card;
    private JPanel cardsPanel;
    private JPanel buttonPanel;
    private int numDeals;
    private int score;
    private JLabel scoreLabel;
    private JButton deal;

    public static void main(String[] args)
    {
        CardGameGUI window = new CardGameGUI();
        window.setVisible(true);
    }

    public CardGameGUI()
    {
        super("Card Game GUI");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        deck = new GraphicalDeck();
        cardsPanel = new JPanel();
        buttonPanel = new JPanel();
        JLabel instructions1;
        JLabel instructions2;
        JLabel instructions3;
        numDeals = 1;

        score = 0;
        scoreLabel = new JLabel();
        buttonPanel.add(scoreLabel);
        scoreLabel.setFont(new Font("SanSerf", Font.PLAIN, 22));

        instructions1 = new JLabel("In this game, the goal is to reach"
            + " the highest number possible.");

        deal = new JButton("Deal");
        buttonPanel.add(deal);
        deal.addActionListener(new DealListener());

        setLayout(new BorderLayout());
        add(instructions1, BorderLayout.NORTH);
        add(cardsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH); 

        DealHand();
    }

    private void DealHand()
    {
        boolean finished = false;
        for (int i = 0; i < 5; i++)
        {
            card = deck.deal();
            JLabel cardLabel = new JLabel();
            cardLabel.setIcon(card.getImage());
            cardsPanel.add(cardLabel);

            if (card.getSuit() == Card.SPADES && card.getFace() == Card.QUEEN)
            {
                finished = true;
                score = 0;
                deal.setEnabled(false);
            }

            if (card.isAce() && !finished)
            {
                score += ACE_POINTS;
            }
            else if (card.isFaceCard() && !finished)
            {
                score += FACE_POINTS;
            }  
            else if (!finished)
            {
                score += OTHER_POINTS;
            }  

            scoreLabel.setText("Your Score is: " + score);
        }
    }

    private class DealListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            numDeals++;
            if (numDeals >= MAX_TURNS)
            {
                deal.setEnabled(false);
            }
            
            DealHand();
        }
    }
}
