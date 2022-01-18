grammar auxiliar;

program : statList EOF;

statList :  (stat)*;

stat : createFigure           #StatCreateFig;

createFigure :      id=ID '{' constructor* '}'                 #createFigureObj;

constructor :       id=ID '=' 'circle' '(' x=Integer ',' y= Integer ',' r=Integer ')' ('{' (param=Param ':' attr=attribute ';')+ '}')*        #createCircle
          |         id=ID '=' 'rectangle' '('x1=Integer ',' y1=Integer ',' lengthx=Integer ',' lengthy=Integer ')' ('{' (param=Param ':' attr=attribute ';')+ '}')* #createRect
          |         id=ID '=' 'square' '(' x1=Integer ',' y1=Integer ',' lengthx=Integer ')' ('{' (param=Param ':' attr=attribute ';')+ '}')*          #createSquare
          |         id=ID '=' 'line' '('x1=Integer ',' y1=Integer ','x2=Integer ',' y2=Integer ')' ('{' (param=Param ':' attr=attribute ';')+ '}')*    #createLine
          |         id=ID '=' 'triangle' '(' x1=Integer ',' y1=Integer ','x2=Integer ',' y2=Integer ',' x3=Integer ',' y3=Integer ')' ('{' (param=Param ':' attr=attribute ';')+ '}')* #createTriangle
          ;

attribute : ID | Integer      #getAttr;

Integer: '-'?[0-9]+;
Param : 'color' | 'thickness' | 'filled' | 'hidden';
ID: [a-zA-Z_][a-zA-Z_0-9]*;
COMMENT: ( '//' ~[\r\n]* '\r'? '\n') -> skip;
WS: [ \t\r\n]+ -> skip;

