package packdao;

import packmodelo.Bezeroak;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BezeroakDAO {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
        		"jdbc:mysql://localhost:3307/bigarrenerronka",
                "root",
                "1MG32025"
        );
    }

    public List<Bezeroak> getAllBezeroak() {
        List<Bezeroak> lista = new ArrayList<>();

        String sql = "SELECT * FROM bezeroak";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Bezeroak(
                        rs.getInt("id"),
                        rs.getString("helbidea"),
                        rs.getString("telefonoa"),
                        rs.getString("izena"),
                        rs.getString("abizenak"),
                        rs.getString("nan"),
                        rs.getString("email"),
                        rs.getString("pasahitza")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean gehituBezeroa(Bezeroak b) {
        String sql = "INSERT INTO bezeroak (helbidea, telefonoa, izena, abizenak, nan, email, pasahitza) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, b.getHelbidea());
            pst.setString(2, b.getTelefonoa());
            pst.setString(3, b.getIzena());
            pst.setString(4, b.getAbizenak());
            pst.setString(5, b.getNan());
            pst.setString(6, b.getEmail());
            pst.setString(7, b.getPasahitza());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean aldatuBezeroa(Bezeroak b) {
        String sql = "UPDATE bezeroak SET helbidea=?, telefonoa=?, izena=?, abizenak=?, nan=?, email=?, pasahitza=? " +
                     "WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, b.getHelbidea());
            pst.setString(2, b.getTelefonoa());
            pst.setString(3, b.getIzena());
            pst.setString(4, b.getAbizenak());
            pst.setString(5, b.getNan());
            pst.setString(6, b.getEmail());
            pst.setString(7, b.getPasahitza());
            pst.setInt(8, b.getId());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ezabatuBezeroa(int id) {
        String sql = "DELETE FROM bezeroak WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, id);
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	public Bezeroak getBezeroakById(int bezeroId) {
		return null;
	}
}