# Christopher Larson    
# CSCI 238 Homework #8, Problem #3
# test_unique.py
# 10/22/13
#
# This program will test the find_unique function.
def main():
    print('This program tests the find_unique function.\n')

    list1 = [3, 10, 7, 5, 10, 9, 5, 2, 5, 10]
    list1_unique = [3, 10, 7, 5, 9, 2]
    print('The unique elements of %s' % list1)
    print('should be %s.\n' % list1_unique)

    unique1 = find_unique(list1)
    print('The unique elements of %s' % list1)
    print('are %s.\n' % unique1)

    list2 = ['apple', 'banana', 'apple', 'pear', 'strawberry',
        'pineapple', 'strawberry', 'pineapple']
    list2_unique = ['apple', 'banana', 'pear', 'strawberry',
        'pineapple']

    print('The unique elements of [', end='')
    for i in range(4):
        print("'%s'" % list2[i], end=', ')
    print()
    for item in list2[4:len(list2)-1]:
        print("'%s'" % item, end=', ')
    print("'%s']" % list2[-1])
    print('should be %s.\n' % list2_unique)

    unique2 = find_unique(list2)
    print('The unique elements of [', end='')
    for i in range(4):
        print("'%s'" % list2[i], end=', ')
    print()
    for item in list2[4:len(list2)-1]:
        print("'%s'" % item, end=', ')
    print("'%s']" % list2[-1])
    print('are %s.\n' % unique2)

    # Want to make sure that the function works for the empty list
    list3 = []
    list3_unique = []
    unique3 = find_unique(list3)

    print('The unique elements of %s should be %s.' % (list3, list3_unique))
    print('The unique elements of %s are %s.\n' % (list3, unique3))

    print('This completes the testing of the find_unique function.')

def find_unique(list1):
    list2 = []
    for i in list1:
        if i not in list2:
            list2.append(i)
    return list2
        

main()
