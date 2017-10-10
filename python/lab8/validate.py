# Robert Pitts Chris Larson
# CSCI 238 Lab#8 Problem #1
# validate.py
# 9-26-13
#
# This program prints a valid output

def main():
    print('This program demonstrates the get_input function.\n')

    result = get_input()

    print('\nThe validated input was %.2f.' % result)

def get_input():
    num = float(input('Enter a number between 1 and 5: '))

    while num < 1 or num > 5:
        print('Error: Not between 1 and 5.')
        num = float(input('Enter a number between 1 and 5: '))
    return num

main()
