display(1200,800):"DVDPlayer";

importFigures;

figure extremos(
          esquerda;
          direita;
          base;
          topo;
);
speedx -> 4;
speedy -> 4;
forever<<
          input:escape<<exit;>>;
          color_r -> rand(10,255);
          color_g -> rand(10,255);
          color_b -> rand(10,255);
          tocaBase -> bola:collides:base;
          tocaDireita -> bola:collides:direita;
          tocaEsquerda -> bola:collides:esquerda;
          tocaTopo -> bola:collides:topo;
          if(readTimer < 1)<<
                    bola:translate(speedx,speedy);
          >>else<<
                    if(tocaBase = True)<<
                              cor -> (color_r,color_g,color_b);
                              bola.ball/color -> cor;
                              speedy -> speedy * -1;
                    >>;
                    if(tocaDireita = True)<<
                              cor -> (color_r,color_g,color_b);
                              bola.ball/color -> cor;
                              speedx -> speedx * -1;
                    >>;
                    if(tocaEsquerda = True)<<
                              cor -> (color_r,color_g,color_b);
                              bola.ball/color -> cor;
                              speedx -> speedx * -1;
                    >>;
                    if(tocaTopo = True)<<
                              cor -> (color_r,color_g,color_b);
                              bola.ball/color -> cor;
                              speedy -> speedy* -1;
                    >>;
                    bola:translate(speedx, speedy);
          >>;
          draw:extremos;
          draw:bola;
>>;