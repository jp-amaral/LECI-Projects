import java.util.*;
class Square extends Figura {
    HashMap <String, String> atributos;
    String id;
    int x;
    int y;
    int comprimento;

    Square(String id, int x, int y, int comprimento){
        super("square", id);
        this.id = id;
        this.x = x;
        this.y = y;
        this.comprimento = comprimento;
        atributos = new HashMap<String, String>();
    }
    @Override public String toString(){
        return "type->"+super.type+"\nid->"+id+"\nx->"+x+"\ny->"+y+"\ncomprimento->"+comprimento+ "\n"  + super.atributosToString() + "\n\n";
    }
}