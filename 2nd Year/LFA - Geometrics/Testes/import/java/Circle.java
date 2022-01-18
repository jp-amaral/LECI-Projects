class Circle extends Figura {
    HashMap <String, String> atributos;
    String id;
    int x;
    int y;
    int raio;
    Circle(String id, int x, int y, int raio){
        super("circle");
        this.id = id;
        this.x = x;
        this.y = y;
        this.raio = raio;
        atributos = new HashMap<String, String>();
    }

    void putAtribute(String key, String value){
        atributos.put(key, value);
    }
}