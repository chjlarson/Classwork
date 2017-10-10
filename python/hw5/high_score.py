# Christopher Larson
# CSCI #238 Homework #5, Problem #4
# high_score.py
# 10/2/13
#
# This program will determine who has the highest score.

def main():
    print('\nWe are going to figure out who got the highest score')
    num_players = int(input('Enter the number of players: '))
    max_player = input('Enter the first players name: ')
    max_score = int(input('Enter their score: '))

    for players in range(num_players - 1):
        next_player = input('Enter the name of the next player: ')
        next_score = int(input('Enter their score: '))
        if next_score > max_score:
            max_score = next_score
            max_player = next_player

    print('The highest score belongs to' \
    + ' %s with a score of %d' % (max_player,max_score))

main()
