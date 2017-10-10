# point3.py

"""Provide the Point class."""

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

