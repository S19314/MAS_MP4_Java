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
    private List<Subject> passedPracticeSubjects = new ArrayList<Subject>();
    private List<Subject> passedExamSubjects = new ArrayList<Subject>();
    private FullTimeEducation fullTimeEducation = null;
    private PartTimeEducation partTimeEducation = null;
    
    /*
    public Student(String firstName, String secondName, String numerS, int currentSemestrNumber, int quantityITN) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.numerS = numerS;
        this.currentSemestrNumber = currentSemestrNumber;
        this.quantityITN = quantityITN;
    }
    */
    public Student(
            String firstName,
            String secondName, 
            String studentNumber, 
            int currentSemestrNumber, 
            int quantityITN
    ) throws Exception {
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
    
    public void addChosenSpecialization(ChosenSpecialization chosenSpecialization) throws Exception {
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
    
    public void addPassedPracticeSubject(Subject newSubject){
        if(!(newSubject == null) && !passedPracticeSubjects.contains(studentNumber)){
            passedPracticeSubjects.add(newSubject);
            
            newSubject.addPassedPracticeStudent(this);
        }
    }
    
    public void removePassedPracticeSubject(Subject passedPracticeSubject){
        if(this.passedPracticeSubjects.contains(passedPracticeSubject)){
            removePassedExamSubject(passedPracticeSubject);
            passedPracticeSubjects.remove(passedPracticeSubject);
            
            passedPracticeSubject.removePassedPracticeStudent(this);
        }
    }
    
    public Subject[] getPassedPracticeSubjects(){
        return passedPracticeSubjects.toArray(new Subject[0]);
    }
    
    public void addPassedExamSubject(Subject newSubject){
        if(!(newSubject == null) && 
            !passedExamSubjects.contains(newSubject) &&
            passedPracticeSubjects.contains(studentNumber)
        ){
            passedExamSubjects.add(newSubject);
            
            newSubject.addPassedExamStudent(this);
        }
    }
    
    public void removePassedExamSubject(Subject passedExamSubject){
        if(this.passedExamSubjects.contains(passedExamSubject)){
            passedExamSubjects.remove(passedExamSubject);
            
            passedExamSubject.removePassedExamStudent(this);
        }
    }
    
    public Subject[] getPassedExamSubjects(){
        return passedExamSubjects.toArray(new Subject[0]);
    }

    public FullTimeEducation getFullTimeEducation() {
        return fullTimeEducation;
    }

    public void setFullTimeEducation(FullTimeEducation fullTimeEducation) throws Exception {
        if(isPartTimeEducationNotSet()){
            if(getFullTimeEducation() != fullTimeEducation && fullTimeEducation != null){
                fullTimeEducation.addStudent(this);
                this.fullTimeEducation = fullTimeEducation;
            }
        }else{
            throw new Exception("FullTimeEducaion can't be set, because partTimeEducaion is already set.");
        }
    }
    
    public void removeFullTimeEducation(FullTimeEducation fullTimeEducation){
        if(isPartTimeEducationNotSet() && this.getFullTimeEducation() == fullTimeEducation){
            fullTimeEducation.removeStudent(this);
            this.fullTimeEducation = null;
        }
    }

    public boolean isFullTimeEducationNotSet(){
        return getFullTimeEducation() == null;
    }
    public boolean isPartTimeEducationNotSet(){
        return getPartTimeEducation() == null;
    }
    public PartTimeEducation getPartTimeEducation() {
        return partTimeEducation;
    }

    public void setPartTimeEducation(PartTimeEducation partTimeEducation) throws Exception {
        if(isFullTimeEducationNotSet()){
            if(getPartTimeEducation() != partTimeEducation && partTimeEducation != null){
                partTimeEducation.addStudent(this);
                this.partTimeEducation = partTimeEducation;
            }
        }else{
            throw new Exception("PartTimeEducationcan't be set, because partTimeEducaion is already set.");
        }
    }
    
    public void removePartTimeEducation(PartTimeEducation partTimeEducation){
        if(isFullTimeEducationNotSet() && this.getPartTimeEducation() == partTimeEducation){
            partTimeEducation.removeStudent(this);
            this.partTimeEducation = null;
        }
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
            stringBuilder.append(paymentsPerSemesters[i].getShortInfo() + ' ');
        }
        stringBuilder.append(",\n chosenSpecializations: ");
        ChosenSpecialization[] chosenSpecializations = getChosenSpecialization();
        for(int i = 0; i < chosenSpecializations.length; i++){
            stringBuilder.append(chosenSpecializations[i].getShortInfo() + ' ');
        }
        stringBuilder.append("\n");
        if(!isFullTimeEducationNotSet()){
            stringBuilder.append(getFullTimeEducation().getShortInfo());
            stringBuilder.append("\n");
        }
        if(!isPartTimeEducationNotSet()){
            stringBuilder.append(getPartTimeEducation().getShortInfo());
        }
        return stringBuilder.toString();
    }
}
