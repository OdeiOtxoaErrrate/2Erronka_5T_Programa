package packgui;

import packmodelo.Produktuak;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModelProduktuak extends AbstractTableModel {

    private List<Produktuak> lista;

    private final String[] columnas = {
            "ID", "Izena", "Modeloa", "Prezioa", "Marka", "Stock", "Sekzioa", "Argazkia", "Hornitzaile ID"
    };

    public TableModelProduktuak(List<Produktuak> lista) {
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
        Produktuak p = lista.get(row);

        return switch (col) {
            case 0 -> p.getId();
            case 1 -> p.getIzena();
            case 2 -> p.getModeloa();
            case 3 -> p.getPrezioa();
            case 4 -> p.getMarka();
            case 5 -> p.getStock();
            case 6 -> p.getSekzioa();
            case 7 -> p.getArgazkia();
            case 8 -> p.getHornitzaileId();
            default -> null;
        };
    }

    public Produktuak getProduktuaAt(int row) {
        return lista.get(row);
    }

    public void addProduktua(Produktuak p) {
        lista.add(p);
        fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
    }

    public void updateProduktua(int row, Produktuak p) {
        lista.set(row, p);
        fireTableRowsUpdated(row, row);
    }

    public void removeProduktua(int row) {
        lista.remove(row);
        fireTableRowsDeleted(row, row);
    }
}