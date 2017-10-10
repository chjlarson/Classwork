# coin.py
# Version of the Coin class developed by Tony Gaddis,
# modified by LFW.
# This version includes appropriate docstrings, a __str__ method,
# and an is_heads method.

"""Provide an improved version of the Coin class."""

import random

HEADS = 'Heads'
TAILS = 'Tails'
    
class Coin(object):

    """Represent a 2-sided fair coin."""
    
    def __init__(self):
        """Initialize coin with random value."""
        self.toss()   # start at a random value

    def get_sideup(self):
        """Return the current value."""
        return self.__sideup

    def is_heads(self):
        """Return whether or not the current value is heads."""
        return self.__sideup == HEADS

    def toss(self):
        """Determine randomly whether it is Heads or Tails and return value."""
        if random.randint(0, 1) == 0:
            self.__sideup = HEADS
        else:
            self.__sideup = TAILS
        return self.__sideup

    def __str__(self):
        """Return the current value as a string."""
        return self.__sideup
