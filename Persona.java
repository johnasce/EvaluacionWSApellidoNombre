package ec.edu.ups.pw.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Persona {
	
	@Id
	@Column(name = "cedula_cliente")
	private String cedula;
	private String nombre;
	private String apellido;
	
	@OneToOne
	@JoinColumn(name="id_domicilio")
	private Domicilio domicilio;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Factura> facturas;
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
	
	private List<Credito> creditos;
	
	
	public List<Credito> getCreditos() {
		return creditos;
	}
	public void setCreditos(List<Credito> creditos) {
		this.creditos = creditos;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Domicilio getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	public List<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	
	
	
}
