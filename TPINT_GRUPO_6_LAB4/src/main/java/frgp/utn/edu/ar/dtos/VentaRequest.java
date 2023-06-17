package frgp.utn.edu.ar.dtos;

import java.util.Date;

import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.dominio.Ventas;

public class VentaRequest {
	
	private int id;
	private Date fecha;
    private double montoTotal;
    private Cliente cliente;
	private boolean estado;
	
	@Override
	public String toString() {
		return "Fecha = " + fecha + ", Monto Total = " + montoTotal + ", Cliente = " + cliente.getDni() + ", estado = "
				+ estado + "";
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public Ventas construirVenta(){
		Ventas  a = new Ventas(fecha, montoTotal, cliente, estado);

        if(id != 0){
            a.setId(id);
        }
        return a;
    }
	

}
