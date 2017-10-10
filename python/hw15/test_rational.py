# test_rational.py

"""Test the rational.Rational class."""

import rational

def main():
    """Test the rational.Rational class methods."""
    print('This program tests the Rational class.\n')

    print('Read the output of this program CAREFULLY!\n')

    number0 = rational.Rational()
    print('Testing the existence of certain methods...')
    if hasattr(number0, 'get_numerator'):
        print('Correct: Has a get_numerator method')
    else:
        print('ERROR: Does not have a get_numerator method')
    if hasattr(number0, 'get_denominator'):
        print('Correct: Has a get_denominator method')
    else:
        print('ERROR: Does not have a get_denominator method')
    if hasattr(number0, 'set_value'):
        print('Correct: Has a set_value method')
    else:
        print('ERROR: Does not have a set_value method')
    if hasattr(number0, '__float__'):
        print('Correct: Has a __float__ method')
    else:
        print('ERROR: Does not have a __float__ method')
    if hasattr(number0, '__add__'):
        print('Correct: Has a __add__ method')
    else:
        print('ERROR: Does not have a __add__ method')
    if hasattr(number0, '__iadd__'):
        print('Correct: Has an __iadd__ method')
    else:
        print('ERROR: Does not have an __iadd__ method')
    if hasattr(number0, '__mul__'):
        print('Correct: Has a __mul__ method')
    else:
        print('ERROR: Does not have a __mul__ method')
    if hasattr(number0, '__imul__'):
        print('Correct: Has an __imul__ method')
    else:
        print('ERROR: Does not have an __imul__ method')
    if hasattr(number0, '__eq__'):
        print('Correct: Has an __eq__ method')
    else:
        print('ERROR: Does not have an __eq__ method')
    if hasattr(number0, '__str__'):
        print('Correct: Has a __str__ method')
    else:
        print('ERROR: Does not have a __str__ method')

    print('\nTesting the constructor and __str__ method:\n')

    # Created number0 = rational.Rational() above
    if str(number0) == '0/1':
        print('Correct: default object = 0/1')
    else:
        print('ERROR: default object should be 0/1 but is %s' % number0)

    number1 = rational.Rational(3)
    if str(number1) == '3/1':
        print('Correct: 3 is represented as 3/1')
    else:
        print('ERROR: 3 should be represented as 3/1 but is %s' % number1)

    number2 = rational.Rational(2, 3)
    if str(number2) == '2/3':
        print('Correct: 2/3 is represented as 2/3')
    else:
        print('ERROR: 2/3 should be 2/3 but is %s' % number2)

    number3 = rational.Rational(2, 6)
    if str(number3) == '1/3':
        print('Correct: 2/6 reduces to 1/3')
    else:
        print('ERROR: 2/6 should reduce to 1/3 but is %s' % number3)

    number4 = rational.Rational(12, 9)
    if str(number4) == '4/3':
        print('Correct: 12/9 reduces to 4/3')
    else:
        print('ERROR: 12/9 should reduce to 4/3 but is %s' % number4)

    number5 = rational.Rational(1, -6)
    if str(number5) == '-1/6':
        print('Correct: 1/-6 reduces to -1/6')
    else:
        print('ERROR: 1/-6 should reduce to -1/6 but is %s' % number5)

    number6 = rational.Rational(-5, -9)
    if str(number6) == '5/9':
        print('Correct: -5/-9 reduces to 5/9')
    else:
        print('ERROR: -5/-9 should reduce to 5/9 but is %s' % number6)

    print('\nAttempting to create a rational number with 0 denominator...')
    print('Expecting a ValueError...')
    try:
        dummy = rational.Rational(5, 0)
        print('ERROR -- No exception was thrown from the constructor!')
    except ValueError:
        print('Correct: Caught a ValueError from the constructor')
    except Exception:
        print('ERROR: Wrong type of exception thrown from the constructor')

    print('\nTesting the accessor and mutator methods:\n')

    numerator = number1.get_numerator()
    denominator = number1.get_denominator()
    if numerator == 3 and denominator == 1:
        print('Correct: 3/1 has numerator 3 and denominator 1') 
    else:
        print('ERROR: %s has numerator %d and denominator %d' \
            % (number1, numerator, denominator))

    numerator = number2.get_numerator()
    denominator = number2.get_denominator()
    if numerator == 2 and denominator == 3:
        print('Correct: 2/3 has numerator 2 and denominator 3') 
    else:
        print('ERROR: %s has numerator %d and denominator %d' \
            % (number2, numerator, denominator))

    print('\nChanging 2/3 to 5/4...')
    number2.set_value(5, 4)
    if str(number2) == '5/4':
        print('Correct: 2/3 has been changed to 5/4')
    else:
        print('ERROR: 2/3 should have been changed to 5/4 but is %s' \
            % number2)

    print('\nChanging 5/4 to 4/12 = 1/3...')
    number2.set_value(4, 12)
    if str(number2) == '1/3':
        print('Correct: 5/4 has been changed to 1/3')
    else:
        print('ERROR: 5/4 should have been changed to 1/3 but is %s' \
            % number2)

    print('\nChanging 1/3 to 4 = 4/1...')
    number2.set_value(4)
    if str(number2) == '4/1':
        print('Correct: 1/3 has been changed to 4/1')
    else:
        print('ERROR: 1/3 should have been changed to 4/1 but is %s' \
            % number2)

    print('\nAttempting to set a rational number with 0 denominator...')
    print('Expecting a ValueError...')
    dummy = rational.Rational(10)
    try:
        dummy.set_value(8, 0)
        print('ERROR -- No exception was thrown from set_value!')
    except ValueError:
        print('Correct: Caught a ValueError from set_value')
    except Exception:
        print('ERROR: Wrong type of exception thrown from set_value')

    print('\nTesting the __float__ method:\n')
   
    if float(number1) == 3.0:
        print('Correct: 3/1 == 3.0')
    else:
        print('ERROR: 3/1 = %.6f' % float(number1))

    number2 = rational.Rational(2, 3)
    if float(number2) == 2.0/3:
        print('Correct: 2/3 == 0.6666667')
    else:
        print('ERROR: 2/3 = %f' % float(number2))

    print('\nTesting the __add__ and __mul__ methods:\n')

    number1.set_value(1, 3)
    number2.set_value(1, 6)
    number3 = number1 + number2
    if str(number3) == '1/2':
        print('Correct: 1/3 + 1/6 = 1/2')
    else:
        print('ERROR: 1/3 + 1/6 should be 1/2 but is %s' % number3)

    number1.set_value(3, 4)
    number3 = number1 + number2
    if str(number3) == '11/12':
        print('Correct: 3/4 + 1/6 = 11/12')
    else:
        print('ERROR: 3/4 + 1/6 should be 11/12 but is %s' % number3)

    number1.set_value(-5, 4)
    number2.set_value(6, -8)
    number3 = number1 + number2
    if str(number3) == '-2/1':
        print('Correct: -5/4 + 6/-8 = -2/1\n')
    else:
        print('ERROR: -5/4 + 6/-8 should be -2/1 but is %s\n' % number3)

    number1.set_value(2, 3)
    number2.set_value(3, 2)
    number3 = number1 * number2
    if str(number3) == '1/1':
        print('Correct: 2/3 * 3/2 = 1/1')
    else:
        print('ERROR: 2/3 * 3/2 should be 1/1 but is %s' % number3)

    number2.set_value(1, 2)
    number3 = number1 * number2
    if str(number3) == '1/3':
        print('Correct: 2/3 * 1/2 = 1/3')
    else:
        print('ERROR: 2/3 * 1/2 should be 1/3 but is %s' % number3)

    number1.set_value(-1, 6)
    number2.set_value(2, 1)
    number3 = number1 * number2
    if str(number3) == '-1/3':
        print('Correct: -1/6 * 2/1 = -1/3')
    else:
        print('ERROR: -1/5 * 2/1 should be -1/3 but is %s' % number3)

    print('\nTesting the __iadd__ and __imul__ methods:\n')

    number1.set_value(1, 3)
    number2.set_value(1, 6)
    number1 += number2
    if str(number1) == '1/2':
        print('Correct: 1/3 += 1/6 is 1/2')
    else:
        print('ERROR: 1/3 += 1/6 should be 1/2 but is %s' % number1)

    number1.set_value(3, 4)
    number1 += number2
    if str(number1) == '11/12':
        print('Correct: 3/4 += 1/6 is 11/12')
    else:
        print('ERROR: 3/4 += 1/6 should be 11/12 but is %s' % number1)

    number1.set_value(-5, 4)
    number2.set_value(6, -8)
    number1 += number2
    if str(number1) == '-2/1':
        print('Correct: -5/4 += 6/-8 is -2/1\n')
    else:
        print('ERROR: -5/4 += 6/-8 should be -2/1 but is %s\n' % number1)

    number1.set_value(2, 3)
    number2.set_value(3, 2)
    number1 *= number2
    if str(number1) == '1/1':
        print('Correct: 2/3 *= 3/2 is 1/1')
    else:
        print('ERROR: 2/3 *= 3/2 should be 1/1 but is %s' % number1)

    number1.set_value(2, 3)
    number2.set_value(1, 2)
    number1 *= number2
    if str(number1) == '1/3':
        print('Correct: 2/3 *= 1/2 is 1/3')
    else:
        print('ERROR: 2/3 *= 1/2 should be 1/3 but is %s' % number1)

    number1.set_value(-1, 6)
    number2.set_value(2, 1)
    number1 *= number2
    if str(number1) == '-1/3':
        print('Correct: -1/6 *= 2/1 is -1/3')
    else:
        print('ERROR: -1/5 *= 2/1 should be -1/3 but is %s' % number1)

    print('\nTesting the __eq__ method:\n')

    number1.set_value(4, 9)
    number2.set_value(4, 9)
    if number1 == number2:
        print('Correct: 4/9 == 4/9')
    else:
        print('ERROR: 4/9 != 4/9')

    number1.set_value(4, 9)
    number2.set_value(4, 8)
    if number1 != number2:
        print('Correct: 4/9 != 4/8')
    else:
        print('ERROR: 4/9 == 4/8')

    number1.set_value(3, 4)
    number2.set_value(3, 5)
    if number1 != number2:
        print('Correct: 3/4 != 3/5')
    else:
        print('ERROR: 3/4 == 3/5')

    number1.set_value(2, 5)
    number2.set_value(3, 5)
    if number1 != number2:
        print('Correct: 2/5 != 3/5')
    else:
        print('ERROR: 2/5 == 3/5')

    print('\n*** End of testing for the Rational class ***\n')
    print('Note that passing all of these tests provides some confidence')
    print('but does not necessarily guarantee that all the code is correct.')


main()
