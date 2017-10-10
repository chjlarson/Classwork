// Christopher Larson
// CSCI 337 Homework #13 Problem #13
// Queens.java
// 11/23/14
//
// This program displays where or not n amount of queens on an n x n board is
// possible.

import java.util.Scanner;

public class Queens
{
    public static final int OPEN = 0;
    public static final int QUEEN = 1;
    public static final int DEFAULT_SIZE = 8;    // default size of board
    
    private int[][] board;
    private int numQueens;    
    
    public static void main(String[] args)
    {
        int n;        // size of chessboard (n x n)
        
        System.out.println("This program solves the Nonattacking Queens "
            + "Problem.");
        System.out.println();
        System.out.println("In solving this problem, I will create an n x n "
            + "chessboard and attempt");
        System.out.println("to place n queens on the board so that no queen "
            + "can attack another.");
        System.out.println();
        System.out.print("Please enter the number n (n >= 4): ");
        
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        
        while (n < 4)        // error check the input
        {
            System.out.println("Sorry, the problem cannot be solved for n < 4.");
            System.out.print("\nPlease enter the number n (n >= 4): ");
            n = scan.nextInt();
        }
        
        Queens q = new Queens(n);
        if (q.solve(0))        // try to solve, beginning with row 0
        {
            System.out.println("Found a solution:\n");
            System.out.println(q);
            System.out.println("In the above solution, " + QUEEN 
                + " represents the placement " + "of a queen.");
        }
        else
            System.out.println("Did not find a solution");
    }
    
    public Queens()    
    {
        numQueens = DEFAULT_SIZE;
        board = new int[DEFAULT_SIZE][DEFAULT_SIZE];
        // by default, the array is initialized to all OPEN (i.e., 0)
    }
    
    public Queens(int n)    
    {
        numQueens = n;
        board = new int[n][n];
        // by default, the array is initialized to all OPEN (i.e., 0)
    }
    
    // Recursive method to solve the nonattacking queens problem 
    // starting with row
    public boolean solve(int row)
    {
        int col;
        boolean done = false;

        // *** Your code goes HERE ***
        // Could not stop infinate recursion 
        if (row  >= board.length)
            return true;

        for (col = 0; col < board.length; col++)
        {
            if (isValid(row, col))
            {
                board[row][col] = QUEEN;
                if (solve(row++))
                    done = true;
                else
                board[row][col] = OPEN;
            }
        }
        return done;
    }

    public String toString()
    {
        int i; 
        int j;
        String result = "";
        for (i = 0; i < numQueens; i++)
        {
            for (j = 0; j < numQueens; j++)
                result += board[i][j] + "    ";
            result += "\n";
        }    
        return result;
    }

     // Check to see if queens in rows below can attack this location
    private boolean isValid(int row, int col)
    {
        int i; 
        int j;
        boolean valid = true;
        
        // First, check this column (stop as soon as valid becomes false)
        for (i = 0; i < row && valid; i++)
            if (board[i][col] == QUEEN)
                valid = false;
        
        // Check diagonals below this row     
        // (stop as soon as valid becomes false)

        for (i = row-1, j = 1; i >= 0 && valid; i--, j++)
        {
            if (col - j >= 0 && board[i][col-j] == QUEEN)
                    valid = false;
            if (col + j < numQueens && board[i][col+j] == QUEEN)
                    valid = false;
        }
        
        return valid;
    }
}
