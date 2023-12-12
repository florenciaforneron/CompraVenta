package ar.unlam.edu.ar;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.TreeSet;

import org.junit.Test;

public class TestComaniaTransporte {

	@Test
	public void queSePuedaRegistrarUnViaje() {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Integer cantidadPasajerosMaximos = 50;
		MedioTransporte medioTransporte = new TransportePasajero(Patente, cantidadPasajerosMaximos);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Boolean valorObtenido = empresa.getViajes().containsValue(viaje);
		assertTrue(valorObtenido);

	}

	@Test
	public void queSePuedaRegistrarUnTicketDePasajeroAUnViaje() throws TipoTicketInvalidoException{

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Integer cantidadPasajerosMaximos = 50;
		MedioTransporte medioTransporte = new TransportePasajero(Patente, cantidadPasajerosMaximos);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;
		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);

		empresa.registrarTicketPasajero(numeroViaje, pasajero);
		//MedioTransporte medioTransporteActual = empresa.getViajes().get(numeroViaje).getMedioTransporte();
		Boolean esTicketPasajero = (empresa.buscarTicketPorIdDeViaje(numeroViaje) instanceof TicketPasajero);
	
		assertTrue(esTicketPasajero);


		// Completar Test

		
		
		//#1 empresa.getTickets().constain(), tener ticket esperado
		//#2 empresa.getTicketBy(numero de viaje) 

	}

	@Test(expected=TipoTicketInvalidoException.class)
	public void queAlRegistrarUnTicketDePasajeroAUnViajeConMedioDeTransporteDeCargaLanceUnaException() throws TipoTicketInvalidoException{

		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Double cargaMaxima = 50.0;
		MedioTransporte medioTransporte = new TransporteCarga(Patente, cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;

		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		empresa.registrarTicketPasajero(numeroViaje, pasajero);

		// Completar test

	}

	
	@Test
	public void queSePuedaRegistrarUnTicketDeCargaAUnViaje() throws TipoTicketInvalidoException, CapacidadExcedidaException {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Double cargaMaxima = 50.0;
		MedioTransporte medioTransporte = new TransporteCarga(Patente, cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);
		
		
		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;
		empresa.registrarTicketcarga(numeroViaje, new Carga(1, 10.0));
		// Completar Test
		
		Boolean valorObtenido = empresa.getViajes().containsValue(viaje);
		assertTrue(valorObtenido);
		
		

	}

	@Test
	public void queSePuedaRegistrarUnTicketMixtoAUnViaje() throws TipoTicketInvalidoException {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";



		Double cargaMaxima = 50.0;

		Integer cantidadPasajerosMaximos = 50;

		MedioTransporte medioTransporte = new TransporteMixto(Patente, cantidadPasajerosMaximos,cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;
		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		Carga carga=new Carga(1, 10.0);
		empresa.registrarTicketMixto(numeroViaje, pasajero,carga);
		
		

		// Completar Test
		Boolean valorObtenido = empresa.getViajes().containsValue(viaje);
		assertTrue(valorObtenido);
		

	}
	
	

	@Test(expected=CapacidadExcedidaException.class)
	public void queAlRegistrarUnticketYExcedalaCargaMaximaDelTransporteLanceUnaExceptionCapacidadExcedidaException() throws TipoTicketInvalidoException, CapacidadExcedidaException {
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Double cargaMaxima = 50.0;
		MedioTransporte medioTransporte = new TransporteCarga(Patente, cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);
		
		
		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;
		empresa.registrarTicketcarga(numeroViaje, new Carga(1, 60.0));
		
		
	}

	@Test
	public void queSePuedaObtenerUnaListaPasajeroDeUnViajeOrdenadoPorDNIDescendiente() throws TipoTicketInvalidoException {
		// Desarrollar test
		// Debe invcar el Metodo obtenerListaPasajeroOrdenadosPorDNIDescendiente(Integer
		// numeroViaje) y este retorna un Treeset <Pasajero>

		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Integer cantidadPasajerosMaximos = 50;
		MedioTransporte medioTransporte = new TransportePasajero(Patente, cantidadPasajerosMaximos);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		Viaje viaje2 = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		empresa.registrarViaje(viaje2);
		empresa.registrarViaje(viaje);

		empresa.registrarViaje(viaje2);
		
		Integer numeroViaje = 1;
		Integer numeroViaje2 = 2;

		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		empresa.registrarTicketPasajero(numeroViaje, pasajero);
		

		Integer dni2 = 1222;
		String apellido2 = "lopez";
		Pasajero pasajero2 = new Pasajero(dni2, apellido2);
		empresa.registrarTicketPasajero(numeroViaje, pasajero2);
		
		Integer dni3 = 5222;
		String apellido3 = "pepe";
		Pasajero pasajero3 = new Pasajero(dni3, apellido3);
		empresa.registrarTicketPasajero(numeroViaje2, pasajero3);
		
		Integer dni4 = 8222;
		String apellido4 = "Volt";
		Pasajero pasajero4 = new Pasajero(dni4, apellido4);
		empresa.registrarTicketPasajero(numeroViaje, pasajero4);
		
		
		TreeSet<Pasajero> pasajeros = empresa.obtenerListaPasajeroOrdenadosPorDNIDescendiente(numeroViaje);
		
		assertEquals(3, pasajeros.size(), 0.1);
		assertEquals(pasajeros.first(),pasajero2);
		assertEquals(pasajeros.last(),pasajero4);
		
	}

	@Test
	public void queSePuedaObtenerElTotalDeCargasTransportada() throws TipoTicketInvalidoException, CapacidadExcedidaException {
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Integer cantidadPasajerosMaximos = 50;
		Double cargaMaxima = 50.00;
		MedioTransporte medioTransporte = new TransportePasajero(Patente, cantidadPasajerosMaximos);
		MedioTransporte medioTransporte2 = new TransporteCarga(Patente, cargaMaxima);
		MedioTransporte medioTransporte3 = new TransporteMixto(Patente, cantidadPasajerosMaximos, cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		Viaje viaje2 = new Viaje(salida, llegada, origen, destino, medioTransporte2);
		
		Viaje viaje3 = new Viaje(salida, llegada, origen, destino, medioTransporte3);

		empresa.registrarViaje(viaje);

		empresa.registrarViaje(viaje2);
		empresa.registrarViaje(viaje3);

		//empresa.registrarViaje(viaje2);
		
		Integer numeroViaje = 1;
		Integer numeroViaje2 = 2;
		Integer numeroViaje3 = 3;
		

		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		empresa.registrarTicketPasajero(numeroViaje, pasajero);
		

		Integer dni2 = 1222;
		String apellido2 = "lopez";
		//Pasajero pasajero2 = new Pasajero(dni2, apellido2);
		Carga carga1 = new Carga(1, 10.00);
		empresa.registrarTicketcarga(numeroViaje2, carga1);
		
		Integer dni3 = 5222;
		String apellido3 = "pepe";
		Pasajero pasajero3 = new Pasajero(dni3, apellido3);
		Carga carga2 = new Carga(1, 15.00);
		empresa.registrarTicketMixto(numeroViaje3, pasajero3, carga2);
		
		Double obtenido = empresa.obtenerCantidadTotalDeCargaTransportada();
		
		assertEquals(25.00, obtenido, 0.1);
		
		
		

	}
	
}
