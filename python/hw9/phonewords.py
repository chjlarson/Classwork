# Christopher Larson
# CSCI 238 Homework #9. Problem #4
# phonewords.py
# 10/29/13
#
# This program will print the corresponding phone number according
# to the word input by the user.

def main():
    print('This program will print the phone number of the word entered.')

    phone_words = input('Enter the words: ')
    phone_num = []

    for char in phone_words:
        num = 0
        if char.isdigit():
            phone_num.append(char)
        elif char == '-':
            phone_num.append(char)
        elif char.isalpha():
            value = ord(char)
            if value in range(65, 68) or value in range(97, 100):
                num = '2'
            elif value in range(68, 71) or value in range(100, 103):
                num = '3'
            elif value in range(71, 74) or value in range(103, 106):
                num = '4'
            elif value in range(74, 77) or value in range(106, 109):
                num = '5'
            elif value in range(77, 80) or value in range(109, 112):
                num = '6'
            elif value in range(80, 84) or value in range(112, 116):
                num = '7'
            elif value in range(84, 87) or value in range(116, 119):
                num = '8'
            elif value in range(87, 91) or value in range(119, 123):
                num = '9'
            phone_num.append(num)
    result = ''.join(phone_num)
    print ('\nThe phone number for %s is %s.' %(phone_words,result))
            
main()            


            

