# Christopher Larson & Robert Pitts
# CSCI 238 Lab #12, Problem #2
# test_polynomial.py
# This program will test the function polynomial

def main():
    print('This program tests the polynomial function.\n')

    print('Testing the polynomial p(x) = 1 + 3x + 2x^2\n')
    result = polynomial([1, 3, 2], 1)
    if result == 6:
        print('Correct: p(1) is 6')
    else:
        print('ERROR: p(1) is %d instead of 6' % result)
    result = polynomial([1, 3, 2], 2)
    if result == 15:
        print('Correct: p(2) is 15')
    else:
        print('ERROR: p(2) is %d instead of 15' % result)
    result = polynomial([1, 3, 2], 3)
    if result == 28:
        print('Correct: p(3) is 28')
    else:
        print('ERROR: p(3) is %d instead of 28' % result)

    print('\nTesting the polynomial p(x) = -3 + x - 3x^2\n')
    result = polynomial([-3, 1, -3], 1)
    if result == -5:
        print('Correct: p(1) is -5')
    else:
        print('ERROR: p(1) is %d instead of -5' % result)
    result = polynomial([-3, 1, -3], 2)
    if result == -13:
        print('Correct: p(2) is -13')
    else:
        print('ERROR: p(2) is %d instead of -13' % result)
    result = polynomial([-3, 1, -3], 3)
    if result == -27:
        print('Correct: p(3) is -27')
    else:
        print('ERROR: p(3) is %d instead of -27' % result)

    print('\nTesting the polynomial p(x) = 1 + 3x^2 - 2x^3 + x^4\n')
    result = polynomial([1, 0, 3, -2, 1], 1)
    if result == 3:
        print('Correct: p(1) is 3')
    else:
        print('ERROR: p(1) is %d instead of 3' % result)
    result = polynomial([1, 0, 3, -2, 1], 2)
    if result == 13:
        print('Correct: p(2) is 13')
    else:
        print('ERROR: p(2) is %d instead of 13' % result)
    result = polynomial([1, 0, 3, -2, 1], 3)
    if result == 55:
        print('Correct: p(3) is 55')
    else:
        print('ERROR: p(3) is %d instead of 55' % result)

def polynomial(a, x):
    """Return value of polynomial a when evaluated at x."""

    sum = 0

    for i in range(len(a)):
        sum += a[i] * x**i
    return sum
        
        

main()
