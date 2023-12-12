package ar.unlam.edu.ar;

public class TicketMixto extends Ticket{
	
	private Pasajero pasajero;
	private Carga carga;

	public TicketMixto(Integer id, Pasajero pasajero, Carga carga) {
		super(id);
		this.pasajero = pasajero;
		this.carga = carga;
		// TODO Auto-generated constructor stub
	}
	
	

	public Carga getCarga() {
		return carga;
	}



	public void setCarga(Carga carga) {
		this.carga = carga;
	}



	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	
	

}
