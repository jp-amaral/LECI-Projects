import java.util.HashMap;
public class Figura{
    String type;        // circle,square,rectangle,triangle
    String id;
    HashMap <String, String> atributos;
    
    public Figura(String type, String id){
        this.type = type;
        this.id = id;
        atributos = new HashMap <String, String>();
    }

    void putAtribute(String key, String value){
        atributos.put(key, value);
    }

    public String atributosToString(){
        return atributos.toString();
    }
}

