class Triangle extends Figura {
    HashMap <String, String> atributos;
    String id;
    int x1;
    int y1;
    int x2;
    int y2;
    int x3;
    int y3;
    Triangle(String id, int x1, int y1, int x2,int y2,int x3,int y3){
        super("triangle");
        this.id = id;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        atributos = new HashMap<String, String>();
    }

    void putAtribute(String key, String value){
        atributos.put(key, value);
    }
}