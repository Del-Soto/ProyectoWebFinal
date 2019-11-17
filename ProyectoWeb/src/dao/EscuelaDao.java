package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Escuela;
import beans.Tutor;

public class EscuelaDao extends BDConnection{

	public int registrarEscuela(Escuela contacto)
	{
		int resultado=0;
		
		try
		{
			getConnection();
			if(connection != null)
			{
				String query = "insert into contacto (telefono, correo) "
						+ "	values (?, ?);";
				PreparedStatement preparedStatement = connection.prepareStatement(query);

				preparedStatement.setString(1, contacto.getTelefono());
				preparedStatement.setString(2, contacto.getCorreo());
				
				resultado = preparedStatement.executeUpdate();
				
				if (resultado >= 1) {
					System.out.println("Se insertaron " + resultado + " columnas");
				} else {
					System.err.println("No se logro insertr ningun registro");
					resultado=-1;
				}
			}
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return resultado;
	}
		
	public Integer actualizaPersona(Escuela contacto) {
		System.out.println("--->"+contacto.getId());
		try {
			int id = contacto.getId();
			String query = "UPDATE contacto SET telefono='"+contacto.getTelefono()+"',correo='"+contacto.getCorreo()+"' WHERE id_contacto="+(id);
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);		
			Integer row = preparedStatement.executeUpdate(query);
			if (row > 0) {
				contacto.setCodigo(1);
				
				System.out.println("Se actualizo la informaci贸n correctamente");
			} else {
				contacto.setCodigo(-1);
				System.err.println("No se puedo realizar la actualizaci贸n o no existe el id");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacto.getCodigo();
	}
	public Integer borrar(Tutor tutor) {
		System.out.println("--->"+tutor.getId());
		try {
			int id = tutor.getId();
			String query = "DELETE FROM Tutor WHERE id_tutor="+id;
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);		
			Integer row = preparedStatement.executeUpdate(query);
			if (row > 0) {
				tutor.setCodigo(1);
				
				System.out.println("Se elimino correctamente");
			} else {
				tutor.setCodigo(-1);
				System.err.println("No se puedo eliminar");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tutor.getCodigo();
	}
	
	public Integer borrar(Escuela contacto) {
		System.out.println("--->"+contacto.getId());
		try {
			int id = contacto.getId();
			String query = "DELETE FROM contacto WHERE id_contacto="+id;
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);		
			Integer row = preparedStatement.executeUpdate(query);
			if (row > 0) {
				contacto.setCodigo(1);
				
				System.out.println("Se elimino correctamente");
			} else {
				contacto.setCodigo(-1);
				System.err.println("No se puedo eliminar");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacto.getCodigo();
	}
	public Escuela findbyId(int id)
	{
		Escuela contacto = new Escuela();
		try
		{
			Connection connection = getConnection();
			if(connection != null)
			{
				String query = "select * from contacto where idEscuela=? and telefono=?";
				PreparedStatement preparestatement = connection.prepareStatement(query);
				preparestatement.setString(1, Integer.toString(id));
				ResultSet rs = preparestatement.executeQuery();
				System.out.println("Numero de coincidencias" + rs.getRow());
				
				if(rs.getRow() >0)
				{
					if(rs.next())
					{
						contacto.setTelefono(rs.getString(1));
						contacto.setCorreo(rs.getString(2));
					}
				}
				else
				{
					
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		cerrrarConexion();
		return contacto;
	}
	
}