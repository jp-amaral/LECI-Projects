display(900,900):"TargetShotting-Game";
figure rotater(
    circulo1 -> circle(445,900,100);
);

figure arrow(
    tronco -> rectangle(445,775,7,120);
);

figure shootingball(
    ball -> circle(445,874,25);
);

figure alvo(
    uptriangle -> triangle(90,110,145,110,120,130);
);

figure esquerda(
          rectangulo1 -> rectangle(5,5,1,895);
);

figure direita(
          right -> rectangle(895,5,1,895);
);

figure topo(
          top -> rectangle(5,5,889,1);
);   

rotater.circulo1/color -> RED;
rotater.circulo1/filled->True;
arrow.tronco/color -> GRAY;
arrow.tronco/filled -> True;
shootingball.ball/color ->BLUE;
shootingball.ball/filled -> True;
shootingball.ball/hidden -> True;

alvo.uptriangle/color -> YELLOW;
alvo.uptriangle/filled -> True;

esquerda.rectangulo1/color->BLACK;
direita.right/color->BLACK;
topo.top/color->BLACK;

speedx -> 4;
speedy -> 4;
speed->1;
left -> True;
stop -> False;
Score -> 0;
timer -> 0;
forever<<
    input:r<<
        stop -> False;
        arrow.tronco/hidden -> False;
        shootingball:translate(-1 * shootingball.ball/x + 445,-1 * shootingball.ball/y + 874);
        shootingball.ball/hidden -> False;
        timer -> 0;
    >>;
    input:space<<stop->True;>>;
    input:escape<<exit;>>;
    drawString(50,850,40):Score -> ORANGE;
    alvo:rotate(speed,alvo.uptriangle/x1,alvo.uptriangle/y1);
    //BallMovement
    tocaDireita -> shootingball:collides:direita;
    tocaEsquerda -> shootingball:collides:esquerda;
    tocaTopo -> shootingball:collides:topo;
    if(arrow:collidesEdge = True)<<
        if(left)<<
            arrow:rotate(1,444,895);
            left -> False;
         >>else<<
            arrow:rotate(-1,444,895);
            left -> True;
         >>;
    >>else<<
        if(stop = False)<<    
            if(left)<<
                arrow:rotate(speed * -1,448,890);
            >>else<<
                arrow:rotate(speed,448,890);
            >>;
        >>else<<
            //arrow.tronco/hidden -> True;
            shootingball.ball/hidden -> False;
            if(timer = 0)<<
                speedx -> (450-arrow.tronco/x1) / -25;
                speedy -> (900-arrow.tronco/y1) / -25;
                shootingball:translate(speedx,speedy);
                timer -> 1;
            >>else<<
                if(tocaEsquerda or tocaDireita)<<
                    speedx -> speedx * -1;
                >>;
                shootingball:translate(speedx,speedy);
            >>;
        >>;
    >>;    
    if(alvo:collides:shootingball)<<
        alvo.uptriangle/hidden -> True;
        Score -> Score + 1;
        randx -> rand(50,850);
        randy -> rand(50,600);
        alvo:translate(alvo.uptriangle/x1 * -1 + randx, alvo.uptriangle/y1 * -1 + randy);
        alvo.uptriangle/hidden -> False;
    >>;

    if(tocaTopo)<<
        stop -> False;
        arrow.tronco/hidden -> False;
        shootingball:translate(-1 * shootingball.ball/x + 445,-1 * shootingball.ball/y + 874);
        shootingball.ball/hidden -> True;
        timer -> 0;
    >>;
    draw:rotater;
    draw:arrow;
    draw:alvo;
    draw:esquerda;
    draw:direita;
    draw:topo;
    draw:shootingball;
>>;