display(1200,800):"BrickBreaker";
importFigures;

cor_player -> (255,100,0);
player.plataforma/color -> cor_player; 


figure obstaculos(
          inimigo1;
          inimigo2;
          inimigo3;
          inimigo4;
          inimigo5;
          inimigo6;
          inimigo7;
          inimigo8;
          inimigo9;
          inimigo10;
          inimigo11;
          inimigo12;
          inimigo13;
          inimigo14;
          inimigo15;
          inimigo16;
          inimigo17;
          inimigo18;
          inimigo19;
          inimigo20;
          inimigo21;
);

inimigo1.evil1/filled -> True;
inimigo2.evil2/filled -> True;
inimigo3.evil3/filled -> True;
inimigo4.evil4/filled -> True;
inimigo5.evil5/filled -> True;
inimigo6.evil6/filled -> True;
inimigo7.evil7/filled -> True;
inimigo8.evil8/filled -> True;
inimigo9.evil9/filled -> True;
inimigo10.evil10/filled -> True;
inimigo11.evil11/filled -> True;
inimigo12.evil12/filled -> True;
inimigo13.evil13/filled -> True;
inimigo14.evil14/filled -> True;
inimigo15.evil15/filled -> True;
inimigo16.evil16/filled -> True;
inimigo17.evil17/filled -> True;
inimigo18.evil18/filled -> True;
inimigo19.evil19/filled -> True;
inimigo20.evil20/filled -> True;
inimigo21.evil21/filled -> True;

topo.top/color -> BLACK;
base.bottom/color -> BLACK;
direita.right/color -> BLACK;
esquerda.left/color -> BLACK;

figure extremos(
          esquerda;
          direita;
          base;
          topo;
);

speedx -> 4;
speedy -> 4;
playerSpeed -> 4;
terminou -> False;
toques -> 21;

forever<<
          tocaBase -> bola:collides:base;
          tocaDireita -> bola:collides:direita;
          tocaEsquerda -> bola:collides:esquerda;
          tocaTopo -> bola:collides:topo;
          tocaPlat -> bola:collides:player;
          player:translate(playerSpeed, 0);
          toca14 -> bola:collides:inimigo14;
          toca15 -> bola:collides:inimigo15;
          toca16 -> bola:collides:inimigo16;
          toca17 -> bola:collides:inimigo17;
          toca18 -> bola:collides:inimigo18;
          toca19 -> bola:collides:inimigo19;
          toca20 -> bola:collides:inimigo20;
          toca21 -> bola:collides:inimigo21;
          toca6 -> bola:collides:inimigo6;
          toca7 -> bola:collides:inimigo7;
          toca8 -> bola:collides:inimigo8;
          toca9 -> bola:collides:inimigo9;
          toca10 -> bola:collides:inimigo10;
          toca11 -> bola:collides:inimigo11;
          toca12 -> bola:collides:inimigo12;
          toca13 -> bola:collides:inimigo13;
          toca5 -> bola:collides:inimigo5;
          toca4 -> bola:collides:inimigo4;
          toca3 -> bola:collides:inimigo3;
          toca2 -> bola:collides:inimigo2;
          toca1 -> bola:collides:inimigo1;

          if((player:collidesEdge = True))<<
                    player:translate(playerSpeed * (-2) , 0);
                    playerSpeed -> playerSpeed * -1;
          >>;
          input:left<<
                    playerSpeed -> -4;
          >>;
          input:right<<
                    playerSpeed -> 4;
          >>;
          //BallMovement
          if(readTimer < 1)<<
                    bola:translate(speedx,speedy);
          >>else<<
                    if(tocaBase = True)<<
                              exit;
                    >>;
                    if(tocaPlat = True)<<
                              speedy -> speedy * -1;
                              speedx -> rand(1,5);
                              direction -> rand(1,2);
                              if(direction = 2)<< speedx -> speedx * -1;>>;
                    >>;
                    if(tocaDireita = True)<<
                              speedx -> speedx * -1;
                    >>;
                    if(tocaEsquerda = True)<<
                              speedx -> speedx * -1;
                    >>;
                    if(tocaTopo = True)<<
                              speedy -> speedy* -1;
                    >>;
                    if(toca14 = True)<<
                            toques -> toques - 1;
                            speedy -> speedy * -1;
                            inimigo14.evil14/hidden -> True;
                            player.plataforma/x2 -> player.plataforma/x2 - 4;
                            player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca15 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo15.evil15/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca16 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo16.evil16/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca17 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo17.evil17/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca18 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo18.evil18/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca19 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo19.evil19/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca20 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo20.evil20/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca21 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo21.evil21/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca13 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo13.evil13/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca12 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo12.evil12/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca11 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo11.evil11/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca10 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo10.evil10/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca9 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo9.evil9/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca8 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo8.evil8/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca6 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo6.evil6/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca7 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo7.evil7/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca5 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo5.evil5/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca4 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo4.evil4/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca3 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo3.evil3/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca2 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo2.evil2/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;
                    if(toca1 = True)<<
                              toques -> toques - 1;
                              speedy -> speedy * -1;
                              inimigo1.evil1/hidden -> True;
                              player.plataforma/x2 -> player.plataforma/x2 - 4;
                              player.plataforma/x3 -> player.plataforma/x3 - 4;
                    >>;

                    if(toques = 0)<<
                        terminou -> True;
                    >>;


                    bola:translate(speedx, speedy);
          >>;
        if(terminou = False)<<
            draw:obstaculos;
            draw:extremos;
            draw:bola;
            draw:player;
        >>else<<
            vitoria -> "Vitoria";
            drawString(600,400,70):vitoria -> ORANGE;
        >>;
            
>>;