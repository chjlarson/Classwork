# Christopher Larson
# CSCI 238 Homework #9, Problem #3
# test_acronym.py
# 10/29/13
# 
# This program will test the acronym function.

def main():
    print('This program tests the acronym function.\n')

    string1 = 'Central Intelligence Agency'
    answer1 = 'CIA'
    print('The acronym for %s should be %s.' % (string1, answer1))

    acronym1 = acronym(string1)
    if acronym1 == answer1:
        print('Correct: The acronym is %s' % answer1)
    else:
        print('ERROR: The acronym is %s instead of %s' \
            % (acronym1, answer1))

    string2 = 'random access memory'
    answer2 = 'RAM'
    print('\nThe acronym for %s should be %s.' % (string2, answer2))

    acronym2 = acronym(string2)
    if acronym2 == answer2:
        print('Correct: The acronym is %s' % answer2)
    else:
        print('ERROR: The acronym is %s instead of %s' \
            % (acronym2, answer2))

def acronym(string):
    """Return the acronym of the given phrase."""
    result = ''
    split_string = string.upper().split()
    for i in split_string:
        result += i[0]
    return result
        
main()
