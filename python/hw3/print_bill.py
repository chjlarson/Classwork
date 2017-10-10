# Christopher Larson
# CSCI 238 homework #3, Problem #4 
# print_bill.py
# 9/14/13
#
# This program will calculate the sales tax and then the total bill.

def main():
    print('This program tests the print_bill function.\n')

    print('Calling print_bill with the arguments subtotal = 25 ' \
        + 'and rate = 5.')
    print('The total should be $26.25.\n')
    print_bill(25, 5)

    print('\nCalling print_bill with the arguments subtotal = 15.47 ' \
        + 'and rate = 7.5.')
    print('The total should be $16.63.\n')
    print_bill(15.47, 7.5)

    print('\nCalling print_bill with the argument subtotal = 125.82')
    print('The total should be $136.20.\n')
    print_bill(125.82)

    print('\nCalling print_bill with the argument subtotal = 982.82 ')
    print('The total should be $1063.90.\n')
    print_bill(982.82)

def print_bill(subtotal, rate=8.25):
    actual_rate = rate / 100
    sales_tax = subtotal * actual_rate
    total = subtotal + sales_tax
    print('%-9s $%7.2f' % ('Subtotal:', subtotal))
    print('%-9s $%7.2f' % ('Tax:', sales_tax))
    print('%-9s $%7.2f' % ('Total:', total))

main()

