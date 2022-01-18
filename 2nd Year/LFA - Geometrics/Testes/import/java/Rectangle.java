class Rectangle extends Figura {
    HashMap <String, String> atributos;
    String id;
    int x;
    int y;
    int comprimeto;
    int largura;

    Rectangle(String id, int x, int y, int comprimeto,int largura){
        super("rectangle");
        this.id = id;
        this.x = x;
        this.y = y;
        this.comprimeto = comprimeto;
        this.largura = largura;
        atributos = new HashMap<String, String>();
    }

    void putAtribute(String key, String value){
        atributos.put(key, value);
    }
}