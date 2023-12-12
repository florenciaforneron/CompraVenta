package ar.unlam.edu.ar;

public class TransporteMixto extends MedioTransporte implements iCargable{

	private Integer cantidadPasajerosMaximos;
	private Double cargaMaxima;
	
	public TransporteMixto(String patente,Integer cantidadPasajerosMaximos,Double cargaMaxima) {
		super(patente);
		this.cantidadPasajerosMaximos = cantidadPasajerosMaximos;
		this.cargaMaxima = cargaMaxima;
	}

	/*
	 * No se pueden agregar mas Atributos
	 */

 

	public Integer getCantidadPasajerosMaximos() {
		return cantidadPasajerosMaximos;
	}

	public void setCantidadPasajerosMaximos(Integer cantidadPasajerosMaximos) {
		this.cantidadPasajerosMaximos = cantidadPasajerosMaximos;
	}

	public Double getCargaMaxima() {
		return cargaMaxima;
	}

	public void setCargaMaxima(Double cargaMaxima) {
		this.cargaMaxima = cargaMaxima;
	}

	@Override
	public Double obtenerCantidadMaximaDeCarga() {
		
		return cargaMaxima;
	}


	
	

}
