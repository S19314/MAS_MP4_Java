/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp4;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author admin
 */
public class MP4 {

    /**
     * @param args the command line arguments
     */
    
    public static Student student1 = null,
            student2 = null;
    public static void main(String[] args) {
        ordered();
        bag();
        subset();
        xor();
    }
    
    
    public static void ordered(){
        System.out.println("ordered");
        try {
            student1 = new Student("Ala", "Kota", "s13", 3, 0);
            student2 = new Student("Tomasz", "Mokira", "s3", 5, 1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
        
            Student student3 = new Student("COPYTomasz", "COPYMokira", "s3", 5, 1);
        } catch (Exception e) {
            System.out.println("Execption about not unique student");
            System.err.println(e.getMessage());
        }
        
        PaymentPerSemester paymentPerSemester1 = new PaymentPerSemester(1, 300),
                paymentPerSemester2 = new PaymentPerSemester(2, 400);
        student1.addPaymentPerSemester(paymentPerSemester1);
        student1.addPaymentPerSemester(paymentPerSemester2);
        
        System.out.println("Student1: " + student1);
        System.out.println("Student2: " + student2);
        System.out.println("Payment1: " + paymentPerSemester1);
        System.out.println("Payment2: " + paymentPerSemester2);
        System.out.println("");
    }
    
    
    
    


/*
B. Programowanie systemowe i sieciowe

E. Multimedia

E_3D. Multimedia – Animacja 3D
*/
    
    public static void bag() {
        System.out.println("bag");
        Specialization specialization1 = null, specialization2 = null;
        try {
            specialization1 = new Specialization("A_BD", "Bazy danych", 600);
            specialization2 = new Specialization("A_IO", "Inżynieria oprogramowania i baz danych", 414);
            System.out.println(specialization1);
            System.out.println(specialization2);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            Specialization specialization3 = new Specialization(
                    "D", 
                    "Inteligentne systemy przetwarzania danych",
                    314
            );
        } catch (Exception e) {
            System.err.println("Should be Exception about less days.");
            System.err.println(e.getMessage());
        }
        
        ChosenSpecialization chosenSpecialization1 = null,
                chosenSpecialization2 = null;
        try {
            chosenSpecialization1 = new ChosenSpecialization(
                    "Confirmed",
                    "VS15",
                    LocalDate.now(), 
                    LocalDate.of(2023, Month.MARCH, 15),
                    student1,
                    specialization2
            );
        
            chosenSpecialization2 = new ChosenSpecialization(
                    "In process",
                    "KL15",
                    LocalDate.now(), 
                    LocalDate.of(2023, Month.JULY, 15),
                    student1,
                    specialization1
            );
        
            System.out.println(chosenSpecialization1);
            System.out.println(chosenSpecialization2);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("");
    }
    
    public static void subset() {
        System.out.println("subset");
        Subject subject1 = null,
                subject2 = null,
                subject3 = null;
        
        try {
                subject1 = new Subject("MAS", 6);
                subject2 = new Subject("TAK", 1);
                subject3 = new Subject("PPJ", 1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Shouldn't change");
        System.out.println("Subject 1 before:");
        System.out.println(subject1);
        subject1.addPassedExamStudent(student1);
        System.out.println("Subject 1 after:");
        System.out.println(subject1);
        
        
        subject1.addPassedPracticeStudent(student1);
        subject1.addPassedExamStudent(student1);
        System.out.println("Subject 1 after:");
        System.out.println(subject1);
        System.out.println("");
    }
    
    public static void xor(){
        System.out.println("XOR");
        FullTimeEducation fullTimeEducation = null;
        try {
            fullTimeEducation = new FullTimeEducation(
                    "FUllTimePlan", 
                    LocalDate.of(2021, Month.OCTOBER, 12),
                    LocalDate.of(2022, Month.MARCH, 2)
            );
            student1.setFullTimeEducation(fullTimeEducation);
            student2.setFullTimeEducation(fullTimeEducation);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        PartTimeEducation partTimeEducation = null;
        try {
            partTimeEducation = new PartTimeEducation(
                    "FUllTimePlan", 
                    LocalDate.of(2021, Month.OCTOBER, 12),
                    LocalDate.of(2022, Month.MARCH, 2)
            );
            student1.setPartTimeEducation(partTimeEducation);
        } catch (Exception e) {
            System.err.println("Should be an exception about no oportunity dor setting PartTimeEducation while FullTimeEducation.");
            System.err.println(e.getMessage());
        }
        System.out.println(partTimeEducation);
        System.out.println(fullTimeEducation);
        
        Student student5 = null; 
        try {
            student5 = new Student("A", "A", "s19000", 4, 0);
        } catch (Exception e) {
//            System.err.println(e.getMessage());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            student5.setPartTimeEducation(partTimeEducation);
            student5.setFullTimeEducation(fullTimeEducation);
        } catch (Exception e) {
//            System.err.println("Should be an exception about no oportunity dor setting FullTimeEducation while PartTimeEducation.");
//            System.err.println(e.getMessage());
            System.out.println("Should be an exception about no oportunity dor setting FullTimeEducation while PartTimeEducation.");
            System.out.println(e.getMessage());
        }
        System.out.println("Student toString():");
        System.out.println(student5);
        System.out.println("Student partTimeEducation():");
        System.out.println(partTimeEducation);
        System.out.println("Student fullTimeEducation():");
        System.out.println(fullTimeEducation);
    }
    
}
