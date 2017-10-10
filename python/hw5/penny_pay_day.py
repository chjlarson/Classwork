# Christopher Larson    
# CSCI 238 Homework#5, Problem #6
# penny_pay_day.py
# 10/2/13
#
# This program will calculate how much you will be paid in pennies over a
# certain amount of time,

def main():
    print('This program computes the total salary earned after a given' \
    + '\nnumber of days, assuming that 1 penny is paid on the first day' \
    + '\nand the salary doubles each day.\n')
    pennies = 1
    count = 1
    num_days = int(input('Enter the number of days: '))
    print('\nDay     Pennies')
    print('---------------')
    for days in range(1, num_days+1):
        if days > 1:
            pennies *= 2
            count += pennies
        print('%3d     %d' % (days, pennies))  
    dollars = convert_change(count)
    print('\nAfter %d days, the total earned is $%.2f.' %(days, dollars))

def convert_change(count):
    return count / 100

main()
