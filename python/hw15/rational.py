# Christopher Larson
# CSCI 238 Homework #15, Problem #4
# rational.py
# 12/7/13
#
# This program redces fractions to their simplest form using their Greatest
# Common Factor (GDP) recursively. 

class Rational(object):
    """Represent a rational number of the form numerator/denominator."""

    def __init__(self, numerator=0, denominator=1):
        if denominator == 0:
            raise ValueError('Denominator cannot be set to 0.')
        self.__numer = numerator
        self.__denom = denominator
        self.__reduce()

    def get_numerator(self):
        """Return the value iof the numerator for numer."""
        return self.__numer

    def get_denominator(self):
        """Return the value of the denominator for denom."""
        return self.__denom

    def set_value(self, numerator, denominator=1):
        """Set the values for self.__numer and self.__denom."""
        if denominator == 0:
            raise ValueError('Denominator cannot be set to 0.')
        self.__numer = numerator
        self.__denom = denominator
        self.__reduce()

    def __float__(self):
        """Return a float value of the object."""
        return self.__numer / self.__denom

    def __add__(self, other):
        """Return the sum of two rational numbers."""
        return Rational(self.__numer * other.__denom \
            + self.__denom * other.__numer,
            self.__denom * other.__denom)

    def __iadd__(self, other):
        """Add the calling number by the other number."""
        num1 = self.__numer * other.__denom
        num2 = self.__denom * other.__numer
        self.__numer = num1 + num2
        self.__denom *= other.__denom
        self.__reduce()
        return self

    def __mul__(self, other):
        """Return the product of two rational numbers."""
        return Rational(self.__numer * other.__numer,
            self.__denom * other.__denom)

    def __imul__(self, other):
        """Multiply the calling number by the other number.""" 
        self.__numer *= other.__numer
        self.__denom *= other.__denom
        self.__reduce()
        return self
   
    def __eq__(self, other):
        """Compare the equality of the two objects."""
        return self.__numer == other.__numer and self.__denom == other.__denom

    def __str__(self):
        """Return the string conversion of the rational object."""
        return '%d/%d' % (self.__numer, self.__denom)


    def __reduce(self):
        """Reduce the rational number to its simplest form."""
        if self.__denom < 0:
            self.__numer = -self.__numer
            self.__denom = -self.__denom
        
        if self.__numer != 0:
            common_divisor = gcd(abs(self.__numer),
                abs(self.__denom))
            if common_divisor != 1:
                self.__numer //= common_divisor
                self.__denom //= common_divisor
        
def gcd(m, n):
    """Return the greatest common divisor of 2 positive integers."""
    if n <= m and m % n == 0:
        result = n
    elif m < n:
        result = gcd(n, m)
    else:
        result = gcd(n, m % n)
    return result

