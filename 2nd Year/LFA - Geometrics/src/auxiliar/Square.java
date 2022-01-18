import java.util.*;
class Square extends Figura {
    String id;
    int x;
    int y;
    int comprimento;

    Square(String id, int x, int y, int comprimento){
        super("square",id);
        this.id = id;
        this.x = x;
        this.y = y;
        this.comprimento = comprimento;
    }
    @Override public String toString(){
        return "type->"+super.type+"\nid->"+id+"\nx->"+x+"\ny->"+y+"\ncomprimento->"+comprimento+"\n\n";
    }
}