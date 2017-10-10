# Christopher Larson
# CSCI 238 Homeowrk #10, Problem #3
# word_frequency.py
# 11/5/13
#
# This program will calculate the frequency of each word in the file.

import sys

def main():
    if len(sys.argv) != 2:
        print('Usage: python word_frequency.py filename')
        sys.exit(1)

    filename = sys.argv[1]

    print('This program determines the frequency of each word in the %s file.\n'\
        % filename)

    total_word = []
    num_list = []

    try:
        in_file = open(filename, 'r')

        for line in in_file:
            word_list = line.split()
            for word in word_list:
                if word.lower() in total_word:
                    num_list[total_word.index(word.lower())] += 1
                else:
                    total_word.append(word.lower().rstrip('\n'))
                    num_list.append(1)
        in_file.close()

        for i in range(len(total_word)):
            print('%-12s  %3d' % (total_word[i], num_list[i]))

    except IOError:
        print('Error: Could not open the file %s' % filename)
        
main()
