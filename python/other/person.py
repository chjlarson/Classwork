# Christopher Larson & Robert Pitts
# CSCI 238 Lab18, Problem #2
# person.py
# 11/12/13

# Example to demonstrate inheritance
# This example is missing docstrings.  :-(

class Person(object):

    def __init__(self, name='unnamed'):
        self.__name = name

    def get_name(self):
        return self.__name

    def set_name(self, name):
        self.__name = name

    def __eq__(self, other):
        return self.__name == other.__name

    def __str__(self):
        return self.__name


class Student(Person):

    def __init__(self, name, id):
        Person.__init__(self, name)
        self.__id = id
  
    def get_id(self):
        return self.__id

    def set_id(self, id):
        self.__id = id

    def __eq__(self, other):
        return Person.__eq__(self, other) and self.__id == other.__id

    def __str__(self):
        return '%s (ID %s) ' \
            % (Person.__str__(self), self.__id)

def main():
    print('Simple example to demonstrate inheritance' \
        + 'with a person and a student.\n')
    
    albus = Person('Albus Dumbledore')
    minerva = Person('Minerva McGonagall')
    severus = Person('Severus Snape')
    harry1 = Student('Harry Potter', 1243250)
    harry2 = Student('Harry Potter', 243259)
    ron1 = Student('Ron Weasley', 'E2342')
    ron2 = Student('Ron Weasley', 'E2342')
    hermione = Student('Hermione Granger', 'E2349')

    print('Person object: %s' % albus)
    print('Person object: %s' % minerva)
    print('Person object: %s' % severus)
    print('Student object: %s' % harry1)
    print('Student object: %s' % harry2)
    print('Student object: %s\n' % ron1)
        
    if isinstance(albus, Person):
        print('%s is a Person.' % albus)
    else:
        print('%s is NOT a Person.' % albus)
    if isinstance(albus, Student):
        print('%s is a Student.' % albus)
    else:
        print('%s is NOT a Student.' % albus)

    if isinstance(hermione, Person):
        print('%s is a Person.' % hermione)
    else:
        print('%s is NOT a Person.' % hermione)
    if isinstance(hermione, Student):
        print('%s is a Student.\n' % hermione)
    else:
        print('%s is NOT a Student.\n' % hermione)
   
    if ron1 == ron2:
        print('%s == %s' % (ron1, ron2))
    else:
        print('%s != %s' % (ron1, ron2))

    if albus == ron2:
        print('%s == %s' % (albus, ron2))
    else:
        print('%s != %s' % (albus, ron2))

    if hermione == ron2:
        print('%s == %s' % (hermione, ron2))
    else:
        print('%s != %s' % (hermione, ron2))

    if harry1 == harry2:
        print('%s == %s' % (harry1, harry2))
    else:
        print('%s != %s' % (harry1, harry2))

    if albus == minerva:
        print('%s == %s' % (albus, minerva))
    else:
        print('%s != %s' % (albus, minerva))

if __name__ == '__main__':
    main()
