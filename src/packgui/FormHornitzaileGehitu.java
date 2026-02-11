package packgui;

import javax.swing.*;
import java.awt.*;
import packmodelo.Hornitzaileak;

public class FormHornitzaileGehitu extends JDialog {

    private JTextField txtIzena, txtAbizenak, txtNan, txtHelbidea, txtTelefonoa, txtEmail;
    private boolean confirmado = false;

    public FormHornitzaileGehitu() {
        setTitle("Hornitzailea Gehitu");
        setSize(350, 350);
        setModal(true);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));

        txtIzena = new JTextField();
        txtAbizenak = new JTextField();
        txtNan = new JTextField();
        txtHelbidea = new JTextField();
        txtTelefonoa = new JTextField();
        txtEmail = new JTextField();

        panel.add(new JLabel("Izena:"));
        panel.add(txtIzena);

        panel.add(new JLabel("Abizenak:"));
        panel.add(txtAbizenak);

        panel.add(new JLabel("NAN:"));
        panel.add(txtNan);

        panel.add(new JLabel("Helbidea:"));
        panel.add(txtHelbidea);

        panel.add(new JLabel("Telefonoa:"));
        panel.add(txtTelefonoa);

        panel.add(new JLabel("Email:"));
        panel.add(txtEmail);

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

    public Hornitzaileak getHornitzailea() {
        return new Hornitzaileak(
                0,
                txtHelbidea.getText(),
                txtIzena.getText(),
                txtAbizenak.getText(),
                txtNan.getText(),
                txtTelefonoa.getText(),
                txtEmail.getText()
        );
    }
}