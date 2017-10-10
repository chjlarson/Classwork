# Christopher Larson
# CSCI 238 Homework #15, Problem #5
# binary_search.py
# 12/7/13
# 
# This program determines if a number is in a given list recursively. 

def main():
    print('This program demonstrates the binary search algorithm.\n')

    array = [2, 3, 8, 11, 15, 16, 21, 24, 35, 42]

    print('The list is = %s\n' % array)

    for target in [10, 2, 1, 16, 42, 7]:
        index = search(array, target)

        if index == -1:
            print('%d was not found in the list.' % target)
        else:
            print('%d was found at index %d.' % (target, index))


def search(a, target):
    return binary_search(a, target, 0, len(a)-1)

def binary_search(a, target, low, high):
    # NOTE that you are writing the IF for this function
    # and your definition MUST be recursive   
    if low <= high:
        mid = (low + high) // 2
        if target == a[mid]:
            return mid
        elif target < a[mid]:
            return binary_search(a, target, low, mid - 1)
        else:
            return binary_search(a, target, mid + 1, high)
    else:
        return -1 

main()
