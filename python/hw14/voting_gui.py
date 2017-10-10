# Christopher Larson
# CSCI 238 Homework #14, Problem #4
# voting_gui.py
# 12/4/13
#
# This program will create a gui that allows the user to vote for a who they
# want and will display the tallied votes in the dos window.


from tkinter import *
import tkinter.messagebox

MINNIE = 0
DONALD = 1
PORKY = 2

class VotingGUI(object):
    def __init__(self):
        self.root = Tk()
        self.root.geometry('300x175')
        self.root.title('Mayoral Election')

        self.__minnie_vote_count = 0
        self.__donald_vote_count = 0
        self.__porky_vote_count = 0

        self.candidate_frame = Frame(self.root)

        self.selection_var = IntVar()
        self.vote_minnie = Radiobutton(self.candidate_frame,
            text='Minnie Mouse', variable=self.selection_var, value=MINNIE)
        self.vote_donald = Radiobutton(self.candidate_frame, text='Donald Duck',
            variable=self.selection_var, value=DONALD)
        self.vote_porky = Radiobutton(self.candidate_frame, text='Porky Pig',
            variable=self.selection_var, value=PORKY)

        self.info_label = Label(self.root, 
            text='Please choose a candidate and press Submit')

        self.submit_button = Button(self.root, text='Submit',
            command=self.cast_vote)

        self.candidate_frame.pack(side='top')
        self.vote_minnie.pack(side='top', pady='2')
        self.vote_donald.pack(pady='2')
        self.vote_porky.pack(side='bottom', pady='2')
        self.info_label.pack(pady='10')
        self.submit_button.pack(side='bottom', pady='5')

        self.root.mainloop()

    def cast_vote(self):
        """Tally up votes."""
        candidate = self.selection_var.get()
        if candidate == MINNIE:
            self.__minnie_vote_count +=1
            result = 'Your vote for Minnie Mouse was cast.'
        elif candidate == DONALD:
            self.__donald_vote_count += 1
            result = 'Your vote for Donald Duck was cast.'
        else:
            self.__porky_vote_count += 1
            result = 'Your vote for Porky Pig was cast.'

        print('Minnie Mouse = %d, Donald Duck = %d, Porky Pig = %d'
            % (self.__minnie_vote_count, self.__donald_vote_count,
                self.__porky_vote_count))
        tkinter.messagebox.showinfo(title='Vote Recieved', message=result)

        self.selection_var.set(MINNIE)

def main():
    window = VotingGUI()

main()


