package sv.edu.udb.www.beans;


import java.sql.Date;

import sv.edu.udb.www.beans.LogBeans;

public class OfertasBeans {
	
	private String codigoOferta;
	private String tituloOferta;
	private String estado;
	private double precioRegular;
	private double precioOferta;
	private Date fechaInicioOferta;
	private Date fechaFinOferta;
	private Date fechaLimiteCupon;
	private int cantidadLimiteCupones;
	private int cuponesVendidos;
	private String descripcionOferta;
	private double comision;
	private double ingresosTotales;
	public LogBeans logBeans;
	
	public void OfertaBeans() {
		this.codigoOferta = "";
		this.tituloOferta = "";
		this.estado = "";
		this.precioRegular = 0;
		this.precioOferta = 0;
		this.fechaInicioOferta = null;
		this.fechaFinOferta = null;
		this.fechaLimiteCupon = null;
		this.cantidadLimiteCupones = 0;
		this.cuponesVendidos = 0;
		this.descripcionOferta = "";
		this.comision = 0;
		this.ingresosTotales = 0;
		this.logBeans = null;
	}	
	
	public OfertasBeans(String tituloOferta) {
		this.tituloOferta = tituloOferta; }
	
	
	public OfertasBeans(String codigoOferta, String tituloOferta, String estado, double precioRegular, double precioOferta,
			Date fechaInicioOferta, Date fechaFinOferta, Date fechaLimiteCupon, int cantidadLimiteCupones,
			int cuponesVendidos, String descripcionOferta, double comision, double ingresosTotales, LogBeans logBeans) {
		this.codigoOferta = codigoOferta;
		this.tituloOferta = tituloOferta;
		this.estado = estado;
		this.precioRegular = precioRegular;
		this.precioOferta = precioOferta;
		this.fechaInicioOferta = fechaInicioOferta;
		this.fechaFinOferta = fechaFinOferta;
		this.fechaLimiteCupon = fechaLimiteCupon;
		this.cantidadLimiteCupones = cantidadLimiteCupones;
		this.cuponesVendidos = cuponesVendidos;
		this.descripcionOferta = descripcionOferta;
		this.comision = comision;
		this.ingresosTotales = ingresosTotales;
		this.logBeans = logBeans;

	}	
	
	

	public String getCodigoOferta() {
		return codigoOferta;
	}
	public void setCodigoOferta(String codigoOferta) {
		this.codigoOferta = codigoOferta;
	}
	public String getTituloOferta() {
		return tituloOferta;
	}
	public void setTituloOferta(String tituloOferta) {
		this.tituloOferta = tituloOferta;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getPrecioRegular() {
		return precioRegular;
	}
	public void setPrecioRegular(double precioRegular) {
		this.precioRegular = precioRegular;
	}
	public double getPrecioOferta() {
		return precioOferta;
	}
	public void setPrecioOferta(double precioOferta) {
		this.precioOferta = precioOferta;
	}
	public Date getFechaInicioOferta() {
		return fechaInicioOferta;
	}
	public void setFechaInicioOferta(Date fechaInicioOferta) {
		this.fechaInicioOferta = fechaInicioOferta;
	}
	public Date getFechaFinOferta() {
		return fechaFinOferta;
	}
	public void setFechaFinOferta(Date fechaFinOferta) {
		this.fechaFinOferta = fechaFinOferta;
	}
	public Date getFechaLimiteCupon() {
		return fechaLimiteCupon;
	}
	public void setFechaLimiteCupon(Date fechaLimiteCupon) {
		this.fechaLimiteCupon = fechaLimiteCupon;
	}
	public int getCantidadLimiteCupones() {
		return cantidadLimiteCupones;
	}
	public void setCantidadLimiteCupones(int cantidadLimiteCupones) {
		this.cantidadLimiteCupones = cantidadLimiteCupones;
	}
	public int getCuponesVendidos() {
		return cuponesVendidos;
	}
	public void setCuponesVendidos(int cuponesVendidos) {
		this.cuponesVendidos = cuponesVendidos;
	}
	public String getDescripcionOferta() {
		return descripcionOferta;
	}
	public void setDescripcionOferta(String descripcionOferta) {
		this.descripcionOferta = descripcionOferta;
	}
	public double getComision() {
		return comision;
	}
	public void setComision(double comision) {
		this.comision = comision;
	}
	public double getIngresosTotales() {
		return ingresosTotales;
	}
	public void setIngresosTotales(double ingresosTotales) {
		this.ingresosTotales = ingresosTotales;
	}

	

}
