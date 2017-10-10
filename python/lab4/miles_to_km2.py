# Christopher Larson
# CSCI 238 Lab #4 Problem #5
# miles_to_km2.py
# 9-10-13

KM_PER_MILE = 1.60935

def main():
    print('This program converts a distance in ' \
        + 'miles to kilometers.\n')

    miles = float(input('Enter the distance in miles: '))
    kilometers = miles_to_kilometers(miles)

    print('\n%.1f miles = %.1f kilometers' \
        % (miles, kilometers))

def miles_to_kilometers(miles):
    kilometers = KM_PER_MILE * miles
    return kilometers

main()
