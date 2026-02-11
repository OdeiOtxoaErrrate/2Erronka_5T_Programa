package packmodelo;

public class EskaeraProduktuak {

    private int id;
    private Produktuak produktua;
    private int kantitatea;

    public EskaeraProduktuak(int id, Produktuak produktua, int kantitatea) {
        this.id = id;
        this.produktua = produktua;
        this.kantitatea = kantitatea;
    }

    public int getId() { return id; }
    public Produktuak getProduktua() { return produktua; }
    public int getKantitatea() { return kantitatea; }
}