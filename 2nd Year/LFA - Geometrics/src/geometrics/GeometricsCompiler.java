import java.io.File;
import java.util.*;

import org.stringtemplate.v4.*;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;

public class GeometricsCompiler extends geometricsBaseVisitor<ST> {
   static String red = "\u001B[31m";
   class Objeto{
      String id;
      String type;

      Objeto(String id, String type){
         this.id = id;
         this.type = type;
      }

      @Override public String toString(){
         return this.id + " -> " + this.type;
      }
   }

   HashMap<String, ArrayList<Objeto>> mapa = new HashMap<String, ArrayList<Objeto>>();

   private STGroup templates = new STGroupFile("python.stg");

   String globalID;
   String globalTYPE;
   ArrayList<ST> drawObj = new ArrayList<ST>();
   ArrayList<ST> translateObj = new ArrayList<ST>();
   String globalInt;
   String colorGlobal;


   @Override public ST visitProgram(geometricsParser.ProgramContext ctx) {
      try{
         ST res = templates.getInstanceOf("module");
         res.add("stat",visit(ctx.statList()));
         return res;
      }catch(Exception e){return null;}
   }

   @Override public ST visitStatList(geometricsParser.StatListContext ctx) {
      try{
         ST res = templates.getInstanceOf("stats");
         for(geometricsParser.StatContext sc: ctx.stat())
            res.add("stat", visit(sc));      
         return res;
      }catch(Exception e){return null;}
   }

   @Override public ST visitStatImportFile(geometricsParser.StatImportFileContext ctx){
      try{
         ST res = templates.getInstanceOf("stats");
         res.add("stat",visit(ctx.importFile()));
         return res;
    }catch(Exception e){return null;}
   }

   @Override public ST visitStatResetTime(geometricsParser.StatResetTimeContext ctx) {
      try{
         ST res = templates.getInstanceOf("stats");
         res.add("stat", visit(ctx.resetTime()).render());
         return res;
      }catch(Exception e){return null;}
   }

   @Override public ST visitStatInput(geometricsParser.StatInputContext ctx) {
      try{
         ST res = templates.getInstanceOf("stats");
         res.add("stat", visit(ctx.input()).render());
         return res;
      }catch(Exception e){return null;}
   }

   @Override public ST visitStatExit(geometricsParser.StatExitContext ctx) {
      try{
         ST res = templates.getInstanceOf("stats");
         res.add("stat", visit(ctx.exit()).render());
         return res;
      }catch(Exception e){return null;}
   }

   @Override public ST visitStatRandom(geometricsParser.StatRandomContext ctx) {
      try{
         ST res = templates.getInstanceOf("stats");
         res.add("stat", visit(ctx.random()).render());
         return res;
      }catch(Exception e){return null;}
   }

   @Override public ST visitStatCreateFig(geometricsParser.StatCreateFigContext ctx) {
      try{
         ST res = templates.getInstanceOf("stats");
         res.add("stat", visit(ctx.createFig()).render());
         return res;
      }catch(Exception e){return null;}
   }

   @Override public ST visitStatColor(geometricsParser.StatColorContext ctx){
      try{
         ST res = templates.getInstanceOf("stats");
         res.add("stat", visit(ctx.createColor()).render());
         return res;
      }catch(Exception e){return null;}
   }

   @Override public ST visitStatDrawFigure(geometricsParser.StatDrawFigureContext ctx) {
      try{
         ST res = templates.getInstanceOf("stats");
         visit(ctx.drawFigure());
         for (int i = 0; i < drawObj.size(); i++) {
            res.add("stat", drawObj.get(i).render());
         }
         return res;
      }catch(Exception e){return null;}
   }

   @Override public ST visitStatCond(geometricsParser.StatCondContext ctx) {
      try{
         ST res = templates.getInstanceOf("stats");
         res.add("stat", visit(ctx.conditional()).render());
         return res;
      }catch(Exception e){return null;}
   }

   @Override public ST visitStatLoop(geometricsParser.StatLoopContext ctx) {
      ST res = templates.getInstanceOf("stats");
      res.add("stat", visit(ctx.loop()).render());
      return res;
   }

   @Override public ST visitStatDecl(geometricsParser.StatDeclContext ctx) {
      try{
         ST res = templates.getInstanceOf("stats");
         res.add("stat", visit(ctx.declaration()).render());
         return res;
      }catch(Exception e){
         return null;
      }
   }

   @Override public ST visitStatScreenSize(geometricsParser.StatScreenSizeContext ctx) {
      try{
         ST res = templates.getInstanceOf("stats");
         res.add("stat", visit(ctx.screenSize()).render());
         return res;
      }catch(Exception e){return null;}
   }

   @Override public ST visitStatRotate(geometricsParser.StatRotateContext ctx) {
      try{
         ST res = templates.getInstanceOf("stats");
         visit(ctx.rotate());
         for (int i = 0; i < translateObj.size(); i++) {
            res.add("stat", translateObj.get(i).render());
         }
         return res;
      }catch(Exception e){return null;}
   }

   @Override public ST visitStatTranslate(geometricsParser.StatTranslateContext ctx) {
      try{
         ST res = templates.getInstanceOf("stats");
         visit(ctx.translate());
         for (int i = 0; i < translateObj.size(); i++) {
            res.add("stat", translateObj.get(i).render());
         }
         return res;
      }catch(Exception e){return null;}
   }

   @Override public ST visitStatAnimate(geometricsParser.StatAnimateContext ctx) {
      try{
         ST res = templates.getInstanceOf("stats");
         visit(ctx.animation());
         for (int i = 0; i < translateObj.size(); i++) {
            res.add("stat", translateObj.get(i).render());
         }
         return res;
      }catch(Exception e){return null;}
   }

   @Override public ST visitStatConsole(geometricsParser.StatConsoleContext ctx) {
      try{
         ST res = templates.getInstanceOf("stats");
         res.add("stat", visit(ctx.console()).render());
         return res;
      }catch(Exception e){return null;}
   }

   @Override public ST visitRandNumber(geometricsParser.RandNumberContext ctx) {
      globalID = "random.randint("+ctx.inicial.getText()+","+ctx.fim.getText()+")";
      return null;
   }
   
   
   @Override public ST visitDrawFig(geometricsParser.DrawFigContext ctx) {
      drawObj = new ArrayList<ST>();
      String id = ctx.ID().getText();
      if(!mapa.containsKey(id)) return null;
      ArrayList<Objeto> temp = mapa.get(id);
      for (int i = 0; i < temp.size(); i++) {
         Objeto atual = temp.get(i);
         if(atual.type.equals("circle")){
            ST res = templates.getInstanceOf("drawCircle");
            res.add("var", atual.id);
            drawObj.add(res);
         }else if(atual.type.equals("line")){
            ST res = templates.getInstanceOf("drawLine");
            res.add("var", atual.id);
            drawObj.add(res);
         }else if(atual.type.equals("square")){
            ST res = templates.getInstanceOf("drawPolygon");
            res.add("var", atual.id);
            drawObj.add(res);
         }else if(atual.type.equals("rect")){
            ST res = templates.getInstanceOf("drawPolygon");
            res.add("var", atual.id);
            drawObj.add(res);
         }else if(atual.type.equals("triangle")){
            ST res = templates.getInstanceOf("drawPolygon");
            res.add("var", atual.id);
            drawObj.add(res);
         }
      }
      return null;
   }

   @Override public ST visitResetTimer(geometricsParser.ResetTimerContext ctx){
      ST res = templates.getInstanceOf("resetTimer");
      return res;
   }

   @Override public ST visitExitProgram(geometricsParser.ExitProgramContext ctx){
      ST res = templates.getInstanceOf("exit");
      return res;
   }

   @Override public ST visitUserInput(geometricsParser.UserInputContext ctx){
      String inp = ctx.ID().getText().toLowerCase();
      if(inp.equals("up") || inp.equals("down") || inp.equals("left") || inp.equals("right") || inp.equals("escape")|| inp.equals("space")) inp = inp.toUpperCase();
      ST res = templates.getInstanceOf("input");
      res.add("var", inp);
      res.add("stat_inside", visit(ctx.statList()).render());
      return res;
   }

   @Override public ST visitColor(geometricsParser.ColorContext ctx){
      ST res = templates.getInstanceOf("color");
      res.add("stat", visit(ctx.expr(0)).render());
      res.add("stat", visit(ctx.expr(1)).render());
      res.add("stat", visit(ctx.expr(2)).render());
      res.add("var", ctx.ID().getText() + "_");
      res.add("r", ctx.expr(0).varName);
      res.add("g", ctx.expr(1).varName);
      res.add("b", ctx.expr(2).varName);
      return res;
   }

   @Override public ST visitDrawStringPY(geometricsParser.DrawStringPYContext ctx){
      ST res = templates.getInstanceOf("displayString");
      res.add("text", ctx.ID(0).getText() + "_");
      res.add("x", ctx.x.getText());
      res.add("y", ctx.y.getText());
      res.add("size", ctx.size.getText());
      res.add("color", ctx.ID(1).getText() + "_");
      return res;
   }

   @Override public ST visitPrintConsole(geometricsParser.PrintConsoleContext ctx) {
      //System.out.println("string");
      ST res = templates.getInstanceOf("print");
      res.add("value", '"' + ctx.String().getText() +'"');
      return res;
   }

   @Override public ST visitPrintConsoleID(geometricsParser.PrintConsoleIDContext ctx) {
      //System.out.println("id");
      ST res = templates.getInstanceOf("print");
      res.add("value", ctx.ID().getText() + "_");
      return res;
   }

   @Override public ST visitImportFigures(geometricsParser.ImportFiguresContext ctx){
      try{
         ST res = templates.getInstanceOf("stats");
         HashMap<String, ArrayList<Figura>> input = Output.out();
         for (String key : input.keySet()) {
            ArrayList<Objeto> figsNames = new ArrayList<Objeto>();
            for(Figura fig : input.get(key)){
               String typeFig = fig.type;
               if(typeFig.equals("rectangle")) typeFig = "rect";
               Objeto atual = new Objeto(fig.id +"_", typeFig);
               figsNames.add(atual);
            }
            mapa.put(key, figsNames);
            for(Figura fig : input.get(key)){
               if(fig.type.equals("circle")){
                  Circle atual = (Circle)fig;
                  ST create = templates.getInstanceOf("createCircle");
                  create.add("var", atual.id+"_");
                  create.add("x", Integer.toString(atual.x));
                  create.add("y", Integer.toString(atual.y));
                  create.add("r", Integer.toString(atual.raio));
                  res.add("stat", create.render());
               }else if(fig.type.equals("square")){
                  Square atual = (Square)fig;
                  ST create = templates.getInstanceOf("createRectangle");
                  create.add("var", atual.id+"_");
                  create.add("x", Integer.toString(atual.x));
                  create.add("y", Integer.toString(atual.y));
                  create.add("w", Integer.toString(atual.comprimento));
                  create.add("h", Integer.toString(atual.comprimento));
                  res.add("stat", create.render());
               }else if(fig.type.equals("rectangle")){
                  Rectangle atual = (Rectangle)fig;
                  ST create = templates.getInstanceOf("createRectangle");
                  create.add("var", atual.id+"_");
                  create.add("x", Integer.toString(atual.x));
                  create.add("y", Integer.toString(atual.y));
                  create.add("w", Integer.toString(atual.comprimento));
                  create.add("h", Integer.toString(atual.largura));
                  res.add("stat", create.render());
               }else if(fig.type.equals("triangle")){
                  Triangle atual = (Triangle)fig;
                  ST create = templates.getInstanceOf("createTriangle");
                  create.add("var", atual.id+"_");
                  create.add("x1", Integer.toString(atual.x1));
                  create.add("y1", Integer.toString(atual.y1));
                  create.add("x2", Integer.toString(atual.x2));
                  create.add("y2", Integer.toString(atual.y2));
                  create.add("x3", Integer.toString(atual.x3));
                  create.add("y3", Integer.toString(atual.y3));
                  res.add("stat", create.render());
               }else if(fig.type.equals("line")){
                  Line atual = (Line)fig;
                  ST create = templates.getInstanceOf("createLine");
                  create.add("var", atual.id+"_");
                  create.add("x1", Integer.toString(atual.x1));
                  create.add("y1", Integer.toString(atual.y1));
                  create.add("x2", Integer.toString(atual.x2));
                  create.add("y2", Integer.toString(atual.y2));
                  res.add("stat", create.render());
               }
               for(String attr : fig.atributos.keySet()){
                  ST change = templates.getInstanceOf("assign");
                  String value = fig.atributos.get(attr);
                  if(attr.equals("color")) value = value + "_";
                  if(attr.equals("filled")){
                     attr = "thickness";
                     if(value.equals("True")) value = "0";
                     else value = "1";
                  }
                  change.add("var", fig.id + "_." + attr);
                  change.add("value", value);
                  res.add("stat", change.render());
               }
            }
         }
         return res;
      }catch (Exception e){
         return null;
      }
      
   }

   @Override public ST visitAnimationTranslate(geometricsParser.AnimationTranslateContext ctx) {
      translateObj = new ArrayList<ST>();
      int start = Integer.parseInt(ctx.start.getText()) * 100;
      int end = Integer.parseInt(ctx.end.getText()) * 100;
      String figureID = ctx.ID().getText();
      if(mapa.containsKey(figureID)){
         ArrayList<Objeto> lista = mapa.get(figureID);
         for (Objeto objeto : lista) {
            ST res = templates.getInstanceOf("translateInterval");
            res.add("stat", visit(ctx.expr(0)).render());
            res.add("stat", visit(ctx.expr(1)).render());
            res.add("maior", ">");
            res.add("menor", "<");
            res.add("start", Integer.toString(start));
            res.add("end", Integer.toString(end));
            res.add("var", objeto.id);
            res.add("x", ctx.expr(0).varName);
            res.add("y", ctx.expr(1).varName);
            translateObj.add(res);
         }
      }else{
         System.err.printf(red+"Error line %3d ->Figure not initialized!\n",ctx.start.getLine());
      }
      return null;
   }

   @Override public ST visitAnimationRotate(geometricsParser.AnimationRotateContext ctx) {
      translateObj = new ArrayList<ST>();
      int start = Integer.parseInt(ctx.start.getText()) * 100;
      int end = Integer.parseInt(ctx.end.getText()) * 100;
      String figureID = ctx.ID().getText();
      if(mapa.containsKey(figureID)){
         ArrayList<Objeto> lista = mapa.get(figureID);
         for (Objeto objeto : lista) {
            ST res = templates.getInstanceOf("rotateInterval");
            res.add("stat", visit(ctx.expr(0)).render());
            res.add("stat", visit(ctx.expr(1)).render());
            res.add("stat", visit(ctx.expr(2)).render());
            res.add("maior", ">");
            res.add("menor", "<");
            res.add("start", Integer.toString(start));
            res.add("end", Integer.toString(end));
            res.add("angle", ctx.expr(0).varName);
            res.add("var", objeto.id);
            res.add("xc", ctx.expr(1).varName);
            res.add("yc", ctx.expr(2).varName);
            translateObj.add(res);
         }
      }else{
         System.err.printf(red+"Error line %3d ->Figure not initialized!\n",ctx.start.getLine());
      }
      return null;
   }

   @Override public ST visitRotateObj(geometricsParser.RotateObjContext ctx) {
      translateObj = new ArrayList<ST>();
      String figureID = ctx.ID().getText();
      if(mapa.containsKey(figureID)){
         ArrayList<Objeto> lista = mapa.get(figureID);
         for (Objeto objeto : lista) {
            ST res = templates.getInstanceOf("rotate");
            res.add("stat", visit(ctx.expr(0)).render());
            res.add("stat", visit(ctx.expr(1)).render());
            res.add("stat", visit(ctx.expr(2)).render());
            res.add("angle", ctx.expr(0).varName);
            res.add("var", objeto.id);
            res.add("xc", ctx.expr(1).varName);
            res.add("yc", ctx.expr(2).varName);
            translateObj.add(res);
         }
      }else{
         System.err.printf(red+"Error line %3d ->Figure not initialized!\n",ctx.start.getLine());
      }
      return null;
   }

   @Override public ST visitTranslateObj(geometricsParser.TranslateObjContext ctx) {

      translateObj = new ArrayList<ST>();
      String figureID = ctx.ID().getText();
      if(mapa.containsKey(figureID)){
         ArrayList<Objeto> lista = mapa.get(figureID);
         for (Objeto objeto : lista) {
            ST res = templates.getInstanceOf("translate");
            res.add("stat", visit(ctx.expr(0)).render());
            res.add("stat", visit(ctx.expr(1)).render());
            res.add("var", objeto.id);
            res.add("x", ctx.expr(0).varName);
            res.add("y", ctx.expr(1).varName);
            translateObj.add(res);
         }
      }else{
         System.err.printf(red+"Error line %3d ->Figure not initialized!\n",ctx.start.getLine());
      }
      return null;
   }

   @Override public ST visitDisplaySize(geometricsParser.DisplaySizeContext ctx) {
      ST res = templates.getInstanceOf("display");
      res.add("x", ctx.x.getText());
      res.add("y", ctx.y.getText());
      res.add("name",ctx.name.getText().split("\"")[1]);
      return res;
   }

   @Override public ST visitExprDeclID(geometricsParser.ExprDeclIDContext ctx) {
      try{
         ST res = templates.getInstanceOf("assign");
         res.add("stat", visit(ctx.expr()).render());
         res.add("var", ctx.ID().getText()+"_");
         res.add("value", ctx.expr().varName);
         return res; 
      }
      catch(Exception e){
         return null;
      }
   }

   @Override public ST visitExprDeclIDString(geometricsParser.ExprDeclIDStringContext ctx){
      ST res = templates.getInstanceOf("assign");
      res.add("stat", "");
      res.add("var", ctx.ID().getText()+"_");
      String valor = ctx.String().getText();
      valor = valor.replace("}","_}");
      res.add("value", "f"+valor);
      return res;
   }

   @Override public ST visitExprDeclAttr(geometricsParser.ExprDeclAttrContext ctx) {
      ST res = templates.getInstanceOf("assign");
      res.add("stat", visit(ctx.expr()).render());
      visit(ctx.getAttribute());
      if(globalID.contains("filled")){
         if(ctx.expr().getText().equals("True")){
            res.add("value", "0");
         }else if(ctx.expr().getText().equals("False")){
            res.add("value", "1");
         }
         globalID = globalID.replace("filled", "thickness");
         res.add("var", globalID);
         return res;
      }else{
         res.add("var", globalID);
         res.add("value", ctx.expr().varName);
      }  
      return res;
   }

   @Override public ST visitIfStat(geometricsParser.IfStatContext ctx) {
      try{
      ST res = templates.getInstanceOf("conditional");
      res.add("stat", visit(ctx.expr()).render());
      res.add("var", ctx.expr().varName);
      res.add("stat_true", visit(ctx.trueSL).render());
      if(ctx.falseSL != null){
         res.add("stat_false", visit(ctx.falseSL).render());
      }
      return res;
      }catch(Exception e){return null;}
   }

   @Override public ST visitForeverStat(geometricsParser.ForeverStatContext ctx) {
      ST res = templates.getInstanceOf("forever");
      for (int i = 0; i < ctx.statList().stat().size(); i++) {
         res.add("stat_inside", visit(ctx.statList().stat(i)).render());
      }
      return res;
   }

   @Override public ST visitExprAddSub(geometricsParser.ExprAddSubContext ctx) {
      ctx.varName = newVarName(); 
      return binaryExpression(ctx, visit(ctx.e1).render(), visit(ctx.e2).render(), ctx.varName, ctx.e1.varName, ctx.op.getText(), ctx.e2.varName);
   }

   @Override public ST visitExprGetIDs(geometricsParser.ExprGetIDsContext ctx) {
      ST res = templates.getInstanceOf("stats");
      ST decl = templates.getInstanceOf("decl");
      String id = ctx.ID().getText() + "_";
      ctx.varName = newVarName();
      decl.add("var", ctx.varName);
      decl.add("value", id);
      res.add("stat", decl.render());
      return res;
   }

   @Override public ST visitExprReadTimer(geometricsParser.ExprReadTimerContext ctx){
      ST res = templates.getInstanceOf("assign");
      ctx.varName = newVarName();
      res.add("var", ctx.varName);
      res.add("value", "math.floor(internal_timer/100)");
      return res;
   }

   @Override public ST visitExprCollision(geometricsParser.ExprCollisionContext ctx) {
      try{
         ST res = templates.getInstanceOf("assign");
         ArrayList<Objeto> temp = mapa.get(ctx.ID().getText());
         String total = "";
         for(Objeto atual : temp){
            total += atual.id + ".collideEdge(WIDTH, HEIGHT)" + " or ";
         }
         total = total.substring(0, total.length()-4);
         ctx.varName = newVarName();
         res.add("var", ctx.varName);
         res.add("value", total);
         return res;
      }
      catch(Exception e){
         return null;
      }
      
   }

   @Override public ST visitExprCollisionFigs(geometricsParser.ExprCollisionFigsContext ctx){
      ST res = templates.getInstanceOf("assign");
      ArrayList<Objeto> temp1 = mapa.get(ctx.ID(0).getText());
      ArrayList<Objeto> temp2 = mapa.get(ctx.ID(1).getText());
      String total = "";
      for(Objeto atual1 : temp1){
         if(!atual1.type.equals("line")){
            for(Objeto atual2 : temp2){
               if(!atual2.type.equals("line")){
                  res.add("stat", atual1.id+".update()");
                  res.add("stat", atual2.id+".update()");
                  total += "figureCollision(" + atual1.id + ".getRect()" + "," + atual2.id + ".getRect()" + ")" + " or ";
               }
            }
         }
      }
      total = total.substring(0, total.length()-4);
      ctx.varName = newVarName();
      res.add("var", ctx.varName);
      res.add("value", total);
      return res;
   }

   @Override public ST visitExprParent(geometricsParser.ExprParentContext ctx) {
      ST res = visit(ctx.expr());
      ctx.varName = ctx.expr().varName;
      return res;
   }

   @Override public ST visitExprReal(geometricsParser.ExprRealContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitExprInteger(geometricsParser.ExprIntegerContext ctx) {
      ST res = templates.getInstanceOf("assign");
      ctx.varName = newVarName();
      res.add("var", ctx.varName);
      res.add("value", ctx.Integer().getText());
      return res;
   }

   @Override public ST visitExprBoolean(geometricsParser.ExprBooleanContext ctx) {
      ST res = templates.getInstanceOf("assign");
      ctx.varName = newVarName();
      res.add("var", ctx.varName);
      res.add("value", ctx.BooleanLiteral().getText());
      return res;
   }
   
   @Override public ST visitExprRandom(geometricsParser.ExprRandomContext ctx) {
      visit(ctx.random());
      ST res = templates.getInstanceOf("assign");
      ctx.varName = newVarName();
      res.add("var", ctx.varName);
      res.add("value", globalID);
      return res;
   }

   @Override public ST visitExperGetAttr(geometricsParser.ExperGetAttrContext ctx) {
      visit(ctx.getAttribute());
      ST res = templates.getInstanceOf("assign");
      ctx.varName = newVarName();
      res.add("var", ctx.varName);
      res.add("value", globalID);
      return res;
   }

   @Override public ST visitExprMultDivMod(geometricsParser.ExprMultDivModContext ctx) {
      ctx.varName = newVarName(); 
      return binaryExpression(ctx, visit(ctx.e1).render(), visit(ctx.e2).render(), ctx.varName, ctx.e1.varName, ctx.op.getText(), ctx.e2.varName);
   }

   @Override public ST visitExprRelation(geometricsParser.ExprRelationContext ctx) {
      try{
         String op;
         if(ctx.op.getText().equals("=")){
            op = "==";
         }else if(ctx.op.getText().equals("/=")){
            op = "!=";
         }else{
            op = ctx.op.getText();
         }
         ctx.varName = newVarName(); 
         return binaryExpression(ctx, visit(ctx.e1).render(), visit(ctx.e2).render(), ctx.varName, ctx.e1.varName, op, ctx.e2.varName);
      }catch(Exception e){return null;}
   }

   @Override public ST visitGetAttr(geometricsParser.GetAttrContext ctx) {
      if(mapa.containsKey(ctx.figure.getText())){
         ArrayList<Objeto> temp = mapa.get(ctx.figure.getText());
         boolean flag = false;
         for (int i = 0; i < temp.size(); i++) {
            try{
               if(temp.get(i).id.equals(ctx.objeto.getText()+"_")){
                  globalID = ctx.objeto.getText() + "_" + "." + ctx.param.getText();
                  flag = true;
               }
            } catch(NullPointerException e){
               System.err.printf(red+"Error line %3d -> Can only change attribute of primitive shape!\n",ctx.start.getLine());
               return null;
            }
            
         }
         if(!flag) System.err.printf(red+"Error line %3d -> %s is not in %s\n",ctx.start.getLine(),ctx.objeto.getText(), ctx.figure.getText());
      }else{
         System.err.println("Error line "+ctx.start.getLine()+" -> Figure " + ctx.figure.getText() + " does not exist!");
      }
      return null;
   }

   @Override public ST visitCreateFigureObj(geometricsParser.CreateFigureObjContext ctx) {
      try{
         String figureID = ctx.ID().getText();
         ArrayList<Objeto> temp = new ArrayList<Objeto>();
         ST res = templates.getInstanceOf("stats");
         for (int i = 0; i < ctx.constructor().size(); i++) {
            res.add("stat", visit(ctx.constructor(i)).render());
            Objeto novo = new Objeto(globalID, globalTYPE);
            temp.add(novo);
         }
         mapa.put(figureID, temp);
         return res;
      }
      catch(Exception e){return null;}
   }

   @Override public ST visitCreateFigureFig(geometricsParser.CreateFigureFigContext ctx) {
      String figureID = ctx.ID(0).getText();
      ArrayList<Objeto> temp = new ArrayList<Objeto>();
      ST res = templates.getInstanceOf("stats");
      for (int i = 1; i < ctx.ID().size(); i++) {
         String figAtual = ctx.ID(i).getText();
         if(mapa.containsKey(figAtual)){
            ArrayList<Objeto> atual = mapa.get(figAtual);
            for(int j = 0; j < atual.size(); j++){
               temp.add(atual.get(j));
            }
         }
      }
      mapa.put(figureID, temp);
      return res;
   }

   @Override public ST visitCreateCircle(geometricsParser.CreateCircleContext ctx) {
      globalID = ctx.dest.getText() + "_";
      globalTYPE = "circle";
      ST res = templates.getInstanceOf("createCircle");
      res.add("var", globalID);
      res.add("x", ctx.x.getText());
      res.add("y", ctx.y.getText());
      res.add("r", ctx.r.getText());
      return res;
   }

   @Override public ST visitCreateLine(geometricsParser.CreateLineContext ctx) {
      globalID = ctx.dest.getText() + "_";
      globalTYPE = "line";
      ST res = templates.getInstanceOf("createLine");
      res.add("var", globalID);
      res.add("x1", ctx.x1.getText());
      res.add("y1", ctx.y1.getText());
      res.add("x2", ctx.x2.getText());
      res.add("y2", ctx.y2.getText());
      return res;
   }

   @Override public ST visitCreateSquare(geometricsParser.CreateSquareContext ctx) {
      globalID = ctx.dest.getText() + "_";
      globalTYPE = "square";
      ST res = templates.getInstanceOf("createRectangle");
      res.add("var", globalID);
      res.add("x", ctx.x1.getText());
      res.add("y", ctx.y1.getText());
      res.add("w", ctx.lengthx.getText());
      res.add("h", ctx.lengthx.getText());

      return res;
   }

   @Override public ST visitCreateTriangle(geometricsParser.CreateTriangleContext ctx) {
      globalID = ctx.dest.getText() + "_";
      globalTYPE = "triangle";
      ST res = templates.getInstanceOf("createTriangle");
      res.add("var", globalID);
      res.add("x1", ctx.x1.getText());
      res.add("y1", ctx.y1.getText());
      res.add("x2", ctx.x2.getText());
      res.add("y2", ctx.y2.getText());
      res.add("x3", ctx.x3.getText());
      res.add("y3", ctx.y3.getText());

      return res;
   }

   @Override public ST visitCreateRect(geometricsParser.CreateRectContext ctx) {
      globalID = ctx.dest.getText() + "_";
      globalTYPE = "rect";
      ST res = templates.getInstanceOf("createRectangle");
      res.add("var", globalID);
      res.add("x", ctx.x1.getText());
      res.add("y", ctx.y1.getText());
      res.add("w", ctx.lengthx.getText());
      res.add("h", ctx.lengthy.getText());

      return res;
   }

   protected ST binaryExpression(ParserRuleContext ctx, String e1Stats, String e2Stats, String var, String e1Var, String op, String e2var){
      ST res = templates.getInstanceOf("binaryExpression");
      res.add("stat", e1Stats);
      res.add("stat", e2Stats);
      res.add("var", var);
      res.add("e1", e1Var);
      res.add("op", op);
      res.add("e2", e2var);
      return res;
   }

   protected String newVarName() {
      varCount++;
      return "v"+varCount;
   }

   protected int varCount = 0;
}
