package packmodelo;

public class Hornitzaileak {

    private int id;
    private String helbidea;
    private String izena;
    private String abizenak;
    private String nan;
    private String telefonoa;
    private String email;

    public Hornitzaileak(int id, String helbidea, String izena, String abizenak,
                         String nan, String telefonoa, String email) {

        this.id = id;
        this.helbidea = helbidea;
        this.izena = izena;
        this.abizenak = abizenak;
        this.nan = nan;
        this.telefonoa = telefonoa;
        this.email = email;
    }

    public int getId() { return id; }
    public String getHelbidea() { return helbidea; }
    public String getIzena() { return izena; }
    public String getAbizenak() { return abizenak; }
    public String getNan() { return nan; }
    public String getTelefonoa() { return telefonoa; }
    public String getEmail() { return email; }
}