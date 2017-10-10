def main():
    my_list = [3, 5, -1, 2, 7, 10, -3, 12]
    result = betty(my_list)
    print('The result is %d' % result)

def betty (num_list):
    if len(num_list) == 0:
        result = 0
    elif len(num_list) == 1:
        result = num_list[0]
    else:
        num1 =num_list[0]
        num2 = betty(num_list[1: ])

        if num1 < num2:
            result = num1
        else: 
            result = num2
    return result
main()

