# dice.py
"""Functions for rolling one or two dice."""

import random

def roll_die():
    """Return the roll from a single die."""
    return random.randint(1, 6)

def roll_dice():
    """Return the two values obtained from rolling two dice."""
    die1 = random.randint(1, 6)
    die2 = random.randint(1, 6)
    return die1, die2
