package packdao;

import packmodelo.Produktuak;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduktuakDAO {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
        		"jdbc:mysql://localhost:3307/bigarrenerronka",
                "root",
                "1MG32025"
        );
    }

    public List<Produktuak> getAllProduktua() {
        List<Produktuak> lista = new ArrayList<>();

        String sql = "SELECT * FROM produktuak";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Produktuak(
                        rs.getInt("id"),
                        rs.getString("izena"),
                        rs.getString("modeloa"),
                        rs.getInt("prezioa"),
                        rs.getString("marka"),
                        rs.getInt("stock"),
                        rs.getInt("sekzioa"),
                        rs.getString("argazkia"),
                        rs.getInt("hornitzaile_id")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean gehituProduktua(Produktuak p) {
        String sql = "INSERT INTO produktuak (izena, modeloa, prezioa, marka, stock, sekzioa, argazkia, hornitzaile_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, p.getIzena());
            pst.setString(2, p.getModeloa());
            pst.setInt(3, p.getPrezioa());
            pst.setString(4, p.getMarka());
            pst.setInt(5, p.getStock());
            pst.setInt(6, p.getSekzioa());
            pst.setString(7, p.getArgazkia());
            pst.setInt(8, p.getHornitzaileId());

            return pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean aldatuProduktua(Produktuak p) {
        String sql = "UPDATE produktuak SET izena=?, modeloa=?, prezioa=?, marka=?, stock=?, sekzioa=?, argazkia=?, hornitzaile_id=? " +
                     "WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, p.getIzena());
            pst.setString(2, p.getModeloa());
            pst.setInt(3, p.getPrezioa());
            pst.setString(4, p.getMarka());
            pst.setInt(5, p.getStock());
            pst.setInt(6, p.getSekzioa());
            pst.setString(7, p.getArgazkia());
            pst.setInt(8, p.getHornitzaileId());
            pst.setInt(9, p.getId());

            return pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean ezabatuProduktua(int id) {
        String sql = "DELETE FROM produktuak WHERE id=?";

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