# Christopher Larson
# CSCI 238 Homework #12, Problem #6
# binary.py
# 11/18/13
#
# This program tests the binary_string function.

def main():
    print('This program tests the binary_string function.\n')

    print('The binary string for 0 should be 0.')
    print('The binary string for 0 is %s.' % binary_string(0))

    print('\nThe binary string for 1 should be 1.')
    print('The binary string for 1 is %s.' % binary_string(1))

    print('\nThe type returned from binary_string(0) should be:')
    print("<class 'str'>")
    print('The type returned from binary_string(0) is:')
    print(type(binary_string(0)))

    print('\nThe type returned from binary_string(1) should be:')
    print("<class 'str'>")
    print('The type returned from binary_string(1) is:')
    print(type(binary_string(1)))

    print('\nThe binary string for 5 should be 101.')
    print('The binary string for 5 is %s.' % binary_string(5))

    print('\nThe binary string for 6 should be 110.')
    print('The binary string for 6 is %s.' % binary_string(6))

    print('\nThe binary string for 10 should be 1010.')
    print('The binary string for 10 is %s.' % binary_string(10))

    print('\nThe binary string for 12 should be 1100.')
    print('The binary string for 12 is %s.' % binary_string(12))

    print('\nThe binary string for 15 should be 1111.')
    print('The binary string for 15 is %s.' % binary_string(15))

    print('\nThe binary string for 20 should be 10100.')
    print('The binary string for 20 is %s.' % binary_string(20))

    print('\nThe binary string for 32 should be 100000.')
    print('The binary string for 32 is %s.' % binary_string(32))

    print('\nThe binary string for 33 should be 100001.')
    print('The binary string for 33 is %s.' % binary_string(33))

    print('\nThe binary string for -1 should not be infinite recursion.')
    print('The binary string for -1 is %s.' % binary_string(-1))

def binary_string(n):
    """Return the binary representation of n."""
    if n <= 0:
        return '0'
    elif n == 1:
        return '1'
    else:
        return binary_string(n//2) + str(n%2)

main()
