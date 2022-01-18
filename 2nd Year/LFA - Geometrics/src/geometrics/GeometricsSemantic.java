import java.util.HashMap;

import javax.swing.text.StyledEditorKit.BoldAction;

import java.io.File;
import java.util.*;

public class GeometricsSemantic extends geometricsBaseVisitor<String> {

   HashMap<String,String> mapa = new HashMap<String,String>();
   static String red = "\u001B[31m";
   @Override public String visitProgram(geometricsParser.ProgramContext ctx) {
      // cores default guardadas inicialmente
      String color = "color";
      mapa.put("WHITE",color);
      mapa.put("BLACK",color);
      mapa.put("BLUE",color);
      mapa.put("YELLOW",color);
      mapa.put("RED",color);
      mapa.put("GREEN",color);
      mapa.put("GRAY",color);
      mapa.put("ORANGE",color);
      mapa.put("PURPLE",color);
      mapa.put("drawstringlllll_","func");
      return visit(ctx.statList());
   }

   @Override public String visitStatList(geometricsParser.StatListContext ctx) {
      for(geometricsParser.StatContext sc: ctx.stat()) visit(sc);
      return "StatList";
   }

   @Override public String visitStatCreateFig(geometricsParser.StatCreateFigContext ctx) {
      return visit(ctx.createFig());
   }

   @Override public String visitStatImportFile(geometricsParser.StatImportFileContext ctx) {
      return visit(ctx.importFile());
   }

   @Override public String visitStatResetTime(geometricsParser.StatResetTimeContext ctx) {
      return visit(ctx.resetTime());
   }

   @Override public String visitStatColor(geometricsParser.StatColorContext ctx) {
      return visit(ctx.createColor());
   }

   @Override public String visitStatDrawFigure(geometricsParser.StatDrawFigureContext ctx) {
      return visit(ctx.drawFigure());
   }

   @Override public String visitStatCond(geometricsParser.StatCondContext ctx) {
      return visit(ctx.conditional());
   }

   @Override public String visitStatLoop(geometricsParser.StatLoopContext ctx) {
      return visit(ctx.loop());
   }

   @Override public String visitStatDecl(geometricsParser.StatDeclContext ctx) {
      return visit(ctx.declaration());
   }

   @Override public String visitStatScreenSize(geometricsParser.StatScreenSizeContext ctx) {
      return visit(ctx.screenSize());
   }

   @Override public String visitStatRotate(geometricsParser.StatRotateContext ctx) {
      return visit(ctx.rotate());
   }

   @Override public String visitStatAnimate(geometricsParser.StatAnimateContext ctx) {
      return visitChildren(ctx);
   }

   @Override public String visitStatConsole(geometricsParser.StatConsoleContext ctx) {
      return visit(ctx.console());
   }

   @Override public String visitImportFigures(geometricsParser.ImportFiguresContext ctx) {
     try{
         HashMap<String, ArrayList<Figura>> input = Output.out();
         for (String key : input.keySet()) {
            mapa.put(key, "figure");
            for(Figura fig : input.get(key)){
               String tipo = fig.type;
               if(tipo.equals("rectangle")) tipo = "rect";
               mapa.put(fig.id, tipo);
            }
         }
         return "import";
     }catch (Exception e){
         System.err.println(red+"Error importing Figures from file! Make sure to compile the file first!");
         return null;
     }
   }

   @Override public String visitResetTimer(geometricsParser.ResetTimerContext ctx) {
      return "ResetTimer";
   }
   @Override public String visitColor(geometricsParser.ColorContext ctx) {
      // try{
      //    int r = Integer.parseInt(ctx.expr(0).getText());
      //    int g = Integer.parseInt(ctx.expr(1).getText());
      //    int b = Integer.parseInt(ctx.expr(2).getText());
      // }  catch(Exception e){
      //    int r = mapa.get(key)
      // }
      // if(r > 255 || g > 255 || b > 255 || r < 0 || g < 0 || b < 0){
      //    System.err.printf(red+"Error line %3d -> ErrorValues for color should be between 0 and 255!",ctx.start.getLine());
      //    return null;
      // }
      mapa.put(ctx.ID().getText(), "color");
      return "color";
   }
   @Override public String visitDrawFig(geometricsParser.DrawFigContext ctx) {
      String id = ctx.ID().getText();
      if(mapa.containsKey(id)){   
         return "DrawFig";
      }else{
         System.err.printf(red+"Error line %3d -> draw:%s : %s does not exist!\n",ctx.start.getLine(),id,id);
         return null;
      }
   }

   @Override public String visitPrintConsole(geometricsParser.PrintConsoleContext ctx) {
      return "PrintConsole";
   }

   @Override public String visitPrintConsoleID(geometricsParser.PrintConsoleIDContext ctx) {
      String id = ctx.ID().getText();
      try{
         if(mapa.containsKey(id)){
            if(mapa.get(id).equals("number") || mapa.get(id).equals("string") || mapa.get(id).equals("boolean")){ //FALTA A CENA A CONSOLE DE UMA STRING
               return "PrintConsoleID";
            }else{
               System.err.printf(red+"Error line %3d -> console(%s) : You can only console numbers,strings and boolean \n",ctx.start.getLine(),id);
               return null;
            }
         }else{
            System.err.printf(red+"Error line %3d -> console(%s) : %s does not exists !\n",ctx.start.getLine(),id,id);
            return null;
         }
      }catch(Exception e){
            System.err.printf(red+"Error line %3d -> console(%s) : %s cannot console null \n",ctx.start.getLine(),id,id);
            return null;
      }
   }
   // FALTA ISTO ####################################################################################
   @Override public String visitAnimationTranslate(geometricsParser.AnimationTranslateContext ctx) {
      for(int i = 0; i < ctx.expr().size(); i++){
         String atual = visit(ctx.expr(i));
         try{
            if(!atual.equals("number")) {
               System.err.printf(red+"Error line %3d -> %s is not a number!\n",ctx.start.getLine(),ctx.expr(i).getText());
               return null;
            }
         }catch (Exception e){
         }
      }
      return "translateObjAnimation";
   }

   @Override public String visitAnimationRotate(geometricsParser.AnimationRotateContext ctx) {
      for(int i = 0; i < ctx.expr().size(); i++){
         String atual = visit(ctx.expr(i));
         try{
            if(!atual.equals("number")) {
               System.err.printf(red+"Error line %3d -> %s is not a number!\n",ctx.start.getLine(),ctx.expr(i).getText());
               return null;
            }
         }catch (Exception e){
         }
      }
      return "rotateObjAnimation";
   }

   @Override public String visitRotateObj(geometricsParser.RotateObjContext ctx) {
      for(int i = 0; i < ctx.expr().size(); i++){
         String atual = visit(ctx.expr(i));
         try {
            if(!atual.equals("number")) {
               System.err.printf(red+"Error line %3d -> %s is not a number!\n",ctx.start.getLine(),ctx.expr(i).getText());
               return null;
            }
         }catch (Exception e){
         }
      }
      return "rotateObj";
   }

   @Override public String visitTranslateObj(geometricsParser.TranslateObjContext ctx) {
      for(int i = 0; i < ctx.expr().size(); i++){
         String atual = visit(ctx.expr(i));
         try{
            if(!atual.equals("number")) {
               System.err.printf(red+"Error line %3d -> %s is not a number!\n",ctx.start.getLine(),ctx.expr(i).getText());
               return null;
            }
         }catch (Exception e){
         }
      }
      return "translateObj";
   }

   @Override public String visitDisplaySize(geometricsParser.DisplaySizeContext ctx) {
      return visitChildren(ctx);
   }
   //######################################################################################
   @Override public String visitExprDeclAttr(geometricsParser.ExprDeclAttrContext ctx) {
      String attr = visit(ctx.getAttribute());
      String tipo = visit(ctx.expr());                                               
      try{
         if(!attr.equals(tipo)){
            System.err.printf(red+"Error line %3d -> [%s -> %s] : %s cannot be converted to %s\n",ctx.start.getLine(),ctx.getAttribute().getText(),ctx.expr().getText(),ctx.getAttribute().getText(),ctx.expr().getText());
            return null;
         }
      }catch (Exception e){
         System.err.printf(red+"Error line %3d -> [%s -> %s] : %s cannot be converted to %s\n",ctx.start.getLine(),ctx.getAttribute().getText(),ctx.expr().getText(),ctx.getAttribute().getText(),ctx.expr().getText());
         return null;

      }
      return visitChildren(ctx);
   }

   @Override public String visitExprDeclID(geometricsParser.ExprDeclIDContext ctx) {
      String type = visit(ctx.expr());
      mapa.put(ctx.ID().getText(),type);
      return type;
   }

   @Override public String visitExprDeclIDString(geometricsParser.ExprDeclIDStringContext ctx) {
      try{
         boolean erro = false;
         boolean erroP = false;
         String valor = ctx.String().getText();
         int num1 = 0;
         int num2 = 0;
         String[] variavel = new String[50];
         int index = -1;
         boolean mudar = false;
         for(int i=0;i<valor.length();i++){
            if(valor.charAt(i) == '}'){
               num1+=1;
               erroP =false;
               mudar =false;
            }
            if(mudar){
               if(variavel[index]==null)variavel[index] = "" + valor.charAt(i);
               else variavel[index]+= valor.charAt(i);
            }
            if(valor.charAt(i) == '{'){
               num2+=1;
               erroP = true;
               index+=1;
               mudar = true;
            }
         }
         for(int i=0;i<index+1;i++){
            if(!mapa.containsKey(variavel[i])){
               System.err.printf(red+"Error line %3d -> %s: this variable is not initialized\n",ctx.start.getLine(),variavel[i]);
               erro = true;
            }
         }
         if(erroP | num1!=num2){
            System.err.printf(red+"Error line %3d -> you need to use this {<variable>}\n",ctx.start.getLine());
         }
         if(erro | erroP){
            return null;
         }
      }catch(Exception E){}
      String type = "string";
      mapa.put(ctx.ID().getText(),type);
      return type;
   }

   @Override public String visitIfStat(geometricsParser.IfStatContext ctx) {
      String type = visit(ctx.expr());
      if(type == null || !type.equals("boolean")){
         System.err.printf(red+"Error line %3d -> if(%s)<<...>>; : Condition can only be of type boolean!\n",ctx.start.getLine(),ctx.cond.getText());
         return null;
      }
      visit(ctx.trueSL);
      try{
         visit(ctx.falseSL);
      }catch(Exception e){   
      }
      
      return "ifCond";
   }

   @Override public String visitForeverStat(geometricsParser.ForeverStatContext ctx) {
      return visit(ctx.statList());
   }

   @Override public String visitExprRandom(geometricsParser.ExprRandomContext ctx) {
      return visit(ctx.random());
   }

   @Override public String visitDrawStringPY(geometricsParser.DrawStringPYContext ctx) {
      String text ="";
      String color="";
      if(mapa.containsKey(ctx.ID(0).getText())){
         text = mapa.get(ctx.ID(0).getText());
      }else{
         System.err.printf(red+"Error line %3d -> %s does not exists\n",ctx.start.getLine(),ctx.text.getText());
         return null;
      }
      if(mapa.containsKey(ctx.ID(1).getText())){
         color = mapa.get(ctx.ID(1).getText());
      }else{
         System.err.printf(red+"Error line %3d -> %s does not exists\n",ctx.start.getLine(),ctx.color.getText());
         return null;
      }

      if(text == null || color == null){
         return null;
      }
      if(!(text.equals("number")||(text.equals("string")))){
         System.err.printf(red+"Error line %3d -> %s can only be number or string\n",ctx.start.getLine(),ctx.text.getText());
         return null;
      }
      if(!(color.equals("color"))){
         System.err.printf(red+"Error line %3d -> %s can only be of type color\n",ctx.start.getLine(),ctx.color.getText());
         return null;
      }
      
      return "drawString";
   }
   @Override public String visitRandNumber(geometricsParser.RandNumberContext ctx) {
      int inicial = Integer.parseInt(ctx.inicial.getText());
      int fim = Integer.parseInt(ctx.fim.getText());
      if(inicial >= fim ) return null;
      return "number";
   }

   @Override public String visitExprAddSub(geometricsParser.ExprAddSubContext ctx) {
      String type1 = visit(ctx.e1);
      String type2 = visit(ctx.e2);
      if(type1 == null || type2 == null){
         return null;
      }
      if(!(type1.equals(type2) && type1.equals("number"))){
         System.err.printf(red+"Error line %3d -> [%s %s %s] : Can only add values of same type!\n",ctx.start.getLine(),ctx.e1.getText(),ctx.op.getText(),ctx.e2.getText());
         return null;
      }
      return type1;
   }

   @Override public String visitExprGetIDs(geometricsParser.ExprGetIDsContext ctx) {
      if(!mapa.containsKey(ctx.ID().getText())){
         System.err.printf(red+"Error line %3d -> [%s->null] : Variable %s not initiaized!\n",ctx.start.getLine(),ctx.ID().getText(),ctx.ID().getText());
         return null;
      }
      return mapa.get(ctx.ID().getText());
   }

   @Override public String visitExprCollision(geometricsParser.ExprCollisionContext ctx) {
      String figure = ctx.ID().getText();
      if(!mapa.containsKey(figure)){
         System.err.printf(red+"Error line %3d -> %s figure does not exists!\n",ctx.start.getLine(),figure);
         return null;
      }else{
         String type = mapa.get(figure);
         if(!type.equals("figure")){
            System.err.printf(red+"Error line %3d -> %s is not a figure!\n",ctx.start.getLine(),figure);
            return null;
         }
      }
      return "boolean";
   }

   @Override public String visitExprCollisionFigs(geometricsParser.ExprCollisionFigsContext ctx){
      String figure1 = ctx.ID(0).getText();
      String figure2 = ctx.ID(1).getText();
      if(figure1.equals(figure2)){
         System.err.printf(red+"Error line %3d -> you cant collides with same figure [%s] !\n",ctx.start.getLine(),figure1,figure2);
         return null;
      }
      if(!mapa.containsKey(figure1)){
         System.err.printf(red+"Error line %3d -> %s figure does not exists!\n",ctx.start.getLine(),figure1);
         return null;
      }else{
         String type = mapa.get(figure1);
         if(!type.equals("figure")){
            System.err.printf(red+"Error line %3d -> %s is not a figure!\n",ctx.start.getLine(),figure1);
            return null;
         }
      }
      if(!mapa.containsKey(figure2)){
         System.err.printf(red+"Error line %3d -> %s figure does not exists!\n",ctx.start.getLine(),figure2);
         return null;
      }else{
         String type = mapa.get(figure2);
         if(!type.equals("figure")){
            System.err.printf(red+"Error line %3d -> %s is not a figure!\n",ctx.start.getLine(),figure2);
            return null;
         }
      }
      return "boolean";
   }

   @Override public String visitExprParent(geometricsParser.ExprParentContext ctx) {
      String type = visit(ctx.expr());
      return type;
   }

   @Override public String visitExprReadTimer(geometricsParser.ExprReadTimerContext ctx) {
      return "number";
   }

   @Override public String visitExprBoolean(geometricsParser.ExprBooleanContext ctx) {
      return "boolean";
   }

   @Override public String visitExprReal(geometricsParser.ExprRealContext ctx) {
      return "number";
   }

   @Override public String visitExprInteger(geometricsParser.ExprIntegerContext ctx) {
      return "number";
   }

   @Override public String visitExperGetAttr(geometricsParser.ExperGetAttrContext ctx) {
      return visit(ctx.getAttribute());
   }

   @Override public String visitExprMultDivMod(geometricsParser.ExprMultDivModContext ctx) {
      String type1 = visit(ctx.e1);
      String type2 = visit(ctx.e2);
      if(type1 == null || type2 == null){
         return null;
      }
      if(!(type1.equals(type2) && type1.equals("number"))){
         System.err.printf(red+"Error line %3d -> [%s %s %s] : Can only add values of same type!\n",ctx.start.getLine(),ctx.e1.getText(),ctx.op.getText(),ctx.e2.getText());
         return null;
      }
      return type1;
   }

   @Override public String visitExprRelation(geometricsParser.ExprRelationContext ctx) {
      String type1 = visit(ctx.e1);
      String type2 = visit(ctx.e2);
      if(type1 == null || type2 == null) return null;
      if(!type1.equals(type2)){
         System.err.printf(red+"Error line %3d -> [%s %s %s] : Can only compare values of same type\n",ctx.start.getLine(),ctx.e1.getText(),ctx.op.getText(),ctx.e2.getText());
         return null;
      }
      return "boolean";
   }

   //Não da para aceder a figuras de figuras e mudar os atributos, apenas as primitivas dessa figura

   @Override public String visitGetAttr(geometricsParser.GetAttrContext ctx) {
      if(mapa.containsKey(ctx.figure.getText())){
         if(mapa.containsKey(ctx.objeto.getText())){
            String tipoObj = mapa.get(ctx.objeto.getText());
            String param = ctx.param.getText();
            String func = ctx.figure.getText();
            if(tipoObj.equals("circle")){
               switch(param){
                  case "thickness":
                     return "number";
                  case "filled":
                     return "boolean";
                  case "x":
                     return "number";
                  case "y":
                     return "number";
                  case "r":
                     return "number";
                  case "color":
                     return "color";
                  case "hidden":
                     return "boolean";
                  default:
                     String s = ctx.figure.getText() + "." + ctx.objeto.getText() + "/" + param;
                     System.err.printf(red+"Error line %3d -> %s - circle : Attribute %s doesn't exist in %s!\n",ctx.start.getLine(),s,param,s);
                     return null;
               }
            }else if(tipoObj.equals("line")){
               switch(param){
                  case "thickness":
                     return "number";
                  case "x1":
                     return "number";
                  case "x2":
                     return "number";
                  case "y1":
                     return "number";
                  case "y2":
                     return "number";
                  case "color":
                     return "color";
                  case "hidden":
                     return "boolean";
                  default:
                     String s = ctx.figure.getText() + "." + ctx.objeto.getText() + "/" + param;
                     System.err.printf(red+"Error line %3d -> %s - line : Attribute %s doesn't exist in %s!\n",ctx.start.getLine(),s,param,s);
                     return null;
               }
            }else if(tipoObj.equals("square") || tipoObj.equals("rect")){
               switch(param){
                  case "x1":
                     return "number";
                  case "x2":
                     return "number";
                  case "x3":
                     return "number";
                  case "x4":
                     return "number";
                  case "y1":
                     return "number";
                  case "y2":
                     return "number";
                  case "y3":
                     return "number";
                  case "y4":
                     return "number";
                  case "filled":
                     return "boolean";
                  case "thickness":
                     return "number";
                  case "hidden":
                     return "boolean";
                  case "color":
                     return "color";
                  default:
                     String s = ctx.figure.getText() + "." + ctx.objeto.getText() + "/" + param;
                     System.err.printf(red+"Error line %3d -> %s - %s : Attribute %s doesn't exist in %s!\n",ctx.start.getLine(),s,tipoObj,param,tipoObj);
                     return null;
               }
            }else if(tipoObj.equals("triangle")){
               switch(param){
                  case "x1":
                     return "number";
                  case "y1":
                     return "number";
                  case "x2":
                     return "number";
                  case "y2":
                     return "number";
                  case "x3":
                     return "number";
                  case "y3":
                     return "number";
                  case "thickness":
                     return "number";
                  case "filled":
                     return "boolean";
                  case "hidden":
                     return "boolean";
                  case "color":
                     return "color";
                  default:
                     String s = ctx.figure.getText() + "." + ctx.objeto.getText() + "/" + param;
                     System.err.printf(red+"Error line %3d -> %s - Triangle : Attribute %s doesn't exist in triangles!\n",ctx.start.getLine(),s,param);
                     return null;
               }
            }else if(tipoObj.equals("figure")){
                  String s = ctx.figure.getText() + "." + ctx.objeto.getText() + "/" + param;
                  System.err.printf(red+"Error line %3d -> %s - figure : Attribute %s doesn't exist in %s!\n",ctx.start.getLine(),s,ctx.objeto.getText(),s);
                  return null;
            }
         }else{
            String s = ctx.figure.getText() + "." + ctx.objeto.getText();
            System.err.printf(red+"Error line %3d -> %s does not exist!!\n",ctx.start.getLine(),s);
            return null;
         }
      }else{
         System.err.printf(red+"Error line %3d -> %s does not exist!!\n",ctx.start.getLine(),ctx.figure.getText());
         return null;
      }
      return null;
   }

   @Override public String visitCreateFigureObj(geometricsParser.CreateFigureObjContext ctx) {
      if(mapa.containsKey(ctx.ID().getText())){
         System.err.printf(red+"Error line %3d -> %s (Figure) : Figure already exists!\n",ctx.start.getLine(),ctx.ID().getText());
         return null;
      }else{
         mapa.put(ctx.ID().getText(),"figure");
         for (int i = 0; i < ctx.constructor().size(); i++) {
            visit(ctx.constructor(i));
         }
         return "figure";
      }
   }
   @Override public String visitCreateFigureFig(geometricsParser.CreateFigureFigContext ctx) {
      if(mapa.containsKey(ctx.ID(0).getText())){
         System.err.printf(red+"Error line %3d -> %s (Figure) : Figure already exists!\n",ctx.start.getLine(),ctx.ID(0).getText());
         return null;
      }else{
         mapa.put(ctx.ID(0).getText(),"figure");
         for(int i = 1; i < ctx.ID().size(); i++){
            String fig = ctx.ID(i).getText();
            if(fig.equals(ctx.ID(0).getText())){
               System.err.printf(red+"Error line %3d -> %s-Figure : Cannot create figure  "+fig + "with the same name as figure container!\n",ctx.start.getLine(),fig);
               return null;
            }
            if(!mapa.containsKey(fig)){
               System.err.printf(red+"Error line %3d -> %s-Figure : Figure " + fig + " is not initialized!\n",ctx.start.getLine(),fig);
               return null;
            }
            String tipo = mapa.get(fig);
            if(!tipo.equals("figure")){
               System.err.printf(red+"Error line %3d -> %s-Figure : Can only create figures of figures and primitive figures!\n",ctx.start.getLine(),fig);
               return null;
            }
         }
         return "figure";
      } 
   }
   @Override public String visitCreateCircle(geometricsParser.CreateCircleContext ctx) {
      String id = ctx.dest.getText();
      if(mapa.containsKey(id)){
         System.err.printf(red+"Error line %3d -> %s-Circle : Primitive %s already exists!\n",ctx.start.getLine(),id,id);
         return null;
      }else{
         mapa.put(id, "circle");
      }
      return "circle";
   }

   @Override public String visitCreateLine(geometricsParser.CreateLineContext ctx) {
      String id = ctx.dest.getText();
      if(mapa.containsKey(id)){
         System.err.printf(red+"Error line %3d -> %s-Line : Primitive %s already exists!\n",ctx.start.getLine(),id,id);
         return null;
      }else{
         mapa.put(id, "line");
      }
      return "line";
   }

   @Override public String visitCreateSquare(geometricsParser.CreateSquareContext ctx) {
      String id = ctx.dest.getText();
      if(mapa.containsKey(id)){
         System.err.printf(red+"Error line %3d -> %s-Square : Primitive %s already exists!\n",ctx.start.getLine(),id,id);
         return null;
      }else{
         mapa.put(id, "square");
      }
      return "square";
   }

   @Override public String visitCreateRect(geometricsParser.CreateRectContext ctx) {  
      String id = ctx.dest.getText();
      if(mapa.containsKey(id)){
         System.err.printf(red+"Error line %3d -> %s-Rectangle : Primitive %s already exists!\n",ctx.start.getLine(),id,id);
         return null;
      }else{
         mapa.put(id, "rect");
      }
      return "rect";
   }

   @Override public String visitCreateTriangle(geometricsParser.CreateTriangleContext ctx) {
      String id = ctx.dest.getText();
      if(mapa.containsKey(id)){
         System.err.printf(red+"Error line %3d -> %s-Triangle : Primitive %s already exists!\n",ctx.start.getLine(),id,id);
         return null;
      }else{
         mapa.put(id, "triangle");
      }
      return "triangle";
   }
}