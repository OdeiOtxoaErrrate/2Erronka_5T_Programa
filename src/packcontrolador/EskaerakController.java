package packcontrolador;

import packdao.EskaerakDAO;
import packmodelo.Eskaerak;

import java.util.List;

public class EskaerakController {

    private EskaerakDAO dao = new EskaerakDAO();

    public List<Eskaerak> listarEskaerak() {
        return dao.getAllEskaerak();
    }

    public boolean gehitu(Eskaerak e) {
        return dao.gehituEskaera(e);
    }

    public boolean aldatu(Eskaerak e) {
        return dao.aldatuEskaera(e);
    }

    public boolean ezabatu(int id) {
        return dao.ezabatuEskaera(id);
    }
}