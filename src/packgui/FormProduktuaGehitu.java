package packgui;

import javax.swing.*;
import java.awt.*;
import packmodelo.Produktuak;

public class FormProduktuaGehitu extends JDialog {

    private JTextField txtIzena, txtModeloa, txtPrezioa, txtMarka, txtStock, txtSekzioa, txtArgazkia, txtHornitzaileId;
    private boolean confirmado = false;

    public FormProduktuaGehitu() {
        setTitle("Produktua Gehitu");
        setSize(400, 450);
        setModal(true);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(9, 2, 5, 5));

        txtIzena = new JTextField();
        txtModeloa = new JTextField();
        txtPrezioa = new JTextField();
        txtMarka = new JTextField();
        txtStock = new JTextField();
        txtSekzioa = new JTextField();
        txtArgazkia = new JTextField();
        txtHornitzaileId = new JTextField();

        panel.add(new JLabel("Izena:"));
        panel.add(txtIzena);

        panel.add(new JLabel("Modeloa:"));
        panel.add(txtModeloa);

        panel.add(new JLabel("Prezioa:"));
        panel.add(txtPrezioa);

        panel.add(new JLabel("Marka:"));
        panel.add(txtMarka);

        panel.add(new JLabel("Stock:"));
        panel.add(txtStock);

        panel.add(new JLabel("Sekzioa:"));
        panel.add(txtSekzioa);

        panel.add(new JLabel("Argazkia (path):"));
        panel.add(txtArgazkia);

        panel.add(new JLabel("Hornitzaile ID:"));
        panel.add(txtHornitzaileId);

        JButton btnOk = new JButton("Gehitu");
        btnOk.addActionListener(e -> {
            confirmado = true;
            dispose();
        });

        panel.add(new JLabel());
        panel.add(btnOk);

        add(panel);
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public Produktuak getProduktua() {
        return new Produktuak(
                0,
                txtIzena.getText(),
                txtModeloa.getText(),
                Integer.parseInt(txtPrezioa.getText()),
                txtMarka.getText(),
                Integer.parseInt(txtStock.getText()),
                Integer.parseInt(txtSekzioa.getText()),
                txtArgazkia.getText(),
                Integer.parseInt(txtHornitzaileId.getText())
        );
    }
}