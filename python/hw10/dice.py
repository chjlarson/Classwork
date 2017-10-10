# dice.py

"""Provide the Die and PairOfDice classes

Die -- a single 6-sided die
    __init__(self) -- initialize die with random face value
    __int__(self) -- return integer representation of die
    get_value(self) -- return the die's face value
    roll(self) -- roll the die and return its new face value
    __str__(self) -- return the face value as a string
"""

import random

class Die(object):

    """Represent a 6-sided die."""

    def __init__(self):
        """Initialize die with random face value."""
        self.roll()

    def __int__(self):
        """Return integer representation of the die."""
        return self.__value
    
    def get_value(self):
        """Return the die's face value."""
        return self.__value
    
    def roll(self):
        """Roll the die and return its new face value."""
        self.__value = random.randint(1, 6)
        return self.__value

    def __str__(self):
        """Return the face value as a string."""
        return str(self.__value)

