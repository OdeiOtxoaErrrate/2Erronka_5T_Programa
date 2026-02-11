package packgui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import packcontrolador.BezeroakController;
import packmodelo.Bezeroak;

public class PanelBezeroak extends JPanel {

    private JTable tabla;
    private TableModelBezeroak modelo;
    private BezeroakController controller = new BezeroakController();

    public PanelBezeroak(String rol) {
        setLayout(new BorderLayout());

        boolean esZuzendaria = rol.equalsIgnoreCase("zuzendaria");
        boolean esAdministraria = rol.equalsIgnoreCase("administraria");

        boolean puedeAñadir = esZuzendaria || esAdministraria;
        boolean puedeEditar = esZuzendaria || esAdministraria;
        boolean puedeBorrar = esZuzendaria;

        List<Bezeroak> lista = controller.listarBezeroak();
        modelo = new TableModelBezeroak(lista);
        tabla = new JTable(modelo);

        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel botones = new JPanel();
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
            FormBezeroGehitu form = new FormBezeroGehitu();
            form.setVisible(true);

            if (form.isConfirmado()) {
                Bezeroak b = form.getBezeroa();
                if (controller.gehitu(b)) {
                    modelo.addBezeroa(b);
                } else {
                    JOptionPane.showMessageDialog(null, "Errorea bezeroa gehitzean.");
                }
            }
        });

        btnAldatu.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Aukeratu bezero bat.");
                return;
            }

            Bezeroak b = modelo.getBezeroakAt(fila);
            FormBezeroAldatu form = new FormBezeroAldatu(b);
            form.setVisible(true);

            if (form.isConfirmado()) {
                Bezeroak berria = form.getBezeroa(b.getId());
                if (controller.aldatu(berria)) {
                    modelo.updateBezeroa(fila, berria);
                } else {
                    JOptionPane.showMessageDialog(null, "Errorea bezeroa aldatzean.");
                }
            }
        });

        btnEzabatu.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Aukeratu bezero bat.");
                return;
            }

            Bezeroak b = modelo.getBezeroakAt(fila);

            int resp = JOptionPane.showConfirmDialog(
                    null,
                    "Ziur zaude ezabatu nahi duzula?",
                    "Konfirmazioa",
                    JOptionPane.YES_NO_OPTION
            );

            if (resp == JOptionPane.YES_OPTION) {
                if (controller.ezabatu(b.getId())) {
                    modelo.removeBezeroa(fila);
                } else {
                    JOptionPane.showMessageDialog(null, "Errorea bezeroa ezabatzean.");
                }
            }
        });
    }
}