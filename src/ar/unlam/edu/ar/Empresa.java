package ar.unlam.edu.ar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Empresa {

	private String nombre;
	private Map<Integer, Viaje> viajes;

	// Se registran todas las ventas de pasajes de los pasajeros
	private Set<Ticket> tickets;
	
	private Integer idViajeActual;

	public Empresa(String nombre) {
		this.nombre = nombre;
		this.idViajeActual = 1;
		viajes = new HashMap<>();
		tickets = new TreeSet<>();
	}
	
	

	public Set<Ticket> getTickets() {
		return tickets;
	}



	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}



	public Integer getIdViajeActual() {
		return idViajeActual;
	}



	public void setIdViajeActual(Integer idViajeActual) {
		this.idViajeActual = idViajeActual;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Map<Integer, Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Map<Integer, Viaje> viajes) {
		this.viajes = viajes;
	}

	/*
	 * Registra Un Nuevo viaje se debe guardar en un mapa donde la Key es un entero
	 * y es autoincremental arrancando de 0
	 */
	public void registrarViaje(Viaje viaje) {
		Integer id = 0;
		id = idViajeActual++;
		
		viajes.put(id, viaje);

	}

	/*
	 * Registra Un ticket para carga TicketCarga.class 
	 * Si el viaje no admite Carga lanza TipoTicketInvalidoExcption
	 *  si supera El peso maximo que soporta el   medioTransprte Lanza Una exception CapacidadExcedidaException
	 */

	public void registrarTicketcarga(Integer numeroViaje, Carga carga) throws TipoTicketInvalidoException, CapacidadExcedidaException {
		Viaje viajeActual = viajes.get(numeroViaje);
		MedioTransporte medio = viajeActual.getMedioTransporte();
		if( medio instanceof TransporteCarga) {
			Double cargaMaxima = ((TransporteCarga) medio).obtenerCantidadMaximaDeCarga();
			if(carga.getPeso() < cargaMaxima) {
				Ticket ticket = new TicketCarga(numeroViaje, carga);
				tickets.add(ticket);
			}else {
				throw new CapacidadExcedidaException("Peso excedido");
			}
			
		}else throw new TipoTicketInvalidoException("ticket invalido");


	}

	/*
	 * Se registra un TicketPasajero TicketPasajero 
	 * Si el viaje no admite pasajeros lanza TipoTicketInvalidoExcption 
	 * si supera la cantidad de pasajero que soporta el medioTransprte Lanza Una exception CantidadPasajeroSobrepasadaException
	 */
	
	/*if(personas.size() == 0) {
			this.personas.add(persona);
			}else {
				for (Persona persona1 : personas) {
					if (persona1.getDni() == persona.getDni() ) {
						
						throw new PersonaDuplicadaException("personas con el mismo dni");
						
					} else {
						this.personas.add(persona);
					}
				}		
			}
	}*/

	public void registrarTicketPasajero(Integer numeroViaje, Pasajero pasajero) throws TipoTicketInvalidoException{
		
		Viaje viajeActual = viajes.get(numeroViaje);
		if(viajeActual.getMedioTransporte() instanceof TransportePasajero) {
			Ticket ticket = new TicketPasajero(numeroViaje, pasajero);			
			tickets.add(ticket);
		}else throw new TipoTicketInvalidoException("ticket invalido");

		/*for (Integer clave : viajes.keySet()) {
		    Viaje valor = viajes.get(numeroViaje);
		    System.out.println("Clave: " + clave + ", Valor: " + valor);
		}
		Ticket ticket = new Ticket(numeroViaje);
		tickets = new TreeSet<>();
		tickets.add(ticket);*/
		
		Integer hola = 0;
		hola = hola++;
		

	}
	
	public Integer getCantidadDePasajeros() {
		return viajes.size();
		}
	/*
	 * Se registra un TicketMixto TicketMixto.class  
	 * si supera la cantidad de pasajero que soporta el medioTransprte Lanza Una exception CantidadPasajeroSobrepasadaException
	 * si supera El peso maximo que soporta el   medioTransprte Lanza Una exception CapacidadExcedidaException
	 */

	public void registrarTicketMixto(Integer numeroViaje, Pasajero pasajero,Carga carga) throws TipoTicketInvalidoException {
		Viaje viajeActual = viajes.get(numeroViaje);
		if(viajeActual.getMedioTransporte() instanceof TransporteMixto) {
			Ticket ticket = new TicketMixto(numeroViaje, pasajero, carga);
			tickets.add(ticket);
		}else throw new TipoTicketInvalidoException("ticket invalido");

	}


	
	public Ticket buscarTicketPorIdDeViaje(Integer id) {
		for(Ticket ticket: tickets) {
			if (ticket.getIdViaje().equals(id)) {
				return ticket;
			}
		}
		return null;
	}
	
	public Double obtenerCantidadTotalDeCargaTransportada() {

		Double total = 0.0;
		for(Ticket ticket: tickets) {
			if((ticket instanceof TicketCarga)) {
				TicketCarga ticketCarga = (TicketCarga) ticket;
				total = total + ticketCarga.getCarga().getPeso();
			}if((ticket instanceof TicketMixto)) {
					TicketMixto ticketMixto = (TicketMixto) ticket;
					total = total + ticketMixto.getCarga().getPeso();			
			}
		}
		return total;
	}
	
	
	
	
	/*
	 * retorna la lista de pasajero enforma Descendiente Lanza una exception si el
	 * viaje no existe o si el tipo de viaje No es compatible para trnssporte de
	 * pasajero lanza una exception si el viaje no existe
	 */

	public TreeSet<Pasajero> obtenerListaPasajeroOrdenadosPorDNIDescendiente(Integer numeroViaje) {
		Set<Pasajero> pasajeros = new TreeSet<Pasajero>();
		
		for(Ticket ticket: tickets) {
			if((ticket instanceof TicketPasajero)) {
				if(ticket.getIdViaje().equals(numeroViaje)) {
					TicketPasajero ticketPasajero = (TicketPasajero) ticket;
					pasajeros.add(ticketPasajero.getPasajero());
				}
			}if((ticket instanceof TicketMixto)) {
				if(ticket.getIdViaje().equals(numeroViaje)) {
					TicketMixto ticketMixto = (TicketMixto) ticket;
					pasajeros.add(ticketMixto.getPasajero());
				}
			}
		}
		return (TreeSet<Pasajero>) pasajeros;
	}

	public Double obtenerELTotalDeCargaTransportadaEnTodosLosViajes() {

		return null;
	}

}
