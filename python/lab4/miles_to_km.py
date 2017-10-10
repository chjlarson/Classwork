# Christopher Larson
# CSCI 238 Lab#4 Problem #3
# miles_to_km.py
# 9-10-13

KM_PER_MILE = 1.60935

def main():
    print('This program converts a distance in ' \
        + 'miles to kilometers.\n')

    miles = float(input('Enter the distance in miles: '))
    kilometers = KM_PER_MILE * miles

    print('\n%.1f miles = %.1f kilometers' \
        % (miles, kilometers))
main()
