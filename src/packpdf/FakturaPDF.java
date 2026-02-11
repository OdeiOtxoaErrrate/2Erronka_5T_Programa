package packpdf;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import packdao.BezeroakDAO;
import packmodelo.Bezeroak;
import packmodelo.Eskaerak;

import java.io.FileOutputStream;

public class FakturaPDF {

    public static void sortuFaktura(Eskaerak eskaera, String fitxategia) {
        Document document = new Document();

        try {
            String ruta = "C:\\xampp\\htdocs\\5T_prog\\Erronka5Tpdf\\" + fitxategia;

            BezeroakDAO bezeroakDAO = new BezeroakDAO();
            Bezeroak b = bezeroakDAO.getBezeroakById(eskaera.getBezeroId());

            PdfWriter.getInstance(document, new FileOutputStream(ruta));
            document.open();

            Font tituloFont = new Font(Font.HELVETICA, 20, Font.BOLD);
            Paragraph titulo = new Paragraph("Faktura", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            document.add(titulo);

            Paragraph bezeroInfo = new Paragraph(
                    "Bezeroaren datuak:\n" +
                    "Izena: " + b.getIzena() + " " + b.getAbizenak() + "\n" +
                    "Email: " + b.getEmail() + "\n" +
                    "Helbidea: " + b.getHelbidea() + "\n" +
                    "Data: " + eskaera.getData() + "\n\n"
            );
            document.add(bezeroInfo);

            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            tabla.setSpacingBefore(10);

            tabla.addCell("Produktua");
            tabla.addCell("Prezioa");
            tabla.addCell("Kantitatea");
            tabla.addCell("Guztira");

            int kantitatea = 1;
            double prezioa = eskaera.getPrezioa();
            double guztira = prezioa * kantitatea;

            tabla.addCell(eskaera.getProduktuIzena());
            tabla.addCell(String.format("%.2f €", prezioa));
            tabla.addCell(String.valueOf(kantitatea));
            tabla.addCell(String.format("%.2f €", guztira));

            document.add(tabla);

            Paragraph total = new Paragraph(
                    "\nGuztira: " + String.format("%.2f €", guztira),
                    new Font(Font.HELVETICA, 14, Font.BOLD)
            );
            total.setAlignment(Element.ALIGN_RIGHT);
            document.add(total);

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}