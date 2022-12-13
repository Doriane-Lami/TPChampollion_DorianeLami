package champollion;

import static java.lang.Math.round;
import java.util.LinkedList;
import java.util.TreeSet;

public class Enseignant extends Personne {

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML
    protected TreeSet<UE> lesUEsEnseignes = new TreeSet<>();
    protected final LinkedList<Intervention> myInterventions = new LinkedList<>();
    private final LinkedList<ServicePrevu> myServicesPrevus = new LinkedList<>();

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures
     * équivalent TD" Pour le calcul : 1 heure de cours magistral vaut 1,5 h
     * "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut
     * 0,75h "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet
     * enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {

        double total = 0;
        for (Intervention inter : myInterventions) {
            if (inter.getClass().equals("CM")) {
                total = total + inter.getDuree() * 1.5;
            } else if (inter.getClass().equals("TD")) {
                total = total + inter.getDuree();
            } else if (inter.getClass().equals("TP")) {
                total = total + inter.getDuree() * 0.75;
            }
        }
        return (int) round(total);
    }

    public boolean enSousService() {
        if (this.heuresPrevues() < 192) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE
     * spécifiée en "heures équivalent TD" Pour le calcul : 1 heure de cours
     * magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent
     * TD" 1 heure de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet
     * enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        if (ue == null) {
            throw new IllegalArgumentException("Il n'y a pas d'ue ");
        } else {
            double total = 0;
            for (Intervention inter : myInterventions) {
                if (inter.appartenirUE(ue)) {
                    if (inter.getClass().equals("CM")) {
                        total = total + inter.getDuree() * 1.5;
                    } else if (inter.getClass().equals("TD")) {
                        total = total + inter.getDuree();
                    } else if (inter.getClass().equals("TP")) {
                        total = total + inter.getDuree() * 0.75;
                    }
                }
            }
            return (int) round(total);
        }
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        ServicePrevu enseignement = new ServicePrevu(ue, this, volumeCM, volumeTD, volumeTP);
        this.myServicesPrevus.add(enseignement);
    }

    public void ajouterIntervention(Intervention inter) {
        if (inter == null) {
            throw new IllegalArgumentException("Il n'y a pas d'intervention");
        } else {
            this.myInterventions.add(inter);
        }
    }

    public int resteAPlanifier(UE ue, TypeIntervention type) {
        int heuresCM = 0;
        int heuresTD = 0;
        int heuresTP = 0;
        int resteCM = 0;
        int resteTD = 0;
        int resteTP = 0;

        for (Intervention inter : myInterventions) {
            if (inter.appartenirUE(ue)) {
                if (inter.getType().equals("CM")) {
                    heuresCM = inter.getDuree();
                }
                if (inter.getType().equals("TD")) {
                    heuresTD = inter.getDuree();
                }
                if (inter.getType().equals("TP")) {
                    heuresTP = inter.getDuree();
                }
            }
        }
        for (ServicePrevu service : myServicesPrevus) {
            if (service.getUe() == ue) {
                resteCM = service.getVolCM() - heuresCM;
                resteTD = service.getVolTD() - heuresTD;
                resteTP = service.getVolTP() - heuresTP;
            }
        }
        return resteCM + resteTD + resteTP;
    }

}
