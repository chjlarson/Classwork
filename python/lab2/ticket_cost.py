# Christopher Larson
# CSCI 238 Lab#2, Problem #3
# ticket_cost.py
# 9-3-13
#
# This program computes the total cost for the theater tickets.

CHILD_PRICE = 3
ADULT_PRICE = 5

print('Bulldog Theater Company')
print()
print('Given the number of child and adult tickets desired,')
print('this program will compute the total cost of the tickets.')
print()

num_children = int(input('Enter the number of children: '))
num_adults = int(input('Enter the number of adults: '))

cost = CHILD_PRICE * num_children + ADULT_PRICE * num_adults

print('For', num_children, 'children and', num_adults, 'adults,')
print('the cost is $', cost)
