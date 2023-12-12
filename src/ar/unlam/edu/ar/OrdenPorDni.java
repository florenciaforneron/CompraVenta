package ar.unlam.edu.ar;

import java.util.Comparator;

public class OrdenPorDni implements Comparator<Pasajero>{

	@Override
	public int compare(Pasajero o1, Pasajero o2) {
		
		return o1.getDni().compareTo(o2.getDni());
	}

}
