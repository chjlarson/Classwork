# cards.py

"""Provide the Card, DeckOfCards, and DeckException classes.

Card -- a single card from a deck of cards
     __init__(self, face=None, suit=None) -- create the desired card
     get_suit(self) -- return the suit
     get_face(self) -- return the face
     deal(self) -- change values to random card
     is_ace(self) -- return whether or not the card is an ace
     is_face_card(self) -- return whether or not the card is a face card
     __eq__(self, other) -- compare cards for equality
     __str__(self) -- return string representation in form 'Ace of Spades'

DeckOfCards -- a deck of 52 cards
    __init__(self) -- create a deck of cards in random order
    shuffle(self) -- shuffle the deck
    cards_left(self) -- return whether or not cards are left in the deck
    deal(self) -- return the next card from the deck
    get_num_cards(self) -- return number of cards left in the deck
    __str__(self) -- return a string representation with one card per line

DeckException -- an exception for a deck of cards operation
    __init__(self, message='') -- create the exception with the given message
"""

import random

# Useful constants
CLUBS = 0
DIAMONDS = 1
HEARTS = 2
SPADES = 3

ACE = 14
KING = 13
QUEEN = 12
JACK = 11
TWO = 2

MIN_FACE = TWO 
MAX_FACE = ACE
MIN_SUIT = CLUBS
MAX_SUIT = SPADES

CARDS_PER_DECK = 52

class Card(object):
    """Represent a card from a deck of cards."""

    # Static lists for suit and face names
    # The face name list contains two empty elements
    # so that the indices range from TWO to ACE 
    __suit_list = ['Clubs', 'Diamonds', 'Hearts', 'Spades']
    __face_list = [None, None, 'Two', 'Three', 'Four',
        'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten',
        'Jack', 'Queen', 'King', 'Ace']
    
    def __init__(self, face=None, suit=None):
        """Create the desired card.

        Default arguments of face=None and suit=None create random card.
        Raises ValueError if the specified card is invalid."""
        if face == None and suit == None:
            # set to random card value
            self.deal()
        elif TWO <= face <= ACE and CLUBS <= suit <= SPADES:
            self.__face = face
            self.__suit = suit
        else:
            raise ValueError('Invalid face and/or suit for Card constructor')
            
    def get_suit(self):
        """Return the suit."""
        return self.__suit

    def get_face(self):
        """Return the face."""
        return self.__face

    def deal(self):
        """Change the card to a random card."""
        self.__face = random.randint(MIN_FACE, MAX_FACE)
        self.__suit = random.randint(MIN_SUIT, MAX_SUIT)
        
    def is_ace(self):
        """Return whether or not the card is an ace."""
        return self.__face == ACE

    def is_face_card(self):
        """Return whether or not the card is a face card."""
        return JACK <= self.__face <= KING

    def __eq__(self, other):
        """Compare cards for equality."""
        return self.__face == other.__face and self.__suit == other.__suit

    def __str__(self):
        """Create string representation in form 'Ace of Spades'"""
        return '%s of %s' \
            % (Card.__face_list[self.__face], Card.__suit_list[self.__suit])
    
class DeckOfCards(object):
    """Represent a deck of cards."""

    def __init__(self):
        """Create a deck containing all 52 cards in random order."""
        self.__card_list = []
        for suit in range(CLUBS, SPADES + 1):
            for face in range(TWO, ACE + 1):
                self.__card_list.append(Card(face, suit))
        self.shuffle()

    def shuffle(self):
        """Shuffle the deck."""
        random.shuffle(self.__card_list)
        self.__top = 0

    def cards_left(self):
        """Return whether or not cards are left in the deck."""
        return (self.__top < CARDS_PER_DECK)

    def deal(self):
        """Return the next card from the deck.

        Raise DeckError if the deck is empty."""
        if self.__top == len(self.__card_list):
            raise DeckError('Cannot deal from empty deck')
        
        card = self.__card_list[self.__top]
        self.__top += 1
        return card

    def get_num_cards_left(self):
        """Return number of cards left in the deck."""
        return len(self.__card_list) - self.__top

    def __str__(self):
        """Return a string representation with one card per line."""
        result = ''
        for i in range(self.__top, CARDS_PER_DECK):
            result += str(self.__card_list[i]) + '\n'
        return result

class DeckError(Exception):
    """Represent an exception for a deck of cards operation."""
    def __init__(self, message=''):          
        """Create the exception with the given message."""
        Exception.__init__(message)

