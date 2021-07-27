package ec.edu.ups.pw.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.pw.dao.PersonaDAO;
import ec.edu.ups.pw.model.Persona;

@Stateless
public class ClienteON {
	
	@Inject
	private PersonaDAO daoPersona;
	
	public void insertarCliente(Persona persona) throws Exception{
		if(!this.validarCedula(persona.getCedula())) {
			throw new Exception("Cedula incorrecta");
		}
		daoPersona.insert(persona);
	}
	
	public boolean validarCedula(String cedula) {
		if(cedula.length() == 10) {
			return true;
		} 
		return false;
	}
	
	public List<Persona> getClientes(){
		return daoPersona.getClientes("%");
	}
}
