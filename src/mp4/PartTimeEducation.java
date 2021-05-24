/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp4;

import java.time.LocalDate;

/**
 *
 * @author admin
 */
public class PartTimeEducation {
    private  String lessonPlan;
    private LocalDate startExamDate, 
            endExamDate;

    public PartTimeEducation(String lessonPlan, LocalDate startExamDate, LocalDate endExamDate) {
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
}
