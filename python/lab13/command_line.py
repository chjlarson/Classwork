# command_line.py
#
# Example to demonstrate command-line arguments

import sys

def main():
    print('The name of my program is %s.' % sys.argv[0]) 
    print('I have %d command-line arguments.' % len(sys.argv))
    
    print('\nMy command-line arguments are:')
    for arg in sys.argv:
        print(arg)

main()
