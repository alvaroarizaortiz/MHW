package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.Armadura;
import enumeraciones.Elemento;
import utils.BDUtil;

public class ArmaduraBD {
    public void insertArmadura(Armadura armadura) {
        try (Connection conn = BDUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(
                     "INSERT INTO armadura (nombre, poderDefensa, resistenciaArmadura, debilidadArmadura) VALUES (?, ?, ?, ?)")) {

            statement.setString(1, armadura.getNombre());
            statement.setInt(2, armadura.getPoderDefensa());
            statement.setString(3, armadura.getResistenciaArmadura().name());
            statement.setString(4, armadura.getDebilidadArmadura().name());

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

                Armadura armadura = new Armadura(nombre, poderDefensa, resistenciaArmadura, debilidadArmadura);
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
}

