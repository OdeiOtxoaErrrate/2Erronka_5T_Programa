package packgui;

import javax.swing.*;
import java.awt.*;
import packmodelo.Bezeroak;

public class FormBezeroAldatu extends JDialog {

    private JTextField txtHelbidea, txtTelefonoa, txtIzena, txtAbizenak, txtNan, txtEmail, txtPasahitza;
    private boolean confirmado = false;

    public FormBezeroAldatu(Bezeroak b) {
        setTitle("Bezeroa Aldatu");
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2, 5, 5));

        txtHelbidea = new JTextField(b.getHelbidea());
        txtTelefonoa = new JTextField(b.getTelefonoa());
        txtIzena = new JTextField(b.getIzena());
        txtAbizenak = new JTextField(b.getAbizenak());
        txtNan = new JTextField(b.getNan());
        txtEmail = new JTextField(b.getEmail());
        txtPasahitza = new JTextField(b.getPasahitza());

        panel.add(new JLabel("Helbidea:"));
        panel.add(txtHelbidea);

        panel.add(new JLabel("Telefonoa:"));
        panel.add(txtTelefonoa);

        panel.add(new JLabel("Izena:"));
        panel.add(txtIzena);

        panel.add(new JLabel("Abizenak:"));
        panel.add(txtAbizenak);

        panel.add(new JLabel("NAN:"));
        panel.add(txtNan);

        panel.add(new JLabel("Email:"));
        panel.add(txtEmail);

        panel.add(new JLabel("Pasahitza:"));
        panel.add(txtPasahitza);

        JButton btnOk = new JButton("Aldatu");
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

    public Bezeroak getBezeroa(int id) {
        return new Bezeroak(
                id,
                txtHelbidea.getText(),
                txtTelefonoa.getText(),
                txtIzena.getText(),
                txtAbizenak.getText(),
                txtNan.getText(),
                txtEmail.getText(),
                txtPasahitza.getText()
        );
    }
}