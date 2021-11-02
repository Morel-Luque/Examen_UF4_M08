import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Aquesta classe es la "principal" (tot i que no es l'executable) perque es la que conte com funciona el joc,
 * quines coses es poden realitzar com per exemple: iniciar el joc, afegir participants, mostrar el resultat final...
 * @author Morel Luque Martínez
 * @version 0.2
 *
 */

public class Game {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private final Scanner sc = new Scanner(System.in);

    private ConfigGame config;
    private Menu menu;
    private Vehicle[] participants;
    List<ResultatsCursa> resultatsCursa = new ArrayList<>();
    ResultatsCursa resul = new ResultatsCursa();
    /**
     *  definició de les puntuacions als primers 3 classificats
     */

    private int[] puntuacions = {10,8,5};

    /**
     * Classe que emmagatzemara quant temps ha fet cada vehicle
     */
    class ResultatsCursa {
        double temps;
        Vehicle vehicle;
    }

    /**
     * Constructor de la classe Game
     */
    public Game() {
        config = new ConfigGame();
        menu = new Menu(this,config);
    }

    /**
     * Funcio que fa iniciar el joc i aparegui el menu principal
     */
    public void start() {
        menu.menuPrincipal();
    }

    /**
     * Funcio que inicia la partida
     * TODO: 02/11/2021 refactoritzar i modular el mètode play
     * @param tipus El tipus de participant que jugara, pot ser un Cotxe o una Bicicleta
     */
    public void play(int tipus)  {

        System.out.println(config);

        /**
         * crear participant usuari i resta de participants
         */
        participants = new Vehicle[config.getNumRunners()];
        addParticipants(tipus);

        /**
         * comença la cursa
         */
        System.out.println("Pilots a la graella de sortida...");
        for(int i=0; i<participants.length; i++) {
            System.out.printf("%s ",participants[i].getPilot().getNom());
        }
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println();
        /**
         * Recorregut per tots els circuits
         */
        for(int i=0; i<config.getNumTracks(); i++) {
            System.out.println("Prem un tecla per iniciar el circuit " + i);
            sc.nextLine();
            System.out.println(ANSI_YELLOW + "Circuit " + i + ANSI_RESET);
            /**
             * simulació del temps que ha fet cada vehicle
             */
            for (int t = 0; t < config.getNumRunners(); t++) {
                resultatsCursa.get(t).temps = (Math.random() * 10000 + 3000);
            }

            /**
             * ordenar classificació
             */
            resultatsCursa.sort((o1, o2) -> (int) (o1.temps - o2.temps));

            /**
             * donar punts
             */
            for(int p=0; p < resultatsCursa.size() && p<3; p++) {
                resultatsCursa.get(p).vehicle.getPilot().addPunts(puntuacions[p]);
                double t = resultatsCursa.get(p).temps;
                String nom = resultatsCursa.get(p).vehicle.getPilot().getNom();
                if(resultatsCursa.get(p).vehicle.getPilot().getNom().equals(config.getUserName())) System.out.printf(ANSI_BLUE);
                System.out.printf("%s %.2f +%d\n",nom,t,puntuacions[p]);
                System.out.printf(ANSI_RESET);
            }
            System.out.println("----------------------");
        }

    }

    /**
     * Funcio que afegeix participants al joc
     * TODO: 02/11/2021 refactoritzar el codi repetit
     * @param tipus El tipus de participant que s'afegira
     */
    private void addParticipants(int tipus) {

        switch (tipus) {
            case 1:
                participants[0] = new Bicicleta(60);
                setParticipants();
                break;
            case 2:
                participants[0] = new Cotxe(300);
                setParticipants();
                break;
            case 3:
                System.out.println("Aquesta opció no està implementada");
                break;
            case 4:
                System.out.println("Aquesta opció no està implementada");
                break;
        }
    }

    /**
     * Funcio que mostra els resultats finals
     */
    public void finalResults() {
        /**
         * ordenar punts
         */
        resultatsCursa.sort((o1, o2) -> (int) (o2.vehicle.getPilot().getPunts() - o1.vehicle.getPilot().getPunts()));
        for(int i = 0; i < resultatsCursa.size(); i++) {
            ResultatsCursa r = resultatsCursa.get(i);
            if(r.vehicle.getPilot().getNom().equals(config.getUserName())) System.out.printf(ANSI_BLUE);
            System.out.printf("| %s\t| %d\t |\n",r.vehicle.getPilot().getNom(),r.vehicle.getPilot().getPunts());
            System.out.printf(ANSI_RESET);
        }
        System.out.println();
    }

    /**
     * Funcio que estableix els resultats a 0 per tal d'iniciar una partida nova
     */
    public void initResults() {
        resultatsCursa.clear();
    }

    /**
     * Funcio que assigna als participants amb el seu vehicle corresponent per mostrar els resultats posteriorment
     */
    private void setParticipants() {
        participants[0].setPilot(new Pilot(config.getUserName()));
        resul.vehicle = participants[0];
        resultatsCursa.add(resul);
        for(int i=1; i<config.getNumRunners(); i++) {
            participants[i] = new Bicicleta(60);
            participants[i].setPilot(new Pilot("player-" + i));
            resul = new ResultatsCursa();
            resul.vehicle = participants[i];
            resultatsCursa.add(resul);
        }
    }

    /**
     * TODO: 02/11/2021 crear funcio per elimiar a l'ultim classificat
     */
    private void eliminarDarrerClassificat() {

    }


}
