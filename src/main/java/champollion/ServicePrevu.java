package champollion;

public class ServicePrevu {

    protected int volumeCM;
    protected int volumeTP;
    protected int volumeTD;

    public ServicePrevu(int volumeCM, int volumeTP, int volumeTD) {
        this.volumeCM = 0;
        this.volumeTD = 0;
        this.volumeTP = 0;
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
}
