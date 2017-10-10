# Christopher Larson
# CSCI 238 Homework #14, Problem #1
# learning_to_count.py
# 12/1/13
#
# This program will display a Gui with buttons for Incrementing
# and Decrementing a number by 1. 

from tkinter import *

class CounterGUI(object):
	def __init__(self):
		self.root = Tk()
		self.root.geometry('300x100')
		self.root.title('Counter GUI')
		self.__count = 0
		

		self.button_frame = Frame(self.root)
		self.increment = Button(self.button_frame, bg='yellow', 
        text='Increment', command=self.add_one)

		self.decrement = Button(self.button_frame, bg='yellow',
        text='Decrement', command=self.sub_one)

		self.count_var = StringVar()
		self.count_var.set('The count = 0')
		self.count_label = Label(self.root, textvariable=self.count_var)


		self.button_frame.pack(side='top', pady=10)
		self.increment.pack(side='left', padx=5)
		self.decrement.pack(side='right', padx=5)
		self.count_label.pack(side='bottom', pady=10)

		self.root.mainloop()

	def add_one(self):
		"""Increment count by 1."""
		self.__count += 1
		self.count_var.set('The count = %d' % self.__count) 

	def sub_one(self):
		"""Decrement count by 1."""
		self.__count -= 1
		self.count_var.set('The count = %d' % self.__count) 

def main():
	window = CounterGUI()
main()	
