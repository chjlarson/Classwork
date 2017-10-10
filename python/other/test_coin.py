import coin

def main():

    count = 0 
    my_coin = coin.Coin()
    while my_coin.is_heads():
        print(my_coin.get_sideup())
        count +=1
        my_coin.toss()

    print(my_coin.get_sideup())
    print('The count was %d' % count)
main()
