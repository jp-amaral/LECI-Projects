import pygame as py
import pygame
from pygame.draw import circle
## variaves
White = (255,255,255)
Black = (0,0,0)
width = 800
height = 800
##def
def printFigure(figura):
    if( type(figura).__name__ == "Circle" ):
        print("----- Circle -----")
        print(f" raio -> {figura.raio}")
        print(f" pos -> ({figura.x1},{figura.y1})")
        print(f" filled -> {figura.filled}")
        print(f" thickness -> {figura.thickness}")
        print(f" color -> {figura.color}")
        print(f" hidden -> {figura.hidden}")
        print("------------------")

class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

class line:
    def __init__(self, x1,y1,x2,y2):
        self.x1 = x1
        self.y1 = y1
        self.x2 = x2
        self.y2 = y2

class Circle:
    def __init__(self,x1,y1,raio):
        self.raio = raio
        self.x1 = x1
        self.y1 = y1
        self.hidden = False
        self.thickness = 1
        self.filled = False
        self.color = White


#setting
display = pygame.display.set_mode([width,height])
pygame.display.set_caption("Window")
clock = py.time.Clock()
fps = 60
run = True

##creat

circulo1 = Circle(400,400,200)
printFigure(circulo1)

while(run):
    clock.tick(fps)
    for event in pygame.event.get() :
        if event.type == pygame.QUIT:
            run = False
    display.fill(Black)

    pygame.draw.ellipse(display,circulo1.color,(100,100,400,200))
    pygame.draw.circle(display,circulo1.color,(circulo1.x1,circulo1.y1),circulo1.raio,circulo1.thickness)
    pygame.display.update()
    pygame.display.flip
pygame.quit()




