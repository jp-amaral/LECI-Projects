
import org.stringtemplate.v4.*;
import java.util.*;
public class AuxiliarCompiler extends auxiliarBaseVisitor<ST> {

   private STGroup templates = new STGroupFile("java.stg");

   HashMap<String, ArrayList<Figura>> mapa = new HashMap<String, ArrayList<Figura>>();

   Figura global;
   String globalAttr;

   @Override public ST visitProgram(auxiliarParser.ProgramContext ctx) {
      ST res = templates.getInstanceOf("module");
      res.add("stat",visit(ctx.statList()));
      return res;
   }

   @Override public ST visitStatList(auxiliarParser.StatListContext ctx) {
      ST res = templates.getInstanceOf("stats");
      for(auxiliarParser.StatContext sc: ctx.stat())
         res.add("stat", visit(sc));      
      return res;
   }

   @Override public ST visitStatCreateFig(auxiliarParser.StatCreateFigContext ctx) {
      ST res = templates.getInstanceOf("stats");
      res.add("stat",visit(ctx.createFigure()));
      //System.out.println(mapa);
      return res;
   }

   @Override public ST visitCreateFigureObj(auxiliarParser.CreateFigureObjContext ctx) {
      String figureID = ctx.ID().getText();
      ArrayList<Figura> temp = new ArrayList<Figura>();
      for (int i = 0; i < ctx.constructor().size(); i++) {
         visit(ctx.constructor(i));
         temp.add(global);

      }
      mapa.put(figureID, temp);

      ST res = templates.getInstanceOf("stats");

      for (Figura figura : temp) {
         if(figura.type.equals("circle")){
            Circle novo = (Circle)figura;
            ST create = templates.getInstanceOf("createCircle");
            create.add("id", novo.id);
            create.add("x", Integer.toString(novo.x));
            create.add("y", Integer.toString(novo.y));
            create.add("r", Integer.toString(novo.raio));
            res.add("stat", create.render());
         }else if(figura.type.equals("triangle")){
            Triangle novo = (Triangle)figura;
            ST create = templates.getInstanceOf("createTriangle");
            create.add("id",novo.id);
            create.add("x1", Integer.toString(novo.x1)); 
            create.add("y1", Integer.toString(novo.y1)); 
            create.add("x2", Integer.toString(novo.x2)); 
            create.add("y2", Integer.toString(novo.y2)); 
            create.add("x3", Integer.toString(novo.x3)); 
            create.add("y3", Integer.toString(novo.y3)); 
            res.add("stat", create.render());
         }else if(figura.type.equals("square")){
            Square novo = (Square)figura;
            ST create = templates.getInstanceOf("createSquare");
            create.add("id",novo.id);
            create.add("x", Integer.toString(novo.x));
            create.add("y", Integer.toString(novo.y));
            create.add("length", Integer.toString(novo.comprimento));
            res.add("stat", create.render());
         }else if(figura.type.equals("rectangle")){
            Rectangle novo = (Rectangle)figura;
            ST create = templates.getInstanceOf("createRect");
            create.add("id",novo.id);
            create.add("x", Integer.toString(novo.x));
            create.add("y", Integer.toString(novo.y));
            create.add("lengthx", Integer.toString(novo.comprimento));
            create.add("lengthy", Integer.toString(novo.largura));
            res.add("stat", create.render());
         }else if(figura.type.equals("line")){
            Line novo = (Line)figura;
            ST create = templates.getInstanceOf("createLine");
            create.add("id",novo.id);
            create.add("x1", Integer.toString(novo.x1));
            create.add("y1", Integer.toString(novo.y1));
            create.add("x2", Integer.toString(novo.x2));
            create.add("y2", Integer.toString(novo.y2));
            res.add("stat", create.render());
         }
         for(String key_set : figura.atributos.keySet()){
            ST attrs = templates.getInstanceOf("putAttr");
            attrs.add("id", figura.id);
            attrs.add("key", key_set);
            attrs.add("value", figura.atributos.get(key_set));
            res.add("stat", attrs.render());
         }
      }
      res.add("stat", "temp = new ArrayList<Figura>();");

      for (Figura figura : temp) {
         res.add("stat", "temp.add("+figura.id+");");
      }
      String extra = '"' + figureID + '"';
      res.add("stat", "mapa.put("+extra+",temp);");

      return res;
   }

   @Override public ST visitCreateCircle(auxiliarParser.CreateCircleContext ctx) {
      String id = ctx.id.getText();
      int x = Integer.parseInt(ctx.x.getText());
      int y = Integer.parseInt(ctx.y.getText());
      int r = Integer.parseInt(ctx.r.getText());
      global = new Circle(id, x, y, r);
      try{
         for(int i = 0; i < ctx.Param().size(); i++){
            visit(ctx.attribute(i));
            global.putAtribute(ctx.Param(i).getText(), globalAttr);
         }
      } catch(Exception e){

      }
      return null;
   }

   @Override public ST visitCreateRect(auxiliarParser.CreateRectContext ctx) {
      String id = ctx.id.getText();
      global = new Rectangle(id, Integer.parseInt(ctx.x1.getText()), Integer.parseInt(ctx.y1.getText()), Integer.parseInt(ctx.lengthx.getText()), Integer.parseInt(ctx.lengthy.getText()));
      try{
         for(int i = 0; i < ctx.Param().size();i++){
            visit(ctx.attribute(i));
            global.putAtribute(ctx.Param(i).getText(), globalAttr);
         }
      }catch(Exception e){

      }
      return null;
   }

   @Override public ST visitCreateSquare(auxiliarParser.CreateSquareContext ctx) {
      String id = ctx.id.getText();
      global = new Square(id, Integer.parseInt(ctx.x1.getText()), Integer.parseInt(ctx.y1.getText()), Integer.parseInt(ctx.lengthx.getText()));
      try{
         for(int i = 0; i < ctx.Param().size();i++){
            visit(ctx.attribute(i));
            global.putAtribute(ctx.Param(i).getText(), globalAttr);
         }
      }catch(Exception e){

      }
      return null;
   }

   @Override public ST visitCreateTriangle(auxiliarParser.CreateTriangleContext ctx) {
      String id = ctx.id.getText();
      global = new Triangle(id, Integer.parseInt(ctx.x1.getText()), Integer.parseInt(ctx.y1.getText()), Integer.parseInt(ctx.x2.getText()), Integer.parseInt(ctx.y2.getText()), Integer.parseInt(ctx.x3.getText()), Integer.parseInt(ctx.y3.getText()));
      try{
         for(int i = 0; i < ctx.Param().size();i++){
            visit(ctx.attribute(i));
            global.putAtribute(ctx.Param(i).getText(), globalAttr);
         }
      }catch(Exception e){

      }
      return null;
   }

   @Override public ST visitCreateLine(auxiliarParser.CreateLineContext ctx) {
      String id = ctx.id.getText();
      global = new Line(id, Integer.parseInt(ctx.x1.getText()), Integer.parseInt(ctx.x2.getText()), Integer.parseInt(ctx.y1.getText()), Integer.parseInt(ctx.y2.getText()));
      try{
         for(int i = 0; i < ctx.Param().size();i++){
            visit(ctx.attribute(i));
            global.putAtribute(ctx.Param(i).getText(), globalAttr);
         }
      }catch(Exception e){

      }
      return null;
   }

   @Override public ST visitAttribute(auxiliarParser.AttributeContext ctx) {
      try{
         globalAttr = ctx.ID().getText();
      }catch(Exception e){
         globalAttr = ctx.Integer().getText();
      }
      return null;
   }
}

