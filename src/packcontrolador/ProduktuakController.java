package packcontrolador;

import packdao.ProduktuakDAO;
import packmodelo.Produktuak;

import java.util.List;

public class ProduktuakController {

    private ProduktuakDAO dao = new ProduktuakDAO();

    public List<Produktuak> listarProduktua() {
        return dao.getAllProduktua();
    }

    public boolean gehitu(Produktuak p) {
        return dao.gehituProduktua(p);
    }

    public boolean aldatu(Produktuak p) {
        return dao.aldatuProduktua(p);
    }

    public boolean ezabatu(int id) {
        return dao.ezabatuProduktua(id);
    }
}