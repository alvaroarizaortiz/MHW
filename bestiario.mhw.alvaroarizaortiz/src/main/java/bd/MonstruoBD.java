package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.Monstruo;
import utils.BDUtil;

public class MonstruoBD {

	// Inserta un monstruo en la base de datos según el mapa
	public void insertarMonstruo(Monstruo monstruo, int id_mapa) {
		String sql = "INSERT INTO Monstruo(nombre, especie, tamaño, puntosSalud, poderAtaque, id_mapa, imagen, descripcion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = BDUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, monstruo.getNombre());
			pstmt.setString(2, monstruo.getEspecie());
			pstmt.setFloat(3, monstruo.getTamaño());
			pstmt.setInt(4, monstruo.getPuntosSalud());
			pstmt.setInt(5, monstruo.getPoderAtaque());
			pstmt.setInt(6, id_mapa);
			pstmt.setString(7, monstruo.getImagePath());
			pstmt.setString(8, monstruo.getDescripcion());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// Obtiene una lista de todos los monstruos en la base de datos
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
				int poderAtaque = rs.getInt("poderAtaque");
				String nombreMapa = rs.getString("nombre_mapa");
				String imagePath = rs.getString("imagen");
				String descripcion = rs.getString("descripcion");
				Monstruo monstruo = new Monstruo(nombre, especie, tamaño, puntosSalud, poderAtaque, nombreMapa,
						imagePath, descripcion);
				listaMonstruos.add(monstruo);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listaMonstruos;
	}

	// Elimina un monstruo de la base de datos por su ID
	public void eliminarMonstruo(int id) {
		String sql = "DELETE FROM Monstruo WHERE id = ?";

		try (Connection conn = BDUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// Obtiene una lista de los nombres de todos los monstruos en la base de datos
	public List<String> getNombresMonstruos() {
		List<String> nombresMonstruos = new ArrayList<>();
		try (Connection conn = BDUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement("SELECT nombre FROM monstruo");
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				nombresMonstruos.add(nombre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nombresMonstruos;
	}
	
	
}
