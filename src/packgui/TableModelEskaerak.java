package packgui;

import packmodelo.Eskaerak;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModelEskaerak extends AbstractTableModel {

    private List<Eskaerak> lista;

    private final String[] columnas = {
            "ID", "Bezero ID", "Data", "Prezioa", "Bezero Izena", "Produktu Izena", "Faktura ID"
    };

    public TableModelEskaerak(List<Eskaerak> lista) {
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
        Eskaerak e = lista.get(row);

        return switch (col) {
            case 0 -> e.getId();
            case 1 -> e.getBezeroId();
            case 2 -> e.getData();
            case 3 -> e.getPrezioa();
            case 4 -> e.getBezeroIzena();
            case 5 -> e.getProduktuIzena();
            case 6 -> e.getFakturaId();
            default -> null;
        };
    }

    public Eskaerak getEskaeraAt(int row) {
        return lista.get(row);
    }

    public void addEskaera(Eskaerak e) {
        lista.add(e);
        fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
    }

    public void updateEskaera(int row, Eskaerak e) {
        lista.set(row, e);
        fireTableRowsUpdated(row, row);
    }

    public void removeEskaera(int row) {
        lista.remove(row);
        fireTableRowsDeleted(row, row);
    }
}