# Christopher Larson
# CSCI 238 Homework #5, Problem #5
# population_estimation.py
# 10/2/13
#
# This program will estimate the growth of a population.

ORIG_POP = 26000

def main():
    print('\nWe are going to figure out the population size')
    growth_rate = float(input('Enter the percent growth rate: '))
    pop_goal = int(input('Enter the population goal: '))

    total_pop, years = population_calculation(growth_rate, pop_goal, ORIG_POP)
    print('%d years after 2011,' % years)
    print('the population is roughly %.0f people.' % total_pop)

def population_calculation(growth_rate, pop_goal, ORIG_POP):
    actual_rate = growth_rate / 100
    new_pop = (ORIG_POP * actual_rate) + ORIG_POP
    count = 1
    while new_pop < pop_goal:
        new_pop += actual_rate * new_pop
        count += 1
    return new_pop, count


main()
