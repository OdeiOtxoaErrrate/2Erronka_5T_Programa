package packgui;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import packmodelo.Hornitzaileak;

public class TableModelHornitzaileak extends AbstractTableModel {

    private List<Hornitzaileak> lista;
    private String[] columnas = {"ID", "Izena", "Email", "Telefonoa"};

    public TableModelHornitzaileak(List<Hornitzaileak> lista) {
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
        Hornitzaileak h = lista.get(row);
        switch (col) {
            case 0: return h.getId();
            case 1: return h.getIzena();
            case 2: return h.getEmail();
            case 3: return h.getTelefonoa();
        }
        return null;
    }

    public Hornitzaileak getHornitzaileaAt(int row) {
        return lista.get(row);
    }

    public void addHornitzailea(Hornitzaileak h) {
        lista.add(h);
        fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
    }

    public void updateHornitzailea(int row, Hornitzaileak h) {
        lista.set(row, h);
        fireTableRowsUpdated(row, row);
    }

    public void removeHornitzailea(int row) {
        lista.remove(row);
        fireTableRowsDeleted(row, row);
    }
}