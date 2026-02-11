package packdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import packmodelo.Hornitzaileak;

public class HornitzaileakDAO {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
        		"jdbc:mysql://localhost:3307/bigarrenerronka",
                "root",
                "1MG32025"
        );
    }

    public List<Hornitzaileak> getAllHornitzaileak() {
        List<Hornitzaileak> lista = new ArrayList<>();

        String sql = "SELECT * FROM hornitzaileak";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Hornitzaileak(
                        rs.getInt("id"),
                        rs.getString("helbidea"),
                        rs.getString("izena"),
                        rs.getString("abizenak"),
                        rs.getString("nan"),
                        rs.getString("telefonoa"),
                        rs.getString("email")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean gehituHornitzailea(Hornitzaileak h) {
        String sql = "INSERT INTO hornitzaileak (helbidea, izena, abizenak, nan, telefonoa, email) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, h.getHelbidea());
            pst.setString(2, h.getIzena());
            pst.setString(3, h.getAbizenak());
            pst.setString(4, h.getNan());
            pst.setString(5, h.getTelefonoa());
            pst.setString(6, h.getEmail());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean aldatuHornitzailea(Hornitzaileak h) {
        String sql = "UPDATE hornitzaileak SET helbidea=?, izena=?, abizenak=?, nan=?, telefonoa=?, email=? WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, h.getHelbidea());
            pst.setString(2, h.getIzena());
            pst.setString(3, h.getAbizenak());
            pst.setString(4, h.getNan());
            pst.setString(5, h.getTelefonoa());
            pst.setString(6, h.getEmail());
            pst.setInt(7, h.getId());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ezabatuHornitzailea(int id) {
        String sql = "DELETE FROM hornitzaileak WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, id);
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}