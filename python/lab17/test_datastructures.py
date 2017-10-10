# Christopher Larson
# CSCI 238 Lab#17 Problem #2
# test_datastructures.py
# 11/11/13
# 
# This program will test the datastructures class.

import datastructures

def main():

    stack = datastructures.Stack()
    stack.push(5)
    stack.push('CSCI 238')
    stack.push(6.9)
    stack.push('Good Morning')
    print('%s\n' % stack)

    item = stack.pop()
    print('Removed %s from stack\n' % item)

    top = stack.peek()
    print('The stack contains')
    print(stack)

main()
