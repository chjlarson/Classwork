// Christopher Larson
// CSCI 239 Homework #5 Problem #2
// PalindromeTest.java
// 2/16/14
//
// This program tests the isPalindrome method.

public class PalindromeTest
{
    public static void main(String[] args)
    {
        char[] sequence1 = {'R', 'a', 'd', 'a', 'R'};
        char[] sequence2 = {'A', 'B', 'B', 'A', 'a', 'B', 'B', 'A'};
        char[] sequence3 = {'M', 'a', 'd', 'a', 'm', 'I', 
            'm', 'a', 'd', 'a', 'M'};
        char[] sequence4 = {'M', 'a', 'd', 'a', 'm', 'I', 
            'M', 'a', 'd', 'a', 'M'};
        char[] sequence5 = {'F', 'E', 'W', 'E', 'R'};

        System.out.println("This program tests the isPalindrome method.\n");

        if (isPalindrome(sequence1))
            System.out.println("CORRECT: RadaR is a palindrome.\n");
        else
            System.out.println("ERROR: RadaR should be a palindrome.\n");

        if (!isPalindrome(sequence2))
            System.out.println("CORRECT: ABBAaBBA is NOT a palindrome.\n");
        else
            System.out.println("ERROR: ABBAaBBA should not be a palindrome.\n");

        if (isPalindrome(sequence3))
            System.out.println("CORRECT: MadamImadaM is a palindrome.\n");
        else
            System.out.println("ERROR: MadamImadaM should be a palindrome.\n");

        if (!isPalindrome(sequence4))
            System.out.println("CORRECT: MadamIMadaM is NOT a palindrome.\n");
        else
            System.out.println("ERROR: MadamIMadaM "
                + "should not be a palindrome.\n");

        if (!isPalindrome(sequence5))
            System.out.println("CORRECT: FEWER is NOT a palindrome.\n");
        else
            System.out.println("ERROR: FEWER "
                + "should not be a palindrome.\n");
    }

    public static boolean isPalindrome(char[] character)
    {
        char[] ch = character;
        boolean flag = true;

        for (int i = 0; i < ch.length/2; i++)
        {
            if (ch[i] != ch[ch.length - 1 - i])
                return false;
        }
        return flag;
    }
}
