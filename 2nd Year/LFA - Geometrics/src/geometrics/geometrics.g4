grammar  geometrics;

program: statList EOF;

statList : (stat? ';')*;

stat:   createFig               #StatCreateFig
        | input                 #StatInput
        | importFile            #StatImportFile
        | resetTime             #StatResetTime
        | createColor           #StatColor
        | drawFigure            #StatDrawFigure
        | conditional           #StatCond
        | loop                  #StatLoop
        | declaration           #StatDecl
        | screenSize            #StatScreenSize
        | translate             #StatTranslate
        | rotate                #StatRotate
        | animation             #StatAnimate
        | console               #StatConsole
        | exit                  #StatExit
        | random                #StatRandom
        | drawString            #StatString
        ;

drawString: 'drawString' '(' x=Integer ',' y=Integer  ',' size=Integer')'':' text=ID '->' color=ID   #DrawStringPY;

exit: 'exit'    #ExitProgram;

input:  'input' ':' ID '<<' statList '>>'       #UserInput;

importFile : 'importFigures'     #importFigures;

resetTime : 'resetTimer'      #resetTimer;

createColor: ID '->'  '(' expr ',' expr ',' expr ')'    #Color;

drawFigure : 'draw:' ID               #drawFig;

console : 'console''(' p=String')'         #printConsole
        | 'console(' ID ')'           #printConsoleID;

animation : ID ':' 'translate' '(' expr ',' expr ')' 'from' 'second' start=Integer 'to' end=Integer                   #animationTranslate
            |ID ':' 'rotate' '('expr ',' expr ',' expr ')' 'from' 'second' start=Integer 'to' end=Integer                                #animationRotate
            ;

rotate : ID':' 'rotate' '('expr ',' expr ',' expr ')'         #rotateObj;

translate : ID ':' 'translate' '(' expr ',' expr ')'                  #translateObj;

random : 'rand''('inicial= Integer','fim=Integer')'           #randNumber;

screenSize : 'display(' x=Integer ',' y=Integer ')'':' name=String #displaySize;

declaration :  getAttribute '->' expr    #ExprDeclAttr
            |ID '->' expr                #ExprDeclID
            |ID '->' String              #ExprDeclIDString;

conditional : 'if' '(' cond=expr ')<<' trueSL=statList '>>' ('else<<' falseSL=statList '>>')?   #ifStat; 

loop:              'forever' '<<' statList '>>'              #foreverStat;

expr returns[String varName]:         
              e1=expr op=('*'|'/'|'%') e2=expr                          #ExprMultDivMod
       |      e1=expr op=('+'|'-') e2=expr                              #ExprAddSub
       |      e1=expr op=('>' | '<' | '=' | '/=' |'and' |'or' | '>=' | '<=') e2=expr  #ExprRelation
       |      '(' expr ')'                                              #ExprParent
       |      Integer                                                   #ExprInteger
       |      REAL                                                      #ExprReal
       |      BooleanLiteral                                            #ExprBoolean
       |      getAttribute                                              #ExperGetAttr
       |      'readTimer'                                               #ExprReadTimer  
       |      ID                                                        #ExprGetIDs
       |      ID ':' 'collidesEdge'                                     #ExprCollision
       |      ID ':' 'collides' ':' ID                                  #ExprCollisionFigs
       |      random                                                    #ExprRandom     
       ;

getPrimitive : figure=ID '.' objeto=ID          #getPrim;

getAttribute : figure=ID '.' objeto=ID'/' param= ID #GetAttr;

createFig : 'figure' ID '(' constructor* ')'     #createFigureObj
        |   'figure' ID '(' (ID ';')* ')'              #createFigureFig;

constructor: dest=ID '->' 'circle' '('x=Integer ',' y=Integer ','r=Integer ')'     ENDLINE                                 #createCircle
            | dest=ID '->' 'line' '('x1=Integer ',' y1=Integer ','x2=Integer ',' y2=Integer ')'   ENDLINE                  #createLine
            | dest=ID '->' 'square' '('x1=Integer ',' y1=Integer ','lengthx=Integer')' ENDLINE                             #createSquare
            | dest=ID '->' 'rectangle' '('x1=Integer ',' y1=Integer ','lengthx=Integer ',' lengthy=Integer ')' ENDLINE     #createRect
            | dest=ID '->' 'triangle' '(' x1=Integer ',' y1=Integer ','x2=Integer ',' y2=Integer ',' x3=Integer ',' y3=Integer ')' ENDLINE #createTriangle
            ;


BooleanLiteral : 'True' | 'False';
ENDLINE: ';';
REAL: [0-9]+ '.' [0-9]*;
COMMENT: ( '//' ~[\r\n]* '\r'? '\n') -> skip;
WS: [ \t\r\n]+ -> skip;
String : '"'.*?'"';
ID: [a-zA-Z_][a-zA-Z_0-9]*;
Integer: '-'?[0-9]+;
