package ar.unlam.edu.ar;

public class TransportePasajero extends MedioTransporte{
	
	private Integer cantidadPasajerosMaximos;

	public TransportePasajero(String patente, Integer cantidadPasajerosMaximos) {
		super(patente);
		this.cantidadPasajerosMaximos = cantidadPasajerosMaximos;
		// TODO Auto-generated constructor stub
	}

}
