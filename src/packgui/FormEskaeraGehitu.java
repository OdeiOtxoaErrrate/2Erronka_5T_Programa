package packgui;

import javax.swing.*;
import java.awt.*;
import packmodelo.Eskaerak;

public class FormEskaeraGehitu extends JDialog {

    private JTextField txtBezeroId, txtData, txtPrezioa, txtBezeroIzena, txtProduktuIzena, txtFakturaId;
    private boolean confirmado = false;

    public FormEskaeraGehitu() {
        setTitle("Eskaera Gehitu");
        setSize(400, 350);
        setModal(true);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));

        txtBezeroId = new JTextField();
        txtData = new JTextField();
        txtPrezioa = new JTextField();
        txtBezeroIzena = new JTextField();
        txtProduktuIzena = new JTextField();
        txtFakturaId = new JTextField();

        panel.add(new JLabel("Bezero ID:"));
        panel.add(txtBezeroId);

        panel.add(new JLabel("Data (YYYY-MM-DD):"));
        panel.add(txtData);

        panel.add(new JLabel("Prezioa:"));
        panel.add(txtPrezioa);

        panel.add(new JLabel("Bezero Izena:"));
        panel.add(txtBezeroIzena);

        panel.add(new JLabel("Produktu Izena:"));
        panel.add(txtProduktuIzena);

        panel.add(new JLabel("Faktura ID:"));
        panel.add(txtFakturaId);

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

    public Eskaerak getEskaera() {
        return new Eskaerak(
                0,
                Integer.parseInt(txtBezeroId.getText()),
                txtData.getText(),
                Double.parseDouble(txtPrezioa.getText()),
                txtBezeroIzena.getText(),
                txtProduktuIzena.getText(),
                Integer.parseInt(txtFakturaId.getText())
        );
    }
}