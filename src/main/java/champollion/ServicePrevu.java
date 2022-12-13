package champollion;

public class ServicePrevu {

    protected int volumeCM;
    protected int volumeTP;
    protected int volumeTD;
    protected Enseignant prof;
    protected UE ue;

    public ServicePrevu(UE ue, Enseignant prof, int volumeCM, int volumeTP, int volumeTD) {
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
        this.ue = ue;
        this.prof = prof;
    }

    public void ajouterCM(int nbHeuresCM) {
        this.volumeCM = this.volumeCM + nbHeuresCM;
    }

    public void ajouterTD(int nbHeuresTD) {
        this.volumeTD = this.volumeTD + nbHeuresTD;
    }

    public void ajouterTP(int nbHeuresTP) {
        this.volumeTP = this.volumeTP + nbHeuresTP;
    }

    public int getVolCM() {
        return volumeCM;
    }

    public int getVolTD() {
        return volumeTD;
    }

    public int getVolTP() {
        return volumeTP;
    }

    public UE getUe() {
        return ue;
    }
    
    
}
