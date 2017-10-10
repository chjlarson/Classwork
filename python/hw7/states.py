# Christopher Larson    
# CSCI 238 Homework #7, Problem #4
# states.py
# 10/12/13
#
# This program will display the population and capital of which ever state the
# user inputs.

def main():
    print('This program reads state records from "states.txt".')
    print('Given a state name, I will tell you the population and capital.\n')
    state_input = input('Enter a state name: ')

    try:
        in_file = open('states.txt', 'r')
        found = False
        state_list = in_file.readline().rstrip('\n')
        while state_list != '' and not found:
            state = state_list
            city = in_file.readline().rstrip('\n')
            population = int(in_file.readline().rstrip('\n'))
            state_list = in_file.readline().rstrip('\n')
            if state == state_input:
                found = True
                print('\nThe population for %s is %d' % (state, population))
                print('and the capital is %s.' % city)
                in_file.close()
        if found == False:
            print('%s was not in the file' % state_input)

    except IOError:
        print('Error: Could not open file.')
    except ValueError:
        print('Error: Could not convert to int.')

main()
