# Christopher Larson    
# CSCI 238 Homework #8, Problem #1
# top_names.py
# 10/19/13
#
# This program will display the top n names of both girls and boys.

import sys

def main():
    if len(sys.argv) != 2:
        print('Usage: python top_names.py num_names')
        sys.exit()
    try:
        argument = int(sys.argv[1])
        if argument < 0 or argument > 1000:
            raise ValueError

        print('This program will list out the top %d' % argument)
        print('boy and girl names of 2012.\n')
        print('%-12s %-1s' %('BOYS', 'GIRLS'))
    
        in_file = open('boynames2012.txt' , 'r')
        out_file = open('girlnames2012.txt' , 'r')

        boys = in_file.readline().rstrip('\n')
        girls = out_file.readline().rstrip('\n')
        count = 0

        while count != argument:
            print('%-12s %-1s' % (boys , girls))
            boys = in_file.readline().rstrip('\n')
            girls = out_file.readline().rstrip('\n')
            count += 1
        in_file.close()
        out_file.close()

    except IOError:
        print('Error: Could not open file.')

    except ValueError:
        print('Usage: python top_names.py num_names')
        sys.exit()
main()
