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
            
            student.addPassedPracticeSubject(this);
        }
    }
    
    public void removePassedPracticeStudent(Student student){
        if(passedPracticeStudents.contains(student)){
//            passedExamStudents.remove(student);
            removePassedExamStudent(student);
            passedPracticeStudents.remove(student);
            student.removePassedPracticeSubject(this);  
        } 
    }

    public Student[] getPassedPracticeStudents(){
        return passedPracticeStudents.toArray(new Student[0]);
    }

    //    passedExamStudents
    public void addPassedExamStudent(Student student){
//         if(!(student == null) && !passedPracticeStudents.contains(student)){
        if( student != null && 
           !passedExamStudents.contains(student) &&
            passedPracticeStudents.contains(student)
        ){
            passedExamStudents.add(student);
            
            student.addPassedExamSubject(this);
        }
    }
    
    public void removePassedExamStudent(Student student){
        if(passedExamStudents.contains(student)){
            passedPracticeStudents.remove(student);
          
            student.removePassedPracticeSubject(this);  
        } 
    }

    public Student[] getPassedExamStudents(){
        return passedExamStudents.toArray(new Student[0]);
    }
    
    public String getShortInfo(){
        return String.format(
            "Subject{name=%s, appearanceSemestrNumber=%d",
            name,
            appearanceSemestrNumber
        );
    }
    
    @Override
    public String toString() {
        String baseInfo = getShortInfo().concat(", passedPracticeStudents={\n");
        
        Student[] passedPracticeStudents = getPassedPracticeStudents();
        StringBuilder stringBuilder = new StringBuilder(baseInfo);
        for(int i = 0; i < passedPracticeStudents.length; i++){
            stringBuilder.append(passedPracticeStudents[i].getShortInfo() + ' ');
        }
        stringBuilder.append(",\n passedExamStudents: ");
        Student[] passedExamStudents = getPassedExamStudents();
        for(int i = 0; i < passedExamStudents.length; i++){
            stringBuilder.append(passedExamStudents[i].getShortInfo() + ' ');
        }
        return stringBuilder.toString();
    }











}

