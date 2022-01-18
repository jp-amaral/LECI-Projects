import java.util.*;
class Rectangle extends Figura {
    String id;
    int x;
    int y;
    int comprimento;
    int largura;

    Rectangle(String id, int x, int y, int comprimento,int largura){
        super("rectangle", id);
        this.id = id;
        this.x = x;
        this.y = y;
        this.comprimento = comprimento;
        this.largura = largura;
    }
    @Override public String toString(){
        return "type->"+super.type+"\nid->"+id+"\nx->"+x+"\ny->"+y+"\ncomprimento->"+comprimento+"\nlargura->"+largura+"\n\n";
    }
}