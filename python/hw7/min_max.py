# Christopher Larson 
# CSCI 238 Homework #7, Problem #3
# min_max.py
# 10/12/13
#
# This program will compute the min and max of a list set by the user and
# display both.

def main():
    print('This program will compute the min and max') 
    print('of the list you wish to open.')

    try:
        in_file = open(input('Enter the file name: '), 'r')

        initial = float(in_file.readline())
        max = initial
        min = initial

        for line in in_file:
            if float(line) > float(max):
                max = line
            if float(line) < float(min):
                min = line

        in_file.close()

        print('\nThe max number in the file was %s' % max)
        print('And the min number in the file was %s' % min) 


    except IOError:
        print('Error: Could not open file')
    except ValueError:
        print('Error: Could not convert string')
        in_file.close()

main()
