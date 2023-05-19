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
		String sql = "Select t2.nombre, t2.especie, t2.tamaño, t2.puntossalud, t2.id_mapa, t2.poderAtaque, t1.eshostil, t1.escabalgable, t1.id_monstruo from monstruoPequeño as t1\r\n"
				+ "Inner Join monstruo as t2 \r\n" + "on t1.id_monstruo = t2.id;";

		try (Connection conn = BDUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {

				String nombre = rs.getString("nombre");
				String especie = rs.getString("especie");
				int tamaño = rs.getInt("tamaño");
				int puntosSalud = rs.getInt("puntosSalud");
				int id_mapa = rs.getInt("id_Mapa");
				int poderAtaque = rs.getInt("poderAtaque");
				boolean esHostil = rs.getBoolean("esHostil");
				boolean esCabalgable = rs.getBoolean("esCabalgable");
				int id_Monstruo = rs.getInt("id_Monstruo");

				MonstruoPequeño monstruoPequeño = new MonstruoPequeño(nombre, especie, tamaño, puntosSalud, id_mapa,
						poderAtaque, esHostil, esCabalgable, id_Monstruo);
				listaMonstruosPequeños.add(monstruoPequeño);
			}
		} catch (SQLException e) {
			System.out.println("Error al obtener la lista de monstruos grandes: " + e.getMessage());
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
