# Christopher Larson
# 238 Homework #6, Problem #4
# rolling_dice.py
# 10/9/13
#
# This program plays a game where it displays a score ccording to how many 6's 
# are gotten during each roll.

import random
ONE_SIX = 1
TWO_SIX = 2
THREE_SIX = 3

def main():
    print('Let\'s play a dice game!')
    print('We will roll 3 dice and the rules are, ')
    print('\tIf you role a 6, you get a point.' \
    + '\n\tIf you role two 6\'s, you get two points.' \
    + '\n\tand if you role three 6\'s, you get 6 points.\n') 
    
    score = 0

    for i in range(50):
        count = 0
        die1, die2, die3 = get_roll()
        if die1 == 6:
            count += 1
        if die2 == 6:
            count += 1
        if die3 == 6:
            count += 1

        score += calc_score(count)
        print('Roll = %d %d %d  Score = %d' % (die1, die2, die3, score))

    


def get_roll():
    """Return random integer from 1 to 6."""
    num1 = random.randint(1, 6)
    num2 = random.randint(1, 6)
    num3 = random.randint(1, 6)
    return num1, num2, num3

def calc_score(count):
    """Return score."""
    result = 0
    if count == THREE_SIX:
        result += 6
    elif count == TWO_SIX:
        result += 2
    elif count == ONE_SIX:
        result += 1
    return result

main()    
