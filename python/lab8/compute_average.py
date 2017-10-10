# Christopher Larson
# CSCI 238 Lab#8 Problem #2
# compute_average.py
# 9/26/13
#
# This program will calculate the average of input numbers.

def main():
    print('Given a series of non-negative numbers, this program')
    print('will compute their average.\n')
    print('Enter a negative number to stop entering data.\n')

    sum = 0
    count = 0   # number of entries for computing the average

    num = float(input('Enter a number: '))
    while num > 0:
        count += 1
        sum += num
        num = float(input('Enter a number: '))
    if sum == 0:
        average = 0
    else:
        average = sum / count
    print('The average is %.2f' % average)

main()
