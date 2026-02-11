package packmodelo;

public class Bezeroak {

    private int id;
    private String helbidea;
    private String telefonoa;
    private String izena;
    private String abizenak;
    private String nan;
    private String email;
    private String pasahitza;

    public Bezeroak(int id, String helbidea, String telefonoa, String izena,
                    String abizenak, String nan, String email, String pasahitza) {

        this.id = id;
        this.helbidea = helbidea;
        this.telefonoa = telefonoa;
        this.izena = izena;
        this.abizenak = abizenak;
        this.nan = nan;
        this.email = email;
        this.pasahitza = pasahitza;
    }

    public int getId() { return id; }
    public String getHelbidea() { return helbidea; }
    public String getTelefonoa() { return telefonoa; }
    public String getIzena() { return izena; }
    public String getAbizenak() { return abizenak; }
    public String getNan() { return nan; }
    public String getEmail() { return email; }
    public String getPasahitza() { return pasahitza; }
}