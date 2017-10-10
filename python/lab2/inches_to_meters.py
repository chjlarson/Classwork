# Christopher Larson 
# inches_to_meters.py

INCHES_PER_METER = 39.37

print('Given a value in inches, this program will compute the')
print('corresponding value in meters.')
print()

inches = float(input('Enter the value in inches: '))
meters = inches / INCHES_PER_METER

print()
print(inches, 'inches =', meters, 'meters')
