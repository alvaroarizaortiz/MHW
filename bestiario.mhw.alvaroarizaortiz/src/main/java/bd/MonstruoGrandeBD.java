package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.Monstruo;
import clases.MonstruoGrande;
import enumeraciones.Elemento;
import utils.BDUtil;

public class MonstruoGrandeBD {
	public void insertarMonstruoGrande(MonstruoGrande monstruoGrande) {
		String sql = "INSERT INTO monstruoGrande ( escapturable, resistencias, debilidades, id_Monstruo, puntodebil) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = BDUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setBoolean(1, monstruoGrande.isEsCapturable());
			pstmt.setString(2,
					monstruoGrande.getResistencias() != null ? monstruoGrande.getResistencias().name() : " ");
			pstmt.setString(3, monstruoGrande.getDebilidades() != null ? monstruoGrande.getDebilidades().name() : " ");
			pstmt.setInt(4, monstruoGrande.getId_Monstruo());
			pstmt.setString(5, monstruoGrande.getPuntoDebil());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar el monstruo grande en la base de datos: " + e.getMessage());
		}
	}

	public List<MonstruoGrande> listarMonstruosGrandes() {
		List<MonstruoGrande> listaMonstruosGrandes = new ArrayList<>();
		String sql = "SELECT t2.nombre, t2.especie, t2.tamaño, t2.puntossalud, m.nombre AS nombre_mapa, t2.poderAtaque, t2.imagen, t2.descripcion, t1.escapturable, t1.resistencias, t1.debilidades, t1.id_monstruo, t1.puntoDebil "
				+ "FROM monstruoGrande AS t1 " + "INNER JOIN monstruo AS t2 ON t1.id_monstruo = t2.id "
				+ "INNER JOIN mapa AS m ON t2.id_mapa = m.id " + "ORDER BY t2.nombre;";

		try (Connection conn = BDUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				String name = rs.getString("nombre");
				String especie = rs.getString("especie");
				int tamaño = rs.getInt("tamaño");
				int poderAtaque = rs.getInt("poderAtaque");
				int puntosSalud = rs.getInt("puntossalud");
				String nombreMapa = rs.getString("nombre_mapa");
				String imagePath = rs.getString("imagen");
				String descripcion = rs.getString("descripcion");
				String puntoDebil = rs.getString("puntoDebil");
				boolean esCapturable = rs.getBoolean("escapturable");

				String resistenciasStr = rs.getString("resistencias");
				Elemento resistencias = Elemento.valueOf(resistenciasStr.toUpperCase());

				String debilidadesStr = rs.getString("debilidades");
				Elemento debilidades = Elemento.valueOf(debilidadesStr.toUpperCase());

				int id_Monstruo = rs.getInt("id_monstruo");

				MonstruoGrande monstruo = new MonstruoGrande(name, especie, tamaño, poderAtaque, puntosSalud,
						nombreMapa, imagePath, descripcion, puntoDebil, esCapturable, resistencias, debilidades,
						id_Monstruo);
				listaMonstruosGrandes.add(monstruo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaMonstruosGrandes;
	}

	public void eliminarMonstruoGrande(String nombre) {
		String sql = "DELETE FROM monstruoGrande WHERE nombre = ?";

		try (Connection conn = BDUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, nombre);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al eliminar el monstruo grande de la base de datos: " + e.getMessage());
		}
	}

	public Monstruo getMonstruoPorNombre(String nombreMonstruo) {
		Monstruo monstruo = null;
		try (Connection conn = BDUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement("SELECT * FROM monstruoWHERE nombre = ?")) {

			statement.setString(1, nombreMonstruo);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				int puntosSalud = resultSet.getInt("puntosSalud");
				int poderAtaque = resultSet.getInt("poderataque");
				String imagePath = resultSet.getString("imagen");

				monstruo = new Monstruo(nombre, puntosSalud, poderAtaque, imagePath);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return monstruo;
	}
	
	public MonstruoGrande getMonstruoGrandePorNombre(String nombre) {
	    Monstruo monstruo = null;
	    try (Connection conn = BDUtil.getConnection();
	         PreparedStatement statement = conn.prepareStatement("SELECT * FROM monstruo WHERE nombre = ?")) {

	        statement.setString(1, nombre);
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            String nombreMonstruo = resultSet.getString("nombre");
	            int puntosSalud = resultSet.getInt("puntosSalud");
	            int poderAtaque = resultSet.getInt("poderAtaque");
	            String imagePath = resultSet.getString("imagen");

	            monstruo = new Monstruo(nombreMonstruo, puntosSalud, poderAtaque, imagePath);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    if (monstruo != null) {
	        return new MonstruoGrande(monstruo.getNombre(), monstruo.getPuntosSalud(), monstruo.getPoderAtaque(), monstruo.getImagePath());
	    } else {
	        return null;
	    }
	}
	 
	
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
