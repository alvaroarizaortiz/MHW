package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.MonstruoGrande;
import clases.PuntoDebil;
import utils.BDUtil;

public class PuntoDebilBD {
	public void insertarPuntoDebil(PuntoDebil puntoDebil) {
		String sql = "INSERT INTO PuntoDebil(nombre, esRompible, resistenciaGolpes, id_puntodebil) VALUES(?,?,?,?)";

		try (Connection conn = BDUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, puntoDebil.getNombre());
			pstmt.setBoolean(2, puntoDebil.getEsRompible());
			pstmt.setByte(3, puntoDebil.getResistenciaGolpes());
			pstmt.setInt(4, puntoDebil.getIdPuntoDebil());
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
				int id_PuntoDebil = rs.getInt("id_puntodebil");
				PuntoDebil puntoDebil = new PuntoDebil(nombre, esRompible, resistenciaGolpes, id_PuntoDebil);
				listaPuntosDebiles.add(puntoDebil);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listaPuntosDebiles;
	}

	public void borrarPuntoDebil(String nombre) {
		String sql = "DELETE FROM PuntoDebil WHERE nombre = ?";

		try (Connection conn = BDUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, nombre);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void insertarMonstruoConPuntosDebiles(MonstruoGrande monstruoGrande) {
		  String sqlInsertMonstruo = "INSERT INTO monstruogrande (esCapturable, resistencias, debilidades) VALUES (?, ?, ?)";
		  String sqlInsertRelacion = "INSERT INTO monstruogrande_puntodebil (id_monstruogrande, id_puntodebil) VALUES (?, ?)";

		  try (Connection conn = BDUtil.getConnection();
		       PreparedStatement pstmtInsertMonstruo = conn.prepareStatement(sqlInsertMonstruo, Statement.RETURN_GENERATED_KEYS);
		       PreparedStatement pstmtInsertRelacion = conn.prepareStatement(sqlInsertRelacion)) {

		    // Insertar el monstruo en la tabla monstruogrande
		    pstmtInsertMonstruo.setBoolean(1, monstruoGrande.isEsCapturable());
		    pstmtInsertMonstruo.setString(2, monstruoGrande.getResistencias().name());
		    pstmtInsertMonstruo.setString(3, monstruoGrande.getDebilidades().name());
		    pstmtInsertMonstruo.executeUpdate();

		    // Obtener el identificador (id_monstruogrande) generado para el monstruo insertado
		    ResultSet generatedKeys = pstmtInsertMonstruo.getGeneratedKeys();
		    int idMonstruoGrande = -1;
		    if (generatedKeys.next()) {
		      idMonstruoGrande = generatedKeys.getInt(1);
		    }

		    // Insertar las relaciones entre el monstruo y los puntos débiles en la tabla monstruogrande_puntodebil
		    ArrayList<PuntoDebil> puntosDebiles = monstruoGrande.getPuntosDebilesMonstruo();
		    for (PuntoDebil puntoDebil : puntosDebiles) {
		        int idPuntoDebil = puntoDebil.getIdPuntoDebil(); // Obtener el valor entero del atributo id
		        
		        pstmtInsertRelacion.setInt(1, idMonstruoGrande);
		        pstmtInsertRelacion.setInt(2, idPuntoDebil);
		        pstmtInsertRelacion.executeUpdate();
		    }

		  } catch (SQLException e) {
		    System.out.println("Error al insertar el monstruo con puntos débiles: " + e.getMessage());
		  }
		}
}
