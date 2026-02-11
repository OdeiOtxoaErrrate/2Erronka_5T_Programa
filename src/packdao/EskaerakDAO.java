package packdao;

import packmodelo.Eskaerak;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EskaerakDAO {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
        		"jdbc:mysql://localhost:3307/bigarrenerronka",
                "root",
                "1MG32025"
        );
    }

    public List<Eskaerak> getAllEskaerak() {
        List<Eskaerak> lista = new ArrayList<>();

        String sql = "SELECT * FROM eskaerak";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Eskaerak(
                        rs.getInt("id"),
                        rs.getInt("bezero_id"),
                        rs.getString("data"),
                        rs.getDouble("prezioa"),
                        rs.getString("bezero_izena"),
                        rs.getString("produktu_izena"),
                        rs.getInt("faktura_id")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean gehituEskaera(Eskaerak e) {
        String sql = "INSERT INTO eskaerak (bezero_id, data, prezioa, bezero_izena, produktu_izena, faktura_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, e.getBezeroId());
            pst.setString(2, e.getData());
            pst.setDouble(3, e.getPrezioa());
            pst.setString(4, e.getBezeroIzena());
            pst.setString(5, e.getProduktuIzena());
            pst.setInt(6, e.getFakturaId());

            return pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean aldatuEskaera(Eskaerak e) {
        String sql = "UPDATE eskaerak SET bezero_id=?, data=?, prezioa=?, bezero_izena=?, produktu_izena=?, faktura_id=? " +
                     "WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, e.getBezeroId());
            pst.setString(2, e.getData());
            pst.setDouble(3, e.getPrezioa());
            pst.setString(4, e.getBezeroIzena());
            pst.setString(5, e.getProduktuIzena());
            pst.setInt(6, e.getFakturaId());
            pst.setInt(7, e.getId());

            return pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean ezabatuEskaera(int id) {
        String sql = "DELETE FROM eskaerak WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, id);
            return pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}