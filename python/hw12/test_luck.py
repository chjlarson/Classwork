def main():
    num = float(input('Enter a number: '))
    answer = is_lucky(num)
    print(answer)

def is_lucky(num):
    if num % 10 == 8:
        result = True
    else:
        result = is_lucky(num // 10)
    return result
main()
