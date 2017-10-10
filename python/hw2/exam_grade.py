# Christopher Larson
# CSCI 238 Homework #2, Problem #6
# exam_grade.py
# 9/11/13
#
# This program will show what the user will need to get on the final exam
# in order to get their desired letter grade for the course.

def main():
    print('We are going to figure out what grade you need to get \n' \
        + 'on the final in order to get the grade you want for the course. \n')
    letter_grade = input('Enter the desired letter grade: ')
    minimum_avg = float(input('Enter the minimum average required: '))
    current_avg = float(input('Enter the current average in the course: '))
    exam_percent = float(input('Enter how much the final counts as a \n' \
        + 'percentage of the course grade: '))
    result = exam(minimum_avg, current_avg, exam_percent)
    print()
    print(('You need a score of %.1f on the final \n' \
    + 'to get a %s in the course.') % (result, letter_grade))

def exam(min_avg, cur_avg, exam_per):
    exam_exact = exam_per / 100
    answer1 = (min_avg - ((1 - exam_exact) * cur_avg))
    answer2 = answer1 / exam_exact
    return answer2

main()
