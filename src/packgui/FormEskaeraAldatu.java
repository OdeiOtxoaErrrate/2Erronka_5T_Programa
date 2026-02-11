package packgui;

import javax.swing.*;
import java.awt.*;
import packmodelo.Eskaerak;

public class FormEskaeraAldatu extends JDialog {

    private JTextField txtBezeroId, txtData, txtPrezioa, txtBezeroIzena, txtProduktuIzena, txtFakturaId;
    private boolean confirmado = false;

    public FormEskaeraAldatu(Eskaerak e) {
        setTitle("Eskaera Aldatu");
        setSize(400, 350);
        setModal(true);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));

        txtBezeroId = new JTextField(String.valueOf(e.getBezeroId()));
        txtData = new JTextField(e.getData());
        txtPrezioa = new JTextField(String.valueOf(e.getPrezioa()));
        txtBezeroIzena = new JTextField(e.getBezeroIzena());
        txtProduktuIzena = new JTextField(e.getProduktuIzena());
        txtFakturaId = new JTextField(String.valueOf(e.getFakturaId()));

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

        JButton btnOk = new JButton("Aldatu");
        btnOk.addActionListener(e2 -> {
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

    public Eskaerak getEskaera(int id) {
        return new Eskaerak(
                id,
                Integer.parseInt(txtBezeroId.getText()),
                txtData.getText(),
                Double.parseDouble(txtPrezioa.getText()),
                txtBezeroIzena.getText(),
                txtProduktuIzena.getText(),
                Integer.parseInt(txtFakturaId.getText())
        );
    }
}