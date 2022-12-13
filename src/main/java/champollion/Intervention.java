package champollion;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Intervention {

    public Date debut;
    public int duree;
    public boolean annulee;
    private int heureDebut;
    protected HashMap<Intervention, Salle> mySalles = new HashMap<>();
    public HashMap<UE, Intervention> myUE = new HashMap<>();

    public Intervention(Date debut, int duree, boolean annulee, int heureDebut){
        this.debut = debut;
        this.duree = duree;
        this.annulee = annulee;
        this.heureDebut = heureDebut;
    }

    public void Reservation(Salle salle){
        mySalles.put(this, salle);
    }

    public HashMap<Intervention, Salle> getMySalles() {
        return mySalles;
    }

    public void concerne(UE ue){
        myUE.put(ue, this);
    }

    public HashMap<UE, Intervention> getMyInterventions() {
        return myUE;
    }


}
