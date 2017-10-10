# Christopher Larson
# CSCI 238 Homework #3, Problem #7
# income_tax.py
# 9/18/13
#
# This program will calculate the the users tax bracket and tax amount.

def main():
    print('\nWe are going to calculate how much you will be paying in taxes.')
    income = float(input('\tPlease enter your households income: '))
    result = bracket(income)
    print('\tYou will be paying $%.2f in taxes.' %result)

def bracket (income):
    if income < 20000:
        result = .01 * (income)
    elif income < 50000:
        result = 200 + .02 * (income - 20000)
    elif income < 75000:
        result = 800 + .03 * (income - 50000)
    elif income < 100000:
        result = 1550 + .04 * (income - 75000)
    elif income < 250000:
        result = 2550 + .05 * (income - 100000)
    elif income < 500000:
        result = 10050 + .06 * (income - 250000)
    else: 
        result = 25050 + .07 * (income - 500000)
    return result

main()
