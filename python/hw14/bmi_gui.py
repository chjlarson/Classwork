# Christopher Larson
# CSCI 238 Homework #14, Problem #2
# bmi_gui.py
# 12/3/13
#
# this program computes the users Body Mass Index.

from tkinter import *

import tkinter.messagebox

class BmiGui(object):
    def __init__(self):
        self.root = Tk()
        self.root.geometry('300x150')
        self.root.title('BMI Calculator')

        self.frame = Frame(self.root)
        self.frame.pack(side='top')

        self.height_label = Label(self.frame,
            text='Enter your height in inches: ')
        self.height_label.grid(row=0, column=0)

        self.height_var = StringVar()
        self.height_entry = Entry(self.frame, width=6,
            textvariable=self.height_var)
        self.height_entry.grid(row=0, column=1)

        self.weight_label = Label(self.frame,
            text='Enter your weight in pounds: ')
        self.weight_label.grid(row=1, column=0)

        self.weight_var = StringVar()
        self.weight_entry = Entry(self.frame, width=6,
            textvariable=self.weight_var)
        self.weight_entry.grid(row=1, column=1)

        self.button_frame = Frame(self.root)
        self.button = Button(self.button_frame, text='Compute BMI',
                    command=self.compute_bmi)
        self.button_frame.pack(side='bottom')
        self.button.pack(side='bottom', pady='10')


        self.root.mainloop()

    # Method to be called when the user presses the button
    def compute_bmi(self):
        """Compute the BMI."""
        height = float(self.height_var.get())
        weight = float(self.weight_var.get())              
        bmi = (703 * weight) / (height ** 2)
        result = 'Yout BMI is %d' % bmi
        tkinter.messagebox.showinfo(title='BMI Result', \
                  message=result)
        self.height_var.set('')  
        self.weight_var.set('')  

def main():
    window = BmiGui()

main()
        
