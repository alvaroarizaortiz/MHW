package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.Mapa;
import utils.BDUtil;

public class MapaBD {
    
    // Obtiene una lista de todos los mapas de la base de datos
    public List<Mapa> getAllMapas() {
        List<Mapa> mapas = new ArrayList<>();
        
        try (Connection conn = BDUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM mapa");
             ResultSet resultSet = statement.executeQuery()) {

        	System.out.println("Estos son todos los mapas que se han introducido en la Base de Datos: ");
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                
                Mapa mapa = new Mapa(nombre);
                mapas.add(mapa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return mapas;
    }
    
    // Inserta un mapa en la base de datos
    public void insertMapa(Mapa mapa) {
        try (Connection conn = BDUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement("INSERT INTO mapa (nombre) VALUES (?)")) {
            
            statement.setString(1, mapa.getNombre());
            
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Mapa insertado correctamente: " + mapa.getNombre());
            } else {
                System.out.println("No se pudo insertar el mapa");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Elimina un mapa de la base de datos
    public void deleteMapa(Mapa mapa) {
        try (Connection conn = BDUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement("DELETE FROM mapa WHERE nombre = ?")) {
            
            statement.setString(1, mapa.getNombre());
            
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Mapa eliminado correctamente: " + mapa.getNombre());
            } else {
                System.out.println("No se pudo eliminar el mapa");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
