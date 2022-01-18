display(800,800):"Relogio";
horas -> 0;
minutos -> 0;
forever<<
    segundos -> readTimer;
    input:escape<<exit;>>;
    input:h<<horas->horas+1;>>;
    input:m<<minutos->minutos+1;>>;
    out -> "{horas}:{minutos}:{segundos}";
    if(segundos = 60)<<resetTimer;minutos -> minutos + 1;>>;
    if(minutos = 60)<<horas -> horas + 1;>>;
    if(horas = 24)<<horas -> 0;minutos -> 0;segundos->0;>>;
    drawString(400,400,150):out -> ORANGE;
>>;