package mp4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
    private String firstName;
    private String secondName;
    private String studentNumber;
    private int currentSemestrNumber;
    private int quantityITN;
    
    public final static int minimalCurrentSemestrNumber = 0;
    public final static int minimalQuantityITN = 0;
    public final static String variableNameStudentNumer = "NumberS";
    private static Map<String, Set<String>> uniqueContainerMap = new HashMap<String, Set<String>>();
    
    private List<PaymentPerSemester> payments = new ArrayList<PaymentPerSemester>();
    private List<ChosenSpecialization> specializations = new ArrayList<ChosenSpecialization>();
    /*
    public Student(String firstName, String secondName, String numerS, int currentSemestrNumber, int quantityITN) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.numerS = numerS;
        this.currentSemestrNumber = currentSemestrNumber;
        this.quantityITN = quantityITN;
    }
    */
    public Student(String firstName, String secondName, String studentNumber, int currentSemestrNumber, int quantityITN) throws Exception {
        this.setFirstName(firstName);
        this.setSecondName(secondName);
        this.setStudentNumber(studentNumber);
        this.setCurrentSemestrNumber(currentSemestrNumber);
        this.setQuantityITN(quantityITN);
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) throws Exception {
        Set<String> uniqueStudentNumberSet;
        if(uniqueContainerMap.containsKey(variableNameStudentNumer)){
            uniqueStudentNumberSet = uniqueContainerMap.get(variableNameStudentNumer);
            if(uniqueStudentNumberSet.contains(studentNumber)){
                throw new Exception(String.format("Student should have an unique number. %s is already exist.", studentNumber));
            }
            uniqueStudentNumberSet.remove(getStudentNumber());
            uniqueStudentNumberSet.add(studentNumber);
            uniqueContainerMap.replace(variableNameStudentNumer, uniqueStudentNumberSet);
        }else{
            uniqueStudentNumberSet = new HashSet<String>();
            uniqueStudentNumberSet.add(studentNumber);
            uniqueContainerMap.put(variableNameStudentNumer, uniqueStudentNumberSet);
        }
        this.studentNumber = studentNumber;
    }

    public int getCurrentSemestrNumber() {
        return currentSemestrNumber;
    }

    public void setCurrentSemestrNumber(int currentSemestrNumber) throws Exception {
        if(currentSemestrNumber < minimalCurrentSemestrNumber){
            throw new Exception(String.format("Current semestr can't be less then %d", minimalCurrentSemestrNumber));
        }
        this.currentSemestrNumber = currentSemestrNumber;
    }

    public void incrementByOneCurrentSemestrNumber() throws Exception {
        int semestrNumber = getCurrentSemestrNumber();
        semestrNumber++;
        setCurrentSemestrNumber(semestrNumber);
    }
    
    public int getQuantityITN() {
        return quantityITN;
    }

    public void setQuantityITN(int quantityITN) throws Exception {
        if(quantityITN < minimalQuantityITN){
            throw new Exception(String.format("Quantity ITNs can't be less then %d", minimalQuantityITN));
        }
        this.quantityITN = quantityITN;
    }    

    public void addPaymentPerSemester(PaymentPerSemester paymentPerSemester){
        if(!(paymentPerSemester == null) && !payments.contains(paymentPerSemester)){
            payments.add(paymentPerSemester);
            
            paymentPerSemester.setStudent(this);
        }
    }
    
    public void removePaymentPerSemester(PaymentPerSemester paymentPerSemester){
        if(payments.contains(paymentPerSemester)){
            payments.remove(paymentPerSemester);
            
            paymentPerSemester.removeStudent(this);
        }
    }
    
    public PaymentPerSemester[] getPaymentPerSemesters(){
        return payments.toArray(new PaymentPerSemester[0]);
    }
    
    public void addChosenSpecialization(ChosenSpecialization chosenSpecialization){
        if(!(chosenSpecialization == null) && !specializations.contains(chosenSpecialization)){
            specializations.add(chosenSpecialization);
            
            chosenSpecialization.setStudent(this);
        }
    }
    
    public void removeChosenSpecialization(ChosenSpecialization chosenSpecialization){
        if(specializations.contains(chosenSpecialization)){
            specializations.remove(chosenSpecialization);
            
            chosenSpecialization.removeStudent(this);
        }
    }
    
    public ChosenSpecialization[] getChosenSpecialization(){
        return specializations.toArray(new ChosenSpecialization[0]);
    }
    
    public String getShortInfo(){
        return String.format(
            "Student:{firstName=%s, secondName=%s, studentNumber=%s, currentSemestrNumber=%d, quantityITN=%d",
            firstName,
            secondName, 
            studentNumber,
            currentSemestrNumber,
            quantityITN,
            payments 
        );
    }

    @Override
    public String toString() {
        String baseInfo = getShortInfo().concat(", paymentsPerSemestrs={\n");
        
        PaymentPerSemester[] paymentsPerSemesters = getPaymentPerSemesters();
        StringBuilder stringBuilder = new StringBuilder(baseInfo);
        for(int i = 0; i < paymentsPerSemesters.length; i++){
            stringBuilder.append(paymentsPerSemesters[i].getShortInfo());
        }
        return stringBuilder.toString();
    }
    
    
}
