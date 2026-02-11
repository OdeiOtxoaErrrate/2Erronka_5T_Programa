package packgui;

import javax.swing.*;
import java.awt.*;
import packmodelo.Hornitzaileak;

public class FormHornitzaileAldatu extends JDialog {

    private JTextField txtIzena, txtAbizenak, txtNan, txtHelbidea, txtTelefonoa, txtEmail;
    private boolean confirmado = false;

    public FormHornitzaileAldatu(Hornitzaileak h) {
        setTitle("Hornitzailea Aldatu");
        setSize(350, 350);
        setModal(true);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));

        txtIzena = new JTextField(h.getIzena());
        txtAbizenak = new JTextField(h.getAbizenak());
        txtNan = new JTextField(h.getNan());
        txtHelbidea = new JTextField(h.getHelbidea());
        txtTelefonoa = new JTextField(h.getTelefonoa());
        txtEmail = new JTextField(h.getEmail());

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

    public Hornitzaileak getHornitzailea(int id) {
        return new Hornitzaileak(
                id,
                txtHelbidea.getText(),
                txtIzena.getText(),
                txtAbizenak.getText(),
                txtNan.getText(),
                txtTelefonoa.getText(),
                txtEmail.getText()
        );
    }
}