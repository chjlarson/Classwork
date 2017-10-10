# Christopher Larson
# CSCI 238 Homework #4, Problem #4
# computing_bmi.py
# 9/25/13
#
# This program will calculate a healthy weight and fitness goals

def main():
    print("\n\tWelcome to the Bulldog Health Club's Body Mass Index! \n" \
        + 'To determine where you fall in the BMI, \n')
    weight = float(input('Please enter your current weight in pounds: '))
    height = float(input('Please enter your current height in inches: '))
    total = compute_bmi(weight, height)
    if total < 18.5:
        result = 'Underweight'
    elif total < 25:
        result = 'Normal'
    elif total < 30:
        result = 'Overweight'
    else:
        result = 'Obese'
    print('\n%-15s %s' %('BMI Level', 'Weight Status'))
    print('%-15.2f %s' %(total, result))

def compute_bmi(weight, height):
    result = (703 * weight) / (height ** 2)
    return result

main()
