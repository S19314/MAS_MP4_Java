package mp4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Student {
    private String firstName;
    private String secondName;
    private String studentNumber; // UNIQUE !!!!!
    private int currentSemestrNumber;
    private int quantityITN;
    
    public final static int minimalCurrentSemestrNumber = 0;
    public final static int minimalQuantityITN = 0;
    public final static String variableNameNumerS = "NumberS";
    private Map<String, Set<String>> uniqueContainerMap = new HashMap<String, HashSet<String>>();
    
    /*
    public Student(String firstName, String secondName, String numerS, int currentSemestrNumber, int quantityITN) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.numerS = numerS;
        this.currentSemestrNumber = currentSemestrNumber;
        this.quantityITN = quantityITN;
    }
    */
    public Student(String firstName, String secondName, String numerS, int currentSemestrNumber, int quantityITN) throws Exception {
        this.setFirstName(firstName);
        this.setSecondName(secondName);
        this.setNumerS(numerS);
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

    public String getNumerS() {
        return studentNumber;
    }

    public void setNumerS(String numerS) {
        Set uniqueNumberS = new HashSet<String>()
        if(!uniqueContainerMap.containsKey(variableNameNumerS)){
            uniqueContainerMap.put(variableNameNumerS, );
        }
        this.studentNumber = numerS;
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
}
