# Christopher Larson
# CSCI 238 Homework #8, Prooblem #2
# test_median.py
# 10/19/13
# 
# This program will test the median function.

def main():
    print('This program tests the median function.\n')

    list1 = [4, 7, 1, 8]
    list2 = [1, 6, 2, 5, 12]
    list3 = [42, 37, 82, 19, 76, 29]
    list4 = [5, 2, 4, 17, 55, 4, 3, 26, 18, 2, 17]
    list5 = [2.75, 6.5, 8.5, 11.5, 12.4, 6.0, 7.25]

    list1_orig = [] + list1

    # The output will show if the function modifies the original list

    print('The list %s should have a median of 5.5.' % list1)
    median1 = median(list1)
    print('The list %s has a median of %.1f.' % (list1, median1))

    if list1 != list1_orig:
        print('ERROR: The function modified the list.')

    print('\nThe list %s should have a median of 5.0.' % list2)
    median5 = median(list2)
    print('The list %s has a median of %.1f.' % (list2, median5))

    print('\nThe list %s should have a median of 39.5.' % list3)
    median3 = median(list3)
    print('The list %s has a median of %.1f.' % (list3, median3))

    print('\nThe list %s should have a median of 5.0.' % list4)
    median4 = median(list4)
    print('The list %s has a median of %.1f.' % (list4, median4))

    print('\nThe list %s should have a median of 7.25.' % list5)
    median2 = median(list5)
    print('The list %s has a median of %.2f.' % (list5, median2))

def median(list):
    """Return the median of the given list"""
    num_list = [] + list
    num_list.sort()
    if len(num_list) % 2 == 1:
        median = num_list[len(num_list) // 2]
    else:
        num1 = num_list[len(num_list) // 2]
        num2 = num_list[len(num_list) // 2 - 1]
        median = (num1 + num2) / 2
    return median
main()
