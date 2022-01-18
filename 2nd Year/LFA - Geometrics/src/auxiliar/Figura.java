import java.util.HashMap;
public class Figura{
    HashMap <String, String> atributos;
    String type;        // circle,square,rectangle,triangle
    String id;
    
    public Figura(String type, String id){
        this.type = type;
        this.id = id;
        atributos = new HashMap<String, String>();
    }

    void putAtribute(String key, String value){
        atributos.put(key, value);
    }
}

