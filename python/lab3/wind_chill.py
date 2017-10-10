# Christopher Larson
# CSCI 238 Lab#3, Problem #3
# wind_chill.py

print('Given the temperature in Fahrenheit and the wind speed')
print('in mph, this program will determine the corresponding')
print('wind chill in Fahrenheit.\n')

actual_temperature = float(input('Enter the actual temperature: '))
wind_speed = float(input('Enter the wind speed: '))

wind_chill = 35.74 + 0.621 * actual_temperature \
    - 35.75 * wind_speed ** 0.16 \
    + 0.4275 * actual_temperature * wind_speed ** 0.16

print('\nFor an actual temperature of %d F and wind speed' \
    % actual_temperature)
print('of %d mph, the wind chill temperature is %d F.' \
    % (wind_speed, wind_chill))
