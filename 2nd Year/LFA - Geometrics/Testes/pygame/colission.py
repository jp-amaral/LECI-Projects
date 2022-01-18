from typing import overload
import pygame as py
import pygame
import random
class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

#fucao
def doOverlap(l1, r1, l2, r2):
    # To check if either rectangle is actually a line
      # For example  :  l1 ={-1,0}  r1={1,1}  l2={0,-1}  r2={0,1}
    if (l1.x == r1.x or l1.y == r2.y or l2.x == r2.x or l2.y == r2.y):
        # the line cannot have positive overlap
        return False
    # If one rectangle is on left side of other
    if(l1.x >= r2.x or l2.x >= r1.x):
        return False
    # If one rectangle is above other
    if(l1.y <= r2.y or l2.y <= r1.y):
        return False
    return True
#ecra
width = 400
height = 400

#color
Green = (0,255,0)
Red = (255,0,0)
Black = (0,0,0)

#settings
display = pygame.display.set_mode([width,height])
pygame.display.set_caption("Window")
run = True
clock = py.time.Clock()
a = True
print(a)
random = random.randint(1, 10)
print(random)
while(run):
    clock.tick(10) 
    eventos = pygame.event.get()
    try:
        if(eventos[0].type == 32787):
            run = False
    except:
        pass
    ###############################################
    try:
        if eventos[0].type == pygame.KEYDOWN and eventos[0].key == pygame.K_1:
            #stat
            print("A")
            #stat
    except:
        pass
     ###############################################
    try:
        if eventos[0].type == pygame.KEYDOWN and eventos[0].key == pygame.K_b:
             #stat
            print("B")
            #stat
    except:
        pass

    display.fill(Black)
    ## draw 1 rectangles
    pygame.display.update()
    pygame.display.flip
pygame.quit()