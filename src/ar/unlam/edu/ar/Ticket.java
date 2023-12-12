package ar.unlam.edu.ar;

import java.util.Objects;

public class Ticket implements Comparable<Ticket>{
	
	private Integer idTicket;
	private Integer idViaje;

	public Ticket(Integer idViaje) {
		super();
		this.idTicket = (int) (Math.random() * 100);		
		this.idViaje = idViaje;
	}

	public Integer getId() {
		return idTicket;
	}

	public void setId(Integer id) {
		this.idTicket = id;
	}
	
	public Integer getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(Integer idViaje) {
		this.idViaje = idViaje;
	}

	public int compareTo(Ticket o) {
		
		return this.getId().compareTo(o.idTicket);
				
	}
	
	

}
