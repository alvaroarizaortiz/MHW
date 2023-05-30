package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BDUtil {
	// Está configurado con user predeterminado root y sin contraseña, añadir tus datos si fuera necesario.
	private static final String URL = "jdbc:mysql://localhost/monsterhunterworld";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
