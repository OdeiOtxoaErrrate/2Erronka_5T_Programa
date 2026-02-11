package packcontrolador;

import packdao.LangileakDAO;
import packmodelo.Langileak;

import java.util.List;

public class LangileakController {

    private LangileakDAO dao = new LangileakDAO();

    public List<Langileak> listarLangileak() {
        return dao.getAllLangileak();
    }

    public boolean gehitu(Langileak l) {
        return dao.gehituLangile(l);
    }

    public boolean aldatu(Langileak l) {
        return dao.aldatuLangile(l);
    }

    public boolean ezabatu(int id) {
        return dao.ezabatuLangile(id);
    }
}