package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Pago;



public class PagoDao extends BDConnection {
	public int registrarPago(Pago pago) {
		int resultado=0;
		try {
			getConnection();
			if(connection!=null) {
				String query ="insert into pago(clavePago,monto,fechaPago) values(?,?,?)";
				PreparedStatement preparedStatement= connection.prepareStatement(query);
				preparedStatement.setString(1,pago.getClavePago());
				preparedStatement.setFloat(2, pago.getMonto());
				preparedStatement.setString(3, pago.getFechaPago());
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
	public int eliminarPago(Pago pago) {
		int resultado=0;
		try {
			getConnection();
			if(connection!=null) {
				String query ="delete from pago where clavePago=?";
				PreparedStatement preparedStatement= connection.prepareStatement(query);
				preparedStatement.setString(1,pago.getClavePago());
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
	public Pago consultarPago(Pago pago1) {
		Pago pago2=new Pago();
		try {
			getConnection();
			if(connection!=null) {
				String query ="select * from pago where clavePago=(?)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, pago1.getClavePago());
				ResultSet rs = preparedStatement.executeQuery();
				if(rs.getRow()>=0) {
					if(rs.next()) {
					pago2.setClavePago(rs.getNString("ClavePago"));
					pago2.setMonto(rs.getFloat(2));
					
				}
				} else {
					pago2.setCodigo(-1);
				}
			}
			
	}catch (SQLException sqle ) {
		sqle.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return pago2;

}
	public int actualizarPago(Pago pago2,Pago pago3) {
		int resultado=0;
		try {
			getConnection();
			if (connection != null) {
				String query="update pago set clavePago=(?), monto=(?), fechaPago=(?) ";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				 preparedStatement.setString(1, pago2.getClavePago());
				 preparedStatement.setFloat(2, pago2.getMonto());
				 preparedStatement.setString(3, pago2.getFechaPago());
				 resultado =  preparedStatement.executeUpdate();
				 if(resultado>=1) {
					 pago2.setCodigo(1);
					 System.err.println("Se actualizo la informacion correctamente");
				 }else {
					 pago2.setCodigo(-1);
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
