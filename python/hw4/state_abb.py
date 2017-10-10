# Christopher Larson
# CSCI 238 Homework #4, Extra Credit
# state_abb.py
# 9/25/13
#
# This program will determine given state abbreviations.

def main():
    print('\n\tHello, we are going to figure out which abbreviations' \
        + ' go with' + '\nwhich state.')
    state_abb = input('Please enter either TX, OK, LA, or NM: ')
    state = compute_state(state_abb)
    print('The state you abbreviated is %s.' %state)

def compute_state(state_abb):
    if state_abb == 'TX':
        result = 'Texas'
    elif state_abb == 'OK':
        result = 'Oklahoma'
    elif state_abb == 'LA':
        result = 'Louisiana' 
    elif state_abb == 'NM':
        result = 'New Mexico'
    else:
        result = 'an invalid state'
    return result


main()
