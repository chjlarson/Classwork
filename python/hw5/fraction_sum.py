# Christopher Larson
# CSCI 238 Homework #5, Problem #3
# fraction_sum.py
# 9/30/13
#
# This program will test the fraction_sum function.

def main():
    print('This program tests the fraction_sum function.\n')

    print('fraction_sum(1) should return 1.00.')
    print('function_sum(1) returned %.2f.\n' % fraction_sum(1))

    print('fraction_sum(2) should return 1.50.')
    print('function_sum(2) returned %.2f.\n' % fraction_sum(2))

    print('fraction_sum(3) should return 1.833.')
    print('function_sum(3) returned %.3f.\n' % fraction_sum(3))

    print('fraction_sum(4) should return 2.083.') 
    print('function_sum(4) returned %.3f.\n' % fraction_sum(4)) 
    
    print('fraction_sum(5) should return 2.283.')
    print('function_sum(5) returned %.3f.\n' % fraction_sum(5))

    print('fraction_sum(10) should return 2.929.')
    print('function_sum(10) returned %.3f.\n' % fraction_sum(10))

    print('fraction_sum(20) should return 3.598.')
    print('function_sum(20) returned %.3f.\n' % fraction_sum(20))

def fraction_sum(n):
    sum = 0
    count = 1
    for i in range(0, n):
        sum += 1 / count
        count += 1
    return sum

main()
