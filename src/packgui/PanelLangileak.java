package packgui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import packcontrolador.LangileakController;
import packmodelo.Langileak;

public class PanelLangileak extends JPanel {

    private JTable tabla;
    private TableModelLangileak modelo;
    private LangileakController controller = new LangileakController();

    public PanelLangileak(String rol) {
        setLayout(new BorderLayout());

        boolean esZuzendaria = rol.equalsIgnoreCase("zuzendaria");
        boolean esAdministraria = rol.equalsIgnoreCase("administraria");

        boolean puedeAñadir = esZuzendaria || esAdministraria;
        boolean puedeEditar = esZuzendaria || esAdministraria;
        boolean puedeBorrar = esZuzendaria;

        List<Langileak> lista = controller.listarLangileak();
        modelo = new TableModelLangileak(lista);
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
            FormLangileGehitu form = new FormLangileGehitu();
            form.setVisible(true);

            if (form.isConfirmado()) {
                Langileak l = form.getLangile();
                if (controller.gehitu(l)) {
                    modelo.addLangile(l);
                } else {
                    JOptionPane.showMessageDialog(null, "Errorea langilea gehitzean.");
                }
            }
        });

        btnAldatu.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Aukeratu langile bat.");
                return;
            }

            Langileak l = modelo.getLangileAt(fila);
            FormLangileAldatu form = new FormLangileAldatu(l);
            form.setVisible(true);

            if (form.isConfirmado()) {
                Langileak berria = form.getLangile(l.getId());
                if (controller.aldatu(berria)) {
                    modelo.updateLangile(fila, berria);
                } else {
                    JOptionPane.showMessageDialog(null, "Errorea langilea aldatzean.");
                }
            }
        });

        btnEzabatu.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Aukeratu langile bat.");
                return;
            }

            Langileak l = modelo.getLangileAt(fila);

            int resp = JOptionPane.showConfirmDialog(
                    null,
                    "Ziur zaude ezabatu nahi duzula?",
                    "Konfirmazioa",
                    JOptionPane.YES_NO_OPTION
            );

            if (resp == JOptionPane.YES_OPTION) {
                if (controller.ezabatu(l.getId())) {
                    modelo.removeLangile(fila);
                } else {
                    JOptionPane.showMessageDialog(null, "Errorea langilea ezabatzean.");
                }
            }
        });
    }
}