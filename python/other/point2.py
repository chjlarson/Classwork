# point2.py
# Example in which only the Point class is defined here
# and the main function is defined in test_point2.py

class Point(object):

    def __init__(self, x_value=0, y_value=0):
        self.__x = x_value
        self.__y = y_value

    def get_x(self):
        return self.__x

    def get_y(self):
        return self.__y

    def set_point(self, x_value, y_value):
        self.__x = x_value
        self.__y = y_value

    def __str__(self):
        return '(%.2f, %.2f)' % (self.__x, self.__y)
