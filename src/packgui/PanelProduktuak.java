package packgui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import packcontrolador.ProduktuakController;
import packmodelo.Produktuak;

public class PanelProduktuak extends JPanel {

    private JTable tabla;
    private TableModelProduktuak modelo;
    private ProduktuakController controller = new ProduktuakController();

    public PanelProduktuak(String rol) {
        setLayout(new BorderLayout());

        boolean esZuzendaria = rol.equalsIgnoreCase("zuzendaria");
        boolean esAdministraria = rol.equalsIgnoreCase("administraria");

        boolean puedeAñadir = esZuzendaria || esAdministraria;
        boolean puedeEditar = esZuzendaria || esAdministraria;
        boolean puedeBorrar = esZuzendaria;

        List<Produktuak> lista = controller.listarProduktua();
        modelo = new TableModelProduktuak(lista);
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
            FormProduktuaGehitu form = new FormProduktuaGehitu();
            form.setVisible(true);

            if (form.isConfirmado()) {
                Produktuak p = form.getProduktua();
                if (controller.gehitu(p)) {
                    modelo.addProduktua(p);
                } else {
                    JOptionPane.showMessageDialog(null, "Errorea produktua gehitzean.");
                }
            }
        });

        btnAldatu.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Aukeratu produktu bat.");
                return;
            }

            Produktuak p = modelo.getProduktuaAt(fila);
            FormProduktuaAldatu form = new FormProduktuaAldatu(p);
            form.setVisible(true);

            if (form.isConfirmado()) {
                Produktuak berria = form.getProduktua(p.getId());
                if (controller.aldatu(berria)) {
                    modelo.updateProduktua(fila, berria);
                } else {
                    JOptionPane.showMessageDialog(null, "Errorea produktua aldatzean.");
                }
            }
        });

        btnEzabatu.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Aukeratu produktu bat.");
                return;
            }

            Produktuak p = modelo.getProduktuaAt(fila);

            int resp = JOptionPane.showConfirmDialog(
                    null,
                    "Ziur zaude ezabatu nahi duzula?",
                    "Konfirmazioa",
                    JOptionPane.YES_NO_OPTION
            );

            if (resp == JOptionPane.YES_OPTION) {
                if (controller.ezabatu(p.getId())) {
                    modelo.removeProduktua(fila);
                } else {
                    JOptionPane.showMessageDialog(null, "Errorea produktua ezabatzean.");
                }
            }
        });
    }
}