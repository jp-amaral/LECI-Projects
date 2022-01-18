# import pygame module in this program
import pygame

# activate the pygame library
# initiate pygame and give permission
# to use pygame's functionality.
pygame.init()

# define the RGB value for white,
# green, blue colour .
black = (0, 0, 0)
green = (0, 255, 0)
blue = (0, 0, 128)

# assigning values to X and Y variable
X = 400
Y = 400

# create the display surface object
# of specific dimension..e(X, Y).
display_surface = pygame.display.set_mode((X, Y))

# set the pygame window name
pygame.display.set_caption('Show Text')

# create a font object.
# 1st parameter is the font file
# which is present in pygame.
# 2nd parameter is size of the font

font = pygame.font.Font('freesansbold.ttf', 32)
text = font.render("Bruno Lemos", True, (255,255,255), black)
textRect = text.get_rect()
textRect.center = (X // 2, Y // 2)
# infinite loop
while True:
	display_surface.fill(black)
	display_surface.blit(text, textRect)

	for event in pygame.event.get():
		if event.type == pygame.QUIT:
			pygame.quit()
			quit()
	text = font.render("asdjlnajkdnjka", True, (255,255,255), black)
	
	pygame.display.update()
