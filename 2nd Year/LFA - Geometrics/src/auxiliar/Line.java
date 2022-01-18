public class Line extends Figura{
          String id;
          int x1,x2,y1,y2;

          Line(String id, int x1, int x2, int y1, int y2){
                    super("line", id);
                    this.id = id;
                    this.x1 = x1;
                    this.x2 = x2;
                    this.y1 = y1;
                    this.y2 = y2;

          }

          @Override public String toString(){
                    return "type->"+super.type+"\nid->"+id+"\nx1->"+x1+"\ny1->"+y1+"\nx2->"+x2+"\ny2->"+y2+"\n\n";
          }    

}
