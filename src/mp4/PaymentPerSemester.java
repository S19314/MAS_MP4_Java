package mp4;

public class PaymentPerSemester {
    private int serialNumber;
    private double amountOfPayment;

    private Student student = null;
    
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

    public Student getStudent() {
        return student;
    }
    
    public void setStudent(Student newStudent) {
        if((getStudent() == null) && newStudent != null){
            this.student = newStudent;
            
            newStudent.addPaymentPerSemester(this);
        }
    }
    
    public void removeStudent(Student studentToRemove){
        if((getStudent() != null && this.getStudent() == studentToRemove)){
            this.student = null;
            
            studentToRemove.removePaymentPerSemester(this);
        }
    }
    
}
