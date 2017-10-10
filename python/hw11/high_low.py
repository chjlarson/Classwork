# Christopher Larson    
# CSCI 238 Homework #11, Problem #3
# high_low.py
# 11/12/13
#
# This program simulates a card game that draws a random card from a deck and
# the user predicts whether the next card drawn will be higher or lower. 

import cards

def main():

    print('\nThis program lets you play a simple card game called High-Low.')
    print('    A card will be dealt from a deck of cards. You must predict')
    print('    whether the next card will be higher (H) or lower (L).')
    print('    If you guess correctly, another card will be dealt')
    print('    and you will guess again.')
    print('Your score will be the number of correct predictions.\n')
    print('  *  Note that a tie counts as an incorrect guess.\n')

    count = 0
    deck = cards.DeckOfCards()
    current_card = cards.Card()
    next_card = deck.deal()    

    print('The current card is the %s.' % current_card)
    guess = input('Enter your guess (H or L): ')
    
    correct = True
    answer = card_calculate(current_card, next_card)
    while correct == True:
        if answer == guess.lower():
            print('\nThe next card was %s' % next_card)
            print('Your prediction was correct.\n')
            count += 1
            current_card = next_card
            next_card = deck.deal()
            guess = input('Enter your next guess (H or L): ')
            answer = card_calculate(current_card, next_card)

        elif answer != guess.lower() and answer != 'tie':
            print('\nThe next card was %s' % next_card)
            print('\nYour prediction was incorrect.')
            correct = False
        else:
            print('\nThe next card was %s' % next_card)
            print('\nSorry, but you lose on ties!')
            correct = False
    print('\nGame over! Your score was %d' % count)


def card_calculate(current_card, next_card): 
    """Return whether next_card is lower, higher, or equal to current_card."""
    current_card_num = cards.Card.get_face(current_card)
    next_card_num = cards.Card.get_face(next_card)
    if current_card_num > next_card_num:
        answer = 'l'
    elif current_card_num < next_card_num:
        answer = 'h'
    else:
        answer = 'tie'
    return answer


main()
