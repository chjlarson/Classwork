# Christopher Larson
# CSCI 238 Homework #8, Problem #4
# top_sales.py
# 10/23/13
#
# This program determines the names of the top salespeople.

import sys

def main():
    if len(sys.argv) != 3:
        print('Usage: python top_sales.py sales_file num_people')
        sys.exit(1)

    filename = sys.argv[1]
    num_people = int(sys.argv[2])

    print(('This program determines the names of the top %d ' \
        + 'salespeople.\n') % num_people)

    name_list, sales_list = read_file(filename)

    top_names = find_top_salespeople(name_list, sales_list, num_people)

    num_returned = len(top_names)
    if num_returned > num_people:
        print('There were ties for the last position on the list.\n')
    elif num_returned < num_people:
        print('There were fewer than %d people in the file.\n' \
            % num_people)

    print('For the file %s, the top %d salespeople are:\n' \
        % (filename, num_returned))

    for i in range(num_returned):
        name = top_names[i]
        index = name_list.index(name)
        print('    %3d. %-24s $%10.2f' % ((i + 1), name, sales_list[index]))


def read_file(filename):
    """Read the file and return the name and sales lists.
    
    Terminate the program if the file cannot be opened."""

    name_list = []
    sales_list = []

    try:
        in_file = open(filename, 'r')
        name = in_file.readline().rstrip('\n')
        while name != '':
            name_list.append(name)
            sales = float(in_file.readline())
            sales_list.append(sales)
            name = in_file.readline().rstrip('\n')

        in_file.close()

        return name_list, sales_list

    except IOError:
        print('Could not open %s for reading.' % filename)
        sys.exit(1)  # cannot continue if this happens

def find_top_salespeople(name_list, sales_list, n):
    """Return names of the top n salespeople."""
    top_names = []
    temp_name = [] + name_list
    temp_sales = [] + sales_list

    while len(top_names) < n and len(temp_sales) != 0: 
        max_sales = temp_sales.index(max(temp_sales))
        num = temp_sales[max_sales]
        top_names.append(temp_name[max_sales])
        temp_name.remove(temp_name[max_sales])
        temp_sales.remove(temp_sales[max_sales])

        if num in temp_sales:
            max_sales2 = temp_sales.index(max(temp_sales))
            top_names.append(temp_name[max_sales2])
            temp_name.remove(temp_name[max_sales2])
            temp_sales.remove(temp_sales[max_sales2])

    return top_names
main()

