package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.Mapa;
import clases.Monstruo;
import utils.BDUtil;

public class MonstruoBD {

	 public void insertarMonstruo(Monstruo monstruo, int id_mapa) {
	        String sql = "INSERT INTO Monstruo(nombre, especie, tamaño, puntosSalud, id_mapa) VALUES (?, ?, ?, ?, ?)";
	        
	        try (Connection conn = BDUtil.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setString(1, monstruo.getNombre());
	            pstmt.setString(2, monstruo.getEspecie());
	            pstmt.setFloat(3, monstruo.getTamaño());
	            pstmt.setInt(4, monstruo.getPuntosSalud());
	            pstmt.setInt(5, id_mapa);
	            pstmt.executeUpdate();
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	
	 public List<Monstruo> listarMonstruos() {
		    List<Monstruo> listaMonstruos = new ArrayList<>();
		    String sql = "SELECT * FROM Monstruo";

		    try (Connection conn = BDUtil.getConnection();
		         PreparedStatement pstmt = conn.prepareStatement(sql);
		         ResultSet rs = pstmt.executeQuery()) {

		        while (rs.next()) {
		            String nombre = rs.getString("nombre");
		            String especie = rs.getString("especie");
		            int tamaño = rs.getInt("tamaño");
		            int puntosSalud = rs.getInt("puntosSalud");
		            int id_mapa = rs.getInt("id_mapa");
		            Monstruo monstruo = new Monstruo(nombre, especie, tamaño, puntosSalud, id_mapa);
		            listaMonstruos.add(monstruo);
		        }

		    } catch (SQLException e) {
		        System.out.println(e.getMessage());
		    }
		    return listaMonstruos;
		}

	    public void eliminarMonstruo(int id) {
	        String sql = "DELETE FROM Monstruo WHERE id = ?";
	        
	        try (Connection conn = BDUtil.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setInt(1, id);
	            pstmt.executeUpdate();
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	}