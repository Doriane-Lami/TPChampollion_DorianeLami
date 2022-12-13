package champollion;

import static java.lang.Math.round;

import java.util.LinkedList;
import java.util.TreeSet;

public class Enseignant extends Personne {

    protected final LinkedList<Intervention> myInterventions = new LinkedList<>();
    protected final LinkedList<ServicePrevu> myServicesPrevus = new LinkedList<>();

    protected TreeSet<UE> lesUEsEnseignes = new TreeSet<>();

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
     */
    public int heuresPrevues() {

        double total = 0;
        for (ServicePrevu service : myServicesPrevus) {
            total = total + service.getVolCM() * 1.5 + service.getVolTD() + service.getVolTP() * 0.75;
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
     */
    public int heuresPrevuesPourUE(UE ue) {
        if (ue == null) {
            throw new IllegalArgumentException("Il n'y a pas d'ue ");
        } else {
            double total = 0;
            for (ServicePrevu service : myServicesPrevus) {
                if (service.getUe().equals(ue)) {
                    total = total + service.getVolCM() * 1.5 + service.getVolTD() + service.getVolTP() * 0.75;
                }
            }
            return (int) round(total);
        }

    }


    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue       l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {

        ServicePrevu enseignement = new ServicePrevu(ue, this, volumeCM, volumeTD, volumeTP);
        this.myServicesPrevus.add(enseignement);
    }

    public void ajouterIntervention(Intervention inter) {
        if (inter == null) {
            throw new IllegalArgumentException("Il n'y a pas d'intervention");
        } else {
            System.out.println("L'intervention a été ajoutée à sa création");
        }
    }

    public int resteAPlanifier(UE ue, TypeIntervention type) {
        int prevu = 0;
        int planifie = 0;

        for (ServicePrevu service : myServicesPrevus) {
            if (service.getUe() == ue) {
                if (type.equals(TypeIntervention.CM)) {
                    prevu = prevu + service.getVolCM();
                }
                if (type.equals(TypeIntervention.TD)) {
                    prevu = prevu + service.getVolTD();
                }
                if (type.equals(TypeIntervention.TP)) {
                    prevu = prevu + service.getVolTP();
                }
            }
        }
        for (Intervention inter : myInterventions) {
            if (inter.getType() == type && inter.appartenirUE(ue)) {
                planifie = planifie + inter.getDuree();
            }
        }
        return prevu - planifie;
    }


}