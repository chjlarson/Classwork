# current_calendar.py

import datetime
import calendar

def main():
    print('Chris Larson')
    print('\n\tThis program prints the calendar for the current year.\n\n')

    today = datetime.date.today()
    year = int(today.strftime('%Y'))
    print(calendar.calendar(year))

    print('\t******************************************************')

main()
