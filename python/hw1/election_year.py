# Christopher Larson
# CSCI 238 Homework #4, Problem #2
# election_year.py
# 9/25/13
#
# This program will calculate which years are election years.

def main():
    print('This program tests the is_election_year() function')
    print('for determining presidential election years.\n')

    if is_election_year(2000):
        print('Correct: 2000 was an election year')
    else:
        print('ERROR: 2000 should have been an election year')

    if not is_election_year(2011):
        print('Correct: 2011 was not an election year')
    else:
        print('ERROR: 2011 should not have been an election year')

    if is_election_year(2012):
        print('Correct: 2012 was an election year')
    else:
        print('ERROR: 2012 should have been an election year')

    # Although it is poor practice to write a condition like this
    # below, I need it here to catch a subtle error that students
    # sometimes make
    if is_election_year(2013) == False:
        print('Correct: 2013 is not an election year')
    else:
        print('ERROR: 2013 should not be an election year')

    if not is_election_year(2014):
        print('Correct: 2014 is not an election year')
    else:
        print('ERROR: 2014 should not be an election year')

    if not is_election_year(2015):
        print('Correct: 2015 is not an election year')
    else:
        print('ERROR: 2015 should not be an election year')

    if is_election_year(2016):
        print('Correct: 2016 is an election year')
    else:
        print('ERROR: 2016 should be an election year')

# put your function here
def is_election_year(year):
    if year % 4 == 0:
        result = True
    else:
        result = False
    return result


main()
