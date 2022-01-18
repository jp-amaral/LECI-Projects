import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SizeAction;

public class AuxiliarSemantic extends auxiliarBaseVisitor<String> {

   static ArrayList <String> cores = new ArrayList<String>();
   static ArrayList <String> basedados = new ArrayList<String>();
   static boolean compile = true;
   static String color_yellow= "\u001B[33m";
   static String reset_color = "\u001B[0m";
   static String color_red = "\u001B[31m";
   @Override public String visitProgram(auxiliarParser.ProgramContext ctx) {
      cores.add("WHITE");
      cores.add("BLACK");
      cores.add("BLUE");
      cores.add("YELLOW");
      cores.add("RED");
      cores.add("GREEN");
      cores.add("GRAY");
      cores.add("ORANGE");
      cores.add("PURPLE");
      visit(ctx.statList());
      if(compile){
         String color_rgb = "\u001B[32m";       
         System.out.println(color_rgb + "File is compiled successfully !!" + reset_color);
      }
      return "";
   }

   @Override public String visitStatList(auxiliarParser.StatListContext ctx) {
      for(auxiliarParser.StatContext sc: ctx.stat()){
         String aux = visit(sc);
         if(aux == null){
            compile = false;
         }
      }
      return "statList";
   }

   @Override public String visitStatCreateFig(auxiliarParser.StatCreateFigContext ctx) {
      return visit(ctx.createFigure());
   }

   @Override public String visitCreateFigureObj(auxiliarParser.CreateFigureObjContext ctx) {
      String id = ctx.id.getText();
      if(!basedados.contains(id)) basedados.add(id);
      else{
         System.err.printf(color_red+"Error line %3d ->  Figure %s already exists!\n",ctx.start.getLine(),id);
         return null;
      }
      for (int i = 0; i < ctx.constructor().size(); i++){
         if( visit(ctx.constructor(i)) == null){
            return null;
         }
      }
      return "";
   }

   @Override public String visitCreateCircle(auxiliarParser.CreateCircleContext ctx) {
      String id = ctx.id.getText();
      if(!basedados.contains(id)) basedados.add(id);
      else{
         System.err.printf(color_red+"Error line %3d ->  Circle %s already exists!\n",ctx.start.getLine(),id);
         return null;
      }
      for(int param=0; param < ctx.Param().size();param++){
         String tipo1 = visit(ctx.attribute(param));//number,boolean,string [NUNCA É NULL]
         String tipo2 = ctx.Param(param).getText();  // hidden, thickness,color,filled
         String aux = ctx.attribute(param).getText();
         switch (tipo2){
            case "hidden":
               if(!tipo1.equals("boolean")){
                  System.err.printf(color_red+"Error line %3d -> [%s] : hidden can only be of type boolean\n",ctx.start.getLine(),aux);
                  return null;
               }
               break;
            case "thickness":
               if(!tipo1.equals("number")){
                  System.err.printf(color_red+"Error line %3d -> [%s] : thickness can only be of type number\n",ctx.start.getLine(),aux);
                  return null;
               }
               break;
            case "color":
               try{
                  Integer.parseInt(aux);
                  System.err.printf(color_red+"Error line %3d -> [%s] : Color can only be of type string\n",ctx.start.getLine(),aux);
                  return null;
               }catch(NumberFormatException e){}
               if(!cores.contains(aux) || !tipo1.equals("string") ){
                  
                  System.out.printf("%sWarning line %3d -> You have to define %s in the geometrics file%s\n",color_yellow,ctx.start.getLine(),aux,reset_color);
               }
               break;
            case "filled":
               if(!tipo1.equals("boolean")){
                  System.err.printf(color_red+"Error line %3d -> [%s] : filled can only be of type boolean\n",ctx.start.getLine(),aux);
                  return null;
               }
               break;
            default:
               System.err.printf(color_red+"Error line %3d -> [%s]: You cant change Figures with this atribute\n",ctx.start.getLine(),ctx.param.getText());
               return null;
         }
      }
      return "null";
   }

   @Override public String visitCreateRect(auxiliarParser.CreateRectContext ctx) {
      String id = ctx.id.getText();
      if(!basedados.contains(id)) basedados.add(id);
      else{
         System.err.printf(color_red+"Error line %3d ->  Rectangle %s already exists!\n",ctx.start.getLine(),id);
         return null;
      }
      for(int param=0; param < ctx.Param().size();param++){
         String tipo1 = visit(ctx.attribute(param));//number,boolean,string [NUNCA É NULL]
         String tipo2 = ctx.Param(param).getText();  // hidden, thickness,color,filled
         String aux = ctx.attribute(param).getText();
         switch (tipo2){
            case "hidden":
               if(!tipo1.equals("boolean")){
                  System.err.printf(color_red+"Error line %3d -> [%s] : hidden can only be of type boolean\n",ctx.start.getLine(),aux);
                  return null;
               }
               break;
            case "thickness":
               if(!tipo1.equals("number")){
                  System.err.printf(color_red+"Error line %3d -> [%s] : thickness can only be of type number\n",ctx.start.getLine(),aux);
                  return null;
               }
               break;
            case "color":
               try{
                  Integer.parseInt(aux);
                  System.err.printf(color_red+"Error line %3d -> [%s] : Color can only be of type string\n",ctx.start.getLine(),aux);
                  return null;
               }catch(NumberFormatException e){}
               if(!cores.contains(aux) || !tipo1.equals("string") ){
                  System.out.printf("%sWarning line %3d -> You have to define %s in the geometrics file%s\n",color_yellow,ctx.start.getLine(),aux,reset_color);
               }
               break;
            case "filled":
               if(!tipo1.equals("boolean")){
                  System.err.printf(color_red+"Error line %3d -> [%s] : filled can only be of type boolean\n",ctx.start.getLine(),aux);
                  return null;
               }
               break;
            default:
               System.err.printf(color_red+"Error line %3d -> [%s]: You cant change Figures with this atribute\n",ctx.start.getLine(),ctx.param.getText());
               return null;
         }
      }
      return "null";
   }

   @Override public String visitCreateSquare(auxiliarParser.CreateSquareContext ctx) {
      String id = ctx.id.getText();
      if(!basedados.contains(id)) basedados.add(id);
      else{
         System.err.printf(color_red+"Error line %3d ->  Square %s already exists!\n",ctx.start.getLine(),id);
         return null;
      }
      for(int param=0; param < ctx.Param().size();param++){
         String tipo1 = visit(ctx.attribute(param));//number,boolean,string [NUNCA É NULL]
         String tipo2 = ctx.Param(param).getText();  // hidden, thickness,color,filled
         String aux = ctx.attribute(param).getText();
         switch (tipo2){
            case "hidden":
               if(!tipo1.equals("boolean")){
                  System.err.printf(color_red+"Error line %3d -> [%s] : hidden can only be of type boolean\n",ctx.start.getLine(),aux);
                  return null;
               }
               break;
            case "thickness":
               if(!tipo1.equals("number")){
                  System.err.printf(color_red+"Error line %3d -> [%s] : thickness can only be of type number\n",ctx.start.getLine(),aux);
                  return null;
               }
               break;
            case "color":
               try{
                  Integer.parseInt(aux);
                  System.err.printf(color_red+"Error line %3d -> [%s] : Color can only be of type string\n",ctx.start.getLine(),aux);
                  return null;
               }catch(NumberFormatException e){}
               if(!cores.contains(aux) || !tipo1.equals("string") ){
                  System.out.printf("%sWarning line %3d -> You have to define %s in the geometrics file%s\n",color_yellow,ctx.start.getLine(),aux,reset_color);
               }
               break;
            case "filled":
               if(!tipo1.equals("boolean")){
                  System.err.printf(color_red+"Error line %3d -> [%s] : filled can only be of type boolean\n",ctx.start.getLine(),aux);
                  return null;
               }
               break;
            default:
               System.err.printf(color_red+"Error line %3d -> [%s]: You cant change Figures with this atribute\n",ctx.start.getLine(),ctx.param.getText());
               return null;
         }
      }
      return "null";
   }

   @Override public String visitCreateLine(auxiliarParser.CreateLineContext ctx) {
      String id = ctx.id.getText();
      if(!basedados.contains(id)) basedados.add(id);
      else{
         System.err.printf(color_red+"Error line %3d ->  Line %s already exists!\n",ctx.start.getLine(),id);
         return null;
      }
      for(int param=0; param < ctx.Param().size();param++){
         String tipo1 = visit(ctx.attribute(param));//number,boolean,string [NUNCA É NULL]
         String tipo2 = ctx.Param(param).getText();  // hidden, thickness,color,filled
         String aux = ctx.attribute(param).getText();
         switch (tipo2){
            case "hidden":
               if(!tipo1.equals("boolean")){
                  System.err.printf(color_red+"Error line %3d -> [%s] : hidden can only be of type boolean\n",ctx.start.getLine(),aux);
                  return null;
               }
               break;
            case "thickness":
               if(!tipo1.equals("number")){
                  System.err.printf(color_red+"Error line %3d -> [%s] : thickness can only be of type number\n",ctx.start.getLine(),aux);
                  return null;
               }
               break;
            case "color":
               try{
                  Integer.parseInt(aux);
                  System.err.printf(color_red+"Error line %3d -> [%s] : Color can only be of type string\n",ctx.start.getLine(),aux);
                  return null;
               }catch(NumberFormatException e){}
               if(!cores.contains(aux) || !tipo1.equals("string") ){
                  System.out.printf("%sWarning line %3d -> You have to define %s in the geometrics file%s\n",color_yellow,ctx.start.getLine(),aux,reset_color);
               }
               break;
            default:
               System.err.printf(color_red+"Error line %3d -> [%s]: You cant change Lines with this atribute\n",ctx.start.getLine(),ctx.param.getText());
               return null;
         }
      }
      return "null";
   }

   @Override public String visitCreateTriangle(auxiliarParser.CreateTriangleContext ctx) {
      String id = ctx.id.getText();
      if(!basedados.contains(id)) basedados.add(id);
      else{
         System.err.printf(color_red+"Error line %3d ->  Triangle %s already exists!\n",ctx.start.getLine(),id);
         return null;
      }
      for(int param=0; param < ctx.Param().size();param++){
         String tipo1 = visit(ctx.attribute(param));//number,boolean,string [NUNCA É NULL]
         String tipo2 = ctx.Param(param).getText();  // hidden, thickness,color,filled
         String aux = ctx.attribute(param).getText();
         switch (tipo2){
            case "hidden":
               if(!tipo1.equals("boolean")){
                  System.err.printf(color_red+"Error line %3d -> [%s] : hidden can only be of type boolean\n",ctx.start.getLine(),aux);
                  return null;
               }
               break;
            case "thickness":
               if(!tipo1.equals("number")){
                  System.err.printf(color_red+"Error line %3d -> [%s] : thickness can only be of type number\n",ctx.start.getLine(),aux);
                  return null;
               }
               break;
            case "color":
               try{
                  Integer.parseInt(aux);
                  System.err.printf(color_red+"Error line %3d -> [%s] : Color can only be of type string\n",ctx.start.getLine(),aux);
                  return null;
               }catch(NumberFormatException e){}
               if(!cores.contains(aux) || !tipo1.equals("string") ){
                  System.out.printf("%sWarning line %3d -> You have to define %s in the geometrics file%s\n",color_yellow,ctx.start.getLine(),aux,reset_color);
               }
               break;
            case "filled":
               if(!tipo1.equals("boolean")){
                  System.err.printf(color_red+"Error line %3d -> [%s] : filled can only be of type boolean\n",ctx.start.getLine(),aux);
                  return null;
               }
               break;
            default:
               System.err.printf(color_red+"Error line %3d -> [%s]: You cant change Figures with this atribute\n",ctx.start.getLine(),ctx.param.getText());
               return null;
         }
      }
      return "null";
   }

   @Override public String visitAttribute(auxiliarParser.AttributeContext ctx) {
      try{
         String attr = ctx.ID().getText();
         if(attr.equals("True") || attr.equals("False")){
            return "boolean";
         }else{
            return "string";
         }
      }catch(Exception e){
         Integer.parseInt(ctx.Integer().getText());
         return "number";
      }
   }
}
