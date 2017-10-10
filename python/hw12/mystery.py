def main():
    name = input('Enter string: ')
    answer = m(name)
    print(answer)



def m(string):
    n = len(string)
    if n <=1:
        result = True
    elif string[0] != string[n-1]:
        result = False
    else:
        result = m(string[1: n-1])
    return result
main()
