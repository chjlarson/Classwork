# Christopher Larson
# CSCI 238 Homework #10, Problem #4
# clock.py
# 11/5/13
#
# This program will test the Clock class.

"""Provide a Clock class that uses the 24-hour format."""

HOURS_PER_DAY = 24
MINUTES_PER_HOUR = 60

class Clock(object):

    """Represent a time on a 24-hour clock."""

    def __init__(self, hour=0, minute=0):
        """Create a clock with the given time (00:00 by default).
        
        Raise: ValueError if the time is invalid."""

        if 0 <= hour < HOURS_PER_DAY and 0 <= minute < MINUTES_PER_HOUR:
            self.__hour = hour
            self.__minute = minute
        else:
            raise ValueError('Invalid time %02d:%02d' % (hour, minute))


    def increment_minute(self):
        """Increment the minute."""
        self.__minute += 1
        if self.__minute >= MINUTES_PER_HOUR:
            self.__minute = 0
            self.increment_hour()

    def get_hour(self):
        """Return the hours of the clock."""
        return self.__hour

    def get_minute(self):
        """Return the minutes of the clock."""
        return self.__minute

    def set_time(self, hour, minute):
        """Determine if input is valid."""
        if 0 <= hour < HOURS_PER_DAY and 0 <= minute < MINUTES_PER_HOUR:
            self.__hour = hour
            self.__minute = minute
        else:
            raise ValueError('Invalid time %02d:%02d' % (hour, minute))

    def increment_minute(self):
        """Increment the minute."""
        self.__minute += 1
        if self.__minute >= MINUTES_PER_HOUR:
            self.__minute = 0
            self.increment_hour()

    def increment_hour(self):
        """Increment the hour."""
        self.__minute += 1
        if self.__minute >= HOURS_PER_DAY:
            self.__hour = 0

    def __eq__(self, other):
        """Check for same data"""
        return self.__hour == other.__hour \
            and self.__minute == other.__minute

    def __str__(self):
        return '%02d:%02d' % (self.__hour, self.__minute)
