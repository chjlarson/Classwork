# datastructures.py
# NOTE: This version does not provide any error checking
# for pop!

"""Provide Stack and Queue classes."""

class Stack(object):

    """Represent a stack data structure."""

    def __init__(self):
        """Create an empty stack."""
        self.__stack = []

    def push(self, item):
        """Add item to the top of the stack."""
        self.__stack.insert(0, item)

    def pop(self):
        """Remove and return item from the top of the stack."""
        item = self.__stack[0]
        del self.__stack[0]
        return item

    def peek(self):
        """Return item from the top of the stack."""
        return self.__stack[0]

    def is_empty(self):
        """Return whether or not the stack is empty."""
        return len(self.__stack) == 0

    def size(self):
        """Return the number of items in the stack."""
        return len(self.__stack)

    def __str__(self):
        """Return a string representation from top to bottom."""
        result = ''
        for item in self.__stack:
            result += str(item) + '\n'
        return result


