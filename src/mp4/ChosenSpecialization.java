package mp4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ChosenSpecialization {
    private String state;
    private String seialNumber;
    private LocalDate startDate,
            plannedEndDate;

    
//    private List<Student> students = new ArrayList<Student>();
    private Student student = null;
    private Specialization specialization = null;
    
    public ChosenSpecialization(String state, String seialNumber, LocalDate startDate, LocalDate plannedEndDate) {
        this.setState(state);
        this.setSeialNumber(seialNumber);
        this.setStartDate(startDate);
        this.setPlannedEndDate(plannedEndDate);
    }
    
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSeialNumber() {
        return seialNumber;
    }

    public void setSeialNumber(String seialNumber) {
        this.seialNumber = seialNumber;
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
    
    public void setStudent(Student newStudent) {
        if((getStudent() == null) && newStudent != null){
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
        return String.format(
            "ChosenSpecialization{state=%s, seialNumber=%s, startDate=%t, plannedEndDate=%t",
            state,
            seialNumber,
            startDate,
            plannedEndDate
        );
    }

    @Override
    public String toString() {
        return getShortInfo().concat(student.getShortInfo());
    }
}
