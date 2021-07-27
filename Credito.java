package ec.edu.ups.pw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Credito {
	
	@Id
	@Column(name="cod_cred")
	@GeneratedValue
	private int codigo;
	
	private double monto;
	private int numMeses;
	private String fechaCuota;
	private double valor;
	
	@ManyToOne
	@JoinColumn(name="cedula_cliente")
	private Persona persona;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public int getNumMeses() {
		return numMeses;
	}
	public void setNumMeses(int numMeses) {
		this.numMeses = numMeses;
	}
	public String getFechaCuota() {
		return fechaCuota;
	}
	public void setFechaCuota(String fechaCuota) {
		this.fechaCuota = fechaCuota;
	}
	
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
}
