package packmodelo;

public class Langileak {

    private int id;
    private String postua;
    private String izena;
    private String abizenak;
    private String nan;
    private String telefonoa;
    private String email;
    private String pasahitza;

    public Langileak(int id, String postua, String izena, String abizenak,
                     String nan, String telefonoa, String email, String pasahitza) {

        this.id = id;
        this.postua = postua;
        this.izena = izena;
        this.abizenak = abizenak;
        this.nan = nan;
        this.telefonoa = telefonoa;
        this.email = email;
        this.pasahitza = pasahitza;
    }

    public int getId() { return id; }
    public String getPostua() { return postua; }
    public String getIzena() { return izena; }
    public String getAbizenak() { return abizenak; }
    public String getNan() { return nan; }
    public String getTelefonoa() { return telefonoa; }
    public String getEmail() { return email; }
    public String getPasahitza() { return pasahitza; }
}