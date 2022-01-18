import pygame as py
import pygame
import random

width = 400
height = 400
fps = 60 


#color

Green = (0,255,0)
Red = (255,0,0)
Blue = (0,0,255)
Black = (0,0,0)
White = (255,255,255)

colors = [Green, Red, Blue,White]


display = pygame.display.set_mode([width,height])
pygame.display.set_caption("Window")

#clock 
clock = py.time.Clock()
run = True
timer = 0

#circle
x = 100
y = 100
raio = 10
flag = 1

#square
flag2 = 1

#line
a = 300
b = 100
altura = 380
flag3 = 1


#color
cor1 = 0
cor2 = 0
cor3 = 0
while(run):
    clock.tick(fps)  

    for event in pygame.event.get() :
        if event.type == pygame.QUIT:
            run = False
    display.fill(Black)
    #change color circle
    if(timer%5 == 0):
        cor1 = random.randint(0, 3)
    #change color (line,square)
    if(timer%35 == 0):
        cor2 = random.randint(0, 3)
        cor3 = random.randint(0, 3)
    pygame.draw.circle(display,colors[cor1],(x,y),raio)
    pygame.draw.rect(display,colors[cor2], pygame.Rect(30,30,60,60))
    pygame.draw.line(display,colors[cor3],(a,altura),(b,altura))

    if(flag3 == 1):
        altura-=1
        if(altura == 300):
            flag3 = 0
    else:
        altura+=1
        if(altura == 380):
            flag3 =1

    #translate circle
    if(flag2 == 1):
        x+=1
        y+=1
        if(x == 300):
            flag2 = 0
    else:
        x-=1
        y-=1
        if(x == 100):
            flag2 =1

    ##increase circle
    if(flag == 1):
        raio+=1
        if(raio == 100):
            flag = 0
    else:
        raio-=1
        if(raio == 0):
            flag = 1

    timer+=1
    pygame.display.update()
pygame.quit()