# Christopher Larson
# CSCI 238 Homework #4, Problem #3
# service_fees.py
# 9/25/13
#
# This program will compute and display the Bulldog Bank's monthly service fee
# for checking accounts

BASIC_FEE = 2


def main():
    print('\nTo calculate the monthly service fees for checking accounts, ')
    check_num = int(input('Please input the number of checks made out' \
        + ' this month '))
    total = compute_service_fee(check_num)
    print('\nThe total service fee comes out to $%.2f.' % total)

def compute_service_fee(check_num):
    if check_num <= 10:
        result = BASIC_FEE
    else:
        result = BASIC_FEE + (.1 * (check_num - 10))
    return result

main()
