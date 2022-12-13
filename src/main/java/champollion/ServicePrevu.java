package champollion;

public class ServicePrevu {
	// TODO : implémenter cette classe
    protected int volumeCM;
    protected int volumeTP;
    protected int volumeTD;
    protected UE ue;
    protected Enseignant prof;

    public ServicePrevu(Enseignant prof, UE ue, int volumeCM, int volumeTP, int volumeTD){
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
        this.ue = ue;
        this.prof = prof;
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
}
