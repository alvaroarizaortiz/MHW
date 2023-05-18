package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.PuntoDebil;
import utils.BDUtil;

public class PuntoDebilBD {
    public void insertarPuntoDebil(PuntoDebil puntoDebil) {
        String sql = "INSERT INTO PuntoDebil(nombre, esRompible, resistenciaGolpes) VALUES(?,?,?)";

        try (Connection conn = BDUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, puntoDebil.getNombre());
            pstmt.setBoolean(2, puntoDebil.getEsRompible());
            pstmt.setByte(3, puntoDebil.getResistenciaGolpes());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<PuntoDebil> listarPuntosDebiles() {
        List<PuntoDebil> listaPuntosDebiles = new ArrayList<>();
        String sql = "SELECT * FROM PuntoDebil";

        try (Connection conn = BDUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                boolean esRompible = rs.getBoolean("esRompible");
                byte resistenciaGolpes = rs.getByte("resistenciaGolpes");
                PuntoDebil puntoDebil = new PuntoDebil(nombre, esRompible, resistenciaGolpes);
                listaPuntosDebiles.add(puntoDebil);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaPuntosDebiles;
    }

    public void borrarPuntoDebil(String nombre) {
        String sql = "DELETE FROM PuntoDebil WHERE nombre = ?";

        try (Connection conn = BDUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}