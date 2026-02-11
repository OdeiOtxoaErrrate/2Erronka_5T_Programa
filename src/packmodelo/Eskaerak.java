package packmodelo;

public class Eskaerak {

    private int id;
    private int bezeroId;
    private String data;
    private double prezioa;
    private String bezeroIzena;
    private String produktuIzena;
    private int fakturaId;

    public Eskaerak(int id, int bezeroId, String data, double prezioa, String bezeroIzena, String produktuIzena, int fakturaId) {
        this.id = id;
        this.bezeroId = bezeroId;
        this.data = data;
        this.prezioa = prezioa;
        this.bezeroIzena = bezeroIzena;
        this.produktuIzena = produktuIzena;
        this.fakturaId = fakturaId;
    }

    public int getId() { return id; }
    public int getBezeroId() { return bezeroId; }
    public String getData() { return data; }
    public double getPrezioa() { return prezioa; }
    public String getBezeroIzena() { return bezeroIzena; }
    public String getProduktuIzena() { return produktuIzena; }
    public int getFakturaId() { return fakturaId; }
}