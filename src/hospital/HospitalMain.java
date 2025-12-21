package hospital;

public class HospitalMain {

    public void start() {

        Entity n =  new Nurse(1, "BB");
        ((ECG) n).analyze();

    }
}
