# CSCI 238 Homework #14, Problem #3
# bmi.py
# 12/3/13
#
# This program computes the user's Miles Per Gallon.

from tkinter import *

class MPGGUI(object):
    
    def __init__(self):
        self.root = Tk()
        self.root.geometry('350x300')
        self.root.title('Miles Per Gallon')
       
        self.miles_label = Label(self.root, text='Miles')
        self.gallons_label = Label(self.root, text='Gallons')

        self.miles_var = StringVar()
        self.miles_entry = Entry(self.root, textvariable=self.miles_var)

        self.gallons_var = StringVar()
        self.gallons_entry = Entry(self.root, textvariable=self.gallons_var)
       
        self.button = Button(self.root, text='Compute MPG',
            command=self.compute_mpg)

        self.result_var = StringVar()
        self.mpg_label = Label(self.root, textvariable=self.result_var) 

        self.miles_label.pack(side='top', pady='10')
        self.miles_entry.pack(side='top', pady='10')
        self.gallons_label.pack(side='top',pady='10')
        self.gallons_entry.pack(side='top', pady='10')
        self.button.pack(side='top', pady='5')
        self.mpg_label.pack(side='top', pady='10')

        self.root.mainloop()

    def compute_mpg(self):
        """Compute how many miles can be travelled per gallon."""
        miles = float(self.miles_var.get())
        gallons = float(self.gallons_var.get())
        result = miles / gallons
        self.result_var.set('%.1f miles / %.1f gallons = %.1f miles per gallon.'
            % (miles, gallons, result))

        self.miles_var.set('')
        self.gallons_var.set('')
    
def main():
    window = MPGGUI()
main()
