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
						"INSERT INTO arma (nombre, poderAtaque, elementoAtaque, tipoArma, imagen, descripcion) VALUES (?, ?, ?, ?, ?, ?)")) {

			statement.setString(1, arma.getNombre());
			statement.setInt(2, arma.getPoderAtaque());
			statement.setString(3, arma.getElementoAtaque().name());
			statement.setString(4, arma.getTipoArma());
			statement.setString(5, arma.getImagePath());
			statement.setString(6, arma.getDescripcion());

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
				int poderAtaque = resultSet.getInt("poderAtaque");
				String elementoAtaqueString = resultSet.getString("elementoAtaque");
				Elemento elementoAtaque = Elemento.valueOf(elementoAtaqueString);
				String tipoArma = resultSet.getString("tipoArma");
				String imagen = resultSet.getString("imagen");
				String descripcion = resultSet.getString("descripcion");

				Arma arma = new Arma(nombre, tipoArma, poderAtaque, elementoAtaque, imagen, descripcion);
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

	public List<String> getNombresArmas() {
		List<String> nombresArmas = new ArrayList<>();
		try (Connection conn = BDUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement("SELECT nombre FROM arma");
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				nombresArmas.add(nombre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nombresArmas;
	}
	
	public Arma getArmaPorNombre(String nombreArma) {
	    Arma arma = null;
	    try (Connection conn = BDUtil.getConnection();
	         PreparedStatement statement = conn.prepareStatement("SELECT * FROM arma WHERE nombre = ?")) {

	        statement.setString(1, nombreArma);
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            String nombre = resultSet.getString("nombre");
	            int poderAtaque = resultSet.getInt("poderAtaque");
	            String elementoAtaqueString = resultSet.getString("elementoAtaque");
	            Elemento elementoAtaque = Elemento.valueOf(elementoAtaqueString);
	            String tipoArma = resultSet.getString("tipoArma");
	            String imagen = resultSet.getString("imagen");
	            String descripcion = resultSet.getString("descripcion");

	            arma = new Arma(nombre, tipoArma, poderAtaque, elementoAtaque, imagen, descripcion);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return arma;
	}

	public Arma getArmaPorId(int idArma) {
	    Arma arma = null;
	    try (Connection conn = BDUtil.getConnection();
	         PreparedStatement statement = conn.prepareStatement("SELECT * FROM arma WHERE id = ?")) {

	        statement.setInt(1, idArma);
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            String nombre = resultSet.getString("nombre");
	            int poderAtaque = resultSet.getInt("poderAtaque");
	            String elementoAtaqueString = resultSet.getString("elementoAtaque");
	            Elemento elementoAtaque = Elemento.valueOf(elementoAtaqueString);
	            String tipoArma = resultSet.getString("tipoArma");
	            String imagen = resultSet.getString("imagen");
	            String descripcion = resultSet.getString("descripcion");

	            arma = new Arma(nombre, tipoArma, poderAtaque, elementoAtaque, imagen, descripcion);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return arma;
	}

}
