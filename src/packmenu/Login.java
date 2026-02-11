package packmenu;

import java.sql.*;
import java.util.Scanner;
import packconexion.Conexion;
import packgui.VentanaPrincipal;

public class Login {

    public static void iniciarLogin() {

        Scanner sc = new Scanner(System.in);
        Conexion conexion = new Conexion();

        System.out.println("Sartu emaila:");
        String email = sc.nextLine();

        System.out.println("Sartu pasahitza:");
        String pasahitza = sc.nextLine();

        try {
            Connection cn = conexion.conectar();
            Statement stm = cn.createStatement();

            String sql = "SELECT postua FROM langileak WHERE email = '" 
                         + email + "' AND pasahitza = '" + pasahitza + "'";

            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
            	String rol = rs.getString("postua").toLowerCase();
                System.out.println("Ongi etorri! Rol: " + rol);

                new VentanaPrincipal(rol);

            } else {
                System.out.println("Email edo pasahitza okerra.");
            }

            rs.close();
            stm.close();
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}