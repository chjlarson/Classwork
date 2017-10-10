import getpass
import sys
import datetime
import os

if os.name == 'posix':
    print('*-----------------------------------------------*')
    print('*                                               *')
    print('*    Welcome to the CSCI 238 mystery program    *')
    print('*                                               *')
    print('*-----------------------------------------------*\n')

    full_name = input('Please enter your full name: ')
    name = full_name.split()
    print('\nWelcome to CSCI 238,', name[0] + '!', end=' ')
    print(' Your username is ' + getpass.getuser() + '.')

    program = sys.argv[0].split('/')[-1]
    print('You are currently running the "%s" program.' \
         % program)

    now = datetime.datetime.today()
    print(now.strftime('\nToday is %A, %B %d, %Y.  It is currently %I:%M %p.\n'))

    print('Here is an appropriate quotation for this course:\n')

    print('  "Writing good code has much in common ' \
        + 'with writing good English."')
    print('  --- Brian Kernighan and Rob Pike, ' \
        + '"The Practice of Programming"\n')

    print('Good luck, and remember to see Dr. Wilson if you have any questions.')

else:
    print("""\nERROR:  You must run this program on the tlustdunix system!
        You have NOT completed this problem successfully.
        Read the instructions very carefully, and try again.""")
