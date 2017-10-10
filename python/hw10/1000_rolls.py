# Christopher Larson
# CSCI 238 Homework #10, PRoblem #2
# 1000_rolls.[y
# 11/03/13
#
# This program will roll 2 die objects 1000 times and count how any times a sum
# of 2, 3, or 12 is rolled.

import dice

NUM_ROLLS = 1000

def main():
    print('This program rolls a pair of dice repeatedly %d times'\
        % NUM_ROLLS)

    total_rolls = 0
    for num in range(1000):
        die1 = dice.Die()
        die2 = dice.Die()
        die1.roll
        die2.roll
        sum = int(die1) + int(die2)

        if sum == 2 or sum == 3 or sum == 12:
            total_rolls += 1

    print('Total number of rolls that equal 2, 3, or 12 within the %d rolls: %d'\
        % (NUM_ROLLS, total_rolls))

main()
