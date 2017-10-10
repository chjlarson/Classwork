# test_money.py

import money

def main():
    print('This program tests some of the methods of the Money class.\n')

    # You are not expected to understand the following
    # if/else statements.
    if '__float__' in money.Money.__dict__:
        print('Correct: The __float__ method is defined.')
    else:
        print('ERROR: The __float__ method is not defined.')
    if '__add__' in money.Money.__dict__:
        print('Correct: The __add__ method is defined.')
    else:
        print('ERROR: The __add__ method is not defined.')
    if '__iadd__' in money.Money.__dict__:
        print('Correct: The __iadd__ method is defined.')
    else:
        print('ERROR: The __iadd__ method is not defined.')

    money1 = money.Money(4, 45)
    money2 = money.Money(5, 55)
    money3 = money.Money(8, 99)

    print('\nmoney1 = %s' % money1)
    print('money2 = %s' % money2)
    print('money3 = %s' % money3)

    print('\nTesting the __float__ method...')
    print('The float value of money1 should be 4.45.')
    print('The float value of money1 is %.2f.' % float(money1))

    float_return = float(money1)
    print('The type returned from the float method should be: ' \
        + "<class 'float'>")
    print('The type returned from the float method is: %s' \
        % type(float_return))

    print('\nTesting the __add__ method...')
    print('Creating money4 by adding money1 and money2.')
    money4 = money1 + money2
    print('money4 should be $10.00.')
    print('money4 is now %s.' % money4)

    print('Creating money5 by adding money1 and money3.')
    money5 = money1 + money3
    print('money5 should be $13.44.')
    print('money5 is now %s.' % money5)

    print('\nThe type returned from the __add__ method should be: ')
    print("<class 'money.Money'>")
    print('The type returned from the __add__ method is:')
    print(type(money5))
    if str(money5) != '$13.44':
        print('ERROR in your __add__ method since money5 is not $13.44.')

    print('\nTesting the __iadd__ method...')
    money1 += money2
    print('After adding money2 to money1, money1 should be $10.00.')
    print('money1 is now %s.' % money1)
    if money1.get_dollars() == 9:
        print('ERROR in __iadd__ method since dollars is 9 instead of 10')
    if money1.get_cents() == 100:
        print('ERROR in __iadd__ method since cents is 100 instead of 0')

    money3 += money4
    print('\nAfter adding money4 to money3, money3 should be $18.99.')
    print('money3 is now %s.' % money3)

    print('\nThe type returned from the __iadd__ method should be: ')
    print("<class 'money.Money'>")
    print('The type returned from the __iadd__ method is:')
    print(type(money3))
    if str(money3) != '$18.99':
        print('ERROR in your __iadd__ method since money3 is not $18.99.')

    print('\nEnd of testing for the Money class.')
main()
