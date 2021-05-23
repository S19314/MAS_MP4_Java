package mp4;

public class PaymentPerSemester {
    private int serialNumber;
    private double amountOfPayment;

    public PaymentPerSemester(int serialNumber, double amountOfPayment) {
        this.setSerialNumber(serialNumber);
        this.setAmountOfPayment(amountOfPayment);
    }
    
    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getAmountOfPayment() {
        return amountOfPayment;
    }

    public void setAmountOfPayment(double amountOfPayment) {
        this.amountOfPayment = amountOfPayment;
    }
}
