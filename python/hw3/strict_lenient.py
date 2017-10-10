# Christopher Larson
# CSCI 238 Homework #3, Extra Credit
# strict_lenient.py
# 9/19/13
#
# This program will promt the user to enter 3 numbers 
# Then calculate if it is decreasing or increasing
# and if it strict or lenient. 

def main():
    print('\nWe are going to see if a group of numbers are' \
        + ' increasing or \n' 
        + 'decreasing strictly or leniently.')
    strict_len = input('Do you want it to be strict' \
        + ' or lenient? \n')
    num1 = float(input('Please enter a number: '))
    num2 = float(input('Please enter another number: '))
    num3 = float(input('Please enter one more number: '))
    result = calculate (strict_len, num1, num2, num3)
    print('The numbers you entered are %s.' %result)

def calculate(strict_len, num1, num2, num3):
    if strict_len == 'strict' or strict_len == 'Strict':
        if num1 < num2 < num3:
            result = 'Increasing'
        elif num1 == num2 == num3:
            result = 'Niether'
        else:
            result = 'Decreasing'
    elif strict_len == 'lenient' or strict_len == 'Lenient':
        if num1 < num2 <  num3:
            result = 'Increasing'
        elif num1 <= num2 < num3:
            result = 'Increasing'
        elif num1 < num2 <= num3:
            result = 'Increasing'
        elif num1 >= num2 > num3:
            result = 'Decreasing'
        elif num1 > num2 >= num3:
            result = 'Decreasing'
        elif num1 == num2 == num3:
            result = 'Increasing and Decreasing'
        else:
            result = 'Niether'
    else:
        result = 'Niether'
    return result

main()
