import java.util.*;
class Circle extends Figura {
    HashMap <String, String> atributos;
    String id;
    int x;
    int y;
    int raio;
    Circle(String id, int x, int y, int raio){
        super("circle", id);
        this.id = id;
        this.x = x;
        this.y = y;
        this.raio = raio;
        atributos = new HashMap<String, String>();
    }

    @Override public String toString(){
        return "type->"+super.type+"\nid->"+id+"\nx->"+x+"\ny->"+y+"\nraio->"+raio+"\n" + super.atributosToString() + "\n\n";
    }
}