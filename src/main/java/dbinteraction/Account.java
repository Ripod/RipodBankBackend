package dbinteraction;

public class Account {
    private String accNumber;
    private float accSum;

    public Account(String accNumber, float accSum) {
        this.accNumber = accNumber;
        this.accSum = accSum;
    }


    public String getAccNumber() {
        return accNumber;
    }

    public float getAccSum() {
        return accSum;
    }
}
