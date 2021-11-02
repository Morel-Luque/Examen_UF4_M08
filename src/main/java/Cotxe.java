/**
 * @author Morel Luque Martínez
 * @version 0.2
 *
 * Aquesta es la classe Cotxe que hereda de la classe abstracta Vehicle
 * Només disposa del constructor que crida al constructor de la classe pare
 */

public class Cotxe extends Vehicle {
	private String Marca;
	private String Model;

	/**
	 * Constructor de la classe Cotxe
	 * @param vel Velocitat màxima que agafa el Cotxe
	 */
	public Cotxe(int vel) {
		super(vel);
	}

	/**
	 * Funcio que retorna la marca del cotxe
	 * @return Marca que és el cotxe
	 */
	public String getMarca() {
		return Marca;
	}

	/**
	 * Funcio que assigna una nova marca al cotxe
	 * @param marca Nova marca a assignar
	 */
	public void setMarca(String marca) {
		Marca = marca;
	}

	/**
	 * Funcio que retorna el model del cotxe
	 * @return Model del cotxe actualment
	 */
	public String getModel() {
		return Model;
	}

	/**
	 * Funcio que assigna un nou model al cotxe
	 * @param model Nou model a assignar
	 */
	public void setModel(String model) {
		Model = model;
	}

}