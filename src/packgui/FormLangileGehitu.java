package packgui;

import javax.swing.*;
import java.awt.*;
import packmodelo.Langileak;

public class FormLangileGehitu extends JDialog {

    private JTextField txtPostua, txtIzena, txtAbizenak, txtNan, txtTelefonoa, txtEmail, txtPasahitza;
    private boolean confirmado = false;

    public FormLangileGehitu() {
        setTitle("Langilea Gehitu");
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2, 5, 5));

        txtPostua = new JTextField();
        txtIzena = new JTextField();
        txtAbizenak = new JTextField();
        txtNan = new JTextField();
        txtTelefonoa = new JTextField();
        txtEmail = new JTextField();
        txtPasahitza = new JTextField();

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

    public Langileak getLangile() {
        return new Langileak(
                0,
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