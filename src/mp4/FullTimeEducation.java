/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author admin
 */
public class FullTimeEducation {
    private  String lessonPlan;
    private LocalDate startExamDate, 
            endExamDate;

    private List<Student> students = new ArrayList<Student>();
    
    public FullTimeEducation(String lessonPlan, LocalDate startExamDate, LocalDate endExamDate) {
        this.setLessonPlan(lessonPlan);
        this.setStartExamDate(startExamDate);
        this.setEndExamDate(endExamDate);
    }
    
    public String getLessonPlan() {
        return lessonPlan;
    }

    public void setLessonPlan(String lessonPlan) {
        this.lessonPlan = lessonPlan;
    }

    public LocalDate getStartExamDate() {
        return startExamDate;
    }

    public void setStartExamDate(LocalDate startExamDate) {
        this.startExamDate = startExamDate;
    }

    public LocalDate getEndExamDate() {
        return endExamDate;
    }

    public void setEndExamDate(LocalDate endExamDate) {
        this.endExamDate = endExamDate;
    }
    
    public void addStudent(Student student) throws Exception {
        if( student != null && !students.contains(student)){
            if(!student.isPartTimeEducationNotSet()){
                throw new Exception("FullTimeEducation can't be installed if PartTimeEducation is already set.");
            }
            students.add(student);
            student.setFullTimeEducation(this);
        }
    }
    
    public void removeStudent(Student student){
        if(students.contains(student)){
           students.remove(student);
          
           student.removeFullTimeEducation(this);  
        } 
    }

    public Student[] getStudents(){
        return students.toArray(new Student[0]);
    }
    
    public String getShortInfo(){
        return String.format(
            "FullTimeEducation{ lessonPlan=%s, startExamDate=%s, endExamDate=%s", 
            lessonPlan,
            startExamDate.toString(),
            endExamDate.toString()
        );
    }
    @Override
    public String toString() {
        Student[] students = getStudents();
        StringBuilder stringBuilder = new StringBuilder(getShortInfo().concat("\n Students:{"));
        for(int i = 0; i < students.length; i++){
            stringBuilder.append(students[i].getShortInfo() + ' ');
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
