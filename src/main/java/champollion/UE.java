package champollion;

import java.util.ArrayList;
import java.util.HashMap;

public class UE {
    private final String myIntitule;
    protected int heuresCM;
    protected int heuresTP;
    protected int heuresTD;

    public UE(String intitule, int heuresCM, int heuresTP, int heuresTD) {
        myIntitule = intitule;
        this.heuresCM = heuresCM;
        this.heuresTD = heuresTD;
        this.heuresTP = heuresTP;
    }

    public String getIntitule() {
        return myIntitule;
    }


}
