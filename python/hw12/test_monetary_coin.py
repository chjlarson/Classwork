# test_monetary_coin.py

import coin

def main():
    print('This program tests the MonetaryCoin class.\n')

    coin1 = coin.MonetaryCoin(1)
    coin2 = coin.MonetaryCoin(5)
    coin3 = coin.MonetaryCoin(10)

    print('coin1 = %s' % coin1)
    print('coin2 = %s' % coin2)
    print('coin3 = %s\n' % coin3)

    print('coin1 should have the value 1.')
    print('coin1 has the value %d.' % coin1.get_value())
    print('coin2 should have the value 5.')
    print('coin2 has the value %d.' % coin2.get_value())
    print('coin3 should have the value 10.')
    print('coin3 has the value %d.\n' % coin3.get_value())

    if isinstance(coin1, coin.Coin):
        print('Correct: a MonetaryCoin is also a Coin')
    else:
        print('ERROR: a MonetaryCoin should also be a Coin')

    if coin1.is_heads() and (str(coin1) == coin.HEADS + ', 1') \
        or not coin1.is_heads() and (str(coin1) == coin.TAILS + ', 1'):
        print('Correct: format for string conversion method\n')
    else:
        print('\nERROR: Incorrect format for string conversion method')

    # Following code demonstrates that MonetaryCoin
    # inherits the toss method of the Coin class

    print('Demonstrating that a MonetaryCoin can be tossed\n')
    print('Tossing coin1 10 times...')
    for i in range(10):
        print('coin1 now has the face value %s' % coin1.toss())

    print('\nTesting the error checking in the constructor\n')
    try:
        print('Should get a ValueError for a parameter of 0')
        coin6 = coin.MonetaryCoin(0)
        print('ERROR: Did not get a ValueError exception')
    except ValueError:
        print('Correct: Caught a ValueError exception')
    except Exception:
        print('ERROR: Caught the wrong kind of exception')

    try:
        print('\nShould get a ValueError for a negative parameter')
        coin6 = coin.MonetaryCoin(-1)
        print('ERROR: Did not get a ValueError exception')
    except ValueError:
        print('Correct: Caught a ValueError exception')
    except Exception:
        print('ERROR: Caught the wrong kind of exception')

    print('\nTesting the error checking in set_value\n')
    try:
        print('Should get a ValueError for a parameter of 0')
        coin1.set_value(0)
        print('ERROR: Did not get a ValueError exception')
    except ValueError:
        print('Correct: Caught a ValueError exception')
    except Exception:
        print('ERROR: Caught the wrong kind of exception')

    try:
        print('\nShould get a ValueError for a negative parameter')
        coin1.set_value(-1)
        print('ERROR: Did not get a ValueError exception')
    except ValueError:
        print('Correct: Caught a ValueError exception')
    except Exception:
        print('ERROR: Caught the wrong kind of exception')

    
main()
