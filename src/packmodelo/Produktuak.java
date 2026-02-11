package packmodelo;

public class Produktuak {

    private int id;
    private String izena;
    private String modeloa;
    private int prezioa;
    private String marka;
    private int stock;
    private int sekzioa;
    private String argazkia;
    private int hornitzaileId;

    public Produktuak(int id, String izena, String modeloa, int prezioa,
                      String marka, int stock, int sekzioa, String argazkia,
                      int hornitzaileId) {

        this.id = id;
        this.izena = izena;
        this.modeloa = modeloa;
        this.prezioa = prezioa;
        this.marka = marka;
        this.stock = stock;
        this.sekzioa = sekzioa;
        this.argazkia = argazkia;
        this.hornitzaileId = hornitzaileId;
    }

    public int getId() { return id; }
    public String getIzena() { return izena; }
    public String getModeloa() { return modeloa; }
    public int getPrezioa() { return prezioa; }
    public String getMarka() { return marka; }
    public int getStock() { return stock; }
    public int getSekzioa() { return sekzioa; }
    public String getArgazkia() { return argazkia; }
    public int getHornitzaileId() { return hornitzaileId; }
}