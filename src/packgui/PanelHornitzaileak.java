package packgui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import packcontrolador.HornitzaileakController;
import packmodelo.Hornitzaileak;

public class PanelHornitzaileak extends JPanel {

    private JTable tabla;
    private TableModelHornitzaileak modelo;
    private HornitzaileakController controller = new HornitzaileakController();

    public PanelHornitzaileak(String rol) {
        setLayout(new BorderLayout());

        boolean esZuzendaria = rol.equalsIgnoreCase("zuzendaria");
        boolean esAdministraria = rol.equalsIgnoreCase("administraria");

        boolean puedeAñadir = esZuzendaria || esAdministraria;
        boolean puedeEditar = esZuzendaria || esAdministraria;
        boolean puedeBorrar = esZuzendaria;

        List<Hornitzaileak> lista = controller.listarHornitzaileak();
        modelo = new TableModelHornitzaileak(lista);
        tabla = new JTable(modelo);

        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel botones = new JPanel();
        botones.setPreferredSize(new Dimension(100, 50));

        JButton btnGehitu = new JButton("Gehitu");
        JButton btnAldatu = new JButton("Aldatu");
        JButton btnEzabatu = new JButton("Ezabatu");

        btnGehitu.setEnabled(puedeAñadir);
        btnAldatu.setEnabled(puedeEditar);
        btnEzabatu.setEnabled(puedeBorrar);

        botones.add(btnGehitu);
        botones.add(btnAldatu);
        botones.add(btnEzabatu);

        add(botones, BorderLayout.NORTH);

        btnGehitu.addActionListener(e -> {
            FormHornitzaileGehitu form = new FormHornitzaileGehitu();
            form.setVisible(true);

            if (form.isConfirmado()) {
                Hornitzaileak h = form.getHornitzailea();
                if (controller.gehitu(h)) {
                    modelo.addHornitzailea(h);
                } else {
                    JOptionPane.showMessageDialog(null, "Errorea hornitzailea gehitzean.");
                }
            }
        });

        btnAldatu.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Aukeratu hornitzaile bat.");
                return;
            }

            Hornitzaileak h = modelo.getHornitzaileaAt(fila);
            FormHornitzaileAldatu form = new FormHornitzaileAldatu(h);
            form.setVisible(true);

            if (form.isConfirmado()) {
                Hornitzaileak berria = form.getHornitzailea(h.getId());
                if (controller.aldatu(berria)) {
                    modelo.updateHornitzailea(fila, berria);
                } else {
                    JOptionPane.showMessageDialog(null, "Errorea hornitzailea aldatzean.");
                }
            }
        });

        btnEzabatu.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Aukeratu hornitzaile bat.");
                return;
            }

            Hornitzaileak h = modelo.getHornitzaileaAt(fila);

            int resp = JOptionPane.showConfirmDialog(
                    null,
                    "Ziur zaude ezabatu nahi duzula?",
                    "Konfirmazioa",
                    JOptionPane.YES_NO_OPTION
            );

            if (resp == JOptionPane.YES_OPTION) {
                if (controller.ezabatu(h.getId())) {
                    modelo.removeHornitzailea(fila);
                } else {
                    JOptionPane.showMessageDialog(null, "Errorea hornitzailea ezabatzean.");
                }
            }
        });
    }
}