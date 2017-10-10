# robust_input.py

def main():
    try:
        num = float(input('\nEnter a number: '))
        print('The number is %.2f' % num)

    except ValueError:
        print('The input could not be converted.')

    print('\nNote that the program was able to continue')
    print('after the exception was caught.\n')

main()
