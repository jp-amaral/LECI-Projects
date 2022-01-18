class Square extends Figura {
    HashMap <String, String> atributos;
    String id;
    int x;
    int y;
    int comprimeto;

    Square(String id, int x, int y, int comprimeto){
        super("square");
        this.id = id;
        this.x = x;
        this.y = y;
        this.comprimeto = comprimeto;
        atributos = new HashMap<String, String>();
    }

    void putAtribute(String key, String value){
        atributos.put(key, value);
    }
}