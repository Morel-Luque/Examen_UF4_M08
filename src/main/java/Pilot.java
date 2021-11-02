import java.util.Date;

/**
 * Aquesta classe es la classe que crea els Pilots de cada Vehicle
 * @author Morel Luque Martínez
 * @version 0.2
 *
 */

public class Pilot {
	private String nom;
	private int nivell;
	private int punts;

	/**
	 * Constructor de la classe Pilot
	 * @param nom El nom del Pilot
	 */
	public Pilot(String nom) {
		this.nom = nom;
	}

	/**
	 * @deprecated ara tractem els punts de forma diferent
	 * @return el nombre de punts
	 */

	//public Pilot(String punts) {
	//	this.punts = punts;
	//}

	/**
	 * Funcio que ens retorna el nom del Pilot
	 * @return Nom del Pilot
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Funcio que ens retorna els punts que ha fet el Pilot
	 * @return Punts que ha fet el Pilot
	 */
	public int getPunts() {
		return punts;
	}

	/**
	 * Funcio que assignara al Pilot els punts que ha fet
	 * @param punts Punts a assignar que ha fet el Pilot
	 */
	public void setPunts(int punts) {
		this.punts = punts;
	}

	/**
	 * Funcio que afegira punts al punts que ja tenia un Pilot
	 * @param p Punts a afegir als punts actuals
	 */
	public void addPunts(int p) {
		punts += p;
	}

	@Override
	/**
	 * Funcio que mostra la informacio del Pilot
	 * sobrecàrrega que hereta de la classe Object
	 */
	public String toString() {
		return "Pilot{" +
				"nom='" + nom + '\'' +
				", punts=" + punts +
				'}';
	}
}
