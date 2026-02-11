package packdao;

import packmodelo.Langileak;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LangileakDAO {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost/bigarrenerronka",
                "root",
                "1MG32025"
        );
    }

    public List<Langileak> getAllLangileak() {
        List<Langileak> lista = new ArrayList<>();

        String sql = "SELECT * FROM langileak";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Langileak(
                        rs.getInt("id"),
                        rs.getString("postua"),
                        rs.getString("izena"),
                        rs.getString("abizenak"),
                        rs.getString("nan"),
                        rs.getString("telefonoa"),
                        rs.getString("email"),
                        rs.getString("pasahitza")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean gehituLangile(Langileak l) {
        String sql = "INSERT INTO langileak (postua, izena, abizenak, nan, telefonoa, email, pasahitza) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, l.getPostua());
            pst.setString(2, l.getIzena());
            pst.setString(3, l.getAbizenak());
            pst.setString(4, l.getNan());
            pst.setString(5, l.getTelefonoa());
            pst.setString(6, l.getEmail());
            pst.setString(7, l.getPasahitza());

            return pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean aldatuLangile(Langileak l) {
        String sql = "UPDATE langileak SET postua=?, izena=?, abizenak=?, nan=?, telefonoa=?, email=?, pasahitza=? " +
                     "WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, l.getPostua());
            pst.setString(2, l.getIzena());
            pst.setString(3, l.getAbizenak());
            pst.setString(4, l.getNan());
            pst.setString(5, l.getTelefonoa());
            pst.setString(6, l.getEmail());
            pst.setString(7, l.getPasahitza());
            pst.setInt(8, l.getId());

            return pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean ezabatuLangile(int id) {
        String sql = "DELETE FROM langileak WHERE id=?";

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