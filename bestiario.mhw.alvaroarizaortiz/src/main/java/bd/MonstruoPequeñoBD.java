package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import clases.MonstruoPequeño;
import utils.BDUtil;

public class MonstruoPequeñoBD {
	public void insertarMonstruoPequeño(MonstruoPequeño monstruoPequeño) {
		String sql = "INSERT INTO monstruoPequeño ( eshostil, escabalgable, id_Monstruo) VALUES (?, ?, ?)";

		try (Connection conn = BDUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setBoolean(1, monstruoPequeño.isEsHostil());
			pstmt.setBoolean(2, monstruoPequeño.isEsCabalgable());
			pstmt.setInt(3, monstruoPequeño.getId_Monstruo());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar el monstruo pequeño en la base de datos: " + e.getMessage());
		}
	}

	public List<MonstruoPequeño> listarMonstruosPequeños() {
		List<MonstruoPequeño> listaMonstruosPequeños = new ArrayList<>();
		String sql = "SELECT t2.nombre, t2.especie, t2.tamaño, t2.puntossalud, m.nombre AS nombre_mapa, t2.poderAtaque, t2.imagen, t2.descripcion, t1.esHostil, t1.esCabalgable, t1.id_monstruo " +
                "FROM monstruoPequeño AS t1 " +
                "INNER JOIN monstruo AS t2 ON t1.id_monstruo = t2.id " +
                "INNER JOIN mapa AS m ON t2.id_mapa = m.id " +
                "ORDER BY t2.nombre;";

		try (Connection conn = BDUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {

				String nombre = rs.getString("nombre");
				String especie = rs.getString("especie");
				int tamaño = rs.getInt("tamaño");
				int puntosSalud = rs.getInt("puntosSalud");
				int poderAtaque = rs.getInt("poderAtaque");
				String nombreMapa = rs.getString("nombre_mapa");
				String imagePath = rs.getString("imagen");
				String descripcion = rs.getString("descripcion");
				boolean esHostil = rs.getBoolean("esHostil");
				boolean esCabalgable = rs.getBoolean("esCabalgable");
				int id_Monstruo = rs.getInt("id_Monstruo");

				MonstruoPequeño monstruoPequeño = new MonstruoPequeño(nombre, especie, tamaño, puntosSalud, 
						poderAtaque, nombreMapa, imagePath, descripcion, esHostil, esCabalgable, id_Monstruo);
				listaMonstruosPequeños.add(monstruoPequeño);
			}
		} catch (SQLException e) {
			System.out.println("Error al obtener la lista de monstruos pequeños: " + e.getMessage());
		}

		return listaMonstruosPequeños;
	}

	public void eliminarMonstruoGrande(String nombre) {
		String sql = "DELETE FROM monstruoPequeño WHERE nombre = ?";

		try (Connection conn = BDUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, nombre);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al eliminar el monstruo grande de la base de datos: " + e.getMessage());
		}
	}
}
