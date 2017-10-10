# Christopher Larson
# CSCI 238 Homework #7, Problem #5
# modified_average.py
# 10/12/13
#
# This program computes the average for a series of grades
# after dropping the lowest grade.

SENTINEL = -1

def main():
    print('This program computes an average grade after')
    print('dropping the lowest grade.\n')

    print('Please enter grades, terminating grade entry by ' \
        + 'entering %d.\n' % SENTINEL)

    grades = enter_grades()

    if len(grades) > 0:
        average = modified_average(grades)
        print('\nAfter dropping the lowest grade, the average is %.1f.' \
            % average)
    else:
        print('\nCould not compute an average because you did not enter ' \
            + 'any valid grades.')

def enter_grades():
    """Return a list of grades entered by the user."""
    grade_list = []

    grade = float(input('Enter a grade (%d to end): ' % SENTINEL))
    while grade != SENTINEL:
        grade_list.append(grade)
        grade = float(input('Enter a grade (%d to end): ' % SENTINEL))

    return grade_list

def modified_average(grades):
    """Return the average of the list entered by the user minus lowest grade"""
    grades.sort()
    del grades[0]
    count = len(grades)
    sum = 0
    for num in grades:
        sum += num
    average = sum / count
    return average
main()
