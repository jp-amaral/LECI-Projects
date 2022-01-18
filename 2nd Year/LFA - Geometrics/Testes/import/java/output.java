import java.util.HashMap;
package java;
public class output {
    HashMap <String, Figura> mapa;
    public output() {
        mapa = new HashMap <String, Figura>();
        //###################################################
        Circle Circle1 = new Circle("circle1",10,10,30);
        Circle1.atributos.put("key", "value");
        mapa.put("/id da figura",Circle1);
        //###################################################
    }
    public HashMap<String, Figura> getMapa() {
        return mapa;
    }
}
