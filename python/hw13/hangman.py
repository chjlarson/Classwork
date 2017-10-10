# Christopher Larson
# CSCI 238 Homework #13, Problem #1
# hangman.py
# 11/24/13
#
# This program simulates the game hangman and tests the modules.

class Hangman:

    def __init__(self, word, max_misses):
        """Initialize object using word and max_misses."""
        self.__word = word.upper().strip()
        self.__guessed_word = len(self.__word) * ['_']
        self.__max_misses = max_misses
        self.__num_misses = 0
        self.__missed_letters = ''

    def get_max_misses(self):
        """Return maximum number of misses."""
        return self.__max_misses

    def get_num_misses(self):
        """Return current number of misses."""
        return self.__num_misses

    def get_missed_letters(self):
        """Return string of missed letters."""
        return self.__missed_letters

    def get_word(self):
        """Return word."""
        return self.__word

    def guess(self, letter):
        """Return whether the guess was correct or not."""
        cap_letter = letter.upper()
        if cap_letter in self.__word:
            for n in range(len(self.__word)):
                if cap_letter == self.__word[n]:
                    self.__guessed_word[n] = cap_letter
            return True

        elif cap_letter in self.get_missed_letters():
            return False

        else:
            self.__missed_letters += cap_letter
            self.__num_misses +=1
            return False

    def get_guessed_word(self):
        """Return the combined guessed_word list."""
        return ''.join(self.__guessed_word)
        
    def game_over(self):
        """Return whether or not the game is over."""
        return self.get_guessed_word() == self.__word or \
                self.__num_misses >= self.__max_misses

    def game_won(self):
        """Return whether or not the word has been correctly guessed."""
        return self.get_guessed_word() == self.__word
        

    def __str__(self):
        """Return string version of the word and its data."""
        return ('Word "%s", Guessed "%s", num misses %d, max misses %d, ' \
            + 'missed letters %s') % (self.__word, self.get_guessed_word(), \
            self.__num_misses, self.__max_misses, self.__missed_letters)

# Test program for Hangman class
def main():
    print('This program provides basic testing of the Hangman class.\n')

    print('Creating a Hangman object for "goodbye" with maximum 3 wrong ' \
        + 'guesses.')
    hangman = Hangman('goodbye', 3)
    print('\nThe complete data is:')
    print(hangman)

    if hangman.guess('o'):
        print('Correct: o is in the word')
    else:
        print('ERROR: o should be in the word')
    if hangman.get_guessed_word() == '_OO____':
        print('Correct: current guessed word is _OO____')
    else:
        print('ERROR: current guessed word should be _OO____')
        print('       but instead is %s' % hangman.get_guessed_word())
    if hangman.get_num_misses() == 0:
        print('Correct: currently 0 misses')
    else:
        print('ERROR: currently %d misses' % hangman.get_num_misses())

    if hangman.guess('t'):
        print('\nERROR: t should not be in the word')
    else:
        print('\nCorrect: t is not in the word')
    if hangman.get_guessed_word() == '_OO____':
        print('Correct: current guessed word is _OO____')
    else:
        print('ERROR: current guessed word should be _OO____')
        print('       but instead is %s' % hangman.get_guessed_word())
    if hangman.get_num_misses() == 1:
        print('Correct: currently 1 miss')
    else:
        print('ERROR: currently %d misses' % hangman.get_num_misses())
    if hangman.get_missed_letters() == 'T':
        print("Correct: get_missed_letters() returned 'T'")
    else:
        print("ERROR: get_missed_letters should return 'T'")
        print('       but instead returned %s' % hangman.get_missed_letters())
    if hangman.game_over():
        print('ERROR: game should not be over')
    else:
        print('Correct: game is not yet over')
    if hangman.game_won():
        print('ERROR: game should not be won')
    else:
        print('Correct: game is not yet won')

    print('\nThe complete data is:')
    print(hangman)

    if hangman.guess('D'):
        print('\nCorrect: D is in the word')
    else:
        print('\nERROR: D should be in the word')
    if hangman.get_guessed_word() == '_OOD___':
        print('Correct: current guessed word is __OOD___')
    else:
        print('ERROR: current guessed word should be __OOD___')
        print('       but instead is %s' % hangman.get_guessed_word())
    if hangman.get_num_misses() == 1:
        print('Correct: currently 1 miss')
    else:
        print('ERROR: currently %d misses' % hangman.get_num_misses())
    if hangman.get_missed_letters() == 'T':
        print("Correct: get_missed_letters() returned 'T'")
    else:
        print("ERROR: get_missed_letters should return 'T'")
        print('       but instead returned %s' % hangman.get_missed_letters())
    if hangman.game_over():
        print('ERROR: game should not be over')
    else:
        print('Correct: game is not yet over')
    if hangman.game_won():
        print('ERROR: game should not be won')
    else:
        print('Correct: game is not yet won')

    if hangman.guess('g'):
        print('\nCorrect: g is in the word')
    else:
        print('\nERROR: g should be in the word')
    if hangman.get_guessed_word() == 'GOOD___':
        print('Correct: current guessed word is GOOD___')
    else:
        print('ERROR: current guessed word should be GOOD___')
        print('       but instead is %s' % hangman.get_guessed_word())
    if hangman.get_num_misses() == 1:
        print('Correct: currently 1 miss')
    else:
        print('ERROR: currently %d misses' % hangman.get_num_misses())
    if hangman.get_missed_letters() == 'T':
        print("Correct: get_missed_letters() returned 'T'")
    else:
        print("ERROR: get_missed_letters should return 'T'")
        print('       but instead returned %s' % hangman.get_missed_letters())
    if hangman.game_over():
        print('ERROR: game should not be over')
    else:
        print('Correct: game is not yet over')
    if hangman.game_won():
        print('ERROR: game should not be won')
    else:
        print('Correct: game is not yet won')

    if hangman.guess('A'):
        print('\nERROR: A should not be in the word')
    else:
        print('\nCorrect: A is not in the word')
    if hangman.get_guessed_word() == 'GOOD___':
        print('Correct: current guessed word is GOOD___')
    else:
        print('ERROR: current guessed word should be GOOD___')
        print('       but instead is %s' % hangman.get_guessed_word())
    if hangman.get_num_misses() == 2:
        print('Correct: currently 2 misses')
    else:
        print('ERROR: currently %d misses' % hangman.get_num_misses())
    if hangman.get_missed_letters() == 'TA':
        print("Correct: get_missed_letters() returned 'TA'")
    else:
        print("ERROR: get_missed_letters should return 'TA'")
        print('       but instead returned %s' % hangman.get_missed_letters())
    if hangman.game_over():
        print('ERROR: game should not be over')
    else:
        print('Correct: game is not yet over')
    if hangman.game_won():
        print('ERROR: game should not be won')
    else:
        print('Correct: game is not yet won')

    print('\nGuessing A for the second time. There should be NO change')
    print('to the number or string of missed letters.')
    if hangman.guess('A'):
        print('\nERROR: A should not be in the word')
    else:
        print('\nCorrect: A is not in the word')
    if hangman.get_num_misses() == 2:
        print('Correct: currently 2 misses')
    else:
        print('ERROR: currently %d misses' % hangman.get_num_misses())
    if hangman.get_missed_letters() == 'TA':
        print("Correct: get_missed_letters() returned 'TA'")
    else:
        print("ERROR: get_missed_letters should return 'TA'")
        print('       but instead returned %s' % hangman.get_missed_letters())

    print('\nThe complete data is:')
    print(hangman)

    if hangman.guess('n'):
        print('\nERROR: n should not be in the word')
    else:
        print('\nCorrect: n is not in the word')
    if hangman.get_guessed_word() == 'GOOD___':
        print('Correct: current guessed word is GOOD___')
    else:
        print('ERROR: current guessed word should be GOOD___')
        print('       but instead is %s' % hangman.get_guessed_word())
    if hangman.get_num_misses() == 3:
        print('Correct: currently 3 misses')
    else:
        print('ERROR: currently %d misses' % hangman.get_num_misses())
    if hangman.get_missed_letters() == 'TAN':
        print("Correct: get_missed_letters() returned 'TAN'")
    else:
        print("ERROR: get_missed_letters should return 'TN'")
        print('       but instead returned %s' % hangman.get_missed_letters())
    if hangman.game_over():
        print('Correct: game is over')
    else:
        print('ERROR: game should be over')
    if hangman.game_won():
        print('ERROR: game should not be won')
    else:
        print('Correct: game is not yet won')

    print('\nThe complete data is:')
    print(hangman)

if __name__ == '__main__':
    main()
