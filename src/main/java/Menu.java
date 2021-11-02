import java.util.Scanner;

/**
 * @author Morel Luque Martínez
 * @version 0.2
 *
 * Aquesta classe es l'encarregada de mostrar els Menus amb els quals interactuara l'usuari
 */

public class Menu {
    private Scanner in = new Scanner(System.in);
    private int opcio;
    ConfigGame configGame;
    Game game;

    /**
     * Constructor de la classe Menu
     * @param game El joc que s'inicia
     * @param config La configuracio del joc que s'inicia
     */
    public Menu(Game game, ConfigGame config) {
        opcio = -1;
        this.game = game;
        configGame = config;
    }

    /**
     * Funcio que mostra el menu principal quan entrem al joc
     */
    public void menuPrincipal() {
        do {
            System.out.println("1. Configuració : " + configGame);
            System.out.println("2. Jugar");
            System.out.println("3. Classificació General");
            System.out.println("0. Acabar");
            System.out.print("Entra una opció(0-3): ");
            opcio = in.nextInt();
            in.nextLine();
            switch (opcio) {
                case 1:
                    setConfig();
                    break;
                case 2:
                    play();
                    break;
                case 3:
                    System.out.println("Classificació...");
                    game.finalResults();
                    break;
                case 0:
                    System.out.println("Gràcies per jugar. Fins la propera!");
                    break;
                default:
                    System.out.println("ATENCIÓ!!! \nHa de ser un valor entre 0 i 3");

            }
        }while(opcio != 0);
    }

    /**
     * Funcio que mostrara i aplicara la configuracio que tindra la partida actual
     */
    public void setConfig() {
        System.out.println("Entra el teu nom: ");
        String n = in.nextLine();
        configGame.setUsername(n);
        System.out.println("Quants participants hi haurà al campionat? ");
        configGame.setNumRunners(in.nextInt());
        /**
         * per esborrar el salt de línia
         */
        in.nextLine();
        System.out.println("Quants circuits tindrà el campionat?");
        configGame.setNumTracks(in.nextInt());
        in.nextLine();
    }

    /**
     * Funcio que ens permetra escollir amb el vehicle que farem el campionat
     */
    public void play() {
        System.out.println("Amb quin vehicle vols fer el campionat?");
        System.out.println("1) Bicicletes");
        System.out.println("2) Cotxes");
        System.out.println("3) Camions");
        System.out.println("4) Motos");
        int op = in.nextInt();
        in.nextLine();
        game.initResults();
        game.play(op);
    }

}
