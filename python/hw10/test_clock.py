# test_clock.py

import clock

def main():
    print('This program tests the Clock class.\n')

    print('Testing the constructor and __str__ method...\n')

    time1 = clock.Clock()
    time2 = clock.Clock(0, 0)
    time3 = clock.Clock(23, 59)
    time4 = clock.Clock(1, 2)

    print('time1 should be 00:00.')
    print('time1 is %s.\n' % time1)
    print('time2 should be 00:00.')
    print('time2 is %s.\n' % time2)
    print('time3 should be 23:59.')
    print('time3 is %s.\n' % time3)
    print('time4 should be 01:02.')
    print('time4 is %s.\n' % time4)

    # If the user running this test program pays close
    # attention to the output, the following test is not
    # necessary.  However, I'm including it to help
    # students who might not be reading the output carefully.

    string1 = str(time1)
    string4 = str(time4)
    if string1 == '00:00':
        print('Correct:  The __str__ method returns 00:00 for time1.')
    else:
        print('ERROR: Your __str__ method has the incorrect formatting.')
    if string4 == '01:02':
        print('Correct:  The __str__ method returns 01:02 for time4.')
    else:
        print('ERROR: Your __str__ method has the incorrect formatting.')

    print('\nTesting the accessor methods...\n')
    print('time1 should be 0 hours and 0 minutes.')
    print('time1: %d hours and %d minutes.' % (time1.get_hour(), \
        time1.get_minute()))
    print('time3 should be 23 hours and 59 minutes.')
    print('time3: %d hours and %d minutes.' % (time3.get_hour(), \
        time3.get_minute()))
    print('time4 should be 1 hour and 2 minutes.')
    print('time4: %d hour and %d minutes.\n' % (time4.get_hour(), \
        time4.get_minute()))

    print('Testing the error checking in the constructor...\n')

    print('Attempting to set time1 = clock.Clock(24, 1)')
    try:
        time1 = clock.Clock(24, 1)
        print('ERROR: No exception was thrown from the constructor.')
    except ValueError:
        print('Correct: ValueError was thrown from the constructor.')
    except Exception:
        print('ERROR: Wrong exception type thrown from the constructor.')

    print('Attempting to set time1 = clock.Clock(1, 60)')
    try:
        time1 = clock.Clock(1, 60)
        print('ERROR: No exception was thrown from the constructor.')
    except ValueError:
        print('Correct: ValueError was thrown from the constructor.')
    except Exception:
        print('ERROR: Wrong exception type thrown from the constructor.')

    print('Attempting to set time1 = clock.Clock(-1, 1)')
    try:
        time1 = clock.Clock(-1, 1)
        print('ERROR: No exception was thrown from the constructor.')
    except ValueError:
        print('Correct: ValueError was thrown from the constructor.')
    except Exception:
        print('ERROR: Wrong exception type thrown from the constructor.')

    print('Attempting to set time1 = clock.Clock(1, -1)')
    try:
        time1 = clock.Clock(1, -1)
        print('ERROR: No exception was thrown from the constructor.')
    except ValueError:
        print('Correct: ValueError was thrown from the constructor.')
    except Exception:
        print('ERROR: Wrong exception type thrown from the constructor.')

    print('\nTesting the set_time method...\n')

    time1.set_time(23, 59)
    time2.set_time(1, 1)
    time3.set_time(0, 0)
    time4.set_time(0, 59)

    print('After calling time1.set_time(23, 59), time1 = %s.' \
        % time1)
    print('After calling time2.set_time(1, 1),   time2 = %s.' \
        % time2)
    print('After calling time3.set_time(0, 0),   time3 = %s.' \
        % time3)
    print('After calling time4.set_time(0, 59),  time4 = %s.' \
        % time4)

    print('\nChecking set_time for error situations...\n')

    print('Attempting to call time1.set_time(24, 0)')
    try:
        time1.set_time(24, 0)
        print('ERROR: No exception was thrown from set_time.')
    except ValueError:
        print('Correct: ValueError was thrown from set_time.')
    except Exception:
        print('ERROR: Wrong exception type thrown from set_time.')

    print('Attempting to call time1.set_time(-1, 59)')
    try:
        time1.set_time(-1, 59)
        print('ERROR: No exception was thrown from set_time.')
    except ValueError:
        print('Correct: ValueError was thrown from set_time.')
    except Exception:
        print('ERROR: Wrong exception type thrown from set_time.')

    print('Attempting to call time1.set_time(5, 60)')
    try:
        time1.set_time(5, 60)
        print('ERROR: No exception was thrown from set_time.')
    except ValueError:
        print('Correct: ValueError was thrown from set_time.')
    except Exception:
        print('ERROR: Wrong exception type thrown from set_time.')

    print('Attempting to call time1.set_time(12, -1)')
    try:
        time1.set_time(12, -1)
        print('ERROR: No exception was thrown from set_time.')
    except ValueError:
        print('Correct: ValueError was thrown from set_time.')
    except Exception:
        print('ERROR: Wrong exception type thrown from set_time.')

    print('\ntime1 is currently %s.' % time1)
    print('Testing increment_minute on time1...')
    print('Expected sequence is 00:00, 00:01, 00:02.')
    time1.increment_minute()
    print('After first increment,  time1 = %s.' % time1)
    time1.increment_minute()
    print('After second increment, time1 = %s.' % time1)
    time1.increment_minute()
    print('After third increment,  time1 = %s.' % time1)

    time1.set_time(12, 30)
    print('\ntime1 has been changed to %s.' % time1)
    print('Testing increment_hour on time1...')
    print('Expected sequence is 13:30, 14:30, 15:30.')
    time1.increment_hour()
    print('After first increment,  time1 = %s.' % time1)
    time1.increment_hour()
    print('After second increment, time1 = %s.' % time1)
    time1.increment_hour()
    print('After third increment,  time1 = %s.' % time1)


    print('\nTesting the existence of the __eq__ method...')
    
    # You are not expected to understand the following 
    # if/else statement
    if '__eq__' in clock.Clock.__dict__:
        print('Correct: The __eq__ method is defined.')
    else:
        print('ERROR: The __eq__ method is not defined.')

    time1.set_time(10, 20)
    time2.set_time(11, 20)
    time3.set_time(10, 21)
    time4.set_time(10, 20)

    print('\nTesting the __eq__ method...')

    if time1 == time4:
        print('Correct: %s == %s' % (time1, time4))
    else:
        print('ERROR: %s != %s' % (time1, time4))
    if time1 == time2:
        print('ERROR: %s == %s' % (time1, time2))
    else:
        print('Correct: %s != %s' % (time1, time2))
    if time1 == time3:
        print('ERROR: %s == %s' % (time1, time3))
    else:
        print('Correct: %s != %s' % (time1, time3))
    if time2 != time4:
        print('Correct: %s != %s' % (time2, time4))
    else:
        print('ERROR: %s == %s' % (time2, time4))

    print('\nEnd of testing for the Clock class.')

main()
