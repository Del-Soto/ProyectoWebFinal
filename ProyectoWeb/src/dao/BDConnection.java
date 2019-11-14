package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BDConnection {
	Connection connection= null;
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/web", "root", "Date");
			System.err.println("-->Conexio exitosa ");
		} catch (SQLException ex) {
			System.err.println("-->SQL error Conexion");
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("-->Conector error Conexion");
			e.printStackTrace();	

		}
		return connection;
	}
	public  void cerrrarConexion() {
		try {
			if(connection!=null) {
				connection.close();
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
