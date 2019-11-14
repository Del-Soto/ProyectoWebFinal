package beans;

import java.time.LocalDate;

public class Pago {
	private String clavePago;
	private float monto;
	private String fechaPago;
	private int codigo;
	//metodos
	public String getClavePago() {
		return clavePago;
	}
	public void setClavePago(String clavePago) {
		this.clavePago = clavePago;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public String getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
