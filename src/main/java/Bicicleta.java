/**
 * @author Morel Luque Martínez
 * @version 0.2
 *
 * Aquesta es la classe Bicicleta que hereda de la classe abstracta Vehicle
 * Només disposa del constructor que crida al constructor de la classe pare
 */
public class Bicicleta extends Vehicle{

    /**
     * Constructor de la classe Bicicleta
     * @param vel Velocitat maxima que pot aagafar l'objecte de bicicleta
     */
    public Bicicleta(int vel) {
        super(vel);
    }

    /**
     * @deprecated variable "tipus" en desús
     */
    //public Bicicleta(int vel, int tipus) {
    //    super(vel);
    //}
}
