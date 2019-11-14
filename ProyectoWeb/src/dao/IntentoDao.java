package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Intento;



public class IntentoDao extends BDConnection {
	public int registrarIntento(Intento intento) {
		int resultado=0;
		try {
			getConnection();
			if(connection!=null) {
				String query ="insert into intentos(intento,institucion,fechaIntento) values(?,?,?)";
				PreparedStatement preparedStatement= connection.prepareStatement(query);
				preparedStatement.setInt(1,intento.getIntento());
				preparedStatement.setString(2, intento.getInstitucion());
				preparedStatement.setString(3, intento.getFechaintento());
				resultado= preparedStatement.executeUpdate();
				if(resultado>=1) {
					System.out.println("Se registraron " + resultado + " columnas");
				} else {
					System.err.println("no se logro registrar ningun registro");
					resultado=-1;
				}
			}
		}catch (SQLException sqle ) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	public int eliminarIntento(Intento intento) {
		int resultado=0;
		try {
			getConnection();
			if(connection!=null) {
				String query ="delete from intentos where institucion=?";
				PreparedStatement preparedStatement= connection.prepareStatement(query);
				preparedStatement.setString(1,intento.getInstitucion());
				resultado= preparedStatement.executeUpdate();
				if(resultado>=1) {
					System.out.println("Se eliminaron " + resultado + " columnas");
				} else {
					System.err.println("no se logro eliminar ningun registro");
					resultado=-1;
				}
			}
		}catch (SQLException sqle ) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	public Intento consultarIntento(Intento intento1) {
		Intento intento2=new Intento();
		try {
			getConnection();
			if(connection!=null) {
				String query ="select * from intentos where institucion=(?)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, intento1.getInstitucion());
				ResultSet rs = preparedStatement.executeQuery();
				if(rs.getRow()>=0) {
					if(rs.next()) {
					intento2.setInstitucion(rs.getNString("institucion"));
					intento2.setIntento(rs.getInt(1));
					intento2.setFechaintento(rs.getString(3));
					
				}
				} else {
					intento2.setCodigo(-1);
				}
			}
			
	}catch (SQLException sqle ) {
		sqle.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return intento2;

}
	public int actualizarIntento(Intento intento2,Intento intento3) {
		int resultado=0;
		try {
			getConnection();
			if (connection != null) {
				String query="update pago set clavePago=(?), monto=(?), fechaPago=(?) ";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				 preparedStatement.setInt(1, intento2.getIntento());
				 preparedStatement.setString(2, intento2.getInstitucion());
				 preparedStatement.setString(3, intento2.getFechaintento());
				 resultado =  preparedStatement.executeUpdate();
				 if(resultado>=1) {
					 intento2.setCodigo(1);
					 System.err.println("Se actualizo la informacion correctamente");
				 }else {
					 intento2.setCodigo(-1);
					 System.err.println("no se puedo realizar la actualizacion");
				 }
			}
		}catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
}

