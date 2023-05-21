package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.Arma;
import clases.Armadura;
import enumeraciones.Elemento;
import utils.BDUtil;

public class ArmaduraBD {
	public void insertArmadura(Armadura armadura) {
		try (Connection conn = BDUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement(
						"INSERT INTO armadura (nombre, poderDefensa, resistenciaArmadura, debilidadArmadura, imagen) VALUES (?, ?, ?, ?, ?, ?)")) {

			statement.setString(1, armadura.getNombre());
			statement.setInt(2, armadura.getPoderDefensa());
			statement.setString(3, armadura.getResistenciaArmadura().name());
			statement.setString(4, armadura.getDebilidadArmadura().name());
			statement.setString(5, armadura.getImagePath());
			statement.setString(6, armadura.getDescripcion());

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Armadura insertada correctamente: " + armadura.getNombre());
			} else {
				System.out.println("No se pudo insertar la armadura");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Armadura> getAllArmaduras() {
		List<Armadura> armaduras = new ArrayList<>();

		try (Connection conn = BDUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement("SELECT * FROM armadura");
				ResultSet resultSet = statement.executeQuery()) {

			System.out.println("Estas son todas las armaduras que se han introducido en la Base de Datos:");
			while (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				int poderDefensa = resultSet.getInt("poderDefensa");
				String resistenciaArmaduraString = resultSet.getString("resistenciaArmadura");
				Elemento resistenciaArmadura = Elemento.valueOf(resistenciaArmaduraString);
				String debilidadArmaduraString = resultSet.getString("debilidadesArmadura");
				Elemento debilidadArmadura = Elemento.valueOf(debilidadArmaduraString);
				String imagen = resultSet.getString("imagen");
				String descripcion = resultSet.getString("descripcion");

				Armadura armadura = new Armadura(nombre, poderDefensa, resistenciaArmadura, debilidadArmadura, imagen,
						descripcion);
				armaduras.add(armadura);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return armaduras;
	}

	public void deleteArmadura(Armadura armadura) {
		try (Connection conn = BDUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement("DELETE FROM armadura WHERE nombre = ?")) {

			statement.setString(1, armadura.getNombre());

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Armadura eliminada correctamente: " + armadura.getNombre());
			} else {
				System.out.println("No se pudo eliminar la armadura");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<String> getNombresArmaduras() {
		List<String> nombresArmaduras = new ArrayList<>();
		try (Connection conn = BDUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement("SELECT nombre FROM armadura");
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				nombresArmaduras.add(nombre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nombresArmaduras;
	}

	public Armadura getArmaduraPorNombre(String nombreArmadura) {
		Armadura armadura = null;
		try (Connection conn = BDUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement("SELECT * FROM armadura WHERE nombre = ?")) {

			statement.setString(1, nombreArmadura);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				int poderDefensa = resultSet.getInt("poderDefensa");
				String resistenciaArmaduraString = resultSet.getString("resistenciaArmadura");
				Elemento resistenciaArmadura = Elemento.valueOf(resistenciaArmaduraString);
				String debilidadArmaduraString = resultSet.getString("debilidadArmadura");
				Elemento debilidadArmadura = Elemento.valueOf(debilidadArmaduraString);
				String imagen = resultSet.getString("imagen");
				String descripcion = resultSet.getString("descripcion");
				armadura = new Armadura(nombre, poderDefensa, resistenciaArmadura, debilidadArmadura, imagen,
						descripcion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return armadura;
	}

}
