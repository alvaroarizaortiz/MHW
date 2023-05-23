package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.Arma;
import clases.Armadura;
import clases.Cazador;
import enumeraciones.Elemento;
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
						.prepareStatement("INSERT INTO cazador (idArma, idArmadura, puntosSalud, nombre) VALUES (?, ?, ?, ?)")) {
			int idArma = getIdNombre("arma", cazador.getArmaEquipada().getNombre());
			int idArmadura = getIdNombre("armadura", cazador.getArmaduraEquipada().getNombre());
			statement.setInt(1, idArma);
			statement.setInt(2, idArmadura);
			statement.setInt(3, cazador.getSaludCazador());
			statement.setString(4,cazador.getNombre());

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

	public List<Cazador> getAllCazadores() {
		List<Cazador> cazadores = new ArrayList<>();

		String sql = "SELECT puntosSalud, idArmadura, idArma, nombre FROM cazador ";
		try (Connection conn = BDUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {

			ArmaduraBD armaduraBD = new ArmaduraBD();
			ArmaBD armaBD = new ArmaBD();
			while (resultSet.next()) {
				int idArmadura = resultSet.getInt("idArmadura");
				int idArma = resultSet.getInt("idArma");
				Armadura armadura = armaduraBD.getArmaduraPorID(idArmadura);
				Arma arma = armaBD.getArmaPorId(idArma);
				int saludCazador = resultSet.getInt("puntosSalud");
				String nombre = resultSet.getString("nombre");

				Cazador cazador = new Cazador(saludCazador, armadura, arma, nombre);
				cazadores.add(cazador);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cazadores;
	}

}
