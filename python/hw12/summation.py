# Christopher Larson
# CSCI 238 Homework #12, Problem #5
# summation.py
# 11/17/13
#
# This program tests the summation function.

def main():
    print('This program tests the recursive summation function.\n')

    print('summation(1, 5) should be 15.')
    print('summation(1, 5) = %d\n' % summation(1, 5))

    print('summation(2, 10) should be 54.')
    print('summation(2, 10) = %d\n' % summation(2, 10))

    print('summation(3, 7) should be 25.')
    print('summation(3, 7) = %d\n' % summation(3, 7))

    print('summation(1, 1) should be 1.')
    print('summation(1, 1) = %d\n' % summation(1, 1))

    print('summation(5, 5) should be 5.')
    print('summation(5, 5) = %d\n' % summation(5, 5))

    print('summation(-3, 0) should be -6.')
    print('summation(-3, 0) = %d\n' % summation(-3, 0))

    print('summation(0, -1) should not lead to infinite recursion.')
    print('summation(0, -1) = %d\n' % summation(0, -1))

    print('summation(10, 1) should not lead to infinite recursion.')
    print('summation(10, 1) = %d\n' % summation(10, 1))

def summation(a, b):
    """Return the sum of the numbers between a nd b."""
    if a >= b:
        return a
    else:  
        return b + summation(a, b-1)
    
        
main()
