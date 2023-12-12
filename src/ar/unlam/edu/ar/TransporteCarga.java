package ar.unlam.edu.ar;

public class TransporteCarga extends MedioTransporte implements iCargable{
	
	private Double cargaMaxima;

	public TransporteCarga(String patente, Double cargaMaxima) {
		super(patente);
		this.cargaMaxima = cargaMaxima;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double obtenerCantidadMaximaDeCarga() {
		
		return cargaMaxima;
	}

}
