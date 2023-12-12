package ar.unlam.edu.ar;

public class TicketPasajero extends Ticket{

	private Pasajero pasajero;
	
	public TicketPasajero(Integer id, Pasajero pasajero) {
		super(id);
		this.pasajero = pasajero;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	
	


}


