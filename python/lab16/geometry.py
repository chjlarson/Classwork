# Chris Larson & Robert Pitts
# CSCI 238 Lab16, Problem #2
# geometry.py
# 11/5/13
#
# This program is testing the LineSegment class.  

"""Provide the Point and the LineSegment classes."""

import math

class Point(object):
    
    """Represent a point in 2-D coordinates."""

    def __init__(self, x_value=0, y_value=0):
        """Create a new point.

        Arguments:
            x_value (default 0)
            y_value (default 0)
        """

        self.__x = x_value
        self.__y = y_value

    def get_x(self):
        """Return the x coordinate of the point."""
        return self.__x

    def get_y(self):
        """Return the y coordinate of the point."""
        return self.__y

    def set_point(self, x_value, y_value):
        """Set the point to the new values.

        Arguments:
            x_value (default 0)
            y_value (default 0)
        """
        self.__x = x_value
        self.__y = y_value

    def __eq__(self, other):
        """Return whether or not the two points have same data."""
        return self.__x == other.__x \
            and self.__y == other.__y

    def __add__(self, other):
        """Return a third point created by adding two points."""
        return Point(self.__x + other.__x, \
            self.__y + other.__y)

    def __iadd__(self, other):
        """Add the second point to the first point."""
        self.__x += other.__x
        self.__y += other.__y
        return self

    def __str__(self):
        """Create a string representation in format (%.2f, %.2f)."""
        return '(%.2f, %.2f)' % (self.__x, self.__y)
    
class LineSegment(object):

    """Represent a line segment in 2-D coordinates."""

    def __init__(self, x1, y1, x2, y2):
        self.__point1 = Point(x1, y1)
        self.__point2 = Point(x2, y2)

    def get_x1(self):
        return self.__point1.get_x()

    def get_y1(self):
        return self.__point1.get_y()
    
    def get_x2(self):
        return self.__point2.get_x()

    def get_y2(self):
        return self.__point2.get_y()
    
    def length(self):
        x_diff = self.__point1.get_x() - self.__point2.get_x()
        y_diff = self.__point1.get_y() - self.__point2.get_y()
        distance = math.sqrt(x_diff * x_diff + y_diff * y_diff)
        return distance

    def __str___(self):
        return '%s, %s' % (self.__point1, self.__point2)
        
