# test_account.py

import sys
import account

def main():
    print('This program tests certain methods of the ')
    print('BankAccount class from the account module.\n')

    print('  READ THIS OUTPUT VERY CAREFULLY  !!!\n')
    print('If you reach the "End of testing" message without')
    print('seeing any error messages, your Account methods')
    print('probably are correct. Otherwise, look at the error')
    print('messages and other output VERY carefully!\n')

    account1 = account.BankAccount()
    account2 = account.BankAccount(10.5)
    account3 = account.BankAccount(10.5)
    account4 = account.BankAccount(9.25)
    account5 = account.BankAccount(4.99)
    account6 = account.BankAccount(2.75)
    account7 = account.BankAccount(22)

    print('account1 = %s' % account1)
    print('account2 = %s' % account2)
    print('account3 = %s' % account3)
    print('account4 = %s' % account4)
    print('account5 = %s' % account5)
    print('account6 = %s' % account6)
    print('account7 = %s' % account7)

    print('\nTesting the __float__ method...')

    # You are not expected to understand the following 
    # if/else statement.
    if '__float__' in account.BankAccount.__dict__:
        print('Correct: The __float__ method is defined.')
    else:
        print('ERROR: The __float__ method is not defined.')
        sys.exit(1)

    float_return = float(account1)
    print('The type returned from the float method should be: ' \
        + "<class 'float'>")
    print('The type returned from the float method is: %s' \
        % type(float_return))

    print('\nTesting the __add__ method...')

    if '__add__' in account.BankAccount.__dict__:
        print('Correct: The __add__ method is defined.')
    else:
        print('ERROR: The __add__ method is not defined.')
        sys.exit(1)

    print('Creating account8 by adding account1 and account2.')
    account8 = account4 + account5
    print('account8 should be $14.24.')
    print('account8 is now %s.' % account8)

    print('\nCreating account9 by adding account4 and account6.')
    account9 = account4 + account6
    print('account9 should be $12.00.')
    print('account9 is now %s.' % account9)
    if str(account9) != '$12.00':
        print('ERROR in your __add__ method since account9 is not $12.00.')

    print('\nThe type returned from the __add__ method should be: ')
    print("   <class 'account.BankAccount'>")
    print('The type returned from the __add__ method is:')
    print("   " + str(type(account8)))

    print('\nTesting the __iadd__ method...')

    if '__iadd__' in account.BankAccount.__dict__:
        print('Correct: The __iadd__ method is defined.')
    else:
        print('ERROR: The __iadd__ method is not defined.')
        sys.exit(1)

    account6 += account5
    print('After adding account5 to account6, account6 should be $7.74.')
    print('account6 is now %s.' % account6)

    account3 += account4
    print('\nAfter adding account4 to account3, account3 should be $19.75.')
    print('account3 is now %s.' % account3)
    if str(account3) != '$19.75':
        print('ERROR in your __iadd__ method since account3 is not $19.75.')

    print('\nThe type returned from the __iadd__ method should be: ')
    print("   <class 'account.BankAccount'>")
    print('The type returned from the __iadd__ method is:')
    print("   " + str(type(account3)))

    print('\nEnd of testing for the BankAccount class.')

main()
