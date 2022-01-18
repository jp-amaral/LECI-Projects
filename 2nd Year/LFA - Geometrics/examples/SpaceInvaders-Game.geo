display(900,900):"SpaceShip-Game";

PURPLE_claro -> (153,51,153);
PURPLE_escuro -> (75,0,130);

importFigures;

score -> 0;
speed_inimigo1 -> 2;
speed_inimigo2 -> 2;
speed -> 3;
vida -> 3;

run -> True;
atirou -> False;

status_inimigo1 -> False;
status_inimigo2 -> False;
timer1 -> 0;
timer2 -> 0;

forever<<
    if(run = True)<<
        drawString(30,30,30):score -> ORANGE;
        nave:translate(speed,0);
        if(nave:collidesEdge = True)<<
            nave:translate(speed * (-2),0);
            speed -> speed * -1;
        >>;
        if(status_inimigo1)<<
            inimigo1.circle2/color -> ORANGE;
            timer1 -> timer1 + 1;
            if(timer1 = 1)<<score -> score + 1;>>;
            if(timer1 > 20)<<
                inimigo1.circle2/color -> YELLOW;
                status_inimigo1 -> False;
                timer1 -> 0;
                randi -> rand(40,860);
                inimigo1.circle2/r -> 25;
                inimigo1:translate(inimigo1.circle2/x * -1 + randi,inimigo1.circle2/y * -1 + 30 );
            >>;
            inimigo1.circle2/r -> inimigo1.circle2/r - 1 ;
        >>;
        if(status_inimigo2)<<
            inimigo2.circle3/color -> ORANGE;
            timer2 -> timer2 + 1;
            if(timer2 = 1)<<score -> score + 1;>>;
            if(timer2 > 20)<<
                inimigo2.circle3/color -> YELLOW;
                status_inimigo2 -> False;
                timer2 -> 0;
                randi -> rand(40,860);
                inimigo2.circle3/r -> 25;
                inimigo2:translate(inimigo2.circle3/x * -1 + randi,inimigo2.circle3/y * -1 + 30 );
            >>;
            inimigo2.circle3/r -> inimigo2.circle3/r - 1;
        >>;
        if(atirou = True)<<
            if(balas:collides:inimigo1)<<
                status_inimigo1 -> True;
            >>;
            if(balas:collides:inimigo2)<<
                status_inimigo2 -> True;
            >>;
            balas.baluda/hidden-> False;
            balas:translate(0,-1*15);
        >>else<<
            v -> balas.baluda/x1 * (-1);
            d -> nave.teto/x2;
            balas:translate(v+d+9,0);
        >>;

        if(balas:collidesEdge = True)<<
            atirou -> False;
            balas:translate(0,800);
            balas.baluda/hidden-> True;
        >>;
        input:left<<speed ->-3;>>;
        input:right<<speed -> 3;>>;
        input:space<<atirou -> True;>>;
        input:escape<<
            run -> False;
        >>;
        //inimigos
        if(inimigo1:collidesEdge = False)<<
            inimigo1:translate(0,speed_inimigo1);
        >>else<<
            vida -> vida - 1;
            randi -> rand(40,860);
            inimigo1:translate(inimigo1.circle2/x * -1 + randi,-850);
        >>;
        if(inimigo2:collidesEdge = False)<<
            inimigo2:translate(0,speed_inimigo2);
        >>else<<
            vida -> vida - 1;
            randi -> rand(40,860);
            inimigo2:translate(inimigo2.circle3/x * -1 + randi,-850);
        >>;
        if(vida = 1)<<
            draw:vida1;
        >>;
        if(vida = 2)<<
            draw:vida1;
            draw:vida2;
        >>;
        if(vida = 3)<<
            draw:vida1;
            draw:vida2;
            draw:vida3;
        >>;
        if(vida <= 0)<<
            run -> False;
        >>;
        draw:inimigo1;
        draw:inimigo2;
        draw:nave;
        draw:balas;
        draw:tabela;
    >>else<<
        Stringout -> "Fim do jogo -> {score} pontos";
        drawString(450,450,50):Stringout -> ORANGE;
        String2 -> "Press 'A' to play again";
        drawString(450,750,20):String2 -> YELLOW; 
        
        if((readTimer % 2) = 0)<<
            string -> "Fim do jogo";
            drawString(450,450,40):Stringout -> RED;
            timer -> 0;
        >>else<<
            drawString(450,600,40):String2 -> YELLOW;
        >>;
        input:a<<
            run -> True;
            vida -> 3;
            score -> 0;
            randi -> rand(30,800);
            inimigo2:translate(inimigo2.circle3/x * -1 + randi,inimigo2.circle3/y * -1 + 30 );
            randi -> rand(30,800);
            inimigo1:translate(inimigo1.circle2/x * -1 + randi,inimigo1.circle2/y * -1 + 30 );
        >>;
    >>;
>>;