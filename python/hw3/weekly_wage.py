# Christopher Larson
# CSCI 238 Homework #3, Problem #5
# weekly_wage.py
# 9/16/13
#
# This program takes the hours worked and hourly wage
# and computes the corresponding weekly page.

OVERTIME_MIN_HOURS = 40
OVERTIME_MULTIPLIER = 1.5

def main():
    print('Given the hours worked and hourly wage, this program')
    print('computes the weekly pay, including any overtime earned.\n')

    hours_worked = float(input('Enter the hours worked: '))
    hourly_wage = float(input('Enter the hourly wage: $'))

    total_pay = compute_pay(hours_worked, hourly_wage)

    print('\nFor %.1f hours at $%.2f per hour, the pay is $%.2f.' \
        % (hours_worked, hourly_wage, total_pay))

def compute_pay(total_hours, hourly_wage):
    if total_hours > OVERTIME_MIN_HOURS:
        pay = OVERTIME_MIN_HOURS * hourly_wage \
            + (total_hours - OVERTIME_MIN_HOURS) * OVERTIME_MULTIPLIER \
            * hourly_wage
    else:
        pay = total_hours * hourly_wage
    return pay

main()
