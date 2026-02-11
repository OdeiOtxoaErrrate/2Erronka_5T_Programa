package packgui;

import javax.swing.*;
import java.awt.*;
import packmodelo.Langileak;

public class FormLangileAldatu extends JDialog {

    private JTextField txtPostua, txtIzena, txtAbizenak, txtNan, txtTelefonoa, txtEmail, txtPasahitza;
    private boolean confirmado = false;

    public FormLangileAldatu(Langileak l) {
        setTitle("Langilea Aldatu");
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2, 5, 5));

        txtPostua = new JTextField(l.getPostua());
        txtIzena = new JTextField(l.getIzena());
        txtAbizenak = new JTextField(l.getAbizenak());
        txtNan = new JTextField(l.getNan());
        txtTelefonoa = new JTextField(l.getTelefonoa());
        txtEmail = new JTextField(l.getEmail());
        txtPasahitza = new JTextField(l.getPasahitza());

        panel.add(new JLabel("Postua:"));
        panel.add(txtPostua);

        panel.add(new JLabel("Izena:"));
        panel.add(txtIzena);

        panel.add(new JLabel("Abizenak:"));
        panel.add(txtAbizenak);

        panel.add(new JLabel("NAN:"));
        panel.add(txtNan);

        panel.add(new JLabel("Telefonoa:"));
        panel.add(txtTelefonoa);

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

    public Langileak getLangile(int id) {
        return new Langileak(
                id,
                txtPostua.getText(),
                txtIzena.getText(),
                txtAbizenak.getText(),
                txtNan.getText(),
                txtTelefonoa.getText(),
                txtEmail.getText(),
                txtPasahitza.getText()
        );
    }
}