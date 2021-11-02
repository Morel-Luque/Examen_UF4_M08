/**
 * @author Morel Luque Martínez
 * @version 0.2
 *
 * Aquesta classe es l'encarregada de la configuracio del joc
 * S'encarrega de guardar i mostrar qui juga, quants corredors hi ha i quantes voltes es fan
 */
public class ConfigGame {
    private String username;
    private int numRunners;
    private int numTracks;

    /**
     * Funcio que retorna el numero de voltes que es faran
     * @return Numero de voltes que es faran
     */
    public int getNumTracks() {
        return numTracks;
    }

    /**
     * Funcio que assigna un nou valor a les voles que es faran
     * @param numTracks Nou valor que tindra el numero de voltes
     */
    public void setNumTracks(int numTracks) {
        this.numTracks = numTracks;
    }

    /**
     * Constructor de la classe ConfigGame
     */
    public ConfigGame() {
        numRunners = 5;
        numTracks = 3;
        username = "player";
    }

    /**
     * Funcio que assigna un nou username
     * @param username Username nou a assignar
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Funcio que retorna el username
     * @return Username actual
     */
    public String getUserName() {
        return username;
    }

    /**
     * Funcio que retorna el numero de corredors
     * @return Numero de corredors actual
     */
    public int getNumRunners() {
        return numRunners;
    }

    /**
     * Funcio que assigna un nou numero de corredors
     * @param numRunners Nou numero de corredors a assignar
     */
    public void setNumRunners(int numRunners) {
        this.numRunners = numRunners;
    }

    @Override
    /**
     * Funcio que mostra la configuracio del joc
     * sobrecàrrega que hereta de la classe Object
     */
    public String toString() {
        return "ConfigGame{" +
                "username='" + username + '\'' +
                ", numRunners=" + numRunners +
                ", numTracks=" + numTracks +
                '}';
    }
}
