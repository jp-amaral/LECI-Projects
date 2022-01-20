import asyncio
import getpass
import json
import os
from pygame.constants import ANYFORMAT

import websockets

# Next 4 lines are not needed for AI agents, please remove them from your code!
import pygame

pygame.init()
#program_icon = pygame.image.load("data/icon2.png")
#pygame.display.set_icon(program_icon)
#m = args[0]
# a = float(sys.argv[1])
# b = float(sys.argv[2])
# c = float(sys.argv[3])
# d = float(sys.argv[4])

a = 57006 # + float(sys.argv[1])
b = 35663 # + float(sys.argv[2])
c = 79066 # + float(sys.argv[3])
d = 20448 # + float(sys.argv[4])
e = 6000 # + float(sys.argv[5])
f = 1000 
#height, num_Holes,lines,bumpiness, emptycol, maxHeight
score_change = 260  # 2700 pontos

def mapHeight(listGames):
    height = [0] * len(listGames)
    j = 0
    for mapa in listGames:
        for x in range(1,9,1):
            for y in range(1,30,1):
                pos = [x,y]
                if pos in mapa:
                    height[j]+=29-pos[1]+1
                    break
        j+=1
    return height

def isBlocked(game, pos):
    x = pos[0]
    for y in range(pos[1], -1, -1):
        pos2 = [x,y]
        if pos2 in game:
            return True
    return False

def findLow(points):
    #print(points)
    result = max(points, key=lambda x : x[1])
    multiple = [value for value in points if value[1] == result[1]]
    mininum = min(multiple, key=lambda x : x[0])
    #print(f"RESULTADO->{mininum}")
    return mininum

def findLeft(list):
    result = min(list, key=lambda x : x[0])
    multiple = [value for value in list if value[0] == result[0]]
    return max(multiple, key=lambda x : x[1])

def findSpace(game):
    for y in range(29, -1, -1):
        for x in range(8):
            x = x + 1
            pos = [x,y]
            if pos and pos not in game and not isBlocked(game, pos):
                return pos

def numHolesArray(listArrays):
    num_Holes = [0] * len(listArrays)
    j = 0
    for mapa in listArrays:
        for x in range(8):
            for y in range(28):
                if mapa[y][x] == 1:
                    column = [row[x] for row in mapa]
                    
                    num_Holes[j] += ( (28 - y) - (sum(column[y:])-1) )
                    break
        j+=1    #proximo mapa     
    return num_Holes

def completeLinesArray(listArrays):
    lines = [0]*len(listArrays)
    maxHeights = [29]*len(listArrays)
    j = 0
    do=1
    for mapa in listArrays:
        for linha in range(29):
            if sum(mapa[linha])>=1 and do and linha > 1:
                maxHeights[j] = 29-linha
                do=0
            if sum(mapa[linha]) == 8:
                lines[j]+=1
        j+=1
        do = 1
    return lines, maxHeights

def getHeight(mapa):
    try:
        return 30-min([points[1] for points in mapa])
    except:
        return 0

# def maxHeight(listArrays):
#     pass


def mapHeightArray(listArrays):
    height = [0] * len(listArrays)
    bumpiness = [0] * len(listArrays)
    emptycol = [0] * len(listArrays)
    aux = []
    j = 0
    for mapa in listArrays:
        aux = []
        for x in range(8):
            column = [row[x] for row in mapa]
            try:
                idx = column.index(1)
            except:
                idx = 29
            altura = 29 - idx
            height[j] += altura
            aux.append(altura)
        bump = 0
        empty = 0
        for valor in range(1,8,1):
            # valor = abs(aux[valor-1]-aux[valor])
            # if valor >=4:
            #     empty+= valor*1.5
            # bump += valor
            value_aux = abs(aux[valor-1]-aux[valor])
            # if valor >=4:
            #     empty+= valor*2
            if valor ==1:
                if aux[valor]-aux[valor-1] >= 3:
                    empty +=(aux[valor]-aux[valor-1])*2
            elif valor ==8:
                if aux[valor-2]-aux[valor-1] >= 3:
                    empty +=(aux[valor-2]-aux[valor-1])*2
            else:
                if aux[valor-2]-aux[valor-1] >= 3 and aux[valor]-aux[valor-1] >= 3:
                    empty += aux[valor-2]-aux[valor-1]*2
            bump += value_aux
        bumpiness[j] = bump
        emptycol[j] = empty
        j+=1
    return height, bumpiness, emptycol

def checkShape(base, piece):
    # return
    #1-type
    #2-versao de rotacao
    #3-tamanho horizontal
    # print("*")

    array = [[0,0,0,0,0,0,0,0] for i in range(29)]
    for point in piece:
        array[point[1]-1][point[0]-1] = 1

    base = [base[0]-1,base[1]-1]
    
    # print([base[1]-1,base[0]])
    # print([base[1]-1,base[0]+1])
    # print([base[1],base[0]+1])
    # print(array[base[1]-1][ base[0]])
    # print(array[base[1]-1][ base[0]+1])
    # print(array[base[1]][ base[0]+1])
    

    #Check if its J
    try:
        if array[base[1]][base[0]+1] == 1 and array[base[1]-1][base[0]+1] == 1 and array[base[1]-2][base[0]+1] == 1:
            return 'J','1',2
    except:pass
    try:
        if array[base[1]-1][base[0]] == 1 and array[base[1]][base[0]+1] == 1 and array[base[1]][base[0]+2] == 1:
            return 'J','2',3
    except:pass
    try:
        if array[base[1]-1][base[0]] == 1 and array[base[1]-2][base[0]] == 1 and array[base[1]-2][base[0]+1] == 1:
            return 'J','3',2
    except:pass

    try:
        if array[base[1]-1][base[0]] == 1 and array[base[1]-1][base[0]-1] == 1 and array[base[1]-1][base[0]-2] == 1:
            return 'J','4',3
    except:pass

    #Check if its square
    try:
        if array[base[1]-1][ base[0]] == 1 and array[base[1]-1][ base[0]+1] == 1 and array[base[1]][ base[0]+1] ==1:
            return 'square','1',2
    except:pass
    #Check if its tower
    try:
        if array[base[1]][base[0]+3] == 1:
            return 'tower','1',4
    except:pass
    try:
        if array[base[1]-3][base[0]] == 1:
            return 'tower','2',1
    except:pass
    #Check if its Z
    try:
        if array[base[1]-1][ base[0]] == 1 and array[base[1]-1][ base[0]+1] == 1 and array[base[1]-2][ base[0]+1] == 1:
            return 'Z','1',2
    except:pass
    try:
        if array[base[1]][base[0]+1] == 1 and array[base[1]-1][ base[0]] == 1 and array[base[1]-1][base[0]-1] == 1:
            return 'Z','2',3
    except:pass

    #Check if its S
    try:
        if array[base[1]-1][base[0]] == 1 and array[base[1]-1][base[0]-1] == 1 and array[base[1]-2][base[0]-1] == 1:
            return 'S','1',2
    except:pass
    try:
        if array[base[1]][base[0]+1] == 1 and array[base[1]-1][base[0]+1] == 1 and array[base[1]-1][base[0]+2] == 1:
            return 'S','2',3
    except:pass
    #Check if its T
    try:
        if array[base[1]][base[0]+1] == 1 and array[base[1]][base[0]+2] == 1 and array[base[1]-1][base[0]+1] == 1:
            return 'T','1',3
    except:pass
    try:
        if array[base[1]-1][base[0]+1] == 1 and array[base[1]-1][base[0]] == 1 and array[base[1]-2][base[0]] == 1:
            return 'T','2',2
    except:pass
    try:
        if array[base[1]-1][base[0]-1] == 1 and array[base[1]-1][base[0]] == 1 and array[base[1]-1][base[0]+1] == 1:
            return 'T','3',3
    except:pass
    try:
        if array[base[1]-1][base[0]-1] == 1 and array[base[1]-1][base[0]] == 1 and array[base[1]-2][base[0]] == 1:
            return 'T','4',2
    except:pass                                                                                                                                                                                                         

    #Check if its L
    try:
        if array[base[1]][base[0]+1] == 1 and array[base[1]-1][base[0]] == 1 and array[base[1]-2][base[0]] == 1:
            return 'L', '1',2
    except:pass
    try:
        if array[base[1]][base[0]+1] == 1 and array[base[1]][base[0]+2] == 1 and array[base[1]-1][base[0]+2] == 1:
            return 'L', '2',3
    except:pass
    try:
        if array[base[1]-1][base[0]] == 1 and array[base[1]-2][base[0]] == 1 and array[base[1]-2][base[0]-1] == 1:
            return 'L', '3',2
    except:pass
    try:
        if array[base[1]-1][base[0]] == 1 and array[base[1]-1][base[0]+1] == 1 and array[base[1]-1][base[0]+2] == 1:
            return 'L', '4',3
    except:pass
    
    
    print('Erro : checkshape\n') 
    return 'error','0',0

def findNextPossibilities(game, piece, next_piece):
    total = []
    possibleDict = {'J': 26, 'S' : 13, 'Z' : 13, 'L' : 26, 'T':26, 'tower' : 13, 'square' : 7}
    shape = checkShape(findLow(piece), piece)
    gameArray = get2DArray(game)
    mapasPossiveis, lista, rots = findAllPossibilites(game, gameArray, piece, shape)

    #####

    mapasPossiveisArray = []
    for mapa in mapasPossiveis:
        arr = get2DArray(mapa)
        mapasPossiveisArray.append(arr)
    
    num_Holes = numHolesArray(mapasPossiveisArray)
    height, bumpiness,emptycol = mapHeightArray(mapasPossiveisArray)
    lines, maxH = completeLinesArray(mapasPossiveisArray)
    #print(maxH)

    custo = []
    for (item1, item2,item3, item4,item5, item6) in zip(height, num_Holes,lines,bumpiness, emptycol, maxH):
        custo.append(a*item1+b*item2-c*item3+d*item4+e*item5+f*item6)

    
    custo,mapasPossiveis, lista, rots, mapasPossiveisArray = zip(*sorted(zip(custo, mapasPossiveis, lista, rots, mapasPossiveisArray)))
    half = int(possibleDict[shape[0]]//2)
    mapasPossiveisArray = mapasPossiveisArray[ 0 : half ]
    mapasPossiveis = mapasPossiveis[ 0 : half ]
    lista = lista[ 0 : half ]
    rots = rots[ 0 : half ]

    ####
    new_shape = checkShape(findLow(next_piece), next_piece)
    for mapa, mapaArray in zip(mapasPossiveis,mapasPossiveisArray):
        novosMapas, aux, rotations = findAllPossibilites(mapa,mapaArray, next_piece, new_shape)
       
        total += novosMapas
        
    return total, lista, rots


def findAllPossibilites(game,gameArray, piece, tipo):
    num_rotation=4      
    if tipo[0] == 'tower' or tipo[0] == 'S' or tipo[0] == 'Z': num_rotation = 2 # TOWER S Z
    elif tipo[0] == 'square': num_rotation = 1  # SQUARE

    new_piece = piece
    allMaps = []
    allLowest = []
    allRotations = []

    for rotation in range(num_rotation):
        mapa_atual,lista = findPossibilities(game, gameArray, new_piece, tipo)
        allMaps += mapa_atual
        allLowest += lista
        rot = [tipo[1]] * (8-tipo[2]+1)
        allRotations += rot
        new_piece = rotatingpieces(new_piece, tipo)
        base = findLow(new_piece)
        tipo=checkShape(base, new_piece)

    return allMaps,allLowest, allRotations


def findPossibilities(game, gameArray, piece, type):
    listPossibilities = []
    listLowestPoints = []
    if(type[0] == 'error'):
        return []
    
    #Centra a peca
    pieceClone = [[piece[0][0] + 2, piece[0][1]], [piece[1][0] + 2, piece[1][1]], [piece[2][0] + 2, piece[2][1]], [piece[3][0] + 2, piece[3][1]]]
    left = findLeft(pieceClone)

    #Chega a peca o maximo a esquerda
    while(left[0] != 1):
        left = [left[0]-1,left[1]]
        #pieceClone = [[point[0] - 1, point[1]] for point in pieceClone]
        pieceClone = [[pieceClone[0][0]-1, pieceClone[0][1]],[pieceClone[1][0]-1, pieceClone[1][1]],[pieceClone[2][0]-1, pieceClone[2][1]],[pieceClone[3][0]-1, pieceClone[3][1]]]
    
    
    aux = pieceClone
    largura = type[2]
    for x in range(1, 8-largura+2,1):
        colidiu = 0
        pieceClone = aux
        pieceClone = [[pieceClone[0][0]+x-1, pieceClone[0][1]],[pieceClone[1][0]+x-1, pieceClone[1][1]],[pieceClone[2][0]+x-1, pieceClone[2][1]],[pieceClone[3][0]+x-1, pieceClone[3][1]]]
        for y in range(1,30,1):
            if(colidiu):
                break
            anterior = pieceClone
            #pieceClone = [[point[0], point[1]+1] for point in pieceClone]
            pieceClone = [[pieceClone[0][0], pieceClone[0][1]+1],[pieceClone[1][0], pieceClone[1][1]+1],[pieceClone[2][0], pieceClone[2][1]+1],[pieceClone[3][0], pieceClone[3][1]+1]]
    
            
            
            
            point1 = gameArray[pieceClone[0][1]-1][pieceClone[0][0]-1] == 1
            point2 = gameArray[pieceClone[1][1]-1][pieceClone[1][0]-1] == 1
            point3 = gameArray[pieceClone[2][1]-1][pieceClone[2][0]-1] == 1
            point4 = gameArray[pieceClone[3][1]-1][pieceClone[3][0]-1] == 1
            if point1 or point2 or point3 or point4:
            #if pieceClone[0] in game or pieceClone[1] in game or pieceClone[2] in game or pieceClone[3] in game:
                colidiu = 1
                listPossibilities.append(anterior)
                listLowestPoints.append(findLow(anterior))
                break
            value = findLow(pieceClone)
            if value[1] == 29 and colidiu !=1:
                colidiu = 1
                listPossibilities.append(pieceClone)
                listLowestPoints.append(value)
                break
    
    # retorna todos os possiveis mapas com a peca que esta a cair
    total = [x + game for x in listPossibilities]
    return total, listLowestPoints

def rotatingpieces(piece,shape):
    tipo = shape[0]
    #print(f"tipo de peca -> {tipo}, {shape[1]}")
    new_piece = piece
    x = piece[0][0]
    y = piece[0][1]
    if tipo == 'tower':
        if shape[1] == '1':
            new_piece = [[x+2, y-2], [x+2,y-1],[x+2,y],[x+2,y+1]]
    elif tipo == 'S':
        if shape[1] == '1':
            new_piece = [[x-1,y+1],[x,y+1],[x,y],[x+1,y]]
    elif tipo == 'Z':
        if shape[1] == '1':
            new_piece = [[x+2,y+1],[x+1,y+1],[x+1,y],[x,y]]
            
    elif tipo == 'T':
        if shape[1] == '1':
            new_piece = [[x,y],[x,y+1],[x+1,y+1],[x,y+2]]
        if shape[1] == '2':
            new_piece = [[x,y],[x-1,y],[x-1,y+1],[x-2,y]]
        if shape[1] == '3':
            new_piece = [[x,y],[x,y-1],[x-1,y-1],[x,y-2]]   
        if shape[1] == '4':
            new_piece = [[x,y],[x+1,y],[x+1,y-1],[x+2,y]]
           
    elif tipo == 'L':
        if shape[1] == '1':
            new_piece = [[x,y],[x+1,y],[x+2,y],[x,y+1]]
        elif shape[1] == '2':
            new_piece = [[x,y],[x,y+1],[x,y+2],[x+1,y+2]]
        elif shape[1] == '3':
            new_piece = [[x,y],[x+1,y],[x+2,y],[x+2,y-1]]
        elif shape[1] == '4':
            new_piece = [[x,y],[x+1,y],[x+1,y+1],[x+1,y+2]]

    elif tipo == 'J':
        if shape[1] == '1':
            new_piece = [[x,y],[x,y-1],[x+1,y],[x+2,y]]
        elif shape[1] == '2':
            new_piece = [[x,y],[x+1,y],[x,y+1],[x,y+2]]
        elif shape[1] == '3':
            new_piece = [[x,y],[x+1,y],[x+2,y],[x+2,y+1]]
        elif shape[1] == '4':
            new_piece = [[x,y],[x-1,y],[x,y-1],[x,y-2]]
    return new_piece

def printmatriz(array):
    for linha in array:
        print(linha)
        
def get2DArray(map):
    array = [[0,0,0,0,0,0,0,0] for i in range(29)]
    for block in map:
        array[block[1]-1][block[0]-1] = 1
    # printmatriz(array)
    return array




async def agent_loop(server_address="localhost:8000", agent_name="student"):
    async with websockets.connect(f"ws://{server_address}/player") as websocket:

        # Receive information about static game properties
        await websocket.send(json.dumps({"cmd": "join", "name": agent_name}))

        # Next 3 lines are not needed for AI agent
        # SCREEN = pygame.display.set_mode((299, 123))
        # SPRITES = pygame.image.load("data/pad.png").convert_alpha()
        # SCREEN.blit(SPRITES, (0, 0))

        checkaltura = { '320':5,'310':5,'300':6,'290' : 7, '280' : 8, '270' : 9, '140':11, '260' : 12, '250' : 13, '240' : 14 }
        primeiravez=1
        possibleDict = {'J': 26, 'S' : 13, 'Z' : 13, 'L' : 26, 'T':26, 'tower' : 13, 'square' : 7}
        estado_rotacao = '1'
        altura_change = 12
        e = 6000
        while True:
            try:
                state = json.loads(
                    await websocket.recv()
                )  # receive game update, this must be called timely or your game will get out of sync with the server
                key = ""
                game = state['game']
                piece = state['piece']
                nextpieces = state['next_pieces']
                next_piece1 = nextpieces[0]
                speed = state['game_speed']
                #print(score)
                e = 6000
                f = 1000
                if speed > 210 and speed < 280:
                    altura_change = 20
                elif speed > 280 and speed < 300:
                    altura_change = 10
                elif speed >=300 and speed <320:
                    altura_change = 9
                elif speed>=320 and speed < 340:
                    altura_change = 8
                if primeiravez:
                    if piece:
                        altura = getHeight(game)
                        gameArray = get2DArray(game)
                        base = findLow(piece)
                        shape = checkShape(base, piece)
                        #try
                        #start = time.time()
                        if speed > score_change:
                            if altura < altura_change:
                                mapasPossiveis, listLowestPoints, allRotations = findNextPossibilities(game, piece, next_piece1)
                            else:
                                #print("one piece only")
                                mapasPossiveis, listLowestPoints, allRotations= findAllPossibilites(game,gameArray, piece, shape)
                        else:
                            mapasPossiveis, listLowestPoints,  allRotations = findNextPossibilities(game, piece, next_piece1)

                        
                        mapasPossiveisArray = []
                        for mapa in mapasPossiveis:
                            arr = get2DArray(mapa)
                            mapasPossiveisArray.append(arr)
                        #end = time.time()
                        #print(",",end-start)
                        
                        #Custos
                        #print(len(listLowestPoints))

                        num_Holes = numHolesArray(mapasPossiveisArray)
                        height, bumpiness,emptycol = mapHeightArray(mapasPossiveisArray)
                        lines, maxH = completeLinesArray(mapasPossiveisArray)
                        custo = []
                        for (item1, item2,item3, item4,item5, item6) in zip(height, num_Holes,lines,bumpiness, emptycol,maxH):
                            custo.append(a*item1+b*item2-c*item3+d*item4+e*item5+f*item6)
                        
                        if custo:
                            minimo = min(custo)
                            calc = custo.index(minimo)
                            
                            if speed > score_change:
                                if altura <altura_change:
                                    
                                    minimo_index = calc//possibleDict[checkShape(findLow(next_piece1),next_piece1)[0]]
                                else:
                                    minimo_index = calc
                            else:
                                minimo_index = calc//possibleDict[checkShape(findLow(next_piece1),next_piece1)[0]]

                            posFinal = listLowestPoints[minimo_index]
                            estado_rotacao = allRotations[minimo_index]
                        
                        primeiravez=0

                if not piece:
                    primeiravez=1

                #Controlador da peca
                #print("hello")
                if piece:
                    lowestPoint = findLow(piece)
                    aux_piece = checkShape(lowestPoint,piece)                    
                    if estado_rotacao != aux_piece[1] and aux_piece[0] != 'square':
                        key = "w"
                    else:
                        if posFinal[0] < lowestPoint[0]:
                            key = "a"
                        elif posFinal[0] > lowestPoint[0]:
                            key = "d"
                        elif posFinal[0] == lowestPoint[0]:
                            key="s"
                    await websocket.send(
                        json.dumps({"cmd": "key", "key": key})
                    )
            except websockets.exceptions.ConnectionClosedOK:
                print("--Server has cleanly disconnected us")
                return
            # except:
            #     pass
            except Exception as e: print(e)
            # Next line is not needed for AI agent
            #pygame.display.flip()


# DO NOT CHANGE THE LINES BELLOW
# You can change the default values using the command line, example:
# $ NAME='arrumador' python3 client.py
loop = asyncio.get_event_loop()
SERVER = os.environ.get("SERVER", "localhost")
PORT = os.environ.get("PORT", "8000")
NAME = os.environ.get("NAME", getpass.getuser())
loop.run_until_complete(agent_loop(f"{SERVER}:{PORT}", NAME))
