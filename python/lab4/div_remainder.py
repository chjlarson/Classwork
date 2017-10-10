# Christopher Larson
# CSCI 238 Lab#4 Problem #4
# div_remainder.py
# 9-10-13

def main():
    print('This program performs long division')
    print('just like you learned in elementary school.')
    print('Thus, the result of each calculation will be')
    print('an integer quotient with an integer remainder.\n')

    division_remainder(7, 2)
    division_remainder(9, 3)
    division_remainder(6, 9)
    division_remainder(27, 4)


def division_remainder(num1, num2):
    quotient = num1 // num2 
    remainder = num1 % num2 
    print('%d / %d = %d R %d' \
        % (num1, num2, quotient, remainder))

main()
