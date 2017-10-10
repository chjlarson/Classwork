# Christopher Larson
# CSCI 238 Homework #9, Problem #6
# stocks.py
# 10/29/13
#
# This program determines the stock and the prices.

import sys

def main():
    if len(sys.argv) != 4:
        print('Usage: python stocks.py filename min_price max_price')
        sys.exit(1)

    filename = sys.argv[1]
    min_price = float(sys.argv[2])
    max_price = float(sys.argv[3])

    print('This program finds the stocks within the range of')
    print('          %.1f and %.1f in the file %s.' \
        % (min_price, max_price, filename))

    try:
        in_file = open(filename, 'r')

        for line in in_file:
            symbol, price, name = line.split(' ', 2)
            if float(price) >= min_price and float(price) <= max_price:
                print('\n%s (%s) is currently listed at $%.2f.' \
                    % (name.rstrip('\n'), symbol, float(price)))
        in_file.close()
        
    except IOError:
        print('\nError: Could not open file.')

    except ValueError:
        print('\nError: Could not convert str to float.')
        in_file.close()
main()
