package ec.edu.ups.pw.services;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.pw.business.CreditoON;
import ec.edu.ups.pw.model.Credito;

@WebService
public class SolicitudCredito {
	
	@Inject
	private CreditoON creditoON;
	
	@WebMethod
	public String registrarCredito(Credito credito) {
		try {
			creditoON.insertarCredito(credito);
			return "Credito ingresado";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error al ingresar credito";
			
		}
	}

	@WebMethod
	public int sumar(int a, int b) {
		return a +b;
	}
}
