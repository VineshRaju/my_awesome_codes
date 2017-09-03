##
 # Author:    Vinesh Raju R
 # 
 # Copyright (c) 2017 Vinesh Raju R
 # A simple click and drag to draw application
##
from tkinter import *
#creating object for tkinter
tk=Tk()
#setting window title
tk.title("VinDraw")
#creating canvas of dimentions 800x600
canvas=Canvas(tk,width = 800,height = 600)
canvas.pack()
#oldX/Y is assigned to -1 because -ve does not exist in canvas
oldX=-1
oldY=-1
color="black"
lineWidth=1


def clear():

    global canvas
    canvas.delete(ALL)

                                                   
bClear= Button(tk,text="Clear",command=clear)
bClear .pack(side="right")


def erase():
    global color
    oldColor=color
    if color=="white":
        color="black"
    else:
        color="white"

bErase= Button(tk,text="Erase",command=erase)
bErase.pack(side="left")

def click(event):
    global oldX,oldY
    oldX=event.x
    oldY=event.y

canvas.bind("<Button-1>",click)


def wUp(event):
    global lineWidth
    lineWidth=lineWidth+1


canvas.bind_all("<KeyPress-Up>",wUp)

def wDwn(event):
    global lineWidth
    if lineWidth>0:
        lineWidth=lineWidth-1


canvas.bind_all("<KeyPress-Down>",wDwn)

def draw(event):
    global oldX,oldY,canvas,color,paint,lineWidth
    newX=event.x
    newY=event.y
    canvas.create_line(oldX,oldY,newX,newY,fill=color,width=lineWidth)
    oldX=newX
    oldY=newY
    newX=event.x
    newY=event.y
    
canvas.bind("<B1-Motion>",draw)

mainloop()

