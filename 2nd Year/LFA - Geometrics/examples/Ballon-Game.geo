display(900,900):"Ballon-Game";
figure snake(
    circle1 -> circle(26,26,25);
);
figure boneco(
    square1 -> square(400,400,20);
);
figure inimigo1(
    square2 -> square(200,16,15);
);
figure inimigo2(
    square3 -> square(400,16,15);
);
figure inimigo3(
    square4 -> square(600,16,15);
);
figure inimigo4(
    square5 -> square(800,16,15);
);
inimigo1.square2/color -> WHITE;
inimigo1.square2/filled -> True;
inimigo2.square3/color -> BLUE;
inimigo2.square3/filled -> True;
inimigo3.square4/color -> GRAY;
inimigo3.square4/filled -> True;
inimigo3.square4/color -> GREEN;
inimigo3.square4/filled -> True;
ORANGE -> (255,165,0);
inimigo4.square5/color -> ORANGE;
inimigo4.square5/filled -> True;
boneco.square1/hidden -> False;
boneco.square1/color -> YELLOW;
boneco.square1/thickness -> 6;
snake.circle1/color -> RED;
snake.circle1/filled -> True; 
inimigo4.square5/hidden -> True;
tocou1 -> False;
tocou2 -> False;
tocou3 -> False;
tocou4 -> False;
speed -> 4;
PURPLE -> (127,0,255);
left -> 0;
right -> 1;
down -> 0;
up -> 0;
counter -> 0;
bonecoexists -> False;
run -> True;
forever<<
    drawString(450,750,100):counter -> YELLOW; 
    if(run = False)<<
        drawString(450,750,100):counter -> YELLOW; 
        if((readTimer % 2) = 0)<<
            string -> "Fim do jogo";
            drawString(450,450,100):string -> PURPLE;
            timer -> 0;
        >>else<<
            drawString(450,750,100):counter -> YELLOW;
        >>;
    >>else<<
        inimigo1:translate(0,2);
        inimigo2:translate(0,4);
        inimigo3:translate(0,3);
        inimigo4:translate(0,1);

        if( inimigo1:collidesEdge = True)<<
            rand1 -> rand(30,850);
            inimigo1:translate(inimigo1.square2/x1 * (-1) + rand1,-850);
        >>;
        if( inimigo2:collidesEdge = True)<<
            rand1 -> rand(30,850);
            inimigo2:translate(inimigo2.square3/x1 * (-1) + rand1,-850);
        >>;
        if( inimigo3:collidesEdge = True)<<
            rand1 -> rand(30,850);
            inimigo3:translate(inimigo3.square4/x1 * (-1) + rand1,-850);
        >>;
        if( inimigo4:collidesEdge = True)<<
            rand1 -> rand(30,850);
            inimigo4:translate(inimigo4.square5/x1 * (-1) + rand1,-850);
        >>;

        xi -> (boneco.square1/x3 - boneco.square1/x1) / 2 + boneco.square1/x1;
        yi -> (boneco.square1/y3 - boneco.square1/y1) / 2 + boneco.square1/y1;

        comeu -> boneco:collides:snake;
        tocou1 -> inimigo1:collides:snake;
        tocou2 -> inimigo2:collides:snake;
        tocou3 -> inimigo3:collides:snake;
        tocou4 -> inimigo4:collides:snake;

        if(tocou1 or tocou2 or tocou3 or tocou4)<<
            run->False;
        >>;
        boneco:rotate(speed, xi,yi);
        if(comeu = True)<<
            player_r -> rand(0,255);
            player_g -> rand(0,255);
            player_b -> rand(0,255);
            cor_nova -> (player_r, player_g, player_b);
            boneco.square1/color -> cor_nova;
            xc -> rand(100,800);
            yc -> rand(100,800);
            boneco:translate(boneco.square1/x1 * -1,boneco.square1/y1 * -1);
            boneco:translate(xc,yc);
            counter -> counter + 1;
            snake.circle1/r -> snake.circle1/r +2; 
        >>;
        if(snake:collidesEdge = False)<<
            if(left =  1)<<
                snake:translate(speed * -1,0);
            >>;
            if(right =  1)<<
                snake:translate(speed,0);
            >>;
            if(down =  1)<<
                snake:translate(0,speed);
            >>;
            if(up =  1)<<
                snake:translate(0,speed * -1);    
            >>;
            input:UP<<
                left -> 0;
                right -> 0;
                down -> 0;
                up -> 1;
            >>;
            input:down<<
                left -> 0;
                right -> 0;
                down -> 1;
                up -> 0;
            >>;
            input:LEFT<<
                left -> 1;
                right -> 0;
                down -> 0;
                up -> 0;
            >>;
            input:RIGHT<<
                left -> 0;
                right -> 1;
                down -> 0;
                up -> 0;
            >>;
            input:ESCAPE<<
                run -> False;
            >>;
        >>else<<
            run -> False;
        >>;
        draw:boneco;
        draw:inimigo1;
        draw:inimigo2;
        draw:inimigo3;
        draw:inimigo4;
        draw:snake;
    >>;
>>;