# Christopher Larson
# CSCI 238 Homework #3, Problem #6
# water_bill.py
# 9/16/13
#
# This program will calculate and display the total charge for the water. 

MONTHLY_CHARGE = 16.3
DOLLARS_PER_GALLON = 2/1000

def main():
    print('\nWater Bill Calculator')
    print('\nTo calculate your water bill,')
    current_reading = int(input('Please enter current water meter reading: '))
    previous_reading = int(input('Please enter previous water meter reading: '))
    total = compute_charge(current_reading, previous_reading)
    print('\nYour total water bill comes out to $%.2f' %total)
    
def compute_charge(current_reading, previous_reading):
    num_gallons = (current_reading - previous_reading) * 100
    total_charge = (DOLLARS_PER_GALLON * num_gallons) + MONTHLY_CHARGE
    return total_charge

main()

