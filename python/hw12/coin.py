# Christopher Larson
# CSCI 238 Homework #12, Problem #4
# coin.py
# 11/17/13
#
# This program contains the Coin and MonetaryCoin classes.

"""Provide the Coin and MonetaryCoin classes.

Coin -- a 2-sided fair coin
    __init__(self) -- initialize coin with random side up
    toss(self) -- determine randomly whether it is Heads or Tails and 
        return side
    get_sideup(self) -- return the current side up
    is_heads(self) -- return whether or not the current side up is heads
    __str__(self) -- return the current side up as a string
"""

import random

HEADS = 'Heads'
TAILS = 'Tails'
    
class Coin(object):

    """Represent a 2-sided fair coin."""
    
    def __init__(self):
        """Initialize coin with random side up."""
        self.toss()   

    def toss(self):
        """Determine randomly whether it is Heads or Tails and return side."""
        if random.randint(0, 1) == 0:
            self.__sideup = HEADS
        else:
            self.__sideup = TAILS
        return self.__sideup

    def get_sideup(self):
        """Return the current side up."""
        return self.__sideup

    def is_heads(self):
        """Return whether or not the current side up is heads."""
        return self.__sideup == HEADS

    def __str__(self):
        """Return the current side up as a string."""
        return self.__sideup

class MonetaryCoin(Coin):

    """Represent the monetary value of a coin.
    
    if value is not positive
        Raise ValueError"""

    def __init__(self, value=0):
        """Initialize coin with random side up and value.."""
        Coin.__init__(self)
        self.__value = value
        if self.__value <= 0: 
            raise ValueError('The value cannot be negative.')

    def get_value(self):
        """Get value of coin."""
        return self.__value

    def set_value(self, value):
        """Set value of coin."""
        self.__value = value
        if self.__value <= 0:
            raise ValueError('The value cannot be negative.')
    
    def __str__(self):
        """Return the current side up and value as a string."""
        return '%s, %s' % (Coin.__str__(self), str(self.__value))
