package mp4;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String name;
    private int appearanceSemestrNumber; 
    
    private final static int minimalAppearanceSemestrNumber = 0; 

    
    
    private List<Student> passedPracticeStudents = new ArrayList<Student>();
    private List<Student> passedExamStudents = new ArrayList<Student>();
    
    public Subject(String name, int appearanceSemestrNumber) throws Exception {
        this.setName(name);
        this.setAppearanceSemestrNumber(appearanceSemestrNumber);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppearanceSemestrNumber() {
        return appearanceSemestrNumber;
    }

    public void setAppearanceSemestrNumber(int appearanceSemestrNumber) throws Exception {
        if(appearanceSemestrNumber < minimalAppearanceSemestrNumber){
            throw new Exception(String.format(
                "AppearanceSemestrNumber for Subject should be more then %d",
                minimalAppearanceSemestrNumber
            ));                
        }
        
        this.appearanceSemestrNumber = appearanceSemestrNumber;
    }


    public void addPassedPracticeStudent(Student student){
        if(!(student == null) && !passedPracticeStudents.contains(student)){
            passedPracticeStudents.add(student);
            
            student.setSubject(this);
        }
    }
    
    public void removePassedPracticeStudent(Student student){
        if(passedPracticeStudents.contains(student)){
            passedPracticeStudents.remove(student);
            
            student.removeSubject(this);
        }
    }
//    passedPracticeStudents
    public Student[] getPassedPracticeStudents(){
        return passedPracticeStudents.toArray(new Student[0]);
    }











}

