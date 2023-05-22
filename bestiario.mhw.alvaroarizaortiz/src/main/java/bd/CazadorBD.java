package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.Cazador;
import utils.BDUtil;

public class CazadorBD {
	public int getIdNombre(String tableName, String name) {
		int id = -1;
		try (Connection conn = BDUtil.getConnection();
				PreparedStatement statement = conn
						.prepareStatement("SELECT id FROM " + tableName + " WHERE nombre = ?")) {
			statement.setString(1, name);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public void insertCazador(Cazador cazador) {
		try (Connection conn = BDUtil.getConnection();
				PreparedStatement statement = conn
						.prepareStatement("INSERT INTO cazador (idArma, idArmadura, puntosSalud) VALUES (?, ?, ?)")) {
			int idArma = getIdNombre("arma", cazador.getArmaEquipada().getNombre());
			int idArmadura = getIdNombre("armadura", cazador.getArmaduraEquipada().getNombre());
			statement.setInt(1, idArma);
			statement.setInt(2, idArmadura);
			statement.setInt(3, cazador.getSaludCazador());

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Cazador insertado correctamente.");
			} else {
				System.out.println("No se pudo insertar el cazador");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteTablaCazador() {
		try (Connection conn = BDUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement("DELETE FROM cazador")) {
			
		} catch (SQLException e) {
			System.out.println("Ocurrió un error al intentar eliminar los cazadores creados");
			e.printStackTrace();
		}
	}
}
