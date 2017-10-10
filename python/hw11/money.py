# Christopher Larson    
# CSCI 238 Homeowork #11, Problem #1
# money.py
# 11/11/13
#
# Class definition for a Money object

CENTS_PER_DOLLAR = 100

class Money(object):

    def __init__(self, dollars=0, cents=0):
        """Initialize object using dollars and cents.

        Precondition:  dollars >= 0 and cents >= 0
        Raises: ValueError if dollars < 0 or cents < 0"""

        self.set_value(dollars, cents)

    def get_dollars(self):
        """Return dollars."""
        return self.__dollars

    def get_cents(self):
        """Return cents."""
        return self.__cents
   
    def get_value(self):
        """Return value as a float."""
        return self.__dollars + self.__cents / CENTS_PER_DOLLAR

    def set_value(self, dollars, cents):
        """Set object using dollars and cents.

        Precondition:  dollars >= 0 and cents >= 0
        Raises: ValueError if dollars < 0 or cents < 0"""

        if dollars < 0 or cents < 0:
            raise ValueError('Cannot have negative dollars or cents')

        self.__dollars = dollars
        self.__cents = cents
        self.__simplify()

    def __float__(self):
        """Return float representation of the money."""
        return float(self.__dollars + self.__cents / CENTS_PER_DOLLAR)

    def __add__(self, other):
        """Return the sum of Money."""
        return Money(self.__dollars + other.__dollars,\
            self.__cents + other.__cents)

    def __iadd__(self, other):
        """Return the sum of Money."""
        self.__dollars += other.__dollars
        self.__cents += other.__cents
        self.__simplify()
        return self

    def __str__(self):
        """Return object as a string."""
        return '$%d.%02d' % (self.__dollars, self.__cents)

    def __simplify(self):
        """Simplify the value so that self.cents < CENTS_PER_DOLLAR."""
        if self.__cents >= CENTS_PER_DOLLAR:
            self.__dollars += self.__cents // CENTS_PER_DOLLAR
            self.__cents = self.__cents % CENTS_PER_DOLLAR
