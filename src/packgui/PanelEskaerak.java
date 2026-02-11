package packgui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import packcontrolador.EskaerakController;
import packmodelo.Eskaerak;

public class PanelEskaerak extends JPanel {

    private JTable tabla;
    private TableModelEskaerak modelo;
    private EskaerakController controller = new EskaerakController();

    public PanelEskaerak(String rol) {
        setLayout(new BorderLayout());

        boolean esZuzendaria = rol.equalsIgnoreCase("zuzendaria");
        boolean esAdministraria = rol.equalsIgnoreCase("administraria");

        boolean puedeAñadir = esZuzendaria || esAdministraria;
        boolean puedeEditar = esZuzendaria || esAdministraria;
        boolean puedeBorrar = esZuzendaria;

        List<Eskaerak> lista = controller.listarEskaerak();
        modelo = new TableModelEskaerak(lista);
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
            FormEskaeraGehitu form = new FormEskaeraGehitu();
            form.setVisible(true);

            if (form.isConfirmado()) {
                Eskaerak esk = form.getEskaera();
                if (controller.gehitu(esk)) {
                    modelo.addEskaera(esk);
                } else {
                    JOptionPane.showMessageDialog(null, "Errorea eskaera gehitzean.");
                }
            }
        });

        btnAldatu.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Aukeratu eskaera bat.");
                return;
            }

            Eskaerak esk = modelo.getEskaeraAt(fila);
            FormEskaeraAldatu form = new FormEskaeraAldatu(esk);
            form.setVisible(true);

            if (form.isConfirmado()) {
                Eskaerak berria = form.getEskaera(esk.getId());
                if (controller.aldatu(berria)) {
                    modelo.updateEskaera(fila, berria);
                } else {
                    JOptionPane.showMessageDialog(null, "Errorea eskaera aldatzean.");
                }
            }
        });

        btnEzabatu.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Aukeratu eskaera bat.");
                return;
            }

            Eskaerak esk = modelo.getEskaeraAt(fila);

            int resp = JOptionPane.showConfirmDialog(
                    null,
                    "Ziur zaude ezabatu nahi duzula?",
                    "Konfirmazioa",
                    JOptionPane.YES_NO_OPTION
            );

            if (resp == JOptionPane.YES_OPTION) {
                if (controller.ezabatu(esk.getId())) {
                    modelo.removeEskaera(fila);
                } else {
                    JOptionPane.showMessageDialog(null, "Errorea eskaera ezabatzean.");
                }
            }
        });
    }
}