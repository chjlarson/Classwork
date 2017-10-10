# pet.py

class Pet(object):

    # Put your constructor here

    # Put your accessor method for the name here

    def get_species(self):
        return self.__species

    def get_age(self):
        return self.__age

    # Put your mutator method for the name here

    def set_species(self, species):
        self.__species = species

    def set_age(self, age):
        self.__age = age

    # Put your string conversion method here

def main():
    pet1 = Pet('Duke', 'dog', 3)

    # The next line demonstrates saving the result of
    # a method call into a variable. The statements after that
    # show printing the results of the method calls directly.

    name1 = pet1.get_name() 
    print('My first pet is %s.' % pet1)
    print('The name of my pet is %s.' % name1) 
    print('The species of my pet is %s.' % pet1.get_species())
    print('The age of my pet is %s.' % pet1.get_age())

    print('\nChanging the name of %s...' % pet1)
    pet1.set_name('Butch')
    print('Correction: The name of my pet is %s.\n' \
        % pet1.get_name())

    pet2 = Pet('Misha', 'cat', 1)
    name2 = pet2.get_name()
    print('My friend has a pet named %s.' % name2)
    print('%s is a(n) %d-year-old %s.' \
        % (name2, pet2.get_age(), pet2.get_species()))


main()
