package packgui;

import packmodelo.Bezeroak;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModelBezeroak extends AbstractTableModel {

    private List<Bezeroak> lista;

    private final String[] columnas = {
            "ID", "Izena", "Abizenak", "NAN", "Telefonoa", "Email", "Helbidea"
    };

    public TableModelBezeroak(List<Bezeroak> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() { return lista.size(); }

    @Override
    public int getColumnCount() { return columnas.length; }

    @Override
    public String getColumnName(int col) { return columnas[col]; }

    @Override
    public Object getValueAt(int row, int col) {
        Bezeroak b = lista.get(row);

        return switch (col) {
            case 0 -> b.getId();
            case 1 -> b.getIzena();
            case 2 -> b.getAbizenak();
            case 3 -> b.getNan();
            case 4 -> b.getTelefonoa();
            case 5 -> b.getEmail();
            case 6 -> b.getHelbidea();
            default -> null;
        };
    }

    public Bezeroak getBezeroakAt(int row) {
        return lista.get(row);
    }

    public void addBezeroa(Bezeroak b) {
        lista.add(b);
        fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
    }

    public void updateBezeroa(int row, Bezeroak b) {
        lista.set(row, b);
        fireTableRowsUpdated(row, row);
    }

    public void removeBezeroa(int row) {
        lista.remove(row);
        fireTableRowsDeleted(row, row);
    }
}