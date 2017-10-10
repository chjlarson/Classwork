# Christopher Larson
# CSCI 238 Homework #7, Problem #6
# 10/12/13
# test_rotate.py
#
# This program will test the rotate_left function.

def main():
    print('This program tests the rotate_left function.\n')

    print('Testing list1...')
    list1 = ['Cougars', 'Bulldogs', 'Unicorns', 'Matadors', 
        'Rangers', 'Panthers']
    rotated_list1 = ['Bulldogs', 'Unicorns', 'Matadors', 
        'Rangers', 'Panthers', 'Cougars']

    rotate_left(list1)
    print('Rotated list1 should be')
    print('  %s' % str(rotated_list1))
    print('Rotated list1 is')
    print('  %s' % str(list1))

    # Interestingly, the == operator works for comparing lists
    if list1 == rotated_list1:
        print('Correct: list1 was properly rotated')
    else:
        print('ERROR: list1 was not properly rotated')

    print('\nTesting list2...')
    list2 = [5, 2, 18, 7, -1, 4, 9, 11, 42]
    rotated_list2 = [2, 18, 7, -1, 4, 9, 11, 42, 5]
    
    rotate_left(list2)
    print('Rotated list2 should be')
    print('  %s' % str(rotated_list2))
    print('Rotated list2 is')
    print('  %s' % str(list2))

    if list2 == rotated_list2:
        print('Correct: list2 was properly rotated')
    else:
        print('ERROR: list2 was not properly rotated')

    print('\nTesting list3, the empty list...')
    list3 = []  # empty list
    rotate_left(list3)

    # If we get here without an exception, all should be OK
    if list3 == []:
        print('Correct: list3 was properly rotated')
    else:
        print("ERROR: Something isn't right with list3")

    print('\nEnd of testing for the rotate_left function.')

def rotate_left(num_list):
    if len(num_list) == 0:
        return
    element0 = num_list[0]
    del num_list[0]
    num_list.append(element0)
    return num_list

main()

