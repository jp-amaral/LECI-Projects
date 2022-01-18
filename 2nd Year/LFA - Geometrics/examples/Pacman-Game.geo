display(800,900):"Pacman-Game";
PINK -> (255,105,180);
importFigures;
x1 -> player.boca/x1;
y1 -> player.boca/y1;

x2 -> player.boca/x2;
y2 -> player.boca/y2;

x3 -> player.boca/x3;
y3 -> player.boca/y3;

figure inimigos(
        inimigo1;
        inimigo2;
        inimigo3;
        inimigo4;
);

figure moedas(
        moeda1;
        moeda2;
        moeda3;
        moeda4;
        moeda5;
        moeda6;
        moeda7;
        moeda8;
        moeda9;
        moeda10;
        moeda11;
        moeda12;
        moeda13;
        moeda14;
        moeda15;
        moeda16;
        moeda17;
        moeda18;
        moeda19;
        moeda20;
        moeda21;
        moeda22;
        moeda23;
        moeda24;
        moeda25;
        moeda26;
        moeda27;
        moeda28;
        moeda29;
        moeda30;
        moeda31;
        moeda32;
        moeda33;
        moeda34;
        moeda35;
        moeda36;
        moeda37;
        moeda38;
        moeda39;
        moeda40;
        moeda41;
        moeda42;
        moeda43;
        moeda44;
        moeda45;
        moeda46;
        moeda47;
        moeda48;
        moeda49;
        moeda50;
        moeda51;
        moeda52;
        moeda53;
        moeda54;
        moeda55;
        moeda56;
        moeda57;
        moeda58;
        moeda59;
        moeda60;
        moeda61;
        moeda62;
        moeda63;
        moeda64;
        moeda65;
        moeda66;
        moeda67;
        moeda68;
        moeda69;
        moeda70;
        moeda71;
        moeda72;
        moeda73;
        moeda74;
        moeda75;
        moeda76;
        moeda77;
        moeda78;
        moeda79;
        moeda80;
        moeda81;
        moeda82;
        moeda83;
        moeda84;
        moeda85;
        moeda86;
        moeda87;
        moeda88;
        moeda89;
);

speed_x -> 2;
speed_y -> 0;
lastInput -> 3;

timer1 -> 0;
timer2 -> 0;
timer3 -> 0;
timer4 -> 0;
player:translate(70,0);

win -> False;
run -> True;
moeda -> 89;
forever<<

        //PLAYER CONTROLLER
        if(run)<<
                self_x -> player.corpo/x;
                self_y -> player.corpo/y;
                input:left<<
                        speed_x -> -2;
                        speed_y -> 0;
                        if(lastInput = 2)<<player:rotate(270, self_x, self_y);>>;
                        if(lastInput = 3)<<player:rotate(180, self_x, self_y);>>;
                        if(lastInput = 4)<<player:rotate(90,self_x, self_y);>>;
                        lastInput -> 1;
                >>;
                input:right<<
                        speed_x -> 2;
                        speed_y -> 0;
                        if(lastInput = 1)<<player:rotate(180, self_x, self_y);>>;
                        if(lastInput = 2)<<player:rotate(90, self_x, self_y);>>;
                        if(lastInput = 4)<<player:rotate(270,self_x, self_y);>>;
                        lastInput -> 3;
                >>;
                input:up<<   
                        speed_y -> -2;
                        speed_x -> 0;
                        if(lastInput = 1)<<player:rotate(90, self_x, self_y);>>;
                        if(lastInput = 3)<<player:rotate(270, self_x, self_y);>>;
                        if(lastInput = 4)<<player:rotate(180,self_x, self_y);>>;
                        lastInput -> 2;
                >>;
                input:down<<
                        speed_y -> 2;
                        speed_x -> 0;
                        if(lastInput = 1)<<player:rotate(270, self_x, self_y);>>;
                        if(lastInput = 3)<<player:rotate(90, self_x, self_y);>>;
                        if(lastInput = 2)<<player:rotate(180,self_x, self_y);>>;
                        lastInput -> 4;
                >>;
                if(player:collides:mapa = False)<<
                        player:translate(speed_x, speed_y);
                >>;

                //Trajetoria azul
                if(timer1<205)<<
                        inimigo1:translate(0,2);
                >>;
                if((timer1>=205) and (timer1 < 490))<<
                        inimigo1:translate(2,0);
                >>;
                if((timer1>=490) and (timer1 < 622))<<
                        inimigo1:translate(0,-2);
                >>;
                if((timer1>=622) and (timer1 < 757))<<
                        inimigo1:translate(-2,0);
                >>;
                if((timer1>=757) and (timer1 < 830))<<
                        inimigo1:translate(0,-2);
                >>;
                if((timer1>=830) and (timer1 < 980))<<
                        inimigo1:translate(-2,0);
                >>;
                if(timer1=980)<<timer1 -> -1;>>;

                //Trajetoria vermelho

                if(timer2<205)<<
                        inimigo2:translate(0,2);
                >>;
                if((timer2>=205) and (timer2 < 490))<<
                        inimigo2:translate(-2,0);
                >>;
                if((timer2>=490) and (timer2 < 622))<<
                        inimigo2:translate(0,-2);
                >>;
                if((timer2>=622) and (timer2 < 757))<<
                        inimigo2:translate(2,0);
                >>;
                if((timer2>=757) and (timer2 < 830))<<
                        inimigo2:translate(0,-2);
                >>;
                if((timer2>=830) and (timer2 < 980))<<
                        inimigo2:translate(2,0);
                >>;
                if(timer2=980)<<timer2 -> -1;>>;

                //Trajetoria Laranja
                if(timer3 < 100)<<
                        inimigo3:translate(-2,0);
                >>;
                if((timer3>=100) and (timer3 < 230))<<
                        inimigo3:translate(0,-2);
                >>;
                if((timer3>=230) and (timer3 < 330))<<
                        inimigo3:translate(2,0);
                >>;
                if((timer3>=330) and (timer3 < 580))<<
                        inimigo3:translate(-2,0);
                >>;
                if((timer3>=580) and (timer3 < 710))<<
                        inimigo3:translate(0,2);
                >>;
                if((timer3>=710) and (timer3 < 960))<<
                        inimigo3:translate(2,0);
                >>;
                if(timer3 = 960)<<timer3->-1;>>;
                
                
                //Trajetoria Rosa

                if(timer4 < 100)<<
                        inimigo4:translate(2,0);
                >>;
                if((timer4>=100) and (timer4 < 230))<<
                        inimigo4:translate(0,-2);
                >>;
                if((timer4>=230) and (timer4 < 330))<<
                        inimigo4:translate(-2,0);
                >>;
                if((timer4>=330) and (timer4 < 580))<<
                        inimigo4:translate(2,0);
                >>;
                if((timer4>=580) and (timer4 < 710))<<
                        inimigo4:translate(0,2);
                >>;
                if((timer4>=710) and (timer4 < 960))<<
                        inimigo4:translate(-2,0);
                >>;
                if(timer4 = 960)<<timer4 -> -1;>>;
                
                if(player:collides:inimigos)<<
                        run -> False;
                        v1 -> inimigo1.corpo1/x;
                        v2 -> inimigo1.corpo1/y;
                        inimigo1:translate(v1 * -1 +50,v2 * -1 +50);

                        v1 -> inimigo2.corpo_1/x;
                        v2 -> inimigo2.corpo_1/y;
                        inimigo2:translate(v1 * -1 +50,v2 * -1 +850);
                        
                        v1 -> inimigo3.corpo__1/x;
                        v2 -> inimigo3.corpo__1/y;
                        inimigo3:translate(v1 * -1 +750,v2 * -1 +50);
                        
                        v1 -> inimigo4.corpo___1/x;
                        v2 -> inimigo4.corpo___1/y;
                        inimigo4:translate(v1 * -1 +750,v2 * -1 +850);

                        v1 -> player.corpo/x;
                        v2 -> player.corpo/y;
                        player:translate(v1 * -1 +400,v2 * -1 +550);

                        
                >>;
                timer4 -> timer4 + 1;
                timer3 -> timer3 + 1;
                timer2 -> timer2 + 1;
                timer1 -> timer1 + 1;
                if(player:collides:moeda1)<<moeda1.c1/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda2)<<moeda2.c2/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda3)<<moeda3.c3/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda4)<<moeda4.c4/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda5)<<moeda5.c5/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda6)<<moeda6.c6/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda7)<<moeda7.c7/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda8)<<moeda8.c8/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda9)<<moeda9.c9/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda10)<<moeda10.c10/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda11)<<moeda11.c11/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda12)<<moeda12.c12/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda13)<<moeda13.c13/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda14)<<moeda14.c14/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda15)<<moeda15.c15/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda16)<<moeda16.c16/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda17)<<moeda17.c17/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda18)<<moeda18.c18/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda19)<<moeda19.c19/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda20)<<moeda20.c20/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda21)<<moeda21.c21/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda22)<<moeda22.c22/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda23)<<moeda23.c23/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda24)<<moeda24.c24/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda25)<<moeda25.c25/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda26)<<moeda26.c26/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda27)<<moeda27.c27/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda28)<<moeda28.c28/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda29)<<moeda29.c29/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda30)<<moeda30.c30/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda31)<<moeda31.c31/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda32)<<moeda32.c32/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda33)<<moeda33.c33/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda34)<<moeda34.c34/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda35)<<moeda35.c35/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda36)<<moeda36.c36/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda37)<<moeda37.c37/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda38)<<moeda38.c38/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda39)<<moeda39.c39/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda40)<<moeda40.c40/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda41)<<moeda41.c41/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda42)<<moeda42.c42/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda43)<<moeda43.c43/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda44)<<moeda44.c44/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda45)<<moeda45.c45/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda46)<<moeda46.c46/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda47)<<moeda47.c47/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda48)<<moeda48.c48/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda49)<<moeda49.c49/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda50)<<moeda50.c50/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda51)<<moeda51.c51/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda52)<<moeda52.c52/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda53)<<moeda53.c53/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda54)<<moeda54.c54/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda55)<<moeda55.c55/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda56)<<moeda56.c56/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda57)<<moeda57.c57/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda58)<<moeda58.c58/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda59)<<moeda59.c59/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda60)<<moeda60.c60/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda61)<<moeda61.c61/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda62)<<moeda62.c62/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda63)<<moeda63.c63/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda64)<<moeda64.c64/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda65)<<moeda65.c65/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda66)<<moeda66.c66/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda67)<<moeda67.c67/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda68)<<moeda68.c68/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda69)<<moeda69.c69/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda70)<<moeda70.c70/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda71)<<moeda71.c71/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda72)<<moeda72.c72/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda73)<<moeda73.c73/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda74)<<moeda74.c74/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda75)<<moeda75.c75/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda76)<<moeda76.c76/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda77)<<moeda77.c77/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda78)<<moeda78.c78/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda79)<<moeda79.c79/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda80)<<moeda80.c80/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda81)<<moeda81.c81/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda82)<<moeda82.c82/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda83)<<moeda83.c83/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda84)<<moeda84.c84/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda85)<<moeda85.c85/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda86)<<moeda86.c86/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda87)<<moeda87.c87/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda88)<<moeda88.c88/hidden->True;moeda->moeda - 1;>>;
                if(player:collides:moeda89)<<moeda89.c89/hidden->True;moeda->moeda - 1;>>;

                if(moeda = 0)<<
                        run -> False;
                        win -> True;
                        v1 -> inimigo1.corpo1/x;
                        v2 -> inimigo1.corpo1/y;
                        inimigo1:translate(v1 * -1 +50,v2 * -1 +50);

                        v1 -> inimigo2.corpo_1/x;
                        v2 -> inimigo2.corpo_1/y;
                        inimigo2:translate(v1 * -1 +50,v2 * -1 +850);
                        
                        v1 -> inimigo3.corpo__1/x;
                        v2 -> inimigo3.corpo__1/y;
                        inimigo3:translate(v1 * -1 +750,v2 * -1 +50);
                        
                        v1 -> inimigo4.corpo___1/x;
                        v2 -> inimigo4.corpo___1/y;
                        inimigo4:translate(v1 * -1 +750,v2 * -1 +850);

                        v1 -> player.corpo/x;
                        v2 -> player.corpo/y;
                        player:translate(v1 * -1 +400,v2 * -1 +550);
                >>;
                draw:mapa;
                draw:moedas;
                time -> readTimer;
                input:r<<
                        v1 -> inimigo1.corpo1/x;
                        v2 -> inimigo1.corpo1/y;
                        inimigo1:translate(v1 * -1 +50,v2 * -1 +50);

                        v1 -> inimigo2.corpo_1/x;
                        v2 -> inimigo2.corpo_1/y;
                        inimigo2:translate(v1 * -1 +750,v2 * -1 +50);
                        
                        v1 -> inimigo3.corpo__1/x;
                        v2 -> inimigo3.corpo__1/y;
                        inimigo3:translate(v1 * -1 +750,v2 * -1 +850);
                        
                        v1 -> inimigo4.corpo___1/x;
                        v2 -> inimigo4.corpo___1/y;
                        inimigo4:translate(v1 * -1 +50,v2 * -1 +850);

                        v1 -> player.corpo/x;
                        v2 -> player.corpo/y;
                        player:translate(v1 * -1 +40,v2 * -1 +50);

                        player.boca/x1 -> x1;
                        player.boca/y1 -> y1;
                        player.boca/x2 -> x2;
                        player.boca/y2 -> y2;
                        player.boca/x3 -> x3;
                        player.boca/y3 -> y3;
                        player:translate(70,0);
                        
                        timer1->0;
                        timer2->0;
                        timer3->0;
                        timer4->0;
                        resetTimer;
                        moeda -> 89;

                        speed_x -> 2;
                        speed_y -> 0;

                        moeda1.c1/hidden->False;
                        moeda2.c2/hidden->False;
                        moeda3.c3/hidden->False;
                        moeda4.c4/hidden->False;
                        moeda5.c5/hidden->False;
                        moeda6.c6/hidden->False;
                        moeda7.c7/hidden->False;
                        moeda8.c8/hidden->False;
                        moeda9.c9/hidden->False;
                        moeda10.c10/hidden->False;
                        moeda11.c11/hidden->False;
                        moeda12.c12/hidden->False;
                        moeda13.c13/hidden->False;
                        moeda14.c14/hidden->False;
                        moeda15.c15/hidden->False;
                        moeda16.c16/hidden->False;
                        moeda17.c17/hidden->False;
                        moeda18.c18/hidden->False;
                        moeda19.c19/hidden->False;
                        moeda20.c20/hidden->False;
                        moeda21.c21/hidden->False;
                        moeda22.c22/hidden->False;
                        moeda23.c23/hidden->False;
                        moeda24.c24/hidden->False;
                        moeda25.c25/hidden->False;
                        moeda26.c26/hidden->False;
                        moeda27.c27/hidden->False;
                        moeda28.c28/hidden->False;
                        moeda29.c29/hidden->False;
                        moeda30.c30/hidden->False;
                        moeda31.c31/hidden->False;
                        moeda32.c32/hidden->False;
                        moeda33.c33/hidden->False;
                        moeda34.c34/hidden->False;
                        moeda35.c35/hidden->False;
                        moeda36.c36/hidden->False;
                        moeda37.c37/hidden->False;
                        moeda38.c38/hidden->False;
                        moeda39.c39/hidden->False;
                        moeda40.c40/hidden->False;
                        moeda41.c41/hidden->False;
                        moeda42.c42/hidden->False;
                        moeda43.c43/hidden->False;
                        moeda44.c44/hidden->False;
                        moeda45.c45/hidden->False;
                        moeda46.c46/hidden->False;
                        moeda47.c47/hidden->False;
                        moeda48.c48/hidden->False;
                        moeda49.c49/hidden->False;
                        moeda50.c50/hidden->False;
                        moeda51.c51/hidden->False;
                        moeda52.c52/hidden->False;
                        moeda53.c53/hidden->False;
                        moeda54.c54/hidden->False;
                        moeda55.c55/hidden->False;
                        moeda56.c56/hidden->False;
                        moeda57.c57/hidden->False;
                        moeda58.c58/hidden->False;
                        moeda59.c59/hidden->False;
                        moeda60.c60/hidden->False;
                        moeda61.c61/hidden->False;
                        moeda62.c62/hidden->False;
                        moeda63.c63/hidden->False;
                        moeda64.c64/hidden->False;
                        moeda65.c65/hidden->False;
                        moeda66.c66/hidden->False;
                        moeda67.c67/hidden->False;
                        moeda68.c68/hidden->False;
                        moeda69.c69/hidden->False;
                        moeda70.c70/hidden->False;
                        moeda71.c71/hidden->False;
                        moeda72.c72/hidden->False;
                        moeda73.c73/hidden->False;
                        moeda74.c74/hidden->False;
                        moeda75.c75/hidden->False;
                        moeda76.c76/hidden->False;
                        moeda77.c77/hidden->False;
                        moeda78.c78/hidden->False;
                        moeda79.c79/hidden->False;
                        moeda80.c80/hidden->False;
                        moeda81.c81/hidden->False;
                        moeda82.c82/hidden->False;
                        moeda83.c83/hidden->False;
                        moeda84.c84/hidden->False;
                        moeda85.c85/hidden->False;
                        moeda86.c86/hidden->False;
                        moeda87.c87/hidden->False;
                        moeda88.c88/hidden->False;
                        moeda89.c89/hidden->False;
                >>;
        >>else<<
                if(win)<<
                        inimigo1:rotate(2,inimigo1.corpo1/x, inimigo1.corpo1/y);
                        inimigo2:rotate(2,inimigo2.corpo_1/x, inimigo2.corpo_1/y);
                        inimigo3:rotate(2,inimigo3.corpo__1/x, inimigo3.corpo__1/y);
                        inimigo4:rotate(2,inimigo4.corpo___1/x, inimigo4.corpo___1/y);
                        player:rotate(2, player.corpo/x, player.corpo/y);
                        in -> "You win in {time}s";
                        drawString(400,450,80):in -> YELLOW;  
                >>else<<
                        inimigo1:rotate(2,inimigo1.corpo1/x, inimigo1.corpo1/y);
                        inimigo2:rotate(2,inimigo2.corpo_1/x, inimigo2.corpo_1/y);
                        inimigo3:rotate(2,inimigo3.corpo__1/x, inimigo3.corpo__1/y);
                        inimigo4:rotate(2,inimigo4.corpo___1/x, inimigo4.corpo___1/y);
                        player:rotate(2, player.corpo/x, player.corpo/y);
                        in -> "You Lost !!";
                        drawString(400,450,60):in -> YELLOW;
                >>;
                
        >>;

        input:ESCAPE<<
                exit;
        >>;
        
        draw:player;
        draw:inimigos;
>>;