package packgui;

import packmodelo.Langileak;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModelLangileak extends AbstractTableModel {

    private List<Langileak> lista;

    private final String[] columnas = {
            "ID", "Postua", "Izena", "Abizenak", "NAN", "Telefonoa", "Email", "Pasahitza"
    };

    public TableModelLangileak(List<Langileak> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnas[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Langileak l = lista.get(row);

        return switch (col) {
            case 0 -> l.getId();
            case 1 -> l.getPostua();
            case 2 -> l.getIzena();
            case 3 -> l.getAbizenak();
            case 4 -> l.getNan();
            case 5 -> l.getTelefonoa();
            case 6 -> l.getEmail();
            case 7 -> l.getPasahitza();
            default -> null;
        };
    }

    public Langileak getLangileAt(int row) {
        return lista.get(row);
    }

    public void addLangile(Langileak l) {
        lista.add(l);
        fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
    }

    public void updateLangile(int row, Langileak l) {
        lista.set(row, l);
        fireTableRowsUpdated(row, row);
    }

    public void removeLangile(int row) {
        lista.remove(row);
        fireTableRowsDeleted(row, row);
    }
}