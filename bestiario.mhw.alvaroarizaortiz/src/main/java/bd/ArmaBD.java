package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import enumeraciones.Elemento;

import clases.Arma;
import utils.BDUtil;

public class ArmaBD {

	public void insertArma(Arma arma) {
		try (Connection conn = BDUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement(
						"INSERT INTO arma (nombre, poderAtaque, elementoAtaque, tipoArma) VALUES (?, ?, ?, ?)")) {

			statement.setString(1, arma.getNombre());
			statement.setInt(2, arma.getPoderAtaque());
			statement.setString(3, arma.getElementoAtaque().name());
			statement.setString(4, arma.getTipoArma());

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Arma insertada correctamente: " + arma.getNombre());
			} else {
				System.out.println("No se pudo insertar el arma");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Arma> getAllArmas() {
		List<Arma> armas = new ArrayList<>();

		try (Connection conn = BDUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement("SELECT * FROM arma");
				ResultSet resultSet = statement.executeQuery()) {

			System.out.println("Estas son todas las armas que se han introducido en la Base de Datos: ");
			while (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				int poderAtaque = resultSet.getInt("poder_ataque");
				String elementoAtaqueString = resultSet.getString("elemento_ataque");
				Elemento elementoAtaque = Elemento.valueOf(elementoAtaqueString);
				String tipoArma = resultSet.getString("tipo_arma");

				Arma arma = new Arma(nombre, poderAtaque, elementoAtaque, tipoArma);
				armas.add(arma);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return armas;
	}

	public void deleteArma(Arma arma) {
		try (Connection conn = BDUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement("DELETE FROM arma WHERE nombre = ?")) {

			statement.setString(1, arma.getNombre());

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Arma eliminada correctamente: " + arma.getNombre());
			} else {
				System.out.println("No se pudo eliminar el arma");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
