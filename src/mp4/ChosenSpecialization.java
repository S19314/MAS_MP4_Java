package mp4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ChosenSpecialization {
    private String state;
    private String serialNumber;
    private LocalDate startDate,
            plannedEndDate;

    public static int maxAllowedAmountITN = 5;
    

    private Student student = null;
    private Specialization specialization = null;
    
    
    public ChosenSpecialization(
            String state, 
            String serialNumber, 
            LocalDate startDate,
            LocalDate plannedEndDate,
            Student student,
            Specialization specialization
    ) throws Exception {
        
        if(student == null){
            throw new Exception("Student in ChosenSpecialization can't be null.");
        }
        if(specialization == null){
            throw new Exception("Specialization in ChosenSpecialization can't be null.");
        }
        this.setState(state);
        this.setSerialNumber(serialNumber);
        this.setStartDate(startDate);
        this.setPlannedEndDate(plannedEndDate);
        this.setStudent(student);
        this.setSpecialization(specialization);
    }
    
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getPlannedEndDate() {
        return plannedEndDate;
    }

    public void setPlannedEndDate(LocalDate plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }
    
    public Student getStudent() {
        return student;
    }
    
    public void setStudent(Student newStudent) throws Exception {
        if((getStudent() == null) && newStudent != null){
            if(newStudent.getQuantityITN() > maxAllowedAmountITN){
                throw new Exception("Student can't chose specialization till he or she has more then five ITNs.");
            }
            this.student = newStudent;
            
            newStudent.addChosenSpecialization(this);
        }
    }
    
    public void removeStudent(Student studentToRemove){
        if((getStudent() != null && this.getStudent() == studentToRemove)){
            this.student = null;
            
            studentToRemove.removeChosenSpecialization(this);
        }
    }
    
    public Specialization getSpecialization() {
        return specialization;
    }
    
    public void setSpecialization(Specialization newSpecialization) {
          if((getSpecialization() == null) && newSpecialization != null){
            this.specialization = newSpecialization;
            
            newSpecialization.addChosenSpecialization(this);
        }
    }
    
    public void removeSpecialization(Specialization specializationToRemove){
        if((getSpecialization() != null && this.getSpecialization() == specializationToRemove)){
            this.specialization = null;
            
            specializationToRemove.removeChosenSpecialization(this);
        }
    }

    public String getShortInfo() {
        return String.format("ChosenSpecialization{state=%s, seialNumber=%s, startDate=%s, plannedEndDate=%s",
            state,
            serialNumber,
            startDate.toString(),
            plannedEndDate.toString()
        );
    }

    @Override
    public String toString() {
        return getShortInfo()
                + " " + 
                getStudent().getShortInfo() 
                + ",  " + 
                getSpecialization().getShortInfo();
    }
}
