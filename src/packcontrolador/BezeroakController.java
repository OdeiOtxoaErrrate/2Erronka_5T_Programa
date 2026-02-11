package packcontrolador;

import packdao.BezeroakDAO;
import packmodelo.Bezeroak;

import java.util.List;

public class BezeroakController {

    private BezeroakDAO dao = new BezeroakDAO();

    public List<Bezeroak> listarBezeroak() {
        return dao.getAllBezeroak();
    }

    public boolean gehitu(Bezeroak b) {
        return dao.gehituBezeroa(b);
    }

    public boolean aldatu(Bezeroak b) {
        return dao.aldatuBezeroa(b);
    }

    public boolean ezabatu(int id) {
        return dao.ezabatuBezeroa(id);
    }
}