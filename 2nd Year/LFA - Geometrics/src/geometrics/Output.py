#!/usr/bin/python3
import pygame as py
import pygame
import random
import math

pygame.font.init()

fps = 100 
clock = py.time.Clock()
run = True
drawstringlllll_ = False

WHITE_ = (255,255,255)
BLACK_ = (0,0,0)
BLUE_ = (0,0,255)
YELLOW_ = (255,255,0)
RED_ = (255,0,0) 
GREEN_ = (0,255,0)
GRAY_ = (155,155,155)
ORANGE_ = (255,128,0)
PURPLE_ = (128,0,128)


class Circle:
    def __init__(self,x,y,r):
        self.r = r
        self.x = x
        self.y = y
        self.hidden = False
        self.thickness = 1
        self.filled = False
        self.color = WHITE_

    def translate(self,x,y):
        self.x = self.x + x
        self.y = self.y  + y

    def rotate(self, angle, xc, yc):
        angle = math.radians(angle)
        cos = math.cos(angle)
        sin = math.sin(angle)
        temp =  (self.x-xc)*cos - (self.y-yc)*sin + xc
        self.y = (self.x-xc)*sin + (self.y-yc)*cos + yc
        self.x = temp

    def collideEdge(self, sizex, sizey):
        p1 = self.x+self.r
        p2 = self.y+self.r
        p3 = self.x-self.r
        p4 = self.y-self.r
        if(p1 >= sizex or p2 >= sizey or p3 <= 0 or p4 <= 0):
            return True
        else:
            return False

    def getRect(self):
        if (self.hidden == False):
            return pygame.Rect(self.x - self.r + 0.25*self.r, self.y - self.r + self.r*0.25, self.r*2 - self.r*0.25, self.r*2 - self.r*0.25)

    def update(self):
        self.x = self.x
        self.y = self.y
        self.r = self.r

class Line:
    def __init__(self, x1,y1,x2,y2):
        self.x1 = x1
        self.y1 = y1
        self.x2 = x2
        self.y2 = y2
        self.color = WHITE_
        self.hidden = False
        self.thickness = 1
        self.distance = math.floor(math.dist([self.x1, self.y1], [self.x2, self.y2]))

    def translate(self, x, y):
        self.x1 = self.x1 + x
        self.x2 = self.x2 + x
        self.y1 = self.y1 + y
        self.y2 = self.y2 + y

    def rotate(self, angle, xc, yc):
        angle = math.radians(angle)
        cos = math.cos(angle)
        sin = math.sin(angle)
        temp =  (self.x2-xc)*cos - (self.y2-yc)*sin + xc
        self.y2 = (self.x2-xc)*sin + (self.y2-yc)*cos + yc
        self.x2 = temp
        temp =  (self.x1-xc)*cos - (self.y1-yc)*sin + xc
        self.y1 = (self.x1-xc)*sin + (self.y1-yc)*cos + yc
        self.x1 = temp

    def collideEdge(self, sizex, sizey):
        if(self.x1 >= sizex or self.x1 <= 0 or self.x2 >= sizex or self.x2 <= 0 or self.y1 >= sizey or self.y1 <= 0 or self.y2 >= sizey or self.y2 <= 0):
            return True
        else:
            return False

class Square:
    def __init__(self, x, y, w, h):
        self.x1 = x
        self.y1 = y
        self.x2 = x+w
        self.y2 = y
        self.x3 = x+w
        self.y3 = y+h
        self.x4 = x
        self.y4 = y+h
        self.w = w
        self.h = h
        self.points = ((self.x1,self.y1),(self.x2,self.y2),(self.x3,self.y3),(self.x4,self.y4))
        self.color = WHITE_
        self.hidden = False
        self.filled = False
        self.thickness = 1

    def translate(self, x,y):
        self.x1 = self.x1 + x
        self.y1 = self.y1 + y
        self.x2 = self.x2 + x
        self.y2 = self.y2 + y
        self.x3 = self.x3 + x
        self.y3 = self.y3 + y
        self.x4 = self.x4 + x
        self.y4 = self.y4 + y
        self.points = ((self.x1,self.y1),(self.x2,self.y2),(self.x3,self.y3),(self.x4,self.y4))

    def rotate(self, angle, xc, yc):
        angle = math.radians(angle)
        cos = math.cos(angle)
        sin = math.sin(angle)
        temp =  (self.x2-xc)*cos - (self.y2-yc)*sin + xc
        self.y2 = (self.x2-xc)*sin + (self.y2-yc)*cos + yc
        self.x2 = temp
        temp =  (self.x1-xc)*cos - (self.y1-yc)*sin + xc
        self.y1 = (self.x1-xc)*sin + (self.y1-yc)*cos + yc
        self.x1 = temp
        temp =  (self.x3-xc)*cos - (self.y3-yc)*sin + xc
        self.y3 = (self.x3-xc)*sin + (self.y3-yc)*cos + yc
        self.x3 = temp
        temp =  (self.x4-xc)*cos - (self.y4-yc)*sin + xc
        self.y4 = (self.x4-xc)*sin + (self.y4-yc)*cos + yc
        self.x4 = temp
        self.points = ((self.x1,self.y1),(self.x2,self.y2),(self.x3,self.y3),(self.x4,self.y4))

    def update(self):
        self.points = ((self.x1,self.y1),(self.x2,self.y2),(self.x3,self.y3),(self.x4,self.y4))

    def collideEdge(self, sizex, sizey):
        if(self.x1 >= sizex or self.x1 <= 0 or self.x2 >= sizex or self.x2 <= 0 or self.x3 >= sizex or self.x3 <= 0 or self.x4 >= sizex or self.x4 <= 0 or self.y1 >= sizey or self.y1 <= 0 or self.y2 >= sizey or self.y2 <= 0 or self.y3 >= sizey or self.y3 <= 0 or self.y4 >= sizey or self.y4 <= 0):
            return True
        else:
            return False

    def getRect(self):
        if (self.hidden == False):
            return pygame.Rect(self.x1, self.y1, self.w, self.h)

class Triangle:
    def __init__(self, x, y, x2, y2, x3, y3):
            self.x1 = x3
            self.y1 = y3
            self.x2 = x
            self.y2 = y
            self.x3 = x2
            self.y3 = y2
            self.points = ((self.x1,self.y1),(self.x2,self.y2),(self.x3,self.y3))
            self.hidden = False
            self.thickness = 1
            self.filled = False
            self.color = WHITE_

    def translate(self, x,y):
        self.x1 = self.x1 + x
        self.y1 = self.y1 + y
        self.x2 = self.x2 + x
        self.y2 = self.y2 + y
        self.x3 = self.x3 + x
        self.y3 = self.y3 + y
        self.points = ((self.x1,self.y1),(self.x2,self.y2),(self.x3,self.y3))

    def rotate(self, angle, xc, yc):
        angle = math.radians(angle)
        cos = math.cos(angle)
        sin = math.sin(angle)
        temp =  (self.x2-xc)*cos - (self.y2-yc)*sin + xc
        self.y2 = (self.x2-xc)*sin + (self.y2-yc)*cos + yc
        self.x2 = temp
        temp =  (self.x1-xc)*cos - (self.y1-yc)*sin + xc
        self.y1 = (self.x1-xc)*sin + (self.y1-yc)*cos + yc
        self.x1 = temp
        temp =  (self.x3-xc)*cos - (self.y3-yc)*sin + xc
        self.y3 = (self.x3-xc)*sin + (self.y3-yc)*cos + yc
        self.x3 = temp
        self.points = ((self.x1,self.y1),(self.x2,self.y2),(self.x3,self.y3))

    def update(self):
        self.points = ((self.x1,self.y1),(self.x2,self.y2),(self.x3,self.y3))

    def collideEdge(self, sizex, sizey):
        if(self.x1 >= sizex or self.x1 <= 0 or self.x2 >= sizex or self.x2 <= 0 or self.x3 >= sizex or self.x3 <= 0 or self.y1 >= sizey or self.y1 <= 0 or self.y2 >= sizey or self.y2 <= 0 or self.y3 >= sizey or self.y3 <= 0):
            return True
        else:
            return False

    def getRect(self):
        if (self.hidden == False):
            return pygame.draw.polygon(display, self.color, self.points, self.thickness)


def figureCollision(a, b):
    try:
        return a.colliderect(b)
    except:
        return False

internal_timer = 0

WIDTH  = 800
HEIGHT = 900
display = pygame.display.set_mode([WIDTH,HEIGHT])
pygame.display.set_caption('Pacman-Game')

v1 = 255
v2 = 105
v3 = 180
PINK_ = (v1,v2,v3)
c39_ = Circle(573,186,8)
c39_.color = WHITE_
c39_.thickness = 3
c38_ = Circle(691,186,8)
c38_.color = WHITE_
c38_.thickness = 3
c37_ = Circle(632,186,8)
c37_.color = WHITE_
c37_.thickness = 3
c36_ = Circle(691,186,8)
c36_.color = WHITE_
c36_.thickness = 3
c35_ = Circle(400,458,8)
c35_.color = WHITE_
c35_.thickness = 3
c79_ = Circle(510,855,8)
c79_.color = WHITE_
c79_.thickness = 3
c34_ = Circle(514,458,8)
c34_.color = WHITE_
c34_.thickness = 3
c78_ = Circle(455,855,8)
c78_.color = WHITE_
c78_.thickness = 3
c33_ = Circle(573,458,8)
c33_.color = WHITE_
c33_.thickness = 3
c77_ = Circle(455,770,8)
c77_.color = WHITE_
c77_.thickness = 3
c43_ = Circle(168,186,8)
c43_.color = WHITE_
c43_.thickness = 3
c87_ = Circle(180,855,8)
c87_.color = WHITE_
c87_.thickness = 3
c42_ = Circle(109,186,8)
c42_.color = WHITE_
c42_.thickness = 3
c86_ = Circle(235,855,8)
c86_.color = WHITE_
c86_.thickness = 3
c41_ = Circle(455,186,8)
c41_.color = WHITE_
c41_.thickness = 3
c85_ = Circle(290,855,8)
c85_.color = WHITE_
c85_.thickness = 3
c40_ = Circle(514,186,8)
c40_.color = WHITE_
c40_.thickness = 3
c84_ = Circle(345,855,8)
c84_.color = WHITE_
c84_.thickness = 3
c83_ = Circle(730,855,8)
c83_.color = WHITE_
c83_.thickness = 3
c82_ = Circle(675,855,8)
c82_.color = WHITE_
c82_.thickness = 3
c81_ = Circle(620,855,8)
c81_.color = WHITE_
c81_.thickness = 3
c80_ = Circle(565,855,8)
c80_.color = WHITE_
c80_.thickness = 3
c29_ = Circle(345,458,8)
c29_.color = WHITE_
c29_.thickness = 3
c28_ = Circle(287,458,8)
c28_.color = WHITE_
c28_.thickness = 3
c27_ = Circle(227,458,8)
c27_.color = WHITE_
c27_.thickness = 3
c26_ = Circle(168,458,8)
c26_.color = WHITE_
c26_.thickness = 3
c25_ = Circle(109,458,8)
c25_.color = WHITE_
c25_.thickness = 3
c69_ = Circle(632,692,8)
c69_.color = WHITE_
c69_.thickness = 3
c24_ = Circle(514,50,8)
c24_.color = WHITE_
c24_.thickness = 3
c68_ = Circle(691,692,8)
c68_.color = WHITE_
c68_.thickness = 3
c23_ = Circle(573,50,8)
c23_.color = WHITE_
c23_.thickness = 3
c67_ = Circle(455,692,8)
c67_.color = WHITE_
c67_.thickness = 3
c22_ = Circle(632,50,8)
c22_.color = WHITE_
c22_.thickness = 3
c66_ = Circle(345,692,8)
c66_.color = WHITE_
c66_.thickness = 3
c32_ = Circle(632,458,8)
c32_.color = WHITE_
c32_.thickness = 3
c76_ = Circle(345,770,8)
c76_.color = WHITE_
c76_.thickness = 3
c31_ = Circle(691,458,8)
c31_.color = WHITE_
c31_.thickness = 3
c75_ = Circle(400,770,8)
c75_.color = WHITE_
c75_.thickness = 3
c9_ = Circle(750,186,8)
c9_.color = WHITE_
c9_.thickness = 3
c30_ = Circle(455,458,8)
c30_.color = WHITE_
c30_.thickness = 3
c74_ = Circle(750,692,8)
c74_.color = WHITE_
c74_.thickness = 3
c8_ = Circle(750,118,8)
c8_.color = WHITE_
c8_.thickness = 3
c73_ = Circle(50,692,8)
c73_.color = WHITE_
c73_.thickness = 3
c72_ = Circle(400,855,8)
c72_.color = WHITE_
c72_.thickness = 3
c71_ = Circle(514,692,8)
c71_.color = WHITE_
c71_.thickness = 3
w1_ = Square(0,892, 900, 6)
w1_.color = BLUE_
w1_.thickness = 2
w2_ = Square(0,0, 800, 6)
w2_.color = BLUE_
w2_.thickness = 2
w3_ = Square(792,0, 6, 900)
w3_.color = BLUE_
w3_.thickness = 2
w4_ = Square(0,0, 6, 900)
w4_.color = BLUE_
w4_.thickness = 2
meio1_ = Square(397,0, 6, 150)
meio1_.color = BLUE_
meio1_.thickness = 2
meio2_ = Square(315,250, 170, 6)
meio2_.color = BLUE_
meio2_.thickness = 2
topR1_ = Square(500,90, 70, 60)
topR1_.color = BLUE_
topR1_.thickness = 2
topR2_ = Square(660,90, 50, 60)
topR2_.color = BLUE_
topR2_.thickness = 2
topR3_ = Square(660,240, 50, 170)
topR3_.color = BLUE_
topR3_.thickness = 2
topL1_ = Square(230,90, 70, 60)
topL1_.color = BLUE_
topL1_.thickness = 2
topL2_ = Square(90,90, 50, 60)
topL2_.color = BLUE_
topL2_.thickness = 2
topL3_ = Square(90,240, 50, 170)
topL3_.color = BLUE_
topL3_.thickness = 2
meioR_ = Square(567,250, 6, 160)
meioR_.color = BLUE_
meioR_.thickness = 2
meioL_ = Square(234,250, 6, 160)
meioL_.color = BLUE_
meioL_.thickness = 2
meioMVer_ = Square(397,256, 6, 154)
meioMVer_.color = BLUE_
meioMVer_.thickness = 2
meioML_ = Square(240,330, 80, 6)
meioML_.color = BLUE_
meioML_.thickness = 2
meioMR_ = Square(487,330, 80, 6)
meioMR_.color = BLUE_
meioMR_.thickness = 2
meio2Baixo_ = Square(315,410, 170, 6)
meio2Baixo_.color = BLUE_
meio2Baixo_.thickness = 2
grandL_ = Square(6,510, 350, 40)
grandL_.color = BLUE_
grandL_.thickness = 2
grandR_ = Square(446,510, 350, 40)
grandR_.color = BLUE_
grandR_.thickness = 2
meio2Baixo2_ = Square(300,640, 200, 6)
meio2Baixo2_.color = BLUE_
meio2Baixo2_.thickness = 2
meio2BaixoV_ = Square(397,646, 6, 80)
meio2BaixoV_.color = BLUE_
meio2BaixoV_.thickness = 2
meio2BaixoL_ = Square(6,640, 200, 6)
meio2BaixoL_.color = BLUE_
meio2BaixoL_.thickness = 2
meio2BaixoR_ = Square(596,640, 200, 6)
meio2BaixoR_.color = BLUE_
meio2BaixoR_.thickness = 2
meioFinal_ = Square(300,810, 200, 6)
meioFinal_.color = BLUE_
meioFinal_.thickness = 2
fimGordoL_ = Square(6,735, 200, 80)
fimGordoL_.color = BLUE_
fimGordoL_.thickness = 2
fimGordoR_ = Square(593,735, 200, 80)
fimGordoR_.color = BLUE_
fimGordoR_.thickness = 2
fimMeioL_ = Square(300,720, 6, 90)
fimMeioL_.color = BLUE_
fimMeioL_.thickness = 2
fimMeioR_ = Square(494,720, 6, 90)
fimMeioR_.color = BLUE_
fimMeioR_.thickness = 2
c70_ = Circle(573,692,8)
c70_.color = WHITE_
c70_.thickness = 3
c3_ = Circle(50,254,8)
c3_.color = WHITE_
c3_.thickness = 3
c2_ = Circle(50,186,8)
c2_.color = WHITE_
c2_.thickness = 3
c1_ = Circle(50,118,8)
c1_.color = WHITE_
c1_.thickness = 3
c7_ = Circle(50,50,8)
c7_.color = WHITE_
c7_.thickness = 3
c6_ = Circle(50,458,8)
c6_.color = WHITE_
c6_.thickness = 3
c5_ = Circle(50,390,8)
c5_.color = WHITE_
c5_.thickness = 3
c4_ = Circle(50,322,8)
c4_.color = WHITE_
c4_.thickness = 3
c19_ = Circle(345,50,8)
c19_.color = WHITE_
c19_.thickness = 3
c18_ = Circle(287,50,8)
c18_.color = WHITE_
c18_.thickness = 3
c17_ = Circle(227,50,8)
c17_.color = WHITE_
c17_.thickness = 3
c16_ = Circle(168,50,8)
c16_.color = WHITE_
c16_.thickness = 3
c15_ = Circle(109,50,8)
c15_.color = WHITE_
c15_.thickness = 3
c59_ = Circle(50,592,8)
c59_.color = WHITE_
c59_.thickness = 3
c14_ = Circle(750,50,8)
c14_.color = WHITE_
c14_.thickness = 3
c58_ = Circle(400,592,8)
c58_.color = WHITE_
c58_.thickness = 3
c13_ = Circle(750,458,8)
c13_.color = WHITE_
c13_.thickness = 3
c57_ = Circle(514,592,8)
c57_.color = WHITE_
c57_.thickness = 3
c12_ = Circle(750,390,8)
c12_.color = WHITE_
c12_.thickness = 3
c56_ = Circle(573,592,8)
c56_.color = WHITE_
c56_.thickness = 3
c11_ = Circle(750,322,8)
c11_.color = WHITE_
c11_.thickness = 3
c55_ = Circle(632,592,8)
c55_.color = WHITE_
c55_.thickness = 3
c21_ = Circle(691,50,8)
c21_.color = WHITE_
c21_.thickness = 3
c65_ = Circle(287,692,8)
c65_.color = WHITE_
c65_.thickness = 3
c20_ = Circle(455,50,8)
c20_.color = WHITE_
c20_.thickness = 3
c64_ = Circle(227,692,8)
c64_.color = WHITE_
c64_.thickness = 3
c63_ = Circle(168,692,8)
c63_.color = WHITE_
c63_.thickness = 3
c62_ = Circle(109,692,8)
c62_.color = WHITE_
c62_.thickness = 3
c61_ = Circle(400,525,8)
c61_.color = WHITE_
c61_.thickness = 3
c60_ = Circle(750,592,8)
c60_.color = WHITE_
c60_.thickness = 3
corpo_ = Circle(40,50,25)
corpo_.color = YELLOW_
corpo_.thickness = 0
boca_ = Triangle(40,50,65,35,65,65)
boca_.color = BLACK_
boca_.thickness = 0
c49_ = Circle(168,592,8)
c49_.color = WHITE_
c49_.thickness = 3
c48_ = Circle(109,592,8)
c48_.color = WHITE_
c48_.thickness = 3
corpo___1_ = Circle(50,847,25)
corpo___1_.color = PINK_
corpo___1_.thickness = 0
corpo___2_ = Square(25,847, 50, 40)
corpo___2_.color = PINK_
corpo___2_.thickness = 0
corpo___3_ = Triangle(25,887,33,877,41,887)
corpo___3_.color = BLACK_
corpo___3_.thickness = 0
corpo___4_ = Triangle(41,887,50,877,58,887)
corpo___4_.color = BLACK_
corpo___4_.thickness = 0
corpo___5_ = Triangle(58,887,67,877,75,887)
corpo___5_.color = BLACK_
corpo___5_.thickness = 0
olho___1_ = Circle(40,847,4)
olho___1_.color = WHITE_
olho___1_.thickness = 0
olho___2_ = Circle(60,847,4)
olho___2_.color = WHITE_
olho___2_.thickness = 0
olho___11_ = Circle(40,849,2)
olho___11_.color = BLUE_
olho___11_.thickness = 0
olho___22_ = Circle(60,849,2)
olho___22_.color = BLUE_
olho___22_.thickness = 0
Borda____ = Square(25,822, 50, 65)
Borda____.color = GREEN_
Borda____.hidden = True
c47_ = Circle(404,186,8)
c47_.color = WHITE_
c47_.thickness = 3
corpo__1_ = Circle(750,847,25)
corpo__1_.color = ORANGE_
corpo__1_.thickness = 0
corpo__2_ = Square(725,847, 50, 40)
corpo__2_.color = ORANGE_
corpo__2_.thickness = 0
corpo__3_ = Triangle(725,887,733,877,741,887)
corpo__3_.color = BLACK_
corpo__3_.thickness = 0
corpo__4_ = Triangle(741,887,750,877,758,887)
corpo__4_.color = BLACK_
corpo__4_.thickness = 0
corpo__5_ = Triangle(758,887,767,877,775,887)
corpo__5_.color = BLACK_
corpo__5_.thickness = 0
olho__1_ = Circle(740,847,4)
olho__1_.color = WHITE_
olho__1_.thickness = 0
olho__2_ = Circle(760,847,4)
olho__2_.color = WHITE_
olho__2_.thickness = 0
olho__11_ = Circle(740,849,2)
olho__11_.color = BLUE_
olho__11_.thickness = 0
olho__22_ = Circle(760,849,2)
olho__22_.color = BLUE_
olho__22_.thickness = 0
Borda___ = Square(725,822, 50, 65)
Borda___.color = GREEN_
Borda___.hidden = True
c46_ = Circle(345,186,8)
c46_.color = WHITE_
c46_.thickness = 3
corpo_1_ = Circle(750,50,25)
corpo_1_.color = RED_
corpo_1_.thickness = 0
corpo_2_ = Square(725,50, 50, 40)
corpo_2_.color = RED_
corpo_2_.thickness = 0
corpo_3_ = Triangle(725,90,733,80,741,90)
corpo_3_.color = BLACK_
corpo_3_.thickness = 0
corpo_4_ = Triangle(741,90,750,80,758,90)
corpo_4_.color = BLACK_
corpo_4_.thickness = 0
corpo_5_ = Triangle(758,90,767,80,775,90)
corpo_5_.color = BLACK_
corpo_5_.thickness = 0
olho_1_ = Circle(740,50,4)
olho_1_.color = WHITE_
olho_1_.thickness = 0
olho_2_ = Circle(760,50,4)
olho_2_.color = WHITE_
olho_2_.thickness = 0
olho_11_ = Circle(740,52,2)
olho_11_.color = BLUE_
olho_11_.thickness = 0
olho_22_ = Circle(760,52,2)
olho_22_.color = BLUE_
olho_22_.thickness = 0
Borda__ = Square(725,25, 50, 65)
Borda__.color = GREEN_
Borda__.hidden = True
c45_ = Circle(286,186,8)
c45_.color = WHITE_
c45_.thickness = 3
c89_ = Circle(70,855,8)
c89_.color = WHITE_
c89_.thickness = 3
corpo1_ = Circle(50,50,25)
corpo1_.color = BLUE_
corpo1_.thickness = 0
corpo2_ = Square(25,50, 50, 40)
corpo2_.color = BLUE_
corpo2_.thickness = 0
corpo3_ = Triangle(25,90,33,80,41,90)
corpo3_.color = BLACK_
corpo3_.thickness = 0
corpo4_ = Triangle(41,90,50,80,58,90)
corpo4_.color = BLACK_
corpo4_.thickness = 0
corpo5_ = Triangle(58,90,67,80,75,90)
corpo5_.color = BLACK_
corpo5_.thickness = 0
olho1_ = Circle(40,50,4)
olho1_.color = WHITE_
olho1_.thickness = 0
olho2_ = Circle(60,50,4)
olho2_.color = WHITE_
olho2_.thickness = 0
olho11_ = Circle(40,52,2)
olho11_.color = BLACK_
olho11_.thickness = 0
olho22_ = Circle(60,52,2)
olho22_.color = BLACK_
olho22_.thickness = 0
Borda_ = Square(25,25, 50, 65)
Borda_.color = GREEN_
Borda_.hidden = True
c44_ = Circle(227,186,8)
c44_.color = WHITE_
c44_.thickness = 3
c88_ = Circle(125,855,8)
c88_.color = WHITE_
c88_.thickness = 3
c10_ = Circle(750,254,8)
c10_.color = WHITE_
c10_.thickness = 3
c54_ = Circle(691,592,8)
c54_.color = WHITE_
c54_.thickness = 3
c53_ = Circle(455,592,8)
c53_.color = WHITE_
c53_.thickness = 3
c52_ = Circle(345,592,8)
c52_.color = WHITE_
c52_.thickness = 3
c51_ = Circle(287,592,8)
c51_.color = WHITE_
c51_.thickness = 3
c50_ = Circle(227,592,8)
c50_.color = WHITE_
c50_.thickness = 3
v4 = boca_.x1
x1_ = v4
v5 = boca_.y1
y1_ = v5
v6 = boca_.x2
x2_ = v6
v7 = boca_.y2
y2_ = v7
v8 = boca_.x3
x3_ = v8
v9 = boca_.y3
y3_ = v9


v10 = 2
speed_x_ = v10
v11 = 0
speed_y_ = v11
v12 = 3
lastInput_ = v12
v13 = 0
timer1_ = v13
v14 = 0
timer2_ = v14
v15 = 0
timer3_ = v15
v16 = 0
timer4_ = v16
v17 = 70
v18 = 0
corpo_.translate(v17, v18)
v19 = 70
v20 = 0
boca_.translate(v19, v20)
v21 = False
win_ = v21
v22 = True
run_ = v22
v23 = 89
moeda_ = v23
while(run):
        clock.tick(fps)  

        eventos = pygame.event.get()
        try:
            if(eventos[0].type == 32787):
                run = False
        except:
            pass
        display.fill(BLACK_)

        if(drawstringlllll_== True):
            display.blit(text, textRect)

        v24 = run_
        if (v24):
            v25 = corpo_.x
            self_x_ = v25
            v26 = corpo_.y
            self_y_ = v26
            try:
                if eventos[0].type == pygame.KEYDOWN and eventos[0].key == pygame.K_LEFT:
                    v27 = -2
                    speed_x_ = v27
                    v28 = 0
                    speed_y_ = v28
                    v30 = lastInput_
                    v31 = 2
                    v29 = v30 == v31
                    if (v29):
                        v32 = 270
                        v33 = self_x_
                        v34 = self_y_
                        corpo_.rotate(v32, v33, v34)
                        v35 = 270
                        v36 = self_x_
                        v37 = self_y_
                        boca_.rotate(v35, v36, v37)

                    v39 = lastInput_
                    v40 = 3
                    v38 = v39 == v40
                    if (v38):
                        v41 = 180
                        v42 = self_x_
                        v43 = self_y_
                        corpo_.rotate(v41, v42, v43)
                        v44 = 180
                        v45 = self_x_
                        v46 = self_y_
                        boca_.rotate(v44, v45, v46)

                    v48 = lastInput_
                    v49 = 4
                    v47 = v48 == v49
                    if (v47):
                        v50 = 90
                        v51 = self_x_
                        v52 = self_y_
                        corpo_.rotate(v50, v51, v52)
                        v53 = 90
                        v54 = self_x_
                        v55 = self_y_
                        boca_.rotate(v53, v54, v55)

                    v56 = 1
                    lastInput_ = v56
            except:
                pass
            try:
                if eventos[0].type == pygame.KEYDOWN and eventos[0].key == pygame.K_RIGHT:
                    v57 = 2
                    speed_x_ = v57
                    v58 = 0
                    speed_y_ = v58
                    v60 = lastInput_
                    v61 = 1
                    v59 = v60 == v61
                    if (v59):
                        v62 = 180
                        v63 = self_x_
                        v64 = self_y_
                        corpo_.rotate(v62, v63, v64)
                        v65 = 180
                        v66 = self_x_
                        v67 = self_y_
                        boca_.rotate(v65, v66, v67)

                    v69 = lastInput_
                    v70 = 2
                    v68 = v69 == v70
                    if (v68):
                        v71 = 90
                        v72 = self_x_
                        v73 = self_y_
                        corpo_.rotate(v71, v72, v73)
                        v74 = 90
                        v75 = self_x_
                        v76 = self_y_
                        boca_.rotate(v74, v75, v76)

                    v78 = lastInput_
                    v79 = 4
                    v77 = v78 == v79
                    if (v77):
                        v80 = 270
                        v81 = self_x_
                        v82 = self_y_
                        corpo_.rotate(v80, v81, v82)
                        v83 = 270
                        v84 = self_x_
                        v85 = self_y_
                        boca_.rotate(v83, v84, v85)

                    v86 = 3
                    lastInput_ = v86
            except:
                pass
            try:
                if eventos[0].type == pygame.KEYDOWN and eventos[0].key == pygame.K_UP:
                    v87 = -2
                    speed_y_ = v87
                    v88 = 0
                    speed_x_ = v88
                    v90 = lastInput_
                    v91 = 1
                    v89 = v90 == v91
                    if (v89):
                        v92 = 90
                        v93 = self_x_
                        v94 = self_y_
                        corpo_.rotate(v92, v93, v94)
                        v95 = 90
                        v96 = self_x_
                        v97 = self_y_
                        boca_.rotate(v95, v96, v97)

                    v99 = lastInput_
                    v100 = 3
                    v98 = v99 == v100
                    if (v98):
                        v101 = 270
                        v102 = self_x_
                        v103 = self_y_
                        corpo_.rotate(v101, v102, v103)
                        v104 = 270
                        v105 = self_x_
                        v106 = self_y_
                        boca_.rotate(v104, v105, v106)

                    v108 = lastInput_
                    v109 = 4
                    v107 = v108 == v109
                    if (v107):
                        v110 = 180
                        v111 = self_x_
                        v112 = self_y_
                        corpo_.rotate(v110, v111, v112)
                        v113 = 180
                        v114 = self_x_
                        v115 = self_y_
                        boca_.rotate(v113, v114, v115)

                    v116 = 2
                    lastInput_ = v116
            except:
                pass
            try:
                if eventos[0].type == pygame.KEYDOWN and eventos[0].key == pygame.K_DOWN:
                    v117 = 2
                    speed_y_ = v117
                    v118 = 0
                    speed_x_ = v118
                    v120 = lastInput_
                    v121 = 1
                    v119 = v120 == v121
                    if (v119):
                        v122 = 270
                        v123 = self_x_
                        v124 = self_y_
                        corpo_.rotate(v122, v123, v124)
                        v125 = 270
                        v126 = self_x_
                        v127 = self_y_
                        boca_.rotate(v125, v126, v127)

                    v129 = lastInput_
                    v130 = 3
                    v128 = v129 == v130
                    if (v128):
                        v131 = 90
                        v132 = self_x_
                        v133 = self_y_
                        corpo_.rotate(v131, v132, v133)
                        v134 = 90
                        v135 = self_x_
                        v136 = self_y_
                        boca_.rotate(v134, v135, v136)

                    v138 = lastInput_
                    v139 = 2
                    v137 = v138 == v139
                    if (v137):
                        v140 = 180
                        v141 = self_x_
                        v142 = self_y_
                        corpo_.rotate(v140, v141, v142)
                        v143 = 180
                        v144 = self_x_
                        v145 = self_y_
                        boca_.rotate(v143, v144, v145)

                    v146 = 4
                    lastInput_ = v146
            except:
                pass
            corpo_.update()
            w1_.update()
            corpo_.update()
            w2_.update()
            corpo_.update()
            w3_.update()
            corpo_.update()
            w4_.update()
            corpo_.update()
            meio1_.update()
            corpo_.update()
            meio2_.update()
            corpo_.update()
            topR1_.update()
            corpo_.update()
            topR2_.update()
            corpo_.update()
            topR3_.update()
            corpo_.update()
            topL1_.update()
            corpo_.update()
            topL2_.update()
            corpo_.update()
            topL3_.update()
            corpo_.update()
            meioR_.update()
            corpo_.update()
            meioL_.update()
            corpo_.update()
            meioMVer_.update()
            corpo_.update()
            meioML_.update()
            corpo_.update()
            meioMR_.update()
            corpo_.update()
            meio2Baixo_.update()
            corpo_.update()
            grandL_.update()
            corpo_.update()
            grandR_.update()
            corpo_.update()
            meio2Baixo2_.update()
            corpo_.update()
            meio2BaixoV_.update()
            corpo_.update()
            meio2BaixoL_.update()
            corpo_.update()
            meio2BaixoR_.update()
            corpo_.update()
            meioFinal_.update()
            corpo_.update()
            fimGordoL_.update()
            corpo_.update()
            fimGordoR_.update()
            corpo_.update()
            fimMeioL_.update()
            corpo_.update()
            fimMeioR_.update()
            boca_.update()
            w1_.update()
            boca_.update()
            w2_.update()
            boca_.update()
            w3_.update()
            boca_.update()
            w4_.update()
            boca_.update()
            meio1_.update()
            boca_.update()
            meio2_.update()
            boca_.update()
            topR1_.update()
            boca_.update()
            topR2_.update()
            boca_.update()
            topR3_.update()
            boca_.update()
            topL1_.update()
            boca_.update()
            topL2_.update()
            boca_.update()
            topL3_.update()
            boca_.update()
            meioR_.update()
            boca_.update()
            meioL_.update()
            boca_.update()
            meioMVer_.update()
            boca_.update()
            meioML_.update()
            boca_.update()
            meioMR_.update()
            boca_.update()
            meio2Baixo_.update()
            boca_.update()
            grandL_.update()
            boca_.update()
            grandR_.update()
            boca_.update()
            meio2Baixo2_.update()
            boca_.update()
            meio2BaixoV_.update()
            boca_.update()
            meio2BaixoL_.update()
            boca_.update()
            meio2BaixoR_.update()
            boca_.update()
            meioFinal_.update()
            boca_.update()
            fimGordoL_.update()
            boca_.update()
            fimGordoR_.update()
            boca_.update()
            fimMeioL_.update()
            boca_.update()
            fimMeioR_.update()
            v148 = figureCollision(corpo_.getRect(),w1_.getRect()) or figureCollision(corpo_.getRect(),w2_.getRect()) or figureCollision(corpo_.getRect(),w3_.getRect()) or figureCollision(corpo_.getRect(),w4_.getRect()) or figureCollision(corpo_.getRect(),meio1_.getRect()) or figureCollision(corpo_.getRect(),meio2_.getRect()) or figureCollision(corpo_.getRect(),topR1_.getRect()) or figureCollision(corpo_.getRect(),topR2_.getRect()) or figureCollision(corpo_.getRect(),topR3_.getRect()) or figureCollision(corpo_.getRect(),topL1_.getRect()) or figureCollision(corpo_.getRect(),topL2_.getRect()) or figureCollision(corpo_.getRect(),topL3_.getRect()) or figureCollision(corpo_.getRect(),meioR_.getRect()) or figureCollision(corpo_.getRect(),meioL_.getRect()) or figureCollision(corpo_.getRect(),meioMVer_.getRect()) or figureCollision(corpo_.getRect(),meioML_.getRect()) or figureCollision(corpo_.getRect(),meioMR_.getRect()) or figureCollision(corpo_.getRect(),meio2Baixo_.getRect()) or figureCollision(corpo_.getRect(),grandL_.getRect()) or figureCollision(corpo_.getRect(),grandR_.getRect()) or figureCollision(corpo_.getRect(),meio2Baixo2_.getRect()) or figureCollision(corpo_.getRect(),meio2BaixoV_.getRect()) or figureCollision(corpo_.getRect(),meio2BaixoL_.getRect()) or figureCollision(corpo_.getRect(),meio2BaixoR_.getRect()) or figureCollision(corpo_.getRect(),meioFinal_.getRect()) or figureCollision(corpo_.getRect(),fimGordoL_.getRect()) or figureCollision(corpo_.getRect(),fimGordoR_.getRect()) or figureCollision(corpo_.getRect(),fimMeioL_.getRect()) or figureCollision(corpo_.getRect(),fimMeioR_.getRect()) or figureCollision(boca_.getRect(),w1_.getRect()) or figureCollision(boca_.getRect(),w2_.getRect()) or figureCollision(boca_.getRect(),w3_.getRect()) or figureCollision(boca_.getRect(),w4_.getRect()) or figureCollision(boca_.getRect(),meio1_.getRect()) or figureCollision(boca_.getRect(),meio2_.getRect()) or figureCollision(boca_.getRect(),topR1_.getRect()) or figureCollision(boca_.getRect(),topR2_.getRect()) or figureCollision(boca_.getRect(),topR3_.getRect()) or figureCollision(boca_.getRect(),topL1_.getRect()) or figureCollision(boca_.getRect(),topL2_.getRect()) or figureCollision(boca_.getRect(),topL3_.getRect()) or figureCollision(boca_.getRect(),meioR_.getRect()) or figureCollision(boca_.getRect(),meioL_.getRect()) or figureCollision(boca_.getRect(),meioMVer_.getRect()) or figureCollision(boca_.getRect(),meioML_.getRect()) or figureCollision(boca_.getRect(),meioMR_.getRect()) or figureCollision(boca_.getRect(),meio2Baixo_.getRect()) or figureCollision(boca_.getRect(),grandL_.getRect()) or figureCollision(boca_.getRect(),grandR_.getRect()) or figureCollision(boca_.getRect(),meio2Baixo2_.getRect()) or figureCollision(boca_.getRect(),meio2BaixoV_.getRect()) or figureCollision(boca_.getRect(),meio2BaixoL_.getRect()) or figureCollision(boca_.getRect(),meio2BaixoR_.getRect()) or figureCollision(boca_.getRect(),meioFinal_.getRect()) or figureCollision(boca_.getRect(),fimGordoL_.getRect()) or figureCollision(boca_.getRect(),fimGordoR_.getRect()) or figureCollision(boca_.getRect(),fimMeioL_.getRect()) or figureCollision(boca_.getRect(),fimMeioR_.getRect())
            v149 = False
            v147 = v148 == v149
            if (v147):
                v150 = speed_x_
                v151 = speed_y_
                corpo_.translate(v150, v151)
                v152 = speed_x_
                v153 = speed_y_
                boca_.translate(v152, v153)

            v155 = timer1_
            v156 = 205
            v154 = v155 < v156
            if (v154):
                v157 = 0
                v158 = 2
                corpo1_.translate(v157, v158)
                v159 = 0
                v160 = 2
                corpo2_.translate(v159, v160)
                v161 = 0
                v162 = 2
                corpo3_.translate(v161, v162)
                v163 = 0
                v164 = 2
                corpo4_.translate(v163, v164)
                v165 = 0
                v166 = 2
                corpo5_.translate(v165, v166)
                v167 = 0
                v168 = 2
                olho1_.translate(v167, v168)
                v169 = 0
                v170 = 2
                olho2_.translate(v169, v170)
                v171 = 0
                v172 = 2
                olho11_.translate(v171, v172)
                v173 = 0
                v174 = 2
                olho22_.translate(v173, v174)
                v175 = 0
                v176 = 2
                Borda_.translate(v175, v176)

            v179 = timer1_
            v180 = 205
            v178 = v179 >= v180
            v182 = timer1_
            v183 = 490
            v181 = v182 < v183
            v177 = v178 and v181
            if (v177):
                v184 = 2
                v185 = 0
                corpo1_.translate(v184, v185)
                v186 = 2
                v187 = 0
                corpo2_.translate(v186, v187)
                v188 = 2
                v189 = 0
                corpo3_.translate(v188, v189)
                v190 = 2
                v191 = 0
                corpo4_.translate(v190, v191)
                v192 = 2
                v193 = 0
                corpo5_.translate(v192, v193)
                v194 = 2
                v195 = 0
                olho1_.translate(v194, v195)
                v196 = 2
                v197 = 0
                olho2_.translate(v196, v197)
                v198 = 2
                v199 = 0
                olho11_.translate(v198, v199)
                v200 = 2
                v201 = 0
                olho22_.translate(v200, v201)
                v202 = 2
                v203 = 0
                Borda_.translate(v202, v203)

            v206 = timer1_
            v207 = 490
            v205 = v206 >= v207
            v209 = timer1_
            v210 = 622
            v208 = v209 < v210
            v204 = v205 and v208
            if (v204):
                v211 = 0
                v212 = -2
                corpo1_.translate(v211, v212)
                v213 = 0
                v214 = -2
                corpo2_.translate(v213, v214)
                v215 = 0
                v216 = -2
                corpo3_.translate(v215, v216)
                v217 = 0
                v218 = -2
                corpo4_.translate(v217, v218)
                v219 = 0
                v220 = -2
                corpo5_.translate(v219, v220)
                v221 = 0
                v222 = -2
                olho1_.translate(v221, v222)
                v223 = 0
                v224 = -2
                olho2_.translate(v223, v224)
                v225 = 0
                v226 = -2
                olho11_.translate(v225, v226)
                v227 = 0
                v228 = -2
                olho22_.translate(v227, v228)
                v229 = 0
                v230 = -2
                Borda_.translate(v229, v230)

            v233 = timer1_
            v234 = 622
            v232 = v233 >= v234
            v236 = timer1_
            v237 = 757
            v235 = v236 < v237
            v231 = v232 and v235
            if (v231):
                v238 = -2
                v239 = 0
                corpo1_.translate(v238, v239)
                v240 = -2
                v241 = 0
                corpo2_.translate(v240, v241)
                v242 = -2
                v243 = 0
                corpo3_.translate(v242, v243)
                v244 = -2
                v245 = 0
                corpo4_.translate(v244, v245)
                v246 = -2
                v247 = 0
                corpo5_.translate(v246, v247)
                v248 = -2
                v249 = 0
                olho1_.translate(v248, v249)
                v250 = -2
                v251 = 0
                olho2_.translate(v250, v251)
                v252 = -2
                v253 = 0
                olho11_.translate(v252, v253)
                v254 = -2
                v255 = 0
                olho22_.translate(v254, v255)
                v256 = -2
                v257 = 0
                Borda_.translate(v256, v257)

            v260 = timer1_
            v261 = 757
            v259 = v260 >= v261
            v263 = timer1_
            v264 = 830
            v262 = v263 < v264
            v258 = v259 and v262
            if (v258):
                v265 = 0
                v266 = -2
                corpo1_.translate(v265, v266)
                v267 = 0
                v268 = -2
                corpo2_.translate(v267, v268)
                v269 = 0
                v270 = -2
                corpo3_.translate(v269, v270)
                v271 = 0
                v272 = -2
                corpo4_.translate(v271, v272)
                v273 = 0
                v274 = -2
                corpo5_.translate(v273, v274)
                v275 = 0
                v276 = -2
                olho1_.translate(v275, v276)
                v277 = 0
                v278 = -2
                olho2_.translate(v277, v278)
                v279 = 0
                v280 = -2
                olho11_.translate(v279, v280)
                v281 = 0
                v282 = -2
                olho22_.translate(v281, v282)
                v283 = 0
                v284 = -2
                Borda_.translate(v283, v284)

            v287 = timer1_
            v288 = 830
            v286 = v287 >= v288
            v290 = timer1_
            v291 = 980
            v289 = v290 < v291
            v285 = v286 and v289
            if (v285):
                v292 = -2
                v293 = 0
                corpo1_.translate(v292, v293)
                v294 = -2
                v295 = 0
                corpo2_.translate(v294, v295)
                v296 = -2
                v297 = 0
                corpo3_.translate(v296, v297)
                v298 = -2
                v299 = 0
                corpo4_.translate(v298, v299)
                v300 = -2
                v301 = 0
                corpo5_.translate(v300, v301)
                v302 = -2
                v303 = 0
                olho1_.translate(v302, v303)
                v304 = -2
                v305 = 0
                olho2_.translate(v304, v305)
                v306 = -2
                v307 = 0
                olho11_.translate(v306, v307)
                v308 = -2
                v309 = 0
                olho22_.translate(v308, v309)
                v310 = -2
                v311 = 0
                Borda_.translate(v310, v311)

            v313 = timer1_
            v314 = 980
            v312 = v313 == v314
            if (v312):
                v315 = -1
                timer1_ = v315

            v317 = timer2_
            v318 = 205
            v316 = v317 < v318
            if (v316):
                v319 = 0
                v320 = 2
                corpo_1_.translate(v319, v320)
                v321 = 0
                v322 = 2
                corpo_2_.translate(v321, v322)
                v323 = 0
                v324 = 2
                corpo_3_.translate(v323, v324)
                v325 = 0
                v326 = 2
                corpo_4_.translate(v325, v326)
                v327 = 0
                v328 = 2
                corpo_5_.translate(v327, v328)
                v329 = 0
                v330 = 2
                olho_1_.translate(v329, v330)
                v331 = 0
                v332 = 2
                olho_2_.translate(v331, v332)
                v333 = 0
                v334 = 2
                olho_11_.translate(v333, v334)
                v335 = 0
                v336 = 2
                olho_22_.translate(v335, v336)
                v337 = 0
                v338 = 2
                Borda__.translate(v337, v338)

            v341 = timer2_
            v342 = 205
            v340 = v341 >= v342
            v344 = timer2_
            v345 = 490
            v343 = v344 < v345
            v339 = v340 and v343
            if (v339):
                v346 = -2
                v347 = 0
                corpo_1_.translate(v346, v347)
                v348 = -2
                v349 = 0
                corpo_2_.translate(v348, v349)
                v350 = -2
                v351 = 0
                corpo_3_.translate(v350, v351)
                v352 = -2
                v353 = 0
                corpo_4_.translate(v352, v353)
                v354 = -2
                v355 = 0
                corpo_5_.translate(v354, v355)
                v356 = -2
                v357 = 0
                olho_1_.translate(v356, v357)
                v358 = -2
                v359 = 0
                olho_2_.translate(v358, v359)
                v360 = -2
                v361 = 0
                olho_11_.translate(v360, v361)
                v362 = -2
                v363 = 0
                olho_22_.translate(v362, v363)
                v364 = -2
                v365 = 0
                Borda__.translate(v364, v365)

            v368 = timer2_
            v369 = 490
            v367 = v368 >= v369
            v371 = timer2_
            v372 = 622
            v370 = v371 < v372
            v366 = v367 and v370
            if (v366):
                v373 = 0
                v374 = -2
                corpo_1_.translate(v373, v374)
                v375 = 0
                v376 = -2
                corpo_2_.translate(v375, v376)
                v377 = 0
                v378 = -2
                corpo_3_.translate(v377, v378)
                v379 = 0
                v380 = -2
                corpo_4_.translate(v379, v380)
                v381 = 0
                v382 = -2
                corpo_5_.translate(v381, v382)
                v383 = 0
                v384 = -2
                olho_1_.translate(v383, v384)
                v385 = 0
                v386 = -2
                olho_2_.translate(v385, v386)
                v387 = 0
                v388 = -2
                olho_11_.translate(v387, v388)
                v389 = 0
                v390 = -2
                olho_22_.translate(v389, v390)
                v391 = 0
                v392 = -2
                Borda__.translate(v391, v392)

            v395 = timer2_
            v396 = 622
            v394 = v395 >= v396
            v398 = timer2_
            v399 = 757
            v397 = v398 < v399
            v393 = v394 and v397
            if (v393):
                v400 = 2
                v401 = 0
                corpo_1_.translate(v400, v401)
                v402 = 2
                v403 = 0
                corpo_2_.translate(v402, v403)
                v404 = 2
                v405 = 0
                corpo_3_.translate(v404, v405)
                v406 = 2
                v407 = 0
                corpo_4_.translate(v406, v407)
                v408 = 2
                v409 = 0
                corpo_5_.translate(v408, v409)
                v410 = 2
                v411 = 0
                olho_1_.translate(v410, v411)
                v412 = 2
                v413 = 0
                olho_2_.translate(v412, v413)
                v414 = 2
                v415 = 0
                olho_11_.translate(v414, v415)
                v416 = 2
                v417 = 0
                olho_22_.translate(v416, v417)
                v418 = 2
                v419 = 0
                Borda__.translate(v418, v419)

            v422 = timer2_
            v423 = 757
            v421 = v422 >= v423
            v425 = timer2_
            v426 = 830
            v424 = v425 < v426
            v420 = v421 and v424
            if (v420):
                v427 = 0
                v428 = -2
                corpo_1_.translate(v427, v428)
                v429 = 0
                v430 = -2
                corpo_2_.translate(v429, v430)
                v431 = 0
                v432 = -2
                corpo_3_.translate(v431, v432)
                v433 = 0
                v434 = -2
                corpo_4_.translate(v433, v434)
                v435 = 0
                v436 = -2
                corpo_5_.translate(v435, v436)
                v437 = 0
                v438 = -2
                olho_1_.translate(v437, v438)
                v439 = 0
                v440 = -2
                olho_2_.translate(v439, v440)
                v441 = 0
                v442 = -2
                olho_11_.translate(v441, v442)
                v443 = 0
                v444 = -2
                olho_22_.translate(v443, v444)
                v445 = 0
                v446 = -2
                Borda__.translate(v445, v446)

            v449 = timer2_
            v450 = 830
            v448 = v449 >= v450
            v452 = timer2_
            v453 = 980
            v451 = v452 < v453
            v447 = v448 and v451
            if (v447):
                v454 = 2
                v455 = 0
                corpo_1_.translate(v454, v455)
                v456 = 2
                v457 = 0
                corpo_2_.translate(v456, v457)
                v458 = 2
                v459 = 0
                corpo_3_.translate(v458, v459)
                v460 = 2
                v461 = 0
                corpo_4_.translate(v460, v461)
                v462 = 2
                v463 = 0
                corpo_5_.translate(v462, v463)
                v464 = 2
                v465 = 0
                olho_1_.translate(v464, v465)
                v466 = 2
                v467 = 0
                olho_2_.translate(v466, v467)
                v468 = 2
                v469 = 0
                olho_11_.translate(v468, v469)
                v470 = 2
                v471 = 0
                olho_22_.translate(v470, v471)
                v472 = 2
                v473 = 0
                Borda__.translate(v472, v473)

            v475 = timer2_
            v476 = 980
            v474 = v475 == v476
            if (v474):
                v477 = -1
                timer2_ = v477

            v479 = timer3_
            v480 = 100
            v478 = v479 < v480
            if (v478):
                v481 = -2
                v482 = 0
                corpo__1_.translate(v481, v482)
                v483 = -2
                v484 = 0
                corpo__2_.translate(v483, v484)
                v485 = -2
                v486 = 0
                corpo__3_.translate(v485, v486)
                v487 = -2
                v488 = 0
                corpo__4_.translate(v487, v488)
                v489 = -2
                v490 = 0
                corpo__5_.translate(v489, v490)
                v491 = -2
                v492 = 0
                olho__1_.translate(v491, v492)
                v493 = -2
                v494 = 0
                olho__2_.translate(v493, v494)
                v495 = -2
                v496 = 0
                olho__11_.translate(v495, v496)
                v497 = -2
                v498 = 0
                olho__22_.translate(v497, v498)
                v499 = -2
                v500 = 0
                Borda___.translate(v499, v500)

            v503 = timer3_
            v504 = 100
            v502 = v503 >= v504
            v506 = timer3_
            v507 = 230
            v505 = v506 < v507
            v501 = v502 and v505
            if (v501):
                v508 = 0
                v509 = -2
                corpo__1_.translate(v508, v509)
                v510 = 0
                v511 = -2
                corpo__2_.translate(v510, v511)
                v512 = 0
                v513 = -2
                corpo__3_.translate(v512, v513)
                v514 = 0
                v515 = -2
                corpo__4_.translate(v514, v515)
                v516 = 0
                v517 = -2
                corpo__5_.translate(v516, v517)
                v518 = 0
                v519 = -2
                olho__1_.translate(v518, v519)
                v520 = 0
                v521 = -2
                olho__2_.translate(v520, v521)
                v522 = 0
                v523 = -2
                olho__11_.translate(v522, v523)
                v524 = 0
                v525 = -2
                olho__22_.translate(v524, v525)
                v526 = 0
                v527 = -2
                Borda___.translate(v526, v527)

            v530 = timer3_
            v531 = 230
            v529 = v530 >= v531
            v533 = timer3_
            v534 = 330
            v532 = v533 < v534
            v528 = v529 and v532
            if (v528):
                v535 = 2
                v536 = 0
                corpo__1_.translate(v535, v536)
                v537 = 2
                v538 = 0
                corpo__2_.translate(v537, v538)
                v539 = 2
                v540 = 0
                corpo__3_.translate(v539, v540)
                v541 = 2
                v542 = 0
                corpo__4_.translate(v541, v542)
                v543 = 2
                v544 = 0
                corpo__5_.translate(v543, v544)
                v545 = 2
                v546 = 0
                olho__1_.translate(v545, v546)
                v547 = 2
                v548 = 0
                olho__2_.translate(v547, v548)
                v549 = 2
                v550 = 0
                olho__11_.translate(v549, v550)
                v551 = 2
                v552 = 0
                olho__22_.translate(v551, v552)
                v553 = 2
                v554 = 0
                Borda___.translate(v553, v554)

            v557 = timer3_
            v558 = 330
            v556 = v557 >= v558
            v560 = timer3_
            v561 = 580
            v559 = v560 < v561
            v555 = v556 and v559
            if (v555):
                v562 = -2
                v563 = 0
                corpo__1_.translate(v562, v563)
                v564 = -2
                v565 = 0
                corpo__2_.translate(v564, v565)
                v566 = -2
                v567 = 0
                corpo__3_.translate(v566, v567)
                v568 = -2
                v569 = 0
                corpo__4_.translate(v568, v569)
                v570 = -2
                v571 = 0
                corpo__5_.translate(v570, v571)
                v572 = -2
                v573 = 0
                olho__1_.translate(v572, v573)
                v574 = -2
                v575 = 0
                olho__2_.translate(v574, v575)
                v576 = -2
                v577 = 0
                olho__11_.translate(v576, v577)
                v578 = -2
                v579 = 0
                olho__22_.translate(v578, v579)
                v580 = -2
                v581 = 0
                Borda___.translate(v580, v581)

            v584 = timer3_
            v585 = 580
            v583 = v584 >= v585
            v587 = timer3_
            v588 = 710
            v586 = v587 < v588
            v582 = v583 and v586
            if (v582):
                v589 = 0
                v590 = 2
                corpo__1_.translate(v589, v590)
                v591 = 0
                v592 = 2
                corpo__2_.translate(v591, v592)
                v593 = 0
                v594 = 2
                corpo__3_.translate(v593, v594)
                v595 = 0
                v596 = 2
                corpo__4_.translate(v595, v596)
                v597 = 0
                v598 = 2
                corpo__5_.translate(v597, v598)
                v599 = 0
                v600 = 2
                olho__1_.translate(v599, v600)
                v601 = 0
                v602 = 2
                olho__2_.translate(v601, v602)
                v603 = 0
                v604 = 2
                olho__11_.translate(v603, v604)
                v605 = 0
                v606 = 2
                olho__22_.translate(v605, v606)
                v607 = 0
                v608 = 2
                Borda___.translate(v607, v608)

            v611 = timer3_
            v612 = 710
            v610 = v611 >= v612
            v614 = timer3_
            v615 = 960
            v613 = v614 < v615
            v609 = v610 and v613
            if (v609):
                v616 = 2
                v617 = 0
                corpo__1_.translate(v616, v617)
                v618 = 2
                v619 = 0
                corpo__2_.translate(v618, v619)
                v620 = 2
                v621 = 0
                corpo__3_.translate(v620, v621)
                v622 = 2
                v623 = 0
                corpo__4_.translate(v622, v623)
                v624 = 2
                v625 = 0
                corpo__5_.translate(v624, v625)
                v626 = 2
                v627 = 0
                olho__1_.translate(v626, v627)
                v628 = 2
                v629 = 0
                olho__2_.translate(v628, v629)
                v630 = 2
                v631 = 0
                olho__11_.translate(v630, v631)
                v632 = 2
                v633 = 0
                olho__22_.translate(v632, v633)
                v634 = 2
                v635 = 0
                Borda___.translate(v634, v635)

            v637 = timer3_
            v638 = 960
            v636 = v637 == v638
            if (v636):
                v639 = -1
                timer3_ = v639

            v641 = timer4_
            v642 = 100
            v640 = v641 < v642
            if (v640):
                v643 = 2
                v644 = 0
                corpo___1_.translate(v643, v644)
                v645 = 2
                v646 = 0
                corpo___2_.translate(v645, v646)
                v647 = 2
                v648 = 0
                corpo___3_.translate(v647, v648)
                v649 = 2
                v650 = 0
                corpo___4_.translate(v649, v650)
                v651 = 2
                v652 = 0
                corpo___5_.translate(v651, v652)
                v653 = 2
                v654 = 0
                olho___1_.translate(v653, v654)
                v655 = 2
                v656 = 0
                olho___2_.translate(v655, v656)
                v657 = 2
                v658 = 0
                olho___11_.translate(v657, v658)
                v659 = 2
                v660 = 0
                olho___22_.translate(v659, v660)
                v661 = 2
                v662 = 0
                Borda____.translate(v661, v662)

            v665 = timer4_
            v666 = 100
            v664 = v665 >= v666
            v668 = timer4_
            v669 = 230
            v667 = v668 < v669
            v663 = v664 and v667
            if (v663):
                v670 = 0
                v671 = -2
                corpo___1_.translate(v670, v671)
                v672 = 0
                v673 = -2
                corpo___2_.translate(v672, v673)
                v674 = 0
                v675 = -2
                corpo___3_.translate(v674, v675)
                v676 = 0
                v677 = -2
                corpo___4_.translate(v676, v677)
                v678 = 0
                v679 = -2
                corpo___5_.translate(v678, v679)
                v680 = 0
                v681 = -2
                olho___1_.translate(v680, v681)
                v682 = 0
                v683 = -2
                olho___2_.translate(v682, v683)
                v684 = 0
                v685 = -2
                olho___11_.translate(v684, v685)
                v686 = 0
                v687 = -2
                olho___22_.translate(v686, v687)
                v688 = 0
                v689 = -2
                Borda____.translate(v688, v689)

            v692 = timer4_
            v693 = 230
            v691 = v692 >= v693
            v695 = timer4_
            v696 = 330
            v694 = v695 < v696
            v690 = v691 and v694
            if (v690):
                v697 = -2
                v698 = 0
                corpo___1_.translate(v697, v698)
                v699 = -2
                v700 = 0
                corpo___2_.translate(v699, v700)
                v701 = -2
                v702 = 0
                corpo___3_.translate(v701, v702)
                v703 = -2
                v704 = 0
                corpo___4_.translate(v703, v704)
                v705 = -2
                v706 = 0
                corpo___5_.translate(v705, v706)
                v707 = -2
                v708 = 0
                olho___1_.translate(v707, v708)
                v709 = -2
                v710 = 0
                olho___2_.translate(v709, v710)
                v711 = -2
                v712 = 0
                olho___11_.translate(v711, v712)
                v713 = -2
                v714 = 0
                olho___22_.translate(v713, v714)
                v715 = -2
                v716 = 0
                Borda____.translate(v715, v716)

            v719 = timer4_
            v720 = 330
            v718 = v719 >= v720
            v722 = timer4_
            v723 = 580
            v721 = v722 < v723
            v717 = v718 and v721
            if (v717):
                v724 = 2
                v725 = 0
                corpo___1_.translate(v724, v725)
                v726 = 2
                v727 = 0
                corpo___2_.translate(v726, v727)
                v728 = 2
                v729 = 0
                corpo___3_.translate(v728, v729)
                v730 = 2
                v731 = 0
                corpo___4_.translate(v730, v731)
                v732 = 2
                v733 = 0
                corpo___5_.translate(v732, v733)
                v734 = 2
                v735 = 0
                olho___1_.translate(v734, v735)
                v736 = 2
                v737 = 0
                olho___2_.translate(v736, v737)
                v738 = 2
                v739 = 0
                olho___11_.translate(v738, v739)
                v740 = 2
                v741 = 0
                olho___22_.translate(v740, v741)
                v742 = 2
                v743 = 0
                Borda____.translate(v742, v743)

            v746 = timer4_
            v747 = 580
            v745 = v746 >= v747
            v749 = timer4_
            v750 = 710
            v748 = v749 < v750
            v744 = v745 and v748
            if (v744):
                v751 = 0
                v752 = 2
                corpo___1_.translate(v751, v752)
                v753 = 0
                v754 = 2
                corpo___2_.translate(v753, v754)
                v755 = 0
                v756 = 2
                corpo___3_.translate(v755, v756)
                v757 = 0
                v758 = 2
                corpo___4_.translate(v757, v758)
                v759 = 0
                v760 = 2
                corpo___5_.translate(v759, v760)
                v761 = 0
                v762 = 2
                olho___1_.translate(v761, v762)
                v763 = 0
                v764 = 2
                olho___2_.translate(v763, v764)
                v765 = 0
                v766 = 2
                olho___11_.translate(v765, v766)
                v767 = 0
                v768 = 2
                olho___22_.translate(v767, v768)
                v769 = 0
                v770 = 2
                Borda____.translate(v769, v770)

            v773 = timer4_
            v774 = 710
            v772 = v773 >= v774
            v776 = timer4_
            v777 = 960
            v775 = v776 < v777
            v771 = v772 and v775
            if (v771):
                v778 = -2
                v779 = 0
                corpo___1_.translate(v778, v779)
                v780 = -2
                v781 = 0
                corpo___2_.translate(v780, v781)
                v782 = -2
                v783 = 0
                corpo___3_.translate(v782, v783)
                v784 = -2
                v785 = 0
                corpo___4_.translate(v784, v785)
                v786 = -2
                v787 = 0
                corpo___5_.translate(v786, v787)
                v788 = -2
                v789 = 0
                olho___1_.translate(v788, v789)
                v790 = -2
                v791 = 0
                olho___2_.translate(v790, v791)
                v792 = -2
                v793 = 0
                olho___11_.translate(v792, v793)
                v794 = -2
                v795 = 0
                olho___22_.translate(v794, v795)
                v796 = -2
                v797 = 0
                Borda____.translate(v796, v797)

            v799 = timer4_
            v800 = 960
            v798 = v799 == v800
            if (v798):
                v801 = -1
                timer4_ = v801

            corpo_.update()
            corpo1_.update()
            corpo_.update()
            corpo2_.update()
            corpo_.update()
            corpo3_.update()
            corpo_.update()
            corpo4_.update()
            corpo_.update()
            corpo5_.update()
            corpo_.update()
            olho1_.update()
            corpo_.update()
            olho2_.update()
            corpo_.update()
            olho11_.update()
            corpo_.update()
            olho22_.update()
            corpo_.update()
            Borda_.update()
            corpo_.update()
            corpo_1_.update()
            corpo_.update()
            corpo_2_.update()
            corpo_.update()
            corpo_3_.update()
            corpo_.update()
            corpo_4_.update()
            corpo_.update()
            corpo_5_.update()
            corpo_.update()
            olho_1_.update()
            corpo_.update()
            olho_2_.update()
            corpo_.update()
            olho_11_.update()
            corpo_.update()
            olho_22_.update()
            corpo_.update()
            Borda__.update()
            corpo_.update()
            corpo__1_.update()
            corpo_.update()
            corpo__2_.update()
            corpo_.update()
            corpo__3_.update()
            corpo_.update()
            corpo__4_.update()
            corpo_.update()
            corpo__5_.update()
            corpo_.update()
            olho__1_.update()
            corpo_.update()
            olho__2_.update()
            corpo_.update()
            olho__11_.update()
            corpo_.update()
            olho__22_.update()
            corpo_.update()
            Borda___.update()
            corpo_.update()
            corpo___1_.update()
            corpo_.update()
            corpo___2_.update()
            corpo_.update()
            corpo___3_.update()
            corpo_.update()
            corpo___4_.update()
            corpo_.update()
            corpo___5_.update()
            corpo_.update()
            olho___1_.update()
            corpo_.update()
            olho___2_.update()
            corpo_.update()
            olho___11_.update()
            corpo_.update()
            olho___22_.update()
            corpo_.update()
            Borda____.update()
            boca_.update()
            corpo1_.update()
            boca_.update()
            corpo2_.update()
            boca_.update()
            corpo3_.update()
            boca_.update()
            corpo4_.update()
            boca_.update()
            corpo5_.update()
            boca_.update()
            olho1_.update()
            boca_.update()
            olho2_.update()
            boca_.update()
            olho11_.update()
            boca_.update()
            olho22_.update()
            boca_.update()
            Borda_.update()
            boca_.update()
            corpo_1_.update()
            boca_.update()
            corpo_2_.update()
            boca_.update()
            corpo_3_.update()
            boca_.update()
            corpo_4_.update()
            boca_.update()
            corpo_5_.update()
            boca_.update()
            olho_1_.update()
            boca_.update()
            olho_2_.update()
            boca_.update()
            olho_11_.update()
            boca_.update()
            olho_22_.update()
            boca_.update()
            Borda__.update()
            boca_.update()
            corpo__1_.update()
            boca_.update()
            corpo__2_.update()
            boca_.update()
            corpo__3_.update()
            boca_.update()
            corpo__4_.update()
            boca_.update()
            corpo__5_.update()
            boca_.update()
            olho__1_.update()
            boca_.update()
            olho__2_.update()
            boca_.update()
            olho__11_.update()
            boca_.update()
            olho__22_.update()
            boca_.update()
            Borda___.update()
            boca_.update()
            corpo___1_.update()
            boca_.update()
            corpo___2_.update()
            boca_.update()
            corpo___3_.update()
            boca_.update()
            corpo___4_.update()
            boca_.update()
            corpo___5_.update()
            boca_.update()
            olho___1_.update()
            boca_.update()
            olho___2_.update()
            boca_.update()
            olho___11_.update()
            boca_.update()
            olho___22_.update()
            boca_.update()
            Borda____.update()
            v802 = figureCollision(corpo_.getRect(),corpo1_.getRect()) or figureCollision(corpo_.getRect(),corpo2_.getRect()) or figureCollision(corpo_.getRect(),corpo3_.getRect()) or figureCollision(corpo_.getRect(),corpo4_.getRect()) or figureCollision(corpo_.getRect(),corpo5_.getRect()) or figureCollision(corpo_.getRect(),olho1_.getRect()) or figureCollision(corpo_.getRect(),olho2_.getRect()) or figureCollision(corpo_.getRect(),olho11_.getRect()) or figureCollision(corpo_.getRect(),olho22_.getRect()) or figureCollision(corpo_.getRect(),Borda_.getRect()) or figureCollision(corpo_.getRect(),corpo_1_.getRect()) or figureCollision(corpo_.getRect(),corpo_2_.getRect()) or figureCollision(corpo_.getRect(),corpo_3_.getRect()) or figureCollision(corpo_.getRect(),corpo_4_.getRect()) or figureCollision(corpo_.getRect(),corpo_5_.getRect()) or figureCollision(corpo_.getRect(),olho_1_.getRect()) or figureCollision(corpo_.getRect(),olho_2_.getRect()) or figureCollision(corpo_.getRect(),olho_11_.getRect()) or figureCollision(corpo_.getRect(),olho_22_.getRect()) or figureCollision(corpo_.getRect(),Borda__.getRect()) or figureCollision(corpo_.getRect(),corpo__1_.getRect()) or figureCollision(corpo_.getRect(),corpo__2_.getRect()) or figureCollision(corpo_.getRect(),corpo__3_.getRect()) or figureCollision(corpo_.getRect(),corpo__4_.getRect()) or figureCollision(corpo_.getRect(),corpo__5_.getRect()) or figureCollision(corpo_.getRect(),olho__1_.getRect()) or figureCollision(corpo_.getRect(),olho__2_.getRect()) or figureCollision(corpo_.getRect(),olho__11_.getRect()) or figureCollision(corpo_.getRect(),olho__22_.getRect()) or figureCollision(corpo_.getRect(),Borda___.getRect()) or figureCollision(corpo_.getRect(),corpo___1_.getRect()) or figureCollision(corpo_.getRect(),corpo___2_.getRect()) or figureCollision(corpo_.getRect(),corpo___3_.getRect()) or figureCollision(corpo_.getRect(),corpo___4_.getRect()) or figureCollision(corpo_.getRect(),corpo___5_.getRect()) or figureCollision(corpo_.getRect(),olho___1_.getRect()) or figureCollision(corpo_.getRect(),olho___2_.getRect()) or figureCollision(corpo_.getRect(),olho___11_.getRect()) or figureCollision(corpo_.getRect(),olho___22_.getRect()) or figureCollision(corpo_.getRect(),Borda____.getRect()) or figureCollision(boca_.getRect(),corpo1_.getRect()) or figureCollision(boca_.getRect(),corpo2_.getRect()) or figureCollision(boca_.getRect(),corpo3_.getRect()) or figureCollision(boca_.getRect(),corpo4_.getRect()) or figureCollision(boca_.getRect(),corpo5_.getRect()) or figureCollision(boca_.getRect(),olho1_.getRect()) or figureCollision(boca_.getRect(),olho2_.getRect()) or figureCollision(boca_.getRect(),olho11_.getRect()) or figureCollision(boca_.getRect(),olho22_.getRect()) or figureCollision(boca_.getRect(),Borda_.getRect()) or figureCollision(boca_.getRect(),corpo_1_.getRect()) or figureCollision(boca_.getRect(),corpo_2_.getRect()) or figureCollision(boca_.getRect(),corpo_3_.getRect()) or figureCollision(boca_.getRect(),corpo_4_.getRect()) or figureCollision(boca_.getRect(),corpo_5_.getRect()) or figureCollision(boca_.getRect(),olho_1_.getRect()) or figureCollision(boca_.getRect(),olho_2_.getRect()) or figureCollision(boca_.getRect(),olho_11_.getRect()) or figureCollision(boca_.getRect(),olho_22_.getRect()) or figureCollision(boca_.getRect(),Borda__.getRect()) or figureCollision(boca_.getRect(),corpo__1_.getRect()) or figureCollision(boca_.getRect(),corpo__2_.getRect()) or figureCollision(boca_.getRect(),corpo__3_.getRect()) or figureCollision(boca_.getRect(),corpo__4_.getRect()) or figureCollision(boca_.getRect(),corpo__5_.getRect()) or figureCollision(boca_.getRect(),olho__1_.getRect()) or figureCollision(boca_.getRect(),olho__2_.getRect()) or figureCollision(boca_.getRect(),olho__11_.getRect()) or figureCollision(boca_.getRect(),olho__22_.getRect()) or figureCollision(boca_.getRect(),Borda___.getRect()) or figureCollision(boca_.getRect(),corpo___1_.getRect()) or figureCollision(boca_.getRect(),corpo___2_.getRect()) or figureCollision(boca_.getRect(),corpo___3_.getRect()) or figureCollision(boca_.getRect(),corpo___4_.getRect()) or figureCollision(boca_.getRect(),corpo___5_.getRect()) or figureCollision(boca_.getRect(),olho___1_.getRect()) or figureCollision(boca_.getRect(),olho___2_.getRect()) or figureCollision(boca_.getRect(),olho___11_.getRect()) or figureCollision(boca_.getRect(),olho___22_.getRect()) or figureCollision(boca_.getRect(),Borda____.getRect())
            if (v802):
                v803 = False
                run_ = v803
                v804 = corpo1_.x
                v1_ = v804
                v805 = corpo1_.y
                v2_ = v805
                v808 = v1_
                v809 = -1
                v807 = v808 * v809
                v810 = 50
                v806 = v807 + v810
                v813 = v2_
                v814 = -1
                v812 = v813 * v814
                v815 = 50
                v811 = v812 + v815
                corpo1_.translate(v806, v811)
                v818 = v1_
                v819 = -1
                v817 = v818 * v819
                v820 = 50
                v816 = v817 + v820
                v823 = v2_
                v824 = -1
                v822 = v823 * v824
                v825 = 50
                v821 = v822 + v825
                corpo2_.translate(v816, v821)
                v828 = v1_
                v829 = -1
                v827 = v828 * v829
                v830 = 50
                v826 = v827 + v830
                v833 = v2_
                v834 = -1
                v832 = v833 * v834
                v835 = 50
                v831 = v832 + v835
                corpo3_.translate(v826, v831)
                v838 = v1_
                v839 = -1
                v837 = v838 * v839
                v840 = 50
                v836 = v837 + v840
                v843 = v2_
                v844 = -1
                v842 = v843 * v844
                v845 = 50
                v841 = v842 + v845
                corpo4_.translate(v836, v841)
                v848 = v1_
                v849 = -1
                v847 = v848 * v849
                v850 = 50
                v846 = v847 + v850
                v853 = v2_
                v854 = -1
                v852 = v853 * v854
                v855 = 50
                v851 = v852 + v855
                corpo5_.translate(v846, v851)
                v858 = v1_
                v859 = -1
                v857 = v858 * v859
                v860 = 50
                v856 = v857 + v860
                v863 = v2_
                v864 = -1
                v862 = v863 * v864
                v865 = 50
                v861 = v862 + v865
                olho1_.translate(v856, v861)
                v868 = v1_
                v869 = -1
                v867 = v868 * v869
                v870 = 50
                v866 = v867 + v870
                v873 = v2_
                v874 = -1
                v872 = v873 * v874
                v875 = 50
                v871 = v872 + v875
                olho2_.translate(v866, v871)
                v878 = v1_
                v879 = -1
                v877 = v878 * v879
                v880 = 50
                v876 = v877 + v880
                v883 = v2_
                v884 = -1
                v882 = v883 * v884
                v885 = 50
                v881 = v882 + v885
                olho11_.translate(v876, v881)
                v888 = v1_
                v889 = -1
                v887 = v888 * v889
                v890 = 50
                v886 = v887 + v890
                v893 = v2_
                v894 = -1
                v892 = v893 * v894
                v895 = 50
                v891 = v892 + v895
                olho22_.translate(v886, v891)
                v898 = v1_
                v899 = -1
                v897 = v898 * v899
                v900 = 50
                v896 = v897 + v900
                v903 = v2_
                v904 = -1
                v902 = v903 * v904
                v905 = 50
                v901 = v902 + v905
                Borda_.translate(v896, v901)
                v906 = corpo_1_.x
                v1_ = v906
                v907 = corpo_1_.y
                v2_ = v907
                v910 = v1_
                v911 = -1
                v909 = v910 * v911
                v912 = 50
                v908 = v909 + v912
                v915 = v2_
                v916 = -1
                v914 = v915 * v916
                v917 = 850
                v913 = v914 + v917
                corpo_1_.translate(v908, v913)
                v920 = v1_
                v921 = -1
                v919 = v920 * v921
                v922 = 50
                v918 = v919 + v922
                v925 = v2_
                v926 = -1
                v924 = v925 * v926
                v927 = 850
                v923 = v924 + v927
                corpo_2_.translate(v918, v923)
                v930 = v1_
                v931 = -1
                v929 = v930 * v931
                v932 = 50
                v928 = v929 + v932
                v935 = v2_
                v936 = -1
                v934 = v935 * v936
                v937 = 850
                v933 = v934 + v937
                corpo_3_.translate(v928, v933)
                v940 = v1_
                v941 = -1
                v939 = v940 * v941
                v942 = 50
                v938 = v939 + v942
                v945 = v2_
                v946 = -1
                v944 = v945 * v946
                v947 = 850
                v943 = v944 + v947
                corpo_4_.translate(v938, v943)
                v950 = v1_
                v951 = -1
                v949 = v950 * v951
                v952 = 50
                v948 = v949 + v952
                v955 = v2_
                v956 = -1
                v954 = v955 * v956
                v957 = 850
                v953 = v954 + v957
                corpo_5_.translate(v948, v953)
                v960 = v1_
                v961 = -1
                v959 = v960 * v961
                v962 = 50
                v958 = v959 + v962
                v965 = v2_
                v966 = -1
                v964 = v965 * v966
                v967 = 850
                v963 = v964 + v967
                olho_1_.translate(v958, v963)
                v970 = v1_
                v971 = -1
                v969 = v970 * v971
                v972 = 50
                v968 = v969 + v972
                v975 = v2_
                v976 = -1
                v974 = v975 * v976
                v977 = 850
                v973 = v974 + v977
                olho_2_.translate(v968, v973)
                v980 = v1_
                v981 = -1
                v979 = v980 * v981
                v982 = 50
                v978 = v979 + v982
                v985 = v2_
                v986 = -1
                v984 = v985 * v986
                v987 = 850
                v983 = v984 + v987
                olho_11_.translate(v978, v983)
                v990 = v1_
                v991 = -1
                v989 = v990 * v991
                v992 = 50
                v988 = v989 + v992
                v995 = v2_
                v996 = -1
                v994 = v995 * v996
                v997 = 850
                v993 = v994 + v997
                olho_22_.translate(v988, v993)
                v1000 = v1_
                v1001 = -1
                v999 = v1000 * v1001
                v1002 = 50
                v998 = v999 + v1002
                v1005 = v2_
                v1006 = -1
                v1004 = v1005 * v1006
                v1007 = 850
                v1003 = v1004 + v1007
                Borda__.translate(v998, v1003)
                v1008 = corpo__1_.x
                v1_ = v1008
                v1009 = corpo__1_.y
                v2_ = v1009
                v1012 = v1_
                v1013 = -1
                v1011 = v1012 * v1013
                v1014 = 750
                v1010 = v1011 + v1014
                v1017 = v2_
                v1018 = -1
                v1016 = v1017 * v1018
                v1019 = 50
                v1015 = v1016 + v1019
                corpo__1_.translate(v1010, v1015)
                v1022 = v1_
                v1023 = -1
                v1021 = v1022 * v1023
                v1024 = 750
                v1020 = v1021 + v1024
                v1027 = v2_
                v1028 = -1
                v1026 = v1027 * v1028
                v1029 = 50
                v1025 = v1026 + v1029
                corpo__2_.translate(v1020, v1025)
                v1032 = v1_
                v1033 = -1
                v1031 = v1032 * v1033
                v1034 = 750
                v1030 = v1031 + v1034
                v1037 = v2_
                v1038 = -1
                v1036 = v1037 * v1038
                v1039 = 50
                v1035 = v1036 + v1039
                corpo__3_.translate(v1030, v1035)
                v1042 = v1_
                v1043 = -1
                v1041 = v1042 * v1043
                v1044 = 750
                v1040 = v1041 + v1044
                v1047 = v2_
                v1048 = -1
                v1046 = v1047 * v1048
                v1049 = 50
                v1045 = v1046 + v1049
                corpo__4_.translate(v1040, v1045)
                v1052 = v1_
                v1053 = -1
                v1051 = v1052 * v1053
                v1054 = 750
                v1050 = v1051 + v1054
                v1057 = v2_
                v1058 = -1
                v1056 = v1057 * v1058
                v1059 = 50
                v1055 = v1056 + v1059
                corpo__5_.translate(v1050, v1055)
                v1062 = v1_
                v1063 = -1
                v1061 = v1062 * v1063
                v1064 = 750
                v1060 = v1061 + v1064
                v1067 = v2_
                v1068 = -1
                v1066 = v1067 * v1068
                v1069 = 50
                v1065 = v1066 + v1069
                olho__1_.translate(v1060, v1065)
                v1072 = v1_
                v1073 = -1
                v1071 = v1072 * v1073
                v1074 = 750
                v1070 = v1071 + v1074
                v1077 = v2_
                v1078 = -1
                v1076 = v1077 * v1078
                v1079 = 50
                v1075 = v1076 + v1079
                olho__2_.translate(v1070, v1075)
                v1082 = v1_
                v1083 = -1
                v1081 = v1082 * v1083
                v1084 = 750
                v1080 = v1081 + v1084
                v1087 = v2_
                v1088 = -1
                v1086 = v1087 * v1088
                v1089 = 50
                v1085 = v1086 + v1089
                olho__11_.translate(v1080, v1085)
                v1092 = v1_
                v1093 = -1
                v1091 = v1092 * v1093
                v1094 = 750
                v1090 = v1091 + v1094
                v1097 = v2_
                v1098 = -1
                v1096 = v1097 * v1098
                v1099 = 50
                v1095 = v1096 + v1099
                olho__22_.translate(v1090, v1095)
                v1102 = v1_
                v1103 = -1
                v1101 = v1102 * v1103
                v1104 = 750
                v1100 = v1101 + v1104
                v1107 = v2_
                v1108 = -1
                v1106 = v1107 * v1108
                v1109 = 50
                v1105 = v1106 + v1109
                Borda___.translate(v1100, v1105)
                v1110 = corpo___1_.x
                v1_ = v1110
                v1111 = corpo___1_.y
                v2_ = v1111
                v1114 = v1_
                v1115 = -1
                v1113 = v1114 * v1115
                v1116 = 750
                v1112 = v1113 + v1116
                v1119 = v2_
                v1120 = -1
                v1118 = v1119 * v1120
                v1121 = 850
                v1117 = v1118 + v1121
                corpo___1_.translate(v1112, v1117)
                v1124 = v1_
                v1125 = -1
                v1123 = v1124 * v1125
                v1126 = 750
                v1122 = v1123 + v1126
                v1129 = v2_
                v1130 = -1
                v1128 = v1129 * v1130
                v1131 = 850
                v1127 = v1128 + v1131
                corpo___2_.translate(v1122, v1127)
                v1134 = v1_
                v1135 = -1
                v1133 = v1134 * v1135
                v1136 = 750
                v1132 = v1133 + v1136
                v1139 = v2_
                v1140 = -1
                v1138 = v1139 * v1140
                v1141 = 850
                v1137 = v1138 + v1141
                corpo___3_.translate(v1132, v1137)
                v1144 = v1_
                v1145 = -1
                v1143 = v1144 * v1145
                v1146 = 750
                v1142 = v1143 + v1146
                v1149 = v2_
                v1150 = -1
                v1148 = v1149 * v1150
                v1151 = 850
                v1147 = v1148 + v1151
                corpo___4_.translate(v1142, v1147)
                v1154 = v1_
                v1155 = -1
                v1153 = v1154 * v1155
                v1156 = 750
                v1152 = v1153 + v1156
                v1159 = v2_
                v1160 = -1
                v1158 = v1159 * v1160
                v1161 = 850
                v1157 = v1158 + v1161
                corpo___5_.translate(v1152, v1157)
                v1164 = v1_
                v1165 = -1
                v1163 = v1164 * v1165
                v1166 = 750
                v1162 = v1163 + v1166
                v1169 = v2_
                v1170 = -1
                v1168 = v1169 * v1170
                v1171 = 850
                v1167 = v1168 + v1171
                olho___1_.translate(v1162, v1167)
                v1174 = v1_
                v1175 = -1
                v1173 = v1174 * v1175
                v1176 = 750
                v1172 = v1173 + v1176
                v1179 = v2_
                v1180 = -1
                v1178 = v1179 * v1180
                v1181 = 850
                v1177 = v1178 + v1181
                olho___2_.translate(v1172, v1177)
                v1184 = v1_
                v1185 = -1
                v1183 = v1184 * v1185
                v1186 = 750
                v1182 = v1183 + v1186
                v1189 = v2_
                v1190 = -1
                v1188 = v1189 * v1190
                v1191 = 850
                v1187 = v1188 + v1191
                olho___11_.translate(v1182, v1187)
                v1194 = v1_
                v1195 = -1
                v1193 = v1194 * v1195
                v1196 = 750
                v1192 = v1193 + v1196
                v1199 = v2_
                v1200 = -1
                v1198 = v1199 * v1200
                v1201 = 850
                v1197 = v1198 + v1201
                olho___22_.translate(v1192, v1197)
                v1204 = v1_
                v1205 = -1
                v1203 = v1204 * v1205
                v1206 = 750
                v1202 = v1203 + v1206
                v1209 = v2_
                v1210 = -1
                v1208 = v1209 * v1210
                v1211 = 850
                v1207 = v1208 + v1211
                Borda____.translate(v1202, v1207)
                v1212 = corpo_.x
                v1_ = v1212
                v1213 = corpo_.y
                v2_ = v1213
                v1216 = v1_
                v1217 = -1
                v1215 = v1216 * v1217
                v1218 = 400
                v1214 = v1215 + v1218
                v1221 = v2_
                v1222 = -1
                v1220 = v1221 * v1222
                v1223 = 550
                v1219 = v1220 + v1223
                corpo_.translate(v1214, v1219)
                v1226 = v1_
                v1227 = -1
                v1225 = v1226 * v1227
                v1228 = 400
                v1224 = v1225 + v1228
                v1231 = v2_
                v1232 = -1
                v1230 = v1231 * v1232
                v1233 = 550
                v1229 = v1230 + v1233
                boca_.translate(v1224, v1229)

            v1235 = timer4_
            v1236 = 1
            v1234 = v1235 + v1236
            timer4_ = v1234
            v1238 = timer3_
            v1239 = 1
            v1237 = v1238 + v1239
            timer3_ = v1237
            v1241 = timer2_
            v1242 = 1
            v1240 = v1241 + v1242
            timer2_ = v1240
            v1244 = timer1_
            v1245 = 1
            v1243 = v1244 + v1245
            timer1_ = v1243
            corpo_.update()
            c1_.update()
            boca_.update()
            c1_.update()
            v1246 = figureCollision(corpo_.getRect(),c1_.getRect()) or figureCollision(boca_.getRect(),c1_.getRect())
            if (v1246):
                v1247 = True
                c1_.hidden = v1247
                v1249 = moeda_
                v1250 = 1
                v1248 = v1249 - v1250
                moeda_ = v1248

            corpo_.update()
            c2_.update()
            boca_.update()
            c2_.update()
            v1251 = figureCollision(corpo_.getRect(),c2_.getRect()) or figureCollision(boca_.getRect(),c2_.getRect())
            if (v1251):
                v1252 = True
                c2_.hidden = v1252
                v1254 = moeda_
                v1255 = 1
                v1253 = v1254 - v1255
                moeda_ = v1253

            corpo_.update()
            c3_.update()
            boca_.update()
            c3_.update()
            v1256 = figureCollision(corpo_.getRect(),c3_.getRect()) or figureCollision(boca_.getRect(),c3_.getRect())
            if (v1256):
                v1257 = True
                c3_.hidden = v1257
                v1259 = moeda_
                v1260 = 1
                v1258 = v1259 - v1260
                moeda_ = v1258

            corpo_.update()
            c4_.update()
            boca_.update()
            c4_.update()
            v1261 = figureCollision(corpo_.getRect(),c4_.getRect()) or figureCollision(boca_.getRect(),c4_.getRect())
            if (v1261):
                v1262 = True
                c4_.hidden = v1262
                v1264 = moeda_
                v1265 = 1
                v1263 = v1264 - v1265
                moeda_ = v1263

            corpo_.update()
            c5_.update()
            boca_.update()
            c5_.update()
            v1266 = figureCollision(corpo_.getRect(),c5_.getRect()) or figureCollision(boca_.getRect(),c5_.getRect())
            if (v1266):
                v1267 = True
                c5_.hidden = v1267
                v1269 = moeda_
                v1270 = 1
                v1268 = v1269 - v1270
                moeda_ = v1268

            corpo_.update()
            c6_.update()
            boca_.update()
            c6_.update()
            v1271 = figureCollision(corpo_.getRect(),c6_.getRect()) or figureCollision(boca_.getRect(),c6_.getRect())
            if (v1271):
                v1272 = True
                c6_.hidden = v1272
                v1274 = moeda_
                v1275 = 1
                v1273 = v1274 - v1275
                moeda_ = v1273

            corpo_.update()
            c7_.update()
            boca_.update()
            c7_.update()
            v1276 = figureCollision(corpo_.getRect(),c7_.getRect()) or figureCollision(boca_.getRect(),c7_.getRect())
            if (v1276):
                v1277 = True
                c7_.hidden = v1277
                v1279 = moeda_
                v1280 = 1
                v1278 = v1279 - v1280
                moeda_ = v1278

            corpo_.update()
            c8_.update()
            boca_.update()
            c8_.update()
            v1281 = figureCollision(corpo_.getRect(),c8_.getRect()) or figureCollision(boca_.getRect(),c8_.getRect())
            if (v1281):
                v1282 = True
                c8_.hidden = v1282
                v1284 = moeda_
                v1285 = 1
                v1283 = v1284 - v1285
                moeda_ = v1283

            corpo_.update()
            c9_.update()
            boca_.update()
            c9_.update()
            v1286 = figureCollision(corpo_.getRect(),c9_.getRect()) or figureCollision(boca_.getRect(),c9_.getRect())
            if (v1286):
                v1287 = True
                c9_.hidden = v1287
                v1289 = moeda_
                v1290 = 1
                v1288 = v1289 - v1290
                moeda_ = v1288

            corpo_.update()
            c10_.update()
            boca_.update()
            c10_.update()
            v1291 = figureCollision(corpo_.getRect(),c10_.getRect()) or figureCollision(boca_.getRect(),c10_.getRect())
            if (v1291):
                v1292 = True
                c10_.hidden = v1292
                v1294 = moeda_
                v1295 = 1
                v1293 = v1294 - v1295
                moeda_ = v1293

            corpo_.update()
            c11_.update()
            boca_.update()
            c11_.update()
            v1296 = figureCollision(corpo_.getRect(),c11_.getRect()) or figureCollision(boca_.getRect(),c11_.getRect())
            if (v1296):
                v1297 = True
                c11_.hidden = v1297
                v1299 = moeda_
                v1300 = 1
                v1298 = v1299 - v1300
                moeda_ = v1298

            corpo_.update()
            c12_.update()
            boca_.update()
            c12_.update()
            v1301 = figureCollision(corpo_.getRect(),c12_.getRect()) or figureCollision(boca_.getRect(),c12_.getRect())
            if (v1301):
                v1302 = True
                c12_.hidden = v1302
                v1304 = moeda_
                v1305 = 1
                v1303 = v1304 - v1305
                moeda_ = v1303

            corpo_.update()
            c13_.update()
            boca_.update()
            c13_.update()
            v1306 = figureCollision(corpo_.getRect(),c13_.getRect()) or figureCollision(boca_.getRect(),c13_.getRect())
            if (v1306):
                v1307 = True
                c13_.hidden = v1307
                v1309 = moeda_
                v1310 = 1
                v1308 = v1309 - v1310
                moeda_ = v1308

            corpo_.update()
            c14_.update()
            boca_.update()
            c14_.update()
            v1311 = figureCollision(corpo_.getRect(),c14_.getRect()) or figureCollision(boca_.getRect(),c14_.getRect())
            if (v1311):
                v1312 = True
                c14_.hidden = v1312
                v1314 = moeda_
                v1315 = 1
                v1313 = v1314 - v1315
                moeda_ = v1313

            corpo_.update()
            c15_.update()
            boca_.update()
            c15_.update()
            v1316 = figureCollision(corpo_.getRect(),c15_.getRect()) or figureCollision(boca_.getRect(),c15_.getRect())
            if (v1316):
                v1317 = True
                c15_.hidden = v1317
                v1319 = moeda_
                v1320 = 1
                v1318 = v1319 - v1320
                moeda_ = v1318

            corpo_.update()
            c16_.update()
            boca_.update()
            c16_.update()
            v1321 = figureCollision(corpo_.getRect(),c16_.getRect()) or figureCollision(boca_.getRect(),c16_.getRect())
            if (v1321):
                v1322 = True
                c16_.hidden = v1322
                v1324 = moeda_
                v1325 = 1
                v1323 = v1324 - v1325
                moeda_ = v1323

            corpo_.update()
            c17_.update()
            boca_.update()
            c17_.update()
            v1326 = figureCollision(corpo_.getRect(),c17_.getRect()) or figureCollision(boca_.getRect(),c17_.getRect())
            if (v1326):
                v1327 = True
                c17_.hidden = v1327
                v1329 = moeda_
                v1330 = 1
                v1328 = v1329 - v1330
                moeda_ = v1328

            corpo_.update()
            c18_.update()
            boca_.update()
            c18_.update()
            v1331 = figureCollision(corpo_.getRect(),c18_.getRect()) or figureCollision(boca_.getRect(),c18_.getRect())
            if (v1331):
                v1332 = True
                c18_.hidden = v1332
                v1334 = moeda_
                v1335 = 1
                v1333 = v1334 - v1335
                moeda_ = v1333

            corpo_.update()
            c19_.update()
            boca_.update()
            c19_.update()
            v1336 = figureCollision(corpo_.getRect(),c19_.getRect()) or figureCollision(boca_.getRect(),c19_.getRect())
            if (v1336):
                v1337 = True
                c19_.hidden = v1337
                v1339 = moeda_
                v1340 = 1
                v1338 = v1339 - v1340
                moeda_ = v1338

            corpo_.update()
            c20_.update()
            boca_.update()
            c20_.update()
            v1341 = figureCollision(corpo_.getRect(),c20_.getRect()) or figureCollision(boca_.getRect(),c20_.getRect())
            if (v1341):
                v1342 = True
                c20_.hidden = v1342
                v1344 = moeda_
                v1345 = 1
                v1343 = v1344 - v1345
                moeda_ = v1343

            corpo_.update()
            c21_.update()
            boca_.update()
            c21_.update()
            v1346 = figureCollision(corpo_.getRect(),c21_.getRect()) or figureCollision(boca_.getRect(),c21_.getRect())
            if (v1346):
                v1347 = True
                c21_.hidden = v1347
                v1349 = moeda_
                v1350 = 1
                v1348 = v1349 - v1350
                moeda_ = v1348

            corpo_.update()
            c22_.update()
            boca_.update()
            c22_.update()
            v1351 = figureCollision(corpo_.getRect(),c22_.getRect()) or figureCollision(boca_.getRect(),c22_.getRect())
            if (v1351):
                v1352 = True
                c22_.hidden = v1352
                v1354 = moeda_
                v1355 = 1
                v1353 = v1354 - v1355
                moeda_ = v1353

            corpo_.update()
            c23_.update()
            boca_.update()
            c23_.update()
            v1356 = figureCollision(corpo_.getRect(),c23_.getRect()) or figureCollision(boca_.getRect(),c23_.getRect())
            if (v1356):
                v1357 = True
                c23_.hidden = v1357
                v1359 = moeda_
                v1360 = 1
                v1358 = v1359 - v1360
                moeda_ = v1358

            corpo_.update()
            c24_.update()
            boca_.update()
            c24_.update()
            v1361 = figureCollision(corpo_.getRect(),c24_.getRect()) or figureCollision(boca_.getRect(),c24_.getRect())
            if (v1361):
                v1362 = True
                c24_.hidden = v1362
                v1364 = moeda_
                v1365 = 1
                v1363 = v1364 - v1365
                moeda_ = v1363

            corpo_.update()
            c25_.update()
            boca_.update()
            c25_.update()
            v1366 = figureCollision(corpo_.getRect(),c25_.getRect()) or figureCollision(boca_.getRect(),c25_.getRect())
            if (v1366):
                v1367 = True
                c25_.hidden = v1367
                v1369 = moeda_
                v1370 = 1
                v1368 = v1369 - v1370
                moeda_ = v1368

            corpo_.update()
            c26_.update()
            boca_.update()
            c26_.update()
            v1371 = figureCollision(corpo_.getRect(),c26_.getRect()) or figureCollision(boca_.getRect(),c26_.getRect())
            if (v1371):
                v1372 = True
                c26_.hidden = v1372
                v1374 = moeda_
                v1375 = 1
                v1373 = v1374 - v1375
                moeda_ = v1373

            corpo_.update()
            c27_.update()
            boca_.update()
            c27_.update()
            v1376 = figureCollision(corpo_.getRect(),c27_.getRect()) or figureCollision(boca_.getRect(),c27_.getRect())
            if (v1376):
                v1377 = True
                c27_.hidden = v1377
                v1379 = moeda_
                v1380 = 1
                v1378 = v1379 - v1380
                moeda_ = v1378

            corpo_.update()
            c28_.update()
            boca_.update()
            c28_.update()
            v1381 = figureCollision(corpo_.getRect(),c28_.getRect()) or figureCollision(boca_.getRect(),c28_.getRect())
            if (v1381):
                v1382 = True
                c28_.hidden = v1382
                v1384 = moeda_
                v1385 = 1
                v1383 = v1384 - v1385
                moeda_ = v1383

            corpo_.update()
            c29_.update()
            boca_.update()
            c29_.update()
            v1386 = figureCollision(corpo_.getRect(),c29_.getRect()) or figureCollision(boca_.getRect(),c29_.getRect())
            if (v1386):
                v1387 = True
                c29_.hidden = v1387
                v1389 = moeda_
                v1390 = 1
                v1388 = v1389 - v1390
                moeda_ = v1388

            corpo_.update()
            c30_.update()
            boca_.update()
            c30_.update()
            v1391 = figureCollision(corpo_.getRect(),c30_.getRect()) or figureCollision(boca_.getRect(),c30_.getRect())
            if (v1391):
                v1392 = True
                c30_.hidden = v1392
                v1394 = moeda_
                v1395 = 1
                v1393 = v1394 - v1395
                moeda_ = v1393

            corpo_.update()
            c31_.update()
            boca_.update()
            c31_.update()
            v1396 = figureCollision(corpo_.getRect(),c31_.getRect()) or figureCollision(boca_.getRect(),c31_.getRect())
            if (v1396):
                v1397 = True
                c31_.hidden = v1397
                v1399 = moeda_
                v1400 = 1
                v1398 = v1399 - v1400
                moeda_ = v1398

            corpo_.update()
            c32_.update()
            boca_.update()
            c32_.update()
            v1401 = figureCollision(corpo_.getRect(),c32_.getRect()) or figureCollision(boca_.getRect(),c32_.getRect())
            if (v1401):
                v1402 = True
                c32_.hidden = v1402
                v1404 = moeda_
                v1405 = 1
                v1403 = v1404 - v1405
                moeda_ = v1403

            corpo_.update()
            c33_.update()
            boca_.update()
            c33_.update()
            v1406 = figureCollision(corpo_.getRect(),c33_.getRect()) or figureCollision(boca_.getRect(),c33_.getRect())
            if (v1406):
                v1407 = True
                c33_.hidden = v1407
                v1409 = moeda_
                v1410 = 1
                v1408 = v1409 - v1410
                moeda_ = v1408

            corpo_.update()
            c34_.update()
            boca_.update()
            c34_.update()
            v1411 = figureCollision(corpo_.getRect(),c34_.getRect()) or figureCollision(boca_.getRect(),c34_.getRect())
            if (v1411):
                v1412 = True
                c34_.hidden = v1412
                v1414 = moeda_
                v1415 = 1
                v1413 = v1414 - v1415
                moeda_ = v1413

            corpo_.update()
            c35_.update()
            boca_.update()
            c35_.update()
            v1416 = figureCollision(corpo_.getRect(),c35_.getRect()) or figureCollision(boca_.getRect(),c35_.getRect())
            if (v1416):
                v1417 = True
                c35_.hidden = v1417
                v1419 = moeda_
                v1420 = 1
                v1418 = v1419 - v1420
                moeda_ = v1418

            corpo_.update()
            c36_.update()
            boca_.update()
            c36_.update()
            v1421 = figureCollision(corpo_.getRect(),c36_.getRect()) or figureCollision(boca_.getRect(),c36_.getRect())
            if (v1421):
                v1422 = True
                c36_.hidden = v1422
                v1424 = moeda_
                v1425 = 1
                v1423 = v1424 - v1425
                moeda_ = v1423

            corpo_.update()
            c37_.update()
            boca_.update()
            c37_.update()
            v1426 = figureCollision(corpo_.getRect(),c37_.getRect()) or figureCollision(boca_.getRect(),c37_.getRect())
            if (v1426):
                v1427 = True
                c37_.hidden = v1427
                v1429 = moeda_
                v1430 = 1
                v1428 = v1429 - v1430
                moeda_ = v1428

            corpo_.update()
            c38_.update()
            boca_.update()
            c38_.update()
            v1431 = figureCollision(corpo_.getRect(),c38_.getRect()) or figureCollision(boca_.getRect(),c38_.getRect())
            if (v1431):
                v1432 = True
                c38_.hidden = v1432
                v1434 = moeda_
                v1435 = 1
                v1433 = v1434 - v1435
                moeda_ = v1433

            corpo_.update()
            c39_.update()
            boca_.update()
            c39_.update()
            v1436 = figureCollision(corpo_.getRect(),c39_.getRect()) or figureCollision(boca_.getRect(),c39_.getRect())
            if (v1436):
                v1437 = True
                c39_.hidden = v1437
                v1439 = moeda_
                v1440 = 1
                v1438 = v1439 - v1440
                moeda_ = v1438

            corpo_.update()
            c40_.update()
            boca_.update()
            c40_.update()
            v1441 = figureCollision(corpo_.getRect(),c40_.getRect()) or figureCollision(boca_.getRect(),c40_.getRect())
            if (v1441):
                v1442 = True
                c40_.hidden = v1442
                v1444 = moeda_
                v1445 = 1
                v1443 = v1444 - v1445
                moeda_ = v1443

            corpo_.update()
            c41_.update()
            boca_.update()
            c41_.update()
            v1446 = figureCollision(corpo_.getRect(),c41_.getRect()) or figureCollision(boca_.getRect(),c41_.getRect())
            if (v1446):
                v1447 = True
                c41_.hidden = v1447
                v1449 = moeda_
                v1450 = 1
                v1448 = v1449 - v1450
                moeda_ = v1448

            corpo_.update()
            c42_.update()
            boca_.update()
            c42_.update()
            v1451 = figureCollision(corpo_.getRect(),c42_.getRect()) or figureCollision(boca_.getRect(),c42_.getRect())
            if (v1451):
                v1452 = True
                c42_.hidden = v1452
                v1454 = moeda_
                v1455 = 1
                v1453 = v1454 - v1455
                moeda_ = v1453

            corpo_.update()
            c43_.update()
            boca_.update()
            c43_.update()
            v1456 = figureCollision(corpo_.getRect(),c43_.getRect()) or figureCollision(boca_.getRect(),c43_.getRect())
            if (v1456):
                v1457 = True
                c43_.hidden = v1457
                v1459 = moeda_
                v1460 = 1
                v1458 = v1459 - v1460
                moeda_ = v1458

            corpo_.update()
            c44_.update()
            boca_.update()
            c44_.update()
            v1461 = figureCollision(corpo_.getRect(),c44_.getRect()) or figureCollision(boca_.getRect(),c44_.getRect())
            if (v1461):
                v1462 = True
                c44_.hidden = v1462
                v1464 = moeda_
                v1465 = 1
                v1463 = v1464 - v1465
                moeda_ = v1463

            corpo_.update()
            c45_.update()
            boca_.update()
            c45_.update()
            v1466 = figureCollision(corpo_.getRect(),c45_.getRect()) or figureCollision(boca_.getRect(),c45_.getRect())
            if (v1466):
                v1467 = True
                c45_.hidden = v1467
                v1469 = moeda_
                v1470 = 1
                v1468 = v1469 - v1470
                moeda_ = v1468

            corpo_.update()
            c46_.update()
            boca_.update()
            c46_.update()
            v1471 = figureCollision(corpo_.getRect(),c46_.getRect()) or figureCollision(boca_.getRect(),c46_.getRect())
            if (v1471):
                v1472 = True
                c46_.hidden = v1472
                v1474 = moeda_
                v1475 = 1
                v1473 = v1474 - v1475
                moeda_ = v1473

            corpo_.update()
            c47_.update()
            boca_.update()
            c47_.update()
            v1476 = figureCollision(corpo_.getRect(),c47_.getRect()) or figureCollision(boca_.getRect(),c47_.getRect())
            if (v1476):
                v1477 = True
                c47_.hidden = v1477
                v1479 = moeda_
                v1480 = 1
                v1478 = v1479 - v1480
                moeda_ = v1478

            corpo_.update()
            c48_.update()
            boca_.update()
            c48_.update()
            v1481 = figureCollision(corpo_.getRect(),c48_.getRect()) or figureCollision(boca_.getRect(),c48_.getRect())
            if (v1481):
                v1482 = True
                c48_.hidden = v1482
                v1484 = moeda_
                v1485 = 1
                v1483 = v1484 - v1485
                moeda_ = v1483

            corpo_.update()
            c49_.update()
            boca_.update()
            c49_.update()
            v1486 = figureCollision(corpo_.getRect(),c49_.getRect()) or figureCollision(boca_.getRect(),c49_.getRect())
            if (v1486):
                v1487 = True
                c49_.hidden = v1487
                v1489 = moeda_
                v1490 = 1
                v1488 = v1489 - v1490
                moeda_ = v1488

            corpo_.update()
            c50_.update()
            boca_.update()
            c50_.update()
            v1491 = figureCollision(corpo_.getRect(),c50_.getRect()) or figureCollision(boca_.getRect(),c50_.getRect())
            if (v1491):
                v1492 = True
                c50_.hidden = v1492
                v1494 = moeda_
                v1495 = 1
                v1493 = v1494 - v1495
                moeda_ = v1493

            corpo_.update()
            c51_.update()
            boca_.update()
            c51_.update()
            v1496 = figureCollision(corpo_.getRect(),c51_.getRect()) or figureCollision(boca_.getRect(),c51_.getRect())
            if (v1496):
                v1497 = True
                c51_.hidden = v1497
                v1499 = moeda_
                v1500 = 1
                v1498 = v1499 - v1500
                moeda_ = v1498

            corpo_.update()
            c52_.update()
            boca_.update()
            c52_.update()
            v1501 = figureCollision(corpo_.getRect(),c52_.getRect()) or figureCollision(boca_.getRect(),c52_.getRect())
            if (v1501):
                v1502 = True
                c52_.hidden = v1502
                v1504 = moeda_
                v1505 = 1
                v1503 = v1504 - v1505
                moeda_ = v1503

            corpo_.update()
            c53_.update()
            boca_.update()
            c53_.update()
            v1506 = figureCollision(corpo_.getRect(),c53_.getRect()) or figureCollision(boca_.getRect(),c53_.getRect())
            if (v1506):
                v1507 = True
                c53_.hidden = v1507
                v1509 = moeda_
                v1510 = 1
                v1508 = v1509 - v1510
                moeda_ = v1508

            corpo_.update()
            c54_.update()
            boca_.update()
            c54_.update()
            v1511 = figureCollision(corpo_.getRect(),c54_.getRect()) or figureCollision(boca_.getRect(),c54_.getRect())
            if (v1511):
                v1512 = True
                c54_.hidden = v1512
                v1514 = moeda_
                v1515 = 1
                v1513 = v1514 - v1515
                moeda_ = v1513

            corpo_.update()
            c55_.update()
            boca_.update()
            c55_.update()
            v1516 = figureCollision(corpo_.getRect(),c55_.getRect()) or figureCollision(boca_.getRect(),c55_.getRect())
            if (v1516):
                v1517 = True
                c55_.hidden = v1517
                v1519 = moeda_
                v1520 = 1
                v1518 = v1519 - v1520
                moeda_ = v1518

            corpo_.update()
            c56_.update()
            boca_.update()
            c56_.update()
            v1521 = figureCollision(corpo_.getRect(),c56_.getRect()) or figureCollision(boca_.getRect(),c56_.getRect())
            if (v1521):
                v1522 = True
                c56_.hidden = v1522
                v1524 = moeda_
                v1525 = 1
                v1523 = v1524 - v1525
                moeda_ = v1523

            corpo_.update()
            c57_.update()
            boca_.update()
            c57_.update()
            v1526 = figureCollision(corpo_.getRect(),c57_.getRect()) or figureCollision(boca_.getRect(),c57_.getRect())
            if (v1526):
                v1527 = True
                c57_.hidden = v1527
                v1529 = moeda_
                v1530 = 1
                v1528 = v1529 - v1530
                moeda_ = v1528

            corpo_.update()
            c58_.update()
            boca_.update()
            c58_.update()
            v1531 = figureCollision(corpo_.getRect(),c58_.getRect()) or figureCollision(boca_.getRect(),c58_.getRect())
            if (v1531):
                v1532 = True
                c58_.hidden = v1532
                v1534 = moeda_
                v1535 = 1
                v1533 = v1534 - v1535
                moeda_ = v1533

            corpo_.update()
            c59_.update()
            boca_.update()
            c59_.update()
            v1536 = figureCollision(corpo_.getRect(),c59_.getRect()) or figureCollision(boca_.getRect(),c59_.getRect())
            if (v1536):
                v1537 = True
                c59_.hidden = v1537
                v1539 = moeda_
                v1540 = 1
                v1538 = v1539 - v1540
                moeda_ = v1538

            corpo_.update()
            c60_.update()
            boca_.update()
            c60_.update()
            v1541 = figureCollision(corpo_.getRect(),c60_.getRect()) or figureCollision(boca_.getRect(),c60_.getRect())
            if (v1541):
                v1542 = True
                c60_.hidden = v1542
                v1544 = moeda_
                v1545 = 1
                v1543 = v1544 - v1545
                moeda_ = v1543

            corpo_.update()
            c61_.update()
            boca_.update()
            c61_.update()
            v1546 = figureCollision(corpo_.getRect(),c61_.getRect()) or figureCollision(boca_.getRect(),c61_.getRect())
            if (v1546):
                v1547 = True
                c61_.hidden = v1547
                v1549 = moeda_
                v1550 = 1
                v1548 = v1549 - v1550
                moeda_ = v1548

            corpo_.update()
            c62_.update()
            boca_.update()
            c62_.update()
            v1551 = figureCollision(corpo_.getRect(),c62_.getRect()) or figureCollision(boca_.getRect(),c62_.getRect())
            if (v1551):
                v1552 = True
                c62_.hidden = v1552
                v1554 = moeda_
                v1555 = 1
                v1553 = v1554 - v1555
                moeda_ = v1553

            corpo_.update()
            c63_.update()
            boca_.update()
            c63_.update()
            v1556 = figureCollision(corpo_.getRect(),c63_.getRect()) or figureCollision(boca_.getRect(),c63_.getRect())
            if (v1556):
                v1557 = True
                c63_.hidden = v1557
                v1559 = moeda_
                v1560 = 1
                v1558 = v1559 - v1560
                moeda_ = v1558

            corpo_.update()
            c64_.update()
            boca_.update()
            c64_.update()
            v1561 = figureCollision(corpo_.getRect(),c64_.getRect()) or figureCollision(boca_.getRect(),c64_.getRect())
            if (v1561):
                v1562 = True
                c64_.hidden = v1562
                v1564 = moeda_
                v1565 = 1
                v1563 = v1564 - v1565
                moeda_ = v1563

            corpo_.update()
            c65_.update()
            boca_.update()
            c65_.update()
            v1566 = figureCollision(corpo_.getRect(),c65_.getRect()) or figureCollision(boca_.getRect(),c65_.getRect())
            if (v1566):
                v1567 = True
                c65_.hidden = v1567
                v1569 = moeda_
                v1570 = 1
                v1568 = v1569 - v1570
                moeda_ = v1568

            corpo_.update()
            c66_.update()
            boca_.update()
            c66_.update()
            v1571 = figureCollision(corpo_.getRect(),c66_.getRect()) or figureCollision(boca_.getRect(),c66_.getRect())
            if (v1571):
                v1572 = True
                c66_.hidden = v1572
                v1574 = moeda_
                v1575 = 1
                v1573 = v1574 - v1575
                moeda_ = v1573

            corpo_.update()
            c67_.update()
            boca_.update()
            c67_.update()
            v1576 = figureCollision(corpo_.getRect(),c67_.getRect()) or figureCollision(boca_.getRect(),c67_.getRect())
            if (v1576):
                v1577 = True
                c67_.hidden = v1577
                v1579 = moeda_
                v1580 = 1
                v1578 = v1579 - v1580
                moeda_ = v1578

            corpo_.update()
            c68_.update()
            boca_.update()
            c68_.update()
            v1581 = figureCollision(corpo_.getRect(),c68_.getRect()) or figureCollision(boca_.getRect(),c68_.getRect())
            if (v1581):
                v1582 = True
                c68_.hidden = v1582
                v1584 = moeda_
                v1585 = 1
                v1583 = v1584 - v1585
                moeda_ = v1583

            corpo_.update()
            c69_.update()
            boca_.update()
            c69_.update()
            v1586 = figureCollision(corpo_.getRect(),c69_.getRect()) or figureCollision(boca_.getRect(),c69_.getRect())
            if (v1586):
                v1587 = True
                c69_.hidden = v1587
                v1589 = moeda_
                v1590 = 1
                v1588 = v1589 - v1590
                moeda_ = v1588

            corpo_.update()
            c70_.update()
            boca_.update()
            c70_.update()
            v1591 = figureCollision(corpo_.getRect(),c70_.getRect()) or figureCollision(boca_.getRect(),c70_.getRect())
            if (v1591):
                v1592 = True
                c70_.hidden = v1592
                v1594 = moeda_
                v1595 = 1
                v1593 = v1594 - v1595
                moeda_ = v1593

            corpo_.update()
            c71_.update()
            boca_.update()
            c71_.update()
            v1596 = figureCollision(corpo_.getRect(),c71_.getRect()) or figureCollision(boca_.getRect(),c71_.getRect())
            if (v1596):
                v1597 = True
                c71_.hidden = v1597
                v1599 = moeda_
                v1600 = 1
                v1598 = v1599 - v1600
                moeda_ = v1598

            corpo_.update()
            c72_.update()
            boca_.update()
            c72_.update()
            v1601 = figureCollision(corpo_.getRect(),c72_.getRect()) or figureCollision(boca_.getRect(),c72_.getRect())
            if (v1601):
                v1602 = True
                c72_.hidden = v1602
                v1604 = moeda_
                v1605 = 1
                v1603 = v1604 - v1605
                moeda_ = v1603

            corpo_.update()
            c73_.update()
            boca_.update()
            c73_.update()
            v1606 = figureCollision(corpo_.getRect(),c73_.getRect()) or figureCollision(boca_.getRect(),c73_.getRect())
            if (v1606):
                v1607 = True
                c73_.hidden = v1607
                v1609 = moeda_
                v1610 = 1
                v1608 = v1609 - v1610
                moeda_ = v1608

            corpo_.update()
            c74_.update()
            boca_.update()
            c74_.update()
            v1611 = figureCollision(corpo_.getRect(),c74_.getRect()) or figureCollision(boca_.getRect(),c74_.getRect())
            if (v1611):
                v1612 = True
                c74_.hidden = v1612
                v1614 = moeda_
                v1615 = 1
                v1613 = v1614 - v1615
                moeda_ = v1613

            corpo_.update()
            c75_.update()
            boca_.update()
            c75_.update()
            v1616 = figureCollision(corpo_.getRect(),c75_.getRect()) or figureCollision(boca_.getRect(),c75_.getRect())
            if (v1616):
                v1617 = True
                c75_.hidden = v1617
                v1619 = moeda_
                v1620 = 1
                v1618 = v1619 - v1620
                moeda_ = v1618

            corpo_.update()
            c76_.update()
            boca_.update()
            c76_.update()
            v1621 = figureCollision(corpo_.getRect(),c76_.getRect()) or figureCollision(boca_.getRect(),c76_.getRect())
            if (v1621):
                v1622 = True
                c76_.hidden = v1622
                v1624 = moeda_
                v1625 = 1
                v1623 = v1624 - v1625
                moeda_ = v1623

            corpo_.update()
            c77_.update()
            boca_.update()
            c77_.update()
            v1626 = figureCollision(corpo_.getRect(),c77_.getRect()) or figureCollision(boca_.getRect(),c77_.getRect())
            if (v1626):
                v1627 = True
                c77_.hidden = v1627
                v1629 = moeda_
                v1630 = 1
                v1628 = v1629 - v1630
                moeda_ = v1628

            corpo_.update()
            c78_.update()
            boca_.update()
            c78_.update()
            v1631 = figureCollision(corpo_.getRect(),c78_.getRect()) or figureCollision(boca_.getRect(),c78_.getRect())
            if (v1631):
                v1632 = True
                c78_.hidden = v1632
                v1634 = moeda_
                v1635 = 1
                v1633 = v1634 - v1635
                moeda_ = v1633

            corpo_.update()
            c79_.update()
            boca_.update()
            c79_.update()
            v1636 = figureCollision(corpo_.getRect(),c79_.getRect()) or figureCollision(boca_.getRect(),c79_.getRect())
            if (v1636):
                v1637 = True
                c79_.hidden = v1637
                v1639 = moeda_
                v1640 = 1
                v1638 = v1639 - v1640
                moeda_ = v1638

            corpo_.update()
            c80_.update()
            boca_.update()
            c80_.update()
            v1641 = figureCollision(corpo_.getRect(),c80_.getRect()) or figureCollision(boca_.getRect(),c80_.getRect())
            if (v1641):
                v1642 = True
                c80_.hidden = v1642
                v1644 = moeda_
                v1645 = 1
                v1643 = v1644 - v1645
                moeda_ = v1643

            corpo_.update()
            c81_.update()
            boca_.update()
            c81_.update()
            v1646 = figureCollision(corpo_.getRect(),c81_.getRect()) or figureCollision(boca_.getRect(),c81_.getRect())
            if (v1646):
                v1647 = True
                c81_.hidden = v1647
                v1649 = moeda_
                v1650 = 1
                v1648 = v1649 - v1650
                moeda_ = v1648

            corpo_.update()
            c82_.update()
            boca_.update()
            c82_.update()
            v1651 = figureCollision(corpo_.getRect(),c82_.getRect()) or figureCollision(boca_.getRect(),c82_.getRect())
            if (v1651):
                v1652 = True
                c82_.hidden = v1652
                v1654 = moeda_
                v1655 = 1
                v1653 = v1654 - v1655
                moeda_ = v1653

            corpo_.update()
            c83_.update()
            boca_.update()
            c83_.update()
            v1656 = figureCollision(corpo_.getRect(),c83_.getRect()) or figureCollision(boca_.getRect(),c83_.getRect())
            if (v1656):
                v1657 = True
                c83_.hidden = v1657
                v1659 = moeda_
                v1660 = 1
                v1658 = v1659 - v1660
                moeda_ = v1658

            corpo_.update()
            c84_.update()
            boca_.update()
            c84_.update()
            v1661 = figureCollision(corpo_.getRect(),c84_.getRect()) or figureCollision(boca_.getRect(),c84_.getRect())
            if (v1661):
                v1662 = True
                c84_.hidden = v1662
                v1664 = moeda_
                v1665 = 1
                v1663 = v1664 - v1665
                moeda_ = v1663

            corpo_.update()
            c85_.update()
            boca_.update()
            c85_.update()
            v1666 = figureCollision(corpo_.getRect(),c85_.getRect()) or figureCollision(boca_.getRect(),c85_.getRect())
            if (v1666):
                v1667 = True
                c85_.hidden = v1667
                v1669 = moeda_
                v1670 = 1
                v1668 = v1669 - v1670
                moeda_ = v1668

            corpo_.update()
            c86_.update()
            boca_.update()
            c86_.update()
            v1671 = figureCollision(corpo_.getRect(),c86_.getRect()) or figureCollision(boca_.getRect(),c86_.getRect())
            if (v1671):
                v1672 = True
                c86_.hidden = v1672
                v1674 = moeda_
                v1675 = 1
                v1673 = v1674 - v1675
                moeda_ = v1673

            corpo_.update()
            c87_.update()
            boca_.update()
            c87_.update()
            v1676 = figureCollision(corpo_.getRect(),c87_.getRect()) or figureCollision(boca_.getRect(),c87_.getRect())
            if (v1676):
                v1677 = True
                c87_.hidden = v1677
                v1679 = moeda_
                v1680 = 1
                v1678 = v1679 - v1680
                moeda_ = v1678

            corpo_.update()
            c88_.update()
            boca_.update()
            c88_.update()
            v1681 = figureCollision(corpo_.getRect(),c88_.getRect()) or figureCollision(boca_.getRect(),c88_.getRect())
            if (v1681):
                v1682 = True
                c88_.hidden = v1682
                v1684 = moeda_
                v1685 = 1
                v1683 = v1684 - v1685
                moeda_ = v1683

            corpo_.update()
            c89_.update()
            boca_.update()
            c89_.update()
            v1686 = figureCollision(corpo_.getRect(),c89_.getRect()) or figureCollision(boca_.getRect(),c89_.getRect())
            if (v1686):
                v1687 = True
                c89_.hidden = v1687
                v1689 = moeda_
                v1690 = 1
                v1688 = v1689 - v1690
                moeda_ = v1688

            v1692 = moeda_
            v1693 = 0
            v1691 = v1692 == v1693
            if (v1691):
                v1694 = False
                run_ = v1694
                v1695 = True
                win_ = v1695
                v1696 = corpo1_.x
                v1_ = v1696
                v1697 = corpo1_.y
                v2_ = v1697
                v1700 = v1_
                v1701 = -1
                v1699 = v1700 * v1701
                v1702 = 50
                v1698 = v1699 + v1702
                v1705 = v2_
                v1706 = -1
                v1704 = v1705 * v1706
                v1707 = 50
                v1703 = v1704 + v1707
                corpo1_.translate(v1698, v1703)
                v1710 = v1_
                v1711 = -1
                v1709 = v1710 * v1711
                v1712 = 50
                v1708 = v1709 + v1712
                v1715 = v2_
                v1716 = -1
                v1714 = v1715 * v1716
                v1717 = 50
                v1713 = v1714 + v1717
                corpo2_.translate(v1708, v1713)
                v1720 = v1_
                v1721 = -1
                v1719 = v1720 * v1721
                v1722 = 50
                v1718 = v1719 + v1722
                v1725 = v2_
                v1726 = -1
                v1724 = v1725 * v1726
                v1727 = 50
                v1723 = v1724 + v1727
                corpo3_.translate(v1718, v1723)
                v1730 = v1_
                v1731 = -1
                v1729 = v1730 * v1731
                v1732 = 50
                v1728 = v1729 + v1732
                v1735 = v2_
                v1736 = -1
                v1734 = v1735 * v1736
                v1737 = 50
                v1733 = v1734 + v1737
                corpo4_.translate(v1728, v1733)
                v1740 = v1_
                v1741 = -1
                v1739 = v1740 * v1741
                v1742 = 50
                v1738 = v1739 + v1742
                v1745 = v2_
                v1746 = -1
                v1744 = v1745 * v1746
                v1747 = 50
                v1743 = v1744 + v1747
                corpo5_.translate(v1738, v1743)
                v1750 = v1_
                v1751 = -1
                v1749 = v1750 * v1751
                v1752 = 50
                v1748 = v1749 + v1752
                v1755 = v2_
                v1756 = -1
                v1754 = v1755 * v1756
                v1757 = 50
                v1753 = v1754 + v1757
                olho1_.translate(v1748, v1753)
                v1760 = v1_
                v1761 = -1
                v1759 = v1760 * v1761
                v1762 = 50
                v1758 = v1759 + v1762
                v1765 = v2_
                v1766 = -1
                v1764 = v1765 * v1766
                v1767 = 50
                v1763 = v1764 + v1767
                olho2_.translate(v1758, v1763)
                v1770 = v1_
                v1771 = -1
                v1769 = v1770 * v1771
                v1772 = 50
                v1768 = v1769 + v1772
                v1775 = v2_
                v1776 = -1
                v1774 = v1775 * v1776
                v1777 = 50
                v1773 = v1774 + v1777
                olho11_.translate(v1768, v1773)
                v1780 = v1_
                v1781 = -1
                v1779 = v1780 * v1781
                v1782 = 50
                v1778 = v1779 + v1782
                v1785 = v2_
                v1786 = -1
                v1784 = v1785 * v1786
                v1787 = 50
                v1783 = v1784 + v1787
                olho22_.translate(v1778, v1783)
                v1790 = v1_
                v1791 = -1
                v1789 = v1790 * v1791
                v1792 = 50
                v1788 = v1789 + v1792
                v1795 = v2_
                v1796 = -1
                v1794 = v1795 * v1796
                v1797 = 50
                v1793 = v1794 + v1797
                Borda_.translate(v1788, v1793)
                v1798 = corpo_1_.x
                v1_ = v1798
                v1799 = corpo_1_.y
                v2_ = v1799
                v1802 = v1_
                v1803 = -1
                v1801 = v1802 * v1803
                v1804 = 50
                v1800 = v1801 + v1804
                v1807 = v2_
                v1808 = -1
                v1806 = v1807 * v1808
                v1809 = 850
                v1805 = v1806 + v1809
                corpo_1_.translate(v1800, v1805)
                v1812 = v1_
                v1813 = -1
                v1811 = v1812 * v1813
                v1814 = 50
                v1810 = v1811 + v1814
                v1817 = v2_
                v1818 = -1
                v1816 = v1817 * v1818
                v1819 = 850
                v1815 = v1816 + v1819
                corpo_2_.translate(v1810, v1815)
                v1822 = v1_
                v1823 = -1
                v1821 = v1822 * v1823
                v1824 = 50
                v1820 = v1821 + v1824
                v1827 = v2_
                v1828 = -1
                v1826 = v1827 * v1828
                v1829 = 850
                v1825 = v1826 + v1829
                corpo_3_.translate(v1820, v1825)
                v1832 = v1_
                v1833 = -1
                v1831 = v1832 * v1833
                v1834 = 50
                v1830 = v1831 + v1834
                v1837 = v2_
                v1838 = -1
                v1836 = v1837 * v1838
                v1839 = 850
                v1835 = v1836 + v1839
                corpo_4_.translate(v1830, v1835)
                v1842 = v1_
                v1843 = -1
                v1841 = v1842 * v1843
                v1844 = 50
                v1840 = v1841 + v1844
                v1847 = v2_
                v1848 = -1
                v1846 = v1847 * v1848
                v1849 = 850
                v1845 = v1846 + v1849
                corpo_5_.translate(v1840, v1845)
                v1852 = v1_
                v1853 = -1
                v1851 = v1852 * v1853
                v1854 = 50
                v1850 = v1851 + v1854
                v1857 = v2_
                v1858 = -1
                v1856 = v1857 * v1858
                v1859 = 850
                v1855 = v1856 + v1859
                olho_1_.translate(v1850, v1855)
                v1862 = v1_
                v1863 = -1
                v1861 = v1862 * v1863
                v1864 = 50
                v1860 = v1861 + v1864
                v1867 = v2_
                v1868 = -1
                v1866 = v1867 * v1868
                v1869 = 850
                v1865 = v1866 + v1869
                olho_2_.translate(v1860, v1865)
                v1872 = v1_
                v1873 = -1
                v1871 = v1872 * v1873
                v1874 = 50
                v1870 = v1871 + v1874
                v1877 = v2_
                v1878 = -1
                v1876 = v1877 * v1878
                v1879 = 850
                v1875 = v1876 + v1879
                olho_11_.translate(v1870, v1875)
                v1882 = v1_
                v1883 = -1
                v1881 = v1882 * v1883
                v1884 = 50
                v1880 = v1881 + v1884
                v1887 = v2_
                v1888 = -1
                v1886 = v1887 * v1888
                v1889 = 850
                v1885 = v1886 + v1889
                olho_22_.translate(v1880, v1885)
                v1892 = v1_
                v1893 = -1
                v1891 = v1892 * v1893
                v1894 = 50
                v1890 = v1891 + v1894
                v1897 = v2_
                v1898 = -1
                v1896 = v1897 * v1898
                v1899 = 850
                v1895 = v1896 + v1899
                Borda__.translate(v1890, v1895)
                v1900 = corpo__1_.x
                v1_ = v1900
                v1901 = corpo__1_.y
                v2_ = v1901
                v1904 = v1_
                v1905 = -1
                v1903 = v1904 * v1905
                v1906 = 750
                v1902 = v1903 + v1906
                v1909 = v2_
                v1910 = -1
                v1908 = v1909 * v1910
                v1911 = 50
                v1907 = v1908 + v1911
                corpo__1_.translate(v1902, v1907)
                v1914 = v1_
                v1915 = -1
                v1913 = v1914 * v1915
                v1916 = 750
                v1912 = v1913 + v1916
                v1919 = v2_
                v1920 = -1
                v1918 = v1919 * v1920
                v1921 = 50
                v1917 = v1918 + v1921
                corpo__2_.translate(v1912, v1917)
                v1924 = v1_
                v1925 = -1
                v1923 = v1924 * v1925
                v1926 = 750
                v1922 = v1923 + v1926
                v1929 = v2_
                v1930 = -1
                v1928 = v1929 * v1930
                v1931 = 50
                v1927 = v1928 + v1931
                corpo__3_.translate(v1922, v1927)
                v1934 = v1_
                v1935 = -1
                v1933 = v1934 * v1935
                v1936 = 750
                v1932 = v1933 + v1936
                v1939 = v2_
                v1940 = -1
                v1938 = v1939 * v1940
                v1941 = 50
                v1937 = v1938 + v1941
                corpo__4_.translate(v1932, v1937)
                v1944 = v1_
                v1945 = -1
                v1943 = v1944 * v1945
                v1946 = 750
                v1942 = v1943 + v1946
                v1949 = v2_
                v1950 = -1
                v1948 = v1949 * v1950
                v1951 = 50
                v1947 = v1948 + v1951
                corpo__5_.translate(v1942, v1947)
                v1954 = v1_
                v1955 = -1
                v1953 = v1954 * v1955
                v1956 = 750
                v1952 = v1953 + v1956
                v1959 = v2_
                v1960 = -1
                v1958 = v1959 * v1960
                v1961 = 50
                v1957 = v1958 + v1961
                olho__1_.translate(v1952, v1957)
                v1964 = v1_
                v1965 = -1
                v1963 = v1964 * v1965
                v1966 = 750
                v1962 = v1963 + v1966
                v1969 = v2_
                v1970 = -1
                v1968 = v1969 * v1970
                v1971 = 50
                v1967 = v1968 + v1971
                olho__2_.translate(v1962, v1967)
                v1974 = v1_
                v1975 = -1
                v1973 = v1974 * v1975
                v1976 = 750
                v1972 = v1973 + v1976
                v1979 = v2_
                v1980 = -1
                v1978 = v1979 * v1980
                v1981 = 50
                v1977 = v1978 + v1981
                olho__11_.translate(v1972, v1977)
                v1984 = v1_
                v1985 = -1
                v1983 = v1984 * v1985
                v1986 = 750
                v1982 = v1983 + v1986
                v1989 = v2_
                v1990 = -1
                v1988 = v1989 * v1990
                v1991 = 50
                v1987 = v1988 + v1991
                olho__22_.translate(v1982, v1987)
                v1994 = v1_
                v1995 = -1
                v1993 = v1994 * v1995
                v1996 = 750
                v1992 = v1993 + v1996
                v1999 = v2_
                v2000 = -1
                v1998 = v1999 * v2000
                v2001 = 50
                v1997 = v1998 + v2001
                Borda___.translate(v1992, v1997)
                v2002 = corpo___1_.x
                v1_ = v2002
                v2003 = corpo___1_.y
                v2_ = v2003
                v2006 = v1_
                v2007 = -1
                v2005 = v2006 * v2007
                v2008 = 750
                v2004 = v2005 + v2008
                v2011 = v2_
                v2012 = -1
                v2010 = v2011 * v2012
                v2013 = 850
                v2009 = v2010 + v2013
                corpo___1_.translate(v2004, v2009)
                v2016 = v1_
                v2017 = -1
                v2015 = v2016 * v2017
                v2018 = 750
                v2014 = v2015 + v2018
                v2021 = v2_
                v2022 = -1
                v2020 = v2021 * v2022
                v2023 = 850
                v2019 = v2020 + v2023
                corpo___2_.translate(v2014, v2019)
                v2026 = v1_
                v2027 = -1
                v2025 = v2026 * v2027
                v2028 = 750
                v2024 = v2025 + v2028
                v2031 = v2_
                v2032 = -1
                v2030 = v2031 * v2032
                v2033 = 850
                v2029 = v2030 + v2033
                corpo___3_.translate(v2024, v2029)
                v2036 = v1_
                v2037 = -1
                v2035 = v2036 * v2037
                v2038 = 750
                v2034 = v2035 + v2038
                v2041 = v2_
                v2042 = -1
                v2040 = v2041 * v2042
                v2043 = 850
                v2039 = v2040 + v2043
                corpo___4_.translate(v2034, v2039)
                v2046 = v1_
                v2047 = -1
                v2045 = v2046 * v2047
                v2048 = 750
                v2044 = v2045 + v2048
                v2051 = v2_
                v2052 = -1
                v2050 = v2051 * v2052
                v2053 = 850
                v2049 = v2050 + v2053
                corpo___5_.translate(v2044, v2049)
                v2056 = v1_
                v2057 = -1
                v2055 = v2056 * v2057
                v2058 = 750
                v2054 = v2055 + v2058
                v2061 = v2_
                v2062 = -1
                v2060 = v2061 * v2062
                v2063 = 850
                v2059 = v2060 + v2063
                olho___1_.translate(v2054, v2059)
                v2066 = v1_
                v2067 = -1
                v2065 = v2066 * v2067
                v2068 = 750
                v2064 = v2065 + v2068
                v2071 = v2_
                v2072 = -1
                v2070 = v2071 * v2072
                v2073 = 850
                v2069 = v2070 + v2073
                olho___2_.translate(v2064, v2069)
                v2076 = v1_
                v2077 = -1
                v2075 = v2076 * v2077
                v2078 = 750
                v2074 = v2075 + v2078
                v2081 = v2_
                v2082 = -1
                v2080 = v2081 * v2082
                v2083 = 850
                v2079 = v2080 + v2083
                olho___11_.translate(v2074, v2079)
                v2086 = v1_
                v2087 = -1
                v2085 = v2086 * v2087
                v2088 = 750
                v2084 = v2085 + v2088
                v2091 = v2_
                v2092 = -1
                v2090 = v2091 * v2092
                v2093 = 850
                v2089 = v2090 + v2093
                olho___22_.translate(v2084, v2089)
                v2096 = v1_
                v2097 = -1
                v2095 = v2096 * v2097
                v2098 = 750
                v2094 = v2095 + v2098
                v2101 = v2_
                v2102 = -1
                v2100 = v2101 * v2102
                v2103 = 850
                v2099 = v2100 + v2103
                Borda____.translate(v2094, v2099)
                v2104 = corpo_.x
                v1_ = v2104
                v2105 = corpo_.y
                v2_ = v2105
                v2108 = v1_
                v2109 = -1
                v2107 = v2108 * v2109
                v2110 = 400
                v2106 = v2107 + v2110
                v2113 = v2_
                v2114 = -1
                v2112 = v2113 * v2114
                v2115 = 550
                v2111 = v2112 + v2115
                corpo_.translate(v2106, v2111)
                v2118 = v1_
                v2119 = -1
                v2117 = v2118 * v2119
                v2120 = 400
                v2116 = v2117 + v2120
                v2123 = v2_
                v2124 = -1
                v2122 = v2123 * v2124
                v2125 = 550
                v2121 = v2122 + v2125
                boca_.translate(v2116, v2121)

            w1_.update()
            if(w1_.hidden == False):
                pygame.draw.polygon(display, w1_.color, w1_.points, w1_.thickness)
            w2_.update()
            if(w2_.hidden == False):
                pygame.draw.polygon(display, w2_.color, w2_.points, w2_.thickness)
            w3_.update()
            if(w3_.hidden == False):
                pygame.draw.polygon(display, w3_.color, w3_.points, w3_.thickness)
            w4_.update()
            if(w4_.hidden == False):
                pygame.draw.polygon(display, w4_.color, w4_.points, w4_.thickness)
            meio1_.update()
            if(meio1_.hidden == False):
                pygame.draw.polygon(display, meio1_.color, meio1_.points, meio1_.thickness)
            meio2_.update()
            if(meio2_.hidden == False):
                pygame.draw.polygon(display, meio2_.color, meio2_.points, meio2_.thickness)
            topR1_.update()
            if(topR1_.hidden == False):
                pygame.draw.polygon(display, topR1_.color, topR1_.points, topR1_.thickness)
            topR2_.update()
            if(topR2_.hidden == False):
                pygame.draw.polygon(display, topR2_.color, topR2_.points, topR2_.thickness)
            topR3_.update()
            if(topR3_.hidden == False):
                pygame.draw.polygon(display, topR3_.color, topR3_.points, topR3_.thickness)
            topL1_.update()
            if(topL1_.hidden == False):
                pygame.draw.polygon(display, topL1_.color, topL1_.points, topL1_.thickness)
            topL2_.update()
            if(topL2_.hidden == False):
                pygame.draw.polygon(display, topL2_.color, topL2_.points, topL2_.thickness)
            topL3_.update()
            if(topL3_.hidden == False):
                pygame.draw.polygon(display, topL3_.color, topL3_.points, topL3_.thickness)
            meioR_.update()
            if(meioR_.hidden == False):
                pygame.draw.polygon(display, meioR_.color, meioR_.points, meioR_.thickness)
            meioL_.update()
            if(meioL_.hidden == False):
                pygame.draw.polygon(display, meioL_.color, meioL_.points, meioL_.thickness)
            meioMVer_.update()
            if(meioMVer_.hidden == False):
                pygame.draw.polygon(display, meioMVer_.color, meioMVer_.points, meioMVer_.thickness)
            meioML_.update()
            if(meioML_.hidden == False):
                pygame.draw.polygon(display, meioML_.color, meioML_.points, meioML_.thickness)
            meioMR_.update()
            if(meioMR_.hidden == False):
                pygame.draw.polygon(display, meioMR_.color, meioMR_.points, meioMR_.thickness)
            meio2Baixo_.update()
            if(meio2Baixo_.hidden == False):
                pygame.draw.polygon(display, meio2Baixo_.color, meio2Baixo_.points, meio2Baixo_.thickness)
            grandL_.update()
            if(grandL_.hidden == False):
                pygame.draw.polygon(display, grandL_.color, grandL_.points, grandL_.thickness)
            grandR_.update()
            if(grandR_.hidden == False):
                pygame.draw.polygon(display, grandR_.color, grandR_.points, grandR_.thickness)
            meio2Baixo2_.update()
            if(meio2Baixo2_.hidden == False):
                pygame.draw.polygon(display, meio2Baixo2_.color, meio2Baixo2_.points, meio2Baixo2_.thickness)
            meio2BaixoV_.update()
            if(meio2BaixoV_.hidden == False):
                pygame.draw.polygon(display, meio2BaixoV_.color, meio2BaixoV_.points, meio2BaixoV_.thickness)
            meio2BaixoL_.update()
            if(meio2BaixoL_.hidden == False):
                pygame.draw.polygon(display, meio2BaixoL_.color, meio2BaixoL_.points, meio2BaixoL_.thickness)
            meio2BaixoR_.update()
            if(meio2BaixoR_.hidden == False):
                pygame.draw.polygon(display, meio2BaixoR_.color, meio2BaixoR_.points, meio2BaixoR_.thickness)
            meioFinal_.update()
            if(meioFinal_.hidden == False):
                pygame.draw.polygon(display, meioFinal_.color, meioFinal_.points, meioFinal_.thickness)
            fimGordoL_.update()
            if(fimGordoL_.hidden == False):
                pygame.draw.polygon(display, fimGordoL_.color, fimGordoL_.points, fimGordoL_.thickness)
            fimGordoR_.update()
            if(fimGordoR_.hidden == False):
                pygame.draw.polygon(display, fimGordoR_.color, fimGordoR_.points, fimGordoR_.thickness)
            fimMeioL_.update()
            if(fimMeioL_.hidden == False):
                pygame.draw.polygon(display, fimMeioL_.color, fimMeioL_.points, fimMeioL_.thickness)
            fimMeioR_.update()
            if(fimMeioR_.hidden == False):
                pygame.draw.polygon(display, fimMeioR_.color, fimMeioR_.points, fimMeioR_.thickness)
            if(c1_.hidden == False):
                pygame.draw.circle(display,c1_.color,(c1_.x,c1_.y),c1_.r,c1_.thickness)
            if(c2_.hidden == False):
                pygame.draw.circle(display,c2_.color,(c2_.x,c2_.y),c2_.r,c2_.thickness)
            if(c3_.hidden == False):
                pygame.draw.circle(display,c3_.color,(c3_.x,c3_.y),c3_.r,c3_.thickness)
            if(c4_.hidden == False):
                pygame.draw.circle(display,c4_.color,(c4_.x,c4_.y),c4_.r,c4_.thickness)
            if(c5_.hidden == False):
                pygame.draw.circle(display,c5_.color,(c5_.x,c5_.y),c5_.r,c5_.thickness)
            if(c6_.hidden == False):
                pygame.draw.circle(display,c6_.color,(c6_.x,c6_.y),c6_.r,c6_.thickness)
            if(c7_.hidden == False):
                pygame.draw.circle(display,c7_.color,(c7_.x,c7_.y),c7_.r,c7_.thickness)
            if(c8_.hidden == False):
                pygame.draw.circle(display,c8_.color,(c8_.x,c8_.y),c8_.r,c8_.thickness)
            if(c9_.hidden == False):
                pygame.draw.circle(display,c9_.color,(c9_.x,c9_.y),c9_.r,c9_.thickness)
            if(c10_.hidden == False):
                pygame.draw.circle(display,c10_.color,(c10_.x,c10_.y),c10_.r,c10_.thickness)
            if(c11_.hidden == False):
                pygame.draw.circle(display,c11_.color,(c11_.x,c11_.y),c11_.r,c11_.thickness)
            if(c12_.hidden == False):
                pygame.draw.circle(display,c12_.color,(c12_.x,c12_.y),c12_.r,c12_.thickness)
            if(c13_.hidden == False):
                pygame.draw.circle(display,c13_.color,(c13_.x,c13_.y),c13_.r,c13_.thickness)
            if(c14_.hidden == False):
                pygame.draw.circle(display,c14_.color,(c14_.x,c14_.y),c14_.r,c14_.thickness)
            if(c15_.hidden == False):
                pygame.draw.circle(display,c15_.color,(c15_.x,c15_.y),c15_.r,c15_.thickness)
            if(c16_.hidden == False):
                pygame.draw.circle(display,c16_.color,(c16_.x,c16_.y),c16_.r,c16_.thickness)
            if(c17_.hidden == False):
                pygame.draw.circle(display,c17_.color,(c17_.x,c17_.y),c17_.r,c17_.thickness)
            if(c18_.hidden == False):
                pygame.draw.circle(display,c18_.color,(c18_.x,c18_.y),c18_.r,c18_.thickness)
            if(c19_.hidden == False):
                pygame.draw.circle(display,c19_.color,(c19_.x,c19_.y),c19_.r,c19_.thickness)
            if(c20_.hidden == False):
                pygame.draw.circle(display,c20_.color,(c20_.x,c20_.y),c20_.r,c20_.thickness)
            if(c21_.hidden == False):
                pygame.draw.circle(display,c21_.color,(c21_.x,c21_.y),c21_.r,c21_.thickness)
            if(c22_.hidden == False):
                pygame.draw.circle(display,c22_.color,(c22_.x,c22_.y),c22_.r,c22_.thickness)
            if(c23_.hidden == False):
                pygame.draw.circle(display,c23_.color,(c23_.x,c23_.y),c23_.r,c23_.thickness)
            if(c24_.hidden == False):
                pygame.draw.circle(display,c24_.color,(c24_.x,c24_.y),c24_.r,c24_.thickness)
            if(c25_.hidden == False):
                pygame.draw.circle(display,c25_.color,(c25_.x,c25_.y),c25_.r,c25_.thickness)
            if(c26_.hidden == False):
                pygame.draw.circle(display,c26_.color,(c26_.x,c26_.y),c26_.r,c26_.thickness)
            if(c27_.hidden == False):
                pygame.draw.circle(display,c27_.color,(c27_.x,c27_.y),c27_.r,c27_.thickness)
            if(c28_.hidden == False):
                pygame.draw.circle(display,c28_.color,(c28_.x,c28_.y),c28_.r,c28_.thickness)
            if(c29_.hidden == False):
                pygame.draw.circle(display,c29_.color,(c29_.x,c29_.y),c29_.r,c29_.thickness)
            if(c30_.hidden == False):
                pygame.draw.circle(display,c30_.color,(c30_.x,c30_.y),c30_.r,c30_.thickness)
            if(c31_.hidden == False):
                pygame.draw.circle(display,c31_.color,(c31_.x,c31_.y),c31_.r,c31_.thickness)
            if(c32_.hidden == False):
                pygame.draw.circle(display,c32_.color,(c32_.x,c32_.y),c32_.r,c32_.thickness)
            if(c33_.hidden == False):
                pygame.draw.circle(display,c33_.color,(c33_.x,c33_.y),c33_.r,c33_.thickness)
            if(c34_.hidden == False):
                pygame.draw.circle(display,c34_.color,(c34_.x,c34_.y),c34_.r,c34_.thickness)
            if(c35_.hidden == False):
                pygame.draw.circle(display,c35_.color,(c35_.x,c35_.y),c35_.r,c35_.thickness)
            if(c36_.hidden == False):
                pygame.draw.circle(display,c36_.color,(c36_.x,c36_.y),c36_.r,c36_.thickness)
            if(c37_.hidden == False):
                pygame.draw.circle(display,c37_.color,(c37_.x,c37_.y),c37_.r,c37_.thickness)
            if(c38_.hidden == False):
                pygame.draw.circle(display,c38_.color,(c38_.x,c38_.y),c38_.r,c38_.thickness)
            if(c39_.hidden == False):
                pygame.draw.circle(display,c39_.color,(c39_.x,c39_.y),c39_.r,c39_.thickness)
            if(c40_.hidden == False):
                pygame.draw.circle(display,c40_.color,(c40_.x,c40_.y),c40_.r,c40_.thickness)
            if(c41_.hidden == False):
                pygame.draw.circle(display,c41_.color,(c41_.x,c41_.y),c41_.r,c41_.thickness)
            if(c42_.hidden == False):
                pygame.draw.circle(display,c42_.color,(c42_.x,c42_.y),c42_.r,c42_.thickness)
            if(c43_.hidden == False):
                pygame.draw.circle(display,c43_.color,(c43_.x,c43_.y),c43_.r,c43_.thickness)
            if(c44_.hidden == False):
                pygame.draw.circle(display,c44_.color,(c44_.x,c44_.y),c44_.r,c44_.thickness)
            if(c45_.hidden == False):
                pygame.draw.circle(display,c45_.color,(c45_.x,c45_.y),c45_.r,c45_.thickness)
            if(c46_.hidden == False):
                pygame.draw.circle(display,c46_.color,(c46_.x,c46_.y),c46_.r,c46_.thickness)
            if(c47_.hidden == False):
                pygame.draw.circle(display,c47_.color,(c47_.x,c47_.y),c47_.r,c47_.thickness)
            if(c48_.hidden == False):
                pygame.draw.circle(display,c48_.color,(c48_.x,c48_.y),c48_.r,c48_.thickness)
            if(c49_.hidden == False):
                pygame.draw.circle(display,c49_.color,(c49_.x,c49_.y),c49_.r,c49_.thickness)
            if(c50_.hidden == False):
                pygame.draw.circle(display,c50_.color,(c50_.x,c50_.y),c50_.r,c50_.thickness)
            if(c51_.hidden == False):
                pygame.draw.circle(display,c51_.color,(c51_.x,c51_.y),c51_.r,c51_.thickness)
            if(c52_.hidden == False):
                pygame.draw.circle(display,c52_.color,(c52_.x,c52_.y),c52_.r,c52_.thickness)
            if(c53_.hidden == False):
                pygame.draw.circle(display,c53_.color,(c53_.x,c53_.y),c53_.r,c53_.thickness)
            if(c54_.hidden == False):
                pygame.draw.circle(display,c54_.color,(c54_.x,c54_.y),c54_.r,c54_.thickness)
            if(c55_.hidden == False):
                pygame.draw.circle(display,c55_.color,(c55_.x,c55_.y),c55_.r,c55_.thickness)
            if(c56_.hidden == False):
                pygame.draw.circle(display,c56_.color,(c56_.x,c56_.y),c56_.r,c56_.thickness)
            if(c57_.hidden == False):
                pygame.draw.circle(display,c57_.color,(c57_.x,c57_.y),c57_.r,c57_.thickness)
            if(c58_.hidden == False):
                pygame.draw.circle(display,c58_.color,(c58_.x,c58_.y),c58_.r,c58_.thickness)
            if(c59_.hidden == False):
                pygame.draw.circle(display,c59_.color,(c59_.x,c59_.y),c59_.r,c59_.thickness)
            if(c60_.hidden == False):
                pygame.draw.circle(display,c60_.color,(c60_.x,c60_.y),c60_.r,c60_.thickness)
            if(c61_.hidden == False):
                pygame.draw.circle(display,c61_.color,(c61_.x,c61_.y),c61_.r,c61_.thickness)
            if(c62_.hidden == False):
                pygame.draw.circle(display,c62_.color,(c62_.x,c62_.y),c62_.r,c62_.thickness)
            if(c63_.hidden == False):
                pygame.draw.circle(display,c63_.color,(c63_.x,c63_.y),c63_.r,c63_.thickness)
            if(c64_.hidden == False):
                pygame.draw.circle(display,c64_.color,(c64_.x,c64_.y),c64_.r,c64_.thickness)
            if(c65_.hidden == False):
                pygame.draw.circle(display,c65_.color,(c65_.x,c65_.y),c65_.r,c65_.thickness)
            if(c66_.hidden == False):
                pygame.draw.circle(display,c66_.color,(c66_.x,c66_.y),c66_.r,c66_.thickness)
            if(c67_.hidden == False):
                pygame.draw.circle(display,c67_.color,(c67_.x,c67_.y),c67_.r,c67_.thickness)
            if(c68_.hidden == False):
                pygame.draw.circle(display,c68_.color,(c68_.x,c68_.y),c68_.r,c68_.thickness)
            if(c69_.hidden == False):
                pygame.draw.circle(display,c69_.color,(c69_.x,c69_.y),c69_.r,c69_.thickness)
            if(c70_.hidden == False):
                pygame.draw.circle(display,c70_.color,(c70_.x,c70_.y),c70_.r,c70_.thickness)
            if(c71_.hidden == False):
                pygame.draw.circle(display,c71_.color,(c71_.x,c71_.y),c71_.r,c71_.thickness)
            if(c72_.hidden == False):
                pygame.draw.circle(display,c72_.color,(c72_.x,c72_.y),c72_.r,c72_.thickness)
            if(c73_.hidden == False):
                pygame.draw.circle(display,c73_.color,(c73_.x,c73_.y),c73_.r,c73_.thickness)
            if(c74_.hidden == False):
                pygame.draw.circle(display,c74_.color,(c74_.x,c74_.y),c74_.r,c74_.thickness)
            if(c75_.hidden == False):
                pygame.draw.circle(display,c75_.color,(c75_.x,c75_.y),c75_.r,c75_.thickness)
            if(c76_.hidden == False):
                pygame.draw.circle(display,c76_.color,(c76_.x,c76_.y),c76_.r,c76_.thickness)
            if(c77_.hidden == False):
                pygame.draw.circle(display,c77_.color,(c77_.x,c77_.y),c77_.r,c77_.thickness)
            if(c78_.hidden == False):
                pygame.draw.circle(display,c78_.color,(c78_.x,c78_.y),c78_.r,c78_.thickness)
            if(c79_.hidden == False):
                pygame.draw.circle(display,c79_.color,(c79_.x,c79_.y),c79_.r,c79_.thickness)
            if(c80_.hidden == False):
                pygame.draw.circle(display,c80_.color,(c80_.x,c80_.y),c80_.r,c80_.thickness)
            if(c81_.hidden == False):
                pygame.draw.circle(display,c81_.color,(c81_.x,c81_.y),c81_.r,c81_.thickness)
            if(c82_.hidden == False):
                pygame.draw.circle(display,c82_.color,(c82_.x,c82_.y),c82_.r,c82_.thickness)
            if(c83_.hidden == False):
                pygame.draw.circle(display,c83_.color,(c83_.x,c83_.y),c83_.r,c83_.thickness)
            if(c84_.hidden == False):
                pygame.draw.circle(display,c84_.color,(c84_.x,c84_.y),c84_.r,c84_.thickness)
            if(c85_.hidden == False):
                pygame.draw.circle(display,c85_.color,(c85_.x,c85_.y),c85_.r,c85_.thickness)
            if(c86_.hidden == False):
                pygame.draw.circle(display,c86_.color,(c86_.x,c86_.y),c86_.r,c86_.thickness)
            if(c87_.hidden == False):
                pygame.draw.circle(display,c87_.color,(c87_.x,c87_.y),c87_.r,c87_.thickness)
            if(c88_.hidden == False):
                pygame.draw.circle(display,c88_.color,(c88_.x,c88_.y),c88_.r,c88_.thickness)
            if(c89_.hidden == False):
                pygame.draw.circle(display,c89_.color,(c89_.x,c89_.y),c89_.r,c89_.thickness)
            v2126 = math.floor(internal_timer/100)
            time_ = v2126
            try:
                if eventos[0].type == pygame.KEYDOWN and eventos[0].key == pygame.K_r:
                    v2127 = corpo1_.x
                    v1_ = v2127
                    v2128 = corpo1_.y
                    v2_ = v2128
                    v2131 = v1_
                    v2132 = -1
                    v2130 = v2131 * v2132
                    v2133 = 50
                    v2129 = v2130 + v2133
                    v2136 = v2_
                    v2137 = -1
                    v2135 = v2136 * v2137
                    v2138 = 50
                    v2134 = v2135 + v2138
                    corpo1_.translate(v2129, v2134)
                    v2141 = v1_
                    v2142 = -1
                    v2140 = v2141 * v2142
                    v2143 = 50
                    v2139 = v2140 + v2143
                    v2146 = v2_
                    v2147 = -1
                    v2145 = v2146 * v2147
                    v2148 = 50
                    v2144 = v2145 + v2148
                    corpo2_.translate(v2139, v2144)
                    v2151 = v1_
                    v2152 = -1
                    v2150 = v2151 * v2152
                    v2153 = 50
                    v2149 = v2150 + v2153
                    v2156 = v2_
                    v2157 = -1
                    v2155 = v2156 * v2157
                    v2158 = 50
                    v2154 = v2155 + v2158
                    corpo3_.translate(v2149, v2154)
                    v2161 = v1_
                    v2162 = -1
                    v2160 = v2161 * v2162
                    v2163 = 50
                    v2159 = v2160 + v2163
                    v2166 = v2_
                    v2167 = -1
                    v2165 = v2166 * v2167
                    v2168 = 50
                    v2164 = v2165 + v2168
                    corpo4_.translate(v2159, v2164)
                    v2171 = v1_
                    v2172 = -1
                    v2170 = v2171 * v2172
                    v2173 = 50
                    v2169 = v2170 + v2173
                    v2176 = v2_
                    v2177 = -1
                    v2175 = v2176 * v2177
                    v2178 = 50
                    v2174 = v2175 + v2178
                    corpo5_.translate(v2169, v2174)
                    v2181 = v1_
                    v2182 = -1
                    v2180 = v2181 * v2182
                    v2183 = 50
                    v2179 = v2180 + v2183
                    v2186 = v2_
                    v2187 = -1
                    v2185 = v2186 * v2187
                    v2188 = 50
                    v2184 = v2185 + v2188
                    olho1_.translate(v2179, v2184)
                    v2191 = v1_
                    v2192 = -1
                    v2190 = v2191 * v2192
                    v2193 = 50
                    v2189 = v2190 + v2193
                    v2196 = v2_
                    v2197 = -1
                    v2195 = v2196 * v2197
                    v2198 = 50
                    v2194 = v2195 + v2198
                    olho2_.translate(v2189, v2194)
                    v2201 = v1_
                    v2202 = -1
                    v2200 = v2201 * v2202
                    v2203 = 50
                    v2199 = v2200 + v2203
                    v2206 = v2_
                    v2207 = -1
                    v2205 = v2206 * v2207
                    v2208 = 50
                    v2204 = v2205 + v2208
                    olho11_.translate(v2199, v2204)
                    v2211 = v1_
                    v2212 = -1
                    v2210 = v2211 * v2212
                    v2213 = 50
                    v2209 = v2210 + v2213
                    v2216 = v2_
                    v2217 = -1
                    v2215 = v2216 * v2217
                    v2218 = 50
                    v2214 = v2215 + v2218
                    olho22_.translate(v2209, v2214)
                    v2221 = v1_
                    v2222 = -1
                    v2220 = v2221 * v2222
                    v2223 = 50
                    v2219 = v2220 + v2223
                    v2226 = v2_
                    v2227 = -1
                    v2225 = v2226 * v2227
                    v2228 = 50
                    v2224 = v2225 + v2228
                    Borda_.translate(v2219, v2224)
                    v2229 = corpo_1_.x
                    v1_ = v2229
                    v2230 = corpo_1_.y
                    v2_ = v2230
                    v2233 = v1_
                    v2234 = -1
                    v2232 = v2233 * v2234
                    v2235 = 750
                    v2231 = v2232 + v2235
                    v2238 = v2_
                    v2239 = -1
                    v2237 = v2238 * v2239
                    v2240 = 50
                    v2236 = v2237 + v2240
                    corpo_1_.translate(v2231, v2236)
                    v2243 = v1_
                    v2244 = -1
                    v2242 = v2243 * v2244
                    v2245 = 750
                    v2241 = v2242 + v2245
                    v2248 = v2_
                    v2249 = -1
                    v2247 = v2248 * v2249
                    v2250 = 50
                    v2246 = v2247 + v2250
                    corpo_2_.translate(v2241, v2246)
                    v2253 = v1_
                    v2254 = -1
                    v2252 = v2253 * v2254
                    v2255 = 750
                    v2251 = v2252 + v2255
                    v2258 = v2_
                    v2259 = -1
                    v2257 = v2258 * v2259
                    v2260 = 50
                    v2256 = v2257 + v2260
                    corpo_3_.translate(v2251, v2256)
                    v2263 = v1_
                    v2264 = -1
                    v2262 = v2263 * v2264
                    v2265 = 750
                    v2261 = v2262 + v2265
                    v2268 = v2_
                    v2269 = -1
                    v2267 = v2268 * v2269
                    v2270 = 50
                    v2266 = v2267 + v2270
                    corpo_4_.translate(v2261, v2266)
                    v2273 = v1_
                    v2274 = -1
                    v2272 = v2273 * v2274
                    v2275 = 750
                    v2271 = v2272 + v2275
                    v2278 = v2_
                    v2279 = -1
                    v2277 = v2278 * v2279
                    v2280 = 50
                    v2276 = v2277 + v2280
                    corpo_5_.translate(v2271, v2276)
                    v2283 = v1_
                    v2284 = -1
                    v2282 = v2283 * v2284
                    v2285 = 750
                    v2281 = v2282 + v2285
                    v2288 = v2_
                    v2289 = -1
                    v2287 = v2288 * v2289
                    v2290 = 50
                    v2286 = v2287 + v2290
                    olho_1_.translate(v2281, v2286)
                    v2293 = v1_
                    v2294 = -1
                    v2292 = v2293 * v2294
                    v2295 = 750
                    v2291 = v2292 + v2295
                    v2298 = v2_
                    v2299 = -1
                    v2297 = v2298 * v2299
                    v2300 = 50
                    v2296 = v2297 + v2300
                    olho_2_.translate(v2291, v2296)
                    v2303 = v1_
                    v2304 = -1
                    v2302 = v2303 * v2304
                    v2305 = 750
                    v2301 = v2302 + v2305
                    v2308 = v2_
                    v2309 = -1
                    v2307 = v2308 * v2309
                    v2310 = 50
                    v2306 = v2307 + v2310
                    olho_11_.translate(v2301, v2306)
                    v2313 = v1_
                    v2314 = -1
                    v2312 = v2313 * v2314
                    v2315 = 750
                    v2311 = v2312 + v2315
                    v2318 = v2_
                    v2319 = -1
                    v2317 = v2318 * v2319
                    v2320 = 50
                    v2316 = v2317 + v2320
                    olho_22_.translate(v2311, v2316)
                    v2323 = v1_
                    v2324 = -1
                    v2322 = v2323 * v2324
                    v2325 = 750
                    v2321 = v2322 + v2325
                    v2328 = v2_
                    v2329 = -1
                    v2327 = v2328 * v2329
                    v2330 = 50
                    v2326 = v2327 + v2330
                    Borda__.translate(v2321, v2326)
                    v2331 = corpo__1_.x
                    v1_ = v2331
                    v2332 = corpo__1_.y
                    v2_ = v2332
                    v2335 = v1_
                    v2336 = -1
                    v2334 = v2335 * v2336
                    v2337 = 750
                    v2333 = v2334 + v2337
                    v2340 = v2_
                    v2341 = -1
                    v2339 = v2340 * v2341
                    v2342 = 850
                    v2338 = v2339 + v2342
                    corpo__1_.translate(v2333, v2338)
                    v2345 = v1_
                    v2346 = -1
                    v2344 = v2345 * v2346
                    v2347 = 750
                    v2343 = v2344 + v2347
                    v2350 = v2_
                    v2351 = -1
                    v2349 = v2350 * v2351
                    v2352 = 850
                    v2348 = v2349 + v2352
                    corpo__2_.translate(v2343, v2348)
                    v2355 = v1_
                    v2356 = -1
                    v2354 = v2355 * v2356
                    v2357 = 750
                    v2353 = v2354 + v2357
                    v2360 = v2_
                    v2361 = -1
                    v2359 = v2360 * v2361
                    v2362 = 850
                    v2358 = v2359 + v2362
                    corpo__3_.translate(v2353, v2358)
                    v2365 = v1_
                    v2366 = -1
                    v2364 = v2365 * v2366
                    v2367 = 750
                    v2363 = v2364 + v2367
                    v2370 = v2_
                    v2371 = -1
                    v2369 = v2370 * v2371
                    v2372 = 850
                    v2368 = v2369 + v2372
                    corpo__4_.translate(v2363, v2368)
                    v2375 = v1_
                    v2376 = -1
                    v2374 = v2375 * v2376
                    v2377 = 750
                    v2373 = v2374 + v2377
                    v2380 = v2_
                    v2381 = -1
                    v2379 = v2380 * v2381
                    v2382 = 850
                    v2378 = v2379 + v2382
                    corpo__5_.translate(v2373, v2378)
                    v2385 = v1_
                    v2386 = -1
                    v2384 = v2385 * v2386
                    v2387 = 750
                    v2383 = v2384 + v2387
                    v2390 = v2_
                    v2391 = -1
                    v2389 = v2390 * v2391
                    v2392 = 850
                    v2388 = v2389 + v2392
                    olho__1_.translate(v2383, v2388)
                    v2395 = v1_
                    v2396 = -1
                    v2394 = v2395 * v2396
                    v2397 = 750
                    v2393 = v2394 + v2397
                    v2400 = v2_
                    v2401 = -1
                    v2399 = v2400 * v2401
                    v2402 = 850
                    v2398 = v2399 + v2402
                    olho__2_.translate(v2393, v2398)
                    v2405 = v1_
                    v2406 = -1
                    v2404 = v2405 * v2406
                    v2407 = 750
                    v2403 = v2404 + v2407
                    v2410 = v2_
                    v2411 = -1
                    v2409 = v2410 * v2411
                    v2412 = 850
                    v2408 = v2409 + v2412
                    olho__11_.translate(v2403, v2408)
                    v2415 = v1_
                    v2416 = -1
                    v2414 = v2415 * v2416
                    v2417 = 750
                    v2413 = v2414 + v2417
                    v2420 = v2_
                    v2421 = -1
                    v2419 = v2420 * v2421
                    v2422 = 850
                    v2418 = v2419 + v2422
                    olho__22_.translate(v2413, v2418)
                    v2425 = v1_
                    v2426 = -1
                    v2424 = v2425 * v2426
                    v2427 = 750
                    v2423 = v2424 + v2427
                    v2430 = v2_
                    v2431 = -1
                    v2429 = v2430 * v2431
                    v2432 = 850
                    v2428 = v2429 + v2432
                    Borda___.translate(v2423, v2428)
                    v2433 = corpo___1_.x
                    v1_ = v2433
                    v2434 = corpo___1_.y
                    v2_ = v2434
                    v2437 = v1_
                    v2438 = -1
                    v2436 = v2437 * v2438
                    v2439 = 50
                    v2435 = v2436 + v2439
                    v2442 = v2_
                    v2443 = -1
                    v2441 = v2442 * v2443
                    v2444 = 850
                    v2440 = v2441 + v2444
                    corpo___1_.translate(v2435, v2440)
                    v2447 = v1_
                    v2448 = -1
                    v2446 = v2447 * v2448
                    v2449 = 50
                    v2445 = v2446 + v2449
                    v2452 = v2_
                    v2453 = -1
                    v2451 = v2452 * v2453
                    v2454 = 850
                    v2450 = v2451 + v2454
                    corpo___2_.translate(v2445, v2450)
                    v2457 = v1_
                    v2458 = -1
                    v2456 = v2457 * v2458
                    v2459 = 50
                    v2455 = v2456 + v2459
                    v2462 = v2_
                    v2463 = -1
                    v2461 = v2462 * v2463
                    v2464 = 850
                    v2460 = v2461 + v2464
                    corpo___3_.translate(v2455, v2460)
                    v2467 = v1_
                    v2468 = -1
                    v2466 = v2467 * v2468
                    v2469 = 50
                    v2465 = v2466 + v2469
                    v2472 = v2_
                    v2473 = -1
                    v2471 = v2472 * v2473
                    v2474 = 850
                    v2470 = v2471 + v2474
                    corpo___4_.translate(v2465, v2470)
                    v2477 = v1_
                    v2478 = -1
                    v2476 = v2477 * v2478
                    v2479 = 50
                    v2475 = v2476 + v2479
                    v2482 = v2_
                    v2483 = -1
                    v2481 = v2482 * v2483
                    v2484 = 850
                    v2480 = v2481 + v2484
                    corpo___5_.translate(v2475, v2480)
                    v2487 = v1_
                    v2488 = -1
                    v2486 = v2487 * v2488
                    v2489 = 50
                    v2485 = v2486 + v2489
                    v2492 = v2_
                    v2493 = -1
                    v2491 = v2492 * v2493
                    v2494 = 850
                    v2490 = v2491 + v2494
                    olho___1_.translate(v2485, v2490)
                    v2497 = v1_
                    v2498 = -1
                    v2496 = v2497 * v2498
                    v2499 = 50
                    v2495 = v2496 + v2499
                    v2502 = v2_
                    v2503 = -1
                    v2501 = v2502 * v2503
                    v2504 = 850
                    v2500 = v2501 + v2504
                    olho___2_.translate(v2495, v2500)
                    v2507 = v1_
                    v2508 = -1
                    v2506 = v2507 * v2508
                    v2509 = 50
                    v2505 = v2506 + v2509
                    v2512 = v2_
                    v2513 = -1
                    v2511 = v2512 * v2513
                    v2514 = 850
                    v2510 = v2511 + v2514
                    olho___11_.translate(v2505, v2510)
                    v2517 = v1_
                    v2518 = -1
                    v2516 = v2517 * v2518
                    v2519 = 50
                    v2515 = v2516 + v2519
                    v2522 = v2_
                    v2523 = -1
                    v2521 = v2522 * v2523
                    v2524 = 850
                    v2520 = v2521 + v2524
                    olho___22_.translate(v2515, v2520)
                    v2527 = v1_
                    v2528 = -1
                    v2526 = v2527 * v2528
                    v2529 = 50
                    v2525 = v2526 + v2529
                    v2532 = v2_
                    v2533 = -1
                    v2531 = v2532 * v2533
                    v2534 = 850
                    v2530 = v2531 + v2534
                    Borda____.translate(v2525, v2530)
                    v2535 = corpo_.x
                    v1_ = v2535
                    v2536 = corpo_.y
                    v2_ = v2536
                    v2539 = v1_
                    v2540 = -1
                    v2538 = v2539 * v2540
                    v2541 = 40
                    v2537 = v2538 + v2541
                    v2544 = v2_
                    v2545 = -1
                    v2543 = v2544 * v2545
                    v2546 = 50
                    v2542 = v2543 + v2546
                    corpo_.translate(v2537, v2542)
                    v2549 = v1_
                    v2550 = -1
                    v2548 = v2549 * v2550
                    v2551 = 40
                    v2547 = v2548 + v2551
                    v2554 = v2_
                    v2555 = -1
                    v2553 = v2554 * v2555
                    v2556 = 50
                    v2552 = v2553 + v2556
                    boca_.translate(v2547, v2552)
                    v2557 = x1_
                    boca_.x1 = v2557
                    v2558 = y1_
                    boca_.y1 = v2558
                    v2559 = x2_
                    boca_.x2 = v2559
                    v2560 = y2_
                    boca_.y2 = v2560
                    v2561 = x3_
                    boca_.x3 = v2561
                    v2562 = y3_
                    boca_.y3 = v2562
                    v2563 = 70
                    v2564 = 0
                    corpo_.translate(v2563, v2564)
                    v2565 = 70
                    v2566 = 0
                    boca_.translate(v2565, v2566)
                    v2567 = 0
                    timer1_ = v2567
                    v2568 = 0
                    timer2_ = v2568
                    v2569 = 0
                    timer3_ = v2569
                    v2570 = 0
                    timer4_ = v2570
                    internal_timer = -1
                    v2571 = 89
                    moeda_ = v2571
                    v2572 = 2
                    speed_x_ = v2572
                    v2573 = 0
                    speed_y_ = v2573
                    v2574 = False
                    c1_.hidden = v2574
                    v2575 = False
                    c2_.hidden = v2575
                    v2576 = False
                    c3_.hidden = v2576
                    v2577 = False
                    c4_.hidden = v2577
                    v2578 = False
                    c5_.hidden = v2578
                    v2579 = False
                    c6_.hidden = v2579
                    v2580 = False
                    c7_.hidden = v2580
                    v2581 = False
                    c8_.hidden = v2581
                    v2582 = False
                    c9_.hidden = v2582
                    v2583 = False
                    c10_.hidden = v2583
                    v2584 = False
                    c11_.hidden = v2584
                    v2585 = False
                    c12_.hidden = v2585
                    v2586 = False
                    c13_.hidden = v2586
                    v2587 = False
                    c14_.hidden = v2587
                    v2588 = False
                    c15_.hidden = v2588
                    v2589 = False
                    c16_.hidden = v2589
                    v2590 = False
                    c17_.hidden = v2590
                    v2591 = False
                    c18_.hidden = v2591
                    v2592 = False
                    c19_.hidden = v2592
                    v2593 = False
                    c20_.hidden = v2593
                    v2594 = False
                    c21_.hidden = v2594
                    v2595 = False
                    c22_.hidden = v2595
                    v2596 = False
                    c23_.hidden = v2596
                    v2597 = False
                    c24_.hidden = v2597
                    v2598 = False
                    c25_.hidden = v2598
                    v2599 = False
                    c26_.hidden = v2599
                    v2600 = False
                    c27_.hidden = v2600
                    v2601 = False
                    c28_.hidden = v2601
                    v2602 = False
                    c29_.hidden = v2602
                    v2603 = False
                    c30_.hidden = v2603
                    v2604 = False
                    c31_.hidden = v2604
                    v2605 = False
                    c32_.hidden = v2605
                    v2606 = False
                    c33_.hidden = v2606
                    v2607 = False
                    c34_.hidden = v2607
                    v2608 = False
                    c35_.hidden = v2608
                    v2609 = False
                    c36_.hidden = v2609
                    v2610 = False
                    c37_.hidden = v2610
                    v2611 = False
                    c38_.hidden = v2611
                    v2612 = False
                    c39_.hidden = v2612
                    v2613 = False
                    c40_.hidden = v2613
                    v2614 = False
                    c41_.hidden = v2614
                    v2615 = False
                    c42_.hidden = v2615
                    v2616 = False
                    c43_.hidden = v2616
                    v2617 = False
                    c44_.hidden = v2617
                    v2618 = False
                    c45_.hidden = v2618
                    v2619 = False
                    c46_.hidden = v2619
                    v2620 = False
                    c47_.hidden = v2620
                    v2621 = False
                    c48_.hidden = v2621
                    v2622 = False
                    c49_.hidden = v2622
                    v2623 = False
                    c50_.hidden = v2623
                    v2624 = False
                    c51_.hidden = v2624
                    v2625 = False
                    c52_.hidden = v2625
                    v2626 = False
                    c53_.hidden = v2626
                    v2627 = False
                    c54_.hidden = v2627
                    v2628 = False
                    c55_.hidden = v2628
                    v2629 = False
                    c56_.hidden = v2629
                    v2630 = False
                    c57_.hidden = v2630
                    v2631 = False
                    c58_.hidden = v2631
                    v2632 = False
                    c59_.hidden = v2632
                    v2633 = False
                    c60_.hidden = v2633
                    v2634 = False
                    c61_.hidden = v2634
                    v2635 = False
                    c62_.hidden = v2635
                    v2636 = False
                    c63_.hidden = v2636
                    v2637 = False
                    c64_.hidden = v2637
                    v2638 = False
                    c65_.hidden = v2638
                    v2639 = False
                    c66_.hidden = v2639
                    v2640 = False
                    c67_.hidden = v2640
                    v2641 = False
                    c68_.hidden = v2641
                    v2642 = False
                    c69_.hidden = v2642
                    v2643 = False
                    c70_.hidden = v2643
                    v2644 = False
                    c71_.hidden = v2644
                    v2645 = False
                    c72_.hidden = v2645
                    v2646 = False
                    c73_.hidden = v2646
                    v2647 = False
                    c74_.hidden = v2647
                    v2648 = False
                    c75_.hidden = v2648
                    v2649 = False
                    c76_.hidden = v2649
                    v2650 = False
                    c77_.hidden = v2650
                    v2651 = False
                    c78_.hidden = v2651
                    v2652 = False
                    c79_.hidden = v2652
                    v2653 = False
                    c80_.hidden = v2653
                    v2654 = False
                    c81_.hidden = v2654
                    v2655 = False
                    c82_.hidden = v2655
                    v2656 = False
                    c83_.hidden = v2656
                    v2657 = False
                    c84_.hidden = v2657
                    v2658 = False
                    c85_.hidden = v2658
                    v2659 = False
                    c86_.hidden = v2659
                    v2660 = False
                    c87_.hidden = v2660
                    v2661 = False
                    c88_.hidden = v2661
                    v2662 = False
                    c89_.hidden = v2662
            except:
                pass
        else:
            v2663 = win_
            if (v2663):
                v2664 = 2
                v2665 = corpo1_.x
                v2666 = corpo1_.y
                corpo1_.rotate(v2664, v2665, v2666)
                v2667 = 2
                v2668 = corpo1_.x
                v2669 = corpo1_.y
                corpo2_.rotate(v2667, v2668, v2669)
                v2670 = 2
                v2671 = corpo1_.x
                v2672 = corpo1_.y
                corpo3_.rotate(v2670, v2671, v2672)
                v2673 = 2
                v2674 = corpo1_.x
                v2675 = corpo1_.y
                corpo4_.rotate(v2673, v2674, v2675)
                v2676 = 2
                v2677 = corpo1_.x
                v2678 = corpo1_.y
                corpo5_.rotate(v2676, v2677, v2678)
                v2679 = 2
                v2680 = corpo1_.x
                v2681 = corpo1_.y
                olho1_.rotate(v2679, v2680, v2681)
                v2682 = 2
                v2683 = corpo1_.x
                v2684 = corpo1_.y
                olho2_.rotate(v2682, v2683, v2684)
                v2685 = 2
                v2686 = corpo1_.x
                v2687 = corpo1_.y
                olho11_.rotate(v2685, v2686, v2687)
                v2688 = 2
                v2689 = corpo1_.x
                v2690 = corpo1_.y
                olho22_.rotate(v2688, v2689, v2690)
                v2691 = 2
                v2692 = corpo1_.x
                v2693 = corpo1_.y
                Borda_.rotate(v2691, v2692, v2693)
                v2694 = 2
                v2695 = corpo_1_.x
                v2696 = corpo_1_.y
                corpo_1_.rotate(v2694, v2695, v2696)
                v2697 = 2
                v2698 = corpo_1_.x
                v2699 = corpo_1_.y
                corpo_2_.rotate(v2697, v2698, v2699)
                v2700 = 2
                v2701 = corpo_1_.x
                v2702 = corpo_1_.y
                corpo_3_.rotate(v2700, v2701, v2702)
                v2703 = 2
                v2704 = corpo_1_.x
                v2705 = corpo_1_.y
                corpo_4_.rotate(v2703, v2704, v2705)
                v2706 = 2
                v2707 = corpo_1_.x
                v2708 = corpo_1_.y
                corpo_5_.rotate(v2706, v2707, v2708)
                v2709 = 2
                v2710 = corpo_1_.x
                v2711 = corpo_1_.y
                olho_1_.rotate(v2709, v2710, v2711)
                v2712 = 2
                v2713 = corpo_1_.x
                v2714 = corpo_1_.y
                olho_2_.rotate(v2712, v2713, v2714)
                v2715 = 2
                v2716 = corpo_1_.x
                v2717 = corpo_1_.y
                olho_11_.rotate(v2715, v2716, v2717)
                v2718 = 2
                v2719 = corpo_1_.x
                v2720 = corpo_1_.y
                olho_22_.rotate(v2718, v2719, v2720)
                v2721 = 2
                v2722 = corpo_1_.x
                v2723 = corpo_1_.y
                Borda__.rotate(v2721, v2722, v2723)
                v2724 = 2
                v2725 = corpo__1_.x
                v2726 = corpo__1_.y
                corpo__1_.rotate(v2724, v2725, v2726)
                v2727 = 2
                v2728 = corpo__1_.x
                v2729 = corpo__1_.y
                corpo__2_.rotate(v2727, v2728, v2729)
                v2730 = 2
                v2731 = corpo__1_.x
                v2732 = corpo__1_.y
                corpo__3_.rotate(v2730, v2731, v2732)
                v2733 = 2
                v2734 = corpo__1_.x
                v2735 = corpo__1_.y
                corpo__4_.rotate(v2733, v2734, v2735)
                v2736 = 2
                v2737 = corpo__1_.x
                v2738 = corpo__1_.y
                corpo__5_.rotate(v2736, v2737, v2738)
                v2739 = 2
                v2740 = corpo__1_.x
                v2741 = corpo__1_.y
                olho__1_.rotate(v2739, v2740, v2741)
                v2742 = 2
                v2743 = corpo__1_.x
                v2744 = corpo__1_.y
                olho__2_.rotate(v2742, v2743, v2744)
                v2745 = 2
                v2746 = corpo__1_.x
                v2747 = corpo__1_.y
                olho__11_.rotate(v2745, v2746, v2747)
                v2748 = 2
                v2749 = corpo__1_.x
                v2750 = corpo__1_.y
                olho__22_.rotate(v2748, v2749, v2750)
                v2751 = 2
                v2752 = corpo__1_.x
                v2753 = corpo__1_.y
                Borda___.rotate(v2751, v2752, v2753)
                v2754 = 2
                v2755 = corpo___1_.x
                v2756 = corpo___1_.y
                corpo___1_.rotate(v2754, v2755, v2756)
                v2757 = 2
                v2758 = corpo___1_.x
                v2759 = corpo___1_.y
                corpo___2_.rotate(v2757, v2758, v2759)
                v2760 = 2
                v2761 = corpo___1_.x
                v2762 = corpo___1_.y
                corpo___3_.rotate(v2760, v2761, v2762)
                v2763 = 2
                v2764 = corpo___1_.x
                v2765 = corpo___1_.y
                corpo___4_.rotate(v2763, v2764, v2765)
                v2766 = 2
                v2767 = corpo___1_.x
                v2768 = corpo___1_.y
                corpo___5_.rotate(v2766, v2767, v2768)
                v2769 = 2
                v2770 = corpo___1_.x
                v2771 = corpo___1_.y
                olho___1_.rotate(v2769, v2770, v2771)
                v2772 = 2
                v2773 = corpo___1_.x
                v2774 = corpo___1_.y
                olho___2_.rotate(v2772, v2773, v2774)
                v2775 = 2
                v2776 = corpo___1_.x
                v2777 = corpo___1_.y
                olho___11_.rotate(v2775, v2776, v2777)
                v2778 = 2
                v2779 = corpo___1_.x
                v2780 = corpo___1_.y
                olho___22_.rotate(v2778, v2779, v2780)
                v2781 = 2
                v2782 = corpo___1_.x
                v2783 = corpo___1_.y
                Borda____.rotate(v2781, v2782, v2783)
                v2784 = 2
                v2785 = corpo_.x
                v2786 = corpo_.y
                corpo_.rotate(v2784, v2785, v2786)
                v2787 = 2
                v2788 = corpo_.x
                v2789 = corpo_.y
                boca_.rotate(v2787, v2788, v2789)
                in_ = f"You win in {time_}s"
                contador__ = in_
                if(isinstance(in_, int)):
                    contador__ = str(in_)

                font = pygame.font.Font('freesansbold.ttf', 80)
                text = font.render(contador__, True, YELLOW_, BLACK_)
                textRect = text.get_rect()
                textRect.center = (400, 450)
                drawstringlllll_ = True
            else:
                v2790 = 2
                v2791 = corpo1_.x
                v2792 = corpo1_.y
                corpo1_.rotate(v2790, v2791, v2792)
                v2793 = 2
                v2794 = corpo1_.x
                v2795 = corpo1_.y
                corpo2_.rotate(v2793, v2794, v2795)
                v2796 = 2
                v2797 = corpo1_.x
                v2798 = corpo1_.y
                corpo3_.rotate(v2796, v2797, v2798)
                v2799 = 2
                v2800 = corpo1_.x
                v2801 = corpo1_.y
                corpo4_.rotate(v2799, v2800, v2801)
                v2802 = 2
                v2803 = corpo1_.x
                v2804 = corpo1_.y
                corpo5_.rotate(v2802, v2803, v2804)
                v2805 = 2
                v2806 = corpo1_.x
                v2807 = corpo1_.y
                olho1_.rotate(v2805, v2806, v2807)
                v2808 = 2
                v2809 = corpo1_.x
                v2810 = corpo1_.y
                olho2_.rotate(v2808, v2809, v2810)
                v2811 = 2
                v2812 = corpo1_.x
                v2813 = corpo1_.y
                olho11_.rotate(v2811, v2812, v2813)
                v2814 = 2
                v2815 = corpo1_.x
                v2816 = corpo1_.y
                olho22_.rotate(v2814, v2815, v2816)
                v2817 = 2
                v2818 = corpo1_.x
                v2819 = corpo1_.y
                Borda_.rotate(v2817, v2818, v2819)
                v2820 = 2
                v2821 = corpo_1_.x
                v2822 = corpo_1_.y
                corpo_1_.rotate(v2820, v2821, v2822)
                v2823 = 2
                v2824 = corpo_1_.x
                v2825 = corpo_1_.y
                corpo_2_.rotate(v2823, v2824, v2825)
                v2826 = 2
                v2827 = corpo_1_.x
                v2828 = corpo_1_.y
                corpo_3_.rotate(v2826, v2827, v2828)
                v2829 = 2
                v2830 = corpo_1_.x
                v2831 = corpo_1_.y
                corpo_4_.rotate(v2829, v2830, v2831)
                v2832 = 2
                v2833 = corpo_1_.x
                v2834 = corpo_1_.y
                corpo_5_.rotate(v2832, v2833, v2834)
                v2835 = 2
                v2836 = corpo_1_.x
                v2837 = corpo_1_.y
                olho_1_.rotate(v2835, v2836, v2837)
                v2838 = 2
                v2839 = corpo_1_.x
                v2840 = corpo_1_.y
                olho_2_.rotate(v2838, v2839, v2840)
                v2841 = 2
                v2842 = corpo_1_.x
                v2843 = corpo_1_.y
                olho_11_.rotate(v2841, v2842, v2843)
                v2844 = 2
                v2845 = corpo_1_.x
                v2846 = corpo_1_.y
                olho_22_.rotate(v2844, v2845, v2846)
                v2847 = 2
                v2848 = corpo_1_.x
                v2849 = corpo_1_.y
                Borda__.rotate(v2847, v2848, v2849)
                v2850 = 2
                v2851 = corpo__1_.x
                v2852 = corpo__1_.y
                corpo__1_.rotate(v2850, v2851, v2852)
                v2853 = 2
                v2854 = corpo__1_.x
                v2855 = corpo__1_.y
                corpo__2_.rotate(v2853, v2854, v2855)
                v2856 = 2
                v2857 = corpo__1_.x
                v2858 = corpo__1_.y
                corpo__3_.rotate(v2856, v2857, v2858)
                v2859 = 2
                v2860 = corpo__1_.x
                v2861 = corpo__1_.y
                corpo__4_.rotate(v2859, v2860, v2861)
                v2862 = 2
                v2863 = corpo__1_.x
                v2864 = corpo__1_.y
                corpo__5_.rotate(v2862, v2863, v2864)
                v2865 = 2
                v2866 = corpo__1_.x
                v2867 = corpo__1_.y
                olho__1_.rotate(v2865, v2866, v2867)
                v2868 = 2
                v2869 = corpo__1_.x
                v2870 = corpo__1_.y
                olho__2_.rotate(v2868, v2869, v2870)
                v2871 = 2
                v2872 = corpo__1_.x
                v2873 = corpo__1_.y
                olho__11_.rotate(v2871, v2872, v2873)
                v2874 = 2
                v2875 = corpo__1_.x
                v2876 = corpo__1_.y
                olho__22_.rotate(v2874, v2875, v2876)
                v2877 = 2
                v2878 = corpo__1_.x
                v2879 = corpo__1_.y
                Borda___.rotate(v2877, v2878, v2879)
                v2880 = 2
                v2881 = corpo___1_.x
                v2882 = corpo___1_.y
                corpo___1_.rotate(v2880, v2881, v2882)
                v2883 = 2
                v2884 = corpo___1_.x
                v2885 = corpo___1_.y
                corpo___2_.rotate(v2883, v2884, v2885)
                v2886 = 2
                v2887 = corpo___1_.x
                v2888 = corpo___1_.y
                corpo___3_.rotate(v2886, v2887, v2888)
                v2889 = 2
                v2890 = corpo___1_.x
                v2891 = corpo___1_.y
                corpo___4_.rotate(v2889, v2890, v2891)
                v2892 = 2
                v2893 = corpo___1_.x
                v2894 = corpo___1_.y
                corpo___5_.rotate(v2892, v2893, v2894)
                v2895 = 2
                v2896 = corpo___1_.x
                v2897 = corpo___1_.y
                olho___1_.rotate(v2895, v2896, v2897)
                v2898 = 2
                v2899 = corpo___1_.x
                v2900 = corpo___1_.y
                olho___2_.rotate(v2898, v2899, v2900)
                v2901 = 2
                v2902 = corpo___1_.x
                v2903 = corpo___1_.y
                olho___11_.rotate(v2901, v2902, v2903)
                v2904 = 2
                v2905 = corpo___1_.x
                v2906 = corpo___1_.y
                olho___22_.rotate(v2904, v2905, v2906)
                v2907 = 2
                v2908 = corpo___1_.x
                v2909 = corpo___1_.y
                Borda____.rotate(v2907, v2908, v2909)
                v2910 = 2
                v2911 = corpo_.x
                v2912 = corpo_.y
                corpo_.rotate(v2910, v2911, v2912)
                v2913 = 2
                v2914 = corpo_.x
                v2915 = corpo_.y
                boca_.rotate(v2913, v2914, v2915)
                in_ = f"You Lost !!"
                contador__ = in_
                if(isinstance(in_, int)):
                    contador__ = str(in_)

                font = pygame.font.Font('freesansbold.ttf', 60)
                text = font.render(contador__, True, YELLOW_, BLACK_)
                textRect = text.get_rect()
                textRect.center = (400, 450)
                drawstringlllll_ = True


        try:
            if eventos[0].type == pygame.KEYDOWN and eventos[0].key == pygame.K_ESCAPE:
                break
        except:
            pass
        if(corpo_.hidden == False):
            pygame.draw.circle(display,corpo_.color,(corpo_.x,corpo_.y),corpo_.r,corpo_.thickness)
        boca_.update()
        if(boca_.hidden == False):
            pygame.draw.polygon(display, boca_.color, boca_.points, boca_.thickness)
        if(corpo1_.hidden == False):
            pygame.draw.circle(display,corpo1_.color,(corpo1_.x,corpo1_.y),corpo1_.r,corpo1_.thickness)
        corpo2_.update()
        if(corpo2_.hidden == False):
            pygame.draw.polygon(display, corpo2_.color, corpo2_.points, corpo2_.thickness)
        corpo3_.update()
        if(corpo3_.hidden == False):
            pygame.draw.polygon(display, corpo3_.color, corpo3_.points, corpo3_.thickness)
        corpo4_.update()
        if(corpo4_.hidden == False):
            pygame.draw.polygon(display, corpo4_.color, corpo4_.points, corpo4_.thickness)
        corpo5_.update()
        if(corpo5_.hidden == False):
            pygame.draw.polygon(display, corpo5_.color, corpo5_.points, corpo5_.thickness)
        if(olho1_.hidden == False):
            pygame.draw.circle(display,olho1_.color,(olho1_.x,olho1_.y),olho1_.r,olho1_.thickness)
        if(olho2_.hidden == False):
            pygame.draw.circle(display,olho2_.color,(olho2_.x,olho2_.y),olho2_.r,olho2_.thickness)
        if(olho11_.hidden == False):
            pygame.draw.circle(display,olho11_.color,(olho11_.x,olho11_.y),olho11_.r,olho11_.thickness)
        if(olho22_.hidden == False):
            pygame.draw.circle(display,olho22_.color,(olho22_.x,olho22_.y),olho22_.r,olho22_.thickness)
        Borda_.update()
        if(Borda_.hidden == False):
            pygame.draw.polygon(display, Borda_.color, Borda_.points, Borda_.thickness)
        if(corpo_1_.hidden == False):
            pygame.draw.circle(display,corpo_1_.color,(corpo_1_.x,corpo_1_.y),corpo_1_.r,corpo_1_.thickness)
        corpo_2_.update()
        if(corpo_2_.hidden == False):
            pygame.draw.polygon(display, corpo_2_.color, corpo_2_.points, corpo_2_.thickness)
        corpo_3_.update()
        if(corpo_3_.hidden == False):
            pygame.draw.polygon(display, corpo_3_.color, corpo_3_.points, corpo_3_.thickness)
        corpo_4_.update()
        if(corpo_4_.hidden == False):
            pygame.draw.polygon(display, corpo_4_.color, corpo_4_.points, corpo_4_.thickness)
        corpo_5_.update()
        if(corpo_5_.hidden == False):
            pygame.draw.polygon(display, corpo_5_.color, corpo_5_.points, corpo_5_.thickness)
        if(olho_1_.hidden == False):
            pygame.draw.circle(display,olho_1_.color,(olho_1_.x,olho_1_.y),olho_1_.r,olho_1_.thickness)
        if(olho_2_.hidden == False):
            pygame.draw.circle(display,olho_2_.color,(olho_2_.x,olho_2_.y),olho_2_.r,olho_2_.thickness)
        if(olho_11_.hidden == False):
            pygame.draw.circle(display,olho_11_.color,(olho_11_.x,olho_11_.y),olho_11_.r,olho_11_.thickness)
        if(olho_22_.hidden == False):
            pygame.draw.circle(display,olho_22_.color,(olho_22_.x,olho_22_.y),olho_22_.r,olho_22_.thickness)
        Borda__.update()
        if(Borda__.hidden == False):
            pygame.draw.polygon(display, Borda__.color, Borda__.points, Borda__.thickness)
        if(corpo__1_.hidden == False):
            pygame.draw.circle(display,corpo__1_.color,(corpo__1_.x,corpo__1_.y),corpo__1_.r,corpo__1_.thickness)
        corpo__2_.update()
        if(corpo__2_.hidden == False):
            pygame.draw.polygon(display, corpo__2_.color, corpo__2_.points, corpo__2_.thickness)
        corpo__3_.update()
        if(corpo__3_.hidden == False):
            pygame.draw.polygon(display, corpo__3_.color, corpo__3_.points, corpo__3_.thickness)
        corpo__4_.update()
        if(corpo__4_.hidden == False):
            pygame.draw.polygon(display, corpo__4_.color, corpo__4_.points, corpo__4_.thickness)
        corpo__5_.update()
        if(corpo__5_.hidden == False):
            pygame.draw.polygon(display, corpo__5_.color, corpo__5_.points, corpo__5_.thickness)
        if(olho__1_.hidden == False):
            pygame.draw.circle(display,olho__1_.color,(olho__1_.x,olho__1_.y),olho__1_.r,olho__1_.thickness)
        if(olho__2_.hidden == False):
            pygame.draw.circle(display,olho__2_.color,(olho__2_.x,olho__2_.y),olho__2_.r,olho__2_.thickness)
        if(olho__11_.hidden == False):
            pygame.draw.circle(display,olho__11_.color,(olho__11_.x,olho__11_.y),olho__11_.r,olho__11_.thickness)
        if(olho__22_.hidden == False):
            pygame.draw.circle(display,olho__22_.color,(olho__22_.x,olho__22_.y),olho__22_.r,olho__22_.thickness)
        Borda___.update()
        if(Borda___.hidden == False):
            pygame.draw.polygon(display, Borda___.color, Borda___.points, Borda___.thickness)
        if(corpo___1_.hidden == False):
            pygame.draw.circle(display,corpo___1_.color,(corpo___1_.x,corpo___1_.y),corpo___1_.r,corpo___1_.thickness)
        corpo___2_.update()
        if(corpo___2_.hidden == False):
            pygame.draw.polygon(display, corpo___2_.color, corpo___2_.points, corpo___2_.thickness)
        corpo___3_.update()
        if(corpo___3_.hidden == False):
            pygame.draw.polygon(display, corpo___3_.color, corpo___3_.points, corpo___3_.thickness)
        corpo___4_.update()
        if(corpo___4_.hidden == False):
            pygame.draw.polygon(display, corpo___4_.color, corpo___4_.points, corpo___4_.thickness)
        corpo___5_.update()
        if(corpo___5_.hidden == False):
            pygame.draw.polygon(display, corpo___5_.color, corpo___5_.points, corpo___5_.thickness)
        if(olho___1_.hidden == False):
            pygame.draw.circle(display,olho___1_.color,(olho___1_.x,olho___1_.y),olho___1_.r,olho___1_.thickness)
        if(olho___2_.hidden == False):
            pygame.draw.circle(display,olho___2_.color,(olho___2_.x,olho___2_.y),olho___2_.r,olho___2_.thickness)
        if(olho___11_.hidden == False):
            pygame.draw.circle(display,olho___11_.color,(olho___11_.x,olho___11_.y),olho___11_.r,olho___11_.thickness)
        if(olho___22_.hidden == False):
            pygame.draw.circle(display,olho___22_.color,(olho___22_.x,olho___22_.y),olho___22_.r,olho___22_.thickness)
        Borda____.update()
        if(Borda____.hidden == False):
            pygame.draw.polygon(display, Borda____.color, Borda____.points, Borda____.thickness)

        internal_timer = internal_timer + 1
        pygame.display.update()
pygame.quit()
