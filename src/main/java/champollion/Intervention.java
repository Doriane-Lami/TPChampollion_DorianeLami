package champollion;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Intervention {

    public Date debut;
    public int duree;
    public boolean annulee;
    private int heureDebut;
    public TypeIntervention type;
    protected HashMap<Intervention, Salle> mySalles = new HashMap<>();
    public HashMap<UE, Intervention> myUE = new HashMap<>();

    public Intervention(Date debut, int duree, boolean annulee, int heureDebut, TypeIntervention type, UE ue, Enseignant prof){
        this.debut = debut;
        this.duree = duree;
        this.annulee = annulee;
        this.heureDebut = heureDebut;
        this.type = type;
        
        myUE.put(ue, this);
        prof.myInterventions.add(this);
    }

    public void Reservation(Salle salle){
        mySalles.put(this, salle);
    }

    public HashMap<Intervention, Salle> getMySalles() {
        return mySalles;
    }

//    public void concerne(UE ue){
//        myUE.put(ue, this);
//    }
    
    public boolean appartenirUE(UE ue){
        return myUE.containsKey(ue);
    }
    
    
//    public boolean appartenirUE(UE ue){
//        if(myUE.containsKey(ue)){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }

    public HashMap<UE, Intervention> getMyUE() {
        return myUE;
    }
    
//    public void etreEffectuee(Enseignant prof){
//        prof.myInterventions.add(this);
//    }

    public int getDuree() {
        return duree;
    }

    public TypeIntervention getType() {
        return type;
    }
    
    

}
