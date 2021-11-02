/**
 * @author Morel Luque Martínez
 * @version 0.2
 *
 * Aquesta classe es la pare de la qual hereten Cotxe i Bicicleta
 */

public abstract class Vehicle {
	private int velocitatMAX;
	private Pilot pilot;

	/**
	 * Constructor que s'utilitzará a les classes filles
	 * @param vel Velocitat maxima del Vehicle
	 */
	public Vehicle(int vel) {
		velocitatMAX = vel;
	}

	/**
	 * @deprecated variable "tipus" en desús
	 */
	//public Vehicle(int vel, int tipus) {
	//	velocitatMAX = vel;
	//}

	/**
	 * Funcio que ens retorna el Pilot del Vehicle
	 * @return Pilot del Vehicle
	 */
	public Pilot getPilot() {
		return pilot;
	}

	/**
	 * Funcio que assigna un nou Pilot al Vehicle
	 * @param pilot Pilot a assignar
	 */
	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	/**
	 * Funcio que ens retorna la velocitat maxima del Vehicle
	 * @return Velocitat maxima del vehicle
	 */
	public int getVelocitatMAX() {
		return velocitatMAX;
	}

	/**
	 * Funcio que assigna una nova velocitat maxima la Vehicle
	 * @param velocitatMAX Nova velocitat maxima a assignar
	 */
	public void setVelocitatMAX(int velocitatMAX) {
		this.velocitatMAX = velocitatMAX;
	}
}
