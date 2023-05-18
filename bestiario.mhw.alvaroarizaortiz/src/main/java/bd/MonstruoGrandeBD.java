package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.MonstruoGrande;
import enumeraciones.Elemento;
import utils.BDUtil;

public class MonstruoGrandeBD {
    public void insertarMonstruoGrande(MonstruoGrande monstruoGrande) {
        String sql = "INSERT INTO monstruoGrande ( escapturable, resistencias, debilidades, id_Monstruo) VALUES (?, ?, ?, ?)";

        try (Connection conn = BDUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	
            pstmt.setBoolean(1, monstruoGrande.getEsCapturable());
            pstmt.setString(2, monstruoGrande.getResistencias() != null ? monstruoGrande.getResistencias().name() : " ");
            pstmt.setString(3, monstruoGrande.getDebilidades() != null ? monstruoGrande.getDebilidades().name() : " ");
            pstmt.setInt(4, monstruoGrande.getId_Monstruo());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar el monstruo grande en la base de datos: " + e.getMessage());
        }
    }

    public List<MonstruoGrande> listarMonstruosGrandes() {
        List<MonstruoGrande> listaMonstruosGrandes = new ArrayList<>();
        String sql = "Select t2.nombre, t2.especie, t2.tamaño, t2.puntossalud, id_mapa, t1.escapturable, t1.resistencias, t1.debilidades, t1.id_monstruo from monstruoGrande as t1\r\n"
        		+ "Inner Join monstruo as t2 \r\n"
        		+ "on t1.id_monstruo = t2.id;";

        try (Connection conn = BDUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {

            	String nombre = rs.getString("nombre");
		        String especie = rs.getString("especie");
		        int tamaño = rs.getInt("tamaño");
		        int puntosSalud = rs.getInt("puntosSalud");
		        int id_mapa = rs.getInt("id_Mapa");
                boolean escapturable = rs.getBoolean("escapturable");
                String resistenciasString = rs.getString("resistencias");
                String debilidadesString = rs.getString("debilidades");
                int id_Monstruo = rs.getInt("id_Monstruo");
                

                Elemento resistencias = Elemento.valueOf(resistenciasString);
                Elemento debilidades = Elemento.valueOf(debilidadesString);

                MonstruoGrande monstruoGrande = new MonstruoGrande( nombre, especie, tamaño, puntosSalud, id_mapa, escapturable, resistencias, debilidades, id_Monstruo);
                listaMonstruosGrandes.add(monstruoGrande);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la lista de monstruos grandes: " + e.getMessage());
        }

        return listaMonstruosGrandes;
    }

    public void eliminarMonstruoGrande(String nombre) {
        String sql = "DELETE FROM monstruoGrande WHERE nombre = ?";

        try (Connection conn = BDUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el monstruo grande de la base de datos: " + e.getMessage());
        }
    }
    
    public void insertarRelacionMonstruoPuntoDebil(int idMonstruoGrande, int idPuntoDebil) {
        String sql = "INSERT INTO monstruogrande_puntodebil (id_monstruogrande, id_puntodebil) VALUES (?, ?)";
        
        try (Connection conn = BDUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, idMonstruoGrande);
            pstmt.setInt(2, idPuntoDebil);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error al insertar la relación entre monstruo grande y punto débil: " + e.getMessage());
        }
    }
    
    
}
