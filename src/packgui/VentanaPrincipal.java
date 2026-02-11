package packgui;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private String rol;

    public VentanaPrincipal(String rol) {
        this.rol = rol;

        setTitle("Kudeaketa Sistema");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        setJMenuBar(crearMenu());

        setContentPane(new JLabel("Ongi etorri sistemara!", SwingConstants.CENTER));

        setVisible(true);
    }

    private JMenuBar crearMenu() {
        JMenuBar barra = new JMenuBar();

        JMenu menuLangileak = new JMenu("Langileak");
        JMenuItem itemIkusiLangileak = new JMenuItem("Ikusi Langileak");
        itemIkusiLangileak.addActionListener(e -> cambiarPanel(new PanelLangileak(rol)));
        menuLangileak.add(itemIkusiLangileak);

        JMenu menuBezeroak = new JMenu("Bezeroak");
        JMenuItem itemIkusiBezeroak = new JMenuItem("Ikusi Bezeroak");
        itemIkusiBezeroak.addActionListener(e -> cambiarPanel(new PanelBezeroak(rol)));
        menuBezeroak.add(itemIkusiBezeroak);

        JMenu menuProduktuak = new JMenu("Produktuak");
        JMenuItem itemIkusiProduktuak = new JMenuItem("Ikusi Produktuak");
        itemIkusiProduktuak.addActionListener(e -> cambiarPanel(new PanelProduktuak(rol)));
        menuProduktuak.add(itemIkusiProduktuak);

        JMenu menuHornitzaileak = new JMenu("Hornitzaileak");
        JMenuItem itemIkusiHornitzaileak = new JMenuItem("Ikusi Hornitzaileak");
        itemIkusiHornitzaileak.addActionListener(e -> cambiarPanel(new PanelHornitzaileak(rol)));
        menuHornitzaileak.add(itemIkusiHornitzaileak);

        JMenu menuEskaerak = new JMenu("Eskaerak");
        JMenuItem itemIkusiEskaerak = new JMenuItem("Ikusi Eskaerak");
        itemIkusiEskaerak.addActionListener(e -> cambiarPanel(new PanelEskaerak(rol)));
        menuEskaerak.add(itemIkusiEskaerak);

        barra.add(menuLangileak);
        barra.add(menuBezeroak);
        barra.add(menuProduktuak);
        barra.add(menuHornitzaileak);
        barra.add(menuEskaerak);

        return barra;
    }

    private void cambiarPanel(JComponent nuevo) {
        setContentPane(nuevo);
        revalidate();
        repaint();
    }
}