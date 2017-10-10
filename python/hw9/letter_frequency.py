# Christopher Larson
# CSCI 238 Homework #9, Problem #5
# letter_frequency.py
# 10/29/13
#
# This program will compute the frequency of each letter in a file.

import sys
MAX_ALPHA = 26

def main():
    if len(sys.argv) != 2:
        print('Usage python letter_frequency.py filename')
        sys.exit(1)

    filename = sys.argv[1]
    print('This program will evaluate the text in the file %s' % filename)

    total = 0
    num = 0
    letter = [0] * MAX_ALPHA
    
    try:    
        in_file = open(filename, 'r')
        for line in in_file:
            for ch in line:
                if ch.isalpha():
                    total += 1
                    if ch.islower():
                        num = ord(ch)-97
                    elif ch.isupper():
                        num = ord(ch)-65
                    letter[num] += 1

        print('\nThe file contained %d letters.' % total)
        print('\nLetter    Count    Percentage')

        for n in range(MAX_ALPHA):
            character = chr(n+65)
            count = letter[n]
            percent = count / total * 100
            print('%3s %10d %10.1f%%' % (character, count, percent))

    except IOError:
        print('Error: Could not open file.')

main()

