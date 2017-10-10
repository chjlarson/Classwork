# Christopher Larson    
# CSCI 238 Homework #7, Problem #2
# cylinder.py
# 10/10/13
#
# This program is acting as a module computing the Surface area of a circle as
# well as the Volume of one.

"""Return the computed volume and surface are.

Preconditions:
    radius >= 0
    height >= 0"""

import math 

def compute_volume(radius, height):
    """Return computed volume."""
    if radius >= 0 and height >= 0:
            volume = math.pi * radius * radius * height
    else: 
        raise ValueError('There cannot be a negative radius/height')
    return volume

def compute_surface_area(radius, height):
    """Return computed surface area."""

    if radius >= 0 and height >= 0:
        surface_area = 2 * math.pi * radius * radius + (2 * math.pi * radius *
        height)
    else:
        raise ValueError('There cannot be a negative height')
    return surface_area

