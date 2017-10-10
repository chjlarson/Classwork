# Christopher Larson & Robert Pitts
# CSCI 238 Lab#10, Problem #1
# rolling_dice.py
# 10/3/13
#
# This program rolls two dice a number of times and determines hiw many times
# a number the user inputs is rolled.

import dice
NUM_ROLLS = 1000

def main():
    print('This program rolls two dice %d times and' %NUM_ROLLS)
    print('determines the number of times a certain number occurs.\n')

    number = int(input('Enter a number from 2 to 12: '))
    while number > 12 or number < 2:
        print('Error, number must be between 2 and 12')
        number = int(input('Enter a number from 2 to 12: '))
    
    count = 0
    for i in range(NUM_ROLLS):
        die1, die2 = dice.roll_dice()
        if die1 + die2 == number:
            count += 1
    print('Out of %d rolls, %d occurs %d times.' % (NUM_ROLLS, number, count))

main()
