# Christopher Larson    
# CSCI 238 Homework #13, Problem #1
# play_hangman.py
# 11/24/13
#
# This program simulates the game hangman.

import random
import hangman

MAX_WRONG_GUESSES = 7

def main():
    word_list = ['easter', 'program', 'receive', 'positive', 'study', \
        'computer', 'science', 'hangman', 'homework', 'queue',
        'stack', 'practice', 'example', 'quick']

    index = random.randint(0, len(word_list) - 1)
    game = hangman.Hangman(word_list[index], MAX_WRONG_GUESSES)

    print('\n*** Welcome to the Hangman Game ***')

    print('\nThis program will allow you to play the classic word guessing')
    print('game of hangman. You will be allowed a maximum of %d wrong guesses.' \
        % MAX_WRONG_GUESSES)
    print('Guessing the same wrong letter twice does not count against you.\n')

    while (not game.game_over()):
        print('\nThe current word is: %s' % game.get_guessed_word())
        letter = input('Choose a letter: ').lower()
        if (not game.guess(letter)):
            print('  Incorrect letters = %s' % game.get_missed_letters())

    if game.game_won():
        print('\nCongratulations!  You guessed the word %s.' \
            % game.get_word())
    else:
        print('\nYou lost! The correct word was %s.' % game.get_word())

main()
