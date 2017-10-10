# Christopher Larson
# CSCI 238 Homework #6, Problem #2
# high_low_game.py
# 10/5/13
#
# This program determines if the users guess is the same as the random number

import random
MAX = 100
RAGE_QUIT = 0

def main():
    print('\nLets play the High-Low Game!')
    print('If at all during the game you want to quit, just enter 0')
    rand_num = random.randint(1, MAX)
    guess = int(input('Enter a random number between 1 and %d: ' % MAX))

    while guess != rand_num and guess != RAGE_QUIT:
        if guess < rand_num:
            print('Too Low')
        else:
            print('Too High')
        guess = int(input('Enter a random number between 1 and 100: '))

    if guess == rand_num:
        print('Correct! The answer was indeed %d!' % rand_num)
    else:
        print('You were so close! The answer was %d' % rand_num)


main()
