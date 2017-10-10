# Christopher Larson & Robert Pitts
# CSCI 238 Lab18, Problem #2
# person_list.py
# 11/12/13
#
# Create and print a list of Person and Student objects.

import person

def main():
    
    friends = []
    robert = person.Student('Robert Pits', 'A001')
    friends.append(robert)
    kyle = person.Person('Kyle Smith')
    friends.append(kyle)
    chris = person.Student('Chris Larson', 'A002')
    friends.append(chris)
    john = person.Person('John Smith')
    friends.append(john)
    nikki = person.Student('Nikki Castillo', 'A003')
    friends.append(nikki)
    adam = person.Person('Adam Smith')
    friends.append(adam)

    for friend in friends:
        print(friend)
main()
