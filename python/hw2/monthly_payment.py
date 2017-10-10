# Christopher Larson
# CSCI 238 Homework#2 Problem #5
# monthly_payment.py
# 9/11/13
#
# This program will calculate the monthly payment of something.

def main():
    print('This will calculate how much your monthly payments will be. \n')
    principle = float(input('Enter the amount you are borrowing: '))
    annual_interest = float(input('Enter the annual' \
        + ' interest rate in percentage: '))
    months = int(input('Enter the total number of expected payments: '))
    monthly_payments = payments(principle, annual_interest, months)
    print(('At an annual interest rate of %.1f%%, your ' \
        + 'payments will be \n $%.2f per month for ' \
            + '%d months.')  % (annual_interest, monthly_payments, months))

def payments(num1, num2, num3):
    monthly_interest = num2 / (100 * 12)
    result = num1 * (monthly_interest / (1 - (1 + monthly_interest)**(- num3)))
    return result

main()
