# Christopher Larson
# CSCI 238 Homework #7, Problem #5
# grade_avg.py
# 10/12/13
#
# This program will compute the average of grades after taking out the lowest
# one.

def main():
    print('Please input grades one at a time and in the end')
    print('the program will drop the lowest grade and calculate the average') 
    print('When you are finished, just input a negative number')

    count = 0
    low_grade = float(input('Enter grade: '))
    grade = float(input('Enter next grade: '))
    sum = low_grade
    while grade >= 0:
        if grade < low_grade:
            low_grade = grade
        sum += grade
        count += 1
        grade = float(input('Enter next grade: '))
    average = (sum - low_grade) / count
    print('The average grade is %.1f' % average)

main()
