# Christopher Larson
# CSCI 238 Homework #15, Problem #3
# 20th_century_presidents.py
# 12/9/13
#
# This program readsdata on U.S. presidents from a file and prints the years
# and names for those presidents who served in the 20th century. 

MIN_DATE = 1900
MAX_DATE = 2000

def main():
    print('\nThis program reads data on U.S. presidents from a file and prints')
    print('  the years and names for those who were in office')
    print('  during the 20th century.\n')

    try:
        in_file = open('presidents.txt', 'r')

        for line in in_file:
            items = line.split(None, 2)
            start_year = int(items[0])                
            end_year = int(items[1])
            president = items[2]

            if start_year >= MIN_DATE and start_year < MAX_DATE:
                print('%d - %d %s' % (start_year, end_year, president))

            elif end_year >= MIN_DATE and end_year < MAX_DATE:
                print('%d - %d %s' % (start_year, end_year, president))
    
        in_file.close()

    except IOError:
        print('Error: The file could not be opened')

    except ValueError:            
        print('Error: Date could not be converted.')
        in_file.close()

main()


