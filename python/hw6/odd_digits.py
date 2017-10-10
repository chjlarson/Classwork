# Christopher Larson
# CSCI 238 Homework #6, Problem #3 
# odd_digits.py
# 10/6/13
#
# This program will test function all_digits_odd

def main():
    print('This program tests the all_digits_odd function.\n')
    
    if all_digits_odd(7):
        print('Correct: The digits in 7 are all odd')
    else:
        print('ERROR: The digits in 7 are all odd, ' \
            + 'but the function returned False')

    if all_digits_odd(13957):
        print('Correct: The digits in 13957 are all odd')
    else:
        print('ERROR: The digits in 13957 are all odd, ' \
            + 'but the function returned False')

    if not all_digits_odd(7136):
        print('Correct: One digit in 7136 is not odd.')
    else:
        print('ERROR: One digit in 7136 is not odd, but ' \
            + 'the function returned True.')

    if not all_digits_odd(69513):
        print('Correct: One digit in 69513 is not odd.')
    else:
        print('ERROR: One digit in 69513 is not odd, but ' \
            + 'the function returned True.')

    if not all_digits_odd(2468):
        print('Correct: The digits in 2468 are not odd.')
    else:
        print('ERROR: The digits in 2468 are not odd, but ' \
            + 'the function returned True.')

def all_digits_odd(num):
    """Return True if all numbers with in integer are odd."""
    odd = True
    while num > 0:
        if num % 2 == 0:
            odd = False
        num //= 10
    return odd

main()
