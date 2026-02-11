package packcontrolador;

import java.util.List;
import packdao.HornitzaileakDAO;
import packmodelo.Hornitzaileak;

public class HornitzaileakController {

    private HornitzaileakDAO dao = new HornitzaileakDAO();

    public List<Hornitzaileak> listarHornitzaileak() {
        return dao.getAllHornitzaileak();
    }

    public boolean gehitu(Hornitzaileak h) {
        return dao.gehituHornitzailea(h);
    }

    public boolean aldatu(Hornitzaileak h) {
        return dao.aldatuHornitzailea(h);
    }

    public boolean ezabatu(int id) {
        return dao.ezabatuHornitzailea(id);
    }
}