# account.py
# Version of the BankAccount class developed by Tony Gaddis,
# modified by LFW.

"""Provide an improved version of the BankAccount class."""

class BankAccount(object):

    def __init__(self, balance=0):
        """Initialize account with new balance (default 0).
           
           Raise: ValueError if balance < 0. """

        if balance < 0:
            raise ValueError('Cannot have negative balance.')

        self.__balance = balance

    def get_balance(self):
        """Return balance."""
        return self.__balance

    def deposit(self, amount):
        """Deposit amount into account.
        
        Raise: ValueError if amount < 0"""

        if amount < 0:
            raise ValueError('Cannot deposit negative amount.')

        self.__balance += amount

    def withdraw(self, amount):
        """Withdraw amount from account.
        
        Raise:  ValueError if balance < amount"""

        if self.__balance < amount:
            raise ValueError('Insufficient funds to withdraw.')

        self.__balance -= amount

    # Add your methods here



    def __str__(self):
        """Return string representation in the form $5.01."""
        return '$%.2f' % self.__balance

